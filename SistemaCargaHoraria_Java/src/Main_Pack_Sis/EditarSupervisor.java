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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditarSupervisor extends JFrame implements ActionListener {

	JButton back = null;
	
	//atributos
	private String url = "jdbc:mysql://localhost/CargaHorariaEstagio?useSSl=false";
	private String Usuario = "root";
	private String Senha = "";
	private String sql = "select idSupervisor, Nome,Cpf, Matricula, Cargo from Supervisor";
	private CamadaBancoDados banco = null;
	
	
	JLabel Nome = null;
	JLabel Cargo = null;
	JLabel Cpf = null;
	
	JTextField NomeCampo = null;
	JTextField  CargoCampo = null;
	JTextField  CpfCampo = null;
	
	JButton Atualizar = null;
	
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
		
		else if(events.getSource() == Atualizar){
			String Cpf = CpfCampo.getText();		
			sup.setCpf(Cpf);
			
			String nome = NomeCampo.getText();
			String Cargo =  CargoCampo.getText();
		
			sup.setNome(nome);
			sup.setCargo(Cargo);
			
			banco.atualizaSupervisor(sup);
			JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!!!");
		}
		
	}
	
	public EditarSupervisor () throws SQLException{
		setTitle("SICH - EDITAR SUPERVISOR");
		setSize(600, 600);
		setLocation(400, 60);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		banco = new CamadaBancoDados (url,Usuario,Senha,sql);
		
		/* Muda o icone da aplicação */
		java.net.URL iconesoftware = this.getClass().getResource("icone.png");
		Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(iconesoftware);
		this.setIconImage(imagemTitulo);
		/* Fim Muda o icone da aplicação */

		
		JPanel buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.add(back = new JButton("VOLTAR"));
		buttons.add(Atualizar = new JButton("ATUALIZAR"));
		
		JPanel painelCpf = new JPanel();
		painelCpf.setLayout(new FlowLayout());
		painelCpf.add(Cpf = new JLabel("CPF:          "));
		painelCpf.add(CpfCampo = new JTextField(40));
		
		JPanel painelNome = new JPanel();
		painelNome.setLayout(new FlowLayout());
		painelNome.add(Nome = new JLabel("NOME:          "));
		painelNome.add(NomeCampo = new JTextField(40));
		
		JPanel painelCargo = new JPanel();
		painelCargo.setLayout(new FlowLayout());
		painelCargo.add(Cargo = new JLabel("CARGO:       "));
		painelCargo.add(CargoCampo = new JTextField(40));
		
		
		JPanel painelCampos2 = new JPanel();
		painelCampos2.setLayout(new BorderLayout());
		painelCampos2.add(painelCpf, BorderLayout.NORTH);
		painelCampos2.add(painelNome, BorderLayout.CENTER);
		painelCampos2.add(painelCargo, BorderLayout.SOUTH);
		
		
		
		back.addActionListener(this);
		Atualizar.addActionListener(this);
		
		add(painelCampos2, BorderLayout.CENTER);
		add(buttons, BorderLayout.SOUTH);
	}

}
