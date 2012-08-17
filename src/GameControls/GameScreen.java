package GameControls;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import GameControls.*;
import java.awt.BasicStroke;
import javax.swing.JPanel;

public class GameScreen extends JPanel implements Runnable{
	int screenHeight, screenWidth;
	
	public void paintComponent(Graphics g){
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 1200, 800);
		g.setColor(Color.WHITE);
		g.fillRect(11, 11, 1169, 744);
                Graphics2D g2 = (Graphics2D)g;
                BasicStroke normalStroke = new BasicStroke(1);
                BasicStroke wideStroke = new BasicStroke(3);
                g2.setStroke(normalStroke);
                
		//super.repaint();
		
		g.drawString("Player Score: "+Integer.toString(GameInfo.playerScore)+"      Multiplier: "+Integer.toString(GameInfo.playerMultiplier), 10, 10);
		for(int i=0; i<GameInfo.enemies.size();i++){
                        //g2.setStroke(wideStroke);
			if(GameInfo.shadowsEnabled){
                g=GameInfo.enemies.get(i).DrawShadow(g);                       
            }
            g=GameInfo.enemies.get(i).Draw(g);
            //g2.setStroke(normalStroke);
		}
		for(int i=0; i<GameInfo.players.size();i++){
       
			g=GameInfo.players.get(i).Draw(g);			
		}
		for(int i=0; i<GameInfo.projectiles.size();i++){
			try{
				g=GameInfo.projectiles.get(i).Draw(g);
			}
			catch(Exception e){
				System.out.println("Tried to draw a non-existant object");
			}
		}
		for(int i=0; i<GameInfo.effects.size();i++){
			try{
			g=GameInfo.effects.get(i).Draw(g);
			}
			catch(Exception e){
				System.out.println("Tried to draw a non-existant object");
			}
		}
		for(int i=0; i<GameInfo.geoms.size();i++){
			g=GameInfo.geoms.get(i).Draw(g);			
		}
	}
	
	public void run() {
		while(true){
			repaint();
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
}
