package Objects;

import java.awt.Color;
import java.awt.Graphics;

import GameControls.GameInfo;
import Movement.*;
import Utilities.Coordinates;

public class GameObject {
	protected double yLoc, xLoc, vel, size;
	protected Movement moveType;
	protected boolean isAlive=true;
	
	public GameObject(){
		
	}
	
	public Graphics Draw(Graphics g){
		g.setColor(Color.BLUE);
		g.drawOval(getXLoc(), getYLoc(), 5, 5);
		return g;
	}
	
	public double getVel() {
		return vel;	
	}
	
	public void setYLoc(int loc){
		yLoc = loc;
	}
	
	public void setYLoc(double loc){
		yLoc = loc;
	}
	
	public int getYLoc(){
		return (int)yLoc;
	}
	
	public void setXLoc(int loc){
		xLoc = loc;
	}
	
	public void setXLoc(double loc){
		xLoc = loc;
	}
	
	public int getXLoc(){
		return (int)xLoc;
	}
	
	public double getSize(){
		return size;
	}
	
	public boolean isAlive(){
		return isAlive;
	}
	
	protected void setMovementType(Movement moveType){
		this.moveType = moveType;
	}
	
	public void move(){	
		Coordinates newLoc = moveType.move(xLoc, yLoc, vel);
		yLoc = newLoc.getYLoc();
		xLoc = newLoc.getXLoc();
	}

	public void hit() {
		isAlive = false;
	}
}
