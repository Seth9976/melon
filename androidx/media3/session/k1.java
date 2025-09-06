package androidx.media3.session;

import I6.S;
import I6.V;
import Vd.w;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import b3.E;
import b3.G;
import b3.K;
import b3.L;
import b3.N;
import b3.Q;
import b3.a;
import b3.d;
import b3.g;
import b3.k;
import b3.l0;
import b3.m0;
import b3.n0;
import b3.o0;
import b3.p0;
import b3.u0;
import b3.w0;
import b3.y;
import b3.z0;
import b3.z;
import d3.c;
import e3.b;
import java.util.ArrayList;
import java.util.Arrays;

public final class k1 {
    public final long A;
    public final long B;
    public final long C;
    public final w0 D;
    public final u0 E;
    public static final k1 F;
    public static final String G;
    public static final String H;
    public static final String I;
    public static final String J;
    public static final String K;
    public static final String L;
    public static final String M;
    public static final String N;
    public static final String O;
    public static final String P;
    public static final String Q;
    public static final String R;
    public static final String S;
    public static final String T;
    public static final String U;
    public static final String V;
    public static final String W;
    public static final String X;
    public static final String Y;
    public static final String Z;
    public final K a;
    public static final String a0;
    public final int b;
    public static final String b0;
    public final v1 c;
    public static final String c0;
    public final Q d;
    public static final String d0;
    public final Q e;
    public static final String e0;
    public final int f;
    public static final String f0;
    public final L g;
    public static final String g0;
    public final int h;
    public static final String h0;
    public final boolean i;
    public static final String i0;
    public final p0 j;
    public static final String j0;
    public final int k;
    public static final String k0;
    public final z0 l;
    public static final String l0;
    public final G m;
    public final float n;
    public final d o;
    public final c p;
    public final k q;
    public final int r;
    public final boolean s;
    public final boolean t;
    public final int u;
    public final boolean v;
    public final boolean w;
    public final int x;
    public final int y;
    public final G z;

    static {
        k1.F = new k1(null, 0, v1.l, v1.k, v1.k, 0, L.d, 0, false, z0.d, p0.a, 0, G.K, 1.0f, d.g, c.c, k.e, 0, false, false, 1, 0, 1, false, false, G.K, 5000L, 15000L, 3000L, w0.b, u0.C);
        k1.G = "1";
        k1.H = "2";
        k1.I = "3";
        k1.J = "4";
        k1.K = "5";
        k1.L = "6";
        k1.M = "7";
        k1.N = "8";
        k1.O = "9";
        k1.P = "a";
        k1.Q = "b";
        k1.R = "c";
        k1.S = "d";
        k1.T = "e";
        k1.U = "f";
        k1.V = "g";
        k1.W = "h";
        k1.X = "i";
        k1.Y = "j";
        k1.Z = "k";
        k1.a0 = "l";
        k1.b0 = "m";
        k1.c0 = "n";
        k1.d0 = "o";
        k1.e0 = "p";
        k1.f0 = "q";
        k1.g0 = "r";
        k1.h0 = "s";
        k1.i0 = "t";
        k1.j0 = "u";
        k1.k0 = "v";
        k1.l0 = "w";
    }

    public k1(K k0, int v, v1 v10, Q q0, Q q1, int v1, L l0, int v2, boolean z, z0 z00, p0 p00, int v3, G g0, float f, d d0, c c0, k k1, int v4, boolean z1, boolean z2, int v5, int v6, int v7, boolean z3, boolean z4, G g1, long v8, long v9, long v10_1, w0 w00, u0 u00) {
        this.a = k0;
        this.b = v;
        this.c = v10;
        this.d = q0;
        this.e = q1;
        this.f = v1;
        this.g = l0;
        this.h = v2;
        this.i = z;
        this.l = z00;
        this.j = p00;
        this.k = v3;
        this.m = g0;
        this.n = f;
        this.o = d0;
        this.p = c0;
        this.q = k1;
        this.r = v4;
        this.s = z1;
        this.t = z2;
        this.u = v5;
        this.x = v6;
        this.y = v7;
        this.v = z3;
        this.w = z4;
        this.z = g1;
        this.A = v8;
        this.B = v9;
        this.C = v10_1;
        this.D = w00;
        this.E = u00;
    }

    public final k1 a(d d0) {
        boolean z1;
        p0 p00 = this.j;
        boolean z = p00.p();
        v1 v10 = this.c;
        if(z) {
            z1 = true;
        }
        else {
            int v = p00.o();
            z1 = v10.a.b >= v ? false : true;
        }
        b.j(z1);
        return new k1(this.a, this.b, v10, this.d, this.e, this.f, this.g, this.h, this.i, this.l, p00, this.k, this.m, this.n, d0, this.p, this.q, this.r, this.s, this.t, this.u, this.x, this.y, this.v, this.w, this.z, this.A, this.B, this.C, this.D, this.E);
    }

    public final k1 b(w0 w00) {
        boolean z1;
        p0 p00 = this.j;
        boolean z = p00.p();
        v1 v10 = this.c;
        if(z) {
            z1 = true;
        }
        else {
            int v = p00.o();
            z1 = v10.a.b >= v ? false : true;
        }
        b.j(z1);
        return new k1(this.a, this.b, v10, this.d, this.e, this.f, this.g, this.h, this.i, this.l, p00, this.k, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.x, this.y, this.v, this.w, this.z, this.A, this.B, this.C, w00, this.E);
    }

    public final k1 c(int v, boolean z) {
        boolean z2;
        p0 p00 = this.j;
        boolean z1 = p00.p();
        v1 v10 = this.c;
        if(z1) {
            z2 = true;
        }
        else {
            int v1 = p00.o();
            z2 = v10.a.b >= v1 ? false : true;
        }
        b.j(z2);
        return new k1(this.a, this.b, v10, this.d, this.e, this.f, this.g, this.h, this.i, this.l, p00, this.k, this.m, this.n, this.o, this.p, this.q, v, z, this.t, this.u, this.x, this.y, this.v, this.w, this.z, this.A, this.B, this.C, this.D, this.E);
    }

    public final k1 d(int v, int v1, boolean z) {
        boolean z1 = false;
        int v2 = this.y;
        p0 p00 = this.j;
        boolean z2 = p00.p();
        v1 v10 = this.c;
        if(z2) {
            z1 = true;
        }
        else {
            int v3 = p00.o();
            if(v10.a.b < v3) {
                z1 = true;
            }
        }
        b.j(z1);
        return new k1(this.a, this.b, v10, this.d, this.e, this.f, this.g, this.h, this.i, this.l, p00, this.k, this.m, this.n, this.o, this.p, this.q, this.r, this.s, z, v, v1, v2, v2 == 3 && z && v1 == 0, this.w, this.z, this.A, this.B, this.C, this.D, this.E);
    }

    public final k1 e(L l0) {
        boolean z1;
        p0 p00 = this.j;
        boolean z = p00.p();
        v1 v10 = this.c;
        if(z) {
            z1 = true;
        }
        else {
            int v = p00.o();
            z1 = v10.a.b >= v ? false : true;
        }
        b.j(z1);
        return new k1(this.a, this.b, v10, this.d, this.e, this.f, l0, this.h, this.i, this.l, p00, this.k, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.x, this.y, this.v, this.w, this.z, this.A, this.B, this.C, this.D, this.E);
    }

    public final k1 f(int v, K k0) {
        boolean z = false;
        boolean z1 = this.t;
        int v1 = this.x;
        p0 p00 = this.j;
        boolean z2 = p00.p();
        v1 v10 = this.c;
        if(z2) {
            z = true;
        }
        else {
            int v2 = p00.o();
            if(v10.a.b < v2) {
                z = true;
            }
        }
        b.j(z);
        return new k1(k0, this.b, v10, this.d, this.e, this.f, this.g, this.h, this.i, this.l, p00, this.k, this.m, this.n, this.o, this.p, this.q, this.r, this.s, z1, this.u, v1, v, v == 3 && z1 && v1 == 0, this.w, this.z, this.A, this.B, this.C, this.D, this.E);
    }

    public final k1 g(G g0) {
        boolean z1;
        p0 p00 = this.j;
        boolean z = p00.p();
        v1 v10 = this.c;
        if(z) {
            z1 = true;
        }
        else {
            int v = p00.o();
            z1 = v10.a.b >= v ? false : true;
        }
        b.j(z1);
        return new k1(this.a, this.b, v10, this.d, this.e, this.f, this.g, this.h, this.i, this.l, p00, this.k, g0, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.x, this.y, this.v, this.w, this.z, this.A, this.B, this.C, this.D, this.E);
    }

    public final k1 h(Q q0, Q q1, int v) {
        boolean z1;
        p0 p00 = this.j;
        boolean z = p00.p();
        v1 v10 = this.c;
        if(z) {
            z1 = true;
        }
        else {
            int v1 = p00.o();
            z1 = v10.a.b >= v1 ? false : true;
        }
        b.j(z1);
        return new k1(this.a, this.b, v10, q0, q1, v, this.g, this.h, this.i, this.l, p00, this.k, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.x, this.y, this.v, this.w, this.z, this.A, this.B, this.C, this.D, this.E);
    }

    public final k1 i(int v) {
        boolean z1;
        p0 p00 = this.j;
        boolean z = p00.p();
        v1 v10 = this.c;
        if(z) {
            z1 = true;
        }
        else {
            int v1 = p00.o();
            z1 = v10.a.b >= v1 ? false : true;
        }
        b.j(z1);
        return new k1(this.a, this.b, v10, this.d, this.e, this.f, this.g, v, this.i, this.l, p00, this.k, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.x, this.y, this.v, this.w, this.z, this.A, this.B, this.C, this.D, this.E);
    }

    public final k1 j(v1 v10) {
        boolean z;
        p0 p00 = this.j;
        if(p00.p()) {
            z = true;
        }
        else {
            int v = p00.o();
            z = v10.a.b >= v ? false : true;
        }
        b.j(z);
        return new k1(this.a, this.b, v10, this.d, this.e, this.f, this.g, this.h, this.i, this.l, p00, this.k, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.x, this.y, this.v, this.w, this.z, this.A, this.B, this.C, this.D, this.E);
    }

    public final k1 k(boolean z) {
        boolean z2;
        p0 p00 = this.j;
        boolean z1 = p00.p();
        v1 v10 = this.c;
        if(z1) {
            z2 = true;
        }
        else {
            int v = p00.o();
            z2 = v10.a.b >= v ? false : true;
        }
        b.j(z2);
        return new k1(this.a, this.b, v10, this.d, this.e, this.f, this.g, this.h, z, this.l, p00, this.k, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.x, this.y, this.v, this.w, this.z, this.A, this.B, this.C, this.D, this.E);
    }

    public final k1 l(p0 p00) {
        boolean z1;
        boolean z = p00.p();
        v1 v10 = this.c;
        if(z) {
            z1 = true;
        }
        else {
            int v = p00.o();
            z1 = v10.a.b >= v ? false : true;
        }
        b.j(z1);
        return new k1(this.a, this.b, v10, this.d, this.e, this.f, this.g, this.h, this.i, this.l, p00, this.k, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.x, this.y, this.v, this.w, this.z, this.A, this.B, this.C, this.D, this.E);
    }

    public final k1 m(q1 q10, int v) {
        boolean z;
        v1 v10 = new v1(new Q(this.c.a.a, v, this.c.a.c, this.c.a.d, this.c.a.e, this.c.a.f, this.c.a.g, this.c.a.h, this.c.a.i), this.c.b, this.c.c, this.c.d, this.c.e, this.c.f, this.c.g, this.c.h, this.c.i, this.c.j);
        if(q10.p()) {
            z = true;
        }
        else {
            int v1 = q10.o();
            z = v10.a.b >= v1 ? false : true;
        }
        b.j(z);
        return new k1(this.a, this.b, v10, this.d, this.e, this.f, this.g, this.h, this.i, this.l, q10, 0, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.x, this.y, this.v, this.w, this.z, this.A, this.B, this.C, this.D, this.E);
    }

    public final k1 n(p0 p00, v1 v10, int v) {
        boolean z;
        if(p00.p()) {
            z = true;
        }
        else {
            int v1 = p00.o();
            z = v10.a.b >= v1 ? false : true;
        }
        b.j(z);
        return new k1(this.a, this.b, v10, this.d, this.e, this.f, this.g, this.h, this.i, this.l, p00, v, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.x, this.y, this.v, this.w, this.z, this.A, this.B, this.C, this.D, this.E);
    }

    public final k1 o(u0 u00) {
        boolean z1;
        p0 p00 = this.j;
        boolean z = p00.p();
        v1 v10 = this.c;
        if(z) {
            z1 = true;
        }
        else {
            int v = p00.o();
            z1 = v10.a.b >= v ? false : true;
        }
        b.j(z1);
        return new k1(this.a, this.b, v10, this.d, this.e, this.f, this.g, this.h, this.i, this.l, p00, this.k, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.x, this.y, this.v, this.w, this.z, this.A, this.B, this.C, this.D, u00);
    }

    public final k1 p(float f) {
        boolean z1;
        p0 p00 = this.j;
        boolean z = p00.p();
        v1 v10 = this.c;
        if(z) {
            z1 = true;
        }
        else {
            int v = p00.o();
            z1 = v10.a.b >= v ? false : true;
        }
        b.j(z1);
        return new k1(this.a, this.b, v10, this.d, this.e, this.f, this.g, this.h, this.i, this.l, p00, this.k, this.m, f, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.x, this.y, this.v, this.w, this.z, this.A, this.B, this.C, this.D, this.E);
    }

    public final k1 q(N n0, boolean z, boolean z1) {
        boolean z5;
        int v3;
        int v2;
        boolean z2 = n0.a(16);
        boolean z3 = n0.a(17);
        v1 v10 = this.c;
        v1 v11 = v10.a(z2, z3);
        Q q0 = this.d.b(z2, z3);
        Q q1 = this.e.b(z2, z3);
        boolean z4 = true;
        p0 p00 = this.j;
        if(!z3 && z2 && !p00.p()) {
            int v = v10.a.b;
            if(p00.o() != 1) {
                o0 o00 = p00.m(v, new o0(), 0L);
                I6.Q q2 = V.o();
                for(int v1 = o00.n; true; ++v1) {
                    v2 = o00.o;
                    if(v1 > v2) {
                        break;
                    }
                    m0 m00 = p00.f(v1, new m0(), true);
                    m00.c = 0;
                    q2.a(m00);
                }
                o00.o = v2 - o00.n;
                o00.n = 0;
                p00 = new n0(V.t(o00), q2.g(), new int[]{0});
            }
        }
        else if(z || !z3) {
            p00 = p0.a;
        }
        G g0 = n0.a(18) ? this.m : G.K;
        float f = n0.a(22) ? this.n : 1.0f;
        d d0 = n0.a(21) ? this.o : d.g;
        c c0 = n0.a(28) ? this.p : c.c;
        if(n0.a(23)) {
            v3 = this.r;
            z5 = this.s;
        }
        else {
            v3 = 0;
            z5 = false;
        }
        G g1 = n0.a(18) ? this.z : G.K;
        w0 w00 = z1 || !n0.a(30) ? w0.b : this.D;
        if(!p00.p()) {
            int v4 = p00.o();
            if(v11.a.b >= v4) {
                z4 = false;
            }
        }
        b.j(z4);
        return new k1(this.a, this.b, v11, q0, q1, this.f, this.g, this.h, this.i, this.l, p00, this.k, g0, f, d0, c0, this.q, v3, z5, this.t, this.u, this.x, this.y, this.v, this.w, g1, this.A, this.B, this.C, w00, this.E);
    }

    public static k1 r(int v, Bundle bundle0) {
        w0 w00;
        long v20;
        int v19;
        c c1;
        k k1;
        I6.p0 p02;
        z0 z01;
        d d1;
        float f1;
        G g1;
        c c0;
        int v8;
        l0 l01;
        z0 z00;
        l0 l00;
        K k0;
        IBinder iBinder0 = bundle0.getBinder(k1.l0);
        if(iBinder0 instanceof j1) {
            return ((j1)iBinder0).a;
        }
        Bundle bundle1 = bundle0.getBundle(k1.X);
        Throwable throwable0 = null;
        if(bundle1 == null) {
            k0 = null;
        }
        else {
            String s = bundle1.getString("2");
            String s1 = bundle1.getString("3");
            String s2 = bundle1.getString("4");
            if(!TextUtils.isEmpty(s1)) {
                try {
                    Class class0 = Class.forName(s1, true, K.class.getClassLoader());
                    if(Throwable.class.isAssignableFrom(class0)) {
                        throwable0 = (Throwable)class0.getConstructor(String.class).newInstance(s2);
                    }
                }
                catch(Throwable unused_ex) {
                    throwable0 = new RemoteException(s2);
                    goto label_20;
                }
                if(throwable0 == null) {
                    throwable0 = new RemoteException(s2);
                }
            }
        label_20:
            int v1 = bundle1.getInt("0", 1000);
            Bundle bundle2 = bundle1.getBundle("5");
            if(bundle2 == null) {
                bundle2 = Bundle.EMPTY;
            }
            k0 = new K(s, throwable0, v1, bundle2, bundle1.getLong("1", SystemClock.elapsedRealtime()));
        }
        int v2 = bundle0.getInt(k1.Z, 0);
        Bundle bundle3 = bundle0.getBundle(k1.Y);
        v1 v10 = bundle3 == null ? v1.l : v1.b(bundle3);
        Bundle bundle4 = bundle0.getBundle(k1.a0);
        Q q0 = bundle4 == null ? v1.k : Q.c(bundle4);
        Bundle bundle5 = bundle0.getBundle(k1.b0);
        Q q1 = bundle5 == null ? v1.k : Q.c(bundle5);
        int v3 = bundle0.getInt(k1.c0, 0);
        Bundle bundle6 = bundle0.getBundle(k1.G);
        L l0 = bundle6 == null ? L.d : new L(bundle6.getFloat("0", 1.0f), bundle6.getFloat("1", 1.0f));
        int v4 = bundle0.getInt(k1.H, 0);
        boolean z = bundle0.getBoolean(k1.I, false);
        Bundle bundle7 = bundle0.getBundle(k1.J);
        if(bundle7 == null) {
            l00 = p0.a;
        }
        else {
            z z1 = new z(3);
            IBinder iBinder1 = bundle7.getBinder("0");
            I6.p0 p00 = iBinder1 == null ? I6.p0.e : b.r(z1, g.a(iBinder1));
            z z2 = new z(4);
            IBinder iBinder2 = bundle7.getBinder("1");
            I6.p0 p01 = iBinder2 == null ? I6.p0.e : b.r(z2, g.a(iBinder2));
            int[] arr_v = bundle7.getIntArray("2");
            if(arr_v == null) {
                int v5 = p00.d;
                int[] arr_v1 = new int[v5];
                for(int v6 = 0; v6 < v5; ++v6) {
                    arr_v1[v6] = v6;
                }
                arr_v = arr_v1;
            }
            l00 = new n0(p00, p01, arr_v);
        }
        int v7 = bundle0.getInt(k1.k0, 0);
        Bundle bundle8 = bundle0.getBundle(k1.K);
        if(bundle8 == null) {
            z00 = z0.d;
            l01 = l00;
            v8 = v7;
        }
        else {
            l01 = l00;
            v8 = v7;
            z00 = new z0(bundle8.getInt("0", 0), bundle8.getInt("1", 0), bundle8.getFloat("3", 1.0f));
        }
        Bundle bundle9 = bundle0.getBundle(k1.L);
        G g0 = bundle9 == null ? G.K : G.b(bundle9);
        float f = bundle0.getFloat(k1.M, 1.0f);
        Bundle bundle10 = bundle0.getBundle(k1.N);
        d d0 = bundle10 == null ? d.g : d.a(bundle10);
        Bundle bundle11 = bundle0.getBundle(k1.d0);
        if(bundle11 == null) {
            c0 = c.c;
            g1 = g0;
            f1 = f;
            d1 = d0;
            z01 = z00;
        }
        else {
            g1 = g0;
            ArrayList arrayList0 = bundle11.getParcelableArrayList("0");
            if(arrayList0 == null) {
                p02 = I6.p0.e;
                f1 = f;
                d1 = d0;
                z01 = z00;
            }
            else {
                f1 = f;
                I6.Q q2 = V.o();
                d1 = d0;
                z01 = z00;
                for(int v9 = 0; v9 < arrayList0.size(); ++v9) {
                    Bundle bundle12 = (Bundle)arrayList0.get(v9);
                    bundle12.getClass();
                    q2.a(d3.b.a(bundle12));
                }
                p02 = q2.g();
            }
            c0 = new c(bundle11.getLong("1"), p02);
        }
        Bundle bundle13 = bundle0.getBundle(k1.O);
        if(bundle13 == null) {
            k1 = k.e;
            c1 = c0;
        }
        else {
            int v10_1 = bundle13.getInt("0", 0);
            int v11 = bundle13.getInt("1", 0);
            c1 = c0;
            int v12 = bundle13.getInt("2", 0);
            String s3 = bundle13.getString("3");
            w w0 = new w(v10_1);
            w0.c = v11;
            w0.d = v12;
            w0.w0(s3);
            k1 = w0.e();
        }
        int v13 = bundle0.getInt(k1.P, 0);
        boolean z3 = bundle0.getBoolean(k1.Q, false);
        boolean z4 = bundle0.getBoolean(k1.R, false);
        int v14 = bundle0.getInt(k1.S, 1);
        int v15 = bundle0.getInt(k1.T, 0);
        int v16 = bundle0.getInt(k1.U, 1);
        boolean z5 = bundle0.getBoolean(k1.V, false);
        boolean z6 = bundle0.getBoolean(k1.W, false);
        Bundle bundle14 = bundle0.getBundle(k1.e0);
        G g2 = bundle14 == null ? G.K : G.b(bundle14);
        long v17 = bundle0.getLong(k1.f0, (v >= 4 ? 5000L : 0L));
        long v18 = bundle0.getLong(k1.g0, (v >= 4 ? 15000L : 0L));
        if(v < 4) {
            v19 = v13;
            v20 = 0L;
        }
        else {
            v19 = v13;
            v20 = 3000L;
        }
        long v21 = bundle0.getLong(k1.h0, v20);
        Bundle bundle15 = bundle0.getBundle(k1.j0);
        if(bundle15 == null) {
            w00 = w0.b;
        }
        else {
            ArrayList arrayList1 = bundle15.getParcelableArrayList("0");
            w00 = new w0((arrayList1 == null ? I6.p0.e : b.r(new z(7), arrayList1)));
        }
        Bundle bundle16 = bundle0.getBundle(k1.i0);
        return bundle16 == null ? new k1(k0, v2, v10, q0, q1, v3, l0, v4, z, z01, l01, v8, g1, f1, d1, c1, k1, v19, z3, z4, v14, v15, v16, z5, z6, g2, v17, v18, v21, w00, u0.C) : new k1(k0, v2, v10, q0, q1, v3, l0, v4, z, z01, l01, v8, g1, f1, d1, c1, k1, v19, z3, z4, v14, v15, v16, z5, z6, g2, v17, v18, v21, w00, u0.b(bundle16));
    }

    public final E s() {
        p0 p00 = this.j;
        if(p00.p()) {
            return null;
        }
        o0 o00 = new o0();
        return p00.m(this.c.a.b, o00, 0L).c;
    }

    public final Bundle t(int v) {
        int v24;
        m0 m02;
        int v23;
        Bundle bundle6;
        int v19;
        Bundle bundle0 = new Bundle();
        K k0 = this.a;
        if(k0 != null) {
            bundle0.putBundle("i", k0.c());
        }
        int v1 = this.b;
        if(v1 != 0) {
            bundle0.putInt("k", v1);
        }
        v1 v10 = this.c;
        if(v < 3 || !v10.equals(v1.l)) {
            bundle0.putBundle("j", v10.c(v));
        }
        Q q0 = this.d;
        if(v < 3 || !v1.k.a(q0)) {
            bundle0.putBundle("l", q0.d(v));
        }
        Q q1 = this.e;
        if(v < 3 || !v1.k.a(q1)) {
            bundle0.putBundle("m", q1.d(v));
        }
        int v2 = this.f;
        if(v2 != 0) {
            bundle0.putInt("n", v2);
        }
        L l0 = this.g;
        if(!l0.equals(L.d)) {
            Bundle bundle1 = new Bundle();
            bundle1.putFloat("0", l0.a);
            bundle1.putFloat("1", l0.b);
            bundle0.putBundle("1", bundle1);
        }
        int v3 = this.h;
        if(v3 != 0) {
            bundle0.putInt("2", v3);
        }
        if(this.i) {
            bundle0.putBoolean("3", true);
        }
        p0 p00 = this.j;
        if(!p00.equals(p0.a)) {
            ArrayList arrayList0 = new ArrayList();
            int v4 = p00.o();
            o0 o00 = new o0();
            for(int v5 = 0; v5 < v4; ++v5) {
                o0 o01 = p00.m(v5, o00, 0L);
                o01.getClass();
                Bundle bundle2 = new Bundle();
                if(!E.g.equals(o01.c)) {
                    bundle2.putBundle("1", o01.c.d(false));
                }
                long v6 = o01.e;
                if(v6 != 0x8000000000000001L) {
                    bundle2.putLong("2", v6);
                }
                long v7 = o01.f;
                if(v7 != 0x8000000000000001L) {
                    bundle2.putLong("3", v7);
                }
                long v8 = o01.g;
                if(v8 != 0x8000000000000001L) {
                    bundle2.putLong("4", v8);
                }
                if(o01.h) {
                    bundle2.putBoolean("5", true);
                }
                if(o01.i) {
                    bundle2.putBoolean("6", true);
                }
                y y0 = o01.j;
                if(y0 != null) {
                    bundle2.putBundle("7", y0.c());
                }
                if(o01.k) {
                    bundle2.putBoolean("8", true);
                }
                long v9 = o01.l;
                if(v9 != 0L) {
                    bundle2.putLong("9", v9);
                }
                long v10_1 = o01.m;
                if(v10_1 != 0x8000000000000001L) {
                    bundle2.putLong("a", v10_1);
                }
                int v11 = o01.n;
                if(v11 != 0) {
                    bundle2.putInt("b", v11);
                }
                int v12 = o01.o;
                if(v12 != 0) {
                    bundle2.putInt("c", v12);
                }
                long v13 = o01.p;
                if(v13 != 0L) {
                    bundle2.putLong("d", v13);
                }
                arrayList0.add(bundle2);
            }
            ArrayList arrayList1 = new ArrayList();
            int v14 = p00.h();
            m0 m00 = new m0();
            int v15 = 0;
            while(v15 < v14) {
                m0 m01 = p00.f(v15, m00, false);
                m01.getClass();
                Bundle bundle3 = new Bundle();
                int v16 = m01.c;
                if(v16 != 0) {
                    bundle3.putInt("0", v16);
                }
                long v17 = m01.d;
                if(v17 != 0x8000000000000001L) {
                    bundle3.putLong("1", v17);
                }
                long v18 = m01.e;
                if(v18 != 0L) {
                    bundle3.putLong("2", v18);
                }
                if(m01.f) {
                    bundle3.putBoolean("3", true);
                }
                if(m01.g.equals(b3.b.f)) {
                    v19 = v14;
                    m02 = m00;
                    v24 = v15;
                }
                else {
                    b3.b b0 = m01.g;
                    b0.getClass();
                    Bundle bundle4 = new Bundle();
                    ArrayList arrayList2 = new ArrayList();
                    v19 = v14;
                    a[] arr_a = b0.e;
                    for(int v20 = false; v20 < b0.e.length; ++v20) {
                        a a0 = arr_a[v20];
                        a0.getClass();
                        Bundle bundle5 = new Bundle();
                        bundle5.putLong("0", a0.a);
                        bundle5.putInt("1", a0.b);
                        bundle5.putInt("7", a0.c);
                        bundle5.putParcelableArrayList("2", new ArrayList(Arrays.asList(a0.d)));
                        ArrayList arrayList3 = new ArrayList();
                        int v21 = a0.e.length;
                        E[] arr_e = a0.e;
                        int v22 = false;
                        while(v22 < v21) {
                            E e0 = arr_e[v22];
                            if(e0 == null) {
                                bundle6 = null;
                                v23 = v21;
                            }
                            else {
                                v23 = v21;
                                bundle6 = e0.d(true);
                            }
                            arrayList3.add(bundle6);
                            ++v22;
                            v21 = v23;
                        }
                        bundle5.putParcelableArrayList("8", arrayList3);
                        bundle5.putIntArray("3", a0.f);
                        bundle5.putLongArray("4", a0.g);
                        bundle5.putLong("5", a0.h);
                        bundle5.putBoolean("6", a0.i);
                        arrayList2.add(bundle5);
                    }
                    m02 = m00;
                    v24 = v15;
                    if(!arrayList2.isEmpty()) {
                        bundle4.putParcelableArrayList("1", arrayList2);
                    }
                    long v25 = b0.b;
                    if(v25 != 0L) {
                        bundle4.putLong("2", v25);
                    }
                    long v26 = b0.c;
                    if(v26 != 0x8000000000000001L) {
                        bundle4.putLong("3", v26);
                    }
                    int v27 = b0.d;
                    if(v27 != 0) {
                        bundle4.putInt("4", v27);
                    }
                    bundle3.putBundle("4", bundle4);
                }
                arrayList1.add(bundle3);
                v15 = v24 + 1;
                v14 = v19;
                m00 = m02;
            }
            int[] arr_v = new int[v4];
            if(v4 > 0) {
                arr_v[false] = p00.a(true);
            }
            for(int v28 = 1; v28 < v4; ++v28) {
                arr_v[v28] = p00.e(arr_v[v28 - 1], 0, true);
            }
            Bundle bundle7 = new Bundle();
            bundle7.putBinder("0", new g(arrayList0));
            bundle7.putBinder("1", new g(arrayList1));
            bundle7.putIntArray("2", arr_v);
            bundle0.putBundle("4", bundle7);
        }
        int v29 = this.k;
        if(v29 != 0) {
            bundle0.putInt("v", v29);
        }
        z0 z00 = this.l;
        if(!z00.equals(z0.d)) {
            Bundle bundle8 = new Bundle();
            int v30 = z00.a;
            if(v30 != 0) {
                bundle8.putInt("0", v30);
            }
            int v31 = z00.b;
            if(v31 != 0) {
                bundle8.putInt("1", v31);
            }
            float f = z00.c;
            if(f != 1.0f) {
                bundle8.putFloat("3", f);
            }
            bundle0.putBundle("5", bundle8);
        }
        G g0 = this.m;
        if(!g0.equals(G.K)) {
            bundle0.putBundle("6", g0.c());
        }
        float f1 = this.n;
        if(f1 != 1.0f) {
            bundle0.putFloat("7", f1);
        }
        d d0 = this.o;
        if(!d0.equals(d.g)) {
            bundle0.putBundle("8", d0.c());
        }
        c c0 = this.p;
        if(!c0.equals(c.c)) {
            Bundle bundle9 = new Bundle();
            V v32 = c0.a;
            I6.Q q2 = V.o();
            for(int v33 = 0; v33 < v32.size(); ++v33) {
                if(((d3.b)v32.get(v33)).d == null) {
                    q2.a(((d3.b)v32.get(v33)));
                }
            }
            I6.p0 p01 = q2.g();
            ArrayList arrayList4 = new ArrayList(p01.d);
            S s0 = p01.r(0);
            while(s0.hasNext()) {
                d3.b b1 = (d3.b)s0.next();
                Bundle bundle10 = b1.b();
                Bitmap bitmap0 = b1.d;
                if(bitmap0 != null) {
                    bundle10.putParcelable("3", bitmap0);
                }
                arrayList4.add(bundle10);
            }
            bundle9.putParcelableArrayList("0", arrayList4);
            bundle9.putLong("1", c0.b);
            bundle0.putBundle("o", bundle9);
        }
        k k1 = this.q;
        if(!k1.equals(k.e)) {
            Bundle bundle11 = new Bundle();
            int v34 = k1.a;
            if(v34 != 0) {
                bundle11.putInt("0", v34);
            }
            int v35 = k1.b;
            if(v35 != 0) {
                bundle11.putInt("1", v35);
            }
            int v36 = k1.c;
            if(v36 != 0) {
                bundle11.putInt("2", v36);
            }
            String s1 = k1.d;
            if(s1 != null) {
                bundle11.putString("3", s1);
            }
            bundle0.putBundle("9", bundle11);
        }
        int v37 = this.r;
        if(v37 != 0) {
            bundle0.putInt("a", v37);
        }
        if(this.s) {
            bundle0.putBoolean("b", true);
        }
        if(this.t) {
            bundle0.putBoolean("c", true);
        }
        int v38 = this.u;
        if(v38 != 1) {
            bundle0.putInt("d", v38);
        }
        int v39 = this.x;
        if(v39 != 0) {
            bundle0.putInt("e", v39);
        }
        int v40 = this.y;
        if(v40 != 1) {
            bundle0.putInt("f", v40);
        }
        if(this.v) {
            bundle0.putBoolean("g", true);
        }
        if(this.w) {
            bundle0.putBoolean("h", true);
        }
        G g1 = this.z;
        if(!g1.equals(G.K)) {
            bundle0.putBundle("p", g1.c());
        }
        long v41 = this.A;
        if(v41 != (v >= 6 ? 5000L : 0L)) {
            bundle0.putLong("q", v41);
        }
        long v42 = this.B;
        if(v42 != (v >= 6 ? 15000L : 0L)) {
            bundle0.putLong("r", v42);
        }
        long v43 = this.C;
        if(v43 != (v >= 6 ? 3000L : 0L)) {
            bundle0.putLong("s", v43);
        }
        w0 w00 = this.D;
        if(!w00.equals(w0.b)) {
            Bundle bundle12 = new Bundle();
            z z0 = new z(6);
            bundle12.putParcelableArrayList("0", b.C(w00.a, z0));
            bundle0.putBundle("u", bundle12);
        }
        u0 u00 = this.E;
        if(!u00.equals(u0.C)) {
            bundle0.putBundle("t", u00.c());
        }
        return bundle0;
    }
}

