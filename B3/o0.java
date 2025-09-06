package b3;

import F4.a;
import I6.p0;
import android.net.Uri;
import e3.b;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public final class o0 {
    public static final String A;
    public static final String B;
    public static final String C;
    public static final String D;
    public static final String E;
    public static final String F;
    public Object a;
    public Object b;
    public E c;
    public Object d;
    public long e;
    public long f;
    public long g;
    public boolean h;
    public boolean i;
    public y j;
    public boolean k;
    public long l;
    public long m;
    public int n;
    public int o;
    public long p;
    public static final Object q;
    public static final Object r;
    public static final E s;
    public static final String t;
    public static final String u;
    public static final String v;
    public static final String w;
    public static final String x;
    public static final String y;
    public static final String z;

    static {
        A a1;
        o0.q = new Object();
        o0.r = new Object();
        t t0 = new t();
        a a0 = new a();
        List list0 = Collections.EMPTY_LIST;
        p0 p00 = p0.e;
        x x0 = new x();
        B b0 = B.d;
        Uri uri0 = Uri.EMPTY;
        b.j(((Uri)a0.e) == null || ((UUID)a0.d) != null);
        w w0 = null;
        if(uri0 == null) {
            a1 = null;
        }
        else {
            if(((UUID)a0.d) != null) {
                w0 = new w(a0);
            }
            a1 = new A(uri0, null, w0, null, list0, null, p00, 0x8000000000000001L);
        }
        o0.s = new E("androidx.media3.common.Timeline", new v(t0), a1, new y(x0), G.K, b0);  // 初始化器: Lb3/u;-><init>(Lb3/t;)V
        o0.t = "1";
        o0.u = "2";
        o0.v = "3";
        o0.w = "4";
        o0.x = "5";
        o0.y = "6";
        o0.z = "7";
        o0.A = "8";
        o0.B = "9";
        o0.C = "a";
        o0.D = "b";
        o0.E = "c";
        o0.F = "d";
    }

    public o0() {
        this.a = o0.q;
        this.c = o0.s;
    }

    public final boolean a() {
        return this.j != null;
    }

    public final void b(Object object0, E e0, Object object1, long v, long v1, long v2, boolean z, boolean z1, y y0, long v3, long v4, int v5, int v6, long v7) {
        this.a = object0;
        this.c = e0 == null ? o0.s : e0;
        this.b = null;
        this.d = object1;
        this.e = v;
        this.f = v1;
        this.g = v2;
        this.h = z;
        this.i = z1;
        this.j = y0;
        this.l = v3;
        this.m = v4;
        this.n = v5;
        this.o = v6;
        this.p = v7;
        this.k = false;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return o0.class.equals(class0) && Objects.equals(this.a, ((o0)object0).a) && Objects.equals(this.c, ((o0)object0).c) && Objects.equals(this.d, ((o0)object0).d) && Objects.equals(this.j, ((o0)object0).j) && this.e == ((o0)object0).e && this.f == ((o0)object0).f && this.g == ((o0)object0).g && this.h == ((o0)object0).h && this.i == ((o0)object0).i && this.k == ((o0)object0).k && this.l == ((o0)object0).l && this.m == ((o0)object0).m && this.n == ((o0)object0).n && this.o == ((o0)object0).o && this.p == ((o0)object0).p;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        int v1 = this.c.hashCode();
        int v2 = 0;
        int v3 = this.d == null ? 0 : this.d.hashCode();
        y y0 = this.j;
        if(y0 != null) {
            v2 = y0.hashCode();
        }
        return (((((((((((((v1 + (v + 0xD9) * 0x1F) * 0x1F + v3) * 0x1F + v2) * 0x1F + ((int)(this.e ^ this.e >>> 0x20))) * 0x1F + ((int)(this.f ^ this.f >>> 0x20))) * 0x1F + ((int)(this.g ^ this.g >>> 0x20))) * 0x1F + this.h) * 0x1F + this.i) * 0x1F + this.k) * 0x1F + ((int)(this.l ^ this.l >>> 0x20))) * 0x1F + ((int)(this.m ^ this.m >>> 0x20))) * 0x1F + this.n) * 0x1F + this.o) * 0x1F + ((int)(this.p ^ this.p >>> 0x20));
    }
}

