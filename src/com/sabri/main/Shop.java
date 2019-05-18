package com.sabri.main;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Shop extends MouseInputAdapter {

    private Handler handler;

    private int B1 = 100;
    private int B2 = 100;
    private int B3 = 100;
    HUD hud;


    public Shop(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("arial", 0, 48));
        g.drawString("SHOP", (int) Game.WIDTH / 2 - 100, 100);

        //box 1
        g.setFont(new Font("arial", 0, 12));
        g.drawRect(100, 100, 100, 100);
        g.drawString("Upgrade Health", 110, 100);
        g.drawString("Cost: " + B1, 110, 140);


        //box 2

        g.drawRect(250, 100, 100, 80);
        g.drawString("Upgrade Speed", 260, 100);
        g.drawString("Cost: " + B2, 260, 140);

        //box 3

        g.drawRect(400, 100, 100, 100);
        g.drawString("Upgrade Health", 400, 100);
        g.drawString("Cost: " + B3, 400, 140);

        //score

        g.drawString("Score: " + hud.getScore(), (int) Game.WIDTH / 2 - 50, 300);
        g.drawString("Press space to get back", (int) Game.WIDTH / 2 - 50, 350);


    }


    public void mousePressed(MouseEvent e) {
        // super.mousePressed(e);

        int mx = e.getX();
        int my = e.getX();

        //box 1

        if (mx >= 100 && mx <= 200) {
            if (my >= 100 && my <= 180) {
                //selected box 1
                System.out.println("Box 1");
                if (hud.getScore() >= B1) {
                    hud.setScore(hud.getScore() - B1);
                    B1 += 100;
                    hud.bounds = +20;
                    hud.HEALTH = (100 + (hud.bounds / 2));
                }
            }
        }

        //box 2

        if (mx >= 220 && mx <= 350) {
            if (my >= 100 && my <= 180) {
                //selected box 2
                System.out.println("Box 2");
            }
        }

        //box 3

        if (mx >= 400 && mx <= 500) {
            if (my >= 100 && my <= 180) {
                //selected box 3
                System.out.println("Box 3");
                if (hud.getScore() >= B3) {
                    hud.setScore(hud.getScore() - B3);
                    B3 += 100;

                    hud.HEALTH = (100 + (hud.bounds / 2));
                }
            }


        }
    }
}

