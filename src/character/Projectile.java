package character;

import java.awt.Graphics;

import image.Image;

public class Projectile {
	protected Direction direction;
	protected float posX;
	protected float posY;
	protected float speed = 4.5f;
	protected Image image;
	//Needs a method that destroys the projectile
	//Image should be declared in extension of Projectile i.e, playerProjectile and enemyProjectile.
	public Projectile(Direction direction, float initialX, float initialY, String imagePath) {
		this.direction = direction;
		this.image = new Image(imagePath);
		posX = initialX;
		posY = initialY;
	}
	public void update() {
		switch(direction) {
			case UP:
				posY-=speed;
				break;
			case DOWN:
				posY+=speed;
				break;
			case LEFT:
				posX-=speed;
				break;
			case RIGHT:
				posX+=speed;
				break;
		}
	}
	public void render(Graphics g) {
		g.drawImage(image.getImage(),(int)posX,(int)posY,50,50,null);
	}
	
	
}
