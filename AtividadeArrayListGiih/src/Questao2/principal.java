package Questao2;

import java.util.ArrayList;

public class principal {

	public static void main(String[] args) {
		ArrayList<String> dep = new ArrayList<String>();
		dep.add("Giovanna");
		dep.add("Guilherme");
		dep.add("Gominam");
		
		Socio s = new Socio();
		
		s.setNome("Iraneide");
		s.setEndereco("606 Norte");
		s.setDependentes(dep);
		
		s.toString();
	}

}
