package Hf;

import Ac.W;
import Gf.i;
import Gf.k;
import Gf.m;
import Gf.p;
import If.f;
import java.util.List;
import kotlin.jvm.internal.q;
import we.a;

public final class z extends x {
    public final p b;
    public final a c;
    public final i d;

    public z(p p0, a a0) {
        q.g(p0, "storageManager");
        super();
        this.b = p0;
        this.c = a0;
        this.d = new i(((m)p0), a0);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
    }

    @Override  // Hf.x
    public final boolean D() {
        return this.J().D();
    }

    @Override  // Hf.x
    public final Af.p E() {
        return this.J().E();
    }

    @Override  // Hf.x
    public final x H(f f0) {
        q.g(f0, "kotlinTypeRefiner");
        W w0 = new W(14, f0, this);
        return new z(this.b, w0);
    }

    @Override  // Hf.x
    public final a0 I() {
        x x0;
        for(x0 = this.J(); x0 instanceof z; x0 = ((z)x0).J()) {
        }
        q.e(x0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
        return (a0)x0;
    }

    public final x J() {
        return (x)this.d.invoke();
    }

    @Override  // Hf.x
    public final List r() {
        return this.J().r();
    }

    @Override  // Hf.x
    public final I t() {
        return this.J().t();
    }

    @Override
    public final String toString() {
        return this.d.c == k.a || this.d.c == k.b ? "<Not computed yet>" : this.J().toString();
    }

    @Override  // Hf.x
    public final M w() {
        return this.J().w();
    }
}

