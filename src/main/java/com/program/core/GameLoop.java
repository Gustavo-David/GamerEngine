package com.program.core;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

public class GameLoop {
    private Window window;

    public void start() {
        window = new Window(800, 600, "Gamer Engine");
        window.create();

        // Loop do jogo
        while (!window.shouldClose()) {
            update();
            render();
            window.update();
        }

        // Finaliza a janela
        window.destroy();
    }

    private void update() {
        // Atualizar lógica do jogo
        if (GLFW.glfwGetKey(window.getWindow(), GLFW.GLFW_KEY_ESCAPE) == GLFW.GLFW_PRESS) {
            GLFW.glfwSetWindowShouldClose(window.getWindow(), true);
        }
    }

    private void render() {
        // Limpa a tela com cor preta
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

        // Troca os buffers (double buffering)
        GLFW.glfwSwapBuffers(window.getWindow());
    }

    public static void main(String[] args) {
        new GameLoop().start();
    }
}
