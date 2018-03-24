package frames;

import javax.swing.*;

public class frames {
	public static void main (String [] args){
		int i;
		
		for(i=0;i<500;i++){
			
		JFrame frame = new JFrame(i + "º"  + " Frame");
		frame.setSize(500, 500);
		frame.setLocation(500, 100);
		

		
		frame.setVisible(true);
		}
}
}
