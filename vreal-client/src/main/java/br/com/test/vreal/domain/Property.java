package br.com.test.vreal.domain;

import java.io.Serializable;
import java.util.List;

public class Property implements Serializable {

    private Long id;

    private long x;

    private long y;

    private String title;

    private double price;

    private String description;

    private int beds;

    private int baths;

    private long squareMeters;

    private List<String> provinces;

    private Property(PropertyBuilder propertyBuilder) {
        this.id = propertyBuilder.id;
        this.x = propertyBuilder.x;
        this.y = propertyBuilder.y;
        this.price = propertyBuilder.price;
        this.description = propertyBuilder.description;
        this.beds = propertyBuilder.beds;
        this.baths = propertyBuilder.baths;
        this.squareMeters = propertyBuilder.squareMeters;
        this.title = propertyBuilder.title;
        this.provinces = propertyBuilder.provinces;

    }

    public static class PropertyBuilder {
        Long id;
        String title;
        int x;
        int y;
        double price;
        String description;
        int beds;
        int baths;
        long squareMeters;
        List<String> provinces;

        public PropertyBuilder (long id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }

        public PropertyBuilder provices (List<String> provinces) {
            this.provinces = provinces;
            return this;
        }

        public PropertyBuilder title(String title) {
            this.title = title;
            return this;
        }

        public PropertyBuilder price(double price) {
            this.price = price;
            return this;
        }

        public PropertyBuilder description(String description) {
            this.description = description;
            return this;
        }

        public PropertyBuilder beds(int beds) {
            this.beds = beds;
            return this;
        }

        public PropertyBuilder baths(int baths) {
            this.baths = baths;
            return this;
        }

        public PropertyBuilder squareMeters(long squareMeters) {
            this.squareMeters = squareMeters;
            return this;
        }

        public Property build() {
            return new Property(this);
        }
    }

    public Long getId() {
        return id;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getBeds() {
        return beds;
    }

    public int getBaths() {
        return baths;
    }

    public long getSquareMeters() {
        return squareMeters;
    }

    public List<String> getProvinces() {
        return provinces;
    }


}
