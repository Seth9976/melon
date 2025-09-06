package vf;

import Hf.x;
import Jf.l;
import Me.z;
import ie.H;
import kotlin.jvm.internal.q;

public final class k extends g {
    public final String b;

    public k(String s) {
        super(H.a);
        this.b = s;
    }

    @Override  // vf.g
    public final x a(z z0) {
        q.g(z0, "module");
        return l.c(Jf.k.E, new String[]{this.b});
    }

    @Override  // vf.g
    public final Object b() {
        throw new UnsupportedOperationException();
    }

    @Override  // vf.g
    public final String toString() {
        return this.b;
    }
}

