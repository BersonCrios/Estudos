package Main_Pack_Sis;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JanelaSupervisor extends JFrame implements ActionListener {
	
	//atributos
		private String url = "jdbc:mysql://localhost/CargaHorariaEstagio?useSSl=false";
		private String Usuario = "root";
		private String Senha = "";
		private String sql = "select idSupervisor, Nome,Cpf, Matricula, Cargo from Supervisor";
		private CamadaBancoDados banco = null;
		
		JButton back = null;
		

		JButton criar = null;
		JButton excluir = null;
		JButton editar = null;
		
		JScrollPane barraRolagem = null;
		
		JTable tabela = null;
		
		JanelaIndex JInd = null;
		
		
		AdicionarSupervisor addSup = new AdicionarSupervisor();
		ExcluirSupervisor excSup = new ExcluirSupervisor();
		EditarSupervisor editSup = new EditarSupervisor();
		
		
		public void actionPerformed(ActionEvent events) {
			if(events.getSource() == back){
				try {
					new JanelaIndex().show();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				this.dispose();	
			}
			else if(events.getSource() == criar){
				addSup.setVisible(true);
				this.dispose();
			}			
			else if(events.getSource() == excluir){
				excSup.setVisible(true);
				this.dispose();
			}
			else if(events.getSource() == editar){
				editSup.setVisible(true);
				this.dispose();
			}
		}
		
		
	public JanelaSupervisor () throws SQLException{
		setTitle("SICH - SUPERVISOR");
		setSize(600, 600);
		setLocation(400, 60);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		/* Muda o icone da aplicação */
		java.net.URL iconesoftware = this.getClass().getResource("icone.png");
		Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(iconesoftware);
		this.setIconImage(imagemTitulo);
		/* Fim Muda o icone da aplicação */

		
		banco = new CamadaBancoDados (url,Usuario,Senha,sql);
		
		tabela = new JTable(banco);
		
		JPanel buttonback = new JPanel();
		buttonback.setLayout(new BorderLayout());
		buttonback.add(back = new JButton("Voltar"), BorderLayout.EAST);
		
		JPanel botoes = new JPanel();
		botoes.setLayout(new FlowLayout());
		botoes.add(criar = new JButton("ADICIONAR"));
		criar.setPreferredSize(new Dimension(400,70));
		
		JPanel botoes2 = new JPanel();
		botoes2.setLayout(new FlowLayout());
		botoes2.add(excluir = new JButton("EXCLUIR"));
		botoes2.add(editar = new JButton("EDITAR"));
		excluir.setPreferredSize(new Dimension(200,70));
		editar.setPreferredSize(new Dimension(200,70));
		
		JPanel ListaSupervisores = new JPanel();
		ListaSupervisores.setLayout(new BorderLayout());
		ListaSupervisores.add(tabela, BorderLayout.CENTER);
		ListaSupervisores.setBorder(BorderFactory.createTitledBorder("Lista de Supervisores"));
		barraRolagem = new JScrollPane(ListaSupervisores);
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new BorderLayout());
		painelBotoes.add(botoes, BorderLayout.NORTH);
		painelBotoes.add(botoes2, BorderLayout.CENTER);
		painelBotoes.setBorder(BorderFactory.createTitledBorder("Opções de Supervisor"));
		
		add(buttonback, BorderLayout.SOUTH);
		add(painelBotoes, BorderLayout.NORTH);
		add(ListaSupervisores, BorderLayout.CENTER);
		//this.add(barraRolagem, BorderLayout.CENTER);
		
		back.addActionListener(this);
		criar.addActionListener(this);
		excluir.addActionListener(this);
		editar.addActionListener(this);
		
	}
	
}
