package br.com.alura.threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class TarefaBuscaTextual implements Runnable {

	private String nomeArquivo;
	private String nome;

	public TarefaBuscaTextual(String nomeArquivo, String nome) {
		this.nomeArquivo = nomeArquivo;
		this.nome = nome;
	
	}

	@Override
	public void run() {
		try {
			Scanner scanner = new Scanner(new File(nomeArquivo));
			int numeroLinha = 1;
			
			while (scanner.hasNextLine()) {
				String linha = (String) scanner.nextLine();
				if(linha.toLowerCase().contains(nome.toLowerCase())){
					System.out.println(nomeArquivo + " - " + numeroLinha + " - " + linha);
				}
				
				numeroLinha++;
			}
			
			scanner.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
