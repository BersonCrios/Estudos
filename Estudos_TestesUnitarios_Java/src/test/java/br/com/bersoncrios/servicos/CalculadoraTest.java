package br.com.bersoncrios.servicos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.bersoncrios.exceptions.NaoPodeDividirPorZeroException;

public class CalculadoraTest {
	
	private Calculadora calc;
	
	@Before
	public void setUp() {
		calc = new Calculadora();
	}
	
	@Test
	public void deveSomarDoisValores() {
		//CEN�RIO
			int a = 5;
			int b = 3;
			
		//A��O
			int result = calc.soma(a,b);
		
		//VERIFICA��O
			Assert.assertEquals(8, result);
	}
	
	
	@Test
	public void deveSubtrairDoisValores() {
		//CEN�RIO
			int a = 5;
			int b = 3;
			
		//A��O
			int result = calc.subtrai(a,b);
		
		//VERIFICA��O
			Assert.assertEquals(2, result);
	}
	
	
	@Test
	public void deveDividirDoisValores() throws NaoPodeDividirPorZeroException {
		//CEN�RIO
			int a = 10;
			int b = 2;
			
		//A��O
			int result = calc.dividir(a,b);
		
		//VERIFICA��O
			Assert.assertEquals(5, result);
	}
	
	@Test(expected = NaoPodeDividirPorZeroException.class)
	public void lancarExcacaoAoDividirPorZero() throws NaoPodeDividirPorZeroException {
		//CEN�RIO
			int a = 10;
			int b = 0;
			
		//A��O
			int result = calc.dividir(a,b);
	}
}
