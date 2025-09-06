package X0;

import we.n;

public final class w {
    public final String a;
    public final n b;
    public boolean c;

    public w(String s) {
        this(s, r.G);
    }

    public w(String s, n n0) {
        this.a = s;
        this.b = n0;
    }

    public w(String s, boolean z, n n0) {
        this(s, n0);
        this.c = z;
    }

    public final void a(x x0, Object object0) {
        ((l)x0).g(this, object0);
    }

    @Override
    public final String toString() {
        return "AccessibilityKey: " + this.a;
    }
}

