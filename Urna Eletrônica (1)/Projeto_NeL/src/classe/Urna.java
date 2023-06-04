package classe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Urna extends Candidato{
	
	private Candidato candidato;
	private Candidato nomePartido;
	private Eleitor eleitor;
	String pesquisar;
	private int votob;
	private int voton;
	private int voto;
	
	public Candidato getCandidato() {
		return candidato;
	}
	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	public Eleitor getEleitor() {
		return eleitor;
	}
	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	public String getPesquisar() {
		return pesquisar;
	}
	public void setPesquisar(String pesquisar) {
		this.pesquisar = pesquisar;
	}
	public int getVotob() {
		return votob;
	}
	public void setVotob(int votob) {
		this.votob = votob;
	}
	public int getVoton() {
		return voton;
	}
	public void setVoton(int voton) {
		this.voton = voton;
	}
	
	
	public void buscar() throws IOException {
		String linha;
		int posicao;
		
		ArrayList<String> cands = new ArrayList<String>();
		FileReader arquivoFisico = new FileReader("Candidatos.txt");
		BufferedReader arquivoLogico = new BufferedReader(arquivoFisico);
		linha = arquivoLogico.readLine();
		
		
	}

}

