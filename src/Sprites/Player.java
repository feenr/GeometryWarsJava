package Sprites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Objects.*;
import Utilities.Coordinates;
import GameControls.GameInfo;
import GameControls.UserInput;
import Movement.*;
import Utilities.SoundUtilities;

public class Player extends Sprite{
	double angle = 0;
	int shotTimer=0;
	int shotDelay=5;
	
	public Player(){
		vel = 6;
		size=8;
		setMovementType(new PlayerControlled());
		isAlive=true;
	}
	
	public Graphics Draw(Graphics g){
		Point pointLoc = MouseInfo.getPointerInfo().getLocation();
		g.setColor(Color.RED);
		g.drawOval(getXLoc()-(int)size, getYLoc()-(int)size, (int)(2*size), (int)(2*size));
		angle = Math.atan2(pointLoc.y-yLoc, pointLoc.x-xLoc);
		int lineToX=(int)(xLoc+Math.cos(angle)*(size+10));
		int lineToY=(int)(yLoc+Math.sin(angle)*(size+10));
		g.setColor(Color.gray);
		g.drawLine((int)(xLoc), (int)(yLoc), lineToX, lineToY);
		return g;
	}
	
	public void hit(){
		for(int x = 0; x<20;x++){
			SingleBurst burst = new SingleBurst(xLoc, yLoc);
			burst.setXLoc((int)xLoc);
			burst.setYLoc((int)yLoc);
			GameInfo.effects.add(burst);
		}
		isAlive = false;
	}

	public void shoot(){
		if(shotTimer==0){
			Projectile laser = new Projectile(angle, xLoc, yLoc);
			GameInfo.projectiles.add(laser);
			shotTimer = shotDelay;
                        SoundUtilities.playSound(("Resources/Laser_burst.wav"));
		}
	}
	
	public void move(){	
		if(UserInput.Shoot==true){
			shoot();
		}
		if(shotTimer>0){
			shotTimer--;
		}
		Coordinates newLoc = moveType.move(xLoc, yLoc, vel);
		yLoc = newLoc.getYLoc();
		xLoc = newLoc.getXLoc();
	}
}