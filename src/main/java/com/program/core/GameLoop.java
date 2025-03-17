package com.program.core;

import org.lwjgl.opengl.GL11;

import com.program.graphics.Renderer;
import com.program.input.KeyHandler;
import com.program.physics.PhysicsEngine;

public class GameLoop {
    private boolean running;
    private Window window;
    private KeyHandler keyHandler;
    private PhysicsEngine physics;
    private Renderer renderer;
    private Timer timer;

    public GameLoop() {
        window = new Window(1920, 1080, "Minha Engine 2D");
        timer = new Timer();
    }

    public void start() {
        window.create();
        keyHandler = new KeyHandler(window.getWindow());
        physics = new PhysicsEngine(0, -0.9f);
        renderer = new Renderer();
        timer.init();

        running = true;
        loop();

        window.destroy();
    }

    private void loop() {
        while (running) {
            float deltaTime = timer.getDeltaTime();
            keyHandler.update();

            update(deltaTime);
            render();

            if (window.shouldClose()) {
                running = false;
            }

            window.update();
        }
    }

    private void update(float deltaTime) {
        physics.update(keyHandler.isMovingLeft(), keyHandler.isMovingRight(), keyHandler.isJumping());
        renderer.update(physics.getPosX(), physics.getPosY());
    }

    private void render() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        renderer.render();
    }
}
