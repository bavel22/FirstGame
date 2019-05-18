package com.sabri.main;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Handler handler;

    Random r = new Random();

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;


    }

    public void tick() {
        x += velX;
        y += velY;


        x = Game.clamp((int)x, 0, Game.WIDTH - 37);
        y = Game.clamp((int)y, 0, Game.HEIGHT - 60);

collision();

    }

    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.EnemyBossBullet) { //tempObject is no BasicEnemy
                    if (getBounds().intersects(tempObject.getBounds())){
                        //collision code
                        HUD.HEALTH -= 2;

                    }
            }

            if (tempObject.getId() == ID.EnemyBoss) { //tempObject is no BasicEnemy
                if (getBounds().intersects(tempObject.getBounds())){
                    //collision code
                    HUD.HEALTH -= 112;

                }
            }
        }
    }

    public void render(Graphics g) {

       //  Graphics2D g2d = (Graphics2D) g;


        if (id == ID.Player) g.setColor(Color.white);
        else if (id == ID.Player2) g.setColor(Color.red);
        g.fillRect((int)x,(int)y, 32, 32);


    }


    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 32, 32);

    }
}




