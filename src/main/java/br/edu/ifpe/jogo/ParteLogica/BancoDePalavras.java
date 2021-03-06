package br.edu.ifpe.jogo.ParteLogica;

import java.util.ArrayList;

public class BancoDePalavras {

    protected ArrayList<String> Palavras = new ArrayList<String>();

    public BancoDePalavras() {
        Palavras.add("LEITE");
        Palavras.add("QUEIJO");
        Palavras.add("BANANA");
        Palavras.add("CAJU");
        Palavras.add("GOAIBA");
        Palavras.add("TOMATE");
        Palavras.add("ARROZ");
        Palavras.add("LARANJA");
        Palavras.add("CARNE");
        Palavras.add("BISCOITO");
        Palavras.add("BOLACHA");
    }

    public ArrayList<String> getPalavras() {
        return Palavras;
    }

    public void setPalavras(ArrayList<String> palavras) {
        Palavras = palavras;
    }

    public String adicionarPalavra(String palavra) {
        palavra = palavra.toUpperCase();
        if (Palavras.contains(palavra) == true) {
            return "\nPalavra já se encontra na lista";
        } else {
            Palavras.add(palavra);
            return "\nPalavra adicionada";
        }
    }

    public String removerPalavra(String palavra) {
        palavra = palavra.toUpperCase();
        if (Palavras.remove(palavra) == true) {
            return "\nPalavra removida";
        } else {
            return "\nPalavra não existe";
        }
    }

    public String mostrarLista() {
        String lista = new String();
        for (int i = 0; i < Palavras.size(); i++) {
            lista += " " + Palavras.get(i);
        }
        return lista;
    }

}
