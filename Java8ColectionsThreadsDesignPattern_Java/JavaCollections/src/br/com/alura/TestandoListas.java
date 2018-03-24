package br.com.alura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TestandoListas {
	public static void main(String[] args) {
		
		/**
		 * Conteúdo referente a primeira Aula de Collection Alura
		 * **/
		
		/*Declarando algumas variáveis do Tipo String*/
		String aula1 =  "Conehcendo mais de Listas";
		String aula2 =  "Modelando a classe aula";
		String aula3 =  "Trabalhando com Cursos e sets";
		
		/*Criando um ArrayList do tipo String*/
		ArrayList<String> aulas = new ArrayList<>();
		
		/*usamos o método "add()" para adicionar um elemento a um arraylit, 
		 *no caso colocando as strings dentro do array list aulas*/
		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);
		
		/*Imprimindo todo o array de aulas, com as três strings dentro*/
		System.out.println(aulas);
		
		/*Removendo o elemento na posição 0 do arraylist aulas*/
		aulas.remove(0);
		
		/*Imprimindo todo o array novamente, só que agora sem o elemento removido*/
		System.out.println(aulas);
		
		/*Coloca na variável "primeiraAula o valor que está na posição 0 no array de aulas"*/
		String primeiraAula = aulas.get(0);
		
		/*Imprimindo esse valor*/
		System.out.println("A primeira Aula é: " + primeiraAula);
		
		/*for "tradicional" onde exibe todas as aulas do array*/
		for (int i = 0;i< aulas.size();i++){
			System.out.println("Aula: " + aulas.get(i));
		}
		
		/*foreach onde se cria uma variável de um determinado tipo para cada variável de um array
		 *No caso, aula do tipo String para cada elemento do arraylist aulas*/
		for (String aula : aulas) {
			System.out.println("Aula: " + aula);
		}
		
		/*foreach como um método do arraylist, onde passamos uma labda expression*/
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
