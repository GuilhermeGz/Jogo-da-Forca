package br.edu.ifpe.jogo.ParteLogica;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jogo {

    int erros;
    int acertos;
    Random gerador = new Random();
    BancoDePalavras bd;
    int opcao;
    char[] letras;
    int[] marcasao;
    ArrayList<Character> letrasRepetidas;

     public BancoDePalavras getBd() {
        return bd;
    }

    public void setBd(BancoDePalavras bd) {
        this.bd = bd;
    }

    public char[] getLetras() {
        return letras;
    }

    public void setLetras(char[] letras) {
        this.letras = letras;
    }

    public int[] getMarcasao() {
        return marcasao;
    }

    public void setMarcasao(int[] marcasao) {
        this.marcasao = marcasao;
    }

    public ArrayList<Character> getLetrasRepetidas() {
        return letrasRepetidas;
    }

    public void setLetrasRepetidas(ArrayList<Character> letrasRepetidas) {
        this.letrasRepetidas = letrasRepetidas;
    }
    
    public int getErros() {
        return erros;
    }

    public void setErros(int erros) {
        this.erros = erros;
    }

    public int getAcertos() {
        return acertos;
    }

    public void setAcertos(int acertos) {
        this.acertos = acertos;
    }

    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }

    public Jogo() {
        bd = new BancoDePalavras();
    }

    public void inicializarJogo() {
        Scanner sc = new Scanner(System.in);
        do {
            int posicao = gerador.nextInt(bd.getPalavras().size());
            String palavra = bd.getPalavras().get(posicao);
            letras = palavra.toCharArray();
            marcasao = new int[letras.length];
            letrasRepetidas = new ArrayList<Character>();

            System.out.println("1 - Jogar\n2 - Adicionar palavra\n3 - Remover palavra"
                    + "\n4 - Mostrar lista de palvras\n5 - Sair do jogo");

            setOpcao(sc.nextInt());

            if (getOpcao() == 1) {
                boolean result;
                erros = 0;
                acertos = 0;

                do {
                    System.out.println(criarCampo(letras,marcasao));
                    System.out.println("\nEscolha uma letra");
                    System.out.println("Erros :" + getErros());
                    char letra = sc.next().toUpperCase().charAt(0);
                    result = verificarLetraRepetida(letra);

                } while (result == true);
                System.out.println(verificarRsultadoDaPartida(acertos));

            } else if (getOpcao() == 2) {
                System.out.println("Digite a palavra");
                System.out.println(bd.adicionarPalavra(sc.next()));
            } else if (getOpcao() == 3) {
                System.out.println("Digite a palavra");
                bd.removerPalavra(sc.next());
            } else if (getOpcao() == 4) {
                System.out.println(bd.mostrarLista());
            } else if (getOpcao() != 5) {
                System.out.println("\nValor inapropriadoz\n");
            }

        } while (getOpcao() != 5);
    }

    public String criarCampo(char[] lista, int[] marcador) {
        String campo = new String();
        for (int i = 0; i < lista.length; i++) {
            if (marcador[i] == 1) {
                campo += lista[i] + " ";
            } else {
                campo += "_ ";
            }
        }
        return campo;
    }

    public boolean verificarLetraRepetida(char pl) {
        if (letrasRepetidas.contains(pl)) {
            return true;
        }
        letrasRepetidas.add(pl);
        return verificarAcerto(pl);
    }

    public boolean verificarAcerto(char letra) {
        boolean cont = false;
        for (int i = 0; i < letras.length; i++) {
            if (letra == letras[i]) {
                acertos++;
                marcasao[i] = 1;
                cont = true;
            }
        }
        if(cont != true){
        erros++;
        }
        return acertos < letras.length && erros < 7;
    }

    public String verificarRsultadoDaPartida(int acertos) {
        if (acertos == letras.length) {
            return "\nVitoria\n";
        } else {
            return "\nDerrota\n";
        }
    }

}
