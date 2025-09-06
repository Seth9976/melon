package o3;

import Vd.w;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.media3.exoplayer.C;
import java.util.ArrayDeque;
import kb.D;

public final class e extends MediaCodec.Callback {
    public final Object a;
    public final HandlerThread b;
    public Handler c;
    public final w d;
    public final w e;
    public final ArrayDeque f;
    public final ArrayDeque g;
    public MediaFormat h;
    public MediaFormat i;
    public MediaCodec.CodecException j;
    public MediaCodec.CryptoException k;
    public long l;
    public boolean m;
    public IllegalStateException n;
    public D o;

    public e(HandlerThread handlerThread0) {
        this.a = new Object();
        this.b = handlerThread0;
        this.d = new w();
        this.e = new w();
        this.f = new ArrayDeque();
        this.g = new ArrayDeque();
    }

    public final void a() {
        ArrayDeque arrayDeque0 = this.g;
        if(!arrayDeque0.isEmpty()) {
            this.i = (MediaFormat)arrayDeque0.getLast();
        }
        this.d.c = this.d.b;
        this.e.c = this.e.b;
        this.f.clear();
        arrayDeque0.clear();
    }

    @Override  // android.media.MediaCodec$Callback
    public final void onCryptoError(MediaCodec mediaCodec0, MediaCodec.CryptoException mediaCodec$CryptoException0) {
        synchronized(this.a) {
            this.k = mediaCodec$CryptoException0;
        }
    }

    @Override  // android.media.MediaCodec$Callback
    public final void onError(MediaCodec mediaCodec0, MediaCodec.CodecException mediaCodec$CodecException0) {
        synchronized(this.a) {
            this.j = mediaCodec$CodecException0;
        }
    }

    @Override  // android.media.MediaCodec$Callback
    public final void onInputBufferAvailable(MediaCodec mediaCodec0, int v) {
        synchronized(this.a) {
            this.d.b(v);
            D d0 = this.o;
            if(d0 != null) {
                C c0 = ((p)d0.b).b0;
                if(c0 != null) {
                    c0.a();
                }
            }
        }
    }

    @Override  // android.media.MediaCodec$Callback
    public final void onOutputBufferAvailable(MediaCodec mediaCodec0, int v, MediaCodec.BufferInfo mediaCodec$BufferInfo0) {
        synchronized(this.a) {
            MediaFormat mediaFormat0 = this.i;
            if(mediaFormat0 != null) {
                this.e.b(-2);
                this.g.add(mediaFormat0);
                this.i = null;
            }
            this.e.b(v);
            this.f.add(mediaCodec$BufferInfo0);
            D d0 = this.o;
            if(d0 != null) {
                C c0 = ((p)d0.b).b0;
                if(c0 != null) {
                    c0.a();
                }
            }
        }
    }

    @Override  // android.media.MediaCodec$Callback
    public final void onOutputFormatChanged(MediaCodec mediaCodec0, MediaFormat mediaFormat0) {
        synchronized(this.a) {
            this.e.b(-2);
            this.g.add(mediaFormat0);
            this.i = null;
        }
    }
}

