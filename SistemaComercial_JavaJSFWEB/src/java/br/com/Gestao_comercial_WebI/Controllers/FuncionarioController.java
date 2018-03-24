/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Gestao_comercial_WebI.Controllers;


import br.com.Gestao_comercial_WebI.model.Funcionario;
import br.com.projetobd.bd.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author berson
 */
@ManagedBean
@ApplicationScoped

public class FuncionarioController {

    private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private Funcionario funcionario = new Funcionario();
    private Connection conn;
    private Statement comando;

    public FuncionarioController() {
        buscarTodos();
    }

    public String adicionarFuncionario() {
        this.funcionarios.add(getFuncionario());
        this.funcionario = new Funcionario();
        FacesMessage mensagem = new FacesMessage("Funcionario Adicionado com sucesso!!!");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
        return "funcionarios";
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public String login() throws SQLException {
        this.conn = Conexao.getConexao();
        Statement st = this.conn.createStatement();
        String sql = "SELECT * FROM funcionario WHERE cpf = '"
                + funcionario.getCpf() + "' AND senha = '" + funcionario.getSenha() + "'";
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            Funcionario temp = new Funcionario();

            temp.setNome(rs.getString("nome"));
            temp.setCpf(rs.getString("cpf"));
            temp.setRg(rs.getInt("rg"));
            temp.setFuncao(rs.getInt("funcao"));
            temp.setSenha(rs.getString("senha"));
            funcionarios.add(temp);
            FacesMessage msg = new FacesMessage("SEJA BEM VINDO AO SISTEMA " + funcionario.getCpf());
            FacesContext.getCurrentInstance().addMessage("Success: ", msg);
            return "Dashboard";
        } else {
            FacesMessage msg = new FacesMessage("Usuário ou senha Invalidos!");
            FacesContext.getCurrentInstance().addMessage("Erro: ", msg);
            return "index";
        }
    }
    
    public String editAction(Funcionario funcionario) {

	funcionario.setEditable(true);
	return null;
    }

    	public String saveAction() {
		
                 Funcionario f = new Funcionario();
                 
		for (Funcionario func : funcionarios){
			func.setEditable(false);
                         
            f.setNome(func.getNome());
            f.setCpf(func.getCpf());
            f.setRg(func.getRg());
            f.setFuncao(func.getFuncao());
                        
		}
		return null;

	}
    
    public String Logout() {
        return "index";
    }
    
     public String apagar() {
        conectar();
        try {
            comando.executeUpdate("DELETE FROM funcionario WHERE Cpf = '" + funcionario.getCpf()
                    + "';");
            FacesMessage mensagem = new FacesMessage("Funcionario Exluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
            buscarTodos();
            return "funcionarios.xhtml";
        } catch (SQLException e) {
            e.printStackTrace();
            FacesMessage mensagem = new FacesMessage("Não foi possivel excluir o Funcionario!");
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
            return "ExcluirFuncionario.xhtml";
        } finally {
            fechar();
        }
    }

      public String apagarPorId(int funcId) {
        conectar();
        try {
            String sql = "DELETE FROM funcionario WHERE idfuncionario = '" +funcId+ "';";
            comando.execute(sql);
            FacesMessage mensagem = new FacesMessage("Funcionario Exluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
            buscarTodos();
            System.out.println(sql);
            return "funcionarios.xhtml";
        } catch (SQLException e) {
            e.printStackTrace();
            FacesMessage mensagem = new FacesMessage("Não foi possivel excluir o Funcionario!");
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
            return "funcionarios.xhtml";
        } finally {
            fechar();
        }
    }
        
    public void buscarTodos() {
        conectar();
        ResultSet rs;
        funcionarios = new ArrayList<>();
        try {
            rs = comando.executeQuery("SELECT * FROM funcionario");
            while (rs.next()) {
                Funcionario temp = new Funcionario();
                temp.setIdfuncionario(rs.getInt("idfuncionario"));
                temp.setNome(rs.getString("nome"));
                temp.setSenha(rs.getString("senha"));
                temp.setCpf(rs.getString("cpf"));
                temp.setRg(rs.getInt("rg"));
                temp.setFuncao(rs.getInt("funcao"));

                funcionarios.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar() {
        conectar();
            String com = "UPDATE funcionario SET nome = '" + funcionario.getNome()
            + "', cpf =" + funcionario.getCpf() +"';";       
            
        try {
            comando.executeUpdate(com);
            FacesMessage mensagem = new FacesMessage("Funcionario alterado com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
            System.out.println(com);
        } catch (SQLException e) {
            e.printStackTrace();
            FacesMessage mensagem = new FacesMessage("Impossivel alterar funcionario!");
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
            System.out.println(com);
        } finally {
            fechar();
        }
    }
    
    public void atualizarPorId() {  
      conectar();  
      String com = "UPDATE funcionario SET nome = '" + funcionario.getNome()
            + "', cpf ='" + funcionario.getCpf() + "' WHERE ='"+funcionario.getIdfuncionario()+"';"; 
      System.out.println(com);  
      try {  
         comando.executeUpdate(com);  
         buscarTodos();
      } catch (SQLException e) {  
         e.printStackTrace();  
      } finally {  
         fechar();  
      }  
   }  

    

    public void insere() {
        conectar();

        try {
            comando.executeUpdate("INSERT INTO Funcionario VALUES('" + funcionario.getIdfuncionario() + "', '"
                    + funcionario.getNome() + "', '" + funcionario.getSenha() + "' , '" + funcionario.getCpf() + "' ,"
                    + " '" + funcionario.getRg() + "' , '" + funcionario.getFuncao() + "')");

            setFuncionario(new Funcionario());
            buscarTodos();
            FacesMessage mensagem = new FacesMessage("Funcionario Adicionado com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
        } catch (SQLException e) {
            e.printStackTrace();
            FacesMessage mensagem = new FacesMessage("Não foi possivel adicionar o Funcionario!");
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
        } finally {
            fechar();
        }

    }

    private void conectar() {
        try {
            conn = Conexao.getConexao();
            comando = conn.createStatement();
            System.out.println("Conectado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fechar() {
        try {
            comando.close();
            conn.close();
            System.out.println("Conexão Fechada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
