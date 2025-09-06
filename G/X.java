package G;

import A0.c;
import F.a0;
import F.b0;
import F.b;
import F.c0;
import P4.a;
import com.google.firebase.messaging.u;
import kotlin.jvm.internal.q;

public final class x implements k {
    public final u a;
    public final y0 b;
    public final Object c;
    public final G.u d;
    public final G.u e;
    public final G.u f;
    public final Object g;
    public final long h;

    public x(y y0, y0 y00, Object object0, G.u u0) {
        u u1 = new u(y0.a);
        super();
        this.a = u1;
        this.b = y00;
        this.c = object0;
        G.u u2 = (G.u)y00.a.invoke(object0);
        this.d = u2;
        this.e = f.j(u0);
        G.u u3 = u1.o(u2, u0);
        this.g = y00.b.invoke(u3);
        if(((G.u)u1.c) == null) {
            u1.c = u2.c();
        }
        G.u u4 = (G.u)u1.c;
        if(u4 != null) {
            int v = u4.b();
            long v2 = 0L;
            for(int v3 = 0; v3 < v; ++v3) {
                c c0 = (c)u1.a;
                u2.getClass();
                float f = u0.a(v3);
                v2 = Math.max(v2, ((long)(Math.exp(((b0)c0.b).b(f) / (((double)c0.a) - 1.0)) * 1000.0)) * 1000000L);
            }
            this.h = v2;
            G.u u5 = f.j(this.a.p(v2, this.d, u0));
            this.f = u5;
            int v4 = u5.b();
            for(int v1 = 0; v1 < v4; ++v1) {
                float f1 = this.f.a(v1);
                this.a.getClass();
                this.a.getClass();
                float f2 = a.i(f1, -0.0f, 0.0f);
                this.f.e(f2, v1);
            }
            return;
        }
        q.m("velocityVector");
        throw null;
    }

    @Override  // G.k
    public final boolean b() {
        return false;
    }

    @Override  // G.k
    public final G.u c(long v) {
        return this.d(v) ? this.f : this.a.p(v, this.d, this.e);
    }

    @Override  // G.k
    public final long e() {
        return this.h;
    }

    @Override  // G.k
    public final y0 f() {
        return this.b;
    }

    @Override  // G.k
    public final Object g(long v) {
        if(!this.d(v)) {
            we.k k0 = this.b.b;
            u u0 = this.a;
            G.u u1 = this.d;
            if(((G.u)u0.b) == null) {
                u0.b = u1.c();
            }
            G.u u2 = (G.u)u0.b;
            if(u2 != null) {
                int v1 = u2.b();
                int v2 = 0;
                while(v2 < v1) {
                    G.u u3 = (G.u)u0.b;
                    if(u3 != null) {
                        c c0 = (c)u0.a;
                        float f = u1.a(v2);
                        float f1 = this.e.a(v2);
                        a0 a00 = ((b0)c0.b).a(f1);
                        F.a a0 = b.a((a00.c <= 0L ? 1.0f : ((float)(v / 1000000L)) / ((float)a00.c)));
                        u3.e(Math.signum(a00.a) * a00.b * a0.a + f, v2);
                        ++v2;
                        continue;
                    }
                    q.m("valueVector");
                    throw null;
                }
                G.u u4 = (G.u)u0.b;
                if(u4 != null) {
                    return k0.invoke(u4);
                }
                q.m("valueVector");
                throw null;
            }
            q.m("valueVector");
            throw null;
        }
        return this.g;
    }

    @Override  // G.k
    public final Object h() {
        return this.g;
    }
}

