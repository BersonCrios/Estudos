package br.com.alura;


/**
 * Classe modelo de aula, que implementa a interace Comparable
 * **/
public class Aula implements Comparable<Aula> {
	private String titulo;
	private int tempo;
	
	
	public Aula(String titulo, int tempo) {
		this.titulo = titulo;
		this.tempo = tempo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public int getTempo() {
		return tempo;
	}
	
	/*Sobrescreve o método da classe mãe*/
	@Override
	public String toString() {
		return "[Aula: " + this.titulo + ", " +  this.tempo + " Minutos]";
	}

	@Override
	public int compareTo(Aula outraAula) {
		return this.titulo.compareTo(outraAula.titulo);
	}
	
}
