package w9;

import com.iloen.melon.userstore.entity.ExcludedArtistEntity;
import e1.u;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import je.w;
import kotlin.jvm.internal.q;
import ne.a;
import z9.C;
import z9.M;
import z9.d;
import z9.o;

public final class b implements c {
    public final c a;

    public b(c c0) {
        q.g(c0, "userDao");
        super();
        this.a = c0;
    }

    @Override  // w9.c
    public final int a(String s) {
        q.g(s, "memberKey");
        return u.o(s) ? this.a.a(s) : 0;
    }

    @Override  // w9.c
    public final List b(String s) {
        q.g(s, "memberKey");
        return u.o(s) ? this.a.b(s) : w.a;
    }

    @Override  // w9.c
    public final Object c(String s, String s1, M m0) {
        if(u.o(s)) {
            Object object0 = this.a.c(s, s1, m0);
            if(object0 == a.a) {
                return object0;
            }
        }
        return H.a;
    }

    @Override  // w9.c
    public final Object d(y9.b b0, d d0) {
        if(u.o(b0.j)) {
            Object object0 = this.a.d(b0, d0);
            if(object0 == a.a) {
                return object0;
            }
        }
        return H.a;
    }

    @Override  // w9.c
    public final Object e(ExcludedArtistEntity excludedArtistEntity0, z9.a a0) {
        if(u.o(excludedArtistEntity0.j)) {
            Object object0 = this.a.e(excludedArtistEntity0, a0);
            if(object0 == a.a) {
                return object0;
            }
        }
        return H.a;
    }

    @Override  // w9.c
    public final Object f(String s, String s1, z9.a a0) {
        if(u.o(s)) {
            Object object0 = this.a.f(s, s1, a0);
            if(object0 == a.a) {
                return object0;
            }
        }
        return H.a;
    }

    @Override  // w9.c
    public final int g(String s, ArrayList arrayList0) {
        q.g(s, "memberKey");
        return u.o(s) ? this.a.g(s, arrayList0) : 0;
    }

    @Override  // w9.c
    public final Object h(String s, d d0) {
        if(u.o(s)) {
            Object object0 = this.a.h(s, d0);
            if(object0 == a.a) {
                return object0;
            }
        }
        return H.a;
    }

    @Override  // w9.c
    public final Object i(String s, oe.c c0) {
        return u.o(s) ? this.a.i(s, c0) : w.a;
    }

    @Override  // w9.c
    public final void j(y9.a a0) {
        if(u.o(a0.g)) {
            this.a.j(a0);
        }
    }

    @Override  // w9.c
    public final Object k(String s, C c0) {
        return u.o(s) ? this.a.k(s, c0) : w.a;
    }

    @Override  // w9.c
    public final Object l(y9.d d0, oe.c c0) {
        if(u.o(d0.e)) {
            Object object0 = this.a.l(d0, c0);
            if(object0 == a.a) {
                return object0;
            }
        }
        return H.a;
    }

    @Override  // w9.c
    public final Object m(int v, String s, oe.c c0) {
        return this.a.m(v, s, c0);
    }

    @Override  // w9.c
    public final Object n(String s, String s1, o o0) {
        return u.o(s) ? this.a.n(s, s1, o0) : "";
    }
}

