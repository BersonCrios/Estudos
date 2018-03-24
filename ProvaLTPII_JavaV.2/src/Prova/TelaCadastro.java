package Prova;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TelaCadastro extends JFrame implements ActionListener {

	File arquivo = new File("");
	
	JLabel Cod = null;
	JLabel Nome = null;
	JLabel Qtd = null;
	JLabel Valor = null;
	JLabel Desc = null;
	
	
	JTextField cod = null;
	JTextField nome = null;
	JTextField qtd = null;
	JTextField valor = null;
	JTextArea desc = null;
	
	
	JButton cancelar = null;
	JButton cadastrar = null;
	
	Product prod = new Product();
	
	ArrayList<Product> produto = null;
	
	public TelaCadastro (){
		setTitle("Cadastrar Produto - Gerênciador de Vendas Intelivendas");
		setSize(600,600);
		setLocation(500,100);
		setLayout(new BorderLayout());	
		
		java.net.URL iconesoftware = this.getClass().getResource("icone.png");
		Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(iconesoftware);
		this.setIconImage(imagemTitulo);	
		
		produto = new ArrayList();
		
		JPanel labels = new JPanel();
		labels.setLayout(new BoxLayout(labels,BoxLayout.Y_AXIS));
		labels.add(Cod = new JLabel("Codigo do Produto: "));
		labels.add(cod = new JTextField());
		labels.add(Nome = new JLabel("Nome: "));
		labels.add(nome = new JTextField());
		labels.add(Qtd = new JLabel("Quantidade: "));
		labels.add(qtd = new JTextField());
		labels.add(Valor = new JLabel("Valor: "));
		labels.add(valor = new JTextField());
		labels.add(Desc = new JLabel("Descrição: "));
		
		
		JPanel campos = new JPanel();
		campos.setLayout(new BoxLayout(campos, BoxLayout.Y_AXIS));
		campos.add(desc = new JTextArea());
		
		
		JPanel botoes = new JPanel();
		botoes.setLayout(new FlowLayout());
		botoes.add(cadastrar = new JButton("CADASTRAR"));
		botoes.add(cancelar = new JButton("CANCELAR"));
		
		
		
		
		add(labels, BorderLayout.NORTH);
		add(campos,BorderLayout.CENTER);
		add(botoes,BorderLayout.SOUTH);
		
	}
	public void actionPerformed(ActionEvent evento) {
		this.dispose();	
		if(evento.getSource() == cadastrar)
		{
			String texto = cod.getText();
			String texto1 = Nome.getText();
			String texto2 = valor.getText();
			String texto3 = desc.getText();
			String texto4 = qtd.getText();
			
			try {
				GerenciadorArquivo.escritor(arquivo.getAbsolutePath() +  "\\file.txt", texto, texto1, texto2, texto3,texto4);
			} catch (IOException e) {
				e.printStackTrace();
			}	

			produto.
			System.out.println(Arrays.toString(produto.toArray()));
		}
		
	}
}
