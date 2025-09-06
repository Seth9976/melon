package x1;

import B1.g;
import De.w;
import d5.m;
import kotlin.jvm.internal.q;
import r1.f;
import ze.a;

public final class c extends a {
    public final int b;
    public final d c;

    public c(d d0) {
        this.b = 1;
        this.c = d0;
        super(u.b);
    }

    public c(d d0, n n0) {
        this.b = 0;
        this.c = d0;
        super(n0);
    }

    @Override  // ze.a
    public final void a(w w0, Object object0, Object object1) {
        B1.c c0;
        if(this.b != 0) {
            u u0 = (u)object0;
            String s = w0.getName();
            this.c.b.C(s, ((u)object1).a);
            return;
        }
        n n0 = (n)object0;
        g g0 = this.c.b;
        String s1 = w0.getName();
        q.e(((n)object1), "null cannot be cast to non-null type androidx.constraintlayout.compose.DimensionDescription");
        m m0 = ((n)object1).a;
        m m1 = ((n)object1).c;
        m m2 = ((n)object1).b;
        if(((f)m2.b) != null || ((String)m2.c) != null || ((f)m1.b) != null || ((String)m1.c) != null) {
            g g1 = new g(new char[0]);  // 初始化器: LB1/b;-><init>([C)V
            if(((f)m2.b) != null || ((String)m2.c) != null) {
                g1.A("min", m2.d());
            }
            if(((f)m1.b) != null || ((String)m1.c) != null) {
                g1.A("max", m1.d());
            }
            g1.A("value", m0.d());
            c0 = g1;
        }
        else {
            c0 = m0.d();
        }
        g0.A(s1, c0);
    }
}

