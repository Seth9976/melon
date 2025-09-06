package i.n.i.b.a.s.e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public final class w4 extends S8 {
    public final a6[] j;
    public final i[] k;
    public final ArrayList l;
    public final E4 m;
    public int n;
    public long[][] o;
    public v4 r;
    public static final e w;

    static {
        w4.w = new e("MergingMediaSource", new b(0x8000000000000000L), null, new c(0x8000000000000001L, 0x8000000000000001L, 0x8000000000000001L, -3.402823E+38f, -3.402823E+38f), M.e);
    }

    public w4(a6[] arr_a6) {
        E4 e40 = new E4(14);
        super();
        this.j = arr_a6;
        this.m = e40;
        this.l = new ArrayList(Arrays.asList(arr_a6));
        this.n = -1;
        this.k = new i[arr_a6.length];
        this.o = new long[0][];
        new HashMap();
        Ja.x(8, "expectedKeys");
        Ja.x(2, "expectedValuesPerKey");
        b5 b50 = b5.g();
        new T0();
        if(!b50.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final e a() {
        return this.j.length <= 0 ? w4.w : this.j[0].a();
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final v0 b(e2 e20, L3 l30, long v) {
        a6[] arr_a6 = this.j;
        v0[] arr_v0 = new v0[arr_a6.length];
        i[] arr_i = this.k;
        int v2 = arr_i[0].d(e20.a);
        for(int v1 = 0; v1 < arr_a6.length; ++v1) {
            e2 e21 = e20.b(arr_i[v1].o(v2));
            arr_v0[v1] = arr_a6[v1].b(e21, l30, v - this.o[v2][v1]);
        }
        return new f4(this.m, this.o[v2], arr_v0);
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final void d(g0 g00) {
        this.i = g00;
        this.h = L7.j(null);
        for(int v = 0; true; ++v) {
            a6[] arr_a6 = this.j;
            if(v >= arr_a6.length) {
                break;
            }
            this.u(v, arr_a6[v]);
        }
    }

    @Override  // i.n.i.b.a.s.e.a6
    public final void e(v0 v00) {
        for(int v = 0; true; ++v) {
            a6[] arr_a6 = this.j;
            if(v >= arr_a6.length) {
                break;
            }
            a6 a60 = arr_a6[v];
            v0 v01 = ((f4)v00).a[v];
            if(v01 instanceof d4) {
                v01 = ((d4)v01).a;
            }
            a60.e(v01);
        }
    }

    @Override  // i.n.i.b.a.s.e.S8
    public final void l() {
        v4 v40 = this.r;
        if(v40 != null) {
            throw v40;
        }
        super.l();
    }

    @Override  // i.n.i.b.a.s.e.S8
    public final void s() {
        super.s();
        Arrays.fill(this.k, null);
        this.n = -1;
        this.r = null;
        this.l.clear();
        Collections.addAll(this.l, this.j);
    }

    @Override  // i.n.i.b.a.s.e.S8
    public final e2 t(Object object0, e2 e20) {
        return ((int)(((Integer)object0))) == 0 ? e20 : null;
    }

    @Override  // i.n.i.b.a.s.e.S8
    public final void v(Object object0, a6 a60, i i0) {
        if(this.r == null) {
            if(this.n == -1) {
                this.n = i0.a();
            }
            else if(i0.a() != this.n) {
                this.r = new v4();  // 初始化器: Ljava/io/IOException;-><init>()V
                return;
            }
            i[] arr_i = this.k;
            if(this.o.length == 0) {
                this.o = new long[this.n][arr_i.length];
            }
            this.l.remove(a60);
            arr_i[((int)(((Integer)object0)))] = i0;
            if(this.l.isEmpty()) {
                this.c(arr_i[0]);
            }
        }
    }
}

