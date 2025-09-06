package s3;

import androidx.media3.session.H0;
import b3.H;
import e3.x;
import ea.c;
import h3.e;
import i.n.i.b.a.s.e.eb;
import java.io.IOException;
import w3.k;

public final class a0 implements V {
    public int a;
    public boolean b;
    public final c0 c;

    public a0(c0 c00) {
        this.c = c00;
    }

    public final void a() {
        if(!this.b) {
            int v = H.g(this.c.j.n);
            long v1 = x.Z(0L);
            v v2 = new v(1, v, this.c.j, 0, null, v1, 0x8000000000000001L);
            H0 h00 = new H0(27, this.c.e, v2);
            this.c.e.k(h00);
            this.b = true;
        }
    }

    @Override  // s3.V
    public final int b(c c0, e e0, int v) {
        this.a();
        c0 c00 = this.c;
        boolean z = c00.l;
        if(z && c00.m == null) {
            this.a = 2;
        }
        int v1 = this.a;
        if(v1 == 2) {
            e0.c(4);
            return -4;
        }
        if((v & 2) == 0 && v1 != 0) {
            if(!z) {
                return -3;
            }
            c00.m.getClass();
            e0.c(1);
            e0.g = 0L;
            if((v & 4) == 0) {
                e0.q(c00.n);
                e0.e.put(c00.m, 0, c00.n);
            }
            if((v & 1) == 0) {
                this.a = 2;
            }
            return -4;
        }
        c0.c = c00.j;
        this.a = 1;
        return -5;
    }

    @Override  // s3.V
    public final boolean isReady() {
        return this.c.l;
    }

    @Override  // s3.V
    public final void maybeThrowError() {
        c0 c00 = this.c;
        if(!c00.k) {
            k k0 = c00.i;
            IOException iOException0 = k0.c;
            if(iOException0 != null) {
                throw iOException0;
            }
            eb eb0 = k0.b;
            if(eb0 != null) {
                IOException iOException1 = eb0.d;
                if(iOException1 != null && eb0.e > eb0.b) {
                    throw iOException1;
                }
            }
        }
    }

    @Override  // s3.V
    public final int skipData(long v) {
        this.a();
        if(v > 0L && this.a != 2) {
            this.a = 2;
            return 1;
        }
        return 0;
    }
}

