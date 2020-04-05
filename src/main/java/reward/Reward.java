package src.main.java.reward;

import src.main.java.character.Entity;
import src.main.java.image.Image;

import java.awt.*;

public abstract class Reward {
	protected Image image;
	
    public abstract int update(Entity entity);
    public abstract void render(Graphics g);
    //public abstract int getX();
    //public abstract int getY();
    public int getWidth() {
    	return image.getImage().getWidth()-15;
    }
    public int getHeight() {
    	return image.getImage().getHeight();
    }
}
