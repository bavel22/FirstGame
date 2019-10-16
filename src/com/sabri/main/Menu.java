package com.sabri.main;

import com.sabri.main.Enemies.BasicEnemy;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.Random;

public class Menu extends MouseAdapter {


    private Handler handler;
    private Random r = new Random();
    private HUD hud;
    Game game;

    private float x = 100f, y = 100f;
    private float radius = 800f;
    private float velX = 10f;
    private float velY = 10f;

    private Color menuButton1 = Color.white;
    private Color menuButton2 = Color.white;
    private Color menuButton3 = Color.white;

    private int bx1 = 650;
    private int bw1 = 300;

    private int bx2 = 650;
    private int bw2 = 300;

    private int bx3 = 650;
    private int bw3 = 300;

    public Menu(Game game, Handler handler, HUD hud) {

        this.game = game;
        this.handler = handler;
        this.hud = hud;
    }


    public void mouseMoved(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        // play button
        if (game.gameSTATE == Game.STATE.Menu) {
            if (mouseOver(mx, my, 650, 400, 300, 100)) {
                menuButton2 = Color.blue;
                bx2 += (550 - bx2) * 0.05;
                bw2 += (400 - bw2) * 0.05;

            } else {

                menuButton2 = Color.white;

            }
        }

    //Quit button
        if (game.gameSTATE == Game.STATE.Menu) {
            if (mouseOver(mx, my, 650, 550, 300, 100)) {
                menuButton3 = Color.red;
                bx3 += (550 - bx3) * 0.05;
                bw3 += (400 - bw3) * 0.05;
            } else {

                menuButton3 = Color.white;
            }
        }
// help button
        if (game.gameSTATE == Game.STATE.Menu) {
            if (mouseOver(mx, my, 650, 250, 300, 100)) {
                menuButton1 = Color.yellow;
                bx1 += (550 - bx1) * 0.05;
                bw1 += (400 - bw1) * 0.05;

            } else {

                menuButton1 = Color.white;
            }
        }

    }


    public void render(Graphics g) {
        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 30);

        if (game.gameSTATE == Game.STATE.Menu) {


            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Menu", 750, 100);


            g.setFont(fnt2);
            g.setColor(menuButton1);
            g.drawString("Help", 700, 300);
            g.drawRect(bx1, 250, bw1, 100);

            g.setFont(fnt2);
            g.setColor(menuButton2);
            g.drawRect(bx2, 400, bw2, 100);
            g.drawString("Play", 700, 450);

            g.setFont(fnt2);
            g.setColor(menuButton3);
            g.drawRect(bx3, 550, bw3, 100);
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



        Graphics2D g2d = (Graphics2D) g;
        Point2D center = new Point2D.Float(x, y);
        float[] dist = {0.0f, 1.0f};
        Color[] colors = {new Color(1.0f, 1.0f, 0.1f, 0.1f), Color.black};
        RadialGradientPaint p = new RadialGradientPaint(center, radius, dist, colors);
        g2d.setPaint(p);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .95f));
        g2d.fillRect(0, 0, 1000, 1100);
        g2d.dispose();
    }


    public void tick() {

     /*   x += velX;
     y += velY;

        if (x <= 0 || x >= 1600) {
            velX *= -1;
        }
        if (y <= 0 || x >= 1200) {
            velX *= -1;
        }

*/



        if(menuButton1 == Color.white) {
            bx1 += (550 - bx1) * 0.1;
            bw1 += (400 - bw1) * 0.1;

        } else {
            bx1 += (1000 - bx1) * 0.05;
            bw1 += (400 - bw1) * 0.05;
        }

        if(menuButton2 == Color.white) {
            bx2 += (550 - bx2) * 0.05;
            bw2 += (400 - bw2) * 0.05;
        } else {
            bx2 += (550 - bx2) * 0.05;
            bw2 += (400 - bw2) * 0.05;
        }

        if(menuButton3 == Color.white) {
            bx3 += (550 - bx3) * 0.05;
            bw3 += (400 - bw3) * 0.05;
        } else {
            bx3 += (550 - bx3) * 0.05;
            bw3 += (400 - bw3) * 0.05;
        }

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


