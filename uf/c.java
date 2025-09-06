package uf;

import Hf.P;
import Hf.b0;
import Hf.x;
import If.i;
import Me.h;
import e.k;
import java.util.Collection;
import java.util.List;
import je.w;
import kotlin.jvm.internal.q;

public final class c implements b {
    public final P a;
    public i b;

    public c(P p0) {
        q.g(p0, "projection");
        super();
        this.a = p0;
        p0.a();
    }

    @Override  // uf.b
    public final P a() {
        return this.a;
    }

    @Override  // Hf.M
    public final Je.i d() {
        Je.i i0 = this.a.b().w().d();
        q.f(i0, "getBuiltIns(...)");
        return i0;
    }

    @Override  // Hf.M
    public final h e() {
        return null;
    }

    @Override  // Hf.M
    public final Collection f() {
        P p0 = this.a;
        x x0 = p0.a() == b0.e ? p0.b() : this.d().p();
        q.d(x0);
        return k.z(x0);
    }

    @Override  // Hf.M
    public final boolean g() {
        return false;
    }

    @Override  // Hf.M
    public final List getParameters() {
        return w.a;
    }

    @Override
    public final String toString() {
        return "CapturedTypeConstructor(" + this.a + ')';
    }
}

