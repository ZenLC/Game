package image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//Add website that gave additional information...
public class Image {
	private String filePath;
	private BufferedImage image;
	
	public Image (String filePath){
		this.filePath = filePath;
		
	}
	/*
	public int getHeight() {
		return
	}
	
	public int getWidth() {
		
	}*/
	
	//This method needs to be fixed clearly, but it will do for now...
	public BufferedImage getImage() {
		try {
			//I have no idea why the "." exist. Also the file doesn't have to be initialized in this method...
			image = ImageIO.read(new File("."+filePath));
		}catch(IOException e) {
			System.out.println("An image could not be found!");
			e.printStackTrace();
			System.exit(1);
		}
		return image;
	}
	
	//This was the original code that was used...
    public static BufferedImage imageLoad(String path){
        try {
            return ImageIO.read(new File("."+path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
