package com.program.input;

import org.lwjgl.glfw.GLFW;

public class KeyHandler {
    private long window;
    private static final float SPEED = 1.0f; // Define a velocidade base

    public KeyHandler(long window) {
        this.window = window;
    }

    public float getMoveX(float deltaTime) {
        float move = 0.0f;
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_A) == GLFW.GLFW_PRESS) {
            move = -SPEED * deltaTime; // Move para a esquerda
        }
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_D) == GLFW.GLFW_PRESS) {
            move = SPEED * deltaTime; // Move para a direita
        }
        return move;
    }

    public float getMoveY(float deltaTime) {
        float move = 0.0f;
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_W) == GLFW.GLFW_PRESS) {
            move = SPEED * deltaTime; // Move para cima
        }
        if (GLFW.glfwGetKey(window, GLFW.GLFW_KEY_S) == GLFW.GLFW_PRESS) {
            move = -SPEED * deltaTime; // Move para baixo
        }
        return move;
    }
}
