package s3;

import androidx.media3.exoplayer.K;
import androidx.media3.exoplayer.i0;
import v3.o;
import w3.d;

public final class r implements w, x {
    public final z a;
    public final long b;
    public final d c;
    public a d;
    public x e;
    public w f;
    public long g;

    public r(z z0, d d0, long v) {
        this.a = z0;
        this.c = d0;
        this.b = v;
        this.g = 0x8000000000000001L;
    }

    @Override  // s3.W
    public final void a(X x0) {
        x x1 = (x)x0;
        this.f.a(this);
    }

    @Override  // s3.X
    public final boolean b(K k0) {
        return this.e != null && this.e.b(k0);
    }

    @Override  // s3.x
    public final long c(o[] arr_o, boolean[] arr_z, V[] arr_v, boolean[] arr_z1, long v) {
        long v1 = this.g == 0x8000000000000001L || v != this.b ? v : this.g;
        this.g = 0x8000000000000001L;
        return this.e.c(arr_o, arr_z, arr_v, arr_z1, v1);
    }

    @Override  // s3.w
    public final void d(x x0) {
        this.f.d(this);
    }

    @Override  // s3.x
    public final void e(w w0, long v) {
        this.f = w0;
        x x0 = this.e;
        if(x0 != null) {
            x0.e(this, (this.g == 0x8000000000000001L ? this.b : this.g));
        }
    }

    @Override  // s3.x
    public final long f(long v, i0 i00) {
        return this.e.f(v, i00);
    }

    @Override  // s3.x
    public final void g(long v) {
        this.e.g(v);
    }

    @Override  // s3.X
    public final long getBufferedPositionUs() {
        return this.e.getBufferedPositionUs();
    }

    @Override  // s3.X
    public final long getNextLoadPositionUs() {
        return this.e.getNextLoadPositionUs();
    }

    @Override  // s3.x
    public final g0 getTrackGroups() {
        return this.e.getTrackGroups();
    }

    public final void h(z z0) {
        long v = this.g == 0x8000000000000001L ? this.b : this.g;
        a a0 = this.d;
        a0.getClass();
        x x0 = a0.b(z0, this.c, v);
        this.e = x0;
        if(this.f != null) {
            x0.e(this, v);
        }
    }

    @Override  // s3.X
    public final boolean isLoading() {
        return this.e != null && this.e.isLoading();
    }

    @Override  // s3.x
    public final void maybeThrowPrepareError() {
        x x0 = this.e;
        if(x0 != null) {
            x0.maybeThrowPrepareError();
            return;
        }
        a a0 = this.d;
        if(a0 != null) {
            a0.j();
        }
    }

    @Override  // s3.x
    public final long readDiscontinuity() {
        return this.e.readDiscontinuity();
    }

    @Override  // s3.X
    public final void reevaluateBuffer(long v) {
        this.e.reevaluateBuffer(v);
    }

    @Override  // s3.x
    public final long seekToUs(long v) {
        return this.e.seekToUs(v);
    }
}

