package Objects;

import java.awt.Color;
import java.awt.Graphics;

import GameControls.GameInfo;
import Movement.GeomMovement;
import Movement.Random;
import Utilities.Coordinates;

public class Geom extends GameObject{
	double startTime;
	double maxTime = 5;
	
	public Geom(double xLoc, double yLoc){
		startTime = GameInfo.globalTimer;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		vel = 1;
		size = 3;
		moveType = new GeomMovement();
		isAlive = true;
	}
	
	public void move(){
		if(GameInfo.globalTimer-startTime>maxTime){
			isAlive = false;
		}
		Coordinates newLoc = moveType.move(xLoc, yLoc, vel);
		yLoc = newLoc.getYLoc();
		xLoc = newLoc.getXLoc();
	}
	
	public Graphics Draw(Graphics g){
		g.setColor(Color.GREEN);
		g.drawOval((int)(xLoc)-2, (int)(yLoc)-2, 4, 4);
		return g;
	}
	
	public void hit(){
		isAlive = false;
		GameInfo.playerMultiplier+=1;
	}
}
