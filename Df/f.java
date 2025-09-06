package df;

import Af.p;
import Gf.i;
import Gf.m;
import Me.h;
import Se.x;
import Ue.c;
import cf.a;
import com.google.firebase.messaging.u;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import je.n;
import je.y;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.z;
import we.k;

public final class f implements p {
    public final u b;
    public final q c;
    public final w d;
    public final i e;
    public static final De.w[] f;

    static {
        z z0 = new z(f.class, "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", 0);
        f.f = new De.w[]{I.a.g(z0)};
    }

    public f(u u0, x x0, q q0) {
        this.b = u0;
        this.c = q0;
        this.d = new w(u0, x0, q0);
        Gf.p p0 = ((a)u0.a).a;
        e e0 = new e(this, 0);
        ((m)p0).getClass();
        this.e = new i(((m)p0), e0);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
    }

    @Override  // Af.p
    public final Set a() {
        p[] arr_p = this.h();
        Set set0 = new LinkedHashSet();
        for(int v = 0; v < arr_p.length; ++v) {
            je.u.U(set0, arr_p[v].a());
        }
        set0.addAll(this.d.a());
        return set0;
    }

    @Override  // Af.p
    public final Collection b(qf.e e0, c c0) {
        kotlin.jvm.internal.q.g(e0, "name");
        this.i(e0, c0);
        p[] arr_p = this.h();
        this.d.getClass();
        Collection collection0 = je.w.a;
        for(int v = 0; v < arr_p.length; ++v) {
            collection0 = a.a.p(collection0, arr_p[v].b(e0, c0));
        }
        return collection0 == null ? y.a : collection0;
    }

    @Override  // Af.r
    public final h c(qf.e e0, Ue.a a0) {
        kotlin.jvm.internal.q.g(e0, "name");
        kotlin.jvm.internal.q.g(a0, "location");
        this.i(e0, a0);
        this.d.getClass();
        h h0 = null;
        h h1 = this.d.v(e0, null);
        if(h1 != null) {
            return h1;
        }
        p[] arr_p = this.h();
        for(int v = 0; v < arr_p.length; ++v) {
            h h2 = arr_p[v].c(e0, a0);
            if(h2 != null) {
                if(!(h2 instanceof Me.i) || !((Me.x)h2).r0()) {
                    return h2;
                }
                if(h0 == null) {
                    h0 = h2;
                }
            }
        }
        return h0;
    }

    @Override  // Af.p
    public final Set d() {
        Set set0 = d5.f.y(n.M(this.h()));
        if(set0 != null) {
            set0.addAll(this.d.d());
            return set0;
        }
        return null;
    }

    @Override  // Af.r
    public final Collection e(Af.f f0, k k0) {
        kotlin.jvm.internal.q.g(f0, "kindFilter");
        p[] arr_p = this.h();
        Collection collection0 = this.d.e(f0, k0);
        for(int v = 0; v < arr_p.length; ++v) {
            collection0 = a.a.p(collection0, arr_p[v].e(f0, k0));
        }
        return collection0 == null ? y.a : collection0;
    }

    @Override  // Af.p
    public final Collection f(qf.e e0, Ue.a a0) {
        kotlin.jvm.internal.q.g(e0, "name");
        this.i(e0, a0);
        p[] arr_p = this.h();
        Collection collection0 = this.d.f(e0, a0);
        for(int v = 0; v < arr_p.length; ++v) {
            collection0 = a.a.p(collection0, arr_p[v].f(e0, a0));
        }
        return collection0 == null ? y.a : collection0;
    }

    @Override  // Af.p
    public final Set g() {
        p[] arr_p = this.h();
        Set set0 = new LinkedHashSet();
        for(int v = 0; v < arr_p.length; ++v) {
            je.u.U(set0, arr_p[v].g());
        }
        set0.addAll(this.d.g());
        return set0;
    }

    public final p[] h() {
        return (p[])P4.a.r(this.e, f.f[0]);
    }

    public final void i(qf.e e0, Ue.a a0) {
        kotlin.jvm.internal.q.g(e0, "name");
        kotlin.jvm.internal.q.g(a0, "location");
        d5.f.T(((a)this.b.a).n, a0, this.c, e0);
    }

    @Override
    public final String toString() {
        return "scope for " + this.c;
    }
}

