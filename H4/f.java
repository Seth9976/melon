package h4;

import B3.L;
import B3.N;
import B3.a;
import B3.t;
import b3.n;
import e3.b;
import e3.p;
import java.util.Arrays;
import java.util.Collections;

public final class f implements i {
    public final boolean a;
    public final N b;
    public final p c;
    public final String d;
    public final int e;
    public String f;
    public L g;
    public L h;
    public int i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public long r;
    public int s;
    public long t;
    public L u;
    public long v;
    public static final byte[] w;

    static {
        f.w = new byte[]{73, 68, 51};
    }

    public f(boolean z, String s, int v) {
        this.b = new N(new byte[7], 7, 2, 0);
        this.c = new p(Arrays.copyOf(f.w, 10));
        this.i = 0;
        this.j = 0;
        this.k = 0x100;
        this.n = -1;
        this.o = -1;
        this.r = 0x8000000000000001L;
        this.t = 0x8000000000000001L;
        this.a = z;
        this.d = s;
        this.e = v;
    }

    @Override  // h4.i
    public final void a(p p0) {
        this.g.getClass();
    label_1:
        while(p0.a() > 0) {
            p p1 = this.c;
            N n0 = this.b;
            int v = 1;
            switch(this.i) {
                case 0: {
                    byte[] arr_b = p0.a;
                    int v1 = p0.b;
                    int v2 = p0.c;
                    while(v1 < v2) {
                        int v3 = arr_b[v1];
                        int v4 = v3 & 0xFF;
                        if(this.k == 0x200 && ((0xFF00 | ((byte)v4) & 0xFF) & 0xFFF6) == 0xFFF0) {
                            if(this.m) {
                            label_46:
                                this.p = (v3 & 8) >> 3;
                                this.l = (v3 & 1) == 0;
                                this.i = this.m ? 3 : 1;
                                this.j = 0;
                                p0.G(v1 + 1);
                                continue label_1;
                            }
                            else {
                                p0.G(v1);
                                byte[] arr_b1 = n0.d;
                                if(p0.a() >= 1) {
                                    p0.e(arr_b1, 0, 1);
                                    n0.L(4);
                                    int v5 = n0.D(1);
                                    if(this.n == -1 || v5 == this.n) {
                                        if(this.o == -1) {
                                        label_29:
                                            byte[] arr_b3 = n0.d;
                                            if(p0.a() >= 4) {
                                                p0.e(arr_b3, 0, 4);
                                                n0.L(14);
                                                int v6 = n0.D(13);
                                                if(v6 >= 7) {
                                                    byte[] arr_b4 = p0.a;
                                                    int v7 = p0.c;
                                                    int v8 = v1 - 1 + v6;
                                                    if(v8 < v7) {
                                                        int v9 = arr_b4[v8];
                                                        if(v9 != -1) {
                                                            if(v9 == 73 && (v8 + 1 == v7 || arr_b4[v8 + 1] == 68 && (v8 + 2 == v7 || arr_b4[v8 + 2] == 51))) {
                                                                goto label_46;
                                                            }
                                                        }
                                                        else if(v8 + 1 != v7) {
                                                            int v10 = arr_b4[v8 + 1];
                                                            if(((0xFF00 | v10 & 0xFF) & 0xFFF6) == 0xFFF0 && (v10 & 8) >> 3 == v5) {
                                                                goto label_46;
                                                            }
                                                        }
                                                        else {
                                                            goto label_46;
                                                        }
                                                    }
                                                    else {
                                                        goto label_46;
                                                    }
                                                }
                                            }
                                            else {
                                                goto label_46;
                                            }
                                        }
                                        else {
                                            byte[] arr_b2 = n0.d;
                                            if(p0.a() >= 1) {
                                                p0.e(arr_b2, 0, 1);
                                                n0.L(2);
                                                if(n0.D(4) == this.o) {
                                                    p0.G(v1 + 1);
                                                    goto label_29;
                                                }
                                            }
                                            else {
                                                goto label_46;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        int v11 = this.k;
                        switch(v4 | v11) {
                            case 329: {
                                this.k = 0x300;
                                ++v1;
                                continue;
                            }
                            case 0x1FF: {
                                this.k = 0x200;
                                ++v1;
                                continue;
                            }
                            case 836: {
                                this.k = 0x400;
                                ++v1;
                                continue;
                            }
                            case 1075: {
                                break;
                            }
                            default: {
                                if(v11 != 0x100) {
                                    this.k = 0x100;
                                    continue;
                                }
                                ++v1;
                                continue;
                            }
                        }
                        this.i = 2;
                        this.j = 3;
                        this.s = 0;
                        p1.G(0);
                        p0.G(v1 + 1);
                        continue label_1;
                    }
                    p0.G(v1);
                    continue;
                }
                case 1: {
                    if(p0.a() == 0) {
                        continue;
                    }
                    n0.d[0] = p0.a[p0.b];
                    n0.L(2);
                    int v12 = n0.D(4);
                    if(this.o == -1 || v12 == this.o) {
                        if(!this.m) {
                            this.m = true;
                            this.n = this.p;
                            this.o = v12;
                        }
                        this.i = 3;
                        this.j = 0;
                    }
                    else {
                        this.m = false;
                        this.i = 0;
                        this.j = 0;
                        this.k = 0x100;
                    }
                    continue;
                }
                case 2: {
                    int v13 = Math.min(p0.a(), 10 - this.j);
                    p0.e(p1.a, this.j, v13);
                    int v14 = this.j + v13;
                    this.j = v14;
                    if(v14 != 10) {
                        continue;
                    }
                    this.h.d(p1, 10, 0);
                    p1.G(6);
                    L l0 = this.h;
                    int v15 = p1.t();
                    this.i = 4;
                    this.j = 10;
                    this.u = l0;
                    this.v = 0L;
                    this.s = v15 + 10;
                    continue;
                }
                case 3: {
                    int v16 = this.l ? 7 : 5;
                    int v17 = Math.min(p0.a(), v16 - this.j);
                    p0.e(n0.d, this.j, v17);
                    int v18 = this.j + v17;
                    this.j = v18;
                    if(v18 != v16) {
                        continue;
                    }
                    n0.L(0);
                    if(this.q) {
                        n0.O(10);
                    }
                    else {
                        int v19 = n0.D(2) + 1;
                        if(v19 != 2) {
                            b.D("AdtsReader", "Detected audio object type: " + v19 + ", but assuming AAC LC.");
                        }
                        n0.O(5);
                        byte b = (byte)(n0.D(3) << 3 & 120 | this.o << 7 & 0x80);
                        byte[] arr_b5 = {((byte)(16 | this.o >> 1 & 7)), b};
                        a a0 = B3.b.m(new N(arr_b5, 2, 2, 0), false);
                        n n1 = new n();
                        n1.a = this.f;
                        n1.m = "audio/mp4a-latm";
                        n1.j = a0.a;
                        n1.B = a0.c;
                        n1.C = a0.b;
                        n1.p = Collections.singletonList(arr_b5);
                        n1.d = this.d;
                        n1.f = this.e;
                        androidx.media3.common.b b1 = new androidx.media3.common.b(n1);
                        this.r = 1024000000L / ((long)b1.D);
                        this.g.b(b1);
                        this.q = true;
                    }
                    n0.O(4);
                    int v20 = n0.D(13);
                    this.i = 4;
                    this.j = 0;
                    this.u = this.g;
                    this.v = this.r;
                    this.s = this.l ? v20 - 9 : v20 - 7;
                    continue;
                }
                case 4: {
                    int v21 = Math.min(p0.a(), this.s - this.j);
                    this.u.d(p0, v21, 0);
                    int v22 = this.j + v21;
                    this.j = v22;
                    if(v22 != this.s) {
                        continue;
                    }
                    if(this.t == 0x8000000000000001L) {
                        v = 0;
                    }
                    break;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
            b.j(((boolean)v));
            this.u.c(this.t, 1, this.s, 0, null);
            this.t += this.v;
            this.i = 0;
            this.j = 0;
            this.k = 0x100;
        }
    }

    @Override  // h4.i
    public final void b(boolean z) {
    }

    @Override  // h4.i
    public final void d(t t0, G g0) {
        g0.c();
        g0.d();
        this.f = g0.e;
        g0.d();
        L l0 = t0.track(g0.d, 1);
        this.g = l0;
        this.u = l0;
        if(this.a) {
            g0.c();
            g0.d();
            L l1 = t0.track(g0.d, 5);
            this.h = l1;
            n n0 = new n();
            g0.d();
            n0.a = g0.e;
            n0.m = "application/id3";
            l1.b(new androidx.media3.common.b(n0));
            return;
        }
        this.h = new B3.p();
    }

    @Override  // h4.i
    public final void packetStarted(long v, int v1) {
        this.t = v;
    }

    @Override  // h4.i
    public final void seek() {
        this.t = 0x8000000000000001L;
        this.m = false;
        this.i = 0;
        this.j = 0;
        this.k = 0x100;
    }
}

