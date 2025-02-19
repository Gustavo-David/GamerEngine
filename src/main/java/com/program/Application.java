package com.program;

import com.program.core.Window;

public class Application {
    public static void main(String[] args) {
        Window window = new Window(800, 600, "Minha Engine");

        window.create(); // 🔥 ESSA LINHA É ESSENCIAL PARA CRIAR A JANELA

        while (!window.shouldClose()) {
            window.update();
        }

        window.destroy();
    }
}
