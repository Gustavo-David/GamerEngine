package com.program.core;

import org.lwjgl.opengl.GL11;

import com.program.graphics.Renderer;
import com.program.input.KeyHandler;

public class GameLoop {
    private boolean running;
    private Window window;
    private KeyHandler keyHandler;
    private Renderer renderer;
    private Timer timer;


    public GameLoop() {
        window = new Window(1920, 1080, "Minha Engine 2D");
    }

    public void start() {
        window.create();
        keyHandler = new KeyHandler(window.getWindow());
        renderer = new Renderer();
        timer = new Timer();

        running = true;
        loop();

        window.destroy();
    }

    private void loop() {
        while (running) {
            float deltaTime = timer.getDeltaTime(); // Calcula o tempo entre frames

            update(deltaTime);
            render();

            if (window.shouldClose()) {
                running = false;
            }

            window.update();
        }
    }

    private void update(float deltaTime) {
        float dx = keyHandler.getMoveX(deltaTime);
        float dy = keyHandler.getMoveY(deltaTime);
        renderer.update(dx, dy);
    }

    private void render() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glLoadIdentity();

        renderer.render();
    }
}
