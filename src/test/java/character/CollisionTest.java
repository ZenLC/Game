package src.test.java.character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.character.Collision;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class CollisionTest {
	
	private int testBoundX1;
	private int testBoundY1;
	private int testBoundX2;
	private int testBoundY2;
	
	
	@BeforeEach
	void setup() {
		//Define bounds
		testBoundX1 = 1;
		testBoundY1 = 1;
		testBoundX2 = 3;
		testBoundY2 = 3;
		new Collision();
	}
	//If I could redo this class I would probably implement all these methods within the entity class
	//Also I know that normally you're supposed to test private methods only by testing the public methods that call them
	//But this method is so essential to the function of the other methods, that I changed it to public to test it.
	@Test 
	void isPointInRect() {
		int pX=2;
		int pY=2;
		boolean test = Collision.isPointInSquare(pX, pY, testBoundX1, testBoundY1, testBoundX2, testBoundY2);
		assertTrue(test);
	}
	
	@Test
	void isPxOutOfRectLeft() {
		int pX=0;
		int pY=2;
		boolean test = Collision.isPointInSquare(pX, pY, testBoundX1, testBoundY1, testBoundX2, testBoundY2);
		assertFalse(test);
	}
	
	@Test
	void isPxOutOfRectRight() {
		int pX=4;
		int pY=2;
		boolean test = Collision.isPointInSquare(pX, pY, testBoundX1, testBoundY1, testBoundX2, testBoundY2);
		assertFalse(test);
	}
	
	@Test
	void isPyOutOfRectUp() {
		int pX=2;
		int pY=0;
		boolean test = Collision.isPointInSquare(pX, pY, testBoundX1, testBoundY1, testBoundX2, testBoundY2);
		assertFalse(test);
	}
	
	@Test
	void isPyOutOfRectDown() {
		int pX=2;
		int pY=4;
		boolean test = Collision.isPointInSquare(pX, pY, testBoundX1, testBoundY1, testBoundX2, testBoundY2);
		assertFalse(test);
	}
	

		/*
	@Test
	void testIsCollidingEntityEntity() {
		fail("Not yet implemented");
	}

	@Test
	void testIsCollidingProjectileEntity() {
		fail("Not yet implemented");
	}

	@Test
	void testIsCollidingIntIntRewardEntity() {
		fail("Not yet implemented");
	}

	@Test
	void testIsCollidingEntityStaticEntity() {
		fail("Not yet implemented");
	}
	*/
}
