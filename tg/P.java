package tg;

import java.util.Objects;

public final class p extends RuntimeException {
    public final int a;
    public final String b;
    public final transient Q c;

    public p(Q q0) {
        Objects.requireNonNull(q0, "response == null");
        super("HTTP " + q0.a.code() + " " + q0.a.message());
        this.a = q0.a.code();
        this.b = q0.a.message();
        this.c = q0;
    }
}

