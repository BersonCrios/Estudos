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

public class ExcluirSupervisor extends JFrame implements ActionListener {

	//atributos
	private String url = "jdbc:mysql://localhost/CargaHorariaEstagio?useSSl=false";
	private String Usuario = "root";
	private String Senha = "";
	private String sql = "select idSupervisor, Nome,Cpf, Matricula, Cargo from Supervisor";
	private CamadaBancoDados banco = null;
	
	JButton back = null;
	
	JLabel Cpf = null;
	JTextField CpfCampo = null;
	
	JButton excluir = null;
	
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
		
		if(events.getSource() == excluir){
			String Cpf = CpfCampo.getText();
			sup.setCpf(Cpf);
			banco.deletaSupervisor(sup);
			
			JOptionPane.showMessageDialog(null, "Supervisor Excluido");
		}
		
	}
	
	public ExcluirSupervisor () throws SQLException{
		setTitle("SICH - EXCLUIR SUPERVISOR");
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
		
		JPanel painelCpf = new JPanel();
		painelCpf.setLayout(new FlowLayout());
		painelCpf.add(Cpf = new JLabel("CPF:              "));
		painelCpf.add(CpfCampo = new JTextField(40));
		
		JPanel buttonback = new JPanel();
		buttonback.setLayout(new FlowLayout());
		buttonback.add(excluir = new JButton("EXCLUIR"));
		buttonback.add(back = new JButton("VOLTAR"));
		
		back.addActionListener(this);
		excluir.addActionListener(this);
		
		add(painelCpf, BorderLayout.CENTER);
		add(buttonback, BorderLayout.SOUTH);
	}

}
