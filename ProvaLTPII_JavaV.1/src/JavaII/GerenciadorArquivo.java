package JavaII;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GerenciadorArquivo {
	
	public static void leitor(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            if (linha != null) {
                System.out.println(linha);
 
            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
    }
	
	//Função que escreve no arquivo
	  public static void escritor(String path, String linha) throws IOException {
	        FileWriter buffWrite = new FileWriter(path, true);
	        buffWrite.write(linha + "\n");
	        buffWrite.flush();
	        buffWrite.close();
	    }
}
