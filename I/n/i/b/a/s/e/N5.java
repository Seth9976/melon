package i.n.i.b.a.s.e;

import android.util.Pair;
import ea.b;
import h4.G;
import h4.x;
import java.util.Arrays;
import java.util.Collections;

public final class n5 implements M4 {
    public String a;
    public ie b;
    public final b c;
    public final wb d;
    public final x e;
    public final boolean[] f;
    public final m5 g;
    public long h;
    public boolean i;
    public boolean j;
    public long k;
    public long l;
    public long m;
    public long n;
    public boolean o;
    public boolean p;
    public static final double[] q;

    static {
        n5.q = new double[]{23.976024, 24.0, 25.0, 29.97003, 30.0, 50.0, 59.94006, 60.0};
    }

    public n5(b b0) {
        this.c = b0;
        this.f = new boolean[4];
        m5 m50 = new m5();  // 初始化器: Ljava/lang/Object;-><init>()V
        m50.d = new byte[0x80];
        this.g = m50;
        if(b0 != null) {
            this.e = new x(0xB2, 1);
            this.d = new wb(1, false);
            return;
        }
        this.e = null;
        this.d = null;
    }

    @Override  // i.n.i.b.a.s.e.M4
    public final void a() {
        Ja.D(this.f);
        this.g.a = false;
        this.g.b = 0;
        this.g.c = 0;
        x x0 = this.e;
        if(x0 != null) {
            x0.d();
        }
        this.h = 0L;
        this.i = false;
    }

    @Override  // i.n.i.b.a.s.e.M4
    public final void b() {
    }

    @Override  // i.n.i.b.a.s.e.M4
    public final void c(wb wb0) {
        long v17;
        int v13;
        long v12;
        float f;
        x x0;
        m5 m50;
        M7.G(this.b);
        int v = wb0.b;
        int v1 = wb0.c;
        byte[] arr_b = wb0.a;
        this.h += (long)wb0.d();
        this.b.b(wb0.d(), wb0);
        while(true) {
            int v2 = Ja.g(arr_b, v, v1, this.f);
            m50 = this.g;
            x0 = this.e;
            if(v2 == v1) {
                break;
            }
            int v3 = wb0.a[v2 + 3] & 0xFF;
            int v4 = v2 - v;
            if(!this.j) {
                if(v4 > 0) {
                    m50.a(arr_b, v, v2);
                }
                if(m50.a) {
                    int v5 = m50.b - (v4 >= 0 ? 0 : -v4);
                    m50.b = v5;
                    if(m50.c != 0 || v3 != 0xB5) {
                        m50.a = false;
                        String s = this.a;
                        s.getClass();
                        byte[] arr_b1 = Arrays.copyOf(m50.d, m50.b);
                        int v6 = (arr_b1[4] & 0xFF) << 4 | (arr_b1[5] & 0xFF) >> 4;
                        int v7 = arr_b1[6] & 0xFF | (arr_b1[5] & 15) << 8;
                        switch((arr_b1[7] & 0xF0) >> 4) {
                            case 2: {
                                f = ((float)(v7 * 4)) / ((float)(v6 * 3));
                                break;
                            }
                            case 3: {
                                f = ((float)(v7 * 16)) / ((float)(v6 * 9));
                                break;
                            }
                            case 4: {
                                f = ((float)(v7 * 0x79)) / ((float)(v6 * 100));
                                break;
                            }
                            default: {
                                f = 1.0f;
                            }
                        }
                        ob ob0 = new ob();
                        ob0.a = s;
                        ob0.k = "video/mpeg2";
                        ob0.p = v6;
                        ob0.q = v7;
                        ob0.t = f;
                        ob0.m = Collections.singletonList(arr_b1);
                        u u0 = new u(ob0);
                        int v8 = (arr_b1[7] & 15) - 1;
                        if(v8 < 0 || v8 >= 8) {
                            v12 = 0L;
                        }
                        else {
                            double f1 = n5.q[v8];
                            int v9 = arr_b1[m50.c + 9];
                            int v10 = (v9 & 0x60) >> 5;
                            int v11 = v9 & 0x1F;
                            if(v10 != v11) {
                                f1 *= (((double)v10) + 1.0) / ((double)(v11 + 1));
                            }
                            v12 = (long)(1000000.0 / f1);
                        }
                        Pair pair0 = Pair.create(u0, v12);
                        this.b.a(((u)pair0.first));
                        this.k = (long)(((Long)pair0.second));
                        this.j = true;
                        goto label_62;
                    }
                    else {
                        m50.c = v5;
                        goto label_61;
                    }
                    goto label_59;
                }
                else {
                label_59:
                    if(v3 == 0xB3) {
                        m50.a = true;
                    }
                }
            label_61:
                m50.a(m5.e, 0, 3);
            }
        label_62:
            if(x0 != null) {
                if(v4 > 0) {
                    x0.a(arr_b, v, v2);
                    v13 = 0;
                }
                else {
                    v13 = -v4;
                }
                if(x0.b(v13)) {
                    int v14 = Ja.V(x0.e, ((byte[])x0.d));
                    this.d.i(v14, ((byte[])x0.d));
                    this.c.e(this.n, this.d);
                }
                if(v3 == 0xB2 && wb0.a[v2 + 2] == 1) {
                    x0.e(0xB2);
                }
            }
            switch(v3) {
                case 0: 
                case 0xB3: {
                    int v15 = v1 - v2;
                    if(this.i && this.p && this.j) {
                        this.b.f(this.n, ((int)this.o), ((int)(this.h - this.m)) - v15, v15, null);
                    }
                    boolean z = this.i;
                    if(!z || this.p) {
                        this.m = this.h - ((long)v15);
                        long v16 = this.l;
                        if(v16 == 0x8000000000000001L) {
                            v17 = z ? this.n + this.k : 0L;
                        }
                        else {
                            v17 = v16;
                        }
                        this.n = v17;
                        this.o = false;
                        this.l = 0x8000000000000001L;
                        this.i = true;
                    }
                    this.p = v3 == 0;
                    break;
                }
                case 0xB8: {
                    this.o = true;
                }
            }
            v = v2 + 3;
        }
        if(!this.j) {
            m50.a(arr_b, v, v1);
        }
        if(x0 != null) {
            x0.a(arr_b, v, v1);
        }
    }

    @Override  // i.n.i.b.a.s.e.M4
    public final void e(U5 u50, G g0) {
        g0.a();
        g0.b();
        this.a = g0.e;
        g0.b();
        this.b = u50.i(g0.d, 2);
        b b0 = this.c;
        if(b0 != null) {
            b0.f(u50, g0);
        }
    }

    @Override  // i.n.i.b.a.s.e.M4
    public final void k(long v, int v1) {
        this.l = v;
    }
}

