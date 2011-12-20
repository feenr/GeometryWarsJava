package GameControls;
import java.util.Vector;

import Objects.GameObject;
import Objects.Geom;
import Sprites.*;

public class GameInfo {
	public static double globalTimer;
	public static int playerScore, playerMultiplier, difficulty;
	public static int xBegin=10, xEnd=1175, yBegin=10, yEnd=750;
	public static Vector<Sprite> enemies = new Vector();
	public static Vector<Player> players= new Vector();
	public static Vector<GameObject> projectiles= new Vector();
	public static Vector<GameObject> geoms = new Vector();
	public static Vector<SpawnPoint> spawns= new Vector();
	public static Vector<GameObject> effects= new Vector();
	public static int boardHeight, BoardWidth;
	
}
