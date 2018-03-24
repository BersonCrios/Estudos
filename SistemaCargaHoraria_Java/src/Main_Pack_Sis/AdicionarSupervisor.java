package Main_Pack_Sis;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class AdicionarSupervisor extends JFrame implements ActionListener {

	//atributos
			private String url = "jdbc:mysql://localhost/CargaHorariaEstagio?useSSl=false";
			private String Usuario = "root";
			private String Senha = "";
			private String sql = "select idSupervisor, Nome,Cpf, Matricula, Cargo from Supervisor";
			private CamadaBancoDados banco = null;
	
	JButton back = null;
	
	JLabel Nome = null;
	JLabel Cpf = null;
	JLabel Matricula = null;
	JLabel Cargo = null;

	JLabel desc = null;
	
	JTextField NomeCampo = null;
	JTextField CpfCampo = null;
	JTextField  MatriculaCampo = null;
	JTextField  CargoCampo = null;
	
	
	JButton cadastrar = null;
	JButton limpar = null;
	
	Supervisor sup = new Supervisor();
	
	public void actionPerformed(ActionEvent events) {
		if(events.getSource() == back){
			try {
				new JanelaSupervisor().show();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			this.dispose();
		}
		
		else if(events.getSource() == cadastrar){
			String nome = NomeCampo.getText();
			String Cpf = CpfCampo.getText();
			String Matricula = MatriculaCampo.getText();
			String Cargo =  CargoCampo.getText();
			
			sup.setNome(nome);
			sup.setCpf(Cpf);
			sup.setMatricula(Matricula);
			sup.setCargo(Cargo);
			
			banco.insereSupervisor(sup);
			JOptionPane.showMessageDialog(null, "Supervisor Adicionado com Sucesso");
		}
		
		else if(events.getSource() == limpar){
			NomeCampo.setText(null);
			CpfCampo.setText(null);
			MatriculaCampo.setText(null);
			CargoCampo.setText(null);
		}
	}
	
	public AdicionarSupervisor () throws SQLException{
		setTitle("SICH - ADICIONAR NOVO SUPERVISOR");
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
		
		desc = new JLabel("<html><p>COLOQUE OS DADOS CORRETAMENTE</p><p>PARA CADASTRAR UM NOVO SUPERVISOR</p><p></p><p></p><p></p><p></p></html>", SwingConstants.CENTER);
		desc.setFont(new Font("Dialog", Font.BOLD, 20));
		
		JPanel painelNome = new JPanel();
		painelNome.setLayout(new FlowLayout());
		painelNome.add(Nome = new JLabel("NOME:          "));
		painelNome.add(NomeCampo = new JTextField(40));
		
		JPanel painelCpf = new JPanel();
		painelCpf.setLayout(new FlowLayout());
		painelCpf.add(Cpf = new JLabel("CPF:              "));
		painelCpf.add(CpfCampo = new JTextField(40));
		
		JPanel painelCampos1 = new JPanel();
		painelCampos1.setLayout(new BorderLayout());
		painelCampos1.add(painelNome, BorderLayout.NORTH);
		painelCampos1.add(painelCpf, BorderLayout.CENTER);
		
		
		JPanel painelMatricula = new JPanel();
		painelMatricula.setLayout(new FlowLayout());
		painelMatricula.add(Matricula= new JLabel("MATRICULA:"));
		painelMatricula.add(MatriculaCampo = new JTextField(40));
		
		JPanel painelCargo = new JPanel();
		painelCargo.setLayout(new FlowLayout());
		painelCargo.add(Cargo = new JLabel("CARGO:       "));
		painelCargo.add(CargoCampo = new JTextField(40));
		
		JPanel painelCampos2 = new JPanel();
		painelCampos2.setLayout(new BorderLayout());
		painelCampos2.add(painelMatricula, BorderLayout.NORTH);
		painelCampos2.add(painelCargo, BorderLayout.CENTER);
		
		
		JPanel painelCamposGeral = new JPanel();
		painelCamposGeral.setLayout(new BorderLayout());
		painelCamposGeral.add(painelCampos1, BorderLayout.NORTH);
		painelCamposGeral.add(painelCampos2, BorderLayout.CENTER);
		painelCamposGeral.add(buttons, BorderLayout.SOUTH);
		painelCamposGeral.setBorder(BorderFactory.createTitledBorder("Dados Cadastrais"));
		
		
		back.addActionListener(this);
		cadastrar.addActionListener(this);
		limpar.addActionListener(this);
		
		add(desc, BorderLayout.NORTH);
		add(painelCamposGeral, BorderLayout.CENTER);
		
	}

}
