package com.program.graphics;

import org.lwjgl.opengl.GL11;

public class Renderer {
    private float x, y;
    private static final float SIZE = 0.05f; // Tamanho do quadrado
    private static final float LIMIT = 0.8f; // Limite da borda

    public Renderer() {
        this.x = 0.0f;
        this.y = -0.8f;
    }

    public void update(float newX, float newY) {
        // Garantindo que o quadrado não ultrapasse os limites da borda
        this.x = Math.max(-LIMIT + SIZE, Math.min(LIMIT - SIZE, newX)); // Limite horizontal
        this.y = Math.max(-LIMIT + SIZE, Math.min(LIMIT - SIZE, newY)); // Limite vertical
    }

    public void render() {
        // 🔥 Desenhando a borda vermelha
        GL11.glColor3f(1.0f, 0.0f, 0.0f); // Cor vermelha
        GL11.glBegin(GL11.GL_LINE_LOOP);
        GL11.glVertex2f(-LIMIT, -LIMIT);
        GL11.glVertex2f(LIMIT, -LIMIT);
        GL11.glVertex2f(LIMIT, LIMIT);
        GL11.glVertex2f(-LIMIT, LIMIT);
        GL11.glEnd();

        // 🔷 Desenhando o quadrado azul (personagem)
        GL11.glColor3f(0.0f, 0.0f, 1.0f); // Cor azul
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(x - SIZE, y - SIZE);
        GL11.glVertex2f(x + SIZE, y - SIZE);
        GL11.glVertex2f(x + SIZE, y + SIZE);
        GL11.glVertex2f(x - SIZE, y + SIZE);
        GL11.glEnd();
    }
}
