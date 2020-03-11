package theGame.main;

import theGame.Display.Display;
public class GameLauncher {

    public static void main(String[] args){
       Game game = new Game("title",800,600);
       game.start();
    }

}
