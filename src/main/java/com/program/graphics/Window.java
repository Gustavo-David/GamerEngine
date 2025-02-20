package com.program.graphics;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

public class Window {
    private long windowHandle;
    private int width, height;
    private String title;

    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public void create() {
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Erro ao inicializar GLFW!");
        }

        windowHandle = GLFW.glfwCreateWindow(width, height, title, 0, 0);
        if (windowHandle == 0) {
            throw new RuntimeException("Erro ao criar a janela!");
        }

        GLFWVidMode videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        GLFW.glfwSetWindowPos(windowHandle, (videoMode.width() - width) / 2, (videoMode.height() - height) / 2);

        GLFW.glfwMakeContextCurrent(windowHandle);
        GL.createCapabilities();
    }

    public boolean shouldClose() {
        return GLFW.glfwWindowShouldClose(windowHandle);
    }

    public void update() {
        GLFW.glfwSwapBuffers(windowHandle);
        GLFW.glfwPollEvents();
    }

    public void destroy() {
        GLFW.glfwDestroyWindow(windowHandle);
        GLFW.glfwTerminate();
    }

    public long getWindowHandle() {
        return windowHandle;
    }
}
