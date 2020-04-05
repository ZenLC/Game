package src.main.java.image;

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
	//This method needs to be fixed clearly, but it will do for now...

	/**
	 * identify picture location
	 * @return the picture
	 */
	public BufferedImage getImage() {
		try {
			image = ImageIO.read(new File("."+filePath));
		}catch(IOException e) {
			System.out.println("An image could not be found:"+filePath);
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
		System.out.println("An image could not be found:"+path);
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
