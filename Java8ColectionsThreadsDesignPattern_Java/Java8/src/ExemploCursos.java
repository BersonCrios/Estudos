import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Curso {
	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}

}

public class ExemploCursos {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();

		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		cursos.sort(Comparator.comparing(c -> c.getAlunos()));

		cursos.forEach(C -> System.out.println(C.getNome()));

		System.out.println("___________________________________________________");

		cursos.stream().filter(c -> c.getAlunos() >= 100).forEach(C -> System.out.println(C.getNome()));

		System.out.println("___________________________________________________");

		cursos.stream().filter(c -> c.getAlunos() >= 100).map(c -> c.getAlunos())
				.forEach(total -> System.out.println(total));

		System.out.println("___________________________________________________");

		int sum = cursos.stream().filter(c -> c.getAlunos() >= 100).mapToInt(c -> c.getAlunos()).sum();

		System.out.println(sum);

		System.out.println("___________________________________________________");

		cursos.stream().filter(c -> c.getAlunos() >= 100).findAny().ifPresent(c -> System.out.println(c.getNome()));

		System.out.println("___________________________________________________");

		OptionalDouble media = cursos.stream().filter(c -> c.getAlunos() >= 100).mapToInt(c -> c.getAlunos()).average();
		
		System.out.println(media);
		
		System.out.println("___________________________________________________");

		cursos = cursos.stream()
		.filter(c->c.getAlunos() >= 100)
		.collect(Collectors.toList());
		
		cursos.forEach(c -> System.out.println(c.getNome()));
		
		System.out.println("___________________________________________________");
		

	}
}
