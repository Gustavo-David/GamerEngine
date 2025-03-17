package com.program.physics;

public class PhysicsEngine {
    private float posX, posY;
    private float velocityX, velocityY;
    private final float gravity = -0.001f;
    private final float jumpStrength = -0.02f;
    private final float moveSpeed = 0.001f;
    private final float maxFallSpeed = 0.02f;
    private boolean onGround = false;

    // 🔥 Definição dos limites da área permitida
    private final float minX = -0.8f;
    private final float maxX = 0.8f;
    private final float minY = -0.8f;
    private final float maxY = 0.8f;

    public PhysicsEngine(float startX, float startY) {
        this.posX = startX;
        this.posY = startY;
    }

    public void update(boolean moveLeft, boolean moveRight, boolean jump) {
        // Movimento lateral
        if (moveLeft) {
            velocityX = -moveSpeed;
        } else if (moveRight) {
            velocityX = moveSpeed;
        } else {
            velocityX *= 0.1f; // Suavização
        }

        // Pulo
        if (jump && onGround) {
            velocityY = -jumpStrength;
            onGround = false;
        }

        // Aplicando gravidade
        velocityY += gravity;
        if (velocityY > maxFallSpeed) {
            velocityY = maxFallSpeed;
        }

        // Atualizar posição
        posX += velocityX;
        posY += velocityY;

        // 🔥 Garantindo que o quadrado não ultrapasse os limites
        if (posX < minX) posX = minX;
        if (posX > maxX) posX = maxX;
        if (posY < minY) {
            posY = minY;
            velocityY = 0;
            onGround = true;
        }
        if (posY > maxY) posY = maxY;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }
}
