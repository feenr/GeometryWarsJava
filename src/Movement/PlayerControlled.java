package Movement;

import Utilities.Coordinates;
import GameControls.*;

public class PlayerControlled implements Movement {

	public Coordinates move(double xLoc, double yLoc, double vel) {
		if(UserInput.Up==true){
			yLoc-=vel;
		}
		if(UserInput.Down==true){
			yLoc+=vel;
		}
		if(UserInput.Right==true){
			xLoc+=vel;
		}
		if(UserInput.Left==true){
			xLoc-=vel;
		}
		
		if(xLoc < GameInfo.xBegin){
			xLoc = GameInfo.xBegin;
		}
		if(xLoc > GameInfo.xEnd){
			xLoc = GameInfo.xEnd;
		}
		if(yLoc< GameInfo.yBegin){
			yLoc = GameInfo.yBegin;
		}
		if(yLoc>GameInfo.yEnd){
			yLoc = GameInfo.yEnd;
		}
		Coordinates newLoc = new Coordinates(xLoc, yLoc);
		return newLoc;
	}
}
