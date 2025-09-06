package i.n.i.b.a.s.e;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import h3.b;
import java.nio.ByteBuffer;
import o3.a;

public final class cc implements W7 {
    public final MediaCodec a;
    public ByteBuffer[] b;
    public ByteBuffer[] c;

    public cc(MediaCodec mediaCodec0) {
        this.a = mediaCodec0;
        if(L7.a < 21) {
            this.b = mediaCodec0.getInputBuffers();
            this.c = mediaCodec0.getOutputBuffers();
        }
    }

    @Override  // i.n.i.b.a.s.e.W7
    public final ByteBuffer a(int v) {
        return L7.a < 21 ? this.b[v] : this.a.getInputBuffer(v);
    }

    @Override  // i.n.i.b.a.s.e.W7
    public final void a() {
        this.b = null;
        this.c = null;
        this.a.release();
    }

    @Override  // i.n.i.b.a.s.e.W7
    public final int b() {
        return this.a.dequeueInputBuffer(0L);
    }

    @Override  // i.n.i.b.a.s.e.W7
    public final void b(Bundle bundle0) {
        this.a.setParameters(bundle0);
    }

    @Override  // i.n.i.b.a.s.e.W7
    public final MediaFormat c() {
        return this.a.getOutputFormat();
    }

    @Override  // i.n.i.b.a.s.e.W7
    public final void c(int v, long v1) {
        this.a.releaseOutputBuffer(v, v1);
    }

    @Override  // i.n.i.b.a.s.e.W7
    public final void d(H0 h00, Handler handler0) {
        a a0 = new a(this, h00, 2);
        this.a.setOnFrameRenderedListener(a0, handler0);
    }

    @Override  // i.n.i.b.a.s.e.W7
    public final void e(int v) {
        this.a.setVideoScalingMode(v);
    }

    @Override  // i.n.i.b.a.s.e.W7
    public final int f(MediaCodec.BufferInfo mediaCodec$BufferInfo0) {
        int v;
        do {
            MediaCodec mediaCodec0 = this.a;
            v = mediaCodec0.dequeueOutputBuffer(mediaCodec$BufferInfo0, 0L);
            if(v == -3 && L7.a < 21) {
                this.c = mediaCodec0.getOutputBuffers();
            }
        }
        while(v == -3);
        return v;
    }

    @Override  // i.n.i.b.a.s.e.W7
    public final void flush() {
        this.a.flush();
    }

    @Override  // i.n.i.b.a.s.e.W7
    public final ByteBuffer g(int v) {
        return L7.a < 21 ? this.c[v] : this.a.getOutputBuffer(v);
    }

    @Override  // i.n.i.b.a.s.e.W7
    public final void h(int v, int v1, int v2, long v3) {
        this.a.queueInputBuffer(v, 0, v1, v3, v2);
    }

    @Override  // i.n.i.b.a.s.e.W7
    public final void i(Surface surface0) {
        this.a.setOutputSurface(surface0);
    }

    @Override  // i.n.i.b.a.s.e.W7
    public final void j(int v, boolean z) {
        this.a.releaseOutputBuffer(v, z);
    }

    @Override  // i.n.i.b.a.s.e.W7
    public final void k(int v, b b0, long v1, int v2) {
        this.a.queueSecureInputBuffer(v, 0, b0.i, v1, v2);
    }
}

