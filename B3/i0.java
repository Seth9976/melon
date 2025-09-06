package b3;

import I6.V;
import I6.w;
import X5.g;
import android.os.SystemClock;
import androidx.media3.common.Metadata.Entry;
import androidx.media3.common.Metadata;
import d3.c;
import e3.b;
import e3.q;
import e3.x;
import java.util.Arrays;
import java.util.Objects;

public final class i0 {
    public final h0 A;
    public final h0 B;
    public final g C;
    public final h0 D;
    public final g E;
    public final int F;
    public final N a;
    public final boolean b;
    public final int c;
    public final int d;
    public final K e;
    public final int f;
    public final long g;
    public final long h;
    public final long i;
    public final L j;
    public final u0 k;
    public final d l;
    public final float m;
    public final z0 n;
    public final c o;
    public final k p;
    public final int q;
    public final q r;
    public final Metadata s;
    public final p0 t;
    public final w0 u;
    public final G v;
    public final G w;
    public final int x;
    public final int y;
    public final int z;

    public i0(androidx.media3.common.d d0) {
        int v1;
        w0 w00 = d0.v;
        h0 h00 = d0.C;
        G g0 = d0.w;
        if(d0.u.p()) {
            b.d(d0.d == 1 || d0.d == 4, "Empty playlist only allowed in STATE_IDLE or STATE_ENDED");
            b.d(d0.z == -1 && d0.A == -1, "Ads not allowed if playlist is empty");
            if(w00 == null) {
                w00 = w0.b;
            }
            if(g0 == null) {
                g0 = G.K;
            }
        }
        else {
            int v = d0.y;
            if(v == -1) {
                v1 = 0;
            }
            else {
                b.d(v < d0.u.o(), "currentMediaItemIndex must be less than playlist.size()");
                v1 = v;
            }
            if(d0.z != -1) {
                m0 m00 = new m0();
                o0 o00 = new o0();
                Long long0 = d0.B;
                long v2 = long0 == null ? h00.get() : ((long)long0);
                int v3 = d0.u.b(d0.u.i(o00, m00, v1, x.M(v2)).first);
                d0.u.f(v3, m00, false);
                b.d(d0.z < m00.g.a, "PeriodData has less ad groups than adGroupIndex");
                int v4 = m00.g.a(d0.z).b;
                if(v4 != -1) {
                    b.d(d0.A < v4, "Ad group has less ads than adIndexInGroupIndex");
                }
            }
            V v5 = d0.t;
            if(v5 != null) {
                b0 b00 = (b0)v5.get(v1);
                g0 = b00.d;
                w00 = b00.b;
            }
            if(g0 == null) {
                E e0 = d0.u.m(v1, new o0(), 0L).c;
                w00.getClass();
                androidx.media3.common.c c0 = new androidx.media3.common.c();
                V v6 = w00.a;
                int v7 = v6.size();
                for(int v8 = 0; v8 < v7; ++v8) {
                    v0 v00 = (v0)v6.get(v8);
                    for(int v9 = 0; v9 < v00.a; ++v9) {
                        if(v00.e[v9]) {
                            androidx.media3.common.b b0 = v00.b.d[v9];
                            if(b0.l != null) {
                                for(int v10 = 0; true; ++v10) {
                                    Entry[] arr_metadata$Entry = b0.l.a;
                                    if(v10 >= arr_metadata$Entry.length) {
                                        break;
                                    }
                                    arr_metadata$Entry[v10].M(c0);
                                }
                            }
                        }
                    }
                }
                c0.b(e0.d);
                g0 = new G(c0);
            }
        }
        if(d0.e != null) {
            b.d(d0.d == 1, "Player error only allowed in STATE_IDLE");
        }
        Long long1 = d0.B;
        if(long1 != null) {
            if(d0.z != -1 || !d0.b || d0.d != 3 || ((long)long1) == 0x8000000000000001L) {
                h00 = new g(((long)d0.B));
            }
            else {
                float f = d0.j.a;
                h00 = new g0(((long)d0.B), SystemClock.elapsedRealtime(), f);
            }
        }
        h0 h01 = d0.D;
        this.a = d0.a;
        this.b = d0.b;
        this.c = d0.c;
        this.d = d0.d;
        this.e = d0.e;
        this.f = d0.f;
        this.g = d0.g;
        this.h = d0.h;
        this.i = d0.i;
        this.j = d0.j;
        this.k = d0.k;
        this.l = d0.l;
        this.m = d0.m;
        this.n = d0.n;
        this.o = d0.o;
        this.p = d0.p;
        this.q = d0.q;
        this.r = d0.r;
        this.s = d0.s;
        this.t = d0.u;
        w00.getClass();
        this.u = w00;
        this.v = g0;
        this.w = d0.x;
        this.x = d0.y;
        this.y = d0.z;
        this.z = d0.A;
        this.A = h00;
        this.B = h01;
        this.C = d0.E;
        this.D = d0.F;
        this.E = d0.G;
        this.F = d0.H;
    }

    public final androidx.media3.common.d a() {
        androidx.media3.common.d d0 = new androidx.media3.common.d();  // 初始化器: Ljava/lang/Object;-><init>()V
        d0.a = this.a;
        d0.b = this.b;
        d0.c = this.c;
        d0.d = this.d;
        d0.e = this.e;
        d0.f = this.f;
        d0.g = this.g;
        d0.h = this.h;
        d0.i = this.i;
        d0.j = this.j;
        d0.k = this.k;
        d0.l = this.l;
        d0.m = this.m;
        d0.n = this.n;
        d0.o = this.o;
        d0.p = this.p;
        d0.q = this.q;
        d0.r = this.r;
        d0.s = this.s;
        p0 p00 = this.t;
        d0.u = p00;
        if(p00 instanceof f0) {
            d0.t = ((f0)p00).e;
        }
        else {
            d0.v = this.u;
            d0.w = this.v;
        }
        d0.x = this.w;
        d0.y = this.x;
        d0.z = this.y;
        d0.A = this.z;
        d0.B = null;
        d0.C = this.A;
        d0.D = this.B;
        d0.E = this.C;
        d0.F = this.D;
        d0.G = this.E;
        d0.H = this.F;
        return d0;
    }

    public final V b() {
        p0 p00 = this.t;
        if(p00 instanceof f0) {
            return ((f0)p00).e;
        }
        o0 o00 = new o0();
        m0 m00 = new m0();
        int v = p00.o();
        w.c(v, "expectedSize");
        w.c(v, "initialCapacity");
        Object[] arr_object = new Object[v];
        int v1 = 0;
        int v2;
        for(v2 = 0; v1 < p00.o(); ++v2) {
            b0 b00 = b0.a(this, v1, m00, o00);
            int v3 = I6.N.f(arr_object.length, v2 + 1);
            if(v3 > arr_object.length) {
                arr_object = Arrays.copyOf(arr_object, v3);
            }
            arr_object[v2] = b00;
            ++v1;
        }
        return V.l(v2, arr_object);
    }

    // 去混淆评级： 低(33)
    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 instanceof i0) {
            i0 i00 = (i0)object0;
            return this.b == i00.b && this.c == i00.c && this.a.equals(i00.a) && this.d == i00.d && Objects.equals(this.e, i00.e) && this.f == i00.f && this.g == i00.g && this.h == i00.h && this.i == i00.i && this.j.equals(i00.j) && this.k.equals(i00.k) && this.l.equals(i00.l) && this.m == i00.m && this.n.equals(i00.n) && this.o.equals(i00.o) && this.p.equals(i00.p) && this.q == i00.q && this.r.equals(i00.r) && this.s.equals(i00.s) && this.t.equals(i00.t) && this.u.equals(i00.u) && this.v.equals(i00.v) && this.w.equals(i00.w) && this.x == i00.x && this.y == i00.y && this.z == i00.z && this.A.equals(i00.A) && this.B.equals(i00.B) && this.C.equals(i00.C) && this.D.equals(i00.D) && this.E.equals(i00.E) && this.F == i00.F;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = ((((this.a.a.hashCode() + 0xD9) * 0x1F + this.b) * 0x1F + this.c) * 0x1F + this.d) * 961;
        return this.e == null ? ((this.E.hashCode() + (this.D.hashCode() + (this.C.hashCode() + (this.B.hashCode() + (this.A.hashCode() + ((((this.w.hashCode() + (this.v.hashCode() + (this.u.a.hashCode() + (this.t.hashCode() + (this.s.hashCode() + (this.r.hashCode() + ((this.p.hashCode() + (this.o.hashCode() + (this.n.hashCode() + (Float.floatToRawIntBits(this.m) + (this.l.hashCode() + (this.k.hashCode() + (this.j.hashCode() + ((((v * 0x1F + this.f) * 0x745F + ((int)(this.g ^ this.g >>> 0x20))) * 0x1F + ((int)(this.h ^ this.h >>> 0x20))) * 0x1F + ((int)(this.i ^ this.i >>> 0x20))) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F + this.q) * 961) * 961) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F + this.x) * 0x1F + this.y) * 0x1F + this.z) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 961 + this.F) * 0x1F : ((this.E.hashCode() + (this.D.hashCode() + (this.C.hashCode() + (this.B.hashCode() + (this.A.hashCode() + ((((this.w.hashCode() + (this.v.hashCode() + (this.u.a.hashCode() + (this.t.hashCode() + (this.s.hashCode() + (this.r.hashCode() + ((this.p.hashCode() + (this.o.hashCode() + (this.n.hashCode() + (Float.floatToRawIntBits(this.m) + (this.l.hashCode() + (this.k.hashCode() + (this.j.hashCode() + (((((v + this.e.hashCode()) * 0x1F + this.f) * 0x745F + ((int)(this.g ^ this.g >>> 0x20))) * 0x1F + ((int)(this.h ^ this.h >>> 0x20))) * 0x1F + ((int)(this.i ^ this.i >>> 0x20))) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F + this.q) * 961) * 961) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F + this.x) * 0x1F + this.y) * 0x1F + this.z) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 0x1F) * 961 + this.F) * 0x1F;
    }
}

