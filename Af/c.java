package af;

import Je.o;
import Se.d;
import Ze.v;
import bf.h;
import com.google.firebase.messaging.u;
import gf.b;
import ie.m;
import java.util.Map;
import je.C;
import kotlin.jvm.internal.q;
import qf.e;

public abstract class c {
    public static final e a;
    public static final e b;
    public static final e c;
    public static final Object d;

    static {
        c.a = e.e("message");
        c.b = e.e("allowedTargets");
        c.c = e.e("value");
        c.d = C.S(new m[]{new m(o.t, v.c), new m(o.w, v.d), new m(o.x, v.f)});
    }

    public static h a(qf.c c0, b b0, u u0) {
        q.g(c0, "kotlinName");
        q.g(b0, "annotationOwner");
        q.g(u0, "c");
        if(c0.equals(o.m)) {
            q.f(v.e, "DEPRECATED_ANNOTATION");
            d d0 = b0.a(v.e);
            if(d0 != null) {
                return new g(d0, u0);
            }
        }
        qf.c c1 = (qf.c)((Map)c.d).get(c0);
        if(c1 != null) {
            d d1 = b0.a(c1);
            return d1 == null ? null : c.b(d1, u0, false);
        }
        return null;
    }

    public static h b(d d0, u u0, boolean z) {
        q.g(d0, "annotation");
        q.g(u0, "c");
        qf.b b0 = Se.c.a(df.d.v(df.d.s(d0.a)));
        q.f(v.c, "TARGET_ANNOTATION");
        if(b0.equals(d3.g.i0(v.c))) {
            return new j(d0, u0);
        }
        q.f(v.d, "RETENTION_ANNOTATION");
        if(b0.equals(d3.g.i0(v.d))) {
            return new i(d0, u0);
        }
        q.f(v.f, "DOCUMENTED_ANNOTATION");
        if(b0.equals(d3.g.i0(v.f))) {
            return new af.b(u0, d0, o.x);
        }
        q.f(v.e, "DEPRECATED_ANNOTATION");
        return b0.equals(d3.g.i0(v.e)) ? null : new df.h(d0, u0, z);
    }
}

