package image;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int width=32,height=32;
    public static BufferedImage floor, wall,gate;
    public static void init(){
        SpriteSheet sheet= new SpriteSheet(Image.imageLoad("/res/tiles.png"));
        floor =sheet.crop(0,7*height,width,height);
        wall =sheet.crop(width,5*height,width,height);
        gate =sheet.crop(0,2*height,width,height);

    }
}
