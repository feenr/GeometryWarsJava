package GameControls;

/**
 * This thread controls all of the games actions with the exception of drawing the display.
 * 
 **/
import Objects.*;
import Sprites.*;
import Utilities.*;

public class GameControl implements Runnable {
	double globalTimer = 0; 	// Contains the time since the game started (or
								// restarted)
	double startTime; 			// Contains the time of game start (or restart)
	double lastSpawn; 			// The game time at which the last spawn occured
	double spawnInterval; 		// The frequency at which enemies should be spawned

	public GameControl() { 		// Begins a new game upon execution
		newGame();
	}

	public void newGame() { 	// Reverts all the game settings to the new game state.
		startTime = System.nanoTime();
		//Wall walls = new Wall();

		GameInfo.projectiles.clear();
		GameInfo.players.clear();
		GameInfo.enemies.clear();
		GameInfo.spawns.clear();
		GameInfo.geoms.clear();
		GameInfo.effects.clear();
		//GameInfo.objects.add(walls);
		GameInfo.playerScore = 0;
		GameInfo.playerMultiplier = 1;
		GameInfo.difficulty = 1;

		GameInfo.spawns.add(new SpawnPoint(30, 30));
		GameInfo.spawns.add(new SpawnPoint(1100, 30));
		GameInfo.spawns.add(new SpawnPoint(1100, 700));
		GameInfo.spawns.add(new SpawnPoint(30, 700));
		lastSpawn = 0;
		spawnInterval = 4;
		
		for(int x = GameInfo.xBegin+100; x<GameInfo.xEnd; x+=100){
			GameInfo.effects.add(new Line(true, x, 15));	
		}
		for(int y = GameInfo.yBegin+100; y<GameInfo.yEnd; y+=100){
			GameInfo.effects.add(new Line(false, y, 15));	
		}
		
		Player ryan = new Player();
		ryan.setYLoc(300);
		ryan.setXLoc(500);
		GameInfo.players.add(ryan);
	}

	public void run() { 			// Performs regular game functions.
		while (true) {
			updateTime();
			//double startTime;
			//startTime = System.nanoTime();
			MoveObjects();
			//double moveTime = System.nanoTime()-startTime;
			//startTime = System.nanoTime();
			CheckCollisions();
			//double collisionTime = System.nanoTime()-startTime;
			//startTime = System.nanoTime();
			CheckSpawns();
			//double spawnTime = System.nanoTime()-startTime;
			//double fullTime = spawnTime+collisionTime+moveTime;
			//System.out.println("Time moving objects: "+moveTime/fullTime*100);
			//System.out.println("Time checking collisions: "+collisionTime/fullTime*100);
			//System.out.println("Time checking spawns: "+spawnTime/fullTime*100);
			//System.out.println();
			
			try {
				Thread.sleep(20); 	// Prevents the run method from being called
									// more often then necessary
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (UserInput.Restart == true) { // Check if the user requested a new game
				newGame();
			}
		}
	}

	public void MoveObjects() {
		//double startTime = System.nanoTime();
		for (int i = 0; i < GameInfo.enemies.size(); i++) {
			GameInfo.enemies.elementAt(i).move();
		}
		
		for (int i = 0; i < GameInfo.players.size(); i++) {
			GameInfo.players.elementAt(i).move();
		}
		
		for (int i = 0; i < GameInfo.geoms.size(); i++) {
			GameInfo.geoms.elementAt(i).move();
		}
		
		for (int i = 0; i < GameInfo.projectiles.size(); i++) {
			GameInfo.projectiles.elementAt(i).move();
		}
		
		for (int i = 0; i < GameInfo.effects.size(); i++) {
			GameInfo.effects.elementAt(i).move();
		}
		//System.out.println("Move Objects time: "+(System.nanoTime()-startTime));
	}

	public void CheckSpawns() {
		//double startTime = System.nanoTime();
		if (GameInfo.globalTimer - lastSpawn > (spawnInterval)) {
			for (int i = 0; i < GameInfo.spawns.size(); i++) {
				SpawnPoint spawner = GameInfo.spawns.get(i);
				spawner.spawn(GameInfo.difficulty);
			}
			lastSpawn = GameInfo.globalTimer;
		}
		//System.out.println("Check Spawns time: "+(System.nanoTime()-startTime));
	}

	public void CheckCollisions() {
		//double startTime = System.nanoTime();
		//Check for collisions between players an enemies
		for (int i = 0; i < GameInfo.players.size(); i++) {
			Coordinates playerCoords = new Coordinates(GameInfo.players.elementAt(i).getXLoc(),GameInfo.players.elementAt(i).getYLoc());
			for (int j = 0; j < GameInfo.enemies.size(); j++) {
				Coordinates enemyCoords = new Coordinates(GameInfo.enemies.elementAt(j).getXLoc(),GameInfo.enemies.elementAt(j).getYLoc());
				double distance = NuetralUtilities.calcDistance(playerCoords, enemyCoords);
				if (distance < GameInfo.enemies.elementAt(j).getSize()+ GameInfo.players.elementAt(i).getSize()) {
					GameInfo.players.elementAt(i).hit();
					GameInfo.enemies.elementAt(j).hit();
				}
			}
			for(int j = 0; j < GameInfo.geoms.size(); j++){
				Coordinates geomCoords = new Coordinates(GameInfo.geoms.elementAt(j).getXLoc(),GameInfo.geoms.elementAt(j).getYLoc());
				double distance = NuetralUtilities.calcDistance(playerCoords, geomCoords);
				if(distance < GameInfo.geoms.elementAt(j).getSize()+GameInfo.players.elementAt(i).getSize()){
					GameInfo.geoms.elementAt(j).hit();
				}
			}
		}
		
		//Check for collisions between enemies and objects
		for (int i = 0; i < GameInfo.enemies.size(); i++ ){
			for (int j = 0; j < GameInfo.projectiles.size(); j++) {
				Coordinates enemyCoords = new Coordinates(GameInfo.enemies.elementAt(i).getXLoc(), GameInfo.enemies.elementAt(i).getYLoc());
				Coordinates objectCoords = new Coordinates(GameInfo.projectiles.elementAt(j).getXLoc(), GameInfo.projectiles.elementAt(j).getYLoc());
				double distance = NuetralUtilities.calcDistance(enemyCoords, objectCoords);
				if (distance < GameInfo.enemies.elementAt(i).getSize()+GameInfo.projectiles.elementAt(j).getSize()) {
					if(GameInfo.projectiles.elementAt(j).isAlive()){
						GameInfo.enemies.elementAt(i).hit();
						GameInfo.projectiles.elementAt(j).hit();
					}
				}
			}
		}

		//Remove objects which have been destroyed
		for(int i=GameInfo.players.size()-1; i>=0; i--){
			if(GameInfo.players.elementAt(i).isAlive()==false){
				GameInfo.players.remove(i);
			}
		}
		for(int i=GameInfo.enemies.size()-1; i>=0; i--){
			if(GameInfo.enemies.elementAt(i).isAlive()==false){
				GameInfo.enemies.remove(i);
			}
		}
		for(int i=GameInfo.projectiles.size()-1; i>=0; i--){
			if(GameInfo.projectiles.elementAt(i).isAlive()==false){
				GameInfo.projectiles.remove(i);
			}
		}
		for(int i=GameInfo.effects.size()-1; i>=0; i--){
			if(GameInfo.effects.elementAt(i).isAlive()==false){
				GameInfo.effects.remove(i);
			}
		}
		for(int i=GameInfo.geoms.size()-1; i>=0; i--){
			if(GameInfo.geoms.elementAt(i).isAlive()==false){
				GameInfo.geoms.remove(i);
			}
		}
		//System.out.println("Check Collisions time: "+(System.nanoTime()-startTime));
	}
	
	//Update the global game timer
	public void updateTime() {
		GameInfo.globalTimer = (System.nanoTime() - startTime) / (Math.pow(10, 9));
	}
}
