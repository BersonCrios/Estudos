package Main_Pack_Sis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AdicionarEstagiario extends JFrame implements ActionListener {

	//atributos
	private String url = "jdbc:mysql://localhost/CargaHorariaEstagio?useSSl=false";
	private String Usuario = "root";
	private String Senha = "";
	private String sql = "select idEstagiario,Matricula,Nome,Cpf,ChDiaria,Horas,Dias,idSupervisor, DataInicio,DataFim from Estagiario";
	private CamadaBancoDados banco = null;
	
	JButton back = null;
	JButton cadastrar = null;
	JButton limpar = null;
	
	JLabel Matricula = null;
	JLabel Nome = null;
	JLabel Cpf = null;
	JLabel ChDiaria = null;
	JLabel Dias = null;
	JLabel Horas = null;
	JLabel idSupervisor = null;
	
	
	JLabel desc = null;
	
	
	JTextField MatriculaCampo = null;
	JTextField NomeCampo = null;
	JTextField CpfCampo = null;
	JTextField ChDiariaCampo = null;
	JTextField DiasCampo = null;
	JTextField HorasCampo = null;
	JTextField idSupervisorCampo = null;
	
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
		
		else if(events.getSource() == cadastrar){
			String Matricula = MatriculaCampo.getText();
			String nome = NomeCampo.getText();
			String Cpf = CpfCampo.getText();
			String ChDiaria = ChDiariaCampo.getText();
			String Horas = HorasCampo.getText();
			String Dias = DiasCampo.getText();
			String idSupervisor = idSupervisorCampo.getText();
			
			int ChDiariaInt = Integer.parseInt(ChDiaria);
			int HoraInt = Integer.parseInt(Horas);
			int DiaInt = Integer.parseInt(Dias);
			int IdSupervisorInt = Integer.parseInt(idSupervisor);
			
			est.setMatricula(Matricula);
			est.setNome(nome);
			est.setCpf(Cpf);
			est.setChDiaria(ChDiariaInt);
			est.setHoras(HoraInt);
			est.setDias(DiaInt);
			est.setidSupervisor(IdSupervisorInt);
			
			banco.insereEstagiario(est);
			
		}
		
		
	}
	
	public AdicionarEstagiario () throws SQLException{
		setTitle("SICH - ADICIONAR NOVO ESTAGIÁRIO");
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
		buttons.add(cadastrar = new JButton("CADASTRAR"));
		buttons.add(limpar = new JButton("LIMPAR"));
		
		desc = new JLabel("<html><p>COLOQUE OS DADOS CORRETAMENTE</p><p>PARA CADASTRAR UM NOVO ESTAGIÁRIO</p><p></p><p></p><p></p><p></p></html>", SwingConstants.CENTER);
		desc.setFont(new Font("Dialog", Font.BOLD, 20));
		
		
		JPanel painelMatricula = new JPanel();
		painelMatricula.setLayout(new FlowLayout());
		painelMatricula.add(Matricula= new JLabel("MATRICULA:"));
		painelMatricula.add(MatriculaCampo = new JTextField(40));
		
		JPanel painelNome = new JPanel();
		painelNome.setLayout(new FlowLayout());
		painelNome.add(Nome = new JLabel("NOME:"));
		painelNome.add(NomeCampo = new JTextField(40));
		
		JPanel painelCpf = new JPanel();
		painelCpf.setLayout(new FlowLayout());
		painelCpf.add(Cpf = new JLabel("CPF:"));
		painelCpf.add(CpfCampo = new JTextField(40));
		
		JPanel painelCampos1 = new JPanel();
		painelCampos1.setLayout(new BorderLayout());
		painelCampos1.add(painelMatricula, BorderLayout.NORTH);
		painelCampos1.add(painelNome, BorderLayout.CENTER);
		painelCampos1.add(painelCpf, BorderLayout.SOUTH);

		
		JPanel painelChDiaria = new JPanel();
		painelChDiaria.setLayout(new FlowLayout());
		painelChDiaria.add(ChDiaria = new JLabel("CH DIÁRIA:"));
		painelChDiaria.add(ChDiariaCampo = new JTextField(40));
		
		JPanel painelHoras = new JPanel();
		painelHoras.setLayout(new FlowLayout());
		painelHoras.add(Horas = new JLabel("HORAS:"));
		painelHoras.add(HorasCampo = new JTextField(40));
		
		JPanel painelDias = new JPanel();
		painelDias.setLayout(new FlowLayout());
		painelDias.add(Dias = new JLabel("DIAS:"));
		painelDias.add(DiasCampo = new JTextField(40));
		
		JPanel painelCampos2 = new JPanel();
		painelCampos2.setLayout(new BorderLayout());
		painelCampos2.add(painelChDiaria, BorderLayout.NORTH);
		painelCampos2.add(painelHoras, BorderLayout.CENTER);
		painelCampos2.add(painelDias, BorderLayout.SOUTH);
		
		JPanel painelIdSupervisor = new JPanel();
		painelIdSupervisor.setLayout(new FlowLayout());
		painelIdSupervisor.add(idSupervisor = new JLabel("ID SUPERVI:"));
		painelIdSupervisor.add(idSupervisorCampo = new JTextField(40));
		
		JPanel painelCamposGeral = new JPanel();
		painelCamposGeral.setLayout(new BorderLayout());
		painelCamposGeral.add(painelCampos1, BorderLayout.NORTH);
		painelCamposGeral.add(painelCampos2, BorderLayout.CENTER);
		painelCamposGeral.add(painelIdSupervisor, BorderLayout.SOUTH);
		painelCamposGeral.setBorder(BorderFactory.createTitledBorder("Dados Cadastrais"));
		
		back.addActionListener(this);
		cadastrar.addActionListener(this);
		
		
		add(desc, BorderLayout.NORTH);
		add(painelCamposGeral, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);
	}
}