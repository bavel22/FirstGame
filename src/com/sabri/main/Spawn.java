package com.sabri.main;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private int scoreKeep = 0;
    private Random r = new Random();
    private Game game;
  //  private int bossCounter = 0;


    public Spawn(Handler handler, HUD hud, Game game) {
        this.handler = handler;
        this.hud = hud;
        this.game = game;
    }

    public void tick() {
        scoreKeep++;

        if (scoreKeep >= 250) {


            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
         //   bossCounter++;


        if(game.diff == 0) {
            if (hud.getLevel() == 2) {
                handler.addObject(new BasicEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.BasicEnemy, handler));
            }
            if (hud.getLevel() == 3) {
                handler.addObject(new BasicEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.BasicEnemy, handler));
                handler.addObject(new SmartEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.SmartEnemy, handler));
                handler.addObject(new SmartEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.SmartEnemy, handler));
                handler.addObject(new SmartEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.SmartEnemy, handler));
            }
            if (hud.getLevel() == 4) {
                handler.addObject(new BasicEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.BasicEnemy, handler));
            }
            if (hud.getLevel() == 5) {
                handler.addObject(new FastEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.FastEnemy, handler));
            }
            if (hud.getLevel() == 6) {
                handler.addObject(new FastEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.FastEnemy, handler));
            }
            if (hud.getLevel() == 7) {
                handler.addObject(new FastEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.FastEnemy, handler));
            }
            if (hud.getLevel() == 8) {
                handler.addObject(new FastEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.FastEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.BasicEnemy, handler));
            }

            if (hud.getLevel() == 9) {
                handler.addObject(new SmartEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.SmartEnemy, handler));
                handler.addObject(new SmartEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.SmartEnemy, handler));
                handler.addObject(new SmartEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.SmartEnemy, handler));
            }

            if (hud.getLevel() == 10) {
                handler.clearEnemies();
                handler.addObject(new EnemyBoss(((Game.WIDTH / 2) - 48), -100, ID.EnemyBoss, handler));
            }
        } else {
            if(game.diff == 1) {
                if (hud.getLevel() == 2) {
                    handler.addObject(new BasicEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.BasicEnemy, handler));
                    handler.addObject(new BasicEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.BasicEnemy, handler));
                    handler.addObject(new BasicEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.BasicEnemy, handler));
                }
                if (hud.getLevel() == 3) {
                    handler.addObject(new BasicEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.BasicEnemy, handler));
                    handler.addObject(new SmartEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.SmartEnemy, handler));
                    handler.addObject(new SmartEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.SmartEnemy, handler));

                    handler.addObject(new SmartEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.SmartEnemy, handler));
                    handler.addObject(new SmartEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.SmartEnemy, handler));
                    handler.addObject(new SmartEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.SmartEnemy, handler));
                    handler.addObject(new SmartEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.SmartEnemy, handler));
                }
                if (hud.getLevel() == 4) {
                    handler.addObject(new BasicEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.BasicEnemy, handler));
                }
                if (hud.getLevel() == 5) {
                    handler.addObject(new FastEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.FastEnemy, handler));
                }
                if (hud.getLevel() == 6) {
                    handler.addObject(new FastEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.FastEnemy, handler));
                }
                if (hud.getLevel() == 7) {
                    handler.addObject(new FastEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.FastEnemy, handler));
                }
                if (hud.getLevel() == 8) {
                    handler.addObject(new FastEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.FastEnemy, handler));
                    handler.addObject(new BasicEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.BasicEnemy, handler));
                }

                if (hud.getLevel() == 9) {
                    handler.addObject(new SmartEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.SmartEnemy, handler));
                    handler.addObject(new SmartEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.SmartEnemy, handler));
                    handler.addObject(new SmartEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.SmartEnemy, handler));
                }

                if (hud.getLevel() == 10) {
                    handler.clearEnemies();
                    handler.addObject(new EnemyBoss(((Game.WIDTH / 2) - 48), -100, ID.EnemyBoss, handler));
                }
            }
        }



            // if (bossCounter == 3) {
            //     handler.clearEnemies();
            //    handler.addObject(new EnemyBoss(((Game.WIDTH / 2) - 48), -100, ID.EnemyBoss, handler));

            //   if (hud.getLevel() == 2 ) {
            // handler.addObject(new SmartEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.SmartEnemy, handler));
            //  handler.addObject(new FastEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.FastEnemy, handler));
            // handler.addObject(new BasicEnemy(r.nextInt((int)Game.WIDTH), r.nextInt((int)Game.HEIGHT), ID.BasicEnemy, handler));


            // }

        }
    }


}

