package br.com.bersoncrios.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.bersoncrios.servicos.CalculadoraTest;
import br.com.bersoncrios.servicos.CalculoValorLocacaoTest;
import br.com.bersoncrios.servicos.LocacaoServiceTest;

@RunWith(Suite.class)
@SuiteClasses({
	CalculadoraTest.class,
	CalculoValorLocacaoTest.class,
	LocacaoServiceTest.class
})
public class SuiteExecucao {
	//REMOVA SE PODER!
}
