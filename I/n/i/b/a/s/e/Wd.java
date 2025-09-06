package i.n.i.b.a.s.e;

import android.net.Uri;
import java.util.Map;

public final class wd implements D0 {
    public final D0 a;
    public final int b;
    public final s5 c;
    public final byte[] d;
    public int e;

    public wd(D0 d00, int v, s5 s50) {
        M7.u(v > 0);
        this.a = d00;
        this.b = v;
        this.c = s50;
        this.d = new byte[1];
        this.e = v;
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final long b(W2 w20) {
        throw new UnsupportedOperationException();
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final Uri c() {
        return this.a.c();
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final void close() {
        throw new UnsupportedOperationException();
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final Map e() {
        return this.a.e();
    }

    @Override  // i.n.i.b.a.s.e.D0
    public final void l(g0 g00) {
        g00.getClass();
        this.a.l(g00);
    }

    @Override  // i.n.i.b.a.s.e.xe
    public final int o(byte[] arr_b, int v, int v1) {
        D0 d00 = this.a;
        if(this.e == 0) {
            byte[] arr_b1 = this.d;
            int v2 = 0;
            if(d00.o(arr_b1, 0, 1) != -1) {
                int v3 = (arr_b1[0] & 0xFF) << 4;
                if(v3 != 0) {
                    byte[] arr_b2 = new byte[v3];
                    for(int v4 = v3; v4 > 0; v4 -= v5) {
                        int v5 = d00.o(arr_b2, v2, v4);
                        if(v5 == -1) {
                            return -1;
                        }
                        v2 += v5;
                    }
                    while(v3 > 0 && arr_b2[v3 - 1] == 0) {
                        --v3;
                    }
                    if(v3 > 0) {
                        wb wb0 = new wb(arr_b2, v3);
                        long v6 = this.c.m ? Math.max(this.c.n.q(), this.c.i) : this.c.i;
                        int v7 = wb0.d();
                        e7 e70 = this.c.l;
                        e70.getClass();
                        e70.b(v7, wb0);
                        e70.f(v6, 1, v7, 0, null);
                        this.c.m = true;
                    }
                }
                this.e = this.b;
                goto label_30;
            }
            return -1;
        }
    label_30:
        int v8 = d00.o(arr_b, v, Math.min(this.e, v1));
        if(v8 != -1) {
            this.e -= v8;
        }
        return v8;
    }
}

