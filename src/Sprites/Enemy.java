package Sprites;
import GameControls.GameInfo;
import Objects.*;
import Utilities.SoundUtilities;

public class Enemy extends Sprite{
	public void hit(){
		for(int x = 0; x<5;x++){
			SingleBurst burst = new SingleBurst(xLoc, yLoc);
			burst.setXLoc((int)xLoc);
			burst.setYLoc((int)yLoc);
			GameInfo.effects.add(burst);
		}
		for (int x = 0; x<1; x++){
			Geom geom = new Geom(xLoc, yLoc);
			GameInfo.geoms.add(geom);
		}
		GameInfo.playerScore+=2*GameInfo.playerMultiplier;
		isAlive = false;
                SoundUtilities.playSound("Resources/Bubble-pop.wav");
	}
}
