package Ae;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public final class e extends f implements Serializable {
    @Override  // Ae.f
    public final int a(int v) {
        return f.b.a(v);
    }

    @Override  // Ae.f
    public final int b() {
        return f.b.b();
    }

    @Override  // Ae.f
    public final int c(int v) {
        return f.b.c(v);
    }

    @Override  // Ae.f
    public final int d(int v, int v1) {
        return f.b.d(v, v1);
    }

    private final void readObject(ObjectInputStream objectInputStream0) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        return d.a;
    }
}

