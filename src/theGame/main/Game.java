package theGame.main;

import image.Assets;
import image.SpriteSheet;
import theGame.Display.Display;
import image.Image;
import theGame.state.GameState;
import theGame.state.State;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {
    private Display display;
    public int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy buffer;
    private Graphics graph;

    private State gameState;

    public Game(String title, int width, int height) {
        this.height = height;
        this.width = width;
        this.title = title;
    }

    private void init() {
        display = new Display(title, width, height);
        Assets.init();
        gameState = new GameState(this);
        State.setState(gameState);
    }

    private void update() {
        if(State.getState() != null)
            State.getState().upDate();
    }

    private void render() {
        buffer = display.getCanvas().getBufferStrategy();
        if (buffer == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graph = buffer.getDrawGraphics();
        graph.clearRect(0,0,width,height);
        if(State.getState() != null)
            State.getState().render(graph);

        buffer.show();
        graph.dispose();
    }

    @Override
    public void run() {
        init();
        int fps =60;
        double timePerUpDate = 1000000000 /fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer=0;
        int ticks =0;

        while (running) {
            now =System.nanoTime();
            delta += (now-lastTime) / timePerUpDate;
            timer +=now -lastTime;
            lastTime = now;

            if(delta >= 1) {
                update();
                render();
                ticks++;
                delta--;
            }
            if(timer >= 1000000000 ){
                //System.out.println("Ticks and Frames"+ticks);
                ticks =0 ;
                timer = 0;
            }
        }
        stop();
        ;
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();

    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
