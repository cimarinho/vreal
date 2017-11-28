package br.com.test.vreal.controller.test.util;

import static java.lang.System.getProperty;

public enum AppConfig {

    APP_HOST("app.host", "http://localhost"),
    APP_PORT("app.port", "8080");

    private final String key;
    private final String defaultValue;

    AppConfig(String key, String defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
    }

    public String asString() {
        return getProperty(key, defaultValue);
    }

    public int asInt() {
        return Integer.valueOf(asString());
    }

}
