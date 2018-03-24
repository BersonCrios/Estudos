package principal;

import java.util.HashMap;
import java.util.Map;

import notas.Do;
import notas.Fa;
import notas.La;
import notas.Mi;
import notas.Re;
import notas.Si;
import notas.Sol;

public class NotasMusicais {
	private static Map<String, Nota> notas =  new HashMap<String, Nota>();
	
	static {
		notas.put("do", new Do());
		notas.put("re", new Re());
		notas.put("mi", new Mi());
		notas.put("fa", new Fa());
		notas.put("sol", new Sol());
		notas.put("la", new La());
		notas.put("si", new Si());
	}
	
	public Nota pega(String nome) {
		return notas.get(nome);
	}
}
