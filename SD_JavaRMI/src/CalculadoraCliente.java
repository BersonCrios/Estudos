import java.rmi.Naming;
public class CalculadoraCliente {
	public static void main(String[] args) {
		try {
		Calculadora c = (Calculadora) Naming.lookup("rmi://192.168.1.8:1099/CalculadoraService");
		System.out.println("Adiçao : " + c.add(10, 15));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
