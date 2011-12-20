package GameControls;
import Sprites.*;

public class SpawnPoint {
	public int xLoc, yLoc;
	
	public SpawnPoint(int xLoc, int yLoc){
		this.xLoc = xLoc;
		this.yLoc = yLoc;
	}
	
	public void spawn(int numSpawns){
		for(int i = 0; i<numSpawns;i++){
			int randomSpawn = (int)(Math.random()*4);
			Enemy enemy;
			if(randomSpawn == 0){
				enemy = new EnemeyFollower();
			}
			else if(randomSpawn == 1){
				enemy = new EnemyParent();
			}else if(randomSpawn ==2){
				enemy = new EnemyRandomWalker();
			}else if(randomSpawn ==3){
				enemy=new EnemyDodger();
			}else{
				enemy=new EnemyDodger();
			}
			enemy.setXLoc(xLoc+(int)(Math.random()*40-20));
			enemy.setYLoc(yLoc+(int)(Math.random()*40-20));
			GameInfo.enemies.add(enemy);
		}
	}
}
