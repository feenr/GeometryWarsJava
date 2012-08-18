package Objects;

import java.awt.Color;
import java.awt.Graphics;

import GameControls.GameInfo;
import Movement.ProjectileMove;
import Movement.Random;
import Utilities.Coordinates;

public class Projectile extends GameObject{
	double lastX, lastY;
	int distance, splashCount;
	int splashMax = 5;
	
	public Projectile(double angle, double xLoc, double yLoc){
		moveType = new ProjectileMove(angle);
		vel = 8;
		size = 2;
		splashCount = splashMax+(int)(Math.random()*2);
		distance = 0;
		isAlive = true;
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		move();
	}
	
	public void move(){
		lastX=xLoc;
		lastY=yLoc;
		distance++;
		if(GameInfo.projectileSplashEnabled == true){
			splashCount--;
			if(splashCount < 0){
				Splash splash = new Splash(xLoc, yLoc);
				GameInfo.effects.add(splash);
				splashCount = splashMax+(int)(Math.random()*2);
			}
		}
		Coordinates newLoc = moveType.move(xLoc, yLoc, vel);
		yLoc = newLoc.getYLoc();
		xLoc = newLoc.getXLoc();
	
		if(xLoc<GameInfo.xBegin){
			isAlive=false;
		}
		
		if(xLoc>GameInfo.xEnd){
			isAlive=false;
		}
		
		if(yLoc<GameInfo.yBegin){
			isAlive=false;
		}
		
		if(yLoc>GameInfo.yEnd){
			isAlive=false;
		}
	}
	
	public Graphics Draw(Graphics g){
		g.setColor(Color.GREEN);
		g.drawOval((int)(xLoc-size), (int)(yLoc-size), (int)(2*size), (int)(2*size));
		g.drawLine((int)lastX, (int)lastY, (int)xLoc, (int)yLoc);
		return g;
	}
	public int getXLoc(){
		return (int)xLoc;
	}
	
	public int getYLoc(){
		return (int)yLoc;
	}
	
	public boolean isAlive(){
		return isAlive;
	}
}
