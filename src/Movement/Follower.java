package Movement;

import Utilities.*;

public class Follower implements Movement{

	public Coordinates move(double xLoc, double yLoc, double vel) {
		try{
			Coordinates target = EnemyUtilities.getClosestPlayer(xLoc, yLoc);
			double angle = Math.atan2(yLoc-target.yLoc, target.xLoc - xLoc);
			xLoc += Math.cos(angle)*vel;
			yLoc -= Math.sin(angle)*vel;
			Coordinates Coords = new Coordinates(xLoc, yLoc);
			return Coords;
		}
		catch(Exception e){
			return new Coordinates(xLoc+Math.random()+2, yLoc+Math.random()+2);
		}
	}
}
