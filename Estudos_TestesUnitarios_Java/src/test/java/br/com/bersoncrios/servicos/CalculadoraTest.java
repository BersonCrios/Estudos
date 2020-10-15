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
		//CENÁRIO
			int a = 5;
			int b = 3;
			
		//AÇÃO
			int result = calc.soma(a,b);
		
		//VERIFICAÇÃO
			Assert.assertEquals(8, result);
	}
	
	
	@Test
	public void deveSubtrairDoisValores() {
		//CENÁRIO
			int a = 5;
			int b = 3;
			
		//AÇÃO
			int result = calc.subtrai(a,b);
		
		//VERIFICAÇÃO
			Assert.assertEquals(2, result);
	}
	
	
	@Test
	public void deveDividirDoisValores() throws NaoPodeDividirPorZeroException {
		//CENÁRIO
			int a = 10;
			int b = 2;
			
		//AÇÃO
			int result = calc.dividir(a,b);
		
		//VERIFICAÇÃO
			Assert.assertEquals(5, result);
	}
	
	@Test(expected = NaoPodeDividirPorZeroException.class)
	public void lancarExcacaoAoDividirPorZero() throws NaoPodeDividirPorZeroException {
		//CENÁRIO
			int a = 10;
			int b = 0;
			
		//AÇÃO
			int result = calc.dividir(a,b);
	}
}
