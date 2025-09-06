package vf;

import Hf.x;
import Jf.k;
import Jf.l;
import Me.f;
import Me.w;
import Me.z;
import ie.m;
import kotlin.jvm.internal.q;
import qf.b;
import qf.e;

public final class j extends g {
    public final b b;
    public final e c;

    public j(b b0, e e0) {
        super(new m(b0, e0));
        this.b = b0;
        this.c = e0;
    }

    @Override  // vf.g
    public final x a(z z0) {
        q.g(z0, "module");
        b b0 = this.b;
        Me.e e0 = w.d(z0, b0);
        if(e0 != null) {
            if(!tf.e.m(e0, f.c)) {
                e0 = null;
            }
            if(e0 != null) {
                x x0 = e0.g();
                if(x0 != null) {
                    return x0;
                }
            }
        }
        return l.c(k.V, new String[]{b0.toString(), this.c.a});
    }

    @Override  // vf.g
    public final String toString() {
        return this.b.f() + '.' + this.c;
    }
}

