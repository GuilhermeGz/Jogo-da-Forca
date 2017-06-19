package br.edu.ifpe.jogo.ParteLogica;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Guilherme Silva
 */
public class JogoIT {

    Jogo jforca = new Jogo();

    public JogoIT() {
    }

    @Test
    public void criarCampoSemAcerto() {
        char[] letrasTest = "LEITE".toCharArray();
        int[] marcador = new int[letrasTest.length];
        String result = jforca.criarCampo(letrasTest, marcador);
        Assert.assertEquals("_ _ _ _ _ ", result);
    }

    @Test
    public void criarCampoComAcerto() {
        char[] letrasTest = "LEITE".toCharArray();
        int[] marcador = new int[letrasTest.length];
        marcador[1] = 1;
        marcador[4] = 1;
        String result = jforca.criarCampo(letrasTest, marcador);
        Assert.assertEquals("_ E _ _ E ", result);
    }
    
    @Test
    public void verificarResultadoDaPartidaComVitoria() {
        char[] letrasTest = "12345".toCharArray();
        String result = jforca.verificarRsultadoDaPartida(5, letrasTest);
        Assert.assertEquals("\nVitoria\n", result);
    }

    @Test
    public void verificarResultadoDaPartidaComDerrota() {
        char[] letrasTest = "12345".toCharArray();
        String result = jforca.verificarRsultadoDaPartida(4, letrasTest);
        Assert.assertEquals("\nDerrota\n", result);
    }
   
}
