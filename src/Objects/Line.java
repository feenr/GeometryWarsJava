package Objects;

import java.awt.Color;
import java.awt.Graphics;
import Utilities.NuetralUtilities;
import GameControls.GameInfo;
import Utilities.Coordinates;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;

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
			Coordinates closestProjectile=NuetralUtilities.getClosestProjectile(point.xLoc, point.yLoc);
			//If there is a projectile within affect distance, move current point away from it 
                        if(NuetralUtilities.calcDistance(point, closestProjectile)<affectDistance){
				point= new Coordinates(point.xLoc+(point.xLoc-closestProjectile.xLoc), point.yLoc+(point.yLoc-closestProjectile.yLoc));
			}
                        //If there isn't ease points back towards their origin (This easing is clearly broken)
			else{
				if((int)points[i].xLoc!=(int)pointOrigins[i].xLoc&&(int)points[i].yLoc!=(int)pointOrigins[i].yLoc){
					point =new Coordinates((points[i].xLoc+pointOrigins[i].xLoc)/2,(points[i].yLoc+pointOrigins[i].yLoc)/2);
				}
			}
                        points[i] = point;
		}
	}
	
	public Graphics Draw(Graphics g){
                Graphics2D g2 = (Graphics2D)g;
		g.setColor(Color.LIGHT_GRAY);
		for(int i = 1; i < points.length; i++){
			Coordinates start = points[i-1];
			Coordinates end = points[i];
                        //Stroke oldStroke = g2.getStroke();
                        //Color oldColor = g2.getColor();
                        //g2.setColor(new Color(0,0,0, 90));
                        //g2.setStroke(new BasicStroke(2));
                        //g2.drawLine((int)start.xLoc, (int)start.yLoc, (int)end.xLoc, (int)end.yLoc);
                        //g2.setColor(oldColor);
                        //g2.setStroke(oldStroke);
			g.drawLine((int)start.xLoc, (int)start.yLoc, (int)end.xLoc, (int)end.yLoc);
                }
		return g;
	}
}
