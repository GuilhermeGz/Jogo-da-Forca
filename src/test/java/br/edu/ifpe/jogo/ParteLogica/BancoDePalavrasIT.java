package br.edu.ifpe.jogo.ParteLogica;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Guilherme Silva
 */
public class BancoDePalavrasIT {

    public BancoDePalavrasIT() {
    }

    @Test
    public void naoAdicionarPalvraNaLista() {
        BancoDePalavras bd = new BancoDePalavras();
        String result = bd.adicionarPalavra("leite");
        Assert.assertEquals("\nPalavra já se encontra na lista", result);
    }

    @Test
    public void adicionarPalavraNaLista() {
        BancoDePalavras bd = new BancoDePalavras();
        String result = bd.adicionarPalavra("pokemon");
        Assert.assertEquals("\nPalavra adicionada", result);
    }

    @Test
    public void naoRemoverPalavraNaLista() {
        BancoDePalavras bd = new BancoDePalavras();
        String result = bd.removerPalavra("forte");
        Assert.assertEquals("\nPalavra não existe", result);
    }

    @Test
    public void removerPalavraNaLista() {
        BancoDePalavras bd = new BancoDePalavras();
        String result = bd.removerPalavra("carne");
        Assert.assertEquals("\nPalavra removida", result);
    }

}
