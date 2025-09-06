package g3;

import B3.L;
import B3.s;
import B3.t;
import V3.d;
import b3.H;
import b3.I;
import b3.n;
import e3.x;
import i.n.i.b.a.s.e.H4;
import i.n.i.b.a.s.e.L7;
import i.n.i.b.a.s.e.N4;
import i.n.i.b.a.s.e.U5;
import i.n.i.b.a.s.e.Z3;
import i.n.i.b.a.s.e.i5;
import i.n.i.b.a.s.e.ie;
import i.n.i.b.a.s.e.ob;
import i.n.i.b.a.s.e.s3;
import i.n.i.b.a.s.e.u;
import i4.b;
import java.math.RoundingMode;

public final class i implements s3, b {
    public int a;
    public long b;
    public int c;
    public long d;
    public Object e;
    public Object f;
    public Object g;
    public Object h;

    public i(t t0, L l0, d d0, String s, int v) {
        this.e = t0;
        this.f = l0;
        this.g = d0;
        int v1 = d0.b;
        int v2 = d0.c;
        int v3 = d0.e * v1 / 8;
        int v4 = d0.d;
        if(v4 != v3) {
            throw I.a(null, "Expected block size: " + v3 + "; got: " + v4);
        }
        int v5 = v2 * v3;
        int v6 = Math.max(v3, v5 / 10);
        this.a = v6;
        n n0 = new n();
        n0.m = H.l(s);
        n0.h = v5 * 8;
        n0.i = v5 * 8;
        n0.n = v6;
        n0.B = v1;
        n0.C = v2;
        n0.D = v;
        this.h = new androidx.media3.common.b(n0);
    }

    public i(U5 u50, ie ie0, Z3 z30, String s, int v) {
        this.e = u50;
        this.f = ie0;
        this.g = z30;
        int v1 = z30.b;
        int v2 = z30.c;
        int v3 = z30.e * v1 / 8;
        int v4 = z30.d;
        if(v4 != v3) {
            throw new H4("Expected block size: " + v3 + "; got: " + v4);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        int v5 = v2 * v3;
        int v6 = Math.max(v3, v5 / 10);
        this.a = v6;
        ob ob0 = new ob();
        ob0.k = s;
        ob0.f = v5 * 8;
        ob0.g = v5 * 8;
        ob0.l = v6;
        ob0.x = v1;
        ob0.y = v2;
        ob0.z = v;
        this.h = new u(ob0);
    }

    @Override  // i.n.i.b.a.s.e.s3
    public void a(long v) {
        this.b = v;
        this.c = 0;
        this.d = 0L;
    }

    @Override  // i4.b
    public boolean a(s s0, long v) {
        int v1;
        while((v1 = Long.compare(v, 0L)) > 0) {
            int v2 = this.c;
            int v3 = this.a;
            if(v2 >= v3) {
                break;
            }
            int v4 = ((L)this.f).a(s0, ((int)Math.min(v3 - v2, v)), true);
            if(v4 == -1) {
                v = 0L;
            }
            else {
                this.c += v4;
                v -= (long)v4;
            }
        }
        d d0 = (d)this.g;
        int v5 = d0.d;
        int v6 = this.c / v5;
        if(v6 > 0) {
            long v7 = this.b;
            long v8 = x.T(this.d, 1000000L, d0.c, RoundingMode.DOWN);
            int v9 = v6 * v5;
            int v10 = this.c - v9;
            ((L)this.f).c(v7 + v8, 1, v9, v10, null);
            this.d += (long)v6;
            this.c = v10;
        }
        return v1 <= 0;
    }

    @Override  // i.n.i.b.a.s.e.s3
    public boolean b(i5 i50, long v) {
        int v1;
        while((v1 = Long.compare(v, 0L)) > 0) {
            int v2 = this.c;
            int v3 = this.a;
            if(v2 >= v3) {
                break;
            }
            int v4 = ((ie)this.f).e(i50, ((int)Math.min(v3 - v2, v)), true);
            if(v4 == -1) {
                v = 0L;
            }
            else {
                this.c += v4;
                v -= (long)v4;
            }
        }
        Z3 z30 = (Z3)this.g;
        int v5 = z30.d;
        int v6 = this.c / v5;
        if(v6 > 0) {
            long v7 = this.b;
            long v8 = L7.C(this.d, 1000000L, z30.c);
            int v9 = v6 * v5;
            int v10 = this.c - v9;
            ((ie)this.f).f(v7 + v8, 1, v9, v10, null);
            this.d += (long)v6;
            this.c = v10;
        }
        return v1 <= 0;
    }

    @Override  // i.n.i.b.a.s.e.s3
    public void c(int v, long v1) {
        ((U5)this.e).t(new N4(((Z3)this.g), 1, ((long)v), v1));
        ((ie)this.f).a(((u)this.h));
    }

    @Override  // i4.b
    public void init(int v, long v1) {
        ((t)this.e).n(new i4.d(((d)this.g), 1, ((long)v), v1));
        ((L)this.f).b(((androidx.media3.common.b)this.h));
    }

    @Override  // i4.b
    public void reset(long v) {
        this.b = v;
        this.c = 0;
        this.d = 0L;
    }
}

