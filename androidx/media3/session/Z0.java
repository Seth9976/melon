package androidx.media3.session;

public final class z0 implements D0 {
    public final v1 a;
    public final boolean b;
    public final boolean c;
    public final w0 d;

    public z0(v1 v10, boolean z, boolean z1, w0 w00) {
        this.a = v10;
        this.b = z;
        this.c = z1;
        this.d = w00;
    }

    @Override  // androidx.media3.session.D0
    public final void h(v0 v00, int v) {
        v00.f(v, this.a, this.b, this.c, this.d.c);
    }
}

