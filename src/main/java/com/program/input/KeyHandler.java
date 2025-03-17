package com.program.input;

import org.lwjgl.glfw.GLFW;

public class KeyHandler {
    private long window;

    public KeyHandler(long window) {
        this.window = window;
    }

    public float getMoveX() {
        float move = 0.0f;
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_A) == GLFW.GLFW_PRESS) {
            move = -0.01f; // Move para a esquerda
        }
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_D) == GLFW.GLFW_PRESS) {
            move = 0.01f; // Move para a direita
        }
        return move;
    }

    public float getMoveY() {
        float move = 0.0f;
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_W) == GLFW.GLFW_PRESS) {
            move = 0.01f; // Move para cima
        }
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_S) == GLFW.GLFW_PRESS) {
            move = -0.01f; // Move para baixo
        }
        return move;
    }
}
