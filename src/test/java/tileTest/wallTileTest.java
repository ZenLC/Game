package src.test.java.tileTest;
import src.main.java.tile.wallTile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class wallTileTest {
/*
Test if the tile wall can be passed
 */
    @Test
    public void isSolid() {
    	assertTrue(true);
        assertTrue(wallTile.Wall.isSolid());
    }
}
