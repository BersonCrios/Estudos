/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Gestao_comercial_WebI.Controllers;

import br.com.Gestao_comercial_WebI.model.Funcionario;
import br.com.Gestao_comercial_WebI.model.Produto;
import br.com.Gestao_comercial_WebI.model.Venda;
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
 * @author Berso
 */
@ManagedBean
@ApplicationScoped
public class VendaController {
    private List<Venda> vendas = new ArrayList<Venda>();
    private Venda venda = new Venda();
    private Connection conn;
    private Statement comando;
    
    
      public String adicionarVenda() {
      this.vendas.add(getVenda());
      this.venda = new Venda();
      FacesMessage mensagem = new FacesMessage("venda realizada com sucesso!!!");
      FacesContext.getCurrentInstance().addMessage(null, mensagem);
      return "Vender";
    }
    
    public VendaController() {
        buscarTodos();
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getComando() {
        return comando;
    }

    public void setComando(Statement comando) {
        this.comando = comando;
    }
    
    
    public String vender(){
        conectar();
        ProdutoController prodc = new ProdutoController();     
        return "";
    }
    
    public void insere() {
        conectar();
        try {
            comando.executeUpdate("INSERT INTO venda VALUES('" + venda.getIdvenda() + "', '"
                    + venda.getIdProduto() + "', '" + venda.getQuantidade() + "')");

            setVenda(new Venda());
            buscarTodos();
            FacesMessage mensagem = new FacesMessage("Venda do item realizada com sucesso");
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
        } catch (SQLException e) {
            e.printStackTrace();
            FacesMessage mensagem = new FacesMessage("Não foi possivel vender o item ");
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
        } finally {
            fechar();
        }

    }
    
    public void buscarTodos() {  
      conectar();
      ResultSet rs;
      //String sql = "select nome,quantidade from venda, produto where  venda.idProduto = produto.idproduto;"
      vendas = new ArrayList<>();
       ProdutoController produ = new ProdutoController();
      try {  
         rs = comando.executeQuery("SELECT * FROM venda"); 
         while (rs.next()) {  
            Venda temp = new Venda();  
            
            temp.setIdvenda(rs.getInt("idvenda"));
            temp.setIdProduto(rs.getInt("idProduto"));
            temp.setQuantidade(rs.getInt("quantidade"));
            temp.setProd(produ.buscarUmProduto(rs.getInt("idproduto")));
            vendas.add(temp);  
         }   
      } catch (SQLException e) {  
         e.printStackTrace(); 
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
