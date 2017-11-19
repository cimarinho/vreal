package br.com.test.vreal.domain;

import java.io.Serializable;

public class Boundary implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int x;
    private final int y;

    private Boundary() {
        this(0, 0);
    }

    private Boundary(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Boundary getBoundary(int x, int y) {
        return new Boundary(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
