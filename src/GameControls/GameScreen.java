package GameControls;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import GameControls.*;
import javax.swing.JPanel;

public class GameScreen extends JPanel implements Runnable{
	int screenHeight, screenWidth;
	
	public void paintComponent(Graphics g){
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 1200, 800);
		g.setColor(Color.WHITE);
		g.fillRect(11, 11, 1169, 744);
		//super.repaint();
		
		g.drawString("Player Score: "+Integer.toString(GameInfo.playerScore)+"      Multiplier: "+Integer.toString(GameInfo.playerMultiplier), 10, 10);
		for(int i=0; i<GameInfo.enemies.size();i++){
			g=GameInfo.enemies.elementAt(i).Draw(g);    //This line is causing problems.
		}
		for(int i=0; i<GameInfo.players.size();i++){
			g=GameInfo.players.elementAt(i).Draw(g);			
		}
		for(int i=0; i<GameInfo.projectiles.size();i++){
			try{
				g=GameInfo.projectiles.elementAt(i).Draw(g);
			}
			catch(Exception e){
				System.out.println("Tried to draw a non-existant object");
			}
		}
		for(int i=0; i<GameInfo.effects.size();i++){
			try{
			g=GameInfo.effects.elementAt(i).Draw(g);
			}
			catch(Exception e){
				System.out.println("Tried to draw a non-existant object");
			}
		}
		for(int i=0; i<GameInfo.geoms.size();i++){
			g=GameInfo.geoms.elementAt(i).Draw(g);			
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
