package Main_Pack_Sis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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


public class  EditarEstagiario extends JFrame implements ActionListener {

	JButton back = null;
	
	//atributos
			private String url = "jdbc:mysql://localhost/CargaHorariaEstagio?useSSl=false";
			private String Usuario = "root";
			private String Senha = "";
			private String sql = "select idEstagiario,Matricula,Nome,Cpf,ChDiaria,Horas,Dias,idSupervisor, DataInicio,DataFim from Estagiario";
			private CamadaBancoDados banco = null;
			
			
			JLabel Cpf = null;
			JLabel Nome = null;
			JLabel ChDiaria = null;
			JLabel Horas = null;
			JLabel Dias = null;
			
			JTextField  CpfCampo = null;
			JTextField  NomeCampo = null;
			JTextField  ChDiariaCampo = null;
			JTextField  HorasCampo = null;
			JTextField  DiasCampo = null;
			
			JButton Atualizar = null;
			
			Estagiario est = new Estagiario();
			
	public void actionPerformed(ActionEvent events) {
		if(events.getSource() == back){
			try {
				new JanelaEstagiario().show();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			this.dispose();
		}
		
		else if(events.getSource() == Atualizar){
			String Cpf = CpfCampo.getText();		
			est.setCpf(Cpf);
			
			String nome = NomeCampo.getText();
			String ChDiaria =  ChDiariaCampo.getText();
			String Horas =  HorasCampo.getText();
			String Dias =  DiasCampo.getText();
			
			int ChDiariaInt = Integer.parseInt(ChDiaria);
			int HorasInt = Integer.parseInt(Horas);
			int DiasInt = Integer.parseInt(Dias);
			
			est.setNome(nome);
			est.setChDiaria(ChDiariaInt);
			est.setHoras(HorasInt);
			est.setDias(DiasInt);
			
			banco.atualizaEstagiario(est);
			
		}
		
	}
	
	public EditarEstagiario () throws SQLException{
		setTitle("SICH - EDITAR ESTAGIÁRIO");
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
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.add(back = new JButton("VOLTAR"));
		buttons.add(Atualizar = new JButton("ATUALIZAR"));
		
		JPanel painelCpf = new JPanel();
		painelCpf.setLayout(new FlowLayout());
		painelCpf.add(Cpf = new JLabel("CPF: "));
		painelCpf.add(CpfCampo = new JTextField(30));
		
		JPanel painelNome = new JPanel();
		painelNome.setLayout(new FlowLayout());
		painelNome.add(Nome = new JLabel("NOME: "));
		painelNome.add(NomeCampo = new JTextField(30));
		
		JPanel painelChDiaria = new JPanel();
		painelChDiaria.setLayout(new FlowLayout());
		painelChDiaria.add(ChDiaria = new JLabel("CH DIARIA: "));
		painelChDiaria.add(ChDiariaCampo = new JTextField(30));
		
		JPanel painelHora = new JPanel();
		painelHora.setLayout(new FlowLayout());
		painelHora.add(Horas = new JLabel("HORAS: "));
		painelHora.add(HorasCampo = new JTextField(30));
		
		JPanel painelDia = new JPanel();
		painelDia.setLayout(new FlowLayout());
		painelDia.add(Dias = new JLabel("DIAS: "));
		painelDia.add(DiasCampo = new JTextField(30));
		
		JPanel painelGeral = new JPanel();
		painelGeral.setLayout(new BorderLayout());
		painelGeral.add(painelCpf, BorderLayout.NORTH);
		painelGeral.add(painelNome, BorderLayout.CENTER);
		painelGeral.add(painelChDiaria, BorderLayout.SOUTH);
		
		
		JPanel painelGeral2 = new JPanel();
		painelGeral2.setLayout(new BorderLayout());
		painelGeral2.add(painelHora, BorderLayout.NORTH);
		painelGeral2.add(painelDia, BorderLayout.CENTER);
		
		
		JPanel painelGlobal = new JPanel();
		painelGlobal.setLayout(new BorderLayout());
		painelGlobal.add(painelGeral, BorderLayout.NORTH);
		painelGlobal.add(painelGeral2, BorderLayout.CENTER);
		
		
		back.addActionListener(this);
		Atualizar.addActionListener(this);
		
		add(painelGlobal, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);
	}
	
}
