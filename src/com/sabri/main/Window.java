package com.sabri.main;


import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

//Window - creating a Window

public class Window extends Canvas implements Serializable {

    private static final long serialVersionUID = -512743643853775956L;

    public Window(int width, int height, String title, Game game) {

        //Canvas Class contains JFrame
        //JFrame used to set Window properties
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        //adds game content to the JFrame
        frame.add(game);
        frame.setVisible(true);

        // runs the start method in Game game
        game.start();


    }

}
