package com.program;

import com.program.core.GameLoop;

public class Application {
    public static void main(String[] args) {
        // Cria o GameLoop e inicia o jogo
        GameLoop gameLoop = new GameLoop();
        gameLoop.start();
    }
}
