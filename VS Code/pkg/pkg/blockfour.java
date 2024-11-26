import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

//package pkg;

public class blockfour {
	
	public blockfour(int x, int y, int w, int h){
		JFrame frame = new JFrame();
		
		JPanel p = new JPanel(){
            @Override
            public void paint(Graphics g) {
				int d = 0;
				while(d < 3){
					g.setColor(new Color(0,0,240));
					g.fillRect(x+(d*w), y, w, h);
					g.setColor(Color.black);
					g.drawRect(x+(d*w), y, w, h);
					d++;
				}
				g.setColor(new Color(0, 0, 240));
				g.fillRect(x+(2*w),y-w,w,h);
				g.setColor(Color.black);
				g.drawRect(x+(2*w),y-w,w,h);
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
		blockfour test = new blockfour(100,100,20,20);

 
		
	}
}