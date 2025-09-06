package org.apache.http.config;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public final class Registry implements Lookup {
    private final Map map;

    public Registry(Map map0) {
        this.map = new ConcurrentHashMap(map0);
    }

    @Override  // org.apache.http.config.Lookup
    public Object lookup(String s) {
        return s == null ? null : this.map.get(s.toLowerCase(Locale.US));
    }

    @Override
    public String toString() {
        return this.map.toString();
    }
}

