package br.com.alura;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Classe Modelo de Cursos
 **/
public class Curso {
	private String nome;
	private String instrutor;

	/* Declara uma lista de aulas */
	private List<Aula> aulas = new LinkedList<>();

	private Set<Aluno> alunos = new HashSet<>();
	
	
	private Map<Integer, Aluno> MatriculaParaAluno = new HashMap<>();
	
	
	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public String getNome() {
		return nome;
	}

	public String getInstrutor() {
		return instrutor;
	}

	/*
	 * no get aulas é definido que não pode ser mudado de fora pelo Collections
	 */
	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas);
	}

	/**
	 * Método que recebe uma aula por parametro e a adiciona na lista
	 **/
	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}

	/**
	 * Mmétodo que calcula o tempo total de aulas
	 * **/
	public int getTempoTotal() {
		return this.aulas.stream().mapToInt(Aula::getTempo).sum();
	}

	@Override
	public String toString() {
		return "[Curso: " + nome + ", tempo total: " + this.getTempoTotal() + " +" + " aulas: " + this.aulas + "]";
	}

	public void matricula(Aluno aluno) {
		this.alunos.add(aluno);
		this.MatriculaParaAluno.put(aluno.getNumeroMatricula(), aluno);
	}
	
	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}

	public boolean estaMatriculado(Aluno aluno) {
		return this.alunos.contains(aluno);
	}

	public Aluno buscaMatriculado(int numero) {
		if (!MatriculaParaAluno.containsKey(numero)) {		
			throw new NoSuchElementException();
		}
		return MatriculaParaAluno.get(numero);
	}
}
