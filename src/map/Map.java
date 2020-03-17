package map;
import theGame.gameLoading.Loading;
import tile.Tile;
import java.awt.*;

public class Map {
    private int width,height;
    private static int [][] tiles;
    private  int x_axis,y_axis;
    public Map(String path){
        loadWorld(path);
    }

    public void upDate(){

    }
    public void render(Graphics g){
        for (int y=0; y<height;y++){
            for (int x=0;x<width;x++){
                geyTile(x,y).render(g,x*Tile.TILEWIDTH,y*Tile.TILEHIGHT);

            }
        }
    }

    public Tile geyTile(int x ,int y){
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
            return Tile.FloorTile;
        return t;
    }
    //Just needed a static way to access the above method...
    public static Tile getTile(int x ,int y){
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
            return null;
        System.out.println(t.getId());
        return t;
    }
    private  void loadWorld(String path){
        String file = Loading.switchToString(path);
        String[] tokens =file.split("\\s+");
        width = Loading.switchToInt(tokens[0]);
        height = Loading.switchToInt(tokens[1]);
        x_axis = Loading.switchToInt(tokens[2]);
        y_axis = Loading.switchToInt(tokens[3]);

        tiles = new int[width][height];
        for (int x=0; x < width; x++){
            for(int y =0 ; y < height;y++)
                tiles[x][y] = Loading.switchToInt(tokens[(x + y * width)+4]);
        }

    }
}
