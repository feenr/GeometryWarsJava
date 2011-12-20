package Sprites;

import java.awt.Color;
import java.awt.Graphics;

import GameControls.GameInfo;
import Movement.Dodger;
import Movement.Follower;
import Utilities.Coordinates;
import java.awt.GradientPaint;

public class EnemyDodger extends Enemy{
        
	public EnemyDodger(){
		size = 7;
		vel = 2;
		setMovementType(new Dodger());
	}
	
	//this logic should be bumped down into Dodger
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
                GradientPaint colorToTrans = new GradientPaint((int)xLoc, (int)yLoc, Color.orange, 10, (int)yLoc, Color.white);
                g.setColor(Color.orange);
		g.drawLine((int)(xLoc+size), (int)yLoc, (int)xLoc, (int)(yLoc+size));
		g.drawLine((int)xLoc, (int)(yLoc+size), (int)(xLoc-size), (int)yLoc);
		g.drawLine((int)(xLoc-size), (int)yLoc, (int)xLoc, (int)(yLoc-size));
		g.drawLine((int)xLoc, (int)(yLoc-size), (int)(xLoc+size), (int)yLoc);
		//g.drawOval(getXLoc()-(int)size, getYLoc()-(int)size, (int)(2*size), (int)(2*size));
		return g;
	}
}
 