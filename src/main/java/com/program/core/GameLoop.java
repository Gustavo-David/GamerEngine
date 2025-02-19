package com.program.core;

import com.program.graphics.Renderer;
import com.program.graphics.Texture;

public class GameLoop {

    private Window window;
    private Renderer renderer;

    public void start() {
        window = new Window(800, 600, "Minha Engine");
        window.create();

        // Carregar a textura (pode ser qualquer imagem sua)
        Texture texture = new Texture("res/images/your_image.png");
        renderer = new Renderer(texture);

        // Loop principal do jogo
        while (!window.shouldClose()) {
            update();
            renderer.render(); // Aqui chamamos o render do Renderer
            window.update();   // Atualiza a janela
        }

        window.destroy(); // Destroi a janela ao sair do loop
    }

    private void update() {
        // Aqui você pode colocar a lógica do jogo
    }
}
