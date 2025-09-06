package b3;

import I6.O;
import I6.Q;
import I6.V;
import I6.Y;
import I6.b0;
import I6.p0;
import I6.w;
import android.os.Bundle;
import androidx.media3.common.TrackSelectionParameters.Builder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import ye.a;

public class u0 {
    public final Y A;
    public final b0 B;
    public static final u0 C;
    public static final String D;
    public static final String E;
    public static final String F;
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
    public final int a;
    public static final String a0;
    public final int b;
    public static final String b0;
    public final int c;
    public static final String c0;
    public final int d;
    public static final String d0;
    public final int e;
    public static final String e0;
    public final int f;
    public static final String f0;
    public final int g;
    public static final String g0;
    public final int h;
    public static final String h0;
    public final int i;
    public final int j;
    public final boolean k;
    public final V l;
    public final int m;
    public final V n;
    public final int o;
    public final int p;
    public final int q;
    public final V r;
    public final t0 s;
    public final V t;
    public final int u;
    public final int v;
    public final boolean w;
    public final boolean x;
    public final boolean y;
    public final boolean z;

    static {
        u0.C = new u0(new TrackSelectionParameters.Builder());
        u0.D = "1";
        u0.E = "2";
        u0.F = "3";
        u0.G = "4";
        u0.H = "5";
        u0.I = "6";
        u0.J = "7";
        u0.K = "8";
        u0.L = "9";
        u0.M = "a";
        u0.N = "b";
        u0.O = "c";
        u0.P = "d";
        u0.Q = "e";
        u0.R = "f";
        u0.S = "g";
        u0.T = "h";
        u0.U = "i";
        u0.V = "j";
        u0.W = "k";
        u0.X = "l";
        u0.Y = "m";
        u0.Z = "n";
        u0.a0 = "o";
        u0.b0 = "p";
        u0.c0 = "q";
        u0.d0 = "r";
        u0.e0 = "s";
        u0.f0 = "t";
        u0.g0 = "u";
        u0.h0 = "v";
    }

    public u0(TrackSelectionParameters.Builder trackSelectionParameters$Builder0) {
        this.a = trackSelectionParameters$Builder0.a;
        this.b = trackSelectionParameters$Builder0.b;
        this.c = trackSelectionParameters$Builder0.c;
        this.d = trackSelectionParameters$Builder0.d;
        this.e = trackSelectionParameters$Builder0.e;
        this.f = trackSelectionParameters$Builder0.f;
        this.g = trackSelectionParameters$Builder0.g;
        this.h = trackSelectionParameters$Builder0.h;
        this.i = trackSelectionParameters$Builder0.i;
        this.j = trackSelectionParameters$Builder0.j;
        this.k = trackSelectionParameters$Builder0.k;
        this.l = trackSelectionParameters$Builder0.l;
        this.m = trackSelectionParameters$Builder0.m;
        this.n = trackSelectionParameters$Builder0.n;
        this.o = trackSelectionParameters$Builder0.o;
        this.p = trackSelectionParameters$Builder0.p;
        this.q = trackSelectionParameters$Builder0.q;
        this.r = trackSelectionParameters$Builder0.r;
        this.s = trackSelectionParameters$Builder0.s;
        this.t = trackSelectionParameters$Builder0.t;
        this.u = trackSelectionParameters$Builder0.u;
        this.v = trackSelectionParameters$Builder0.v;
        this.w = trackSelectionParameters$Builder0.w;
        this.x = trackSelectionParameters$Builder0.x;
        this.y = trackSelectionParameters$Builder0.y;
        this.z = trackSelectionParameters$Builder0.z;
        this.A = Y.a(trackSelectionParameters$Builder0.A);
        this.B = b0.p(trackSelectionParameters$Builder0.B);
    }

    public TrackSelectionParameters.Builder a() {
        TrackSelectionParameters.Builder trackSelectionParameters$Builder0 = new TrackSelectionParameters.Builder();  // 初始化器: Ljava/lang/Object;-><init>()V
        trackSelectionParameters$Builder0.d(this);
        return trackSelectionParameters$Builder0;
    }

    public static u0 b(Bundle bundle0) {
        p0 p00;
        t0 t00;
        TrackSelectionParameters.Builder trackSelectionParameters$Builder0 = new TrackSelectionParameters.Builder();  // 初始化器: Ljava/lang/Object;-><init>()V
        u0 u00 = u0.C;
        trackSelectionParameters$Builder0.a = bundle0.getInt(u0.I, u00.a);
        trackSelectionParameters$Builder0.b = bundle0.getInt(u0.J, u00.b);
        trackSelectionParameters$Builder0.c = bundle0.getInt(u0.K, u00.c);
        trackSelectionParameters$Builder0.d = bundle0.getInt(u0.L, u00.d);
        trackSelectionParameters$Builder0.e = bundle0.getInt(u0.M, u00.e);
        trackSelectionParameters$Builder0.f = bundle0.getInt(u0.N, u00.f);
        trackSelectionParameters$Builder0.g = bundle0.getInt(u0.O, u00.g);
        trackSelectionParameters$Builder0.h = bundle0.getInt(u0.P, u00.h);
        trackSelectionParameters$Builder0.i = bundle0.getInt(u0.Q, u00.i);
        trackSelectionParameters$Builder0.j = bundle0.getInt(u0.R, u00.j);
        trackSelectionParameters$Builder0.k = bundle0.getBoolean(u0.S, u00.k);
        String[] arr_s = bundle0.getStringArray(u0.T);
        if(arr_s == null) {
            arr_s = new String[0];
        }
        trackSelectionParameters$Builder0.l = V.q(arr_s);
        trackSelectionParameters$Builder0.m = bundle0.getInt(u0.b0, u00.m);
        String[] arr_s1 = bundle0.getStringArray(u0.D);
        if(arr_s1 == null) {
            arr_s1 = new String[0];
        }
        trackSelectionParameters$Builder0.n = TrackSelectionParameters.Builder.e(arr_s1);
        trackSelectionParameters$Builder0.o = bundle0.getInt(u0.E, u00.o);
        trackSelectionParameters$Builder0.p = bundle0.getInt(u0.U, u00.p);
        trackSelectionParameters$Builder0.q = bundle0.getInt(u0.V, u00.q);
        String[] arr_s2 = bundle0.getStringArray(u0.W);
        if(arr_s2 == null) {
            arr_s2 = new String[0];
        }
        trackSelectionParameters$Builder0.r = V.q(arr_s2);
        Bundle bundle1 = bundle0.getBundle(u0.g0);
        if(bundle1 == null) {
            s0 s01 = new s0();
            s01.a = bundle0.getInt(u0.d0, t0.d.a);
            s01.b = bundle0.getBoolean(u0.e0, t0.d.b);
            s01.c = bundle0.getBoolean(u0.f0, t0.d.c);
            t00 = new t0(s01);
        }
        else {
            s0 s00 = new s0();
            s00.a = bundle1.getInt(t0.e, t0.d.a);
            s00.b = bundle1.getBoolean(t0.f, t0.d.b);
            s00.c = bundle1.getBoolean(t0.g, t0.d.c);
            t00 = new t0(s00);
        }
        trackSelectionParameters$Builder0.s = t00;
        String[] arr_s3 = bundle0.getStringArray(u0.F);
        if(arr_s3 == null) {
            arr_s3 = new String[0];
        }
        trackSelectionParameters$Builder0.t = TrackSelectionParameters.Builder.e(arr_s3);
        trackSelectionParameters$Builder0.u = bundle0.getInt(u0.G, u00.u);
        trackSelectionParameters$Builder0.v = bundle0.getInt(u0.c0, u00.v);
        trackSelectionParameters$Builder0.w = bundle0.getBoolean(u0.H, u00.w);
        trackSelectionParameters$Builder0.x = bundle0.getBoolean(u0.h0, u00.x);
        trackSelectionParameters$Builder0.y = bundle0.getBoolean(u0.X, u00.y);
        trackSelectionParameters$Builder0.z = bundle0.getBoolean(u0.Y, u00.z);
        ArrayList arrayList0 = bundle0.getParcelableArrayList(u0.Z);
        if(arrayList0 == null) {
            p00 = p0.e;
        }
        else {
            Q q0 = V.o();
            for(int v1 = 0; v1 < arrayList0.size(); ++v1) {
                Bundle bundle2 = (Bundle)arrayList0.get(v1);
                bundle2.getClass();
                Bundle bundle3 = bundle2.getBundle("0");
                bundle3.getClass();
                q0 q00 = q0.a(bundle3);
                int[] arr_v = bundle2.getIntArray("1");
                arr_v.getClass();
                q0.a(new r0(q00, a.r(arr_v)));
            }
            p00 = q0.g();
        }
        trackSelectionParameters$Builder0.A = new HashMap();
        for(int v2 = 0; v2 < p00.d; ++v2) {
            r0 r00 = (r0)p00.get(v2);
            trackSelectionParameters$Builder0.A.put(r00.a, r00);
        }
        int[] arr_v1 = bundle0.getIntArray(u0.a0);
        if(arr_v1 == null) {
            arr_v1 = new int[0];
        }
        trackSelectionParameters$Builder0.B = new HashSet();
        for(int v = 0; v < arr_v1.length; ++v) {
            trackSelectionParameters$Builder0.B.add(((int)arr_v1[v]));
        }
        return new u0(trackSelectionParameters$Builder0);
    }

    public Bundle c() {
        Bundle bundle0 = new Bundle();
        bundle0.putInt("6", this.a);
        bundle0.putInt("7", this.b);
        bundle0.putInt("8", this.c);
        bundle0.putInt("9", this.d);
        bundle0.putInt("a", this.e);
        bundle0.putInt("b", this.f);
        bundle0.putInt("c", this.g);
        bundle0.putInt("d", this.h);
        bundle0.putInt("e", this.i);
        bundle0.putInt("f", this.j);
        bundle0.putBoolean("g", this.k);
        bundle0.putStringArray("h", ((String[])this.l.toArray(new String[0])));
        bundle0.putInt("p", this.m);
        bundle0.putStringArray("1", ((String[])this.n.toArray(new String[0])));
        bundle0.putInt("2", this.o);
        bundle0.putInt("i", this.p);
        bundle0.putInt("j", this.q);
        bundle0.putStringArray("k", ((String[])this.r.toArray(new String[0])));
        bundle0.putStringArray("3", ((String[])this.t.toArray(new String[0])));
        bundle0.putInt("4", this.u);
        bundle0.putInt("q", this.v);
        bundle0.putBoolean("5", this.w);
        bundle0.putInt("r", this.s.a);
        bundle0.putBoolean("s", this.s.b);
        bundle0.putBoolean("t", this.s.c);
        Bundle bundle1 = new Bundle();
        bundle1.putInt("1", this.s.a);
        bundle1.putBoolean("2", this.s.b);
        bundle1.putBoolean("3", this.s.c);
        bundle0.putBundle("u", bundle1);
        bundle0.putBoolean("v", this.x);
        bundle0.putBoolean("l", this.y);
        bundle0.putBoolean("m", this.z);
        O o0 = this.A.e();
        ArrayList arrayList0 = new ArrayList(o0.size());
        for(Object object0: o0) {
            ((r0)object0).getClass();
            Bundle bundle2 = new Bundle();
            bundle2.putBundle("0", ((r0)object0).a.d());
            bundle2.putIntArray("1", a.Y(((r0)object0).b));
            arrayList0.add(bundle2);
        }
        bundle0.putParcelableArrayList("n", arrayList0);
        bundle0.putIntArray("o", a.Y(this.B));
        return bundle0;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null && this.getClass() == object0.getClass()) {
            u0 u00 = (u0)object0;
            if(this.a == u00.a && this.b == u00.b && this.c == u00.c && this.d == u00.d && this.e == u00.e && this.f == u00.f && this.g == u00.g && this.h == u00.h && this.k == u00.k && this.i == u00.i && this.j == u00.j && this.l.equals(u00.l) && this.m == u00.m && this.n.equals(u00.n) && this.o == u00.o && this.p == u00.p && this.q == u00.q && this.r.equals(u00.r) && this.s.equals(u00.s) && this.t.equals(u00.t) && this.u == u00.u && this.v == u00.v && this.w == u00.w && this.x == u00.x && this.y == u00.y && this.z == u00.z) {
                this.A.getClass();
                return w.g(u00.A, this.A) && this.B.equals(u00.B);
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.B.hashCode() + (this.A.hashCode() + (((((((this.t.hashCode() + (this.s.hashCode() + (this.r.hashCode() + ((((this.n.hashCode() + ((this.l.hashCode() + (((((((((((this.a + 0x1F) * 0x1F + this.b) * 0x1F + this.c) * 0x1F + this.d) * 0x1F + this.e) * 0x1F + this.f) * 0x1F + this.g) * 0x1F + this.h) * 0x1F + this.k) * 0x1F + this.i) * 0x1F + this.j) * 0x1F) * 0x1F + this.m) * 0x1F) * 0x1F + this.o) * 0x1F + this.p) * 0x1F + this.q) * 0x1F) * 0x1F) * 0x1F) * 0x1F + this.u) * 0x1F + this.v) * 0x1F + this.w) * 0x1F + this.x) * 0x1F + this.y) * 0x1F + this.z) * 0x1F) * 0x1F;
    }
}

