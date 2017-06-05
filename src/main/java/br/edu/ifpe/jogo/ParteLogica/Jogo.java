package br.edu.ifpe.jogo.ParteLogica;

import java.util.Random;
import java.util.Scanner;

public class Jogo {

    int erros ;
    int acertos ;
    Random gerador = new Random();
    BancoDePalavras bd;
    int opcao;
    char[] letras;
    int[] marcasao;

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
        int posicao = gerador.nextInt(bd.getPalavras().size());
        String palavra = bd.getPalavras().get(posicao);
        letras = palavra.toCharArray();
        marcasao = new int[letras.length];

        do {
            System.out.println("1 - Jogar\n2 - Adicionar palavra\n3 - Remover palavra"
                    + "\n4 - Mostrar lista de palvras\n5 - Sair do jogo");

            setOpcao(sc.nextInt());
            
            if (getOpcao() == 1) {
                boolean result;
                do {
                    System.out.println(criarCampo());
                    System.out.println("\nEscolha uma letra");
                    System.out.println("Erros :" + getErros());
                    char letra = sc.next().toUpperCase().charAt(0);
                    result = verificarLetra(letra);

                } while (result == true);

                System.out.println(verificarRsultadoPartida(acertos));

            } else if (getOpcao() == 2) {
                System.out.println("Digite a palavra");
                System.out.println(bd.adicionarPalavra(sc.next()));
            } else if (getOpcao() == 3) {
                System.out.println("Digite a palavra");
                bd.removerPalavra(sc.next());
            } else if (getOpcao() == 4) {
                System.out.println(mostrarLista());
            } else if (getOpcao() != 5) {
                System.out.println("\nValor inapropriadoz\n");
            }

        } while (getOpcao() != 5);
    }

    public String criarCampo() {
        String campo = new String();
        for (int i = 0; i < letras.length; i++) {
            if (marcasao[i] == 1) {
                campo += letras[i] + " ";
            } else {
                campo += "_ ";
            }
        }
        return campo;
    }

    public boolean verificarLetra(char pl) {
        char letra = pl;
        boolean cont = false;

        for (int i = 0; i < letras.length; i++) {
            if (letra == letras[i]) {
                if (marcasao[i] == 1) {
                    System.out.println("\nEscolha outra letra\n");
                    cont = true;
                } else {
                    marcasao[i] = 1;
                    acertos++;
                    cont = true;
                }
            }
        }
        if (cont == false) {
            erros++;
        }
        return acertos < letras.length && erros < 7;
    }

    public String mostrarLista() {
        String lista = new String();
        for (int i = 0; i < bd.Palavras.size(); i++) {
            lista += " " + bd.getPalavras().get(i);
        }
        return lista;
    }

    public String verificarRsultadoPartida(int acertos) {
        if (acertos == letras.length) {
            return "\nVitoria\n";
        } else {
            return "\nDerrota\n";
        }
    }
    
}
