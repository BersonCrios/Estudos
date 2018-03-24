package br.com.alura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestaAlunos {
	public static void main(String[] args) {
		
        Collection<String> alunos = new HashSet<>();
        
        alunos.add("Guilherme");
        alunos.add("Matheus");
        alunos.add("Daniel");
        alunos.add("Weslley");
        alunos.add("Alecxandra");
        alunos.add("Max");
        
        boolean guilhermeEstaMatriculado = alunos.contains("Guilherme");
        System.out.println(guilhermeEstaMatriculado);
        
        System.out.println("__________________________________________________________");
        
        System.out.println(alunos.size());
        
        System.out.println("__________________________________________________________");
        
        System.out.println(alunos);
        
        System.out.println("__________________________________________________________");
        
        for (String aluno : alunos) {
			System.out.println(aluno);
		}
        
        System.out.println("__________________________________________________________");
        
        alunos.forEach( aluno-> {
			System.out.println(aluno);
        });
        
        System.out.println("__________________________________________________________");

        
        List<String> alunosEmLista = new ArrayList<>(alunos); 
        
        
        System.out.println(alunosEmLista.get(2));
	}
}
