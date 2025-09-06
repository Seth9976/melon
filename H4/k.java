package h4;

import B3.L;
import B3.t;
import android.util.Pair;
import b3.n;
import d5.l;
import e3.b;
import e3.p;
import java.util.Arrays;
import java.util.Collections;

public final class k implements i {
    public String a;
    public L b;
    public final l c;
    public final p d;
    public final x e;
    public final boolean[] f;
    public final j g;
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
        k.q = new double[]{23.976024, 24.0, 25.0, 29.97003, 30.0, 50.0, 59.94006, 60.0};
    }

    public k(l l0) {
        this.c = l0;
        this.f = new boolean[4];
        j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j0.d = new byte[0x80];
        this.g = j0;
        if(l0 == null) {
            this.e = null;
            this.d = null;
        }
        else {
            this.e = new x(0xB2, 0);
            this.d = new p();
        }
        this.l = 0x8000000000000001L;
        this.n = 0x8000000000000001L;
    }

    @Override  // h4.i
    public final void a(p p0) {
        int v13;
        long v12;
        float f;
        x x0;
        j j0;
        b.k(this.b);
        int v = p0.b;
        int v1 = p0.c;
        byte[] arr_b = p0.a;
        this.h += (long)p0.a();
        this.b.d(p0, p0.a(), 0);
        while(true) {
            int v2 = f3.j.b(arr_b, v, v1, this.f);
            j0 = this.g;
            x0 = this.e;
            if(v2 == v1) {
                break;
            }
            int v3 = p0.a[v2 + 3] & 0xFF;
            int v4 = v2 - v;
            if(!this.j) {
                if(v4 > 0) {
                    j0.a(arr_b, v, v2);
                }
                if(j0.a) {
                    int v5 = j0.b - (v4 >= 0 ? 0 : -v4);
                    j0.b = v5;
                    if(j0.c != 0 || v3 != 0xB5) {
                        j0.a = false;
                        String s = this.a;
                        s.getClass();
                        byte[] arr_b1 = Arrays.copyOf(j0.d, j0.b);
                        int v6 = (arr_b1[5] & 0xFF) >> 4 | (arr_b1[4] & 0xFF) << 4;
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
                        n n0 = new n();
                        n0.a = s;
                        n0.m = "video/mpeg2";
                        n0.t = v6;
                        n0.u = v7;
                        n0.x = f;
                        n0.p = Collections.singletonList(arr_b1);
                        androidx.media3.common.b b0 = new androidx.media3.common.b(n0);
                        int v8 = (arr_b1[7] & 15) - 1;
                        if(v8 < 0 || v8 >= 8) {
                            v12 = 0L;
                        }
                        else {
                            double f1 = k.q[v8];
                            int v9 = arr_b1[j0.c + 9];
                            int v10 = (v9 & 0x60) >> 5;
                            int v11 = v9 & 0x1F;
                            if(v10 != v11) {
                                f1 *= (((double)v10) + 1.0) / ((double)(v11 + 1));
                            }
                            v12 = (long)(1000000.0 / f1);
                        }
                        Pair pair0 = Pair.create(b0, v12);
                        this.b.b(((androidx.media3.common.b)pair0.first));
                        this.k = (long)(((Long)pair0.second));
                        this.j = true;
                        goto label_62;
                    }
                    else {
                        j0.c = v5;
                        goto label_61;
                    }
                    goto label_59;
                }
                else {
                label_59:
                    if(v3 == 0xB3) {
                        j0.a = true;
                    }
                }
            label_61:
                j0.a(j.e, 0, 3);
            }
        label_62:
            if(x0 != null) {
                if(v4 > 0) {
                    x0.c(arr_b, v, v2);
                    v13 = 0;
                }
                else {
                    v13 = -v4;
                }
                if(x0.f(v13)) {
                    int v14 = f3.j.k(((byte[])x0.d), x0.e);
                    this.d.E(((byte[])x0.d), v14);
                    this.c.g(this.n, this.d);
                }
                if(v3 == 0xB2 && p0.a[v2 + 2] == 1) {
                    x0.i(0xB2);
                }
            }
            switch(v3) {
                case 0: 
                case 0xB3: {
                    int v15 = v1 - v2;
                    if(this.p && this.j) {
                        long v16 = this.n;
                        if(v16 != 0x8000000000000001L) {
                            this.b.c(v16, ((int)this.o), ((int)(this.h - this.m)) - v15, v15, null);
                        }
                    }
                    if(!this.i || this.p) {
                        this.m = this.h - ((long)v15);
                        long v17 = this.l;
                        if(v17 == 0x8000000000000001L) {
                            v17 = this.n == 0x8000000000000001L ? 0x8000000000000001L : this.n + this.k;
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
            j0.a(arr_b, v, v1);
        }
        if(x0 != null) {
            x0.c(arr_b, v, v1);
        }
    }

    @Override  // h4.i
    public final void b(boolean z) {
        b.k(this.b);
        if(z) {
            this.b.c(this.n, ((int)this.o), ((int)(this.h - this.m)), 0, null);
        }
    }

    @Override  // h4.i
    public final void d(t t0, G g0) {
        g0.c();
        g0.d();
        this.a = g0.e;
        g0.d();
        this.b = t0.track(g0.d, 2);
        l l0 = this.c;
        if(l0 != null) {
            l0.h(t0, g0);
        }
    }

    @Override  // h4.i
    public final void packetStarted(long v, int v1) {
        this.l = v;
    }

    @Override  // h4.i
    public final void seek() {
        f3.j.a(this.f);
        this.g.a = false;
        this.g.b = 0;
        this.g.c = 0;
        x x0 = this.e;
        if(x0 != null) {
            x0.h();
        }
        this.h = 0L;
        this.i = false;
        this.l = 0x8000000000000001L;
        this.n = 0x8000000000000001L;
    }
}

