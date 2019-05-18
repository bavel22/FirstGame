package com.sabri.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {


    private Handler handler;
    private Random r = new Random();
    private HUD hud;
    Game game;


    public Menu(Game game, Handler handler, HUD hud) {

        this.game = game;
        this.handler = handler;
        this.hud = hud;
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
        if (game.gameSTATE == Game.STATE.End) {

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Game Over", 750, 100);

            g.setFont(fnt2);
            g.drawString("You lost, score was only: " + hud.getScore(), 100, 200);

            g.setFont(fnt2);
            g.drawString("try again", 700, 600);

        }
        if (game.gameSTATE == Game.STATE.Select) {




            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("SELECT DIFFICULTY", 750, 100);


            g.setColor(Color.white);
            g.drawRect(650, 250, 300, 100);

            g.setFont(fnt2);
            g.drawString("Normal", 700, 300);

            g.setColor(Color.white);
            g.drawRect(650, 400, 300, 100);

            g.setFont(fnt2);
            g.drawString("Hard", 700, 450);

            g.setColor(Color.white);
            g.drawRect(650, 550, 300, 100);

            g.setFont(fnt2);
            g.drawString("Back", 700, 600);
        }
    }

    public void tick() {


    }

    public void mousePressed(MouseEvent e) {

        int mx = e.getX();
        //test
        int my = e.getY();


        // play button
        if (game.gameSTATE == Game.STATE.Menu) {
            if (mouseOver(mx, my, 650, 400, 300, 100)) {
                // game.gameSTATE = Game.STATE.Game;
                //handler.addObject(new Player((int) Game.WIDTH / 2 - 32, (int) Game.HEIGHT / 2 - 32, ID.Player, handler));
                //handler.clearEnemies();
                game.gameSTATE = Game.STATE.Select;

                try {
                    wait(1);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

                //  handler.addObject(new BasicEnemy(r.nextInt((int) Game.WIDTH), r.nextInt((int) Game.HEIGHT), ID.BasicEnemy, handler));
              //  handler.addObject(new BasicEnemy(r.nextInt((int) Game.WIDTH), r.nextInt((int) Game.HEIGHT), ID.BasicEnemy, handler));
            }
        }

        //normal button
        if (game.gameSTATE == Game.STATE.Select) {

                if (mouseOver(mx, my, 700, 300, 300, 100)) {
                game.gameSTATE = Game.STATE.Game;
                handler.addObject(new Player((int) Game.WIDTH / 2 - 32, (int) Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.clearEnemies();
                game.diff = 0;


                handler.addObject(new BasicEnemy(r.nextInt((int) Game.WIDTH), r.nextInt((int) Game.HEIGHT), ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt((int) Game.WIDTH), r.nextInt((int) Game.HEIGHT), ID.BasicEnemy, handler));
            }
        }

        //hard button
        if (game.gameSTATE == Game.STATE.Select) {

            if (mouseOver(mx, my, 700, 450, 300, 100)) {
                game.gameSTATE = Game.STATE.Game;
                handler.addObject(new Player((int) Game.WIDTH / 2 - 32, (int) Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.clearEnemies();
                game.diff = 1;


                handler.addObject(new SmartEnemy(r.nextInt((int) Game.WIDTH), r.nextInt((int) Game.HEIGHT), ID.SmartEnemy, handler));
                handler.addObject(new SmartEnemy(r.nextInt((int) Game.WIDTH), r.nextInt((int) Game.HEIGHT), ID.SmartEnemy, handler));
                handler.addObject(new SmartEnemy(r.nextInt((int) Game.WIDTH), r.nextInt((int) Game.HEIGHT), ID.SmartEnemy, handler));
                handler.addObject(new SmartEnemy(r.nextInt((int) Game.WIDTH), r.nextInt((int) Game.HEIGHT), ID.SmartEnemy, handler));



            }
        }
//Quit button
        if (game.gameSTATE == Game.STATE.Menu) {
        if (mouseOver(mx, my, 650, 600, 300, 100)) {

//how to add a sound -> need to figure out AudioPlayer libraries
//          AudioPlayer.getSound("menu sound").play;

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
        //Back button for select
        if (game.gameSTATE == Game.STATE.Select) {


            if (mouseOver(mx, my, 650, 600, 300, 100)) {
                game.gameSTATE = Game.STATE.Menu;
            }
        }

//try again button for game over screen
        if (game.gameSTATE == Game.STATE.End) {


            if (mouseOver(mx, my, 650, 600, 300, 100)) {

                game.gameSTATE = Game.STATE.Menu;
                hud.setLevel(1);
                hud.setScore(0);

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


