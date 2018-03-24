package br.com.alura;

public class Aluno {
	private String nome;
	private int numeroMatricula;
	
	
	public Aluno(String nome, int numeroMatricula) {
		
		if(nome == null){
			throw new NullPointerException("Nome não pode ser NULO");
		}
		this.nome = nome;
		this.numeroMatricula = numeroMatricula;
	}


	public String getNome() {
		return nome;
	}

	public int getNumeroMatricula() {
		return numeroMatricula;
	}
	
	@Override
	public int hashCode() {
		return this.nome.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		Aluno outroAluno = (Aluno) obj;	
		return this.nome.equals(outroAluno.nome);
	}
	@Override
	public String toString() {
		return "[Aluno: " +this.nome + ", Matricula: " + this.numeroMatricula  + "]";
	}
}
