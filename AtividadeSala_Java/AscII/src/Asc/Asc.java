package Asc;

import javax.swing.*;

public class Asc {
	public static void main (String [] args){
		
		
		JFrame frame = new JFrame("Asc Table");
		frame.setSize(500, 500);
		frame.setLocation(500, 100);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		
		ImageIcon icon = new ImageIcon("c:/ABAAAfv5sAA-0.jpg");
			
			JLabel label = new JLabel(icon);
			panel.add(label);
	

		frame.pack();
		frame.setVisible(true);	

}
}
