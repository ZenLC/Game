package tile;

import image.Assets;

public class gateTile extends Tile {

    public gateTile(int id) {
        super(Assets.gate, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
