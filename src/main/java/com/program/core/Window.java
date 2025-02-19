package com.program.core;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;

public class Window {
    private long window;
    private int width, height;
    private String title;

    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public void create() {
        // Inicializa GLFW
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Falha ao inicializar GLFW!");
        }

        // Configura a janela
        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);

        // Cria a janela
        window = GLFW.glfwCreateWindow(width, height, title, MemoryUtil.NULL, MemoryUtil.NULL);
        if (window == MemoryUtil.NULL) {
            throw new RuntimeException("Falha ao criar janela!");
        }

        // Pega o monitor primário e centraliza a janela
        GLFWVidMode vidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        if (vidMode != null) {
            GLFW.glfwSetWindowPos(window,
                    (vidMode.width() - width) / 2,
                    (vidMode.height() - height) / 2);
        }

        // Faz o contexto OpenGL atual
        GLFW.glfwMakeContextCurrent(window);
        GL.createCapabilities();

        // Exibe a janela
        GLFW.glfwShowWindow(window);
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

    public long getWindow() {
        return window;
    }
}
