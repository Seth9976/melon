package s3;

import B3.L;
import android.net.Uri;
import e3.b;
import g3.f;
import g3.j;
import g3.x;
import java.util.Map;

public final class p implements f {
    public final f a;
    public final int b;
    public final K c;
    public final byte[] d;
    public int e;

    public p(f f0, int v, K k0) {
        b.c(v > 0);
        this.a = f0;
        this.b = v;
        this.c = k0;
        this.d = new byte[1];
        this.e = v;
    }

    @Override  // g3.f
    public final void close() {
        throw new UnsupportedOperationException();
    }

    @Override  // g3.f
    public final Map getResponseHeaders() {
        return this.a.getResponseHeaders();
    }

    @Override  // g3.f
    public final Uri getUri() {
        return this.a.getUri();
    }

    @Override  // g3.f
    public final long p(j j0) {
        throw new UnsupportedOperationException();
    }

    @Override  // g3.f
    public final void r(x x0) {
        x0.getClass();
        this.a.r(x0);
    }

    @Override  // b3.j
    public final int read(byte[] arr_b, int v, int v1) {
        f f0 = this.a;
        if(this.e == 0) {
            byte[] arr_b1 = this.d;
            if(f0.read(arr_b1, 0, 1) != -1) {
                int v2 = (arr_b1[0] & 0xFF) << 4;
                if(v2 != 0) {
                    byte[] arr_b2 = new byte[v2];
                    int v3 = v2;
                    int v4 = 0;
                    while(v3 > 0) {
                        int v5 = f0.read(arr_b2, v4, v3);
                        if(v5 == -1) {
                            return -1;
                        }
                        v4 += v5;
                        v3 -= v5;
                    }
                    while(v2 > 0 && arr_b2[v2 - 1] == 0) {
                        --v2;
                    }
                    if(v2 > 0) {
                        e3.p p0 = new e3.p(arr_b2, v2);
                        long v6 = this.c.l ? Math.max(this.c.m.l(true), this.c.i) : this.c.i;
                        int v7 = p0.a();
                        L l0 = this.c.k;
                        l0.getClass();
                        l0.d(p0, v7, 0);
                        l0.c(v6, 1, v7, 0, null);
                        this.c.l = true;
                    }
                }
                this.e = this.b;
                goto label_30;
            }
            return -1;
        }
    label_30:
        int v8 = f0.read(arr_b, v, Math.min(this.e, v1));
        if(v8 != -1) {
            this.e -= v8;
        }
        return v8;
    }
}

