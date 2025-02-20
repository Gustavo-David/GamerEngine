package com.program.core;

public class Timer {
    private double lastTime;

    public void init() {
        lastTime = System.nanoTime() / 1_000_000_000.0;
    }

    public float getDeltaTime() {
        double currentTime = System.nanoTime() / 1_000_000_000.0;
        float delta = (float) (currentTime - lastTime);
        lastTime = currentTime;
        return delta;
    }
}
