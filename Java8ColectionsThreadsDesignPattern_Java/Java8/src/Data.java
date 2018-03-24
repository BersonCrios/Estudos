import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Data {
	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		
		
		System.out.println(hoje);
		LocalDate meuAniversario2018 = LocalDate.of(2018, Month.APRIL, 27);
		
		
		
		System.out.println("___________________________________________________");
		
		
		
		int anosFaltam = meuAniversario2018.getYear() - hoje.getYear();
		System.out.println(anosFaltam);
		
		
		
		System.out.println("___________________________________________________");

		
		
		Period periodo = Period.between(hoje, meuAniversario2018);
		System.out.println(periodo.getMonths() + " Mêses " + periodo.getDays() + " Dias ");
		
		
		
		System.out.println("___________________________________________________");
		
		
		
		DateTimeFormatter formatador  = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataMeuAniversarioFormatado = meuAniversario2018.format(formatador);
		System.out.println("Sem formatar: " + meuAniversario2018);		
		System.out.println("Com formatação: " + dataMeuAniversarioFormatado);
		
	}
}
