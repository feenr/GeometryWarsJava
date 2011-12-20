package Objects;

import java.awt.Color;
import java.awt.Graphics;

public class Splash extends GameObject{
	Color color = Color.GRAY;
	int maxTime = 32;
	int fadeValue = 255/maxTime;
	public Splash(double xLoc, double yLoc){
		this.xLoc=xLoc;
		this.yLoc=yLoc;
		move();
	}
	
	public void move(){
		size++;
		maxTime--;
		
		if(maxTime == 0){
			isAlive = false;
		}
		//328965
		//197379
		//131586
		color = new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()-fadeValue);
		//color = new Color(color.getRGB()+197379);
	}
	
	public Graphics Draw(Graphics g){
	    g.setColor(color);
		g.drawOval((int)(xLoc-size*.5), (int)(yLoc-size*.5), (int)size, (int)size);
		return g;
	}
}
