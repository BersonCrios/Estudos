package br.com.banheiro;

public class Banheiro {

	private boolean ehSujo = true;

	public void fazNumero1() {
		String nome = Thread.currentThread().getName();

		System.out.println(nome + " está batendo na porta");

		synchronized (this) {
			System.out.println(nome + " Entrando no banheiro");
			
			while (ehSujo) {
				EsperaLaFora(nome);
			}
			
			System.out.println(nome + " Fazendo coisa rápida");

			dormeUmPouco(5000);

			this.ehSujo = true;
			
			System.out.println(nome + " Dando descarga");
			System.out.println(nome + " Lavando as mãos");
			System.out.println(nome + " Saindo do Banheiro");
		}
	}

	public void fazNumero2() {

		String nome = Thread.currentThread().getName();

		System.out.println(nome + " está batendo na porta");

		synchronized (this) {
			System.out.println(nome + " Entrando no banheiro");

			while (ehSujo) {
				EsperaLaFora(nome);
			}

			System.out.println(nome + " Fazendo coisa demorada");
			dormeUmPouco(10000);
			
			this.ehSujo = true;

			System.out.println(nome + " Dando descarga");
			System.out.println(nome + " Lavando as mãos");
			System.out.println(nome + " Saindo do Banheiro");
		}
	}


	public void limpa() {
		String nome = Thread.currentThread().getName();

		System.out.println(nome + " está batendo na porta");

		synchronized (this) {
			System.out.println(nome + " Entrando no banheiro");
			if (!ehSujo) {
				System.out.println(nome + "Não está sujo, vou sair");
				return;
			}
			
			System.out.println(nome + " Limpando banheiro");
			this.ehSujo = false;

			dormeUmPouco(13000);
			
			this.notifyAll();
			
			System.out.println(nome + " Saindo do Banheiro");
		}

	}
	
	private void dormeUmPouco(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void EsperaLaFora(String nome) {
		System.out.println(nome + ", eca, banheiro tá sujo");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
