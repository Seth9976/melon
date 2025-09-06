package w9;

import E9.w;
import Eb.f;
import Nb.i;
import com.iloen.melon.userstore.UserDatabase_Impl;
import com.iloen.melon.userstore.entity.ExcludedArtistEntity;
import java.util.ArrayList;
import java.util.List;
import k8.Y;
import m9.l;
import sd.g;
import td.m0;
import y9.b;
import z9.C;
import z9.M;
import z9.a;
import z9.o;

public final class d implements c {
    public final UserDatabase_Impl a;
    public final f b;
    public final f c;
    public final f d;
    public final f e;

    public d(UserDatabase_Impl userDatabase_Impl0) {
        this.a = userDatabase_Impl0;
        this.b = new f(13);
        this.c = new f(14);
        this.d = new f(15);
        this.e = new f(16);
    }

    @Override  // w9.c
    public final int a(String s) {
        g g0 = new g(s, 13);
        return (int)(((Integer)w.N(this.a, true, false, g0)));
    }

    @Override  // w9.c
    public final List b(String s) {
        g g0 = new g(s, 14);
        return (List)w.N(this.a, true, false, g0);
    }

    @Override  // w9.c
    public final Object c(String s, String s1, M m0) {
        i i0 = new i(s, s1, 13);
        return w.P(this.a, m0, i0, false, true);
    }

    @Override  // w9.c
    public final Object d(b b0, z9.d d0) {
        l l0 = new l(23, this, b0);
        return w.P(this.a, d0, l0, false, true);
    }

    @Override  // w9.c
    public final Object e(ExcludedArtistEntity excludedArtistEntity0, a a0) {
        l l0 = new l(22, this, excludedArtistEntity0);
        return w.P(this.a, a0, l0, false, true);
    }

    @Override  // w9.c
    public final Object f(String s, String s1, a a0) {
        i i0 = new i(s, s1, 11);
        return w.P(this.a, a0, i0, false, true);
    }

    @Override  // w9.c
    public final int g(String s, ArrayList arrayList0) {
        StringBuilder stringBuilder0 = Y.p("delete from dcf_extension_logs where member_key = ? and _id in (");
        a.a.k(arrayList0.size(), stringBuilder0);
        stringBuilder0.append(")");
        m0 m00 = new m0(arrayList0, stringBuilder0.toString(), s);
        return (int)(((Integer)w.N(this.a, false, true, m00)));
    }

    @Override  // w9.c
    public final Object h(String s, z9.d d0) {
        g g0 = new g(s, 10);
        return w.P(this.a, d0, g0, false, true);
    }

    @Override  // w9.c
    public final Object i(String s, oe.c c0) {
        g g0 = new g(s, 11);
        return w.P(this.a, c0, g0, true, false);
    }

    @Override  // w9.c
    public final void j(y9.a a0) {
        l l0 = new l(24, this, a0);
        w.N(this.a, false, true, l0);
    }

    @Override  // w9.c
    public final Object k(String s, C c0) {
        g g0 = new g(s, 12);
        return w.P(this.a, c0, g0, true, false);
    }

    @Override  // w9.c
    public final Object l(y9.d d0, oe.c c0) {
        l l0 = new l(21, this, d0);
        return w.P(this.a, c0, l0, false, true);
    }

    @Override  // w9.c
    public final Object m(int v, String s, oe.c c0) {
        Ld.w w0 = new Ld.w(s, v, 7);
        return w.P(this.a, c0, w0, true, false);
    }

    @Override  // w9.c
    public final Object n(String s, String s1, o o0) {
        i i0 = new i(s, s1, 12);
        return w.P(this.a, o0, i0, true, false);
    }
}

