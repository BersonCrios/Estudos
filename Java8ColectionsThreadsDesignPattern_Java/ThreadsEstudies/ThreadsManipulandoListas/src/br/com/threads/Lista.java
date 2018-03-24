package br.com.threads;

public class Lista {
	/* Vari�veis globais da classe */

	/* Declarando um vetor de Strings com 100 posi��es */
	private String[] elementos = new String[1000];
	/*
	 * Declarando um inteiro que iniciar� em zero, que ser� como o indice do
	 * array
	 */
	private int indice = 0;

	/**
	 * Nome: adicionaElemento(elemento) retorno: Void Parametro: Elemento Classe
	 * que adiciona um elemento no vetor da seguinte maneira: Pega a posi��o X
	 * do vetor e adicona o elemento passado por parametro, no final o indice �
	 * acrecido de mais uma unidade
	 **/
	public void adicionaElementos(String elemento) {
		/*
		 * Acesso sincronizado, cada thread espera a outra terminar essas linhas
		 * para poder come�ar
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
				System.out.println("Lista t� cheia, notificando");
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
	 * Nome: pegaElemento(posicao) retorno: String Parametro: posi��o(int)
	 * Classe que pega um elemento que est� em uma determinada posi��o no array
	 * de elementos
	 **/
	public String pegaElemento(int posicao) {
		return this.elementos[posicao];
	}

	public boolean estaCheia() {
		return this.indice == this.tamanho();
	}
}
