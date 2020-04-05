package src.main.java.tile;

import src.main.java.image.Assets;

public class wallTile extends Tile {
    public wallTile(int id) {
        super(Assets.wall, id);
    }

    public boolean isSolid(){
        return true;
    }
}
