package Prova;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GerenciadorArquivo {

	public static String leitor(String path) {
		String retorno = "<html>";
		try {
			BufferedReader buffRead = new BufferedReader(new FileReader(path));
			String linha = "";
			boolean condicao = true;
			while (condicao) {
				if (linha != null) {
					retorno += linha + "<br/>";
				} else
					condicao = false;
				linha = buffRead.readLine().toUpperCase();
			}
			buffRead.close();

		} catch (Exception e) {
		}
		return retorno += "</html>";
	}

	// Função que escreve no arquivo
	public static void escritor(String path, String cod,String Nome, String valor, String desc, String qtd) throws IOException {
		FileWriter buffWrite = new FileWriter(path, true);
		buffWrite.write(cod + ";" + Nome + ";" + valor + ";" + desc + ";" + qtd + ";"  + "\n");
		buffWrite.flush();
		buffWrite.close();
	}
}
