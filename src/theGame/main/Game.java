package theGame.main;

import theGame.Display.Display;
import image.Image;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable{
    private Display display;
    public int width,height;
    public String title;

    private boolean running=false;
    private Thread thread;

    private BufferStrategy buffer;
    private Graphics graph;
    private BufferedImage testG;

    public Game(String title, int width, int height){
        this.height = height;
        this.width = width;
        this.title = title;
    }

        private  void init(){
            display = new Display(title,width,height);
            testG = Image.imageLoad("/res/wall.png");
        }

        private void update(){

        }
        private  void render(){
            buffer = display.getCanvas().getBufferStrategy();
            if (buffer == null) {
                display.getCanvas().createBufferStrategy(3);
                return;
            }
            graph = buffer.getDrawGraphics();
                graph.drawImage(testG,20,20,null);

                buffer.show();
                graph.dispose();
        }

    public void run(){
        init();

        while(running){
            update();
            render();
        }
        stop();;
    }
    public synchronized  void start(){
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();

    }
    public synchronized void stop(){
        if(!running)
            return;
        running=false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
