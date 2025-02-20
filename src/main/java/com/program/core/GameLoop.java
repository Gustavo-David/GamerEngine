package com.program.core;

public class GameLoop {
    private boolean running;
    private Window window;
    private Timer timer;

    public GameLoop() {
        window = new Window(800, 600, "Minha Engine 2D");
        timer = new Timer();
    }

    public void start() {
        window.create();
        timer.init();
        running = true;

        loop();
        window.destroy();
    }

    private void loop() {
        while (running) {
            float deltaTime = timer.getDeltaTime();

            update(deltaTime);
            render();

            if (window.shouldClose()) {
                running = false;
            }

            window.update();
        }
    }

    private void update(float deltaTime) {
        // Atualizações da lógica do jogo
    }

    private void render() {
        // Renderiza gráficos
    }
}
