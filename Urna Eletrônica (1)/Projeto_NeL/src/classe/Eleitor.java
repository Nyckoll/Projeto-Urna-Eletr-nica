package classe;

public class Eleitor extends Pessoa{
	
	//private int id;
	private String cpf;
	private String cep;
	private String rua;
	private String bairro;
	private String numero;
	
	public Eleitor() {
		super();
		this.cpf=cpf;
		this.cep=cep;
		this.rua=rua;
		this.bairro=bairro;
		this.numero=numero;
	
	}
	
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

}
