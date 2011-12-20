package Movement;

import Utilities.Coordinates;

public class NoMove implements Movement{

	@Override
	public Coordinates move(double xLoc, double yLoc, double Vel) {
		// TODO Auto-generated method stub
		return new Coordinates(xLoc, yLoc);
	}

}
