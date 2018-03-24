package br.com.threads;

public class SegundaThread implements Runnable {
	int i;

	@Override
	public void run() {
		for (i = 0; i <= 1000; i++) {
			System.out.println("Thread 2 - " + i);
		}
	}
}
