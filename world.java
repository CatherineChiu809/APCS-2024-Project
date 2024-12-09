////imported stuff
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class world {

    JPanel p;
    JFrame frame;{

            frame=new JFrame();

            p=new JPanel(){
        
        @Override/////What does this mean?
        public void paint(Graphics g){
            ////DRAWS GRASS
            g.setColor(Color.decode("#1CFC40"));
            g.fillRect(0,0,720,560);
            // g.setColor(Color.black);
            // g.drawRect(0,0,780,560);
            int i=0;
            for(int a=0; a<14; a++){
                if(a%2==0){
                    for(i=0;i<18;i++){
                        if(i%2==0){
                            g.setColor(Color.decode("#7CFC60"));
                            g.fillRect(i*40, a*40, 40, 40);
                        }
                    }
                }
                else{
                    for(i=0;i<18;i++){
                        if(i%2!=0){
                            g.setColor(Color.decode("#7CFC60"));                            g.fillRect(i*40, a*40, 40, 40);
                        }
                    }
                }
                i=i+1;

        }
        ////CREATES COORDINATES
        int b;
        int c=0;
        coordinate [] coors=new coordinate[18*14];
        for(int a=0; a<14; a++){
            for(b=0; b<18; b++){
                coors[c]=new coordinate(b,a);
                c=c+1;
            }
            b=b+1;
        }
        ////ASSIGNS MINES
        int [] random=new int[18*14];
        for(int mine=0; mine<41; mine++){
            int ran=(int)(Math.random()*252);
            random[ran]=1;
        }
        for(int a=0; a<random.length; a++){
            int ran=(int)(Math.random()*252);
            if(random[ran]==1){
                coors[a].setMine(true);
                random[ran]=-1;
            }
            else if(random[ran]==0){
                coors[a].setMine(false);
                random[ran]=-1;
            }
            else if(random[ran]==-1){
                a=a-1;
            }
        }
        /////DRAW MINES
        for(int a=0; a<random.length; a++){
            if(coors[a].getMine()==true){
                g.setColor(Color.RED);
                g.fillRect(coors[a].getX()*40, coors[a].getY()*40, 40,40);
            }
        }

        ////DRAW SURROUNDING BLOCKS

        ////FIGURES OUT HOW MANY MINES SURROUND EACH BLOCK
        for(int z=0; z<random.length; z++){
            for(int a=0; a<random.length; a++){
                if(coors[z].getMine()==false){
                if(coors[a].getX()==coors[z].getX()+1&&coors[a].getY()==coors[z].getY()+1){
                    if(coors[a].getMine()){
                        coors[z].incNum();
                    }
                }
                else if(coors[a].getX()==coors[z].getX()-1&&coors[a].getY()==coors[z].getY()-1){
                    if(coors[a].getMine()){
                        coors[z].incNum();
                    }
                }
                else if(coors[a].getX()==coors[z].getX()+1&&coors[a].getY()==coors[z].getY()-1){
                    if(coors[a].getMine()){
                        coors[z].incNum();
                    }
                }
                else if(coors[a].getX()==coors[z].getX()-1&&coors[a].getY()==coors[z].getY()+1){
                    if(coors[a].getMine()){
                        coors[z].incNum();
                    }
                }
                else if(coors[a].getX()==coors[z].getX()-1&&coors[a].getY()==coors[z].getY()){
                    if(coors[a].getMine()){
                        coors[z].incNum();
                    }
                }
                else if(coors[a].getX()==coors[z].getX()+1&&coors[a].getY()==coors[z].getY()){
                    if(coors[a].getMine()){
                        coors[z].incNum();
                    }
                }
                else if(coors[a].getY()==coors[z].getY()-1&&coors[a].getX()==coors[z].getX()){
                    if(coors[a].getMine()){
                        coors[z].incNum();
                    }
                }
                else if(coors[a].getY()==coors[z].getY()+1&&coors[a].getX()==coors[z].getX()){
                    if(coors[a].getMine()){
                        coors[z].incNum();
                    }
                }
                
            }
            }
        }

        /////PRINTS THE SURROUNDING MINES ON EACH BLOCK
        for(int a=0; a<252; a++){
            if(coors[a].getMine()==false){
                if(coors[a].getDark()){
                    g.setColor(Color.decode("#A9A9A9"));
                    g.fillRect(coors[a].getX()*40, coors[a].getY()*40, 40, 40);
                }
                else{
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillRect(coors[a].getX()*40, coors[a].getY()*40, 40, 40);
                }
                g.setColor(Color.black);
                g.setFont(new Font("Arial",Font.PLAIN,25));
                g.drawString(""+coors[a].getNum(), coors[a].getX()*40+10, coors[a].getY()*40+30);
            }
        }

        }
            };
            frame.add(p,BorderLayout.CENTER);
            frame.setVisible(true);
        }
    }
