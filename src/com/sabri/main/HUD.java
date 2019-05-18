package com.sabri.main;

import java.awt.*;

public class HUD {

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




    public void tick() {


        HEALTH = Game.clamp(HEALTH, 0 , 100);
        greenValue = (int)Game.clamp(greenValue, 0, 255);
        greenValue = HEALTH * 2;

        score++;
    }

    public void render(Graphics g) {

        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);

        g.setColor(new Color(75, (int)greenValue, 0));
        g.fillRect(15, 15, (int)HEALTH * 2, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, (int)HEALTH * 2, 32);

        g.drawString("Score: " + score, 10, 64);
        g.drawString("Level: " + level, 13, 84);

    }
}
