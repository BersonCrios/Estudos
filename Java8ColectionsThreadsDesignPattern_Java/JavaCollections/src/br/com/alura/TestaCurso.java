package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaCurso {
	public static void main(String[] args) {
		/*Cria um objeto de cursos, onde passa nome d curso e professor pelo construtor*/
		Curso javaColecoes = new Curso("Dominando as Cole��es", "Guilherme Berson");
	
		//javaColecoes.getAulas().add(new Aula("Trabalhando com ArrayLists",21));
		
		/*Usando m�todo criado na classe Curso para adiciona as aulas*/
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayLists",21));
		javaColecoes.adiciona(new Aula("Criando uma Aula",20));
		javaColecoes.adiciona(new Aula("Modelando com Cole��es",22));
		
		/*Imprime a lista de aulas*/
		System.out.println(javaColecoes.getAulas());	
		
		
		/*Cria uma list de aulas ainda imut�veis por conta do get aulas*/
		List<Aula> aulasImutaveis = javaColecoes.getAulas();
		System.out.println(aulasImutaveis);
		
		/*Cria outra lista de aulas que recebe uma c�pia das aulas imut�eis, so que agr podendo ser mudadas*/
		List<Aula> aulas = new ArrayList<>(aulasImutaveis); 
		/*Ordena pelo titulo*/
		Collections.sort(aulas);
		/*Imprime*/
		System.out.println(aulas);
		
		/*Imprime o tempo total do curso, feito pelo m�todo getTempoTotal, que calcua�*/
		System.out.println(javaColecoes.getTempoTotal());
		
		System.out.println(javaColecoes);
	}
}
