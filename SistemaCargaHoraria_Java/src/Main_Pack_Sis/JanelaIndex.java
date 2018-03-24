package Main_Pack_Sis;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;


public class JanelaIndex extends JFrame implements ActionListener {
	
	JLabel texto = null;
	
	//Componentes Barra de Menu
	JMenuBar menuBar = null;
	JMenu ajuda = null;
	JMenuItem sobre = null;
	//Componentes Botão
	JButton estagiario = null;
	JButton supervisor = null;
	//Instancia da classe janela para estagiário e supervisor
	JanelaSupervisor JSup = new JanelaSupervisor();
	JanelaEstagiario JEst = new JanelaEstagiario();
	Sobre jsobre = new Sobre();
	//Metódo de  eventos de click
	public void actionPerformed(ActionEvent events) {
		if(events.getSource() == estagiario){
			try{
			JEst.setVisible(true);
			this.dispose();
			}
			catch(Exception e){
				
			}
		}
		else if(events.getSource() == supervisor){
			try{
			JSup.setVisible(true);
			this.dispose();
			}
			catch(Exception e){
				
			}
		}
		else if(events.getSource() == ajuda){
			jsobre.setVisible(true);
			this.dispose();
		}
	}
	
	public JanelaIndex () throws SQLException{
		setTitle("SICH - INÍCIO");
		setSize(600, 600);
		setLocation(400, 60);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		
		/* Muda o icone da aplicação */
		java.net.URL iconesoftware = this.getClass().getResource("icone.png");
		Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(iconesoftware);
		this.setIconImage(imagemTitulo);
		/* Fim Muda o icone da aplicação */

		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		ajuda = new JMenu("Sobre");
		
		texto = new JLabel("<html><p>SISTEMA DE CARGA</p><p>HORÁRIA DE ESTÁGIO</p></html>", SwingConstants.CENTER);
		texto.setFont(new Font("Dialog", Font.BOLD, 30));
		texto.setForeground(Color.BLUE);
		texto.setBorder(BorderFactory.createTitledBorder(""));
		
		JPanel botoes = new JPanel();
		botoes.setLayout(new FlowLayout());
		botoes.add(estagiario = new JButton("  ESTAGIÁRIOS   "));
		estagiario.setPreferredSize(new Dimension(400,70));
		
		
		
		JPanel botoes2 = new JPanel();
		botoes2.setLayout(new FlowLayout());
		botoes2.add(supervisor = new JButton("SUPERVISORES"));
		supervisor.setPreferredSize(new Dimension(400,70));

		JPanel painel1 = new JPanel();
		painel1.setLayout(new BorderLayout());
		painel1.add(botoes, BorderLayout.CENTER);
		painel1.add(botoes2, BorderLayout.NORTH);
		
		
		menuBar.add(ajuda);
		
		ajuda.addActionListener(this);
		estagiario.addActionListener(this);
		supervisor.addActionListener(this);
		
		this.add(painel1, BorderLayout.SOUTH);

		this.add(texto, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public static void main(String [] args){
		try{
			new JanelaIndex();
		}
		catch(Exception e){
			
		}
	}
}
