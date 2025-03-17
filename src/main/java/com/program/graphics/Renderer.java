package com.program.graphics;

import org.lwjgl.opengl.GL11;

public class Renderer {
    private float x, y; // Posição do objeto na tela

    public Renderer() {
        this.x = 0.0f;  // Posição inicial X
        this.y = 0.0f;  // Posição inicial Y
    }

    public void update(float dx, float dy) {
        this.x += dx; // Atualiza posição X
        this.y += dy; // Atualiza posição Y
    }

    public void render() {
        // Define a cor do objeto (vermelho)
        GL11.glColor3f(1.0f, 0.0f, 0.0f);

        // Desenha um quadrado
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(x - 0.05f, y - 0.05f);
        GL11.glVertex2f(x + 0.05f, y - 0.05f);
        GL11.glVertex2f(x + 0.05f, y + 0.05f);
        GL11.glVertex2f(x - 0.05f, y + 0.05f);
        GL11.glEnd();
    }
}
