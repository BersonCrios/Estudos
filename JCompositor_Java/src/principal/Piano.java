package principal;

import java.util.List;

import org.jfugue.player.Player;

public class Piano {
	public void toca(List<Nota> musica) {
		Player player = new Player();
		
		StringBuilder musicaEmNotas = new StringBuilder();
		
		for (Nota nota : musica) {
			musicaEmNotas.append(nota.simbolo() + " ");
		}
		
		System.out.println(musicaEmNotas.toString());
		player.play(musicaEmNotas.toString());
		
	}
}
