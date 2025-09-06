package org.apache.http.entity.mime;

public class MinimalField {
    private final String name;
    private final String value;

    public MinimalField(String s, String s1) {
        this.name = s;
        this.value = s1;
    }

    public String getBody() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.value;
    }
}

