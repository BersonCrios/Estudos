package digit;

import javax.swing.*;
import java.util.*;

public class digit {
	public static void main (String [] args){
		
		
		JFrame frame = new JFrame("Relógio");
		frame.setSize(500, 500);
		frame.setLocation(500, 100);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		
		
		Date data = new Date();
		
		
			JLabel label = new JLabel("data");
			panel.add(label);
		

		//frame.pack();
		frame.setVisible(true);		

}
}
