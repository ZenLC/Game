package character;

public class CharacterBullet extends Projectile{
	public CharacterBullet(Direction direction, float initialX, float initialY) {
		super(direction,initialX,initialY,"/res/character/fireball.png");
	}
}
