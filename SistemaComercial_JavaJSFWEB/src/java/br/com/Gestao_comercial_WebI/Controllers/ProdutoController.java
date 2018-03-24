/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Gestao_comercial_WebI.Controllers;

import br.com.Gestao_comercial_WebI.model.Funcionario;
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

public class ProdutoController {

    private List<Produto> produtos = new ArrayList<Produto>();
    private Produto produto = new Produto();
    private Connection conn;
    private Statement comando;
    
    public ProdutoController(){
        buscarTodos();
    }
    
    public String adicionarProduto(){
        this.produtos.add((Produto) getProduto());
        this.produto = new Produto();
        FacesMessage mensagem = new FacesMessage("Produto Adicionado com sucesso!!!");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
        return "produtos";
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
     public String editAction(Produto produto) {

	produto.setEditable(true);
	return null;
    }

    	public String saveAction() {
		
                 Produto p = new Produto();
                 
		for (Produto produto : produtos){
			produto.setEditable(false);        
		}
		return null;

	}
    public String Vender() {  
      conectar();  
     
      return "";
   }  
    
    
     public String apagar() {  
      conectar();  
      try {  
            comando.executeUpdate("DELETE FROM produto WHERE codigoBarra = '" + produto.getCodigoBarra()
                     + "';");  
             FacesMessage mensagem = new FacesMessage("Produto Exluido com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
        buscarTodos();
        return "produtos";
      } catch (SQLException e) {  
         e.printStackTrace();  
          FacesMessage mensagem = new FacesMessage("Não foi possivel excluir o Produto!");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
      } finally {  
         fechar();  
      }  
      return null;
   }  
     
      public String apagarPorId(int prodId) {
        conectar();
        try {
            String sql = "DELETE FROM produto WHERE idproduto = '" +prodId+ "';";
            comando.execute(sql);
            FacesMessage mensagem = new FacesMessage("Produto Exluido com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
            buscarTodos();
            System.out.println(sql);
            return "produtos.xhtml";
        } catch (SQLException e) {
            e.printStackTrace();
            FacesMessage mensagem = new FacesMessage("Não foi possivel excluir o produto!");
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
            return "produtos.xhtml";
        } finally {
            fechar();
        }
    }
  
   public void buscarTodos() {  
      conectar();
      ResultSet rs;
      produtos = new ArrayList<>();
      try {  
         rs = comando.executeQuery("SELECT * FROM produto");  
         while (rs.next()) {  
            Produto temp = new Produto();  
            
            temp.setIdproduto(rs.getInt("idproduto"));
            temp.setNome(rs.getString("nome"));
            temp.setValidade(rs.getString("validade"));
            temp.setCodigoBarra(rs.getString("codigoBarra"));
            temp.setPreco(rs.getFloat("preco"));
            temp.setIdFornecedor(rs.getInt("idFornecedor"));
            temp.setQuantidade(rs.getInt("quantidade"));
            
            produtos.add(temp);  
         }   
      } catch (SQLException e) {  
         e.printStackTrace(); 
      }  
   }  
  
   
   public Produto buscarUmProduto(int IdProd) throws SQLException {  
        this.conn = Conexao.getConexao();
        Statement st = this.conn.createStatement();
        String sqlProdu = "SELECT * FROM produto WHERE idproduto = '"+IdProd+"';";
        ResultSet rs = st.executeQuery(sqlProdu);
        
         Produto temp = new Produto(); 
        
        while (rs.next()) {         
            temp.setIdproduto(rs.getInt("idproduto"));
            temp.setNome(rs.getString("nome"));
            temp.setValidade(rs.getString("validade"));
            temp.setCodigoBarra(rs.getString("codigoBarra"));
            temp.setPreco(rs.getFloat("preco"));
            temp.setIdFornecedor(rs.getInt("idFornecedor"));
            temp.setQuantidade(rs.getInt("quantidade"));
         }
         return temp;
    }       
   
//   public void atualizar() {  
//      conectar();  
//      String com = "UPDATE Funcionarios SET Nome = '" + funcionario.getNome()
//            + "', ID_endereco_FK =" + funcionario.getID_endereco_FK()+ 
//              "', ID_funcao_FK =" + funcionario.getId_funcao_FK()+
//              "', senha =" + funcionario.getSenha()+ "'  ;";  
//      System.out.println("Atualizada!");  
//      try {  
//         comando.executeUpdate(com);  
//      } catch (SQLException e) {  
//         e.printStackTrace();  
//      } finally {  
//         fechar();  
//      }  
//   }  
//  
   public void insere(){  
      conectar();
     
      try {  
        comando.executeUpdate("INSERT INTO produto VALUES('"+produto.getIdproduto()+"', '"  
               + produto.getNome() + "', '" + produto.getValidade() + "' , '" + produto.getCodigoBarra()+ "' , '" + produto.getPreco()+ "' , '" + produto.getQuantidade()+ "' ,'" +  produto.getIdFornecedor() + "')");  
         
        setProduto(new Produto());
        buscarTodos();
        FacesMessage mensagem = new FacesMessage("Produto Adicionado com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);  
      } catch (SQLException e) {  
         e.printStackTrace();  
          FacesMessage mensagem = new FacesMessage("Não foi possivel adicionar o Produto!");
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