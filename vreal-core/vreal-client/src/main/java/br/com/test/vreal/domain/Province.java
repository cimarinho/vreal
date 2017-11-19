package br.com.test.vreal.domain;

import java.io.Serializable;

public class Province implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private Boundaries boundaries;

    private Province(ProvinceBuilder provinceBuilder) {
        this.name = provinceBuilder.name;
        this.boundaries = provinceBuilder.boundaries;
    }

    public static class ProvinceBuilder {

        private String name;
        private Boundaries boundaries = new Boundaries();

        public ProvinceBuilder(String name) {
            this.name = name;
        }

        public ProvinceBuilder square(int bottomRightX, int bottomRightY, int upperLeftX, int upperLeftY) {
            this.boundaries = new Boundaries(Boundary.getBoundary(bottomRightX, bottomRightY), Boundary.getBoundary(upperLeftX, upperLeftY));
            return this;
        }

        public Province build() {
            return new Province(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boundaries getBoundaries() {
        return boundaries;
    }

    public void setBoundaries(Boundaries boundaries) {
        this.boundaries = boundaries;
    }
}
