package theGame.main;

import theGame.Display.Display;

public class Game{
    private Display display;

    public int width,height;

    public Game(String title, int width, int height){
        this.height = height;
        this.width = width;
    display = new Display(title,width,height);
    }
}
