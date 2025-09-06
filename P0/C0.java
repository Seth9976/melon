package P0;

import A3.l;
import Vd.w;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;
import androidx.collection.f;
import androidx.media3.session.r1;
import d5.m;
import g0.e;
import h3.b;
import i.n.i.b.a.s.e.H0;
import i.n.i.b.a.s.e.u9;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import kb.D;
import kotlin.jvm.internal.q;
import o3.a;
import o3.j;
import o3.k;
import r0.o;
import r0.p;

public final class c0 implements j {
    public final int a;
    public int b;
    public boolean c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;

    public c0() {
        this.a = 1;
        super();
        this.d = new Object();
        this.e = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
    }

    public c0(d0 d00, p p0, int v, e e0, e e1, boolean z) {
        this.a = 0;
        super();
        this.g = d00;
        this.d = p0;
        this.b = v;
        this.e = e0;
        this.f = e1;
        this.c = z;
    }

    public c0(MediaCodec mediaCodec0, HandlerThread handlerThread0, k k0, m m0) {
        this.a = 2;
        super();
        this.d = mediaCodec0;
        this.e = new o3.e(handlerThread0);
        this.f = k0;
        this.g = m0;
        this.b = 0;
    }

    @Override  // o3.j
    public void a(int v, b b0, long v1, int v2) {
        ((k)this.f).a(v, b0, v1, v2);
    }

    public static void b(c0 c00, MediaFormat mediaFormat0, Surface surface0, MediaCrypto mediaCrypto0, int v) {
        o3.e e0 = (o3.e)c00.e;
        MediaCodec mediaCodec0 = (MediaCodec)c00.d;
        e3.b.j(e0.c == null);
        e0.b.start();
        Handler handler0 = new Handler(e0.b.getLooper());
        mediaCodec0.setCallback(e0, handler0);
        e0.c = handler0;
        Trace.beginSection("configureCodec");
        mediaCodec0.configure(mediaFormat0, surface0, mediaCrypto0, v);
        Trace.endSection();
        ((k)c00.f).start();
        Trace.beginSection("startCodec");
        mediaCodec0.start();
        Trace.endSection();
        c00.b = 1;
    }

    @Override  // o3.j
    public void c(Bundle bundle0) {
        ((k)this.f).c(bundle0);
    }

    @Override  // o3.j
    public void d(int v, int v1, int v2, long v3) {
        ((k)this.f).d(v, v1, v2, v3);
    }

    @Override  // o3.j
    public MediaFormat e() {
        o3.e e0 = (o3.e)this.e;
        synchronized(e0.a) {
            MediaFormat mediaFormat0 = e0.h;
            if(mediaFormat0 != null) {
                return mediaFormat0;
            }
        }
        throw new IllegalStateException();
    }

    @Override  // o3.j
    public void f() {
        ((MediaCodec)this.d).detachOutputSurface();
    }

    @Override  // o3.j
    public void flush() {
        ((k)this.f).flush();
        ((MediaCodec)this.d).flush();
        o3.e e0 = (o3.e)this.e;
        synchronized(e0.a) {
            ++e0.l;
            e0.c.post(new u9(e0, 17));
        }
        ((MediaCodec)this.d).start();
    }

    @Override  // o3.j
    public boolean g(D d0) {
        synchronized(((o3.e)this.e).a) {
            ((o3.e)this.e).o = d0;
        }
        return true;
    }

    @Override  // o3.j
    public ByteBuffer h(int v) {
        return ((MediaCodec)this.d).getInputBuffer(v);
    }

    @Override  // o3.j
    public void i(Surface surface0) {
        ((MediaCodec)this.d).setOutputSurface(surface0);
    }

    public boolean j(int v, int v1) {
        int v2 = this.b;
        o o0 = (o)((e)this.e).a[v + v2];
        o o1 = (o)((e)this.f).a[v2 + v1];
        return q.b(o0, o1) || o0.getClass() == o1.getClass();
    }

    @Override  // o3.j
    public void k(int v) {
        ((MediaCodec)this.d).releaseOutputBuffer(v, false);
    }

    public r1 l(Object object0) {
        synchronized(this.d) {
            int v1 = this.r();
            r1 r10 = new r1(v1, object0);
            if(this.c) {
                r10.m();
            }
            else {
                ((f)this.e).put(v1, r10);
            }
            return r10;
        }
    }

    @Override  // o3.j
    public void m(H0 h00, Handler handler0) {
        ((MediaCodec)this.d).setOnFrameRenderedListener(new a(this, h00, 0), handler0);
    }

    @Override  // o3.j
    public void n(int v, long v1) {
        ((MediaCodec)this.d).releaseOutputBuffer(v, v1);
    }

    @Override  // o3.j
    public int o() {
        IllegalStateException illegalStateException0;
        ((k)this.f).b();
        o3.e e0 = (o3.e)this.e;
        synchronized(e0.a) {
            illegalStateException0 = e0.n;
            if(illegalStateException0 == null) {
                MediaCodec.CodecException mediaCodec$CodecException0 = e0.j;
                if(mediaCodec$CodecException0 == null) {
                    int v1 = -1;
                    MediaCodec.CryptoException mediaCodec$CryptoException0 = e0.k;
                    if(mediaCodec$CryptoException0 == null) {
                        if(Long.compare(e0.l, 0L) > 0 || e0.m) {
                            return -1;
                        }
                        w w0 = e0.d;
                        int v2 = w0.b;
                        if(v2 != w0.c) {
                            v1 = ((int[])w0.e)[v2];
                            w0.b = v2 + 1 & w0.d;
                        }
                        return v1;
                    }
                    e0.k = null;
                    throw mediaCodec$CryptoException0;
                }
                e0.j = null;
                throw mediaCodec$CodecException0;
            }
            e0.n = null;
        }
        throw illegalStateException0;
    }

    public static String p(int v, String s) {
        StringBuilder stringBuilder0 = new StringBuilder(s);
        if(v == 1) {
            stringBuilder0.append("Audio");
            return stringBuilder0.toString();
        }
        if(v == 2) {
            stringBuilder0.append("Video");
            return stringBuilder0.toString();
        }
        stringBuilder0.append("Unknown(");
        stringBuilder0.append(v);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }

    @Override  // o3.j
    public int q(MediaCodec.BufferInfo mediaCodec$BufferInfo0) {
        int v2;
        ((k)this.f).b();
        o3.e e0 = (o3.e)this.e;
        synchronized(e0.a) {
            IllegalStateException illegalStateException0 = e0.n;
            if(illegalStateException0 != null) {
                e0.n = null;
                throw illegalStateException0;
            }
            MediaCodec.CodecException mediaCodec$CodecException0 = e0.j;
            if(mediaCodec$CodecException0 != null) {
                e0.j = null;
                throw mediaCodec$CodecException0;
            }
            MediaCodec.CryptoException mediaCodec$CryptoException0 = e0.k;
            if(mediaCodec$CryptoException0 != null) {
                e0.k = null;
                throw mediaCodec$CryptoException0;
            }
            if(Long.compare(e0.l, 0L) <= 0 && !e0.m) {
                w w0 = e0.e;
                int v = w0.b;
                int v1 = w0.c;
                if(v != v1) {
                    if(v == v1) {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    v2 = ((int[])w0.e)[v];
                    w0.b = w0.d & v + 1;
                    if(v2 >= 0) {
                        e3.b.k(e0.h);
                        MediaCodec.BufferInfo mediaCodec$BufferInfo1 = (MediaCodec.BufferInfo)e0.f.remove();
                        mediaCodec$BufferInfo0.set(mediaCodec$BufferInfo1.offset, mediaCodec$BufferInfo1.size, mediaCodec$BufferInfo1.presentationTimeUs, mediaCodec$BufferInfo1.flags);
                    }
                    else if(v2 == -2) {
                        e0.h = (MediaFormat)e0.g.remove();
                    }
                    return v2;
                }
                return -1;
            }
            return -1;
        }
        return v2;
    }

    public int r() {
        int v;
        synchronized(this.d) {
            v = this.b;
            this.b = v + 1;
        }
        return v;
    }

    @Override  // o3.j
    public void release() {
        if(this.a != 1) {
            try {
                if(this.b == 1) {
                    ((k)this.f).shutdown();
                    o3.e e0 = (o3.e)this.e;
                    synchronized(e0.a) {
                        e0.m = true;
                        e0.b.quit();
                        e0.a();
                    }
                    goto label_18;
                label_14:
                    if(this.c) {
                        throw throwable0;
                    }
                    goto label_15;
                }
                goto label_18;
            }
            catch(Throwable throwable0) {
                goto label_14;
            }
        label_15:
            ((MediaCodec)this.d).release();
            this.c = true;
            throw throwable0;
        label_18:
            this.b = 2;
            if(!this.c) {
                ((MediaCodec)this.d).release();
                this.c = true;
            }
            return;
        }
        synchronized(this.d) {
            this.c = true;
            ArrayList arrayList0 = new ArrayList(((f)this.e).values());
            ((f)this.e).clear();
            if(((l)this.f) != null) {
                Handler handler0 = (Handler)this.g;
                handler0.getClass();
                handler0.post(((l)this.f));
                this.f = null;
                this.g = null;
            }
        }
        for(Object object1: arrayList0) {
            ((r1)object1).m();
        }
    }

    @Override  // o3.j
    public ByteBuffer s(int v) {
        return ((MediaCodec)this.d).getOutputBuffer(v);
    }

    @Override  // o3.j
    public void setVideoScalingMode(int v) {
        ((MediaCodec)this.d).setVideoScalingMode(v);
    }

    public void t(int v, Object object0) {
        synchronized(this.d) {
            r1 r10 = (r1)((f)this.e).remove(v);
            if(r10 != null) {
                if(r10.i.getClass() == object0.getClass()) {
                    r10.k(object0);
                }
                else {
                    e3.b.D("SequencedFutureManager", "Type mismatch, expected " + r10.i.getClass() + ", but was " + object0.getClass());
                }
            }
            if(((l)this.f) != null && ((f)this.e).isEmpty()) {
                this.release();
            }
        }
    }
}

