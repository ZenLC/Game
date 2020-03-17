package image;
import character.Character;
import theGame.main.Game;

import java.awt.*;

public class Camera {
    private float xView,yView;
    private Game game;
    public Camera(Game game,float xView,float yView){
        this.xView=xView;
        this.yView=yView;
        this.game=game;
    }

    //insert the character location code here
   // public  void followPlayers(Player p){
       // xView=p.getX()-game.getWidth()/2 + p.getWidth() /2;
       // yView=p.getY()-game.getHeight()/2 + p.getHeight()/2;
    //}
    public void move(float xSize, float ySize){
        xView+=xSize;
        yView+=ySize;
    }
    public float getxView() {
        return xView;
    }

    public float getyView() {
        return yView;
    }

    public void setxView(float xView) {
        this.xView = xView;
    }

    public void setyView(float yView) {
        this.yView = yView;
    }
}
