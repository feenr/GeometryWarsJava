package Sprites;
import java.awt.Color;
import java.awt.Graphics;

import GameControls.GameInfo;
import Movement.*;

public class EnemyRandomWalker extends Enemy{
	public EnemyRandomWalker(){
		vel = 4;
		size = 16;
		setMovementType(new Random());
	}
	
	public Graphics Draw(Graphics g){
		g.setColor(Color.MAGENTA);
		g.drawOval(getXLoc()-(int)(0.5*size), getYLoc()-(int)(0.5*size), (int)(size), (int)(size));
		return g;
	}
}
