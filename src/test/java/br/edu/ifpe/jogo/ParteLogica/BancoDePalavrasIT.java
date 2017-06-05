package br.edu.ifpe.jogo.ParteLogica;

import br.edu.ifpe.jogo.ParteLogica.BancoDePalavras;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 20141D12GR0114
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

}
