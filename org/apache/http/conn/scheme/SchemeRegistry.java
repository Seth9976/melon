package org.apache.http.conn.scheme;

import java.util.List;
import java.util.Map;
import org.apache.http.HttpHost;

@Deprecated
public final class SchemeRegistry {
    public SchemeRegistry() {
        throw new RuntimeException("Stub!");
    }

    public final Scheme get(String s) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public final Scheme getScheme(String s) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public final Scheme getScheme(HttpHost httpHost0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public final List getSchemeNames() {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public final Scheme register(Scheme scheme0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public void setItems(Map map0) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }

    public final Scheme unregister(String s) {
        synchronized(this) {
            throw new RuntimeException("Stub!");
        }
    }
}

