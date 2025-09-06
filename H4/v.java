package h4;

import B3.L;
import B3.N;
import B3.t;
import H0.e;
import I6.V;
import I6.p0;
import b3.I;
import b3.n;
import d8.d;
import e3.b;
import e3.p;
import e3.x;

public final class v implements i {
    public final p a;
    public final N b;
    public final p c;
    public int d;
    public String e;
    public L f;
    public double g;
    public double h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public boolean m;
    public int n;
    public int o;
    public final w p;
    public int q;
    public int r;
    public int s;
    public long t;
    public boolean u;

    public v() {
        this.d = 0;
        this.a = new p(new byte[15], 2);
        this.b = new N(2);
        this.c = new p();
        this.p = new w();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.q = 0x80000001;
        this.r = -1;
        this.t = -1L;
        this.j = true;
        this.m = true;
        this.g = -9223372036854776000.0;
        this.h = -9223372036854776000.0;
    }

    @Override  // h4.i
    public final void a(p p0) {
        int v39;
        int v38;
        byte[] arr_b;
        int v26;
        double f;
        int v19;
        int v18;
        int v16;
        boolean z;
        long v6;
        b.k(this.f);
    label_1:
        while(p0.a() > 0) {
            int v = this.d;
            if(v == 0) {
                int v41 = this.k;
                if((v41 & 2) == 0) {
                    p0.G(p0.c);
                }
                else {
                    if((v41 & 4) == 0) {
                        do {
                            if(p0.a() <= 0) {
                                continue label_1;
                            }
                            int v42 = this.l << 8;
                            this.l = v42;
                            int v43 = v42 | p0.u();
                            this.l = v43;
                        }
                        while((v43 & 0xFFFFFF) != 0xC001A5);
                        p0.G(p0.b - 3);
                        this.l = 0;
                    }
                    this.d = 1;
                }
            }
            else {
                p p1 = this.c;
                w w0 = this.p;
                switch(v) {
                    case 1: {
                        p p2 = this.a;
                        int v1 = Math.min(p0.a(), p2.a());
                        p0.e(p2.a, p2.b, v1);
                        p2.H(v1);
                        if(p2.a() == 0) {
                            int v2 = p2.c;
                            N n0 = this.b;
                            n0.K(p2.a, v2);
                            n0.A();
                            int v3 = d.C(n0, 3, 8, 8);
                            w0.a = v3;
                            if(v3 == -1) {
                                z = false;
                            }
                            else {
                                b.c(true);
                                e.y(e.y(3L, 0xFFL), 0x100000000L);
                                if(n0.m() >= 2) {
                                    long v4 = n0.F(2);
                                    if(v4 != 3L) {
                                    label_32:
                                        v6 = v4;
                                    }
                                    else if(n0.m() >= 8) {
                                        long v5 = n0.F(8);
                                        v4 = v5 + 3L;
                                        if(v5 != 0xFFL) {
                                            goto label_32;
                                        }
                                        else if(n0.m() >= 0x20) {
                                            v6 = n0.F(0x20) + v4;
                                        }
                                    }
                                }
                                else {
                                    v6 = -1L;
                                }
                                w0.b = v6;
                                if(v6 != -1L) {
                                    if(v6 > 16L) {
                                        throw I.c(("Contains sub-stream with an invalid packet label " + w0.b));
                                    }
                                    if(v6 == 0L) {
                                        switch(w0.a) {
                                            case 1: {
                                                throw I.a(null, "Mpegh3daConfig packet with invalid packet label 0");
                                            }
                                            case 2: {
                                                throw I.a(null, "Mpegh3daFrame packet with invalid packet label 0");
                                            }
                                            case 17: {
                                                throw I.a(null, "AudioTruncation packet with invalid packet label 0");
                                            }
                                        }
                                    }
                                    int v7 = d.C(n0, 11, 24, 24);
                                    w0.c = v7;
                                    if(v7 != -1) {
                                        z = true;
                                    }
                                }
                            }
                            if(z) {
                                this.n = 0;
                                this.o = w0.c + v2 + this.o;
                            }
                            if(z) {
                                p2.G(0);
                                this.f.d(p2, p2.c, 0);
                                p2.D(2);
                                p1.D(w0.c);
                                this.m = true;
                                this.d = 2;
                            }
                            else {
                                int v8 = p2.c;
                                if(v8 >= 15) {
                                    break;
                                }
                                p2.F(v8 + 1);
                                this.m = false;
                            }
                        }
                        else {
                            this.m = false;
                        }
                        break;
                    }
                    case 2: {
                        if(w0.a == 1 || w0.a == 17) {
                            int v9 = p0.b;
                            int v10 = Math.min(p0.a(), p1.a());
                            p0.e(p1.a, p1.b, v10);
                            p1.H(v10);
                            p0.G(v9);
                        }
                        int v11 = Math.min(p0.a(), w0.c - this.n);
                        this.f.d(p0, v11, 0);
                        int v12 = this.n + v11;
                        this.n = v12;
                        if(v12 != w0.c) {
                            break;
                        }
                        int v13 = w0.a;
                        if(v13 == 1) {
                            N n1 = new N(p1.a, p1.a.length, 2, 0);
                            int v14 = n1.D(8);
                            int v15 = n1.D(5);
                            if(v15 == 0x1F) {
                                v16 = n1.D(24);
                            }
                            else {
                                switch(v15) {
                                    case 0: {
                                        v16 = 96000;
                                        break;
                                    }
                                    case 1: {
                                        v16 = 88200;
                                        break;
                                    }
                                    case 2: {
                                        v16 = 0xFA00;
                                        break;
                                    }
                                    case 3: {
                                        v16 = 48000;
                                        break;
                                    }
                                    case 4: {
                                        v16 = 44100;
                                        break;
                                    }
                                    case 5: {
                                        v16 = 32000;
                                        break;
                                    }
                                    case 6: {
                                        v16 = 24000;
                                        break;
                                    }
                                    case 7: {
                                        v16 = 22050;
                                        break;
                                    }
                                    case 8: {
                                        v16 = 16000;
                                        break;
                                    }
                                    case 9: {
                                        v16 = 12000;
                                        break;
                                    }
                                    case 10: {
                                        v16 = 11025;
                                        break;
                                    }
                                    case 11: {
                                        v16 = 8000;
                                        break;
                                    }
                                    case 12: {
                                        v16 = 7350;
                                        break;
                                    }
                                    case 15: {
                                        v16 = 0xE100;
                                        break;
                                    }
                                    case 16: {
                                        v16 = 0xC800;
                                        break;
                                    }
                                    case 17: {
                                        v16 = 40000;
                                        break;
                                    }
                                    case 18: {
                                        v16 = 0x9600;
                                        break;
                                    }
                                    case 19: {
                                        v16 = 34150;
                                        break;
                                    }
                                    case 20: {
                                        v16 = 0x7080;
                                        break;
                                    }
                                    case 21: {
                                        v16 = 0x6400;
                                        break;
                                    }
                                    case 22: {
                                        v16 = 20000;
                                        break;
                                    }
                                    case 23: {
                                        v16 = 0x4B00;
                                        break;
                                    }
                                    case 24: {
                                        v16 = 17075;
                                        break;
                                    }
                                    case 25: {
                                        v16 = 14400;
                                        break;
                                    }
                                    case 26: {
                                        v16 = 0x3200;
                                        break;
                                    }
                                    case 27: {
                                        v16 = 9600;
                                        break;
                                    }
                                    default: {
                                        throw I.c(("Unsupported sampling rate index " + v15));
                                    }
                                }
                            }
                            int v17 = n1.D(3);
                            switch(v17) {
                                case 0: {
                                    v18 = 0x300;
                                    break;
                                }
                                case 1: {
                                    v18 = 0x400;
                                    break;
                                }
                                case 2: 
                                case 3: {
                                    v18 = 0x800;
                                    break;
                                }
                                case 4: {
                                    v18 = 0x1000;
                                    break;
                                }
                                default: {
                                    throw I.c(("Unsupported coreSbrFrameLengthIndex " + v17));
                                }
                            }
                            switch(v17) {
                                case 0: 
                                case 1: {
                                    v19 = 0;
                                    break;
                                }
                                case 2: {
                                    v19 = 2;
                                    break;
                                }
                                case 3: {
                                    v19 = 3;
                                    break;
                                }
                                case 4: {
                                    v19 = 1;
                                    break;
                                }
                                default: {
                                    throw I.c(("Unsupported coreSbrFrameLengthIndex " + v17));
                                }
                            }
                            n1.O(2);
                            d.H(n1);
                            int v20 = n1.D(5);
                            int v22 = 0;
                            for(int v21 = 0; v21 < v20 + 1; ++v21) {
                                int v23 = n1.D(3);
                                v22 = d.C(n1, 5, 8, 16) + 1 + v22;
                                if((v23 == 0 || v23 == 2) && n1.C()) {
                                    d.H(n1);
                                }
                            }
                            int v24 = d.C(n1, 4, 8, 16);
                            n1.N();
                            for(int v25 = 0; true; ++v25) {
                                f = 2.0;
                                if(v25 >= v24 + 1) {
                                    break;
                                }
                                switch(n1.D(2)) {
                                    case 0: {
                                        n1.O(3);
                                        if(n1.C()) {
                                            n1.O(13);
                                        }
                                        if(v19 > 0) {
                                            d.G(n1);
                                        }
                                        break;
                                    }
                                    case 1: {
                                        n1.O(3);
                                        boolean z1 = n1.C();
                                        if(z1) {
                                            n1.O(13);
                                        }
                                        if(z1) {
                                            n1.N();
                                        }
                                        if(v19 > 0) {
                                            d.G(n1);
                                            v26 = n1.D(2);
                                        }
                                        else {
                                            v26 = 0;
                                        }
                                        if(v26 > 0) {
                                            n1.O(6);
                                            int v27 = n1.D(2);
                                            n1.O(4);
                                            if(n1.C()) {
                                                n1.O(5);
                                            }
                                            if(v26 == 2 || v26 == 3) {
                                                n1.O(6);
                                            }
                                            if(v27 == 2) {
                                                n1.N();
                                            }
                                        }
                                        int v28 = ((int)Math.floor(Math.log(v22 - 1) / 0.693147)) + 1;
                                        int v29 = n1.D(2);
                                        if(v29 > 0 && n1.C()) {
                                            n1.O(v28);
                                        }
                                        if(n1.C()) {
                                            n1.O(v28);
                                        }
                                        if(v19 == 0 && v29 == 0) {
                                            n1.N();
                                        }
                                        break;
                                    }
                                    case 3: {
                                        d.C(n1, 4, 8, 16);
                                        int v30 = d.C(n1, 4, 8, 16);
                                        if(n1.C()) {
                                            d.C(n1, 8, 16, 0);
                                        }
                                        n1.N();
                                        if(v30 > 0) {
                                            n1.O(v30 * 8);
                                        }
                                    }
                                }
                            }
                            if(n1.C()) {
                                int v31 = d.C(n1, 2, 4, 8);
                                arr_b = null;
                                for(int v32 = 0; v32 < v31 + 1; ++v32) {
                                    int v33 = d.C(n1, 4, 8, 16);
                                    int v34 = d.C(n1, 4, 8, 16);
                                    if(v33 == 7) {
                                        int v35 = n1.D(4);
                                        n1.O(4);
                                        byte[] arr_b1 = new byte[v35 + 1];
                                        for(int v36 = 0; v36 < v35 + 1; ++v36) {
                                            arr_b1[v36] = (byte)n1.D(8);
                                        }
                                        arr_b = arr_b1;
                                    }
                                    else {
                                        n1.O(v34 * 8);
                                    }
                                }
                            }
                            else {
                                arr_b = null;
                            }
                            switch(v16) {
                                case 14700: 
                                case 16000: {
                                    f = 3.0;
                                    break;
                                }
                                case 22050: 
                                case 24000: {
                                    break;
                                }
                                case 29400: 
                                case 32000: 
                                case 58800: 
                                case 0xFA00: {
                                    f = 1.5;
                                    break;
                                }
                                case 44100: 
                                case 48000: 
                                case 88200: 
                                case 96000: {
                                    f = 1.0;
                                    break;
                                }
                                default: {
                                    throw I.c(("Unsupported sampling rate " + v16));
                                }
                            }
                            this.q = (int)(((double)v16) * f);
                            this.r = (int)(((double)v18) * f);
                            long v37 = w0.b;
                            if(this.t != v37) {
                                this.t = v37;
                                p0 p00 = arr_b == null || arr_b.length <= 0 ? null : V.u(x.f, arr_b);
                                n n2 = new n();
                                n2.a = this.e;
                                n2.m = "audio/mhm1";
                                n2.C = this.q;
                                n2.j = v14 == -1 ? "mhm1" : "mhm1" + String.format(".%02X", v14);
                                n2.p = p00;
                                androidx.media3.common.b b0 = new androidx.media3.common.b(n2);
                                this.f.b(b0);
                            }
                            this.u = true;
                        }
                        else if(v13 == 17) {
                            N n3 = new N(p1.a, p1.a.length, 2, 0);
                            if(n3.C()) {
                                n3.O(2);
                                v38 = n3.D(13);
                            }
                            else {
                                v38 = 0;
                            }
                            this.s = v38;
                        }
                        else if(v13 == 2) {
                            if(this.u) {
                                this.j = false;
                                v39 = 1;
                            }
                            else {
                                v39 = 0;
                            }
                            double f1 = ((double)(this.r - this.s)) * 1000000.0 / ((double)this.q);
                            long v40 = Math.round(this.g);
                            if(this.i) {
                                this.i = false;
                                this.g = this.h;
                            }
                            else {
                                this.g += f1;
                            }
                            this.f.c(v40, v39, this.o, 0, null);
                            this.u = false;
                            this.s = 0;
                            this.o = 0;
                        }
                        this.d = 1;
                        break;
                    }
                    default: {
                        throw new IllegalStateException();
                    }
                }
            }
        }
    }

    @Override  // h4.i
    public final void b(boolean z) {
    }

    @Override  // h4.i
    public final void d(t t0, G g0) {
        g0.c();
        g0.d();
        this.e = g0.e;
        g0.d();
        this.f = t0.track(g0.d, 1);
    }

    @Override  // h4.i
    public final void packetStarted(long v, int v1) {
        this.k = v1;
        if(!this.j && (this.o != 0 || !this.m)) {
            this.i = true;
        }
        if(v != 0x8000000000000001L) {
            if(this.i) {
                this.h = (double)v;
                return;
            }
            this.g = (double)v;
        }
    }

    @Override  // h4.i
    public final void seek() {
        this.d = 0;
        this.l = 0;
        this.a.D(2);
        this.n = 0;
        this.o = 0;
        this.q = 0x80000001;
        this.r = -1;
        this.s = 0;
        this.t = -1L;
        this.u = false;
        this.i = false;
        this.m = true;
        this.j = true;
        this.g = -9223372036854776000.0;
        this.h = -9223372036854776000.0;
    }
}

