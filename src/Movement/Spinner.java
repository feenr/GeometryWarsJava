package Movement;

import GameControls.GameInfo;
import Utilities.Coordinates;

public class Spinner implements Movement{
	double xCenter, yCenter;
	double xOffset, yOffset;
	double sinLoc;
	double radius=20;
	double spinSpeed=.1;
	double angle;
	double offsetAngle;
	double vel, xVel, yVel;

	public Spinner(){
		angle = Math.random()*360;
		setVelocities();
	}
	

	public void setVelocities(){
		xVel = Math.sin(angle)*vel;
		yVel = Math.cos(angle)*vel;
	}
	
	
	public Coordinates move(double loc, double loc2, double vel) {
		// TODO Auto-generated method stub
		if(this.vel!=vel){
			this.vel=vel;
			setVelocities();
		}
		xCenter=loc-xOffset;
		yCenter=loc2-yOffset;
		xCenter+=xVel;
		yCenter+=yVel;
		sinLoc+=spinSpeed;
		offsetAngle = Math.sin(sinLoc);
		xOffset = Math.cos(sinLoc)*radius;
		yOffset = Math.sin(sinLoc)*radius;
		double xLoc = xCenter+xOffset;
		double yLoc = yCenter+yOffset;
		if(xLoc<GameInfo.xBegin){
			xLoc = GameInfo.xBegin;
			xVel=-xVel;
		}
		if(xLoc>GameInfo.xEnd){
			xLoc = GameInfo.xEnd;
			xVel=-xVel;
		}
		if(yLoc<GameInfo.yBegin){
			yLoc = GameInfo.yBegin;
			yVel = -yVel;
		}
		if(yLoc>GameInfo.yEnd){
			yLoc = GameInfo.yEnd;
			yVel = -yVel;
		}
		return new Coordinates(xLoc, yLoc);
	}
}
