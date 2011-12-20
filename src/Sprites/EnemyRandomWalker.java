package Sprites;
import java.awt.Color;
import java.awt.Graphics;

import GameControls.GameInfo;
import Movement.*;

public class EnemyRandomWalker extends Enemy{
	public EnemyRandomWalker(){
		vel = 4;
		size = 8;
		setMovementType(new Random());
	}
	
	public Graphics Draw(Graphics g){
		g.setColor(Color.MAGENTA);
		g.drawOval(getXLoc()-(int)size, getYLoc()-(int)size, (int)(2*size), (int)(2*size));
		return g;
	}
}
