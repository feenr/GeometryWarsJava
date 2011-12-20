package Objects;

import java.awt.Color;
import java.awt.Graphics;

import GameControls.GameInfo;
import Movement.*;
import Utilities.*;

public class SingleBurst extends GameObject{
	double vel; 
	int timeLeft, lastX, lastY;
	Color color;
	
	public SingleBurst(double xLoc, double yLoc){
		size = Integer.MIN_VALUE; //Will not allow any objects to collide with this object.
		color = new Color((int)Math.random()*155+100,(int)Math.random()*75,(int)Math.random()*75);
		vel = Math.random()*5+2;
		setMovementType(new Random());
		timeLeft = (int)Math.random()*50+20;
		size = NuetralUtilities.noHit;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		move();
	}
	
	public void move(){
		lastX=(int)xLoc;
		lastY=(int)yLoc;
		
		Coordinates newLoc = moveType.move(xLoc, yLoc, vel);
		
		yLoc = newLoc.getYLoc();
		xLoc = newLoc.getXLoc();
		
		if(timeLeft%3==0){
			color.brighter();	
		}
		timeLeft -=1;
		if(timeLeft==0){
			isAlive = false;
		}
	}
	
	public Graphics Draw(Graphics g){
		g.setColor(color);
		g.drawLine(lastX, lastY, (int)xLoc, (int)yLoc);
		return g;
	}
	
}
