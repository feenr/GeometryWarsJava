package Objects;

import java.awt.Color;
import java.awt.Graphics;
import Utilities.NuetralUtilities;
import GameControls.GameInfo;
import Utilities.Coordinates;

public class Line extends GameObject{
	private Coordinates[] pointOrigins;
	private Coordinates[] points;
	private boolean vertical;
	//private int location, segments;
	private int affectDistance = 50;
	
	public Line(boolean vertical, int location, int segments){
		this.vertical=vertical;
		points = new Coordinates[segments+1];
		pointOrigins = new Coordinates[segments+1];
		int begin;
		int end;
		double increment;
		int pointer=0;
		if(vertical){
			begin = GameInfo.yBegin;
			end = GameInfo.yEnd;
		}else{
			begin = GameInfo.xBegin;
			end = GameInfo.xEnd;
		}
		increment = (double)(end-begin)/(double)(segments);
		for(int i = 0; i<=segments; i++){
			int tempLoc = begin+(int)(i*increment);
			if(vertical){
				points[pointer]= new Coordinates(location ,tempLoc);
			}else{
				points[pointer]= new Coordinates(tempLoc, location);
			}
			pointer++;
		}
		pointer=0;
		for(int i = 0; i<=segments; i++){
			int tempLoc = begin+(int)(i*increment);
			if(vertical){
				pointOrigins[pointer]= new Coordinates(location ,tempLoc);
			}else{
				pointOrigins[pointer]= new Coordinates(tempLoc, location);
			}
			pointer++;
		}
	}
	
	public void move(){
		for(int i = 1; i < points.length; i++){
			Coordinates point = pointOrigins[i];
			Coordinates closestProjectile=NuetralUtilities.getClosestProjectile(point.yLoc, point.xLoc);
			if(NuetralUtilities.calcDistance(point, closestProjectile)<affectDistance){
				point= new Coordinates(point.xLoc+(point.xLoc-closestProjectile.xLoc), point.yLoc+(point.yLoc-closestProjectile.yLoc));
				points[i]=point;
			}
			else{
				//points[i]=new Coordinates(pointOrigins[i].xLoc, pointOrigins[i].yLoc);
				//This is wrong
				if((int)points[i].xLoc!=(int)pointOrigins[i].xLoc&&(int)points[i].yLoc!=(int)pointOrigins[i].yLoc){
					points[i]=new Coordinates((points[i].xLoc+pointOrigins[i].xLoc)/2,(points[i].yLoc+pointOrigins[i].yLoc)/2);
				}
				else{
					points[i]=new Coordinates(pointOrigins[i].xLoc, pointOrigins[i].yLoc);	
				}
			}
		}
	}
	
	public Graphics Draw(Graphics g){
		g.setColor(Color.LIGHT_GRAY);
		for(int i = 1; i < points.length; i++){
			Coordinates start = points[i-1];
			Coordinates end = points[i];
			g.drawLine((int)start.xLoc, (int)start.yLoc, (int)end.xLoc, (int)end.yLoc);
		}
		return g;
	}
}
