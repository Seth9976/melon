package androidx.media3.session;

import M6.B;

public final class a1 implements e {
    public final e1 a;
    public final n0 b;
    public final w0 c;
    public final int d;

    public a1(e1 e10, n0 n00, w0 w00, int v) {
        this.a = e10;
        this.b = n00;
        this.c = w00;
        this.d = v;
    }

    @Override  // androidx.media3.session.e
    public final B run() {
        return (B)this.a.e(this.b, this.c, this.d);
    }
}

