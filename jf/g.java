package jf;

import Ff.l;
import Ff.m;
import Re.c;
import androidx.appcompat.app.o;
import e1.x;
import kf.a;
import kotlin.jvm.internal.q;
import lf.E;
import of.k;
import pf.f;
import qf.e;
import yf.b;

public final class g implements m {
    public final b a;
    public final b b;
    public final c c;

    public g(c c0, E e0, f f0, boolean z, l l0) {
        q.g(c0, "kotlinClass");
        q.g(e0, "packageProto");
        q.g(f0, "nameResolver");
        b b0 = new b(b.e(Se.c.a(c0.a)));
        String s = c0.b.b;
        b b1 = null;
        if(((a)c0.b.d) != a.i) {
            s = null;
        }
        if(s != null && s.length() > 0) {
            b1 = b.c(s);
        }
        super();
        this.a = b0;
        this.b = b1;
        this.c = c0;
        q.f(k.m, "packageModuleName");
        Integer integer0 = (Integer)x.G(e0, k.m);
        if(integer0 != null) {
            f0.getString(integer0.intValue());
        }
    }

    @Override  // Ff.m
    public final String a() {
        return o.r(new StringBuilder("Class \'"), this.b().a().a.a, '\'');
    }

    public final qf.b b() {
        qf.c c0;
        b b0 = this.a;
        String s = b0.a;
        int v = s.lastIndexOf("/");
        if(v == -1) {
            c0 = qf.c.c;
            if(c0 == null) {
                b.a(9);
                throw null;
            }
        }
        else {
            c0 = new qf.c(s.substring(0, v).replace('/', '.'));
        }
        String s1 = b0.d();
        q.f(s1, "getInternalName(...)");
        return new qf.b(c0, e.e(Tf.o.Y0('/', s1, s1)));
    }

    // 去混淆评级： 低(40)
    @Override
    public final String toString() {
        return "g: " + this.a;
    }
}

