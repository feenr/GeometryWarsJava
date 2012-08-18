package Objects;

import java.awt.Color;
import java.awt.Graphics;

import GameControls.GameInfo;
import Movement.*;
import Utilities.Coordinates;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

public class GameObject {
	protected double yLoc, xLoc, vel, size;
	protected Movement moveType;
	protected boolean isAlive=true;
	protected Color shadowColor = new Color(200,200,200, 100);
	private Color transparent = new Color(240,240,240, 0);
	
	public GameObject(){
		
	}
	
	public Graphics Draw(Graphics g){
		g.setColor(Color.BLUE);
		g.drawOval(getXLoc(), getYLoc(), 5, 5);
		return g;
	}
        
        public Graphics DrawShadow(Graphics g){
                int offset = 5;
                Graphics2D g2 = (Graphics2D)g;
                //Paint oldPaint = g2.getPaint();
                //RadialGradientPaint colorToTrans = new RadialGradientPaint((int)xLoc-2, (int)yLoc-2, 20, new float[] { 0.0f, 1.0f }, new Color[] { Color.lightGray, new Color(240,240,240, 0) });
                //Stroke oldStroke = g2.getStroke();
                
                
                
                Point2D center = new Point2D.Float((int)xLoc+offset, (int)yLoc+offset);
                float radius = 25;
                //Point2D focus = new Point2D.Float((int)xLoc, (int)yLoc);
                float[] dist = {0.0f, 0.6f};
                Color[] colors = {shadowColor, transparent};
                RadialGradientPaint p =
                    new RadialGradientPaint(center, radius, center,
                                            dist, colors,
                                            CycleMethod.NO_CYCLE);
                
                
                g2.setPaint(p);
                g2.fillOval((int)(xLoc-.5*size)+offset, (int)(yLoc-.5*size)+offset, 20, (int)size);
                return g2;
        }
	
	public double getVel() {
		return vel;	
	}
	
	public void setYLoc(int loc){
		yLoc = loc;
	}
	
	public void setYLoc(double loc){
		yLoc = loc;
	}
	
	public int getYLoc(){
		return (int)yLoc;
	}
	
	public void setXLoc(int loc){
		xLoc = loc;
	}
	
	public void setXLoc(double loc){
		xLoc = loc;
	}
	
	public int getXLoc(){
		return (int)xLoc;
	}
	
	public double getSize(){
		return size;
	}
	
	public boolean isAlive(){
		return isAlive;
	}
	
	protected void setMovementType(Movement moveType){
		this.moveType = moveType;
	}
	
	public void move(){	
		Coordinates newLoc = moveType.move(xLoc, yLoc, vel);
		yLoc = newLoc.getYLoc();
		xLoc = newLoc.getXLoc();
	}

	public void hit() {
		isAlive = false;
	}
}
