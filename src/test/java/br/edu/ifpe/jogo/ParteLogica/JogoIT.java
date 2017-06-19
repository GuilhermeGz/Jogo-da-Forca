package br.edu.ifpe.jogo.ParteLogica;

import java.util.ArrayList;
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
    
    @Test
    public void verificarRepeticaoDeLetraComLetraRepetida() {
        ArrayList <Character> letrasTest = new ArrayList<Character>();
        letrasTest.add('A');
        boolean result = jforca.verificarRepeticaoDeLetra('A', letrasTest);
        Assert.assertEquals(true, result);
    }
    
    @Test(expected=java.lang.NullPointerException.class)
    public void verificarRepeticaoDeLetraSemLetraRepetida() {
        ArrayList <Character> letrasTest = new ArrayList<Character>();
        letrasTest.add('A');
        boolean result = jforca.verificarRepeticaoDeLetra('E', letrasTest);
    }
    
    @Test
    public void verificarAcertoComAcertosMenoresDoQueNecessarioParaVitoria() {
        char[] letrasTest = "LEITE".toCharArray();
        int [] marcador = new int [letrasTest.length];
        jforca.setMarcasao(marcador);
        jforca.setLetras(letrasTest);
        jforca.setErros(0);
        jforca.setAcertos(0);
        boolean result = jforca.verificarAcerto('L');
        Assert.assertEquals(true, result);
    }
    
    @Test
    public void verificarAcertoComAcertosNecessariosParaVitoria() {
        char[] letrasTest = "LEITE".toCharArray();
        int [] marcador = new int [letrasTest.length];
        jforca.setMarcasao(marcador);
        jforca.setLetras(letrasTest);
        jforca.setErros(0);
        jforca.setAcertos(4);
        boolean result = jforca.verificarAcerto('L');
        Assert.assertEquals(false, result);
    }
   
}
