package br.com.bersoncrios.servicos;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import br.com.bersoncrios.entidades.Usuario;

public class AssertTest {

	@Test
	public void test() {
		//Verifica se a assertiva é verdade
		assertTrue(true);
		//Verifica se a assertiva é falso
		assertFalse(false);
		//Verifica se o primeiro é igual o segundo elemento
		assertEquals(1,1);
		//Verifica se o primeiro é igual o segundo elemento, tendo o ultimo parametro como margem de comparação
		assertEquals(0.519,0.519, 0.001);
		
		/*
		 * comparação entre tipo primitivo e objeto
		 * */
		int i = 5;
		Integer i2 = 5;
		
		assertEquals(Integer.valueOf(i), i2);
		//ou
		assertEquals(i, i2.intValue());
		
		assertEquals("bola", "bola");
		assertNotEquals("bola", "Bola");
		assertTrue("bola".equalsIgnoreCase("Bola"));
		assertTrue("bola".startsWith("bo"));
		
		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");
		Usuario u3 = u2;
		assertEquals(u1, u2);
		
		//Verifica se o objeto é da mesma instância
		assertSame(u2, u3);
		assertNotSame(u1,u2);
	}
	
}
