package Prova;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

class Janela extends JFrame implements ActionListener {	

	
	JMenuBar barraMenu = null; 
	JMenu Sistema = null; 
	
	JMenuItem Cadastro = null;
	JMenuItem Venda = null;

	TelaCadastro telaCadastro = null;
	TelaVenda telaVenda = null;
	
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == Cadastro) {
			telaCadastro.setVisible(true);
		} else if (evento.getSource() == Venda) {
			telaVenda.setVisible(true);
		}
	}

	
	public Janela() {
	
		setTitle("Inicio - Gerênciador de Vendas Intelivendas");
		setSize(600, 600);
		setLocation(500, 100);							
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());		
	
		java.net.URL iconesoftware = this.getClass().getResource("icone.png");
		Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(iconesoftware);
		this.setIconImage(imagemTitulo);			

		
		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		
		Sistema = new JMenu("Sistema");
		
		Cadastro = new JMenuItem("Cadastrar Produto");
		Venda = new JMenuItem("Realizar Venda");
		
		telaCadastro = new TelaCadastro();
		telaVenda = new TelaVenda();
		
		barraMenu.add(Sistema);
		
		Sistema.add(Cadastro);
		Sistema.add(Venda);
		
		Cadastro.addActionListener(this);
		Venda.addActionListener(this);
		
		setVisible(true);
	}

}

public class TelaPrincipal {
	public static void main(String[] args) {
		new Janela();
	}
}
