package uf;

import Af.p;
import Hf.B;
import Hf.I;
import Hf.M;
import Hf.P;
import Hf.a0;
import Hf.x;
import If.f;
import Jf.h;
import Jf.l;
import Kf.c;
import java.util.List;
import je.w;
import kotlin.jvm.internal.q;

public final class a extends B implements c {
    public final P b;
    public final uf.c c;
    public final boolean d;
    public final I e;

    public a(P p0, uf.c c0, boolean z, I i0) {
        q.g(p0, "typeProjection");
        q.g(i0, "attributes");
        super();
        this.b = p0;
        this.c = c0;
        this.d = z;
        this.e = i0;
    }

    @Override  // Hf.x
    public final boolean D() {
        return this.d;
    }

    @Override  // Hf.x
    public final p E() {
        return l.a(h.b, true, new String[0]);
    }

    @Override  // Hf.x
    public final x H(f f0) {
        q.g(f0, "kotlinTypeRefiner");
        return new a(this.b.d(f0), this.c, this.d, this.e);
    }

    @Override  // Hf.B
    public final a0 J(boolean z) {
        return z == this.d ? this : new a(this.b, this.c, z, this.e);
    }

    @Override  // Hf.a0
    public final a0 M(f f0) {
        q.g(f0, "kotlinTypeRefiner");
        return new a(this.b.d(f0), this.c, this.d, this.e);
    }

    @Override  // Hf.B
    public final B V(boolean z) {
        return z == this.d ? this : new a(this.b, this.c, z, this.e);
    }

    @Override  // Hf.B
    public final B W(I i0) {
        q.g(i0, "newAttributes");
        return new a(this.b, this.c, this.d, i0);
    }

    @Override  // Hf.x
    public final List r() {
        return w.a;
    }

    @Override  // Hf.x
    public final I t() {
        return this.e;
    }

    // 去混淆评级： 低(20)
    @Override  // Hf.B
    public final String toString() {
        return "Captured(" + this.b + ')' + (this.d ? "?" : "");
    }

    @Override  // Hf.x
    public final M w() {
        return this.c;
    }
}

