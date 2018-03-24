/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Gestao_comercial_WebI.Controllers;

import br.com.Gestao_comercial_WebI.model.Fornecedor;
import br.com.Gestao_comercial_WebI.model.Produto;
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
import javax.faces.context.FacesContext;

/**
 *
 * @author berson
 */
@ManagedBean
@ApplicationScoped
public class FornecedorController {
    private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
    private Fornecedor fornecedor = new Fornecedor();
    private Connection conn;
    private Statement comando;

     public FornecedorController(){
        buscarTodos();
    }
    
    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
    
     public String apagar() {  
      conectar();  
      try {  
            comando.executeUpdate("DELETE FROM fornecedor WHERE cnpj = '" + fornecedor.getCnpj()
                     + "';");  
             FacesMessage mensagem = new FacesMessage("Fornecedor Exluido com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
        buscarTodos();
        return "Fornecedor.xhtml";
      } catch (SQLException e) {  
         e.printStackTrace();  
          FacesMessage mensagem = new FacesMessage("Não foi possivel excluir o Fornecedor!");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
      } finally {  
         fechar();  
      }  
      return null;
   }  
     
     public String apagarPorId(int fornId) {
        conectar();
        try {
            String sql = "DELETE FROM fornecedor WHERE idfornecedor = '" +fornId+ "';";
            comando.execute(sql);
            FacesMessage mensagem = new FacesMessage("fornecedor Exluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
            buscarTodos();
            System.out.println(sql);
            return "fornecedor.xhtml";
        } catch (SQLException e) {
            e.printStackTrace();
            FacesMessage mensagem = new FacesMessage("Não foi possivel excluir o fornecedor!");
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
            return "fornecedor.xhtml";
        } finally {
            fechar();
        }
    }
  
   public void buscarTodos() {  
      conectar();
      ResultSet rs;
      fornecedores = new ArrayList<>();
      try {  
         rs = comando.executeQuery("SELECT * FROM fornecedor");  
         while (rs.next()) {  
            Fornecedor temp = new Fornecedor();  
            
            temp.setNomeFantasia(rs.getString("nomeFantasia"));
            temp.setRazaoSocial(rs.getString("razaoSocial"));
            temp.setCnpj(rs.getString("cnpj"));
            temp.setIdFornecedor(rs.getInt("idFornecedor"));
            temp.setCep(rs.getString("cep"));
            fornecedores.add(temp);  
         }   
      } catch (SQLException e) {  
         e.printStackTrace(); 
      }  
   }
    
       public void insere(){  
      conectar();
      int cont;
     
      try {  
        comando.executeUpdate("INSERT INTO fornecedor VALUES('"+ fornecedor.getIdFornecedor() +"', '"  
               + fornecedor.getNomeFantasia() + "', '" + fornecedor.getRazaoSocial()+ "' , '" + fornecedor.getCnpj()+ "' , '" + fornecedor.getCep()+ "')");  
         
        setFornecedor(new Fornecedor());
        buscarTodos();
        FacesMessage mensagem = new FacesMessage("Fornecedor Adicionado com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);  
      } catch (SQLException e) {  
         e.printStackTrace();  
          FacesMessage mensagem = new FacesMessage("Não foi possivel adicionar o Fornecedor!");
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
