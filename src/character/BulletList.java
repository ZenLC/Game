package character;

import java.awt.Graphics;
import java.util.ArrayList;

//singular class
public class BulletList {
	private ArrayList<Projectile> bulletList;
	private int elements=0;
	public BulletList() {
		bulletList=new ArrayList<Projectile>();
	}
	public void push(Projectile bullet) {
		bulletList.add(bullet);
		elements++;
		return;
	}
	public boolean isEmpty() {
		if (elements==0)
			return true;
		return false;
	}
	/*//Kind of unnecessary
	public CharacterBullet get(int index) {
		return bulletList.get(index);
	}*/
	//Does nothing if empty or if index is larger than the last index.
	public void remove(int index) {
		if (isEmpty() || index >= elements) {
			return;
		}else {
			bulletList.remove(index);
		}
		return;
	}
	public void update() {
		//FOR ALL BULLET IN LIST UPDATE
		for(int i=0; i<elements;i++)
			bulletList.get(i).update();
		
	}
	
	public void render(Graphics g) {
		//FOR ALL BULLETS IN LIST RENDER
		for(int i=0; i<elements;i++)
			bulletList.get(i).render(g);
	}
	
	
}
