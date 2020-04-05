package src.main.java.theGame.state;

import src.main.java.UI.EndFrame;
import src.main.java.character.Character;
import src.main.java.character.*;
import src.main.java.map.Map;
import src.main.java.map.staticEntity;
import src.main.java.reward.BonusReward;
import src.main.java.reward.RegularReward;
import src.main.java.theGame.main.Game;


import java.awt.*;
import java.awt.geom.AffineTransform;



/**
 * implement all reference
 */
public class GameState extends State {

    private Map map;
    private static Character character;
    private static BulletList characterBulletList;
    
    private static BulletList enemyBulletList;
    private int time=0;
    private Enemy[] enemies={null,null,null,null,null,};
    
    private RegularReward regular;
    private BonusReward bonus;
    private staticEntity endPoint;


    public GameState(){
        new EnemyList();
        map =new Map("src/main/resources/map.txt");
        character = new Character(80,5);
        characterBulletList = new BulletList();
        enemyBulletList = new BulletList();
        enemies[0]= new Enemy1(150,630);
        enemies[1]= new Enemy2(470,400);
        enemies[2]= new Enemy2(400,630);
        enemies[3]= new Enemy1(550,500);
        enemies[4]= new Enemy1(600,190);
        for(int i=0; i < 5; i++)
        	EnemyList.push(enemies[i]);
        
        regular = new RegularReward();
        bonus = new BonusReward();
        endPoint = new staticEntity(32*(26),32*(16),"/src/main/java/resources/endPoint.png");
    }
    public void restart() {
    	 new EnemyList();
         map =new Map("src/main/resources/map.txt");
         character = new Character(80,5);
         characterBulletList = new BulletList();
         enemyBulletList = new BulletList();
         enemies[0]= new Enemy1(150,630);
         enemies[1]= new Enemy2(470,400);
         enemies[2]= new Enemy2(400,630);
         enemies[3]= new Enemy1(550,500);
         enemies[4]= new Enemy1(600,190);
         for(int i=0; i < 5; i++)
         	EnemyList.push(enemies[i]);
         
         regular = new RegularReward();
         bonus = new BonusReward();
         endPoint = new staticEntity(32*(26),32*(16),"/src/main/resources/endPoint.png");
    	return;
    }
    @Override
    public void upDate() {
    	if(character.getScore()<0) {
    		EndFrame.gameLost(character.getScore(),time);
    	}
        map.upDate();
        character.update();
        characterBulletList.update();

        enemyBulletList.update();
        EnemyList.update();
        character.increaseScore(EnemyList.getReturnScoreForUpdate());

        character.increaseScore(regular.update(character));
        character.increaseScore(bonus.update(character));

        if(Collision.isColliding(character,endPoint)) {
        	EndFrame.gameWon(character.getScore(), time);
        }
    }

    @Override
    public void render(Graphics g) {
    	Graphics2D g2d = (Graphics2D)g;
		AffineTransform old = g2d.getTransform();
		//Should more specifically translate using the characters width and height, this will do for now.
		g2d.translate( (-character.getX())+40+Game.getHeight()/2, -(character.getY())-85+Game.getWidth()/2 );
		
        map.render(g);
        character.render(g);
        EnemyList.render(g);
        characterBulletList.render(g);

        enemyBulletList.render(g);
        
        regular.render(g);
        bonus.render(g);
        endPoint.render(g);
        
        g2d.setTransform(old);
       
    	g2d.setFont(new Font("SansSerif", Font.BOLD, 22));
		g2d.setColor(new Color(2,2,2));
    	g2d.drawString("Score: "+character.getScore(), 30+2, 30+2);
    	if((time/60)%60<10)
    		g2d.drawString("Time: "+time/60/60+":"+"0"+(time/60)%60, 370+2, 30+2);
    	else
    		g2d.drawString("Time: "+time/60/60+":"+(time/60)%60, 370+2, 30+2);
    	
    	g2d.setColor(new Color(255,255,255));
		g2d.drawString("Score: "+character.getScore(), 30, 30);
		if((time/60)%60<10)
    		g2d.drawString("Time: "+time/60/60+":"+"0"+(time/60)%60, 370, 30);
    	else
    		g2d.drawString("Time: "+time/60/60+":"+(time/60)%60, 370, 30);
		
		time++;

    }
    public static void pushCharacterBullet(Direction direction,float posX,float posY) {
    	characterBulletList.push(new CharacterBullet(direction, posX, posY));
    }
    public static void pushEnemyBullet(Direction direction,float posX,float posY) {
    	enemyBulletList.push(new EnemyBullet(direction, posX, posY,character));
    }
}
