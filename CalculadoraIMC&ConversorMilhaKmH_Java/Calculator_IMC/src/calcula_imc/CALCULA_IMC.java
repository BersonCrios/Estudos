package calcula_imc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Author Guilherme Berson e Alecxandra Mesquita
public class CALCULA_IMC extends JFrame implements ActionListener{   
        JLabel alturaLabel = null;
        JLabel pesoLabel = null;
        JLabel imc = null;
        JLabel situacao = null;
        
        JTextField alturaCampo = null;
        JTextField pesoCampo = null;
        
        JButton Calcular = null;
        JButton Limpar = null;
        JButton Sair = null;
        
         float IMC; 
         
        //Função OBRIGATÓRIA do ActionListener, onde realiza-se os eventos
        public void actionPerformed(ActionEvent evento) {
            //Evento de Limpa os campos atravez do botão "Limpar"
            if(evento.getSource() == Limpar){
                alturaCampo.setText(null);
                pesoCampo.setText(null);
                imc.setText("0.0");
                situacao.setText("Entre com peso e altura para saber sua situação");
            }
            //Evento que Fecha a janela (aplicação) atravez do botão "Sair"
            else if(evento.getSource() == Sair){
	        System.exit(0);
	    }
            
            //Evento que faz os Calculos de imc atravez do botão Calcular
            else if(evento.getSource() == Calcular){
                String alturaStr = alturaCampo.getText();// Pega o que foi digitado no campo de altura e armazena na variavel
                String pesoStr = pesoCampo.getText();//Pega o que foi digitado no campo de peso e armazena na variavel
                
                float alturaNum = Float.parseFloat(alturaStr);//Transforma a String pega do campo e ransforma em float e armazena na variável
                float pesoNum = Float.parseFloat(pesoStr);//Transforma a String pega do campo e ransforma em float e armazena na variável

                 IMC = pesoNum / (alturaNum*alturaNum);
                 
                 String labelIMC = Float.toString(IMC);//Transforma a váriavel global(que tem seu valor conseguido atravez de um evento de botão) em String para ser exibida
                 imc.setText(labelIMC);
                    
                    String situacaoTxt = null;
                    
                    if(IMC < 18.48){                    
                        situacaoTxt = "Abaixo do Peso";
                        situacao.setText(situacaoTxt);
                    }      
                   if(IMC >= 18.50 && IMC <= 24.99){
                        situacaoTxt = "Peso Normal";
                        situacao.setText(situacaoTxt);
                    }
                   if(IMC >= 25 && IMC <= 29.99){
                        situacaoTxt = "Acima do Peso";
                        situacao.setText(situacaoTxt);
                    }                    
                   if(IMC >= 30 && IMC <= 34.99){
                        situacaoTxt = "Obesidade I";
                        situacao.setText(situacaoTxt);
                    }                    
                    if(IMC >= 35 && IMC <= 39.99){
                        situacaoTxt = "Obesidade II";
                        situacao.setText(situacaoTxt);
                    }                        
                    if(IMC >= 40){
                        situacaoTxt = "Obesidade III";
                        situacao.setText(situacaoTxt);
                    }                         
            }
        }
        
    public CALCULA_IMC(){
        //Criacao da janela
        setTitle("Calculadora IMC");
        setSize(600,300);//tamanho da janela
        setLocation(500,100);//locasizacao da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fecha a janela
        setLayout(new BorderLayout());//chama o layout da janela
           
        /*Muda o icone da aplicação*/
	java.net.URL iconesoftware = this.getClass().getResource("icone.jpeg");
	Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(iconesoftware);
	this.setIconImage(imagemTitulo);
                
        /*Cria uma linha de só para peso, com o label e o text field*/
        JPanel CamposLabelsPeso = new JPanel();
        CamposLabelsPeso.setLayout(new FlowLayout());
        CamposLabelsPeso.add(pesoLabel = new JLabel("Seu Peso:                             "));
        CamposLabelsPeso.add(pesoCampo = new JTextField(15));
        
        /*Cria uma linha de só para altura, com o label e o text field*/
        JPanel CamposLabelsAltura = new JPanel();
        CamposLabelsAltura.setLayout(new FlowLayout());
        CamposLabelsAltura.add(alturaLabel = new JLabel("Sua Altura:                            "));
        CamposLabelsAltura.add(alturaCampo = new JTextField(15));
        
        /*Cria uma área especifica na somente para os campos de entrada e labels*/
        JPanel LayoutCampos = new JPanel();
        LayoutCampos.setLayout(new BorderLayout());
        LayoutCampos.setBorder(BorderFactory.createTitledBorder("Dados de Calculo"));//Adiciona um fieldset(Borda) a área de campos e labels
        
        
        /*Cria uma área especifica na somente para o dizer qual o imc*/
        JPanel LayoutResultadosimc = new JPanel();
        LayoutResultadosimc.setLayout(new BorderLayout());
        LayoutResultadosimc.setBorder(BorderFactory.createTitledBorder("IMC: "));//Adiciona um fieldset(Borda) a área de campmostra os resultados
        
        
        /*Cria uma área especifica na somente para o dizer qual a situação*/
        JPanel LayoutResultadosSituacao = new JPanel();
        LayoutResultadosSituacao.setLayout(new BorderLayout());
        LayoutResultadosSituacao.setBorder(BorderFactory.createTitledBorder("SITUAÇÃO: "));//Adiciona um fieldset(Borda) a área de campmostra os resultados
        
        //Cria uma área que abrange a área de imc e situação
        JPanel LayoutStatus = new JPanel();
        LayoutStatus.setLayout(new BorderLayout());
        LayoutStatus.setBorder(BorderFactory.createTitledBorder("STATUS:  "));//Adiciona um fieldset(Borda) a área de campmostra os resultados
        
        
        //Cria painel para os botoes
        JPanel botoes = new JPanel();
        botoes.setLayout(new FlowLayout());
        botoes.add(Calcular = new JButton("Calcular"));
        botoes.add(Limpar = new JButton("Limpar"));
        botoes.add(Sair = new JButton("Sair"));        
        
        
        
        //Cria painel queMostra o imc
        JPanel apresentaIMC = new JPanel();
        apresentaIMC.setLayout(new BorderLayout());
        apresentaIMC.add(imc = new JLabel());
        imc.setText(String.valueOf(IMC));
        
        
        //Cria painel queMostra a situação
        JPanel apresentaSitucao = new JPanel();
        apresentaSitucao.setLayout(new BorderLayout());
        apresentaSitucao.add(situacao = new JLabel("Entre com peso e altura para saber sua situação"));
        
        // Adiciona componente a lista de eventos 
        Calcular.addActionListener(this);
        Limpar.addActionListener(this);
        Sair.addActionListener(this);
        
        LayoutCampos.add(CamposLabelsPeso, BorderLayout.NORTH);//Adiciona a parte de peso a região norte do layout criado acima
        LayoutCampos.add(CamposLabelsAltura, BorderLayout.CENTER);//Adiciona a parte de peso a região central do layout criado acima      
        LayoutCampos.add(botoes, BorderLayout.SOUTH);// Adciona os botoes na região sul do layour de campos
        
        LayoutResultadosimc.add(apresentaIMC,BorderLayout.CENTER );
        LayoutResultadosSituacao.add(apresentaSitucao,BorderLayout.CENTER );
        
        //áreas de apresentação de STATUS
        LayoutStatus.add(LayoutResultadosimc, BorderLayout.NORTH);
        LayoutStatus.add(LayoutResultadosSituacao, BorderLayout.CENTER);      
        
        this.add(LayoutCampos, BorderLayout.NORTH);//Adiciona essa área ao painel principal na região norte  
        this.add(LayoutStatus, BorderLayout.CENTER);//Adiciona STATUS A região central

        setVisible(true);
        
    }
    
    public static void main(String[] args) { 
        new  CALCULA_IMC();
        
    }  
}