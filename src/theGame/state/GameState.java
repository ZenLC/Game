package theGame.state;

import character.*;
import character.Character;
import image.Assets;
import map.Map;
import theGame.main.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class GameState extends  State{

    private Map map;
    private Character character;
    private static BulletList characterBulletList;
    private static staticEntity e;
    public GameState(Game game){
        map =new Map("res/map.txt");
        character = new Character(64,64);
        characterBulletList = new BulletList();
    }
    @Override
    public void upDate() {
        map.upDate();
        character.update();
        characterBulletList.update();
        e.update();
    }

    @Override
    public void render(Graphics g) {
        map.render(g);
        character.render(g);
        characterBulletList.render(g);
        e.render(g);
    }
    public static void pushCharacterBullet(Direction direction,float posX,float posY) {
    	characterBulletList.push(new CharacterBullet(direction, posX, posY));
    }
}
