package com.sabri.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    private boolean[] keyDown = new boolean[4];

    Game game;


    public KeyInput(Handler handler, Game game) {
        this.handler = handler;
        this.game = game;
        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
    }


    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {
                // key events for player

                if (key == KeyEvent.VK_W) {
                    tempObject.setVelY(-5);
                    keyDown[0] = true;
                }
                if (key == KeyEvent.VK_A) {
                    tempObject.setVelX(-5);
                    keyDown[3] = true;
                }
                if (key == KeyEvent.VK_S) {
                    tempObject.setVelY(5);
                    keyDown[1] = true;
                }
                if (key == KeyEvent.VK_D) {
                    tempObject.setVelX(5);
                    keyDown[2] = true;
                }

                //tempObject.setVelY(Game.clamp((int) tempObject.getVelY(), -5, 5));
                //tempObject.setVelX(Game.clamp((int) tempObject.getVelX(), -5, 5));
            }
            if (key == KeyEvent.VK_ESCAPE) System.exit(1);

            if (key == KeyEvent.VK_P) Game.paused = !Game.paused;

            if (key == KeyEvent.VK_SPACE) {
                if(Game.gameSTATE == Game.gameSTATE.Game) Game.gameSTATE = Game.STATE.Shop;
                else if(Game.gameSTATE == Game.STATE.Shop) Game.gameSTATE = Game.STATE.Game;
            }
        }
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {
                // key events for player
                // tempObject.setVelY(Game.clamp((int) tempObject.getVelY(), -5, 5));
                // tempObject.setVelX(Game.clamp((int) tempObject.getVelX(), -5, 5));
                if (key == KeyEvent.VK_W) keyDown[0] = false; //tempObject.setVelY(tempObject.getVelY() + 5);
                if (key == KeyEvent.VK_A) keyDown[3] = false;//tempObject.setVelX(tempObject.getVelX() + 5);
                if (key == KeyEvent.VK_S) keyDown[1] = false; //tempObject.setVelY(tempObject.getVelY() - 5);
                if (key == KeyEvent.VK_D) keyDown[2] = false; //tempObject.setVelX(tempObject.getVelX() - 5);

                //vertical movement

                if (!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
                //horizontal movement
                if (!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);

            }
        }
    }
}
