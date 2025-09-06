package h4;

import B3.L;
import B3.N;
import B3.t;
import androidx.media3.common.b;
import b3.H;
import b3.I;
import b3.n;
import e3.p;
import e3.x;
import java.math.RoundingMode;
import java.util.concurrent.atomic.AtomicInteger;
import ye.a;

public final class g implements i {
    public final p a;
    public final AtomicInteger b;
    public final String c;
    public final int d;
    public String e;
    public L f;
    public int g;
    public int h;
    public int i;
    public long j;
    public b k;
    public int l;
    public int m;
    public int n;
    public int o;
    public long p;

    public g(String s, int v, int v1) {
        this.a = new p(new byte[v1]);
        this.g = 0;
        this.p = 0x8000000000000001L;
        this.b = new AtomicInteger();
        this.n = -1;
        this.o = -1;
        this.c = s;
        this.d = v;
    }

    // This method was un-flattened
    @Override  // h4.i
    public final void a(p p0) {
        int v49;
        long v48;
        int v46;
        int v43;
        long v30;
        int v29;
        int v28;
        int v27;
        int v20;
        int v19;
        int v17;
        int v16;
        int v13;
        int v12;
        int v14;
        int v10;
        int v9;
        int v11;
        int v2;
        e3.b.k(this.f);
        while(p0.a() > 0) {
            p p1 = this.a;
            switch(this.g) {
                case 0: {
                    while(p0.a() > 0) {
                        int v = this.i << 8;
                        this.i = v;
                        int v1 = v | p0.u();
                        this.i = v1;
                        switch(v1) {
                            case 0xF21B4140: 
                            case 1078008818: {
                                v2 = 3;
                                this.m = 3;
                                goto label_24;
                            }
                            case 0x25205864: 
                            case 0x64582025: {
                                v2 = 2;
                                this.m = 2;
                                goto label_24;
                            }
                            case 0xE842C471: 
                            case 1908687592: {
                                v2 = 4;
                                this.m = 4;
                                goto label_24;
                            }
                            case 0xFE7F0180: 
                            case 0xFF1F00E8: 
                            case 0x1FFFE800: 
                            case 0x7FFE8001: {
                                break;
                            }
                            default: {
                                this.m = 0;
                                continue;
                            }
                        }
                        v2 = 1;
                        this.m = 1;
                    label_24:
                        byte[] arr_b = p1.a;
                        arr_b[0] = (byte)(v1 >> 24 & 0xFF);
                        arr_b[1] = (byte)(v1 >> 16 & 0xFF);
                        arr_b[2] = (byte)(v1 >> 8 & 0xFF);
                        arr_b[3] = (byte)(v1 & 0xFF);
                        this.h = 4;
                        this.i = 0;
                        if(v2 == 3 || v2 == 4) {
                            this.g = 4;
                        }
                        else if(v2 == 1) {
                            this.g = 1;
                        }
                        else {
                            this.g = 2;
                        }
                        break;
                    }
                    continue;
                }
                case 1: {
                    if(!this.c(p0, p1.a, 18)) {
                        continue;
                    }
                    byte[] arr_b1 = p1.a;
                    if(this.k == null) {
                        String s = this.e;
                        N n0 = B3.b.i(arr_b1);
                        n0.O(60);
                        int v3 = B3.b.j[n0.D(6)];
                        int v4 = B3.b.k[n0.D(4)];
                        int v5 = n0.D(5);
                        int v6 = v5 < 29 ? B3.b.l[v5] * 1000 / 2 : -1;
                        n0.O(10);
                        int v7 = n0.D(2) <= 0 ? 0 : 1;
                        n n1 = new n();
                        n1.a = s;
                        n1.m = "audio/vnd.dts";
                        n1.h = v6;
                        n1.B = v3 + v7;
                        n1.C = v4;
                        n1.q = null;
                        n1.d = this.c;
                        n1.f = this.d;
                        b b0 = new b(n1);
                        this.k = b0;
                        this.f.b(b0);
                    }
                    int v8 = arr_b1[0];
                    if(v8 == -2) {
                        v9 = (arr_b1[4] & 3) << 12 | (arr_b1[7] & 0xFF) << 4;
                        v10 = arr_b1[6];
                    }
                    else {
                        switch(v8) {
                            case -1: {
                                v11 = (((arr_b1[7] & 3) << 12 | (arr_b1[6] & 0xFF) << 4 | (arr_b1[9] & 60) >> 2) + 1) * 16 / 14;
                                goto label_77;
                            }
                            case 0x1F: {
                                v11 = (((arr_b1[6] & 3) << 12 | (arr_b1[7] & 0xFF) << 4 | (arr_b1[8] & 60) >> 2) + 1) * 16 / 14;
                                goto label_77;
                            }
                            default: {
                                v9 = (arr_b1[5] & 3) << 12 | (arr_b1[6] & 0xFF) << 4;
                                v10 = arr_b1[7];
                            }
                        }
                    }
                    v11 = (v9 | (v10 & 0xF0) >> 4) + 1;
                label_77:
                    this.l = v11;
                    if(v8 == -2) {
                        v12 = (arr_b1[5] & 1) << 6;
                        v13 = arr_b1[4];
                    }
                    else {
                        switch(v8) {
                            case -1: {
                                v12 = (arr_b1[4] & 7) << 4;
                                v14 = arr_b1[7] & 60;
                                goto label_92;
                            }
                            case 0x1F: {
                                v12 = (arr_b1[5] & 7) << 4;
                                v14 = arr_b1[6] & 60;
                                goto label_92;
                            }
                            default: {
                                v12 = (arr_b1[4] & 1) << 6;
                                v13 = arr_b1[5];
                            }
                        }
                    }
                    v14 = v13 & 0xFC;
                label_92:
                    this.j = (long)a.t(x.R(this.k.D, ((long)(((v14 >> 2 | v12) + 1) * 0x20))));
                    p1.G(0);
                    this.f.d(p1, 18, 0);
                    this.g = 6;
                    continue;
                }
                case 2: {
                    if(!this.c(p0, p1.a, 7)) {
                        continue;
                    }
                    N n2 = B3.b.i(p1.a);
                    n2.O(42);
                    this.n = n2.D((n2.C() ? 12 : 8)) + 1;
                    this.g = 3;
                    continue;
                }
                case 3: {
                    if(!this.c(p0, p1.a, this.n)) {
                        continue;
                    }
                    N n3 = B3.b.i(p1.a);
                    n3.O(40);
                    int v15 = n3.D(2);
                    if(n3.C()) {
                        v16 = 20;
                        v17 = 12;
                    }
                    else {
                        v16 = 16;
                        v17 = 8;
                    }
                    n3.O(v17);
                    int v18 = n3.D(v16);
                    boolean z = n3.C();
                    if(z) {
                        v19 = n3.D(2);
                        v20 = (n3.D(3) + 1) * 0x200;
                        if(n3.C()) {
                            n3.O(36);
                        }
                        if(n3.D(3) + 1 != 1 || n3.D(3) + 1 != 1) {
                            throw I.c("Multiple audio presentations or assets not supported");
                        }
                        int v21 = v15 + 1;
                        int v22 = n3.D(v21);
                        for(int v23 = 0; v23 < v21; ++v23) {
                            if((v22 >> v23 & 1) == 1) {
                                n3.O(8);
                            }
                        }
                        if(n3.C()) {
                            n3.O(2);
                            int v24 = n3.D(2) + 1 << 2;
                            int v25 = n3.D(2);
                            for(int v26 = 0; v26 < v25 + 1; ++v26) {
                                n3.O(v24);
                            }
                        }
                    }
                    else {
                        v19 = -1;
                        v20 = 0;
                    }
                    n3.O(v16);
                    n3.O(12);
                    if(z) {
                        if(n3.C()) {
                            n3.O(4);
                        }
                        if(n3.C()) {
                            n3.O(24);
                        }
                        if(n3.C()) {
                            n3.P(n3.D(10) + 1);
                        }
                        n3.O(5);
                        v27 = B3.b.m[n3.D(4)];
                        v28 = n3.D(8) + 1;
                    }
                    else {
                        v28 = -1;
                        v27 = 0x80000001;
                    }
                    if(z) {
                        switch(v19) {
                            case 0: {
                                v29 = 32000;
                                break;
                            }
                            case 1: {
                                v29 = 44100;
                                break;
                            }
                            case 2: {
                                v29 = 48000;
                                break;
                            }
                            default: {
                                throw I.a(null, "Unsupported reference clock code in DTS HD header: " + v19);
                            }
                        }
                        v30 = x.T(v20, 1000000L, v29, RoundingMode.DOWN);
                    }
                    else {
                        v30 = 0x8000000000000001L;
                    }
                    this.e(new B3.a(v28, v30, "audio/vnd.dts.hd;profile=lbr", v27, v18 + 1));
                    this.l = v18 + 1;
                    this.j = v30 == 0x8000000000000001L ? 0L : v30;
                    p1.G(0);
                    this.f.d(p1, this.n, 0);
                    this.g = 6;
                    continue;
                }
                case 4: {
                    if(!this.c(p0, p1.a, 6)) {
                        continue;
                    }
                    N n4 = B3.b.i(p1.a);
                    n4.O(0x20);
                    int v31 = B3.b.p(n4, B3.b.r) + 1;
                    this.o = v31;
                    int v32 = this.h;
                    if(v32 > v31) {
                        int v33 = v32 - v31;
                        this.h = v32 - v33;
                        p0.G(p0.b - v33);
                    }
                    this.g = 5;
                    continue;
                }
                case 5: {
                    if(!this.c(p0, p1.a, this.o)) {
                        continue;
                    }
                    byte[] arr_b2 = p1.a;
                    N n5 = B3.b.i(arr_b2);
                    int v34 = n5.D(0x20) == 1078008818 ? 1 : 0;
                    int v35 = B3.b.p(n5, B3.b.n);
                    if(v34 == 0) {
                        v48 = 0x8000000000000001L;
                        v49 = 0x80000001;
                    }
                    else {
                        if(!n5.C()) {
                            throw I.c("Only supports full channel mask-based audio presentation");
                        }
                        int v36 = v35 - 1;
                        int v37 = arr_b2[v36] << 8 & 0xFFFF | arr_b2[v35] & 0xFF;
                        int v39 = 0xFFFF;
                        for(int v38 = 0; v38 < v36; ++v38) {
                            int v40 = arr_b2[v38];
                            int v41 = (x.n[(v39 >> 12 & 0xFF ^ (v40 & 0xFF) >> 4) & 0xFF] ^ v39 << 4 & 0xFFFF) & 0xFFFF;
                            v39 = (v41 << 4 & 0xFFFF ^ x.n[(v40 & 15 ^ v41 >> 12 & 0xFF) & 0xFF]) & 0xFFFF;
                        }
                        if(v37 != v39) {
                            throw I.a(null, "CRC check failed");
                        }
                        int v42 = n5.D(2);
                        switch(v42) {
                            case 0: {
                                v43 = 0x200;
                                break;
                            }
                            case 1: {
                                v43 = 480;
                                break;
                            }
                            case 2: {
                                v43 = 0x180;
                                break;
                            }
                            default: {
                                throw I.a(null, "Unsupported base duration index in DTS UHD header: " + v42);
                            }
                        }
                        int v44 = n5.D(3);
                        int v45 = n5.D(2);
                        switch(v45) {
                            case 0: {
                                v46 = 32000;
                                break;
                            }
                            case 1: {
                                v46 = 44100;
                                break;
                            }
                            case 2: {
                                v46 = 48000;
                                break;
                            }
                            default: {
                                throw I.a(null, "Unsupported clock rate index in DTS UHD header: " + v45);
                            }
                        }
                        if(n5.C()) {
                            n5.O(36);
                        }
                        int v47 = n5.D(2);
                        v48 = x.T((v44 + 1) * v43, 1000000L, v46, RoundingMode.DOWN);
                        v49 = v46 * (1 << v47);
                    }
                    int v51 = 0;
                    for(int v50 = 0; v50 < v34; ++v50) {
                        v51 += B3.b.p(n5, B3.b.o);
                    }
                    AtomicInteger atomicInteger0 = this.b;
                    if(v34 != 0) {
                        atomicInteger0.set(B3.b.p(n5, B3.b.p));
                    }
                    int v52 = v51 + (atomicInteger0.get() == 0 ? 0 : B3.b.p(n5, B3.b.q)) + (v35 + 1);
                    B3.a a0 = new B3.a(2, v48, "audio/vnd.dts.uhd;profile=p2", v49, v52);
                    if(this.m == 3) {
                        this.e(a0);
                    }
                    this.l = v52;
                    this.j = v48 == 0x8000000000000001L ? 0L : v48;
                    p1.G(0);
                    this.f.d(p1, this.o, 0);
                    this.g = 6;
                    continue;
                }
                case 6: {
                    int v53 = Math.min(p0.a(), this.l - this.h);
                    this.f.d(p0, v53, 0);
                    int v54 = this.h + v53;
                    this.h = v54;
                    if(v54 == this.l) {
                        break;
                    }
                    continue;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
            e3.b.j(this.p != 0x8000000000000001L);
            this.f.c(this.p, (this.m == 4 ? 0 : 1), this.l, 0, null);
            this.p += this.j;
            this.g = 0;
        }
    }

    @Override  // h4.i
    public final void b(boolean z) {
    }

    public final boolean c(p p0, byte[] arr_b, int v) {
        int v1 = Math.min(p0.a(), v - this.h);
        p0.e(arr_b, this.h, v1);
        int v2 = this.h + v1;
        this.h = v2;
        return v2 == v;
    }

    @Override  // h4.i
    public final void d(t t0, G g0) {
        g0.c();
        g0.d();
        this.e = g0.e;
        g0.d();
        this.f = t0.track(g0.d, 1);
    }

    public final void e(B3.a a0) {
        int v = a0.b;
        String s = a0.a;
        int v1 = a0.c;
        if(v != 0x80000001 && v1 != -1 && (this.k == null || v1 != this.k.C || v != this.k.D || !s.equals(this.k.n))) {
            n n0 = this.k == null ? new n() : this.k.a();
            n0.a = this.e;
            n0.m = H.l(s);
            n0.B = v1;
            n0.C = v;
            n0.d = this.c;
            n0.f = this.d;
            b b0 = new b(n0);
            this.k = b0;
            this.f.b(b0);
        }
    }

    @Override  // h4.i
    public final void packetStarted(long v, int v1) {
        this.p = v;
    }

    @Override  // h4.i
    public final void seek() {
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.p = 0x8000000000000001L;
        this.b.set(0);
    }
}

