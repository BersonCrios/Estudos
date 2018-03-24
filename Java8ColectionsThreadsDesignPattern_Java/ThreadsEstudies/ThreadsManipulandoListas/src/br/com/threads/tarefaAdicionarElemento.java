package br.com.threads;

import java.util.List;

public class tarefaAdicionarElemento implements Runnable {

	private Lista lista;
	private int numeroDaThread;

	public tarefaAdicionarElemento(Lista lista, int numeroDaThread) {
		this.lista = lista;
		this.numeroDaThread = numeroDaThread;
		
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			lista.adicionaElementos("Thread " + numeroDaThread + " - " + i);
			
		}
	}

}
