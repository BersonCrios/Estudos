package br.com.projetobd.bd;

import br.com.Gestao_comercial_WebI.model.Funcionario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import javax.swing.table.AbstractTableModel;

public class CamadaBancoDados extends AbstractTableModel {

    String bancoDados = "jdbc:mysql://localhost/SGC?useSSl=false";

    //referencia para conec��o
    Connection conexao = null;
    //referencia para o objeto consulta
    Statement consulta = null;
    //referencia para o objeto de resultado da consulta
    ResultSet resultado = null;
    //referencia a um objeto meta do banco
    ResultSetMetaData informacoesBanco = null;

    private int numeroDeLinhas;

    //monitora o stts da conx�o com o bd
    private boolean conectaaBaseDados = false;

    PreparedStatement pStatements = null;

    public CamadaBancoDados(String url, String nomedeusuario, String senha, String busca) throws SQLException {
        //conecta ao bd
        conexao = DriverManager.getConnection(bancoDados, "root", "senha");

        /*String query = "INSERT INTO supervisor (Nome,Cpf,Matricula,Cargo) value (?,?,?,?)";
    	pStatements = conexao.prepareStatement(query);*/
        //cria consulta para o construtor    	
        consulta = conexao.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );

        //att stts conex�o com o banco
        conectaaBaseDados = true;

        //config consultae a exeeculta
        setQuery(busca);
    }

    //obtem a classe que representa o tipo de coluna
    public Class getColumnClass(int coluna) throws IllegalStateException {
        //Asseguga que a conexao com o banco esta disponivel
        if (!conectaaBaseDados) {
            throw new IllegalStateException("Nao Conecta com a data Base");
        }
        //determina a classe java Coluna
        try {
            String ClassNome = informacoesBanco.getColumnClassName(coluna + 1);
            //Retorna Objato Classe que representa a classe Nome
            return Class.forName(ClassNome);
        } catch (Exception excessao) {
            excessao.printStackTrace();
        }
        //retorna o objeto da classe
        return Object.class;//se ocorrerem os problrmas acima tipo objeto
    }//fim do metodo getColunaClassse
    
    
        public void buscaFuncionario(Funcionario funcionario) {
        try {
            String query = "SELECT FROM Funcionario (Cpf,senha) value (?,?)";
            pStatements = conexao.prepareStatement(query);
            pStatements.setString(1, funcionario.getCpf());
            pStatements.setString(2, funcionario.getSenha());
            pStatements.executeUpdate();
            pStatements.close();
        } catch (Exception e) {

        }
    }


    @Override
    public int getColumnCount() throws IllegalStateException {
        if (!conectaaBaseDados) {
            throw new IllegalStateException("ERRO CONEXÃO");
        }

        //DETERMINA O NUMERO DE COLUNAS
        try {
            return informacoesBanco.getColumnCount();
        } catch (SQLException sqlExc) {
            sqlExc.printStackTrace();
        }
        return 0;
    }

   

    public String getCollumnName(int coluna) throws IllegalStateException {
        if (!conectaaBaseDados) {
            throw new IllegalStateException("ERRO CONEX�O");
        }

        //determina o nome da coluna
        try {
            return informacoesBanco.getColumnName(coluna + 1);
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }

        return "";
    }

    @Override
    public int getRowCount() throws IllegalStateException {
        if (!conectaaBaseDados) {
            throw new IllegalStateException("ERRO CONEX�O");
        }

        return numeroDeLinhas;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        if (!conectaaBaseDados) {
            throw new IllegalStateException("ERRO CONEX�O");
        }

        try {
            resultado.absolute(linha + 1);
            return resultado.getObject(coluna + 1);
        } catch (SQLException sqlE) {
            sqlE.printStackTrace();
        }
        return "";
    }

    public void setQuery(String busca) throws SQLException, IllegalStateException {
        if (!conectaaBaseDados) {
            throw new IllegalStateException("ERRO CONEX�O");
        }

        resultado = consulta.executeQuery(busca);

        informacoesBanco = resultado.getMetaData();

        resultado.last();

        numeroDeLinhas = resultado.getRow();

        fireTableStructureChanged();
    }

    public void desconectaDaBaseDados() {
        if (conectaaBaseDados) {
            try {
                resultado.close();
                consulta.close();
                conexao.close();
            } catch (SQLException sqlE) {
                sqlE.printStackTrace();
            } finally {
                conectaaBaseDados = false;
            }
        }
    }
}
