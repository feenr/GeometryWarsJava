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
		size = 10;
		vel = 2;
		setMovementType(new Spinner());
	}
	
	public Graphics Draw(Graphics g){
		g.setColor(Color.cyan);
		g.drawOval(getXLoc()-(int)(0.5*size), getYLoc()-(int)(0.5*size), (int)(size), (int)(size));
		return g;
	}
}
