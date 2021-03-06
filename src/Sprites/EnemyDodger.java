package Sprites;

import java.awt.Color;
import java.awt.Graphics;

import GameControls.GameInfo;
import Movement.Dodger;
import Movement.Follower;
import Utilities.Coordinates;
import java.awt.BasicStroke;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;

public class EnemyDodger extends Enemy{
        
	public EnemyDodger(){
		size = 20;
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
                Graphics2D g2 = (Graphics2D)g;
                double size = 0.5 * this.size;
                g2.setColor(Color.orange);
                g2.drawLine((int)(xLoc+size), (int)yLoc, (int)xLoc, (int)(yLoc+size));
		g2.drawLine((int)xLoc, (int)(yLoc+size), (int)(xLoc-size), (int)yLoc);
		g2.drawLine((int)(xLoc-size), (int)yLoc, (int)xLoc, (int)(yLoc-size));
		g2.drawLine((int)xLoc, (int)(yLoc-size), (int)(xLoc+size), (int)yLoc);
		//g.drawOval(getXLoc()-(int)size, getYLoc()-(int)size, (int)(2*size), (int)(2*size));
                return g2;
	}
}
 