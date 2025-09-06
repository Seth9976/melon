package Ge;

import B.a;
import Ff.m;
import Ff.t;
import Me.E;
import Me.L;
import Me.k;
import Me.p;
import Pe.z;
import Tf.o;
import Ze.u;
import e1.x;
import k8.Y;
import kotlin.jvm.internal.q;
import lf.I;
import nf.f;
import of.e;
import pf.d;
import pf.g;

public final class n extends a {
    public final L e;
    public final I f;
    public final e g;
    public final f h;
    public final z i;
    public final String j;

    public n(L l0, I i0, e e0, f f0, z z0) {
        q.g(i0, "proto");
        String s3;
        String s;
        q.g(f0, "nameResolver");
        q.g(z0, "typeTable");
        super();
        this.e = l0;
        this.f = i0;
        this.g = e0;
        this.h = f0;
        this.i = z0;
        if(e0.g()) {
            s = f0.getString(e0.e.c) + f0.getString(e0.e.d);
        }
        else {
            d d0 = g.b(i0, f0, z0, true);
            if(d0 == null) {
                throw new s0("No field signature for property: " + l0);
            }
            String s1 = d0.l;
            StringBuilder stringBuilder0 = new StringBuilder();
            stringBuilder0.append(u.a(d0.k));
            k k0 = l0.e();
            q.f(k0, "getContainingDeclaration(...)");
            if(q.b(l0.getVisibility(), p.d) && k0 instanceof Ff.k) {
                q.f(of.k.i, "classModuleName");
                Integer integer0 = (Integer)x.G(((Ff.k)k0).e, of.k.i);
                String s2 = integer0 == null ? "main" : f0.getString(integer0.intValue());
                s3 = "$" + qf.f.a.c(s2, "_");
            }
            else if(!q.b(l0.getVisibility(), p.a) || !(k0 instanceof E)) {
                s3 = "";
            }
            else {
                m m0 = ((t)l0).Z;
                if(!(m0 instanceof jf.g) || ((jf.g)m0).b == null) {
                    s3 = "";
                }
                else {
                    String s4 = ((jf.g)m0).a.d();
                    q.f(s4, "getInternalName(...)");
                    s3 = "$" + qf.e.e(o.Y0('/', s4, s4)).b();
                }
            }
            s = Y.l(stringBuilder0, s3, "()", s1);
        }
        this.j = s;
    }

    @Override  // B.a
    public final String k() {
        return this.j;
    }
}

