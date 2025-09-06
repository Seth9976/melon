package h4;

import B3.L;
import B3.N;
import B3.d;
import B3.t;
import b3.H;
import b3.n;
import e3.p;
import java.util.Objects;

public final class b implements i {
    public final int a;
    public final N b;
    public final p c;
    public final String d;
    public final int e;
    public String f;
    public L g;
    public int h;
    public int i;
    public boolean j;
    public long k;
    public androidx.media3.common.b l;
    public int m;
    public long n;

    public b() {
        this.a = 0;
        this(null, 0, 0);
    }

    public b(String s, int v, int v1) {
        this.a = v1;
        if(v1 != 1) {
            super();
            N n0 = new N(new byte[0x80], 0x80, 2, 0);
            this.b = n0;
            this.c = new p(n0.d);
            this.h = 0;
            this.n = 0x8000000000000001L;
            this.d = s;
            this.e = v;
            return;
        }
        super();
        N n1 = new N(new byte[16], 16, 2, 0);
        this.b = n1;
        this.c = new p(n1.d);
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.n = 0x8000000000000001L;
        this.d = s;
        this.e = v;
    }

    @Override  // h4.i
    public final void a(p p0) {
        int v26;
        String s;
        int v24;
        int v21;
        int v18;
        int v15;
        int v14;
        int v13;
        int v11;
        int v10;
        int v1;
        if(this.a != 0) {
            e3.b.k(this.g);
        label_2:
            while(p0.a() > 0) {
                p p1 = this.c;
                boolean z = true;
                switch(this.h) {
                    case 0: {
                        while(true) {
                            if(p0.a() <= 0) {
                                continue label_2;
                            }
                            if(this.j) {
                                int v = p0.u();
                                this.j = v == 0xAC;
                                v1 = 0x40;
                                if(v == 0x40 || v == 65) {
                                    break;
                                }
                            }
                            else {
                                this.j = p0.u() == 0xAC;
                            }
                        }
                        this.h = 1;
                        byte[] arr_b = p1.a;
                        arr_b[0] = -84;
                        if(v == 65) {
                            v1 = 65;
                        }
                        arr_b[1] = (byte)v1;
                        this.i = 2;
                        continue;
                    }
                    case 1: {
                        int v2 = Math.min(p0.a(), 16 - this.i);
                        p0.e(p1.a, this.i, v2);
                        int v3 = this.i + v2;
                        this.i = v3;
                        if(v3 != 16) {
                            continue;
                        }
                        this.b.L(0);
                        d d0 = B3.b.l(this.b);
                        int v4 = d0.a;
                        if(this.l == null || 2 != this.l.C || v4 != this.l.D || !"audio/ac4".equals(this.l.n)) {
                            n n0 = new n();
                            n0.a = this.f;
                            n0.m = "audio/ac4";
                            n0.B = 2;
                            n0.C = v4;
                            n0.d = this.d;
                            n0.f = this.e;
                            androidx.media3.common.b b0 = new androidx.media3.common.b(n0);
                            this.l = b0;
                            this.g.b(b0);
                        }
                        this.m = d0.b;
                        this.k = ((long)d0.c) * 1000000L / ((long)this.l.D);
                        p1.G(0);
                        this.g.d(p1, 16, 0);
                        this.h = 2;
                        continue;
                    }
                    case 2: {
                        int v5 = Math.min(p0.a(), this.m - this.i);
                        this.g.d(p0, v5, 0);
                        int v6 = this.i + v5;
                        this.i = v6;
                        if(v6 != this.m) {
                            continue;
                        }
                        if(this.n == 0x8000000000000001L) {
                            z = false;
                        }
                        break;
                    }
                    default: {
                        continue;
                    }
                }
                e3.b.j(z);
                this.g.c(this.n, 1, this.m, 0, null);
                this.n += this.k;
                this.h = 0;
            }
            return;
        }
        e3.b.k(this.g);
        while(p0.a() > 0) {
            p p2 = this.c;
            boolean z1 = true;
            switch(this.h) {
                case 0: {
                    while(p0.a() > 0) {
                        if(this.j) {
                            int v7 = p0.u();
                            if(v7 == 0x77) {
                                this.j = false;
                                this.h = 1;
                                byte[] arr_b1 = p2.a;
                                arr_b1[0] = 11;
                                arr_b1[1] = 0x77;
                                this.i = 2;
                                break;
                            }
                            this.j = v7 == 11;
                        }
                        else {
                            this.j = p0.u() == 11;
                        }
                    }
                    continue;
                }
                case 1: {
                    int v8 = Math.min(p0.a(), 0x80 - this.i);
                    p0.e(p2.a, this.i, v8);
                    int v9 = this.i + v8;
                    this.i = v9;
                    if(v9 != 0x80) {
                        continue;
                    }
                    N n1 = this.b;
                    n1.L(0);
                    int[] arr_v = B3.b.f;
                    int[] arr_v1 = B3.b.d;
                    n1.O(40);
                    boolean z2 = n1.D(5) > 10;
                    n1.L(n1.B());
                    if(z2) {
                        n1.O(16);
                        switch(n1.D(2)) {
                            case 0: {
                                v10 = 0;
                                break;
                            }
                            case 1: {
                                v10 = 1;
                                break;
                            }
                            case 2: {
                                v10 = 2;
                                break;
                            }
                            default: {
                                v10 = -1;
                            }
                        }
                        n1.O(3);
                        v11 = (n1.D(11) + 1) * 2;
                        int v12 = n1.D(2);
                        if(v12 == 3) {
                            v13 = B3.b.e[n1.D(2)];
                            v14 = 3;
                            v15 = 6;
                        }
                        else {
                            int v16 = n1.D(2);
                            int v17 = B3.b.c[v16];
                            v13 = arr_v1[v12];
                            v14 = v16;
                            v15 = v17;
                        }
                        v18 = v15 * 0x100;
                        int v19 = n1.D(3);
                        int v20 = n1.C();
                        v21 = arr_v[v19] + v20;
                        n1.O(10);
                        if(n1.C()) {
                            n1.O(8);
                        }
                        if(v19 == 0) {
                            n1.O(5);
                            if(n1.C()) {
                                n1.O(8);
                            }
                        }
                        if(v10 == 1 && n1.C()) {
                            n1.O(16);
                        }
                        if(n1.C()) {
                            if(v19 > 2) {
                                n1.O(2);
                            }
                            if((v19 & 1) != 0 && v19 > 2) {
                                n1.O(6);
                            }
                            if((v19 & 4) != 0) {
                                n1.O(6);
                            }
                            if(v20 != 0 && n1.C()) {
                                n1.O(5);
                            }
                            if(v10 == 0) {
                                if(n1.C()) {
                                    n1.O(6);
                                }
                                if(v19 == 0 && n1.C()) {
                                    n1.O(6);
                                }
                                if(n1.C()) {
                                    n1.O(6);
                                }
                                int v22 = n1.D(2);
                                if(v22 == 1) {
                                    n1.O(5);
                                }
                                else {
                                    switch(v22) {
                                        case 2: {
                                            n1.O(12);
                                            break;
                                        }
                                        case 3: {
                                            int v23 = n1.D(5);
                                            if(n1.C()) {
                                                n1.O(5);
                                                if(n1.C()) {
                                                    n1.O(4);
                                                }
                                                if(n1.C()) {
                                                    n1.O(4);
                                                }
                                                if(n1.C()) {
                                                    n1.O(4);
                                                }
                                                if(n1.C()) {
                                                    n1.O(4);
                                                }
                                                if(n1.C()) {
                                                    n1.O(4);
                                                }
                                                if(n1.C()) {
                                                    n1.O(4);
                                                }
                                                if(n1.C()) {
                                                    n1.O(4);
                                                }
                                                if(n1.C()) {
                                                    if(n1.C()) {
                                                        n1.O(4);
                                                    }
                                                    if(n1.C()) {
                                                        n1.O(4);
                                                    }
                                                }
                                            }
                                            if(n1.C()) {
                                                n1.O(5);
                                                if(n1.C()) {
                                                    n1.O(7);
                                                    if(n1.C()) {
                                                        n1.O(8);
                                                    }
                                                }
                                            }
                                            n1.O((v23 + 2) * 8);
                                            n1.n();
                                        }
                                    }
                                }
                                if(v19 < 2) {
                                    if(n1.C()) {
                                        n1.O(14);
                                    }
                                    if(v19 == 0 && n1.C()) {
                                        n1.O(14);
                                    }
                                }
                                if(n1.C()) {
                                    v24 = v14;
                                    if(v24 == 0) {
                                        n1.O(5);
                                    }
                                    else {
                                        for(int v25 = 0; v25 < v15; ++v25) {
                                            if(n1.C()) {
                                                n1.O(5);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            v24 = v14;
                        }
                        if(n1.C()) {
                            n1.O(5);
                            if(v19 == 2) {
                                n1.O(4);
                            }
                            if(v19 >= 6) {
                                n1.O(2);
                            }
                            if(n1.C()) {
                                n1.O(8);
                            }
                            if(v19 == 0 && n1.C()) {
                                n1.O(8);
                            }
                            if(v12 < 3) {
                                n1.N();
                            }
                        }
                        if(v10 == 0 && v24 != 3) {
                            n1.N();
                        }
                        if(v10 == 2 && (v24 == 3 || n1.C())) {
                            n1.O(6);
                        }
                        s = !n1.C() || n1.D(6) != 1 || n1.D(8) != 1 ? "audio/eac3" : "audio/eac3-joc";
                        v26 = v11 * v13 / (v15 * 0x20);
                    }
                    else {
                        n1.O(0x20);
                        int v27 = n1.D(2);
                        int v28 = n1.D(6);
                        v26 = B3.b.g[v28 / 2] * 1000;
                        int v29 = B3.b.f(v27, v28);
                        n1.O(8);
                        int v30 = n1.D(3);
                        if((v30 & 1) != 0 && v30 != 1) {
                            n1.O(2);
                        }
                        if((v30 & 4) != 0) {
                            n1.O(2);
                        }
                        if(v30 == 2) {
                            n1.O(2);
                        }
                        int v31 = v27 >= 3 ? -1 : arr_v1[v27];
                        int v32 = n1.C();
                        v21 = arr_v[v30] + v32;
                        v11 = v29;
                        v13 = v31;
                        v18 = 0x600;
                        s = v27 == 3 ? null : "audio/ac3";
                    }
                    if(this.l == null || v21 != this.l.C || v13 != this.l.D || !Objects.equals(s, this.l.n)) {
                        n n2 = new n();
                        n2.a = this.f;
                        n2.m = H.l(s);
                        n2.B = v21;
                        n2.C = v13;
                        n2.d = this.d;
                        n2.f = this.e;
                        n2.i = v26;
                        if("audio/ac3".equals(s)) {
                            n2.h = v26;
                        }
                        androidx.media3.common.b b1 = new androidx.media3.common.b(n2);
                        this.l = b1;
                        this.g.b(b1);
                    }
                    this.m = v11;
                    this.k = ((long)v18) * 1000000L / ((long)this.l.D);
                    p2.G(0);
                    this.g.d(p2, 0x80, 0);
                    this.h = 2;
                    continue;
                }
                case 2: {
                    int v33 = Math.min(p0.a(), this.m - this.i);
                    this.g.d(p0, v33, 0);
                    int v34 = this.i + v33;
                    this.i = v34;
                    if(v34 != this.m) {
                        continue;
                    }
                    if(this.n == 0x8000000000000001L) {
                        z1 = false;
                    }
                    break;
                }
                default: {
                    continue;
                }
            }
            e3.b.j(z1);
            this.g.c(this.n, 1, this.m, 0, null);
            this.n += this.k;
            this.h = 0;
        }
    }

    @Override  // h4.i
    public final void b(boolean z) {
    }

    private final void c(boolean z) {
    }

    @Override  // h4.i
    public final void d(t t0, G g0) {
        if(this.a != 0) {
            g0.c();
            g0.d();
            this.f = g0.e;
            g0.d();
            this.g = t0.track(g0.d, 1);
            return;
        }
        g0.c();
        g0.d();
        this.f = g0.e;
        g0.d();
        this.g = t0.track(g0.d, 1);
    }

    private final void e(boolean z) {
    }

    @Override  // h4.i
    public final void packetStarted(long v, int v1) {
        if(this.a != 0) {
            this.n = v;
            return;
        }
        this.n = v;
    }

    @Override  // h4.i
    public final void seek() {
        if(this.a != 0) {
            this.h = 0;
            this.i = 0;
            this.j = false;
            this.n = 0x8000000000000001L;
            return;
        }
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.n = 0x8000000000000001L;
    }
}

