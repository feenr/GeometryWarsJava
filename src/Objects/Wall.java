package Objects;

import java.awt.Color;
import java.awt.Graphics;

import Movement.NoMove;

public class Wall extends GameObject{
	public Wall(){
		moveType = new NoMove();
	}
	
	public Graphics Draw(Graphics g){
		g.setColor(Color.BLACK);
		g.drawRect(10, 10, 1170, 745);
		return g;
	}
}
