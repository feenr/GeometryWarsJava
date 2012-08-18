package GameControls;
import java.util.ArrayList;
import java.util.Vector;

import Objects.GameObject;
import Objects.Geom;
import Sprites.*;

public class GameInfo {
	public static double globalTimer;
	public static int playerScore, playerMultiplier, difficulty;
	public static int xBegin=10, xEnd=1175, yBegin=10, yEnd=750;
	public static ArrayList<Sprite> enemies = new ArrayList<Sprite>();
	public static ArrayList<Player> players= new ArrayList<Player>();
	public static ArrayList<GameObject> projectiles= new ArrayList<GameObject>();
	public static ArrayList<GameObject> geoms = new ArrayList<GameObject>();
	public static ArrayList<SpawnPoint> spawns= new ArrayList<SpawnPoint>();
	public static ArrayList<GameObject> effects= new ArrayList<GameObject>();
	public static int boardHeight, BoardWidth;
	
	//Display settings;
	public static boolean shadowsEnabled = true;
	public static boolean projectileSplashEnabled = false;
}
