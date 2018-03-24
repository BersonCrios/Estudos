package br.com.threads;

public class Principal {
	public static void main(String[] args) {
		Thread threadPrimeira = new Thread(new PrimeiraThreads());
		Thread threadSegunda = new Thread(new SegundaThread());
		
		long idT1 = threadPrimeira.getId();
		System.out.println("Id da Primeira thread: " + idT1);
		
		long idT2 = threadSegunda.getId();
		System.out.println("Id da Primeira thread: " + idT2);
		
		threadPrimeira.start();
		threadSegunda.start();
	}
}
