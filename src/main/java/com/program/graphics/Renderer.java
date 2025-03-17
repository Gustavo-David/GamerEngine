package com.program.graphics;

import org.lwjgl.opengl.GL11;

public class Renderer {
    private float x, y; // Posição do quadrado
    private static final float SIZE = 0.1f; // Tamanho do quadrado

    public Renderer() {
        this.x = 0.0f;
        this.y = 0.0f;
    }

    public void update(float dx, float dy) {
        x += dx;
        y += dy;

        // 🔥 Adicionando colisão nas bordas da tela
        if (x + SIZE > 1.0f) x = 1.0f - SIZE;  // Colisão direita
        if (x - SIZE < -1.0f) x = -1.0f + SIZE; // Colisão esquerda
        if (y + SIZE > 1.0f) y = 1.0f - SIZE;  // Colisão superior
        if (y - SIZE < -1.0f) y = -1.0f + SIZE; // Colisão inferior
    }

    public void render() {
        GL11.glColor3f(0.0f, 0.0f, 1.0f); // Define a cor vermelha

        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(x - SIZE, y - SIZE);
        GL11.glVertex2f(x + SIZE, y - SIZE);
        GL11.glVertex2f(x + SIZE, y + SIZE);
        GL11.glVertex2f(x - SIZE, y + SIZE);
        GL11.glEnd();
    }
}
