/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.jogo.ParteLogica;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gon
 */
public class BancoDePalavrasTest {
    
    public BancoDePalavrasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAdicionarPalavra() {
        System.out.println("adicionarPalavra");
        String palavra = "";
        BancoDePalavras instance = new BancoDePalavras();
        String expResult = "";
        String result = instance.adicionarPalavra(palavra);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemoverPalavra() {
        System.out.println("removerPalavra");
        String palavra = "";
        BancoDePalavras instance = new BancoDePalavras();
        String expResult = "";
        String result = instance.removerPalavra(palavra);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPalavras() {
        System.out.println("getPalavras");
        BancoDePalavras instance = new BancoDePalavras();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getPalavras();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPalavras() {
        System.out.println("setPalavras");
        ArrayList<String> palavras = null;
        BancoDePalavras instance = new BancoDePalavras();
        instance.setPalavras(palavras);
        fail("The test case is a prototype.");
    }
    
}
