import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class CalculadoraServer {
	CalculadoraServer(){
		try {
			System.setProperty("java.rmi.serve.hostname","192.168.1.8");
			LocateRegistry.createRegistry(1099);
			Calculadora c = new CalculadoraImple();
			Naming.bind("CalculadoraService", (Remote) c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new CalculadoraServer();
	}
}
