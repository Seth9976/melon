package s3;

import androidx.media3.common.b;
import androidx.media3.exoplayer.K;
import androidx.media3.exoplayer.i0;
import androidx.recyclerview.widget.p0;
import b3.H;
import v3.o;

public final class d implements w, x {
    public final x a;
    public w b;
    public c[] c;
    public long d;
    public long e;
    public long f;
    public f g;

    public d(x x0, boolean z, long v, long v1) {
        this.a = x0;
        this.c = new c[0];
        this.d = z ? v : 0x8000000000000001L;
        this.e = v;
        this.f = v1;
    }

    @Override  // s3.W
    public final void a(X x0) {
        x x1 = (x)x0;
        w w0 = this.b;
        w0.getClass();
        w0.a(this);
    }

    @Override  // s3.X
    public final boolean b(K k0) {
        return this.a.b(k0);
    }

    @Override  // s3.x
    public final long c(o[] arr_o, boolean[] arr_z, V[] arr_v, boolean[] arr_z1, long v) {
        this.c = new c[arr_v.length];
        V[] arr_v1 = new V[arr_v.length];
        for(int v2 = 0; true; ++v2) {
            V v3 = null;
            if(v2 >= arr_v.length) {
                break;
            }
            c[] arr_c = this.c;
            c c0 = (c)arr_v[v2];
            arr_c[v2] = c0;
            if(c0 != null) {
                v3 = c0.a;
            }
            arr_v1[v2] = v3;
        }
        long v4 = 0x8000000000000001L;
        long v5 = this.a.c(arr_o, arr_z, arr_v1, arr_z1, v);
        boolean z = true;
        if(this.h() && (v == this.e && this.e != 0L)) {
            for(int v6 = 0; v6 < arr_o.length; ++v6) {
                o o0 = arr_o[v6];
                if(o0 != null) {
                    b b0 = o0.getSelectedFormat();
                    String s = b0.n;
                    String s1 = b0.k;
                    if(s != null) {
                        switch(s) {
                            case "audio/ac3": {
                                continue;
                            }
                            case "audio/eac3": {
                                continue;
                            }
                            case "audio/eac3-joc": {
                                continue;
                            }
                            case "audio/flac": {
                                continue;
                            }
                            case "audio/g711-alaw": {
                                continue;
                            }
                            case "audio/g711-mlaw": {
                                continue;
                            }
                            case "audio/mp4a-latm": {
                                if(s1 != null) {
                                    p0 p00 = H.e(s1);
                                    if(p00 != null) {
                                        switch(p00.a()) {
                                            case 0: 
                                            case 16: {
                                                break;
                                            }
                                            default: {
                                                continue;
                                            }
                                        }
                                    }
                                }
                                break;
                            }
                            case "audio/mpeg": {
                                continue;
                            }
                            case "audio/mpeg-L1": {
                                continue;
                            }
                            case "audio/mpeg-L2": {
                                continue;
                            }
                            case "audio/raw": {
                                continue;
                            }
                        }
                    }
                    v4 = v5;
                    break;
                }
            }
        }
        this.d = v4;
        if(v5 != v && (v5 < this.e || this.f != 0x8000000000000000L && v5 > this.f)) {
            z = false;
        }
        e3.b.j(z);
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            V v7 = arr_v1[v1];
            if(v7 == null) {
                this.c[v1] = null;
            }
            else {
                c[] arr_c1 = this.c;
                c c1 = arr_c1[v1];
                if(c1 == null || c1.a != v7) {
                    arr_c1[v1] = new c(this, v7);
                }
            }
            arr_v[v1] = this.c[v1];
        }
        return v5;
    }

    @Override  // s3.w
    public final void d(x x0) {
        if(this.g != null) {
            return;
        }
        w w0 = this.b;
        w0.getClass();
        w0.d(this);
    }

    @Override  // s3.x
    public final void e(w w0, long v) {
        this.b = w0;
        this.a.e(this, v);
    }

    @Override  // s3.x
    public final long f(long v, i0 i00) {
        long v1 = this.e;
        if(v == v1) {
            return v1;
        }
        long v2 = e3.x.i(i00.a, 0L, v - v1);
        long v3 = e3.x.i(i00.b, 0L, (this.f == 0x8000000000000000L ? 0x7FFFFFFFFFFFFFFFL : this.f - v));
        if(v2 != i00.a || v3 != i00.b) {
            i00 = new i0(v2, v3);
        }
        return this.a.f(v, i00);
    }

    @Override  // s3.x
    public final void g(long v) {
        this.a.g(v);
    }

    @Override  // s3.X
    public final long getBufferedPositionUs() {
        long v = this.a.getBufferedPositionUs();
        return v == 0x8000000000000000L || this.f != 0x8000000000000000L && v >= this.f ? 0x8000000000000000L : v;
    }

    @Override  // s3.X
    public final long getNextLoadPositionUs() {
        long v = this.a.getNextLoadPositionUs();
        return v == 0x8000000000000000L || this.f != 0x8000000000000000L && v >= this.f ? 0x8000000000000000L : v;
    }

    @Override  // s3.x
    public final g0 getTrackGroups() {
        return this.a.getTrackGroups();
    }

    public final boolean h() {
        return this.d != 0x8000000000000001L;
    }

    @Override  // s3.X
    public final boolean isLoading() {
        return this.a.isLoading();
    }

    @Override  // s3.x
    public final void maybeThrowPrepareError() {
        f f0 = this.g;
        if(f0 != null) {
            throw f0;
        }
        this.a.maybeThrowPrepareError();
    }

    @Override  // s3.x
    public final long readDiscontinuity() {
        if(this.h()) {
            long v = this.d;
            this.d = 0x8000000000000001L;
            long v1 = this.readDiscontinuity();
            return v1 == 0x8000000000000001L ? v : v1;
        }
        boolean z = false;
        long v2 = this.a.readDiscontinuity();
        if(v2 == 0x8000000000000001L) {
            return 0x8000000000000001L;
        }
        e3.b.j(Long.compare(v2, this.e) >= 0);
        if(this.f == 0x8000000000000000L || v2 <= this.f) {
            z = true;
        }
        e3.b.j(z);
        return v2;
    }

    @Override  // s3.X
    public final void reevaluateBuffer(long v) {
        this.a.reevaluateBuffer(v);
    }

    @Override  // s3.x
    public final long seekToUs(long v) {
        this.d = 0x8000000000000001L;
        c[] arr_c = this.c;
        boolean z = false;
        for(int v1 = 0; v1 < arr_c.length; ++v1) {
            c c0 = arr_c[v1];
            if(c0 != null) {
                c0.b = false;
            }
        }
        long v2 = this.a.seekToUs(v);
        if(v2 == v || v2 >= this.e && (this.f == 0x8000000000000000L || v2 <= this.f)) {
            z = true;
        }
        e3.b.j(z);
        return v2;
    }
}

