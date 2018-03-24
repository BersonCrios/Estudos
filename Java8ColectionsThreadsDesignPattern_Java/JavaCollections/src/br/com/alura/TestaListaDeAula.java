package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestaListaDeAula {
	public static void main(String[] args) {
		
		/*Criando objetos da classe aula*/
		Aula a1 = new Aula("Revisitando as ArrayLists", 21);
		Aula a2 = new Aula("Listas de Objetos", 20);
		Aula a3 = new Aula("Relacionamento de Listas e Objetos", 15);
		
		/*Criando a array list aulas*/
		ArrayList<Aula> aulas = new ArrayList<>();
		
		
		/*Adicionando esses objetos em uma arraylist*/
		aulas.add(a1);
		aulas.add(a2);
		aulas.add(a3);
		
		/*Imprimindo a array list, onde retorna o que tem no método toString da classe Aula*/
		System.out.println(aulas);
		
		/*Ordenando as aulas, somente após a implementação da interface Comparable, pois quem herda
		 * de object não tem  o compareTo*/
		Collections.sort(aulas);
	
		/*Imprimindo array list ordenado pelo nosso critério definido na classe aula, ou seja, pela string do titlo*/
		System.out.println(aulas);
		
		/*Ordenando aulas pelo tempom usando método sort*/
		aulas.sort(Comparator.comparing(Aula::getTempo));
		
		/*Imprimindo*/
		System.out.println(aulas);


	}
}
