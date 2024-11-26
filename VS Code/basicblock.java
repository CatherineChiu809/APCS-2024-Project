import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

//package pkg;

public class basicblock {
	
	public basicblock(int x, int y){
		JFrame frame = new JFrame();
		
		JPanel p = new JPanel(){
            @Override
            public void paint(Graphics g) {
				int d = 0;
				while(d < 4){
					g.setColor(Color.blue);
					g.fillRect(x, y+(d*40), 40, 40);
					g.setColor(Color.black);
					g.drawRect(x, y+(d*40), 40, 40);
					d++;
				}
				
				
            }
			
		};
		p.setBorder(BorderFactory.createEmptyBorder(30,30,100,300));
		p.setLayout(new GridLayout(0,1));
		
		frame.add(p,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Our GUI");
		frame.add(p);
		frame.setVisible(true);
	}
	
	public static void main(String args[]) {
		//basicblock test = new basicblock(10,10);
		basicblock test2 = new basicblock(100,100);

 
		
	}
}