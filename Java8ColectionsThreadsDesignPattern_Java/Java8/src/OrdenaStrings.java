import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();

		palavras.add("Alura Online");
		palavras.add("Editora Casa do Código");
		palavras.add("Caelum");

		/*palavras.sort((s1, s2) -> {
				if (s1.length() < s2.length()) {
					return -1;
				}
				if (s1.length() > s2.length()) {
					return 1;
				}

				return 0;
		});*/
		
		
		/*palavras.sort((s1, s2) -> {
			return Integer.compare(s1.length(),s2.length());
		});
		*/
		
		/*palavras.sort(Comparator.comparing(s -> s.length()));*/
		
		palavras.sort(Comparator.comparing(String::length));
		
		System.out.println(palavras);

		System.out.println("__________________________________________________________");

		for (String p : palavras) {
			System.out.println(p);
		}

		System.out.println("__________________________________________________________");

		palavras.forEach(p -> {
			System.out.println("Sem Classe Anônoma: "+p);
		});

		System.out.println("__________________________________________________________");

		palavras.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println("Com Classe Anonima: " + s);
			}
		});
	}
}