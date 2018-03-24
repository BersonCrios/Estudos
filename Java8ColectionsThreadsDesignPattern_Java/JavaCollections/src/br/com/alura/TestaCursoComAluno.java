package br.com.alura;

import java.util.Iterator;
import java.util.Set;

public class TestaCursoComAluno {
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
		

        System.out.println("Todos os Alunos Matriculados: ");
        
        javaColecoes.getAlunos().forEach(aluno-> {
        	System.out.println(aluno);
        });
        
        System.out.println("__________________________________________________________");
        
        
        System.out.println("O Aluno " + a1.getNome() + " Esta Matrciludado?");
        System.out.println(javaColecoes.estaMatriculado(a1));
        
        
        
        System.out.println("__________________________________________________________");

        Aluno joao  = new Aluno("Jo�o", 1111 );
        
        System.out.println("O Jo�o Esta Matrciludado?");
        System.out.println(javaColecoes.estaMatriculado(joao));

        System.out.println("__________________________________________________________");

        System.out.println("O a1 � equals ao Jo�o?");
        System.out.println(a1.equals(joao));
        
        
        System.out.println("__________________________________________________________");
        
        
        /*Iterator se v� bastante em c�digo legado*/
        Set<Aluno> alunos = javaColecoes.getAlunos();
        Iterator<Aluno> iterator = alunos.iterator();
        while(iterator.hasNext()){
        	Aluno proximo = iterator.next();
        	System.out.println(proximo);
        }
        
        
        
	}
}
