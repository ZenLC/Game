package character;

import image.Image;

import java.awt.*;

public class staticEntity {
    protected int x,y;
    protected Image i;
    public staticEntity(int posX, int posY, String path) {
        x=posX;
        y=posY;
        this.i=new Image(path);
    }
    public void update(){

    }
    public void render(Graphics graphics)
    {
            graphics.drawImage(i.getImage(),x,y,50,50,null);
    }

}
