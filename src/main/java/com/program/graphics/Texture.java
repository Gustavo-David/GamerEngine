package com.program.graphics;

import java.nio.ByteBuffer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.stb.STBImage;

public class Texture {

    private int textureID;

    public Texture(String path) {
        textureID = loadTexture(path);
    }

    private int loadTexture(String path) {
        // Declarando variáveis para largura, altura e canais
        int width = 0;
        int height = 0;
        int channels = 0;

        // Carrega a imagem e preenche as variáveis de dimensão
        ByteBuffer buffer = STBImage.stbi_load(path, width, height, channels, 0);
        if (buffer == null) {
            throw new RuntimeException("Falha ao carregar a textura: " + path);
        }

        // Gerando o ID da textura
        int textureID = GL11.glGenTextures();
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureID);

        // Configurações da textura
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);

        // Definindo a imagem como textura no OpenGL
        GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGB, width, height, 0, GL11.GL_RGB, GL11.GL_UNSIGNED_BYTE, buffer);

        // Liberando a memória do buffer
        STBImage.stbi_image_free(buffer);

        return textureID;
    }

    // Método para vincular a textura
    public void bind() {
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureID);
    }
}
