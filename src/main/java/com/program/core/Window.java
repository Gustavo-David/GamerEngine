package com.program.core;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;

public class Window {

    private int width, height;
    private String title;
    private long window;

    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public void create() {
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Não foi possível inicializar o GLFW");
        }

        window = GLFW.glfwCreateWindow(width, height, title, 0, 0);
        if (window == 0) {
            throw new IllegalStateException("Falha ao criar a janela GLFW");
        }

        GLFW.glfwMakeContextCurrent(window);
        GLFW.glfwShowWindow(window);

        GL.createCapabilities();
    }

    public boolean shouldClose() {
        return GLFW.glfwWindowShouldClose(window);
    }

    public void update() {
        GLFW.glfwPollEvents();
    }

    public void destroy() {
        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();
    }
}
