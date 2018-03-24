package JavaII;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AlterarProduto extends JFrame implements ActionListener {
	
	public AlterarProduto (){
		setTitle("Alterar Produto - LOJAVA");
		setSize(600,600);
		setLocation(500,100);//Localização na tela(x,y)(meno é pra cima e mais e pa baixo no exo y)
		setLayout(new BorderLayout());
	
		
		/*Muda o icone da aplicação*/
		java.net.URL iconesoftware = this.getClass().getResource("icone.png");
		Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(iconesoftware);
		this.setIconImage(imagemTitulo);
		/*Fim Muda o icone da aplicação*/	

		
	}
	public void actionPerformed(ActionEvent evento) {
		this.dispose();		
	}
}
