package br.edu.ifpe.jogo.FORCA;

import br.edu.ifpe.jogo.ParteLogica.Jogo;
import java.util.Scanner;

public class Jogando {

    public static void main(String[] args) {
        Jogo j = new Jogo();
        System.out.println(j.mostrarMenu());
        Scanner sc = new Scanner(System.in);
        j.inicializarJogo(sc.nextInt());

    }

}
