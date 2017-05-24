package br.edu.ifpe.jogo.ParteLogica;

import java.util.Random;
import java.util.Scanner;

public class Jogo {

    int erros = 0;
    int acertos = 0;
    Random gerador = new Random();
    BancoDePalavras bd;
    char[] letras;
    int[] marcasao;

    public Jogo() {
        bd = new BancoDePalavras();
    }

    public void inicializandoJogo() {
        Scanner sc = new Scanner(System.in);
        int posicao = gerador.nextInt(bd.getPalavras().size());
        String palavra = bd.getPalavras().get(posicao);
        letras = palavra.toCharArray();
        marcasao = new int[letras.length];
        int opcao;

        do {
            System.out.println("1 - Jogar\n2 - Adicionar palavra\n3 - Remover palavra"
                    + "\n4 - Mostrar lista de palvras\n5 - Sair do jogo");

            opcao = sc.nextInt();
            if (opcao == 1) {
                boolean result;
                do {
                    criarCampo();

                    System.out.println("\nEscolha uma letra");
                    System.out.println("Erros :" + erros);
                    char letra = sc.next().toUpperCase().charAt(0);
                    result = realizarEscolhaPalavra(letra);

                } while (result != false);

                if (acertos == letras.length) {
                    System.out.println("\nVitoria\n");
                } else {
                    System.out.println("\nDerrota\n");
                }

            } else if (opcao == 2) {
                realizandoAdicaoPalavra(sc.next());
            } else if (opcao == 3) {
                remocaoPalavra(sc.next());
            } else if (opcao != 5) {
                mostrarLista();
            } else if (opcao != 5) {
                System.out.println("Valor inapropriado");
            }

        } while (opcao != 5);
    }

    public void criarCampo() {

        for (int i = 0; i < letras.length; i++) {
            if (marcasao[i] == 1) {
                System.out.print(letras[i] + " ");
            } else {
                System.out.print("_ ");
            }
        }

    }

    public boolean realizarEscolhaPalavra(char pl) {
        char letra = pl;
        int cont = 0;

        for (int i = 0; i < letras.length; i++) {
            if (letra == letras[i]) {
                if (marcasao[i] == 1) {
                    System.out.println("Escolha outra letra");
                    cont = 1;
                } else {
                    marcasao[i] = 1;
                    acertos++;
                    cont = 1;
                }
            }
        }
        if (cont != 1) {
            erros++;
        }
        return acertos < letras.length && erros < 7;
    }

    public void realizandoAdicaoPalavra(String pl) {
        System.out.println("Digite a palavra");
        System.out.println(bd.adicionarPalavra(pl));
    }

    public void remocaoPalavra(String pl) {
        System.out.println("Digite a palavra");
        System.out.println(bd.removerPalavra(pl));
    }

    public void mostrarLista() {
        for (int i = 0; i < bd.Palavras.size(); i++) {
            System.out.println(bd.getPalavras().get(i));
        }
    }

}
