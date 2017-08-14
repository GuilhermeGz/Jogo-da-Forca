package br.edu.ifpe.jogo.ParteLogica;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Guilherme Silva
 */
public class BancoDePalavrasIT {

    BancoDePalavras bd = new BancoDePalavras();

    public BancoDePalavrasIT() {
    }

    @Test
    public void naoAdicionarPalvraNaLista() {
        String result = bd.adicionarPalavra("leite");
        Assert.assertEquals("\nPalavra já se encontra na lista", result);
    }

    @Test
    public void adicionarPalavraNaLista() {
        String result = bd.adicionarPalavra("pokemon");
        Assert.assertEquals("\nPalavra adicionada", result);
    }

    @Test
    public void naoRemoverPalavraNaLista() {
        String result = bd.removerPalavra("forte");
        Assert.assertEquals("\nPalavra não existe", result);
    }

    @Test
    public void removerPalavraNaLista() {
        String result = bd.removerPalavra("carne");
        Assert.assertEquals("\nPalavra removida", result);
    }

    @Test
    public void mostrarListaInicial() {
        String result = bd.mostrarLista();
        Assert.assertEquals(" LEITE QUEIJO BANANA CAJU GOAIBA TOMATE "
                + "ARROZ LARANJA CARNE BISCOITO BOLACHA", result);
    }

    @Test
    public void mostrarListaComAdicaoDePalavra() {
        bd.adicionarPalavra("pokemon");
        String result = bd.mostrarLista();
        Assert.assertEquals(" LEITE QUEIJO BANANA CAJU GOAIBA TOMATE "
                + "ARROZ LARANJA CARNE BISCOITO BOLACHA POKEMON", result);
    }

    @Test
    public void mostrarListaComRemocaoDePalavra() {
        bd.removerPalavra("carne");
        String result = bd.mostrarLista();
        Assert.assertEquals(" LEITE QUEIJO BANANA CAJU GOAIBA TOMATE "
                + "ARROZ LARANJA BISCOITO BOLACHA", result);
    }

    @Test
    public void adicionarPosicaoNaLista() {
        int prime = bd.getPalavras().size();
        bd.adicionarPalavra("Computador");
        int result = bd.getPalavras().size();
        Assert.assertEquals(prime + 1, result);

    }

    @Test
    public void verificarAdicaoDaPalavraNaLista() {
        bd.adicionarPalavra("CPU");
        String result = bd.getPalavras().get(bd.getPalavras().size() - 1);
        Assert.assertEquals("CPU", result);
    }

    @Test
    public void removerPosicaoNaLista() {
        int prime = bd.getPalavras().size();
        bd.removerPalavra("bolacha");
        int result = bd.getPalavras().size();
        Assert.assertEquals(prime - 1, result);
    }
    
    @Test
    public void verificarRemocaoDaPalavraNaLista(){
        bd.removerPalavra("bolacha");
        boolean result = bd.Palavras.contains("bolacha");
        Assert.assertFalse(result);
    }
}
