package o3;

import Bb.e;
import S8.b;
import android.media.MediaCodec.CryptoInfo.Pattern;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec;
import android.os.Bundle;
import android.os.HandlerThread;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public final class d implements k {
    public final MediaCodec a;
    public final HandlerThread b;
    public e c;
    public final AtomicReference d;
    public final b e;
    public boolean f;
    public static final ArrayDeque g;
    public static final Object h;

    static {
        d.g = new ArrayDeque();
        d.h = new Object();
    }

    public d(MediaCodec mediaCodec0, HandlerThread handlerThread0) {
        b b0 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
        super();
        this.a = mediaCodec0;
        this.b = handlerThread0;
        this.e = b0;
        this.d = new AtomicReference();
    }

    @Override  // o3.k
    public final void a(int v, h3.b b0, long v1, int v2) {
        this.b();
        c c0 = d.e();
        c0.a = v;
        c0.b = 0;
        c0.d = v1;
        c0.e = v2;
        MediaCodec.CryptoInfo mediaCodec$CryptoInfo0 = c0.c;
        mediaCodec$CryptoInfo0.numSubSamples = b0.f;
        int[] arr_v = b0.d;
        int[] arr_v1 = mediaCodec$CryptoInfo0.numBytesOfClearData;
        if(arr_v != null) {
            if(arr_v1 == null || arr_v1.length < arr_v.length) {
                arr_v1 = Arrays.copyOf(arr_v, arr_v.length);
            }
            else {
                System.arraycopy(arr_v, 0, arr_v1, 0, arr_v.length);
            }
        }
        mediaCodec$CryptoInfo0.numBytesOfClearData = arr_v1;
        int[] arr_v2 = b0.e;
        int[] arr_v3 = mediaCodec$CryptoInfo0.numBytesOfEncryptedData;
        if(arr_v2 != null) {
            if(arr_v3 == null || arr_v3.length < arr_v2.length) {
                arr_v3 = Arrays.copyOf(arr_v2, arr_v2.length);
            }
            else {
                System.arraycopy(arr_v2, 0, arr_v3, 0, arr_v2.length);
            }
        }
        mediaCodec$CryptoInfo0.numBytesOfEncryptedData = arr_v3;
        byte[] arr_b = b0.b;
        byte[] arr_b1 = mediaCodec$CryptoInfo0.key;
        if(arr_b != null) {
            if(arr_b1 == null || arr_b1.length < arr_b.length) {
                arr_b1 = Arrays.copyOf(arr_b, arr_b.length);
            }
            else {
                System.arraycopy(arr_b, 0, arr_b1, 0, arr_b.length);
            }
        }
        arr_b1.getClass();
        mediaCodec$CryptoInfo0.key = arr_b1;
        byte[] arr_b2 = b0.a;
        byte[] arr_b3 = mediaCodec$CryptoInfo0.iv;
        if(arr_b2 != null) {
            if(arr_b3 == null || arr_b3.length < arr_b2.length) {
                arr_b3 = Arrays.copyOf(arr_b2, arr_b2.length);
            }
            else {
                System.arraycopy(arr_b2, 0, arr_b3, 0, arr_b2.length);
            }
        }
        arr_b3.getClass();
        mediaCodec$CryptoInfo0.iv = arr_b3;
        mediaCodec$CryptoInfo0.mode = b0.c;
        mediaCodec$CryptoInfo0.setPattern(new MediaCodec.CryptoInfo.Pattern(b0.g, b0.h));
        this.c.obtainMessage(2, c0).sendToTarget();
    }

    @Override  // o3.k
    public final void b() {
        RuntimeException runtimeException0 = (RuntimeException)this.d.getAndSet(null);
        if(runtimeException0 != null) {
            throw runtimeException0;
        }
    }

    @Override  // o3.k
    public final void c(Bundle bundle0) {
        this.b();
        this.c.obtainMessage(4, bundle0).sendToTarget();
    }

    @Override  // o3.k
    public final void d(int v, int v1, int v2, long v3) {
        this.b();
        c c0 = d.e();
        c0.a = v;
        c0.b = v1;
        c0.d = v3;
        c0.e = v2;
        this.c.obtainMessage(1, c0).sendToTarget();
    }

    public static c e() {
        ArrayDeque arrayDeque0 = d.g;
        synchronized(arrayDeque0) {
            if(arrayDeque0.isEmpty()) {
                return new c();
            }
        }
        return (c)arrayDeque0.removeFirst();
    }

    @Override  // o3.k
    public final void flush() {
        if(this.f) {
            try {
                e e0 = this.c;
                e0.getClass();
                e0.removeCallbacksAndMessages(null);
                synchronized(this.e) {
                    this.e.a = false;
                }
                e e1 = this.c;
                e1.getClass();
                e1.obtainMessage(3).sendToTarget();
                this.e.a();
            }
            catch(InterruptedException interruptedException0) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(interruptedException0);
            }
        }
    }

    @Override  // o3.k
    public final void shutdown() {
        if(this.f) {
            this.flush();
            this.b.quit();
        }
        this.f = false;
    }

    @Override  // o3.k
    public final void start() {
        if(!this.f) {
            this.b.start();
            this.c = new e(this, this.b.getLooper(), 19);
            this.f = true;
        }
    }
}

