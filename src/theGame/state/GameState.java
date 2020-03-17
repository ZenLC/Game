package theGame.state;

import image.Assets;
import map.Map;
import theGame.main.Game;
import character.BulletList;
import character.Character;
import character.CharacterBullet;
import character.Direction;
import character.Projectile;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class GameState extends  State{

    private Map map;
    private Character character;
    private static BulletList characterBulletList;
    
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
    }

    @Override
    public void render(Graphics g) {
        map.render(g);
        character.render(g);
        characterBulletList.render(g);
    }
    public static void pushCharacterBullet(Direction direction,float posX,float posY) {
    	characterBulletList.push(new CharacterBullet(direction, posX, posY));
    }
}
