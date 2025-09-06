package s3;

import androidx.media3.common.b;
import b3.n;
import h3.e;

public final class c implements V {
    public final V a;
    public boolean b;
    public final d c;

    public c(d d0, V v0) {
        this.c = d0;
        this.a = v0;
    }

    @Override  // s3.V
    public final int b(ea.c c0, e e0, int v) {
        d d0 = this.c;
        if(d0.h()) {
            return -3;
        }
        if(this.b) {
            e0.b = 4;
            return -4;
        }
        long v1 = d0.getBufferedPositionUs();
        int v2 = this.a.b(c0, e0, v);
        if(v2 == -5) {
            b b0 = (b)c0.c;
            b0.getClass();
            int v3 = b0.G;
            int v4 = b0.F;
            if(v4 == 0 && v3 == 0) {
                return -5;
            }
            if(Long.compare(d0.e, 0L) != 0) {
                v4 = 0;
            }
            if(d0.f != 0x8000000000000000L) {
                v3 = 0;
            }
            n n0 = b0.a();
            n0.E = v4;
            n0.F = v3;
            c0.c = new b(n0);
            return -5;
        }
        if(d0.f != 0x8000000000000000L && (v2 == -4 && e0.g >= d0.f || v2 == -3 && v1 == 0x8000000000000000L && !e0.f)) {
            e0.o();
            e0.b = 4;
            this.b = true;
            return -4;
        }
        return v2;
    }

    // 去混淆评级： 低(20)
    @Override  // s3.V
    public final boolean isReady() {
        return !this.c.h() && this.a.isReady();
    }

    @Override  // s3.V
    public final void maybeThrowError() {
        this.a.maybeThrowError();
    }

    // 去混淆评级： 低(20)
    @Override  // s3.V
    public final int skipData(long v) {
        return this.c.h() ? -3 : this.a.skipData(v);
    }
}

