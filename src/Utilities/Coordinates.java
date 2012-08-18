package Utilities;

import java.awt.geom.Point2D;


//This should be replaced with java.awt.Point
public class Coordinates extends Point2D{
	public double yLoc, xLoc;
	
	public Coordinates(int xLoc, int yLoc){
		this.xLoc = xLoc;
		this.yLoc = yLoc;
	}
	
	public Coordinates(double xLoc, double yLoc){
		this.xLoc = xLoc;
		this.yLoc = yLoc;
	}
	
	public double getYLoc(){
		return yLoc;
	}
	public double getXLoc(){
		return xLoc;
	}
	public String toString(){
		return xLoc+", "+yLoc;
	}

	
	
	
	
	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return xLoc;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return yLoc;
	}

	@Override
	public void setLocation(double arg0, double arg1) {
		xLoc = arg0;
		yLoc = arg1;	
	}
}
