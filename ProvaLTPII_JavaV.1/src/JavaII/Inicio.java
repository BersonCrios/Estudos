package JavaII;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.print.DocFlavor.URL;
import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.net.*;
import java.util.Scanner;

class Janela extends JFrame implements ActionListener{
	
	/* Espaço para declarações */
		JMenuBar barraMenu = null; // barra onde são colocados os icones de menu
		JMenu  menuInicio = null; // Menu que redireciona ao inicio
		JMenu menuGerenciaProduto = null; // Menu que contem itens
		JMenu menuAjuda = null; // Menu que contem itens
		
		//Itens de Gerencia Produto
			JMenuItem addProduto = null;
			JMenuItem rmvProduto = null;
			JMenuItem altProduto = null;
		//fim itens gerencia produto
			
		//Itens de sobre
			JMenuItem sobre = null;
		//fim itens sobre	
			
		/*Declaração(instancia) das classes das outrs janelas*/
			AdicionarProduto adicionaProduto = null;
			AlterarProduto alteraProduto  = null;
			RemoverProduto removerProduto = null;
			Sobre sbre = null;
		/*Fim Declaração(instancia ) das classes das outrs janelas*/	
	/* Fim do espaço para declarações*/
	
	/**
	 * Método onde se cria funções que aplica 
	 * eventos a itens de janela
	 * **/
	public void actionPerformed(ActionEvent evento) {		
		 if( evento.getSource() == addProduto){
			 adicionaProduto.setVisible(true);
		}
		 else if( evento.getSource() == altProduto){
			 alteraProduto.setVisible(true);
		}
		 else if( evento.getSource() == rmvProduto){
			 removerProduto.setVisible(true);
		}
		 else if( evento.getSource() == sobre){
			 sbre.setVisible(true);
		}
	}
	
	/**
	 * Janela em si, onde é aplicada todos os componentes visuais**/
	public Janela(){
		/*Config janela*/
		setTitle("Inicio - LOJAVA");//titulo da janela
		setSize(600,600);//tamanho da janela(x,y)
		setLocation(500,100);//Localização na tela(x,y)(meno é pra cima e mais e pa baixo no exo y)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Para o processo após fechar
		setLayout(new BorderLayout());//seta o layout da janela
		/*Fim config janela*/
		
		/*Muda o icone da aplicação*/
		java.net.URL iconesoftware = this.getClass().getResource("icone.png");
		Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(iconesoftware);
		this.setIconImage(imagemTitulo);
		/*Fim Muda o icone da aplicação*/	
		
		/*Instaciando barra de menu com Itens*/
			barraMenu = new JMenuBar();
			setJMenuBar(barraMenu);
			
			menuInicio = new JMenu("Inicio");
			menuGerenciaProduto = new JMenu("Gerenciar Produtos");
			menuAjuda = new JMenu("Ajuda");
			
			addProduto = new JMenuItem("Adicionar Produto");
			rmvProduto = new JMenuItem("Remover Produto");
			altProduto = new JMenuItem("Alterar Produto");
			sobre = new JMenuItem("Sobre");
			
			adicionaProduto = new AdicionarProduto();
			alteraProduto = new AlterarProduto();
			removerProduto = new RemoverProduto();
		/*Fim Instaciando barra de menu com Itens*/
		
		/*Adiciona cada um em seu lugar*/
			barraMenu.add(menuInicio);
			barraMenu.add(menuGerenciaProduto);
			barraMenu.add(menuAjuda);
			
			menuGerenciaProduto.add(addProduto);
			menuGerenciaProduto.add(altProduto);
			menuGerenciaProduto.add(rmvProduto);
			menuAjuda.add(sobre);
		/*Fim Adiciona cada um em seu lugar*/	
		
		/*Adiciona componete aa lista de ações*/
			addProduto.addActionListener(this);
			rmvProduto.addActionListener(this);
			altProduto.addActionListener(this);
			sobre.addActionListener(this);
		/*Fim Adiciona componete aa lista de ações*/
			
		 setVisible(true);//Mostra a janela na tela
		
	}
	
}


/**
 * classe Principal onde a janela é chamada com 
 * todas as funcionalidades**/
public class Inicio {
	public static void main(String[]args) {   
		new Janela();
}
}
