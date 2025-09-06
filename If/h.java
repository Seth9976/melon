package If;

import Ac.W;
import Af.p;
import Hf.B;
import Hf.I;
import Hf.M;
import Hf.a0;
import Hf.x;
import Jf.l;
import Kf.b;
import Kf.c;
import java.util.List;
import je.w;
import kotlin.jvm.internal.q;

public final class h extends B implements c {
    public final b b;
    public final i c;
    public final a0 d;
    public final I e;
    public final boolean f;
    public final boolean g;

    public h(b b0, i i0, a0 a00, I i1, boolean z, int v) {
        if((v & 8) != 0) {
            I.b.getClass();
            i1 = I.c;
        }
        if((v & 16) != 0) {
            z = false;
        }
        this(b0, i0, a00, i1, z, false);
    }

    public h(b b0, i i0, a0 a00, I i1, boolean z, boolean z1) {
        q.g(b0, "captureStatus");
        q.g(i0, "constructor");
        q.g(i1, "attributes");
        super();
        this.b = b0;
        this.c = i0;
        this.d = a00;
        this.e = i1;
        this.f = z;
        this.g = z1;
    }

    @Override  // Hf.x
    public final boolean D() {
        return this.f;
    }

    @Override  // Hf.x
    public final p E() {
        return l.a(Jf.h.b, true, new String[0]);
    }

    @Override  // Hf.x
    public final x H(f f0) {
        return this.Y(f0);
    }

    @Override  // Hf.B
    public final a0 J(boolean z) {
        return new h(this.b, this.c, this.d, this.e, z, 0x20);
    }

    @Override  // Hf.a0
    public final a0 M(f f0) {
        return this.Y(f0);
    }

    @Override  // Hf.B
    public final B V(boolean z) {
        return new h(this.b, this.c, this.d, this.e, z, 0x20);
    }

    @Override  // Hf.B
    public final B W(I i0) {
        q.g(i0, "newAttributes");
        return new h(this.b, this.c, this.d, i0, this.f, this.g);
    }

    public final h Y(f f0) {
        q.g(f0, "kotlinTypeRefiner");
        this.c.getClass();
        i i0 = new i(this.c.a.d(f0), (this.c.b == null ? null : new W(16, this.c, f0)), (this.c.c == null ? this.c : this.c.c), this.c.d);
        return this.d == null ? new h(this.b, i0, null, this.e, this.f, 0x20) : new h(this.b, i0, this.d, this.e, this.f, 0x20);
    }

    @Override  // Hf.x
    public final List r() {
        return w.a;
    }

    @Override  // Hf.x
    public final I t() {
        return this.e;
    }

    @Override  // Hf.x
    public final M w() {
        return this.c;
    }
}

