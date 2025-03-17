package com.program.input;

import org.lwjgl.glfw.GLFW;

public class KeyHandler {
    private long window;
    private boolean moveLeft, moveRight, jump;

    public KeyHandler(long window) {
        this.window = window;
    }

    public void update() {
        moveLeft = GLFW.glfwGetKey(window, GLFW.GLFW_KEY_A) == GLFW.GLFW_PRESS;
        moveRight = GLFW.glfwGetKey(window, GLFW.GLFW_KEY_D) == GLFW.GLFW_PRESS;
        jump = GLFW.glfwGetKey(window, GLFW.GLFW_KEY_SPACE) == GLFW.GLFW_PRESS;
    }

    public boolean isMovingLeft() {
        return moveLeft;
    }

    public boolean isMovingRight() {
        return moveRight;
    }

    public boolean isJumping() {
        return jump;
    }
}
