package Utilities;

import GameControls.GameInfo;

public class NuetralUtilities {
	public static final double noHit = Integer.MIN_VALUE;
	
	public static double calcDistance(Coordinates a, Coordinates b){
		double xDistance = a.getXLoc()-b.getXLoc();
		double yDistance = a.getYLoc()-b.getYLoc();
		return Math.sqrt(Math.pow(xDistance, 2)+Math.pow(yDistance, 2));
	}
	public static Coordinates getClosestProjectile(double xLoc, double yLoc){
		Coordinates projectileLocation = new Coordinates(0, 0);
		double closestProjectile = Integer.MAX_VALUE;
		for(int i=0; i<GameInfo.projectiles.size(); i++){
			double projectileX =GameInfo.projectiles.elementAt(i).getXLoc();
			double projectileY =GameInfo.projectiles.elementAt(i).getYLoc();
			double xDist =Math.abs(xLoc-projectileX);
			if(xDist<closestProjectile){
				double yDist =Math.abs(yLoc-projectileY); 
				if(yDist<closestProjectile){
					double distance = Math.sqrt(Math.pow(xDist, 2)+Math.pow(yDist, 2));
					if(distance<closestProjectile){
						closestProjectile = distance;
						projectileLocation.xLoc = projectileX;
						projectileLocation.yLoc = projectileY;
					}
				}
			}
		}
		return projectileLocation;
	}
	public static Coordinates getClosestEnemy(double xLoc, double yLoc){
		Coordinates enemyLocation = new Coordinates(0, 0);
		double closestEnemy = Integer.MAX_VALUE;
		for(int i=0; i<GameInfo.enemies.size(); i++){
			double enemyX =GameInfo.enemies.elementAt(i).getXLoc();
			double enemyY =GameInfo.enemies.elementAt(i).getYLoc();
			double xDist = xLoc-enemyX;
			if(xDist<closestEnemy){
				double yDist = yLoc-enemyY;
				if(yDist<closestEnemy){
					double distance = Math.sqrt(Math.pow(xDist, 2)+Math.pow(yDist, 2));
					if(distance<closestEnemy){
						closestEnemy = distance;
						enemyLocation.xLoc = enemyX;
						enemyLocation.yLoc = enemyY;
					}
				}
			}
		}
		return enemyLocation;
	}
	public static Coordinates getClosestPlayer(double xLoc, double yLoc){
		Coordinates playerLocation = new Coordinates(0, 0);
		double closestPlayer = Integer.MAX_VALUE;
		for(int i=0; i<GameInfo.players.size(); i++){
			double playerX =GameInfo.players.elementAt(i).getXLoc();
			double playerY =GameInfo.players.elementAt(i).getYLoc();
			double xDist =xLoc-playerX;
			if(xDist<closestPlayer){
				double yDist =yLoc-playerY;
				if(yDist<closestPlayer){
					double distance = Math.sqrt(Math.pow(xDist, 2)+Math.pow(yDist, 2));
					if(distance<closestPlayer){
						closestPlayer = distance;
						playerLocation.xLoc = playerX;
						playerLocation.yLoc = playerY;
					}
				}
			}
		}
		return playerLocation;
	}
}
