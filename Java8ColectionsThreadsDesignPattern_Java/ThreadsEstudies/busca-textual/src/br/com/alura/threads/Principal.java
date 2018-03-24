package br.com.alura.threads;

public class Principal {
	public static void main(String[] args) {
		String nome = "da";
		
		Thread threadsAssinaturas1 = new Thread(new TarefaBuscaTextual("assinaturas1.txt",nome));
		Thread threadsAssinaturas2 = new Thread(new TarefaBuscaTextual("assinaturas2.txt",nome));
		Thread threadsAutores = new Thread(new TarefaBuscaTextual("autores.txt",nome));
		
		threadsAssinaturas1.start();
		threadsAssinaturas2.start();
		threadsAutores.start();
	}
}
