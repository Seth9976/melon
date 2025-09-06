package Nf;

import Hf.x;
import Je.i;
import bf.f;
import kotlin.jvm.internal.q;
import we.k;
import xf.d;
import y5.a;

public abstract class w implements e {
    public final k a;
    public final String b;

    public w(String s, k k0) {
        this.a = k0;
        this.b = "must return " + s;
    }

    @Override  // Nf.e
    public final boolean a(f f0) {
        x x0 = f0.g;
        i i0 = d.e(f0);
        return q.b(x0, this.a.invoke(i0));
    }

    @Override  // Nf.e
    public final String b(f f0) {
        return a.L(this, f0);
    }

    @Override  // Nf.e
    public final String getDescription() {
        return this.b;
    }
}

