package classe;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import classe.Pessoa;

public class Candidato extends Pessoa{
	
	
	private int numero;
	private String nomePartido;
	private Pessoa nome;
	
	
	
	public void salvarDados(String string, String string2, String string3) throws IOException {
		
		FileWriter arquivoFisico = new FileWriter("Candidatos.txt", true);
		PrintWriter arqLog = new PrintWriter(arquivoFisico);
		
		arqLog.printf("%s;%s;%s\n", string, string2, string3);
		
		arqLog.close();
		arquivoFisico.close();
		}
	
	
	public String getNomePartido() {
		return nomePartido;
	}


	public void setNomePartido(String nomePartido) {
		this.nomePartido = nomePartido;
	}


	


	public void setNome(Pessoa nome) {
		this.nome = nome;
	}


	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

}

