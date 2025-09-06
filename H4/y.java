package h4;

import B3.N;
import B3.t;
import com.iloen.melon.utils.a;
import e3.b;
import e3.p;
import e3.v;

public final class y implements H {
    public final i a;
    public final N b;
    public int c;
    public int d;
    public v e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public boolean k;
    public long l;

    public y(i i0) {
        this.a = i0;
        this.b = new N(new byte[10], 10, 2, 0);
        this.c = 0;
    }

    @Override  // h4.H
    public final void a(int v, p p0) {
        int v4;
        b.k(this.e);
        i i0 = this.a;
        if((v & 1) != 0) {
            switch(this.c) {
                case 0: 
                case 1: {
                    break;
                }
                case 2: {
                    b.D("PesReader", "Unexpected start indicator reading extended header");
                    break;
                }
                case 3: {
                    if(this.j != -1) {
                        b.D("PesReader", "Unexpected start indicator: expected " + this.j + " more bytes");
                    }
                    i0.b(p0.c == 0);
                    break;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
            this.c = 1;
            this.d = 0;
        }
        int v1 = v;
        while(p0.a() > 0) {
            int v2 = this.c;
            if(v2 == 0) {
                p0.H(p0.a());
            }
            else {
                N n0 = this.b;
                switch(v2) {
                    case 1: {
                        if(!this.c(p0, n0.d, 9)) {
                            break;
                        }
                        n0.L(0);
                        int v3 = n0.D(24);
                        if(v3 == 1) {
                            n0.O(8);
                            int v5 = n0.D(16);
                            n0.O(5);
                            this.k = n0.C();
                            n0.O(2);
                            this.f = n0.C();
                            this.g = n0.C();
                            n0.O(6);
                            int v6 = n0.D(8);
                            this.i = v6;
                            if(v5 == 0) {
                                this.j = -1;
                            }
                            else {
                                int v7 = v5 - 3 - v6;
                                this.j = v7;
                                if(v7 < 0) {
                                    b.D("PesReader", "Found negative packet payload size: " + this.j);
                                    this.j = -1;
                                }
                            }
                            v4 = 2;
                        }
                        else {
                            a.r(v3, "Unexpected start code prefix: ", "PesReader");
                            this.j = -1;
                            v4 = 0;
                        }
                        this.c = v4;
                        this.d = 0;
                        break;
                    }
                    case 2: {
                        if(!this.c(p0, n0.d, Math.min(10, this.i)) || !this.c(p0, null, this.i)) {
                            break;
                        }
                        n0.L(0);
                        this.l = 0x8000000000000001L;
                        if(this.f) {
                            n0.O(4);
                            long v8 = ((long)n0.D(3)) << 30;
                            n0.O(1);
                            int v9 = n0.D(15);
                            n0.O(1);
                            long v10 = ((long)(v9 << 15)) | v8 | ((long)n0.D(15));
                            n0.O(1);
                            if(!this.h && this.g) {
                                n0.O(4);
                                long v11 = ((long)n0.D(3)) << 30;
                                n0.O(1);
                                int v12 = n0.D(15);
                                n0.O(1);
                                long v13 = v11 | ((long)(v12 << 15)) | ((long)n0.D(15));
                                n0.O(1);
                                this.e.b(v13);
                                this.h = true;
                            }
                            this.l = this.e.b(v10);
                        }
                        v1 |= (this.k ? 4 : 0);
                        i0.packetStarted(this.l, v1);
                        this.c = 3;
                        this.d = 0;
                        break;
                    }
                    case 3: {
                        int v14 = p0.a();
                        int v15 = this.j == -1 ? 0 : v14 - this.j;
                        if(v15 > 0) {
                            v14 -= v15;
                            p0.F(p0.b + v14);
                        }
                        i0.a(p0);
                        int v16 = this.j;
                        if(v16 == -1) {
                            break;
                        }
                        int v17 = v16 - v14;
                        this.j = v17;
                        if(v17 != 0) {
                            break;
                        }
                        i0.b(((boolean)0));
                        this.c = 1;
                        this.d = 0;
                        break;
                    }
                    default: {
                        throw new IllegalStateException();
                    }
                }
            }
        }
    }

    @Override  // h4.H
    public final void b(v v0, t t0, G g0) {
        this.e = v0;
        this.a.d(t0, g0);
    }

    public final boolean c(p p0, byte[] arr_b, int v) {
        int v1 = Math.min(p0.a(), v - this.d);
        if(v1 <= 0) {
            return true;
        }
        if(arr_b == null) {
            p0.H(v1);
        }
        else {
            p0.e(arr_b, this.d, v1);
        }
        int v2 = this.d + v1;
        this.d = v2;
        return v2 == v;
    }

    @Override  // h4.H
    public final void seek() {
        this.c = 0;
        this.d = 0;
        this.h = false;
        this.a.seek();
    }
}

