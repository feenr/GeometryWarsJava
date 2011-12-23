package Movement;

import Utilities.Coordinates;
import Utilities.EnemyUtilities;

public class Dodger implements Movement{
	int dodgeRadius = 50;
	int dodgeSpeed = 2;
	public Coordinates move(double xLoc, double yLoc, double vel) {
		try{
			Coordinates target = EnemyUtilities.getClosestPlayer(xLoc, yLoc);
			double angle = Math.atan2(yLoc-target.yLoc, target.xLoc - xLoc);
			xLoc += Math.cos(angle)*vel;
			yLoc -= Math.sin(angle)*vel;
			Coordinates fleeFrom = EnemyUtilities.getClosestProjectile(xLoc, yLoc);
			EnemyUtilities.calcDistance(fleeFrom, new Coordinates(xLoc, yLoc));
			if(EnemyUtilities.calcDistance(fleeFrom, new Coordinates(xLoc, yLoc))<dodgeRadius){
				angle = Math.atan2(yLoc-fleeFrom.yLoc, fleeFrom.xLoc - xLoc);
				xLoc-=Math.cos(angle)*dodgeSpeed;
				yLoc+=Math.sin(angle)*dodgeSpeed;
			}
			Coordinates Coords = new Coordinates(xLoc, yLoc);
			return Coords;
		}
		catch(Exception e){
			return new Coordinates(xLoc+Math.random()+2, yLoc+Math.random()+2);
		}
	}
	
	
}
