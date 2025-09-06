package s3;

import androidx.media3.exoplayer.J;
import androidx.media3.exoplayer.K;
import androidx.media3.exoplayer.i0;
import v3.o;

public final class f0 implements w, x {
    public final x a;
    public final long b;
    public w c;

    public f0(x x0, long v) {
        this.a = x0;
        this.b = v;
    }

    @Override  // s3.W
    public final void a(X x0) {
        x x1 = (x)x0;
        w w0 = this.c;
        w0.getClass();
        w0.a(this);
    }

    @Override  // s3.X
    public final boolean b(K k0) {
        J j0 = new J();  // 初始化器: Ljava/lang/Object;-><init>()V
        j0.b = k0.b;
        j0.c = k0.c;
        j0.a = k0.a - this.b;
        K k1 = new K(j0);
        return this.a.b(k1);
    }

    @Override  // s3.x
    public final long c(o[] arr_o, boolean[] arr_z, V[] arr_v, boolean[] arr_z1, long v) {
        V[] arr_v1 = new V[arr_v.length];
        for(int v2 = 0; true; ++v2) {
            V v3 = null;
            if(v2 >= arr_v.length) {
                break;
            }
            e0 e00 = (e0)arr_v[v2];
            if(e00 != null) {
                v3 = e00.a;
            }
            arr_v1[v2] = v3;
        }
        long v4 = this.b;
        long v5 = this.a.c(arr_o, arr_z, arr_v1, arr_z1, v - v4);
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            V v6 = arr_v1[v1];
            if(v6 == null) {
                arr_v[v1] = null;
            }
            else {
                V v7 = arr_v[v1];
                if(v7 == null || ((e0)v7).a != v6) {
                    arr_v[v1] = new e0(v6, v4);
                }
            }
        }
        return v5 + v4;
    }

    @Override  // s3.w
    public final void d(x x0) {
        w w0 = this.c;
        w0.getClass();
        w0.d(this);
    }

    @Override  // s3.x
    public final void e(w w0, long v) {
        this.c = w0;
        this.a.e(this, v - this.b);
    }

    @Override  // s3.x
    public final long f(long v, i0 i00) {
        return this.a.f(v - this.b, i00) + this.b;
    }

    @Override  // s3.x
    public final void g(long v) {
        this.a.g(v - this.b);
    }

    @Override  // s3.X
    public final long getBufferedPositionUs() {
        long v = this.a.getBufferedPositionUs();
        return v == 0x8000000000000000L ? 0x8000000000000000L : v + this.b;
    }

    @Override  // s3.X
    public final long getNextLoadPositionUs() {
        long v = this.a.getNextLoadPositionUs();
        return v == 0x8000000000000000L ? 0x8000000000000000L : v + this.b;
    }

    @Override  // s3.x
    public final g0 getTrackGroups() {
        return this.a.getTrackGroups();
    }

    @Override  // s3.X
    public final boolean isLoading() {
        return this.a.isLoading();
    }

    @Override  // s3.x
    public final void maybeThrowPrepareError() {
        this.a.maybeThrowPrepareError();
    }

    @Override  // s3.x
    public final long readDiscontinuity() {
        long v = this.a.readDiscontinuity();
        return v == 0x8000000000000001L ? 0x8000000000000001L : v + this.b;
    }

    @Override  // s3.X
    public final void reevaluateBuffer(long v) {
        this.a.reevaluateBuffer(v - this.b);
    }

    @Override  // s3.x
    public final long seekToUs(long v) {
        return this.a.seekToUs(v - this.b) + this.b;
    }
}

