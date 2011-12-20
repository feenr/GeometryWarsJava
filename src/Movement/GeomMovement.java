package Movement;

import GameControls.GameInfo;
import Utilities.*;
public class GeomMovement implements Movement{
	double angle;
	double xVel;
	double yVel;
	double vel;
	double startTime;
	double maxTime = 10;
	
	public GeomMovement(){
		angle = Math.random()*360;
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
		Coordinates playerLoc = EnemyUtilities.getClosestPlayer(yLoc, xLoc);
		if(NuetralUtilities.calcDistance(new Coordinates(xLoc, yLoc), playerLoc)<80.0){
			double angle = Math.atan2(yLoc-playerLoc.yLoc, playerLoc.xLoc - xLoc);
			xLoc += Math.cos(angle)*2*vel;
			yLoc -= Math.sin(angle)*2*vel;
		}else{
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
		}
		return new Coordinates(xLoc, yLoc);
	}

}