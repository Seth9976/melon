package h4;

import B3.L;
import B3.N;
import B3.t;
import d5.l;
import e3.b;
import e3.p;
import f3.j;
import java.util.Arrays;
import java.util.Collections;

public final class n implements i {
    public final l a;
    public final p b;
    public final boolean[] c;
    public final h4.l d;
    public final x e;
    public m f;
    public long g;
    public String h;
    public L i;
    public boolean j;
    public long k;
    public static final float[] l;

    static {
        n.l = new float[]{1.0f, 1.0f, 1.090909f, 0.909091f, 1.454545f, 1.212121f, 1.0f};
    }

    public n(l l0) {
        this.a = l0;
        this.c = new boolean[4];
        h4.l l1 = new h4.l();  // 初始化器: Ljava/lang/Object;-><init>()V
        l1.e = new byte[0x80];
        this.d = l1;
        this.k = 0x8000000000000001L;
        this.e = new x(0xB2, 0);
        this.b = new p();
    }

    @Override  // h4.i
    public final void a(p p0) {
        int v17;
        float f;
        int v7;
        b.k(this.f);
        b.k(this.i);
        int v = p0.b;
        int v1 = p0.c;
        byte[] arr_b = p0.a;
        this.g += (long)p0.a();
        this.i.d(p0, p0.a(), 0);
        while(true) {
            int v2 = j.b(arr_b, v, v1, this.c);
            h4.l l0 = this.d;
            x x0 = this.e;
            if(v2 == v1) {
                if(!this.j) {
                    l0.a(arr_b, v, v1);
                }
                this.f.b(arr_b, v, v1);
                if(x0 != null) {
                    x0.c(arr_b, v, v1);
                }
                return;
            }
            int v3 = p0.a[v2 + 3];
            int v4 = v3 & 0xFF;
            int v5 = v2 - v;
            if(this.j) {
                v7 = v2 + 3;
            }
            else {
                if(v5 > 0) {
                    l0.a(arr_b, v, v2);
                }
                int v6 = l0.b;
                switch(v6) {
                    case 0: {
                        v7 = v2 + 3;
                        if(v4 == 0xB0) {
                            l0.b = 1;
                            l0.a = true;
                        }
                        break;
                    }
                    case 1: {
                        v7 = v2 + 3;
                        if(v4 == 0xB5) {
                            l0.b = 2;
                        }
                        else {
                            b.D("H263Reader", "Unexpected start code value");
                            l0.a = false;
                            l0.c = 0;
                            l0.b = 0;
                        }
                        break;
                    }
                    case 2: {
                        v7 = v2 + 3;
                        if(v4 > 0x1F) {
                            b.D("H263Reader", "Unexpected start code value");
                            l0.a = false;
                            l0.c = 0;
                            l0.b = 0;
                        }
                        else {
                            l0.b = 3;
                        }
                        break;
                    }
                    default: {
                        v7 = v2 + 3;
                        switch(v6) {
                            case 3: {
                                if((v3 & 0xF0) == 0x20) {
                                    l0.d = l0.c;
                                    l0.b = 4;
                                }
                                else {
                                    b.D("H263Reader", "Unexpected start code value");
                                    l0.a = false;
                                    l0.c = 0;
                                    l0.b = 0;
                                }
                                break;
                            }
                            case 4: {
                                if(v4 == 0xB3 || v4 == 0xB5) {
                                    l0.c -= (v5 >= 0 ? 0 : -v5);
                                    l0.a = false;
                                    L l1 = this.i;
                                    int v8 = l0.d;
                                    String s = this.h;
                                    s.getClass();
                                    byte[] arr_b1 = Arrays.copyOf(l0.e, l0.c);
                                    N n0 = new N(arr_b1, arr_b1.length, 2, 0);
                                    n0.P(v8);
                                    n0.P(4);
                                    n0.N();
                                    n0.O(8);
                                    if(n0.C()) {
                                        n0.O(4);
                                        n0.O(3);
                                    }
                                    int v9 = n0.D(4);
                                    if(v9 == 15) {
                                        int v10 = n0.D(8);
                                        int v11 = n0.D(8);
                                        if(v11 == 0) {
                                            b.D("H263Reader", "Invalid aspect ratio");
                                            goto label_66;
                                        }
                                        else {
                                            f = ((float)v10) / ((float)v11);
                                            goto label_67;
                                        }
                                        goto label_62;
                                    }
                                    else {
                                    label_62:
                                        if(v9 < 7) {
                                            f = n.l[v9];
                                            goto label_67;
                                        }
                                        else {
                                            b.D("H263Reader", "Invalid aspect ratio");
                                        }
                                    }
                                label_66:
                                    f = 1.0f;
                                label_67:
                                    if(n0.C()) {
                                        n0.O(2);
                                        n0.O(1);
                                        if(n0.C()) {
                                            n0.O(15);
                                            n0.N();
                                            n0.O(15);
                                            n0.N();
                                            n0.O(15);
                                            n0.N();
                                            n0.O(3);
                                            n0.O(11);
                                            n0.N();
                                            n0.O(15);
                                            n0.N();
                                        }
                                    }
                                    if(n0.D(2) != 0) {
                                        b.D("H263Reader", "Unhandled video object layer shape");
                                    }
                                    n0.N();
                                    int v12 = n0.D(16);
                                    n0.N();
                                    if(n0.C()) {
                                        if(v12 == 0) {
                                            b.D("H263Reader", "Invalid vop_increment_time_resolution");
                                        }
                                        else {
                                            int v13 = v12 - 1;
                                            int v14 = 0;
                                            while(v13 > 0) {
                                                ++v14;
                                                v13 >>= 1;
                                            }
                                            n0.O(v14);
                                        }
                                    }
                                    n0.N();
                                    int v15 = n0.D(13);
                                    n0.N();
                                    int v16 = n0.D(13);
                                    n0.N();
                                    n0.N();
                                    b3.n n1 = new b3.n();
                                    n1.a = s;
                                    n1.m = "video/mp4v-es";
                                    n1.t = v15;
                                    n1.u = v16;
                                    n1.x = f;
                                    n1.p = Collections.singletonList(arr_b1);
                                    l1.b(new androidx.media3.common.b(n1));
                                    this.j = true;
                                    goto label_139;
                                }
                                break;
                            }
                            default: {
                                throw new IllegalStateException();
                            }
                        }
                    }
                }
                l0.a(h4.l.f, 0, 3);
            }
        label_139:
            this.f.b(arr_b, v, v2);
            if(x0 != null) {
                if(v5 > 0) {
                    x0.c(arr_b, v, v2);
                    v17 = 0;
                }
                else {
                    v17 = -v5;
                }
                if(x0.f(v17)) {
                    int v18 = j.k(((byte[])x0.d), x0.e);
                    this.b.E(((byte[])x0.d), v18);
                    this.a.g(this.k, this.b);
                }
                if(v4 == 0xB2 && p0.a[v2 + 2] == 1) {
                    x0.i(0xB2);
                }
            }
            this.f.c(this.g - ((long)(v1 - v2)), v1 - v2, this.j);
            this.f.d = v4;
            this.f.c = false;
            this.f.a = v4 == 0xB3 || v4 == 0xB6;
            this.f.b = v4 == 0xB6;
            this.f.e = 0;
            this.f.g = this.k;
            v = v7;
        }
    }

    @Override  // h4.i
    public final void b(boolean z) {
        b.k(this.f);
        if(z) {
            this.f.c(this.g, 0, this.j);
            this.f.a = false;
            this.f.b = false;
            this.f.c = false;
            this.f.d = -1;
        }
    }

    @Override  // h4.i
    public final void d(t t0, G g0) {
        g0.c();
        g0.d();
        this.h = g0.e;
        g0.d();
        L l0 = t0.track(g0.d, 2);
        this.i = l0;
        this.f = new m(l0);
        this.a.h(t0, g0);
    }

    @Override  // h4.i
    public final void packetStarted(long v, int v1) {
        this.k = v;
    }

    @Override  // h4.i
    public final void seek() {
        j.a(this.c);
        this.d.a = false;
        this.d.c = 0;
        this.d.b = 0;
        m m0 = this.f;
        if(m0 != null) {
            m0.a = false;
            m0.b = false;
            m0.c = false;
            m0.d = -1;
        }
        x x0 = this.e;
        if(x0 != null) {
            x0.h();
        }
        this.g = 0L;
        this.k = 0x8000000000000001L;
    }
}

