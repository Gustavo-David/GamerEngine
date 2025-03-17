package com.program.graphics;

import org.lwjgl.opengl.GL11;

public class Renderer {
    private float x, y;
    private static final float SIZE = 0.05f; // Ajustando tamanho do quadrado

    public Renderer() {
        this.x = 0.0f;
        this.y = -0.8f;
    }

    public void update(float newX, float newY) {
        this.x = newX;
        this.y = newY;
    }

    public void render() {
       // 🔥 Desenhando a borda vermelha
       GL11.glColor3f(1.0f, 0.0f, 0.0f); // Vermelho
       GL11.glBegin(GL11.GL_LINE_LOOP);
       GL11.glVertex2f(-0.8f, -0.8f);
       GL11.glVertex2f(0.8f, -0.8f);
       GL11.glVertex2f(0.8f, 0.8f);
       GL11.glVertex2f(-0.8f, 0.8f);
       GL11.glEnd();

       // 🔷 Desenhando o quadrado azul (personagem)
       GL11.glColor3f(0.0f, 0.0f, 1.0f); // Azul
       GL11.glBegin(GL11.GL_QUADS);
       GL11.glVertex2f(x - SIZE, y - SIZE);
       GL11.glVertex2f(x + SIZE, y - SIZE);
       GL11.glVertex2f(x + SIZE, y + SIZE);
       GL11.glVertex2f(x - SIZE, y + SIZE);
       GL11.glEnd();
    }
}
