package com.program.graphics;

import org.lwjgl.opengl.GL11;

public class Renderer {

    private Texture texture;

    public Renderer(Texture texture) {
        this.texture = texture;
    }

    // Método responsável por renderizar o conteúdo na tela
    public void render() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT); // Limpa a tela

        // Ativa a textura
        texture.bind();

        // Exemplo simples de renderizar um quadrado com a textura
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0.0f, 0.0f); GL11.glVertex2f(-0.5f, -0.5f);
        GL11.glTexCoord2f(1.0f, 0.0f); GL11.glVertex2f( 0.5f, -0.5f);
        GL11.glTexCoord2f(1.0f, 1.0f); GL11.glVertex2f( 0.5f,  0.5f);
        GL11.glTexCoord2f(0.0f, 1.0f); GL11.glVertex2f(-0.5f,  0.5f);
        GL11.glEnd();
    }
}
