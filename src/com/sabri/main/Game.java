package com.sabri.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.Serializable;
import java.util.Random;

public class Game extends Canvas implements Serializable, Runnable {


    public static final float WIDTH = 1600, HEIGHT = WIDTH / 16 * 9;

    private static final long serialVersionUID = -3922283413751273958L;

    private Thread thread;
    private boolean running = false;


    private Random r;
    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private Menu menu;

    public enum STATE {
      Menu,
      Game,
      HELP

    }

    public STATE gameSTATE = STATE.Menu;


    public Game() {




        handler = new Handler();
        menu = new Menu(this, handler);
        this.addMouseListener(menu);
        this.addKeyListener(new KeyInput(handler));



        new Window((int)WIDTH, (int)HEIGHT, "LIMS INTERFACE", this);

        hud = new HUD();
       spawner = new Spawn(handler, hud);

        r = new Random();


        if (gameSTATE == STATE.Game) {


            // for (float i = 0; i < 50; i++) {
            //     handler.addObject(new Player(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.Player));
            // System.out.println(r.nextInt(WIDTH) + ", " + r.nextInt(HEIGHT));
            //  }


            handler.addObject(new Player((int) WIDTH / 2 - 32, (int) HEIGHT / 2 - 32, ID.Player, handler));
            handler.addObject(new BasicEnemy(r.nextInt((int) Game.WIDTH), r.nextInt((int) Game.HEIGHT), ID.BasicEnemy, handler));
            handler.addObject(new BasicEnemy(r.nextInt((int) WIDTH), r.nextInt((int) HEIGHT), ID.BasicEnemy, handler));


        }



    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();


    }

    private void tick() {
        handler.tick();
        if (gameSTATE == STATE.Game) {
            hud.tick();
            spawner.tick();
        }else if (gameSTATE == STATE.Menu) {
            menu.tick();
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;

        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, (int)WIDTH, (int)HEIGHT);


        handler.render(g);

        if (gameSTATE == STATE.Game) {

            hud.render(g);
        }else if (gameSTATE == STATE.Menu || gameSTATE == STATE.HELP) {
            menu.render(g);

        }
        g.dispose();
        bs.show();

    }

    public static float clamp(float var, float min, float max) {
        if(var >= max)
            return var = max;
        else if (var <= min)
            return var = min;
        else
            return var;

    }

    public static void main(String args[]) {

        new Game();
    }

}