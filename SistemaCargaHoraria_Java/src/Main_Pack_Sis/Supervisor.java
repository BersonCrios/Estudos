package Main_Pack_Sis;

public class Supervisor {
	String nome;
	String Cpf;
	String Matricula;
	String Cargo;
	
	public String getNome(){
		return nome;
	}
	public String getCpf(){
		return Cpf;
	}
	public String getMatricula(){
		return Matricula;
	}
	public String getCargo(){
		return Cargo;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	public void setCpf(String Cpf){
		this.Cpf = Cpf;
	}
	public void setMatricula(String Matricula){
		this.Matricula = Matricula;
	}
	public void setCargo(String Cargo){
		this.Cargo = Cargo;
	}
	
}
