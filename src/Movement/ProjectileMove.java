package Movement;

import GameControls.GameInfo;
import Objects.Projectile;
import Utilities.Coordinates;

public class ProjectileMove implements Movement{
	double angle;
	double vel;
	double xVel;
	double yVel;
	int index;
	
	public ProjectileMove(double angle){
		this.angle = angle;
		setVelocities();
	}
	
	public void setVelocities(){
		xVel = Math.cos(angle)*vel;
		yVel = Math.sin(angle)*vel;
	}
	public Coordinates move(double xLoc, double yLoc, double vel) {
		if(this.vel!=vel){
			this.vel = vel;
			setVelocities();
		}
		yLoc += yVel;
		xLoc += xVel;
		
		return new Coordinates(xLoc, yLoc);
	}

}
