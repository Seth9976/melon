package s3;

import B7.b;
import Nf.p;
import androidx.media3.exoplayer.K;
import androidx.media3.exoplayer.i0;
import androidx.media3.session.N;
import b3.I;
import b3.q0;
import g3.e;
import g3.f;
import g3.j;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import v3.o;
import w3.g;
import w3.h;
import w3.k;

public final class c0 implements x, g {
    public final j a;
    public final e b;
    public final g3.x c;
    public final p d;
    public final b e;
    public final g0 f;
    public final ArrayList g;
    public final long h;
    public final k i;
    public final androidx.media3.common.b j;
    public final boolean k;
    public boolean l;
    public byte[] m;
    public int n;

    public c0(j j0, e e0, g3.x x0, androidx.media3.common.b b0, long v, p p0, b b1, boolean z) {
        this.a = j0;
        this.b = e0;
        this.c = x0;
        this.j = b0;
        this.h = v;
        this.d = p0;
        this.e = b1;
        this.k = z;
        this.f = new g0(new q0[]{new q0("", new androidx.media3.common.b[]{b0})});
        this.g = new ArrayList();
        this.i = new k("SingleSampleMediaPeriod");
    }

    @Override  // w3.g
    public final N a(h h0, long v, long v1, IOException iOException0, int v2) {
        N n0;
        long v3;
        q q0 = new q(((b0)h0).b.d, v1);
        p p0 = this.d;
        p0.getClass();
        if(iOException0 instanceof I || iOException0 instanceof FileNotFoundException || iOException0 instanceof g3.q || iOException0 instanceof w3.j) {
        label_11:
            v3 = 0x8000000000000001L;
        }
        else {
            Throwable throwable0 = iOException0;
            while(throwable0 != null) {
                if(throwable0 instanceof g3.g && ((g3.g)throwable0).a == 2008) {
                    goto label_11;
                }
                throwable0 = throwable0.getCause();
            }
            v3 = (long)Math.min((v2 - 1) * 1000, 5000);
        }
        int v4 = Long.compare(v3, 0x8000000000000001L);
        int v5 = 0;
        boolean z = v4 == 0 || v2 >= p0.e(1);
        if(!this.k || !z) {
            n0 = v4 == 0 ? k.f : new N(v3, 0, false);
        }
        else {
            e3.b.E("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", iOException0);
            this.l = true;
            n0 = k.e;
        }
        if(n0.a == 0 || n0.a == 1) {
            v5 = 1;
        }
        this.e.t(q0, 1, -1, this.j, 0, null, 0L, this.h, iOException0, ((boolean)(v5 ^ 1)));
        return n0;
    }

    @Override  // s3.X
    public final boolean b(K k0) {
        if(!this.l) {
            k k1 = this.i;
            if(!k1.b() && k1.c == null) {
                f f0 = this.b.createDataSource();
                g3.x x0 = this.c;
                if(x0 != null) {
                    f0.r(x0);
                }
                k1.d(new b0(f0, this.a), this, this.d.e(1));
                q q0 = new q(this.a);
                this.e.u(q0, 1, -1, this.j, 0, null, 0L, this.h);
                return true;
            }
        }
        return false;
    }

    @Override  // s3.x
    public final long c(o[] arr_o, boolean[] arr_z, V[] arr_v, boolean[] arr_z1, long v) {
        for(int v1 = 0; v1 < arr_o.length; ++v1) {
            V v2 = arr_v[v1];
            ArrayList arrayList0 = this.g;
            if(v2 != null && (arr_o[v1] == null || !arr_z[v1])) {
                arrayList0.remove(v2);
                arr_v[v1] = null;
            }
            if(arr_v[v1] == null && arr_o[v1] != null) {
                a0 a00 = new a0(this);
                arrayList0.add(a00);
                arr_v[v1] = a00;
                arr_z1[v1] = true;
            }
        }
        return v;
    }

    @Override  // w3.g
    public final void d(h h0, long v, long v1) {
        this.n = (int)((b0)h0).b.b;
        byte[] arr_b = ((b0)h0).c;
        arr_b.getClass();
        this.m = arr_b;
        this.l = true;
        q q0 = new q(((b0)h0).b.d, v1);
        this.d.getClass();
        this.e.s(q0, 1, -1, this.j, 0, null, 0L, this.h);
    }

    @Override  // s3.x
    public final void e(w w0, long v) {
        w0.d(this);
    }

    @Override  // s3.x
    public final long f(long v, i0 i00) {
        return v;
    }

    @Override  // s3.x
    public final void g(long v) {
    }

    // 去混淆评级： 低(20)
    @Override  // s3.X
    public final long getBufferedPositionUs() {
        return this.l ? 0x8000000000000000L : 0L;
    }

    // 去混淆评级： 低(20)
    @Override  // s3.X
    public final long getNextLoadPositionUs() {
        return this.l || this.i.b() ? 0x8000000000000000L : 0L;
    }

    @Override  // s3.x
    public final g0 getTrackGroups() {
        return this.f;
    }

    @Override  // w3.g
    public final void h(h h0, long v, long v1, boolean z) {
        q q0 = new q(((b0)h0).b.d, v1);
        this.d.getClass();
        this.e.r(q0, 1, -1, null, 0, null, 0L, this.h);
    }

    @Override  // s3.X
    public final boolean isLoading() {
        return this.i.b();
    }

    @Override  // s3.x
    public final void maybeThrowPrepareError() {
    }

    @Override  // s3.x
    public final long readDiscontinuity() {
        return 0x8000000000000001L;
    }

    @Override  // s3.X
    public final void reevaluateBuffer(long v) {
    }

    @Override  // s3.x
    public final long seekToUs(long v) {
        for(int v1 = 0; true; ++v1) {
            ArrayList arrayList0 = this.g;
            if(v1 >= arrayList0.size()) {
                break;
            }
            a0 a00 = (a0)arrayList0.get(v1);
            if(a00.a == 2) {
                a00.a = 1;
            }
        }
        return v;
    }
}

