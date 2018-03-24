package Main_Pack_Sis;

public class Estagiario {
	
	String Matricula;
	String Nome;
	String Cpf;
	int ChDiaria;
	int Horas;
	int Dias;
	int idSupervisor;
	
	public String getMatricula (){
		return Matricula;
	}
	
	public String getNome (){
		return Nome;
	}
	
	public String getCpf (){
		return Cpf;
	}
	
	public int getChDiaria (){
		return ChDiaria;
	}
	
	public int getHoras (){
		return Horas;
	}
	
	public int getDias (){
		return Dias;
	}
	
	public int getIdSupervisor (){
		return idSupervisor;
	}
	
	public void setMatricula (String nMatricula){
		this.Matricula = nMatricula;
	}
	
	public void setNome (String nNome){
		this.Nome = nNome;
	}
	
	public void setCpf (String nCpf){
		this.Cpf = nCpf;
	}
	
	public void setChDiaria(int nChDiaria){
		this.ChDiaria = nChDiaria;
	}
	
	public void setHoras (int nHoras){
		this.Horas = nHoras;
	}
	
	public void setDias (int nDias){
		this.Dias = nDias;
	}
	
	public void setidSupervisor(int nIdSupervisor){
		this.idSupervisor = nIdSupervisor;
	}
	
}
