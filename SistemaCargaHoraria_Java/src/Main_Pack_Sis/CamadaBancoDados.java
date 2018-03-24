package Main_Pack_Sis;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import javax.swing.table.AbstractTableModel;



public class CamadaBancoDados extends AbstractTableModel {
	
	 String bancoDados = "jdbc:mysql://localhost/CargaHorariaEstagio?useSSl=false";
	 
	 //referencia para conecção
    Connection conexao = null;
    //referencia para o objeto consulta
    Statement consulta = null;
    //referencia para o objeto de resultado da consulta
    ResultSet resultado = null;
    //referencia a um objeto meta do banco
    ResultSetMetaData informacoesBanco = null;
    
    private int numeroDeLinhas;
 
    //monitora o stts da conxão com o bd
    private boolean conectaaBaseDados = false;
    
    
    PreparedStatement pStatements = null;
    
    public CamadaBancoDados( String url , String nomedeusuario, String senha ,String busca)throws SQLException{
    	//conecta ao bd
    	conexao = DriverManager.getConnection(bancoDados, "root", "");
    	
    	/*String query = "INSERT INTO supervisor (Nome,Cpf,Matricula,Cargo) value (?,?,?,?)";
    	pStatements = conexao.prepareStatement(query);*/
    	
    	//cria consulta para o construtor    	
    	consulta = conexao.createStatement(
    		ResultSet.TYPE_SCROLL_INSENSITIVE,
    		ResultSet.CONCUR_READ_ONLY
    	);
    	
    	//att stts conexão com o banco
    	
    	conectaaBaseDados = true;
    	
    	
    	//config consultae a exeeculta
    	setQuery(busca);   	  	
    }	
    
  //obtem a classe que representa o tipo de coluna
    public Class getColumnClass(int coluna)throws IllegalStateException{
        //Asseguga que a conexao com o banco esta disponivel
        if(!conectaaBaseDados){
            throw new IllegalStateException("Nao Conecta com a data Base");
        }
        //determina a classe java Coluna
        try{
            String ClassNome = informacoesBanco.getColumnClassName(coluna + 1);
            //Retorna Objato Classe que representa a classe Nome
            return Class.forName(ClassNome);
        }
        catch(Exception excessao){
            excessao.printStackTrace();
        }
        //retorna o objeto da classe
        return Object.class;//se ocorrerem os problrmas acima tipo objeto
    }//fim do metodo getColunaClassse
    

	@Override
	public int getColumnCount() throws IllegalStateException {
		if(!conectaaBaseDados){
			throw new IllegalStateException("ERRO CONEXÃO");
		}
		
		//DETERMINA O NUMERO DE COLUNAS
		
		try{
			return informacoesBanco.getColumnCount();
		}
		catch(SQLException sqlExc){
			sqlExc.printStackTrace();
		}
		return 0;
	}
	
	/*
	 * Operações de querry para supervisor
	 * */
	public void insereSupervisor (Supervisor supervisor){
		try{
			String query = "INSERT INTO supervisor (Nome,Cpf,Matricula,Cargo) value (?,?,?,?)";
	    	pStatements = conexao.prepareStatement(query);
			pStatements.setString(1, supervisor.getNome());
			pStatements.setString(2, supervisor.getCpf());
			pStatements.setString(3, supervisor.getMatricula());
			pStatements.setString(4, supervisor.getCargo());
			pStatements.executeUpdate();
			pStatements.close();
		}
		catch(Exception e){
			
		}
	}
	
	public void deletaSupervisor(Supervisor supervisor){
		try{
			String query = "DELETE FROM supervisor where Cpf = ?";
	    	pStatements = conexao.prepareStatement(query);
	    	pStatements.setString(1, supervisor.getCpf());
	    	pStatements.execute();
	    	pStatements.close();
			
		}
		catch(Exception e){
			
		}
	}
	
	public void atualizaSupervisor(Supervisor supervisor) {

		try{
			String query = "UPDATE supervisor SET Nome = ? , Cargo = ?  WHERE Cpf = ?";
			pStatements = conexao.prepareStatement(query);
			pStatements.setString(1, supervisor.getNome()); 
			pStatements.setString(2, supervisor.getCargo()); 
			pStatements.setString(3, supervisor.getCpf()); 
	    	pStatements.execute();
	    	pStatements.close();
			
		}
		catch(Exception e){
			
		}
    }
	
	/*
	 * Operações de querry para estagiário
	 * */
	public void insereEstagiario (Estagiario estagiario){
		try{
			String query = "INSERT INTO estagiario (Matricula,Nome,Cpf,ChDiaria,Horas,Dias,idSupervisor) value (?,?,?,?,?,?,?)";
	    	pStatements = conexao.prepareStatement(query);
	    	pStatements.setString(1, estagiario.getMatricula());
	    	pStatements.setString(2, estagiario.getNome());
	    	pStatements.setString(3, estagiario.getCpf());
	    	pStatements.setInt(4, estagiario.getChDiaria());
	    	pStatements.setInt(5, estagiario.getHoras());
	    	pStatements.setInt(6, estagiario.getDias());
	    	pStatements.setInt(7, estagiario.getIdSupervisor());
	    	pStatements.executeUpdate();
	    	pStatements.close();
		}
		catch(Exception e){
			
		}
	}
	
	public void deletaEstagiario(Estagiario estagiario){
		try{
			String query = "DELETE FROM estagiario where Cpf = ?";
	    	pStatements = conexao.prepareStatement(query);
	    	pStatements.setString(1, estagiario.getCpf());
	    	pStatements.execute();
	    	pStatements.close();
			
		}
		catch(Exception e){
			
		}
	}
	
	public void atualizaEstagiario(Estagiario estagiario) {

		try{
			String query = "UPDATE estagiario SET Nome = ? , ChDiaria = ?, Horas = ?, Dias = ?  WHERE Cpf = ?";
			pStatements = conexao.prepareStatement(query);
			pStatements.setString(1, estagiario.getNome()); 
			pStatements.setInt(2, estagiario.getChDiaria()); 
			pStatements.setInt(3, estagiario.getHoras());
			pStatements.setInt(4, estagiario.getDias());
			pStatements.setString(5, estagiario.getCpf());
	    	pStatements.execute();
	    	pStatements.close();
			
		}
		catch(Exception e){
			
		}
		
    }
	
	
	
	
	
	
	public String getCollumnName(int coluna) throws IllegalStateException{
		if(!conectaaBaseDados){
			throw new IllegalStateException("ERRO CONEXÃO");
		}
		
		//determina o nome da coluna
		try{
			return informacoesBanco.getColumnName(coluna + 1);
		}
		catch(SQLException sqlE){
			sqlE.printStackTrace();
		}
		
		return "";
	}
	
	@Override
	public int getRowCount() throws IllegalStateException {
		if(!conectaaBaseDados){
			throw new IllegalStateException("ERRO CONEXÃO");
		}
		
		return numeroDeLinhas;
	}
	
	

	@Override
	public Object getValueAt(int linha, int coluna) {
		if(!conectaaBaseDados){
			throw new IllegalStateException("ERRO CONEXÃO");
		}
		
		try{
			resultado.absolute(linha + 1);
			return resultado.getObject(coluna+1);
		}
		catch(SQLException sqlE){
			sqlE.printStackTrace();
		}
		return "";
	}
	
	public void setQuery(String busca) throws SQLException, IllegalStateException{
		if(!conectaaBaseDados){
			throw new IllegalStateException("ERRO CONEXÃO");
		}
		
		resultado = consulta.executeQuery(busca);
		
		informacoesBanco = resultado.getMetaData();
		
		resultado.last();
		
		numeroDeLinhas = resultado.getRow();
		
		fireTableStructureChanged();
	}
	
	public void desconectaDaBaseDados(){
		if(conectaaBaseDados){
			try{
				resultado.close();
				consulta.close();
				conexao.close();
			}
			catch(SQLException sqlE){
				sqlE.printStackTrace();
			}
			finally{
				conectaaBaseDados = false;
			}
		}
	}
}
