package Sprites;
import java.awt.Color;
import java.awt.Graphics;

import GameControls.GameInfo;
import Movement.*;
import Utilities.Coordinates;
import Utilities.EnemyUtilities;
import Utilities.NuetralUtilities;


// I know I its spelled enemy....
public class EnemeyFollower extends Enemy{
	public EnemeyFollower(){
		vel = 4;
		size = 20;
		setMovementType(new Follower());
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
		g.setColor(Color.BLUE);
		g.drawOval(getXLoc()-(int)(0.5*size), getYLoc()-(int)(0.5*size), (int)(size), (int)(size));
		return g;
	}
}
