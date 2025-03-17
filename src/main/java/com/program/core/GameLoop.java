package com.program.core;

import org.lwjgl.opengl.GL11;

import com.program.graphics.Renderer;
import com.program.input.KeyHandler;

public class GameLoop {
    private boolean running;
    private Window window;
    private KeyHandler keyHandler;
    private Renderer renderer;

    public GameLoop() {
        window = new Window(1920, 1080, "Minha Engine 2D");
    }

    public void start() {
        window.create();
        keyHandler = new KeyHandler(window.getWindow());
        renderer = new Renderer();

        running = true;
        loop();

        window.destroy();
    }

    private void loop() {
        while (running) {
            update();
            render();

            if (window.shouldClose()) {
                running = false;
            }

            window.update();
        }
    }

    private void update() {
        float dx = keyHandler.getMoveX();
        float dy = keyHandler.getMoveY();
        renderer.update(dx, dy);
    }

    private void render() {
        // Limpa a tela
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

        // Renderiza o objeto
        renderer.render();
    }
}
