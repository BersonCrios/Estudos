package Questao1;

import java.util.ArrayList;

public class Aluno {
	private String nome;
	private ArrayList<Double> notas;
	private Double media;
	private String situacao;
	
	
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Double getMedia() {
		return media;
	}
	public void setMedia(Double media) {
		this.media = media;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Double> getNotas() {
		return notas;
	}
	public void setNotas(ArrayList<Double> notas) {
		this.notas = notas;
	}
	
	public void imprimeDadosDoAluno() {
		System.out.println("Nome: " + nome + "\n" + "Notas: " + notas);
	}
	
	public void calulaMedia() {
		int i;
		Double soma = 0.0;
		for (i = 0; i < notas.size(); i++) {
			soma += notas.get(i);
			media = soma/2;
		}
		System.out.println("Média: " + media);
	}
	
	public void mostraSituacao() {
		if (media < 6) {
			situacao = "REPROVADO";
			System.out.println("REPROVADO");
		}
		else {
			situacao = "APROVADO";
			System.out.println("APROVADO");
		}
	}
}
