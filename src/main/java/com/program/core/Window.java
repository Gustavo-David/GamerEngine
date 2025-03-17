package com.program.core;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

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

        // Centraliza a janela na tela
        GLFWVidMode vidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        GLFW.glfwSetWindowPos(window, (vidMode.width() - width) / 2, (vidMode.height() - height) / 2);

        GLFW.glfwMakeContextCurrent(window);
        GLFW.glfwShowWindow(window);
        GL.createCapabilities();

        // 🔥 Corrige a visualização para 2D
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(-1, 1, -1, 1, -1, 1); // Define uma área de visualização 2D
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
    }

    public boolean shouldClose() {
        return GLFW.glfwWindowShouldClose(window);
    }

    public void update() {
        GLFW.glfwSwapBuffers(window);
        GLFW.glfwPollEvents();
    }

    public void destroy() {
        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();
    }

    public long getWindow() {
        return window;
    }
}
