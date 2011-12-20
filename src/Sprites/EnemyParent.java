package Sprites;

import java.awt.Color;
import java.awt.Graphics;

import GameControls.GameInfo;
import Movement.Follower;
import Movement.Spinner;
import Objects.Geom;
import Objects.SingleBurst;
import Utilities.Coordinates;

public class EnemyParent extends Enemy{
	
	public EnemyParent(){
		size = 10;
		vel = 2;
		setMovementType(new Follower());
	}
	public void hit(){
		for (int x = 0; x<2; x++){
			Enemy child = new EnemyChild(xLoc, yLoc);
			GameInfo.enemies.add(child);
		}
		GameInfo.playerScore+=2*GameInfo.playerMultiplier;
		isAlive = false;
	}

	public void move(){
		if(GameInfo.players.isEmpty()==false){
		Coordinates newLoc = moveType.move(xLoc, yLoc, vel);
			yLoc = newLoc.getYLoc();
			xLoc = newLoc.getXLoc();
		}
		else{//If no players exist
			yLoc+=Math.random()*4-2;
			xLoc+=Math.random()*4-2;

			if(xLoc>GameInfo.xEnd){
				//bounce x axis
				xLoc=GameInfo.xEnd;
			}
			if(xLoc<GameInfo.xBegin){
				xLoc=GameInfo.xBegin;
			}
			
			if(yLoc<GameInfo.yBegin){
				//bounce y axis
				yLoc = GameInfo.yBegin;
			}
			
			if(yLoc>GameInfo.yEnd){
				yLoc = GameInfo.yEnd;
			}
		}
	}
	
	public Graphics Draw(Graphics g){
		g.setColor(Color.cyan);
		g.drawOval(getXLoc()-(int)size, getYLoc()-(int)size, (int)(2*size), (int)(2*size));
		return g;
	}
}
