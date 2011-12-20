package Movement;

import GameControls.GameInfo;
import Utilities.Coordinates;

public class Random implements Movement{
	double angle;
	double xVel;
	double yVel;
	double vel;
	public Random(){
		angle = Math.random()*360;
		setVelocities();
	}
	
	public Random(double angle, double vel){
		this.angle=angle;
		this.vel=vel;
		setVelocities();
	}
	
	public void setVelocities(){
		xVel = Math.sin(angle)*vel;
		yVel = Math.cos(angle)*vel;
	}
	
	public Coordinates move(double xLoc, double yLoc, double vel) {
		if(this.vel!=vel){
			this.vel=vel;
			setVelocities();
		}
		xLoc += xVel;
		yLoc += yVel;
		
		if(xLoc>GameInfo.xEnd){
			//bounce x axis
			xVel=-xVel;
			xLoc=GameInfo.xEnd+xVel;
		}
		if(xLoc<GameInfo.xBegin){
			xVel=-xVel;
			xLoc=GameInfo.xBegin+xVel;
		}
		
		if(yLoc<GameInfo.yBegin){
			//bounce y axis
			yVel=-yVel;
			yLoc = GameInfo.yBegin+yVel;
		}
		
		if(yLoc>GameInfo.yEnd){
			yVel=-yVel;
			yLoc = GameInfo.yEnd+yVel;
		}
		
		return new Coordinates(xLoc, yLoc);
	}

}
