package com.sabri.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {


    private Handler handler;
    private Random r = new Random();
    Game game;


    public Menu(Game game, Handler handler) {

        this.game = game;
        this.handler = handler;
    }

    public void render(Graphics g) {
        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 30);

        if (game.gameSTATE == Game.STATE.Menu) {


            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Menu", 750, 100);


            g.setColor(Color.white);
            g.drawRect(650, 250, 300, 100);

            g.setFont(fnt2);
            g.drawString("Help", 700, 300);

            g.setColor(Color.white);
            g.drawRect(650, 400, 300, 100);

            g.setFont(fnt2);
            g.drawString("Play", 700, 450);

            g.setColor(Color.white);
            g.drawRect(650, 550, 300, 100);

            g.setFont(fnt2);
            g.drawString("Quit", 700, 600);
        }
        if (game.gameSTATE == Game.STATE.HELP) {

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Help", 750, 100);

            g.setFont(fnt2);
            g.drawString("use the WASD Keys to move and dodge enemies", 100, 200);

            g.setFont(fnt2);
            g.drawString("Back", 700, 600);

        }
    }

    public void tick() {


    }

    public void mousePressed(MouseEvent e) {

        int mx = e.getX();
        int my = e.getY();

//Play button
        if (game.gameSTATE == Game.STATE.Menu) {
            if (mouseOver(mx, my, 650, 400, 300, 100)) {
                game.gameSTATE = Game.STATE.Game;

                handler.addObject(new Player((int) Game.WIDTH / 2 - 32, (int) Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.addObject(new BasicEnemy(r.nextInt((int) Game.WIDTH), r.nextInt((int) Game.HEIGHT), ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt((int) Game.WIDTH), r.nextInt((int) Game.HEIGHT), ID.BasicEnemy, handler));
            }
        }
//Quit button
        if (game.gameSTATE == Game.STATE.Menu) {
        if (mouseOver(mx, my, 650, 600, 300, 100)) {
            System.exit(1);
        }
        }
//Help button
        if (game.gameSTATE == Game.STATE.Menu) {
            if (mouseOver(mx, my, 650, 300, 300, 100)) {
                game.gameSTATE = Game.STATE.HELP;
            }
        }

//Back button for help
        if (game.gameSTATE == Game.STATE.HELP) {


            if (mouseOver(mx, my, 650, 600, 300, 100)) {
                game.gameSTATE = Game.STATE.Menu;
            }
        }

    }

    public void mouseReleased(MouseEvent e) {

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else return false;
        } else return false;
    }

}


