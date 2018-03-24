package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaCurso {
	public static void main(String[] args) {
		/*Cria um objeto de cursos, onde passa nome d curso e professor pelo construtor*/
		Curso javaColecoes = new Curso("Dominando as Coleções", "Guilherme Berson");
	
		//javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayLists",21));
		
		/*Usando método criado na classe Curso para adiciona as aulas*/
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayLists",21));
		javaColecoes.adiciona(new Aula("Criando uma Aula",20));
		javaColecoes.adiciona(new Aula("Modelando com Coleções",22));
		
		/*Imprime a lista de aulas*/
		System.out.println(javaColecoes.getAulas());	
		
		
		/*Cria uma list de aulas ainda imutáveis por conta do get aulas*/
		List<Aula> aulasImutaveis = javaColecoes.getAulas();
		System.out.println(aulasImutaveis);
		
		/*Cria outra lista de aulas que recebe uma cópia das aulas imutáeis, so que agr podendo ser mudadas*/
		List<Aula> aulas = new ArrayList<>(aulasImutaveis); 
		/*Ordena pelo titulo*/
		Collections.sort(aulas);
		/*Imprime*/
		System.out.println(aulas);
		
		/*Imprime o tempo total do curso, feito pelo método getTempoTotal, que calcuaç*/
		System.out.println(javaColecoes.getTempoTotal());
		
		System.out.println(javaColecoes);
	}
}
