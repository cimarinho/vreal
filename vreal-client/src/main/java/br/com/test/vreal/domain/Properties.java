package br.com.test.vreal.domain;

import java.io.Serializable;
import java.util.List;

public class Properties implements Serializable {

    private final int foundProperties;
    private final List<Property> properties;

    public Properties(int foundProperties, List<Property> properties) {
        this.foundProperties = foundProperties;
        this.properties = properties;
    }

    public int getFoundProperties() {
        return foundProperties;
    }

    public List<Property> getProperties() {
        return properties;
    }
}
