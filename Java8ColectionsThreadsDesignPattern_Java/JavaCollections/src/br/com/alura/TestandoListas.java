package br.com.alura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TestandoListas {
	public static void main(String[] args) {
		
		/**
		 * Conte�do referente a primeira Aula de Collection Alura
		 * **/
		
		/*Declarando algumas vari�veis do Tipo String*/
		String aula1 =  "Conehcendo mais de Listas";
		String aula2 =  "Modelando a classe aula";
		String aula3 =  "Trabalhando com Cursos e sets";
		
		/*Criando um ArrayList do tipo String*/
		ArrayList<String> aulas = new ArrayList<>();
		
		/*usamos o m�todo "add()" para adicionar um elemento a um arraylit, 
		 *no caso colocando as strings dentro do array list aulas*/
		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);
		
		/*Imprimindo todo o array de aulas, com as tr�s strings dentro*/
		System.out.println(aulas);
		
		/*Removendo o elemento na posi��o 0 do arraylist aulas*/
		aulas.remove(0);
		
		/*Imprimindo todo o array novamente, s� que agora sem o elemento removido*/
		System.out.println(aulas);
		
		/*Coloca na vari�vel "primeiraAula o valor que est� na posi��o 0 no array de aulas"*/
		String primeiraAula = aulas.get(0);
		
		/*Imprimindo esse valor*/
		System.out.println("A primeira Aula �: " + primeiraAula);
		
		/*for "tradicional" onde exibe todas as aulas do array*/
		for (int i = 0;i< aulas.size();i++){
			System.out.println("Aula: " + aulas.get(i));
		}
		
		/*foreach onde se cria uma vari�vel de um determinado tipo para cada vari�vel de um array
		 *No caso, aula do tipo String para cada elemento do arraylist aulas*/
		for (String aula : aulas) {
			System.out.println("Aula: " + aula);
		}
		
		/*foreach como um m�todo do arraylist, onde passamos uma labda expression*/
		aulas.forEach(aula -> {
			System.out.println("Percorrendo: ");
			System.out.println("Aula  " + aula);
			});
		
		
		/*Adicionando mais um elemento no array*/
		aulas.add("Aumentando nosso conhecimento");
		
		/*Imprimindo todo o arraylist*/
		System.out.println(aulas);
		
		/*Ordenando*/
		Collections.sort(aulas);
		
		/*Imprmido ordenado*/
		System.out.println(aulas);
		
		

	}
}
