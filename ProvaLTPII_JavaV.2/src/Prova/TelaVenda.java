package Prova;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaVenda extends JFrame implements ActionListener {

	
	public TelaVenda (){
		setTitle("Venda em andamento - Gerênciador de Vendas Intelivendas");
		setSize(600,600);
		setLocation(500,100);
		setLayout(new BorderLayout());		
		
		java.net.URL iconesoftware = this.getClass().getResource("icone.png");
		Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(iconesoftware);
		this.setIconImage(imagemTitulo);		
		
	}
	public void actionPerformed(ActionEvent evento) {
		this.dispose();		
	}
}
