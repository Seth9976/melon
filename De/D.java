package de;

import java.io.Closeable;

public final class d implements Closeable {
    public final h a;

    public d(h h0) {
        this.a = h0;
    }

    @Override
    public final void close() {
        this.a.a();
    }
}

