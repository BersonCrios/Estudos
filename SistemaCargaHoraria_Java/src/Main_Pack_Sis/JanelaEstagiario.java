package Main_Pack_Sis;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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




public class JanelaEstagiario extends JFrame implements ActionListener {
	
		//atributos
		private String url = "jdbc:mysql://localhost/CargaHorariaEstagio?useSSl=false";
		private String Usuario = "root";
		private String Senha = "";
		private String sql = "select idEstagiario, Nome	,Cpf,ChDiaria,DataInicio, DataFim, Horas, Dias from Estagiario";
		private CamadaBancoDados banco = null;
		
		
		JButton back = null;
			

		JButton criar = null;
		JButton excluir = null;
		JButton editar = null;
		
		JScrollPane barraRolagem = null;
		
		JTable tabela = null;
		
		JanelaIndex JInd = null;
		
		AdicionarEstagiario addEst = new AdicionarEstagiario();
		ExcluirEstagiario excEst = new ExcluirEstagiario();
		EditarEstagiario editEst = new EditarEstagiario();
		
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
			addEst.setVisible(true);
			this.dispose();
		}
		else if(events.getSource() == excluir){
			excEst.setVisible(true);
			this.dispose();
		}
		else if(events.getSource() == editar){
			editEst.setVisible(true);
			this.dispose();
		}
	}
	
	public JanelaEstagiario () throws SQLException{
		setTitle("SICH - ESTAGI�RIO");
		setSize(600, 600);
		setLocation(400, 60);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		/* Muda o icone da aplica��o */
		java.net.URL iconesoftware = this.getClass().getResource("icone.png");
		Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(iconesoftware);
		this.setIconImage(imagemTitulo);
		/* Fim Muda o icone da aplica��o */

		
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
		
		JPanel ListaEstagiarios = new JPanel();
		ListaEstagiarios.setLayout(new BorderLayout());
		ListaEstagiarios.add(tabela, BorderLayout.CENTER);
		ListaEstagiarios.setBorder(BorderFactory.createTitledBorder("Lista de Estagi�rios"));
		barraRolagem = new JScrollPane(ListaEstagiarios);
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new BorderLayout());
		painelBotoes.add(botoes, BorderLayout.NORTH);
		painelBotoes.add(botoes2, BorderLayout.CENTER);
		painelBotoes.setBorder(BorderFactory.createTitledBorder("Op��es de Estagi�rio"));
		
		add(buttonback, BorderLayout.SOUTH);
		add(painelBotoes, BorderLayout.NORTH);
		add(ListaEstagiarios, BorderLayout.CENTER);
		//this.add(barraRolagem, BorderLayout.CENTER);
		
		
		
		back.addActionListener(this);
		criar.addActionListener(this);
		excluir.addActionListener(this);
		editar.addActionListener(this);
	}
	
}
