package milhasforkm;
        
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MilhasForKm extends JFrame  implements ActionListener{   
         JLabel milhasTxt = null;
         JLabel kmConvertido = null;
         JTextField milhasCampo = null;
      
      
        JButton Calcular = null;
        JButton Limpar = null;
        JButton Sair = null;
        
         float milhass;

      //Função OBRIGATÓRIA do ActionListener, onde realiza-se os eventos
        public void actionPerformed(ActionEvent evento) {
            //Evento de Limpa os campos atravez do botão "Limpar"
            if(evento.getSource() == Limpar){
                milhasCampo.setText(null);
                kmConvertido.setText("0.0");
            }
            //Evento que Fecha a janela (aplicação) atravez do botão "Sair"
            else if(evento.getSource() == Sair){
	        System.exit(0);
	    }
            
            //Evento que faz os Calculos de imc atravez do botão Calcular
            else if(evento.getSource() == Calcular){
                String milhasStr = milhasCampo.getText();// Pega o que foi digitado no campo de altura e armazena na variavel
                
                milhass = Float.parseFloat(milhasStr);//Transforma a String pega do campo e ransforma em float e armazena na variável 
                
                
                
                float conversaoMforKm = (float) (milhass * 1.609344);
                
                 String labelConvert = Float.toString(conversaoMforKm);//Transforma a váriavel global(que tem seu valor conseguido atravez de um evento de botão) em String para ser exibida
                 kmConvertido.setText(labelConvert);   
                 
            }
        }
        
    public MilhasForKm(){
        //Criacao da janela
        setTitle("Conversor Milhas Para Km/H");
        setSize(600,200);//tamanho da janela
        setLocation(400,100);//locasizacao da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fecha a janela
        setLayout(new BorderLayout());//chama o layout da janela
           
        
         JPanel CamposLabelsMilhas = new JPanel();
        CamposLabelsMilhas.setLayout(new FlowLayout());
        CamposLabelsMilhas.add(milhasTxt = new JLabel("Qaunridade de Milhas/h:                             "));
        CamposLabelsMilhas.add(milhasCampo = new JTextField(15));
        
        JPanel DadosConversao = new JPanel();
        DadosConversao.setLayout(new BorderLayout());
        DadosConversao.setBorder(BorderFactory.createTitledBorder("Conversão"));
      
        
        
        JPanel LayoutCampos = new JPanel();
        LayoutCampos.setLayout(new BorderLayout());
        LayoutCampos.setBorder(BorderFactory.createTitledBorder(""));
        
        
       
        JPanel botoes = new JPanel();
        botoes.setLayout(new FlowLayout());
        botoes.add(Calcular = new JButton("Calcular"));
        botoes.add(Limpar = new JButton("Limpar"));
        botoes.add(Sair = new JButton("Sair")); 
        
        
        JPanel convertido = new JPanel();
        convertido.setLayout(new BorderLayout());
        convertido.add(kmConvertido = new JLabel());
       
        
         // Adiciona componente a lista de eventos 
        Calcular.addActionListener(this);
        Limpar.addActionListener(this);
        Sair.addActionListener(this);
        
         DadosConversao.add(convertido,BorderLayout.CENTER );
        LayoutCampos.add(CamposLabelsMilhas, BorderLayout.NORTH);
        LayoutCampos.add(botoes, BorderLayout.SOUTH);
         
        this.add(LayoutCampos, BorderLayout.NORTH);
        this.add(DadosConversao, BorderLayout.CENTER);
        
          setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new  MilhasForKm();
    }  
}
