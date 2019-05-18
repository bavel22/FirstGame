package com.sabri.main;

import java.awt.*;
import java.util.Random;

public class EnemyBoss extends GameObject {

    private Handler handler;
    private int timer = 90;
    private int timer2 = 90;
    Random r = new Random();
    private float bulletX;
    private float bulletY;

    public EnemyBoss(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 0;
        velY = 2;

    }

    public void tick() {

        x += velX;
        y += velY;

        if (timer <= 0) velY = 0;
        else timer--;

        if (timer <= 0) timer2--;
        if (timer2 <= 0)
        {

            if(velX == 0) velX = 5;
            velX += 0.01f;
            int spawn = r.nextInt(10);




            if (spawn == 0) handler.addObject(new EnemyBossBullet(x, y, ID.EnemyBossBullet, handler ));

        }


        //if (y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 96) velX *= -1;


        handler.addObject(new Trail((int)x, (int)y, ID.Trail , Color.red, 96, 96, .08f, handler));

    }


    public void render(Graphics g) {

        g.setColor(Color.red);
        g.fillRect((int)x,(int)y, 96, 96);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 96, 96);
    }
}


