package Utilities;

public class Coordinates {
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
}
