package org.apache.http.config;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
public final class RegistryBuilder {
    private final Map items;

    public RegistryBuilder() {
        this.items = new HashMap();
    }

    public Registry build() {
        return new Registry(this.items);
    }

    public static RegistryBuilder create() {
        return new RegistryBuilder();
    }

    public RegistryBuilder register(String s, Object object0) {
        Args.notEmpty(s, "ID");
        Args.notNull(object0, "Item");
        this.items.put(s.toLowerCase(Locale.US), object0);
        return this;
    }

    @Override
    public String toString() {
        return this.items.toString();
    }
}

