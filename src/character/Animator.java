package character;


import java.awt.image.BufferedImage;

import image.Image;

public class Animator {
	private Image animatedImage;
	private int height;
	private int width;
	
	private int counter=0;
	private int subCounter=0;
	public Animator(String filepath) {
		animatedImage = new Image(filepath);
		height = animatedImage.getImage().getHeight();
		width = animatedImage.getImage().getWidth();
	}
	
	//Returns an image based on tick
	public BufferedImage getImage(boolean isMoving) {
		//This a little trick, so that the image doesn't update too quickly.
		//Basically the image doesn't update until the subcounter reaches ten.
		if(isMoving) {
			subCounter++;
			if (subCounter >= 10){
				counter = (counter+1)%4;
				subCounter=0;
			}
		}
		return animatedImage.getImage().getSubimage((width/4)*counter,0,width/4,height);
	}
}
