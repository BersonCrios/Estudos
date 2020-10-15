package br.com.bersoncrios.servicos;

import br.com.bersoncrios.exceptions.NaoPodeDividirPorZeroException;

public class Calculadora {

	public int soma(int a, int b) {
		return a+b;
	}

	public int subtrai(int a, int b) {
		return a-b;
	}

	public int dividir(int a, int b) throws NaoPodeDividirPorZeroException {
		if(b == 0) {
			throw new NaoPodeDividirPorZeroException();
		}
		return a/b;
	}
}
