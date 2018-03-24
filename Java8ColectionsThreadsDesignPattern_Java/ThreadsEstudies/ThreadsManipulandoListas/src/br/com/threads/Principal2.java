package br.com.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Principal2 {
	public static void main(String[] args) throws InterruptedException {
		// List<String> lista = new Vector<String>();
		Lista lista = new Lista();

		for (int i = 0; i < 10; i++) {
			new Thread(new tarefaAdicionarElemento(lista, i)).start();
		}
 		
		new Thread(new TarefaImprimir(lista)).start();;
	
	}
}
