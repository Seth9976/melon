package o3;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Trace;
import androidx.media3.common.b;
import androidx.media3.exoplayer.C;
import androidx.media3.exoplayer.e;
import androidx.media3.exoplayer.g;
import androidx.media3.exoplayer.l;
import c3.d;
import e3.u;
import e3.x;
import ea.c;
import j3.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import k8.Y;
import kb.D;
import s3.V;
import s3.z;
import y5.a;

public abstract class p extends e {
    public boolean A0;
    public final i B;
    public boolean B0;
    public boolean C0;
    public final h D;
    public boolean D0;
    public final float E;
    public boolean E0;
    public boolean F0;
    public final h3.e G;
    public int G0;
    public int H0;
    public final h3.e I;
    public int I0;
    public boolean J0;
    public boolean K0;
    public boolean L0;
    public final h3.e M;
    public long M0;
    public final f N;
    public long N0;
    public boolean O0;
    public boolean P0;
    public boolean Q0;
    public boolean R0;
    public final MediaCodec.BufferInfo S;
    public l S0;
    public final ArrayDeque T;
    public androidx.media3.exoplayer.f T0;
    public o U0;
    public final v V;
    public long V0;
    public b W;
    public boolean W0;
    public b X;
    public static final byte[] X0;
    public k3.h Y;
    public k3.h Z;
    public C b0;
    public MediaCrypto c0;
    public final long d0;
    public float e0;
    public float f0;
    public j g0;
    public b h0;
    public MediaFormat i0;
    public boolean j0;
    public float k0;
    public ArrayDeque l0;
    public n m0;
    public m n0;
    public int o0;
    public boolean p0;
    public boolean q0;
    public boolean r0;
    public boolean s0;
    public boolean t0;
    public boolean u0;
    public long v0;
    public long w0;
    public int x0;
    public int y0;
    public ByteBuffer z0;

    static {
        p.X0 = new byte[]{0, 0, 1, 103, 66, (byte)0xC0, 11, -38, 37, (byte)0x90, 0, 0, 1, 104, -50, 15, 19, 0x20, 0, 0, 1, 101, -120, (byte)0x84, 13, -50, 0x71, 24, (byte)0xA0, 0, 0x2F, -65, 28, 49, -61, 39, 93, 120};
    }

    public p(int v, i i0, h h0, float f) {
        super(v);
        this.B = i0;
        h0.getClass();
        this.D = h0;
        this.E = f;
        this.G = new h3.e(0);
        this.I = new h3.e(0);
        this.M = new h3.e(2);
        f f1 = new f(2);  // 初始化器: Lh3/e;-><init>(I)V
        f1.l = 0x20;
        this.N = f1;
        this.S = new MediaCodec.BufferInfo();
        this.e0 = 1.0f;
        this.f0 = 1.0f;
        this.d0 = 0x8000000000000001L;
        this.T = new ArrayDeque();
        this.U0 = o.e;
        f1.q(0);
        f1.e.order(ByteOrder.nativeOrder());
        v v1 = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
        v1.a = d.a;
        v1.c = 0;
        v1.b = 2;
        this.V = v1;
        this.k0 = -1.0f;
        this.o0 = 0;
        this.G0 = 0;
        this.x0 = -1;
        this.y0 = -1;
        this.w0 = 0x8000000000000001L;
        this.M0 = 0x8000000000000001L;
        this.N0 = 0x8000000000000001L;
        this.V0 = 0x8000000000000001L;
        this.v0 = 0x8000000000000001L;
        this.H0 = 0;
        this.I0 = 0;
        this.T0 = new androidx.media3.exoplayer.f();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final boolean A(long v, long v1) {
        int v13;
        int v12;
        e3.b.j(!this.P0);
        f f0 = this.N;
        if(f0.t()) {
            ByteBuffer byteBuffer0 = f0.e;
            int v2 = this.y0;
            int v3 = f0.k;
            long v4 = f0.g;
            boolean z = this.R(this.l, f0.j);
            boolean z1 = f0.i(4);
            b b0 = this.X;
            b0.getClass();
            if(!this.f0(v, v1, null, byteBuffer0, v2, 0, v3, v4, z, z1, b0)) {
                return false;
            }
            this.a0(f0.j);
            f0.o();
        }
        if(this.O0) {
            this.P0 = true;
            return false;
        }
        h3.e e0 = this.M;
        if(this.D0) {
            e3.b.j(f0.s(e0));
            this.D0 = false;
        }
        if(this.E0) {
            if(f0.t()) {
                return true;
            }
            this.D();
            this.E0 = false;
            this.S();
            if(!this.C0) {
                return false;
            }
        }
        e3.b.j(!this.O0);
        c c0 = this.c;
        c0.e();
        e0.o();
    alab1:
        while(true) {
            e0.o();
            switch(this.t(c0, e0, 0)) {
                case -5: {
                    this.X(c0);
                    goto label_148;
                }
                case -4: {
                    if(e0.i(4)) {
                        this.O0 = true;
                        this.N0 = this.M0;
                        goto label_148;
                    }
                    this.M0 = Math.max(this.M0, e0.g);
                    if(this.h() || this.I.i(0x20000000)) {
                        this.N0 = this.M0;
                    }
                    byte[] arr_b = null;
                    if(this.Q0) {
                        b b1 = this.W;
                        b1.getClass();
                        this.X = b1;
                        if(Objects.equals(b1.n, "audio/opus") && !this.X.q.isEmpty()) {
                            byte[] arr_b1 = (byte[])this.X.q.get(0);
                            int v5 = arr_b1[10] & 0xFF | (arr_b1[11] & 0xFF) << 8;
                            b b2 = this.X;
                            b2.getClass();
                            b3.n n0 = b2.a();
                            n0.E = v5;
                            this.X = new b(n0);
                        }
                        this.Y(this.X, null);
                        this.Q0 = false;
                    }
                    e0.r();
                    if(this.X != null && Objects.equals(this.X.n, "audio/opus")) {
                        if(e0.i(0x10000000)) {
                            e0.c = this.X;
                            this.P(e0);
                        }
                        if(this.l - e0.g <= 80000L) {
                            b b3 = this.X;
                            b3.getClass();
                            List list0 = b3.q;
                            v v6 = this.V;
                            v6.getClass();
                            e0.e.getClass();
                            if(e0.e.limit() - e0.e.position() != 0) {
                                if(v6.b == 2) {
                                    switch(list0.size()) {
                                        case 1: 
                                        case 3: {
                                            arr_b = (byte[])list0.get(0);
                                        }
                                    }
                                }
                                ByteBuffer byteBuffer1 = e0.e;
                                int v7 = byteBuffer1.position();
                                int v8 = byteBuffer1.limit();
                                int v9 = v8 - v7;
                                int v10 = (v9 + 0xFF) / 0xFF;
                                int v11 = v10 + 27 + v9;
                                if(v6.b == 2) {
                                    v12 = arr_b == null ? 0x2F : arr_b.length + 28;
                                    v11 = v12 + 44 + v11;
                                }
                                else {
                                    v12 = 0;
                                }
                                if(v6.a.capacity() < v11) {
                                    v6.a = ByteBuffer.allocate(v11).order(ByteOrder.LITTLE_ENDIAN);
                                }
                                else {
                                    v6.a.clear();
                                }
                                ByteBuffer byteBuffer2 = v6.a;
                                if(v6.b == 2) {
                                    if(arr_b == null) {
                                        v13 = v8;
                                        byteBuffer2.put(v.d);
                                    }
                                    else {
                                        v.a(byteBuffer2, 0L, 0, 1, true);
                                        v13 = v8;
                                        a.l("out of range: %s", ((long)arr_b.length), ((long)arr_b.length) >> 8 == 0L);
                                        byteBuffer2.put(((byte)(((int)(((long)arr_b.length))))));
                                        byteBuffer2.put(arr_b);
                                        byteBuffer2.putInt(22, x.k(byteBuffer2.array(), byteBuffer2.arrayOffset(), arr_b.length + 28, 0));
                                        byteBuffer2.position(arr_b.length + 28);
                                    }
                                    byteBuffer2.put(v.e);
                                }
                                else {
                                    v13 = v8;
                                }
                                int v14 = byteBuffer1.get(0);
                                int v15 = byteBuffer1.limit() <= 1 ? 0 : byteBuffer1.get(1);
                                int v16 = v6.c + ((int)(B3.b.j(((byte)v14), ((byte)v15)) * 48000L / 1000000L));
                                v6.c = v16;
                                v.a(byteBuffer2, ((long)v16), v6.b, v10, false);
                                for(int v17 = 0; v17 < v10; ++v17) {
                                    if(v9 >= 0xFF) {
                                        byteBuffer2.put(-1);
                                        v9 -= 0xFF;
                                    }
                                    else {
                                        byteBuffer2.put(((byte)v9));
                                        v9 = 0;
                                    }
                                }
                                int v18 = v13;
                                while(v7 < v18) {
                                    byteBuffer2.put(byteBuffer1.get(v7));
                                    ++v7;
                                }
                                byteBuffer1.position(byteBuffer1.limit());
                                byteBuffer2.flip();
                                if(v6.b == 2) {
                                    byteBuffer2.putInt(v12 + 66, x.k(byteBuffer2.array(), byteBuffer2.arrayOffset() + v12 + 44, byteBuffer2.limit() - byteBuffer2.position(), 0));
                                }
                                else {
                                    byteBuffer2.putInt(22, x.k(byteBuffer2.array(), byteBuffer2.arrayOffset(), byteBuffer2.limit() - byteBuffer2.position(), 0));
                                }
                                ++v6.b;
                                v6.a = byteBuffer2;
                                e0.o();
                                e0.q(v6.a.remaining());
                                e0.e.put(v6.a);
                                e0.r();
                            }
                        }
                    }
                    if(f0.t()) {
                        long v19 = this.l;
                        if(this.R(v19, f0.j) == this.R(v19, e0.g)) {
                            goto label_143;
                        }
                        else {
                            break alab1;
                        }
                    }
                    else {
                    label_143:
                        if(f0.s(e0)) {
                            break;
                        }
                        break alab1;
                    }
                    goto label_148;
                }
                case -3: {
                    goto label_146;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
        }
        this.D0 = true;
        goto label_148;
    label_146:
        if(this.h()) {
            this.N0 = this.M0;
        }
    label_148:
        if(f0.t()) {
            f0.r();
        }
        return f0.t() || this.O0 || this.E0;
    }

    public abstract g B(m arg1, b arg2, b arg3);

    public o3.l C(IllegalStateException illegalStateException0, m m0) {
        return new o3.l(illegalStateException0, m0);
    }

    public final void D() {
        this.E0 = false;
        this.N.o();
        this.M.o();
        this.D0 = false;
        this.C0 = false;
        this.V.getClass();
        this.V.a = d.a;
        this.V.c = 0;
        this.V.b = 2;
    }

    public final boolean E() {
        if(this.J0) {
            this.H0 = 1;
            if(this.q0) {
                this.I0 = 3;
                return false;
            }
            this.I0 = 2;
            return true;
        }
        this.s0();
        return true;
    }

    public final boolean F(long v, long v1) {
        int v2;
        boolean z2;
        j j0 = this.g0;
        j0.getClass();
        MediaCodec.BufferInfo mediaCodec$BufferInfo0 = this.S;
        if(this.y0 >= 0) {
        label_48:
            if(!this.r0 || !this.K0) {
                ByteBuffer byteBuffer2 = this.z0;
                int v7 = this.y0;
                int v8 = mediaCodec$BufferInfo0.flags;
                long v9 = mediaCodec$BufferInfo0.presentationTimeUs;
                boolean z3 = this.A0;
                boolean z4 = this.B0;
                b b1 = this.X;
                b1.getClass();
                z2 = this.f0(v, v1, j0, byteBuffer2, v7, v8, 1, v9, z3, z4, b1);
            label_72:
                if(z2) {
                    this.a0(mediaCodec$BufferInfo0.presentationTimeUs);
                    boolean z5 = (mediaCodec$BufferInfo0.flags & 4) != 0;
                    if(!z5 && this.K0 && this.B0) {
                        this.g.getClass();
                        this.v0 = System.currentTimeMillis();
                    }
                    this.y0 = -1;
                    this.z0 = null;
                    if(!z5) {
                        return true;
                    }
                    this.e0();
                }
            }
            else {
                try {
                    ByteBuffer byteBuffer1 = this.z0;
                    int v4 = this.y0;
                    int v5 = mediaCodec$BufferInfo0.flags;
                    long v6 = mediaCodec$BufferInfo0.presentationTimeUs;
                    boolean z = this.A0;
                    boolean z1 = this.B0;
                    b b0 = this.X;
                    b0.getClass();
                    z2 = this.f0(v, v1, j0, byteBuffer1, v4, v5, 1, v6, z, z1, b0);
                    goto label_72;
                }
                catch(IllegalStateException unused_ex) {
                    this.e0();
                    if(this.P0) {
                        this.h0();
                        return false;
                    }
                }
            }
        }
        else if(this.r0 && this.K0) {
            try {
                v2 = j0.q(mediaCodec$BufferInfo0);
                goto label_12;
            }
            catch(IllegalStateException unused_ex) {
                this.e0();
                if(this.P0) {
                    this.h0();
                    return false;
                }
            }
        }
        else {
            v2 = j0.q(mediaCodec$BufferInfo0);
        label_12:
            if(v2 < 0) {
                if(v2 == -2) {
                    this.L0 = true;
                    j j1 = this.g0;
                    j1.getClass();
                    MediaFormat mediaFormat0 = j1.e();
                    if(this.o0 != 0 && mediaFormat0.getInteger("width") == 0x20 && mediaFormat0.getInteger("height") == 0x20) {
                        this.t0 = true;
                        return true;
                    }
                    this.i0 = mediaFormat0;
                    this.j0 = true;
                    return true;
                }
                if(this.u0 && (this.O0 || this.H0 == 2)) {
                    this.e0();
                }
                long v3 = this.v0;
                if(v3 != 0x8000000000000001L) {
                    this.g.getClass();
                    if(v3 + 100L < System.currentTimeMillis()) {
                        this.e0();
                        return false;
                    }
                }
            }
            else {
                if(this.t0) {
                    this.t0 = false;
                    j0.k(v2);
                    return true;
                }
                if(mediaCodec$BufferInfo0.size == 0 && (mediaCodec$BufferInfo0.flags & 4) != 0) {
                    this.e0();
                    return false;
                }
                this.y0 = v2;
                ByteBuffer byteBuffer0 = j0.s(v2);
                this.z0 = byteBuffer0;
                if(byteBuffer0 != null) {
                    byteBuffer0.position(mediaCodec$BufferInfo0.offset);
                    this.z0.limit(mediaCodec$BufferInfo0.offset + mediaCodec$BufferInfo0.size);
                }
                this.A0 = mediaCodec$BufferInfo0.presentationTimeUs < this.l;
                this.B0 = this.N0 != 0x8000000000000001L && this.N0 <= mediaCodec$BufferInfo0.presentationTimeUs;
                this.t0(mediaCodec$BufferInfo0.presentationTimeUs);
                goto label_48;
            }
        }
        return false;
    }

    public final boolean G() {
        j j0 = this.g0;
        if(j0 != null && this.H0 != 2 && !this.O0) {
            h3.e e0 = this.I;
            if(this.x0 < 0) {
                int v = j0.o();
                this.x0 = v;
                if(v >= 0) {
                    e0.e = j0.h(v);
                    e0.o();
                    goto label_9;
                }
            }
            else {
            label_9:
                if(this.H0 == 1) {
                    if(!this.u0) {
                        this.K0 = true;
                        j0.d(this.x0, 0, 4, 0L);
                        this.x0 = -1;
                        e0.e = null;
                    }
                    this.H0 = 2;
                    return false;
                }
                if(this.s0) {
                    this.s0 = false;
                    ByteBuffer byteBuffer0 = e0.e;
                    byteBuffer0.getClass();
                    byteBuffer0.put(p.X0);
                    j0.d(this.x0, 38, 0, 0L);
                    this.x0 = -1;
                    e0.e = null;
                    this.J0 = true;
                    return true;
                }
                if(this.G0 == 1) {
                    for(int v1 = 0; true; ++v1) {
                        b b0 = this.h0;
                        b0.getClass();
                        if(v1 >= b0.q.size()) {
                            break;
                        }
                        byte[] arr_b = (byte[])this.h0.q.get(v1);
                        ByteBuffer byteBuffer1 = e0.e;
                        byteBuffer1.getClass();
                        byteBuffer1.put(arr_b);
                    }
                    this.G0 = 2;
                }
                ByteBuffer byteBuffer2 = e0.e;
                byteBuffer2.getClass();
                int v2 = byteBuffer2.position();
                c c0 = this.c;
                c0.e();
                try {
                    switch(this.t(c0, e0, 0)) {
                        case -5: {
                            break;
                        }
                        case -3: {
                            goto label_126;
                        }
                        default: {
                            goto label_56;
                        }
                    }
                }
                catch(h3.d d0) {
                    this.U(d0);
                    this.g0(0);
                    this.H();
                    return true;
                }
                if(this.G0 == 2) {
                    e0.o();
                    this.G0 = 1;
                }
                this.X(c0);
                return true;
            label_56:
                if(!e0.i(4)) {
                    goto label_71;
                }
                this.N0 = this.M0;
                if(this.G0 == 2) {
                    e0.o();
                    this.G0 = 1;
                }
                this.O0 = true;
                if(!this.J0) {
                    this.e0();
                    return false;
                }
                if(!this.u0) {
                    this.K0 = true;
                    j0.d(this.x0, 0, 4, 0L);
                    this.x0 = -1;
                    e0.e = null;
                    return false;
                label_71:
                    if(!this.J0 && !e0.i(1)) {
                        e0.o();
                        if(this.G0 == 2) {
                            this.G0 = 1;
                        }
                        return true;
                    }
                    if(this.o0(e0)) {
                        e0.o();
                        ++this.T0.d;
                        return true;
                    }
                    boolean z = e0.i(0x40000000);
                    if(z) {
                        h3.b b1 = e0.d;
                        if(v2 == 0) {
                            b1.getClass();
                        }
                        else {
                            if(b1.d == null) {
                                int[] arr_v = new int[1];
                                b1.d = arr_v;
                                b1.i.numBytesOfClearData = arr_v;
                            }
                            b1.d[0] += v2;
                        }
                    }
                    long v3 = e0.g;
                    if(this.Q0) {
                        ArrayDeque arrayDeque0 = this.T;
                        if(arrayDeque0.isEmpty()) {
                            u u1 = this.U0.d;
                            b b3 = this.W;
                            b3.getClass();
                            u1.b(v3, b3);
                        }
                        else {
                            u u0 = ((o)arrayDeque0.peekLast()).d;
                            b b2 = this.W;
                            b2.getClass();
                            u0.b(v3, b2);
                        }
                        this.Q0 = false;
                    }
                    this.M0 = Math.max(this.M0, v3);
                    if(this.h() || e0.i(0x20000000)) {
                        this.N0 = this.M0;
                    }
                    e0.r();
                    if(e0.i(0x10000000)) {
                        this.P(e0);
                    }
                    this.c0(e0);
                    int v4 = this.K(e0);
                    if(z) {
                        j0.a(this.x0, e0.d, v3, v4);
                    }
                    else {
                        int v5 = this.x0;
                        ByteBuffer byteBuffer3 = e0.e;
                        byteBuffer3.getClass();
                        j0.d(v5, byteBuffer3.limit(), v4, v3);
                    }
                    this.x0 = -1;
                    e0.e = null;
                    this.J0 = true;
                    this.G0 = 0;
                    ++this.T0.c;
                    return true;
                label_126:
                    if(this.h()) {
                        this.N0 = this.M0;
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public final void H() {
        try {
            j j0 = this.g0;
            e3.b.k(j0);
            j0.flush();
        }
        finally {
            this.j0();
        }
    }

    public final boolean I() {
        if(this.g0 == null) {
            return false;
        }
        int v = this.I0;
        if(v != 3 && (!this.p0 || this.L0) && (!this.q0 || !this.K0)) {
            if(v == 2) {
                e3.b.j(true);
                try {
                    this.s0();
                }
                catch(l l0) {
                    e3.b.E("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", l0);
                    this.h0();
                    return true;
                }
            }
            this.H();
            return false;
        }
        this.h0();
        return true;
    }

    public final List J(boolean z) {
        b b0 = this.W;
        b0.getClass();
        h h0 = this.D;
        List list0 = this.N(h0, b0, z);
        if(((ArrayList)list0).isEmpty() && z) {
            List list1 = this.N(h0, b0, false);
            if(!((ArrayList)list1).isEmpty()) {
                e3.b.D("MediaCodecRenderer", "Drm session requires secure decoder for " + b0.n + ", but no secure decoder available. Trying to proceed with " + list1 + ".");
            }
            return list1;
        }
        return list0;
    }

    public int K(h3.e e0) {
        return 0;
    }

    public boolean L() {
        return false;
    }

    public abstract float M(float arg1, b[] arg2);

    public abstract ArrayList N(h arg1, b arg2, boolean arg3);

    public abstract E9.u O(m arg1, b arg2, MediaCrypto arg3, float arg4);

    public abstract void P(h3.e arg1);

    public final void Q(m m0, MediaCrypto mediaCrypto0) {
        b b0 = this.W;
        b0.getClass();
        String s = m0.a;
        float f = -1.0f;
        float f1 = this.f0;
        b[] arr_b = this.j;
        arr_b.getClass();
        float f2 = this.M(f1, arr_b);
        if(f2 > this.E) {
            f = f2;
        }
        this.d0(b0);
        this.g.getClass();
        long v = SystemClock.elapsedRealtime();
        E9.u u0 = this.O(m0, b0, mediaCrypto0, f);
        i3.l l0 = this.f;
        l0.getClass();
        l0.b.getClass();
        LogSessionId logSessionId0 = l0.b.a;
        if(!i3.i.z(logSessionId0)) {
            ((MediaFormat)u0.b).setString("log-session-id", logSessionId0.getStringId());
        }
        try {
            Trace.beginSection(("createCodec:" + s));
            j j0 = this.B.j(u0);
            this.g0 = j0;
            j0.g(new D(this, 22));
        }
        finally {
            Trace.endSection();
        }
        this.g.getClass();
        long v2 = SystemClock.elapsedRealtime();
        if(!m0.d(b0)) {
            e3.b.D("MediaCodecRenderer", Y.k("Format exceeds selected codec\'s capabilities [", b.d(b0), ", ", s, "]"));
        }
        this.n0 = m0;
        this.k0 = f;
        this.h0 = b0;
        boolean z = false;
        this.o0 = 0;
        this.p0 = false;
        this.q0 = false;
        this.r0 = false;
        if("Amazon".equals(x.c) && "AFTS".equals(x.d) && m0.f || this.L()) {
            z = true;
        }
        this.u0 = z;
        this.g0.getClass();
        if(this.h == 2) {
            this.g.getClass();
            this.w0 = SystemClock.elapsedRealtime() + 1000L;
        }
        ++this.T0.a;
        this.V(s, v2, v2 - v);
    }

    public final boolean R(long v, long v1) {
        return v1 < v && (this.X == null || !Objects.equals(this.X.n, "audio/opus") || v - v1 > 80000L);
    }

    public final void S() {
        if(this.g0 == null && !this.C0) {
            b b0 = this.W;
            if(b0 != null) {
                String s = b0.n;
                boolean z = true;
                if(this.Z == null && this.p0(b0)) {
                    this.D();
                    f f0 = this.N;
                    if("audio/mp4a-latm".equals(s) || "audio/mpeg".equals(s) || "audio/opus".equals(s)) {
                        f0.getClass();
                        f0.l = 0x20;
                    }
                    else {
                        f0.getClass();
                        f0.l = 1;
                    }
                    this.C0 = true;
                    return;
                }
                this.l0(this.Z);
                if(this.Y == null) {
                    try {
                    label_36:
                        if(this.Y == null || this.Y.getState() != 3 && this.Y.getState() != 4) {
                            z = false;
                        }
                        else {
                            k3.h h1 = this.Y;
                            e3.b.k(s);
                            if(!h1.e(s)) {
                                z = false;
                            }
                        }
                        this.T(this.c0, z);
                        goto label_47;
                    }
                    catch(n n0) {
                    }
                    throw this.d(n0, b0, false, 4001);
                }
                else {
                    e3.b.j(this.c0 == null);
                    k3.h h0 = this.Y;
                    h3.a a0 = h0.c();
                    if(!k3.u.c || !(a0 instanceof k3.u)) {
                    label_27:
                        if(a0 != null) {
                            if(a0 instanceof k3.u) {
                                k3.u u0 = (k3.u)a0;
                                try {
                                    this.c0 = new MediaCrypto(u0.a, u0.b);
                                }
                                catch(MediaCryptoException mediaCryptoException0) {
                                    throw this.d(mediaCryptoException0, this.W, false, 6006);
                                }
                            }
                            goto label_36;
                        }
                        else if(h0.getError() != null) {
                            goto label_36;
                        }
                    }
                    else {
                        switch(h0.getState()) {
                            case 1: {
                                k3.g g0 = h0.getError();
                                g0.getClass();
                                throw this.d(g0, this.W, false, g0.a);
                            }
                            case 4: {
                                goto label_27;
                            }
                        }
                    }
                }
            label_47:
                MediaCrypto mediaCrypto0 = this.c0;
                if(mediaCrypto0 != null && this.g0 == null) {
                    mediaCrypto0.release();
                    this.c0 = null;
                }
            }
        }
    }

    public final void T(MediaCrypto mediaCrypto0, boolean z) {
        b b0 = this.W;
        b0.getClass();
        if(this.l0 == null) {
            try {
                List list0 = this.J(z);
                this.l0 = new ArrayDeque();
                if(!((ArrayList)list0).isEmpty()) {
                    this.l0.add(((m)((ArrayList)list0).get(0)));
                }
                this.m0 = null;
                goto label_11;
            }
            catch(s s0) {
            }
            throw new n(b0, s0, z, 0xFFFF3CB2);
        }
    label_11:
        if(this.l0.isEmpty()) {
            throw new n(b0, null, z, 0xFFFF3CB1);
        }
        ArrayDeque arrayDeque0 = this.l0;
        arrayDeque0.getClass();
        while(this.g0 == null) {
            m m0 = (m)arrayDeque0.peekFirst();
            m0.getClass();
            if(!this.n0(m0)) {
                return;
            }
            try {
                this.Q(m0, mediaCrypto0);
            }
            catch(Exception exception0) {
                e3.b.E("MediaCodecRenderer", "Failed to initialize decoder: " + m0, exception0);
                arrayDeque0.removeFirst();
                String s1 = exception0 instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException)exception0).getDiagnosticInfo() : null;
                n n0 = new n("Decoder init failed: " + m0.a + ", " + b0, exception0, b0.n, z, m0, s1);
                this.U(n0);
                n n1 = this.m0;
                this.m0 = n1 == null ? n0 : new n(n1.getMessage(), n1.getCause(), n1.a, n1.b, n1.c, n1.d);
                if(arrayDeque0.isEmpty()) {
                    throw this.m0;
                }
                if(false) {
                    break;
                }
            }
        }
        this.l0 = null;
    }

    public abstract void U(Exception arg1);

    public abstract void V(String arg1, long arg2, long arg3);

    public abstract void W(String arg1);

    public g X(c c0) {
        b b1;
        boolean z = true;
        this.Q0 = true;
        b b0 = (b)c0.c;
        b0.getClass();
        String s = b0.n;
        if(s == null) {
            throw this.d(new IllegalArgumentException("Sample MIME type is null."), b0, false, 4005);
        }
        if(!s.equals("video/av01") || b0.q.isEmpty()) {
            b1 = b0;
        }
        else {
            b3.n n0 = b0.a();
            n0.p = null;
            b1 = new b(n0);
        }
        k3.h h0 = (k3.h)c0.b;
        k3.h h1 = this.Z;
        if(h1 != h0) {
            if(h0 != null) {
                h0.a(null);
            }
            if(h1 != null) {
                h1.d(null);
            }
        }
        this.Z = h0;
        this.W = b1;
        if(this.C0) {
            this.E0 = true;
            return null;
        }
        j j0 = this.g0;
        if(j0 == null) {
            this.l0 = null;
            this.S();
            return null;
        }
        m m0 = this.n0;
        m0.getClass();
        b b2 = this.h0;
        b2.getClass();
        k3.h h2 = this.Y;
        k3.h h3 = this.Z;
        if(h2 != h3) {
            if(h3 == null || h2 == null) {
                goto label_48;
            }
            h3.a a0 = h3.c();
            if(a0 == null) {
                goto label_48;
            }
            h3.a a1 = h2.c();
            if(a1 == null || !a0.getClass().equals(a1.getClass())) {
                goto label_48;
            }
            if(a0 instanceof k3.u) {
                if(!h3.b().equals(h2.b()) || (b3.h.e.equals(h2.b()) || b3.h.e.equals(h3.b()))) {
                    goto label_48;
                }
                if(!m0.f) {
                    switch(h3.getState()) {
                        case 2: {
                        label_48:
                            if(this.J0) {
                                this.H0 = 1;
                                this.I0 = 3;
                                return new g(m0.a, b2, b1, 0, 0x80);
                            }
                            this.h0();
                            this.S();
                            return new g(m0.a, b2, b1, 0, 0x80);
                        }
                        case 3: 
                        case 4: {
                            b1.n.getClass();
                            if(h3.e(b1.n)) {
                                goto label_48;
                            }
                        }
                    }
                }
            }
        }
        boolean z1 = this.Z != this.Y;
        int v = 16;
        e3.b.j(true);
        g g0 = this.B(m0, b2, b1);
        int v1 = g0.d;
        if(v1 == 0) {
            if(this.J0) {
                this.H0 = 1;
                this.I0 = 3;
            }
            else {
                this.h0();
                this.S();
            }
            v = 0;
        }
        else {
            switch(v1) {
                case 1: {
                    if(this.r0(b1)) {
                        this.h0 = b1;
                        if(z1) {
                            if(!this.E()) {
                                return this.g0 == j0 && this.I0 != 3 ? g0 : new g(m0.a, b2, b1, 0, 2);
                            }
                        }
                        else if(this.J0) {
                            this.H0 = 1;
                            if(this.q0) {
                                this.I0 = 3;
                                return new g(m0.a, b2, b1, 0, 2);
                            }
                            this.I0 = 1;
                        }
                        return this.g0 == j0 && this.I0 != 3 ? g0 : new g(m0.a, b2, b1, 0, 0);
                    }
                    break;
                }
                case 2: {
                    if(this.r0(b1)) {
                        this.F0 = true;
                        this.G0 = 1;
                        if(this.o0 != 2 && (this.o0 != 1 || b1.u != b2.u || b1.v != b2.v)) {
                            z = false;
                        }
                        this.s0 = z;
                        this.h0 = b1;
                        if(z1 && !this.E()) {
                            return this.g0 == j0 && this.I0 != 3 ? g0 : new g(m0.a, b2, b1, 0, 2);
                        }
                        return this.g0 == j0 && this.I0 != 3 ? g0 : new g(m0.a, b2, b1, 0, 0);
                    }
                    break;
                }
                case 3: {
                    if(this.r0(b1)) {
                        this.h0 = b1;
                        if(z1 && !this.E()) {
                            return this.g0 == j0 && this.I0 != 3 ? g0 : new g(m0.a, b2, b1, 0, 2);
                        }
                        return this.g0 == j0 && this.I0 != 3 ? g0 : new g(m0.a, b2, b1, 0, 0);
                    }
                    break;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
        }
        return v1 == 0 || this.g0 == j0 && this.I0 != 3 ? g0 : new g(m0.a, b2, b1, 0, v);
    }

    public abstract void Y(b arg1, MediaFormat arg2);

    public void Z() {
    }

    public void a0(long v) {
        this.V0 = v;
        while(true) {
            ArrayDeque arrayDeque0 = this.T;
            if(arrayDeque0.isEmpty() || v < ((o)arrayDeque0.peek()).a) {
                break;
            }
            o o0 = (o)arrayDeque0.poll();
            o0.getClass();
            this.m0(o0);
            this.b0();
        }
    }

    public abstract void b0();

    public void c0(h3.e e0) {
    }

    public void d0(b b0) {
    }

    public final void e0() {
        switch(this.I0) {
            case 1: {
                this.H();
                return;
            }
            case 2: {
                this.H();
                this.s0();
                return;
            }
            case 3: {
                this.h0();
                this.S();
                return;
            }
            default: {
                this.P0 = true;
                this.i0();
            }
        }
    }

    public abstract boolean f0(long arg1, long arg2, j arg3, ByteBuffer arg4, int arg5, int arg6, int arg7, long arg8, boolean arg9, boolean arg10, b arg11);

    public final boolean g0(int v) {
        c c0 = this.c;
        c0.e();
        h3.e e0 = this.G;
        e0.o();
        int v1 = this.t(c0, e0, v | 4);
        if(v1 == -5) {
            this.X(c0);
            return true;
        }
        if(v1 == -4 && e0.i(4)) {
            this.O0 = true;
            this.e0();
        }
        return false;
    }

    public final void h0() {
        try {
            j j0 = this.g0;
            if(j0 != null) {
                j0.release();
                ++this.T0.b;
                m m0 = this.n0;
                m0.getClass();
                this.W(m0.a);
            }
        }
        catch(Throwable throwable0) {
            try {
                this.g0 = null;
                MediaCrypto mediaCrypto0 = this.c0;
                if(mediaCrypto0 != null) {
                    mediaCrypto0.release();
                }
            }
            throw throwable0;
        }
        finally {
            this.c0 = null;
            this.l0(null);
            this.k0();
        }
        this.g0 = null;
        MediaCrypto mediaCrypto1 = this.c0;
        if(mediaCrypto1 != null) {
            mediaCrypto1.release();
        }
    }

    public void i0() {
    }

    public void j0() {
        this.x0 = -1;
        this.I.e = null;
        this.y0 = -1;
        this.z0 = null;
        this.w0 = 0x8000000000000001L;
        this.K0 = false;
        this.v0 = 0x8000000000000001L;
        this.J0 = false;
        this.s0 = false;
        this.t0 = false;
        this.A0 = false;
        this.B0 = false;
        this.M0 = 0x8000000000000001L;
        this.N0 = 0x8000000000000001L;
        this.V0 = 0x8000000000000001L;
        this.H0 = 0;
        this.I0 = 0;
        this.G0 = this.F0;
    }

    @Override  // androidx.media3.exoplayer.e
    public boolean k() {
        boolean z;
        if(this.W != null) {
            if(this.h()) {
                z = this.n;
            }
            else {
                V v0 = this.i;
                v0.getClass();
                z = v0.isReady();
            }
            if(z || this.y0 >= 0) {
                return true;
            }
            if(this.w0 != 0x8000000000000001L) {
                this.g.getClass();
                return SystemClock.elapsedRealtime() < this.w0;
            }
        }
        return false;
    }

    public final void k0() {
        this.j0();
        this.S0 = null;
        this.l0 = null;
        this.n0 = null;
        this.h0 = null;
        this.i0 = null;
        this.j0 = false;
        this.L0 = false;
        this.k0 = -1.0f;
        this.o0 = 0;
        this.p0 = false;
        this.q0 = false;
        this.r0 = false;
        this.u0 = false;
        this.F0 = false;
        this.G0 = 0;
    }

    @Override  // androidx.media3.exoplayer.e
    public void l() {
        this.W = null;
        this.m0(o.e);
        this.T.clear();
        this.I();
    }

    public final void l0(k3.h h0) {
        k3.h h1 = this.Y;
        if(h1 != h0) {
            if(h0 != null) {
                h0.a(null);
            }
            if(h1 != null) {
                h1.d(null);
            }
        }
        this.Y = h0;
    }

    public final void m0(o o0) {
        this.U0 = o0;
        if(o0.c != 0x8000000000000001L) {
            this.W0 = true;
            this.Z();
        }
    }

    @Override  // androidx.media3.exoplayer.e
    public void n(long v, boolean z) {
        this.O0 = false;
        this.P0 = false;
        this.R0 = false;
        if(this.C0) {
            this.N.o();
            this.M.o();
            this.D0 = false;
            this.V.getClass();
            this.V.a = d.a;
            this.V.c = 0;
            this.V.b = 2;
        }
        else if(this.I()) {
            this.S();
        }
        if(this.U0.d.k() > 0) {
            this.Q0 = true;
        }
        this.U0.d.d();
        this.T.clear();
    }

    public boolean n0(m m0) {
        return true;
    }

    public boolean o0(h3.e e0) {
        return false;
    }

    public boolean p0(b b0) {
        return false;
    }

    public abstract int q0(h arg1, b arg2);

    public final boolean r0(b b0) {
        if(this.g0 != null && this.I0 != 3 && this.h != 0) {
            float f = this.f0;
            b0.getClass();
            b[] arr_b = this.j;
            arr_b.getClass();
            float f1 = this.M(f, arr_b);
            float f2 = this.k0;
            if(f2 != f1) {
                if(f1 == -1.0f) {
                    if(this.J0) {
                        this.H0 = 1;
                        this.I0 = 3;
                        return false;
                    }
                    this.h0();
                    this.S();
                    return false;
                }
                if(f2 != -1.0f || f1 > this.E) {
                    Bundle bundle0 = new Bundle();
                    bundle0.putFloat("operating-rate", f1);
                    j j0 = this.g0;
                    j0.getClass();
                    j0.c(bundle0);
                    this.k0 = f1;
                }
            }
        }
        return true;
    }

    @Override  // androidx.media3.exoplayer.e
    public void s(b[] arr_b, long v, long v1, z z0) {
        if(this.U0.c == 0x8000000000000001L) {
            this.m0(new o(0x8000000000000001L, v, v1));
            return;
        }
        ArrayDeque arrayDeque0 = this.T;
        if(arrayDeque0.isEmpty() && (this.M0 == 0x8000000000000001L || this.V0 != 0x8000000000000001L && this.V0 >= this.M0)) {
            this.m0(new o(0x8000000000000001L, v, v1));
            if(this.U0.c != 0x8000000000000001L) {
                this.b0();
            }
            return;
        }
        arrayDeque0.add(new o(this.M0, v, v1));
    }

    public final void s0() {
        k3.h h0 = this.Z;
        h0.getClass();
        h3.a a0 = h0.c();
        if(a0 instanceof k3.u) {
            try {
                MediaCrypto mediaCrypto0 = this.c0;
                mediaCrypto0.getClass();
                mediaCrypto0.setMediaDrmSession(((k3.u)a0).b);
            }
            catch(MediaCryptoException mediaCryptoException0) {
                throw this.d(mediaCryptoException0, this.W, false, 6006);
            }
        }
        this.l0(this.Z);
        this.H0 = 0;
        this.I0 = 0;
    }

    public final void t0(long v) {
        b b0 = (b)this.U0.d.i(v);
        if(b0 == null && this.W0 && this.i0 != null) {
            b0 = (b)this.U0.d.h();
        }
        if(b0 != null) {
            this.X = b0;
            goto label_7;
        }
        else if(this.j0 && this.X != null) {
        label_7:
            b b1 = this.X;
            b1.getClass();
            this.Y(b1, this.i0);
            this.j0 = false;
            this.W0 = false;
        }
    }

    @Override  // androidx.media3.exoplayer.e
    public void u(long v, long v1) {
        boolean z2;
        boolean z1;
        boolean z = false;
        if(this.R0) {
            this.R0 = false;
            this.e0();
        }
        l l0 = this.S0;
        if(l0 == null) {
            try {
                if(this.P0) {
                    this.i0();
                    return;
                }
                if(this.W == null && !this.g0(2)) {
                    return;
                }
                this.S();
                if(!this.C0) {
                    if(this.g0 != null) {
                        this.g.getClass();
                        long v2 = SystemClock.elapsedRealtime();
                        Trace.beginSection("drainAndFeed");
                        while(this.F(v, v1)) {
                            long v3 = this.d0;
                            if(v3 == 0x8000000000000001L) {
                                z1 = true;
                            }
                            else {
                                this.g.getClass();
                                if(SystemClock.elapsedRealtime() - v2 >= v3) {
                                    z1 = false;
                                }
                            }
                            if(!z1) {
                                break;
                            }
                        }
                        while(this.G()) {
                            long v4 = this.d0;
                            if(v4 == 0x8000000000000001L) {
                                z2 = true;
                            }
                            else {
                                this.g.getClass();
                                if(SystemClock.elapsedRealtime() - v2 >= v4) {
                                    z2 = false;
                                }
                            }
                            if(!z2) {
                                break;
                            }
                        }
                        Trace.endSection();
                        return;
                    }
                    androidx.media3.exoplayer.f f0 = this.T0;
                    int v5 = f0.d;
                    V v6 = this.i;
                    v6.getClass();
                    f0.d = v5 + v6.skipData(v - this.k);
                    this.g0(1);
                    return;
                }
                Trace.beginSection("bypassRender");
                while(true) {
                    if(!this.A(v, v1)) {
                        Trace.endSection();
                        return;
                    }
                }
                goto label_53;
            }
            catch(MediaCodec.CryptoException mediaCodec$CryptoException0) {
            }
            catch(IllegalStateException illegalStateException0) {
                goto label_53;
            }
            throw this.d(mediaCodec$CryptoException0, this.W, false, x.v(mediaCodec$CryptoException0.getErrorCode()));
        label_53:
            if(!(illegalStateException0 instanceof MediaCodec.CodecException)) {
                StackTraceElement[] arr_stackTraceElement = illegalStateException0.getStackTrace();
                if(arr_stackTraceElement.length <= 0 || !arr_stackTraceElement[0].getClassName().equals("android.media.MediaCodec")) {
                    throw illegalStateException0;
                }
            }
            this.U(illegalStateException0);
            if(illegalStateException0 instanceof MediaCodec.CodecException && ((MediaCodec.CodecException)illegalStateException0).isRecoverable()) {
                z = true;
                this.h0();
            }
            o3.l l1 = this.C(illegalStateException0, this.n0);
            throw this.d(l1, this.W, z, (l1.a == 1101 ? 4006 : 4003));
        }
        this.S0 = null;
        throw l0;
    }

    @Override  // androidx.media3.exoplayer.e
    public void x(float f, float f1) {
        this.e0 = f;
        this.f0 = f1;
        this.r0(this.h0);
    }

    @Override  // androidx.media3.exoplayer.e
    public final int y(b b0) {
        try {
            return this.q0(this.D, b0);
        }
        catch(s s0) {
            throw this.d(s0, b0, false, 4002);
        }
    }

    @Override  // androidx.media3.exoplayer.e
    public final int z() {
        return 8;
    }
}

