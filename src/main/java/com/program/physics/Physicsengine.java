package com.program.physics;

public class PhysicsEngine {
    private float posX, posY; // Posição do personagem
    private float velocityX = 0; // Velocidade horizontal
    private float velocityY = 0; // Velocidade vertical (pulo)
    
    private final float acceleration = 0.02f; // Aceleração para movimentos suaves
    private final float maxSpeed = 0.1f; // Velocidade máxima
    private final float gravity = -0.005f; // Gravidade aplicada no pulo
    private final float jumpForce = 0.15f; // Força do pulo
    private boolean isGrounded = false; // Se o personagem está no chão

    public PhysicsEngine(float startX, float startY) {
        this.posX = startX;
        this.posY = startY;
    }

    public void update(boolean moveLeft, boolean moveRight, boolean jump) {
        // Movimentação Esquerda/Direita
        if (moveLeft) {
            velocityX -= acceleration;
        } else if (moveRight) {
            velocityX += acceleration;
        } else {
            velocityX *= 0.85f; // Faz o personagem desacelerar suavemente
        }

        // Limita a velocidade máxima
        if (velocityX > maxSpeed) velocityX = maxSpeed;
        if (velocityX < -maxSpeed) velocityX = -maxSpeed;

        // Pulo (apenas se estiver no chão)
        if (jump && isGrounded) {
            velocityY = jumpForce;
            isGrounded = false;
        }

        // Aplicando gravidade
        velocityY += gravity;

        // Atualiza posição
        posX += velocityX;
        posY += velocityY;

        // Colisão com o chão (para não cair infinitamente)
        if (posY < -0.8f) {
            posY = -0.8f;
            velocityY = 0;
            isGrounded = true;
        }
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }
}
