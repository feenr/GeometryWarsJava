package Sprites;
import java.awt.Color;
import java.awt.Graphics;
import Movement.Spinner;

public class EnemyChild extends Enemy{
	double xCenter, yCenter;
	double xOffSet, yOffSet;

	public EnemyChild(double xLoc, double yLoc){
		this.xLoc=xLoc;
		this.yLoc=yLoc;
		size = 5;
		vel = 2;
		setMovementType(new Spinner());
	}
	
	public Graphics Draw(Graphics g){
		g.setColor(Color.cyan);
		g.drawOval(getXLoc()-(int)size, getYLoc()-(int)size, (int)(2*size), (int)(2*size));
		return g;
	}
}
