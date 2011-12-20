package Sprites;

import javax.swing.JPanel;
import Objects.*;

public class Sprite extends GameObject{
	int height, width;
	boolean isAlive;
	
	public Sprite(){
		isAlive=true;
	}
	
	public int getYLoc(){
		return (int)yLoc;
	}
	
	public void setYLoc(int yLoc){
		this.yLoc=yLoc;
	}
	
	public int getXLoc(){
		return (int)xLoc;
	}
	
	public void setXLoc(int yLoc){
		this.xLoc=yLoc;
	}
	
	public boolean isAlive(){
		return isAlive;
	}
}
