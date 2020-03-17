package character;

import controls.Control;
import theGame.state.*;
import map.Map;
import tile.Tile;

public class Character extends Entity{
	private boolean canShoot=false;
	private int counter=0;
	private int cooldown=30;
	private int colX=(int)((posX/Tile.TILEWIDTH)+0.5);
	private int colY=(int)((posY/Tile.TILEHIGHT)+1);
	
	public Character(int posX, int posY){
		super(posX, posY,"/res/character/mainCharacter");
	}
	public void shoot() {
		GameState.pushCharacterBullet(getDirection(), posX, posY);
		canShoot=false;
	}
	public void update() {
		colX=(int)((posX/Tile.TILEWIDTH)+0.75);
		colY=(int)((posY/Tile.TILEHIGHT)+1);
		//And timer is ready
		//System.out.println(Map.getTile((int)((posX/Tile.TILEWIDTH)+0.5),(int)((posY/Tile.TILEHIGHT)+1)).getId());
		//Map.getTile((int)posX,(int)posY);
		//x*Tile.TILEWIDTH,y*Tile.TILEHIGHT
		//System.out.println((int)((posX/Tile.TILEWIDTH)+0.5)+" "+(int)((posY/Tile.TILEHIGHT)+1));
		if(counter > cooldown) {
			counter = 0;
			canShoot = true;
		}
		if (canShoot==false)
			counter++;
		if(Control.spaceBar && canShoot) {
			shoot();
		}
		moving=true;
		if(Control.getDirection()[Direction.UP.ordinal()]==true) {
			if(Control.getDirection()[Direction.LEFT.ordinal()]==true) {
				//moveLeftUp();
			}
			else if (Control.getDirection()[Direction.RIGHT.ordinal()]==true) {
				//moveRightUp();
			}
			else {
				//Handles basic collision...
				if(!Map.getTile((int)((posX/Tile.TILEWIDTH)+0.5),colY).isSolid()) {
					moveUp();
				}
			return;
			}
		}
		else if(Control.getDirection()[Direction.DOWN.ordinal()]==true) {
			if(Control.getDirection()[Direction.LEFT.ordinal()]==true) {
				//moveLeftDown();
			}
			else if (Control.getDirection()[Direction.RIGHT.ordinal()]==true) {
				//moveRightDown();
			}
			else
				//Handles basic collision...
				if(!Map.getTile((int)((posX/Tile.TILEWIDTH)+0.5),(int)((posY/Tile.TILEHIGHT)+1.45)).isSolid()) {
					moveDown();
				}
			return;
		}
		else if(Control.getDirection()[Direction.LEFT.ordinal()]==true) {
			//Handles basic collision for the left
			if(!Map.getTile((int)((posX/Tile.TILEWIDTH)+0.25),(int)((posY/Tile.TILEHIGHT)+1.125)).isSolid()) {
				moveLeft();
			}
			return;
		}
		else if(Control.getDirection()[Direction.RIGHT.ordinal()]==true) {
			//Handles basic collision for the right
			if(!Map.getTile((int)(colX+0.3),(int)((posY/Tile.TILEHIGHT)+1.125)).isSolid()) {
				moveRight();
			}
			return;
		} 
		stopMoving();
		return;
			
	}
	
}
