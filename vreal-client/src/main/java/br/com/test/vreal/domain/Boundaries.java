package br.com.test.vreal.domain;


import java.io.Serializable;

public class Boundaries implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Boundary upperLeft;
    private final Boundary bottomRight;

    Boundaries() {
        this(null, null);
    }

    public Boundaries(Boundary upperLeft, Boundary bottomRight) {
        this.upperLeft = upperLeft;
        this.bottomRight = bottomRight;
    }

    public Boundary getUpperLeft() {
        return upperLeft;
    }

    public Boundary getBottomRight() {
        return bottomRight;
    }
}
