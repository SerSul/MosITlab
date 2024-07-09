package org.example;

public class Gun {
    private boolean isDestroyed;

    public Gun() {
        this.isDestroyed = false;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void destroy() {
        this.isDestroyed = true;
    }
}

