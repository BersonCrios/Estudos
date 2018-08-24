package Questao1;

import java.util.ArrayList;

public class principal {
	public static void main(String[] args) {
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		
		ArrayList<Double> n001 = new ArrayList<Double>();
		ArrayList<Double> n002 = new ArrayList<Double>();
		ArrayList<Double> n003 = new ArrayList<Double>();
		
		n001.add(5.6);
		n001.add(5.6);
		
		n002.add(7.4);
		n002.add(9.6);

		n003.add(9.6);
		n003.add(8.0);

		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		Aluno a3 = new Aluno();
		
		a1.setNome("Jóca");
		a1.setNotas(n001);
		a2.setNome("José");
		a2.setNotas(n002);
		a3.setNome("Maria");
		a3.setNotas(n003);
		
		
		alunos.add(a1);
		alunos.add(a2);
		alunos.add(a3);
		
		
		for (int i = 0; i < alunos.size(); i++) {
			Aluno aluno;
			int qtdAprovados = 0;

			aluno = alunos.get(i);
			aluno.imprimeDadosDoAluno();
			aluno.calulaMedia();
			aluno.mostraSituacao();
			System.out.println("---------------------------------------");
		}
	}
}
