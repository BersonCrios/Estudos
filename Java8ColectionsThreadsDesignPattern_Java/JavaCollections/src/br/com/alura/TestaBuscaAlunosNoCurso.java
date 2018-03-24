package br.com.alura;

public class TestaBuscaAlunosNoCurso {
	public static void main(String[] args) {
Curso javaColecoes = new Curso("Dominando as Cole��es", "Guilherme Berson");
	
		
		javaColecoes.adiciona(new Aula("Trabalhando com ArrayLists",21));
		javaColecoes.adiciona(new Aula("Criando uma Aula",20));
		javaColecoes.adiciona(new Aula("Modelando com Cole��es",22));
		
		Aluno a1 = new Aluno ("Jo�o", 1111);
		Aluno a2 = new Aluno ("Maria", 2222);
		Aluno a3 = new Aluno ("Pedro", 3333);
		
		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);
		
		
		Aluno aluno = javaColecoes.buscaMatriculado(2222);
		
		System.out.println("Quem � o aluno com matricula " + aluno.getNumeroMatricula() + " ?");
		System.out.println("Aluno: "  + aluno);
	}
}
