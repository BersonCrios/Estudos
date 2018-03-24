package br.com.threads;

public class Lista {
	/* Variáveis globais da classe */

	/* Declarando um vetor de Strings com 100 posições */
	private String[] elementos = new String[1000];
	/*
	 * Declarando um inteiro que iniciará em zero, que será como o indice do
	 * array
	 */
	private int indice = 0;

	/**
	 * Nome: adicionaElemento(elemento) retorno: Void Parametro: Elemento Classe
	 * que adiciona um elemento no vetor da seguinte maneira: Pega a posição X
	 * do vetor e adicona o elemento passado por parametro, no final o indice é
	 * acrecido de mais uma unidade
	 **/
	public void adicionaElementos(String elemento) {
		/*
		 * Acesso sincronizado, cada thread espera a outra terminar essas linhas
		 * para poder começar
		 */
		synchronized (this) {
			this.elementos[indice] = elemento;
			this.indice++;
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (this.indice == this.elementos.length) {
				System.out.println("Lista tá cheia, notificando");
				this.notify();
			}
		}
	}

	/**
	 * Nome: tamanho() retorno: int Parametro: Nenhum Classe que conta o tamanho
	 * do array de elementos
	 **/
	public int tamanho() {
		return this.elementos.length;
	}

	/**
	 * Nome: pegaElemento(posicao) retorno: String Parametro: posição(int)
	 * Classe que pega um elemento que está em uma determinada posição no array
	 * de elementos
	 **/
	public String pegaElemento(int posicao) {
		return this.elementos[posicao];
	}

	public boolean estaCheia() {
		return this.indice == this.tamanho();
	}
}
