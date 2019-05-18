package com.sabri.main;

import java.awt.*;

public class HUD {

    public  int bounds = 0;
    public static float HEALTH = 100;
    private float greenValue = 255;

    public float getScore() {
        return score;
    }

    public void score(float score) {
        this.score = (int)score;
    }

    private float score = 0;

    public float getLevel() {
        return level;
    }

    public void setLevel(float level) {
        this.level = (int)level;
    }

    private float level = 1;


    public void setScore(float score) {
        this.score = score;
    }

    public void tick() {



        HEALTH = Game.clamp(HEALTH, 0 , 100+ (bounds/2));
        greenValue = HEALTH * 2;
        greenValue = (int)Game.clamp(greenValue, 0, 255);


        score++;
    }

    public void render(Graphics g) {

        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);

        g.setColor(new Color(75, (int)greenValue, 0));
        g.fillRect(15, 15, (int)HEALTH * 2 + bounds, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, (int)HEALTH * 2 + bounds, 32);

        g.drawString("Score: " + score, 10, 64);
        g.drawString("Level: " + level, 13, 84);
        g.drawString("Press SPACE for shop",  13, 120);


    }
}
