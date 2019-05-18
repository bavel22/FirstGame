package com.sabri.main;

import java.awt.*;
import java.util.Random;

public class MenuParticle extends GameObject {
    Random r = new Random();
    private Handler handler;
    private int red = r.nextInt(255);
    private int green = r.nextInt(255);
    private int blue = r.nextInt(255);
    private Color col;




    public MenuParticle(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;





        velX = r.nextInt(15);
        velY = r.nextInt(15);

        col = new Color(red, green, blue);

    }

    public void tick() {

        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 16) velX *= -1;


        handler.addObject(new Trail((int) x, (int) y, ID.MenuParticle, col, 16, 16, 0.02f, handler));

    }


    public void render(Graphics g) {

        g.setColor(col);
        g.fillRect((int) x, (int) y, 16, 16);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 32, 32);
    }
}


