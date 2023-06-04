package classe;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {
	

	public void escreve (String texto) throws IOException{
		try {
		PrintWriter arquivo = new PrintWriter(new FileWriter("Candidatos.txt"));

		arquivo.println(texto);
		
		arquivo.close();
		} catch (Exception erro){
			
		}
	}
}
