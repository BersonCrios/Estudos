package Questao2;

import java.util.ArrayList;

public class Socio {
	private String nome;
	private String endereco;
	private ArrayList<String> dependentes;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public ArrayList<String> getDependentes() {
		return dependentes;
	}
	public void setDependentes(ArrayList<String> dependentes) {
		this.dependentes = dependentes;
	}
	
	public String toString() {
		System.out.println("Nome: " + getNome() + "\n" + "Endereço: " + getEndereco() + "\n" + "Dependentes: " + getDependentes());
		return "";
	}
}
