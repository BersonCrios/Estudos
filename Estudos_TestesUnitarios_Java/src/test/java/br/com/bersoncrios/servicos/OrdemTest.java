package br.com.bersoncrios.servicos;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrdemTest {
	
	public static int count = 0;
	
	@Test
	public void inicia() {
		count = 1;
	}
	
	@Test
	public void verifica() {
		Assert.assertEquals(1, count);
	}
	
}
