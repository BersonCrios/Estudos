package Main_Pack_Sis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Sobre  extends JFrame implements ActionListener{

	JButton back = null;
	
	public void actionPerformed(ActionEvent events) {
		if(events.getSource() == back){
			try {
				new JanelaEstagiario().show();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			this.dispose();
		}
	}
	
	public Sobre(){
		setTitle("SICH - SOBRE O PROJETO");
		setSize(600, 600);
		setLocation(400, 60);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		/* Muda o icone da aplicação */
		java.net.URL iconesoftware = this.getClass().getResource("icone.png");
		Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(iconesoftware);
		this.setIconImage(imagemTitulo);
		/* Fim Muda o icone da aplicação */
		
		JLabel texto = new JLabel("<html><p>Trabalho avaliativo de Linguagens e tecnicas de programação</P>"
				+ " <p>Feito pelo aluno Guilherme Taveira Berson, cursando o quarto período de sistemas</p>"
				+ "<p>de informações na Universidade Estadual do Tocantins, Orientado pelo Professor</p>"
				+ "<p>Silvanno Malffatti.</p> </html>");
		texto.setFont(new Font("Dialog", Font.BOLD, 20));

			back = new JButton("VOLTAR");
			
			back.addActionListener(this);
			
			add(texto, BorderLayout.CENTER);
			add(back, BorderLayout.SOUTH);

	}

}
