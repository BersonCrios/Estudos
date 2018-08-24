package Questao3;

import java.util.ArrayList;
import java.util.Scanner;

public class principal {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Scanner sc = new Scanner(System.in);
		int opt = 0;
		
		ArrayList<Contato> contatos = new ArrayList<Contato>();
		
		while(opt != 4) {
			String nome, endereco, telefone, email;

			System.out.println("### MENU ### \n 1-Add Contato \n 2-Remover Contato \n 3-Consultar Contato \n 4-Sair \n ----------------");
			System.out.println("Escolha uma Opção: ");
			opt = sc.nextInt();
			
			switch (opt) {
			case 1:
				Contato c = new Contato();
				System.out.println("Insira os dados: ");
				nome = sc.nextLine();
				
				System.out.print("Nome: ");
				nome = sc.nextLine();
				
				System.out.print("Endereço: ");
				endereco = sc.nextLine();

				System.out.print("telefone: ");
				telefone = sc.nextLine();
				
				System.out.print("Email: ");
				email = sc.nextLine();
				
				c.setNome(nome);
				c.setEndereco(endereco);
				c.setEmail(email);
				c.setTelefone(telefone);
				
				contatos.add(c);
				break;
			case 2:
				System.out.println(" ");
				endereco = sc.nextLine();
				System.out.print("Nome: ");
				nome = sc.nextLine();
				
				for (int i = 0; i < contatos.size(); i++) {
				    if (contatos.get(i).getNome().equals(nome)) {
				    	contatos.remove(i);
				    }
				  }
				break;
			case 3:
				System.out.println("-------MEUS CONTATOS---------");
				Contato con;
				for (int i = 0; i < contatos.size(); i++) {
					con = contatos.get(i);
					System.out.println("Nome: "+ con.getNome());
					System.out.println("Endereço: "+ con.getEndereco());
					System.out.println("Telefone: "+ con.getTelefone());
					System.out.println("Email: "+ con.getEmail());

					System.out.println("-------------------");
				}
				break;
			}
		}
		
	}

}
