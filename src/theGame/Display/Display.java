package theGame.Display;
import javax.swing.Icon;
import  javax.swing.JFrame;
import javax.swing.JLabel;

import controls.Control;

import java.awt.*;

//For testing
import image.Image;

public class Display {
    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width,height;

    public Display (String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
       
        canvas =new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.addKeyListener(new Control());	
       
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
