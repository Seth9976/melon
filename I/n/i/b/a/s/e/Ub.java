package i.n.i.b.a.s.e;

import B3.N;
import I.H1;
import I9.b;
import U4.x;
import W.p;
import android.media.AudioAttributes.Builder;
import android.media.AudioAttributes;
import android.media.AudioFormat.Builder;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.media3.session.p0;
import com.google.android.exoplayer2.audio.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import k8.Y;

public final class ub {
    public long A;
    public long B;
    public int C;
    public boolean D;
    public boolean E;
    public long F;
    public float G;
    public float H;
    public A6[] I;
    public ByteBuffer[] J;
    public ByteBuffer K;
    public int L;
    public ByteBuffer M;
    public byte[] N;
    public int O;
    public int P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public int U;
    public G9 V;
    public boolean W;
    public long X;
    public boolean Y;
    public boolean Z;
    public final e5 a;
    public final sa b;
    public final boolean c;
    public final Ia d;
    public final T1 e;
    public final A6[] f;
    public final A6[] g;
    public final ConditionVariable h;
    public final G8 i;
    public final ArrayDeque j;
    public final boolean k;
    public sa l;
    public final H1 m;
    public final H1 n;
    public Ga o;
    public qb p;
    public qb q;
    public AudioTrack r;
    public I4 s;
    public sb t;
    public sb u;
    public x6 v;
    public ByteBuffer w;
    public int x;
    public long y;
    public long z;

    public ub(e5 e50, sa sa0) {
        this.a = e50;
        this.b = sa0;
        this.c = false;
        this.k = false;
        this.h = new ConditionVariable(true);
        this.i = new G8(new Ga(this, 1));
        Ia ia0 = new Ia();  // 初始化器: Li/n/i/b/a/s/e/W9;-><init>()V
        this.d = ia0;
        T1 t10 = new T1();  // 初始化器: Li/n/i/b/a/s/e/W9;-><init>()V
        t10.m = L7.g;
        this.e = t10;
        ArrayList arrayList0 = new ArrayList();
        Collections.addAll(arrayList0, new W9[]{new j(), ia0, t10});  // 初始化器: Li/n/i/b/a/s/e/W9;-><init>()V
        Collections.addAll(arrayList0, ((A6[])sa0.b));
        this.f = (A6[])arrayList0.toArray(new A6[0]);
        this.g = new A6[]{new Cc()};  // 初始化器: Li/n/i/b/a/s/e/W9;-><init>()V
        this.G = 1.0f;
        this.H = 1.0f;
        this.s = I4.b;
        this.U = 0;
        this.V = new G9();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.u = new sb(x6.d, false, 0L, 0L);
        this.v = x6.d;
        this.P = -1;
        this.I = new A6[0];
        this.J = new ByteBuffer[0];
        this.j = new ArrayDeque();
        this.m = new H1(9);
        this.n = new H1(9);
    }

    public final boolean a() {
        if(!this.W && "audio/raw".equals(((u)this.q.h).l)) {
            int v = ((u)this.q.h).V;
            return !this.c || v != 4 && v != 0x20000000 && v != 0x30000000;
        }
        return false;
    }

    public static Pair b(u u0, e5 e50) {
        int v3;
        if(e50 != null) {
            int[] arr_v = e50.a;
            u0.l.getClass();
            int v = mb.d(u0.l, u0.i);
            int v1 = 6;
            if(v == 5 || v == 6 || v == 18 || (v == 7 || v == 8 || v == 17) || v == 14) {
                if(v == 18 && Arrays.binarySearch(arr_v, 18) < 0) {
                    v = 6;
                }
                else if(v == 8 && Arrays.binarySearch(arr_v, 8) < 0) {
                    v = 7;
                }
                if(Arrays.binarySearch(arr_v, v) < 0) {
                    return null;
                }
                if(v == 18) {
                    if(L7.a >= 29) {
                        int v2 = u0.T;
                        AudioAttributes audioAttributes0 = new AudioAttributes.Builder().setUsage(1).setContentType(3).build();
                        for(v3 = 8; true; --v3) {
                            if(v3 <= 0) {
                                v3 = 0;
                                break;
                            }
                            if(AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(18).setSampleRate(v2).setChannelMask(L7.b(v3)).build(), audioAttributes0)) {
                                break;
                            }
                        }
                        if(v3 != 0) {
                            goto label_30;
                        }
                        Log.w("DefaultAudioSink", "E-AC3 JOC encoding supported but no channel count supported");
                        return null;
                    }
                    v3 = 6;
                    goto label_30;
                }
                v3 = u0.S;
                if(v3 <= e50.b) {
                label_30:
                    int v4 = L7.a;
                    if(v4 > 28) {
                        v1 = v3;
                    }
                    else if(v3 == 7) {
                        v1 = 8;
                    }
                    else if(v3 != 3 && (v3 != 4 && v3 != 5)) {
                        v1 = v3;
                    }
                    if(v4 <= 26 && "fugu".equals(L7.c) && v1 == 1) {
                        v1 = 2;
                    }
                    int v5 = L7.b(v1);
                    return v5 == 0 ? null : Pair.create(v, v5);
                }
            }
        }
        return null;
    }

    public final void c(long v) {
        boolean z;
        x6 x60;
        sa sa0 = this.b;
        if(this.a()) {
            x60 = this.q().a;
            Z0 z00 = (Z0)sa0.d;
            float f = x60.a;
            if(Float.compare(z00.c, f) != 0) {
                z00.c = f;
                z00.i = true;
            }
            float f1 = x60.b;
            if(z00.d != f1) {
                z00.d = f1;
                z00.i = true;
            }
        }
        else {
            x60 = x6.d;
        }
        if(this.a()) {
            sb sb0 = this.q();
            ((O)sa0.c).m = sb0.b;
            z = sb0.b;
        }
        else {
            z = false;
        }
        qb qb0 = this.q;
        sb sb1 = new sb(x60, z, Math.max(0L, v), this.s() * 1000000L / ((long)qb0.d));
        this.j.add(sb1);
        A6[] arr_a6 = (A6[])this.q.i;
        ArrayList arrayList0 = new ArrayList();
        for(int v2 = 0; v2 < arr_a6.length; ++v2) {
            A6 a60 = arr_a6[v2];
            if(a60.f()) {
                arrayList0.add(a60);
            }
            else {
                a60.flush();
            }
        }
        int v3 = arrayList0.size();
        this.I = (A6[])arrayList0.toArray(new A6[v3]);
        this.J = new ByteBuffer[v3];
        for(int v1 = 0; true; ++v1) {
            A6[] arr_a61 = this.I;
            if(v1 >= arr_a61.length) {
                break;
            }
            A6 a61 = arr_a61[v1];
            a61.flush();
            ByteBuffer[] arr_byteBuffer = this.J;
            arr_byteBuffer[v1] = a61.c();
        }
        Ga ga0 = this.o;
        if(ga0 != null) {
            p p0 = ((od)ga0.b).o1;
            Handler handler0 = (Handler)p0.a;
            if(handler0 != null) {
                handler0.post(new b(p0, z, 3));
            }
        }
    }

    public final void d(x6 x60, boolean z) {
        sb sb0 = this.q();
        if(x60.equals(sb0.a) && z == sb0.b) {
            return;
        }
        sb sb1 = new sb(x60, z, 0x8000000000000001L, 0x8000000000000001L);
        if(this.u()) {
            this.t = sb1;
            return;
        }
        this.u = sb1;
    }

    public final void e(u u0, int[] arr_v) {
        int v11;
        int v10;
        A6[] arr_a61;
        int v9;
        int v8;
        int v7;
        int v6;
        int[] arr_v1;
        int v = u0.T;
        int v1 = u0.S;
        int v2 = u0.V;
        if("audio/raw".equals(u0.l)) {
            M7.u(L7.G(v2));
            int v3 = L7.v(v2, v1);
            A6[] arr_a6 = !this.c || v2 != 4 && v2 != 0x20000000 && v2 != 0x30000000 ? this.f : this.g;
            this.e.i = u0.W;
            this.e.j = u0.X;
            if(L7.a >= 21 || v1 != 8 || arr_v != null) {
                arr_v1 = arr_v;
            }
            else {
                arr_v1 = new int[6];
                for(int v4 = 0; v4 < 6; ++v4) {
                    arr_v1[v4] = v4;
                }
            }
            this.d.i = arr_v1;
            y6 y60 = new y6(v, v1, v2);
            for(int v5 = 0; v5 < arr_a6.length; ++v5) {
                A6 a60 = arr_a6[v5];
                try {
                    y6 y61 = a60.a(y60);
                    if(a60.f()) {
                        y60 = y61;
                    }
                }
                catch(z6 z60) {
                    throw new s7(z60, u0);
                }
            }
            v6 = L7.b(y60.b);
            v7 = v3;
            v8 = L7.v(y60.c, y60.b);
            v9 = y60.c;
            arr_a61 = arr_a6;
            v10 = y60.a;
            v11 = 0;
        }
        else {
            Pair pair0 = ub.b(u0, this.a);
            if(pair0 == null) {
                throw new s7("Unable to configure passthrough for: " + u0, u0);
            }
            int v12 = (int)(((Integer)pair0.first));
            v6 = (int)(((Integer)pair0.second));
            v8 = -1;
            v11 = 2;
            v9 = v12;
            arr_a61 = new A6[0];
            v7 = -1;
            v10 = v;
        }
        if(v9 == 0) {
            throw new s7("Invalid output encoding (mode=" + v11 + ") for: " + u0, u0);
        }
        if(v6 == 0) {
            throw new s7("Invalid output channel config (mode=" + v11 + ") for: " + u0, u0);
        }
        this.Y = false;
        qb qb0 = new qb(u0, v7, v11, v8, v10, v6, v9, this.k, arr_a61);
        if(this.u()) {
            this.p = qb0;
            return;
        }
        this.q = qb0;
    }

    public final void f(ByteBuffer byteBuffer0, long v) {
        int v7;
        if(byteBuffer0.hasRemaining()) {
            ByteBuffer byteBuffer1 = this.M;
            boolean z = true;
            boolean z1 = false;
            if(byteBuffer1 == null) {
                this.M = byteBuffer0;
                if(L7.a < 21) {
                    int v1 = byteBuffer0.remaining();
                    if(this.N == null || this.N.length < v1) {
                        this.N = new byte[v1];
                    }
                    byteBuffer0.get(this.N, 0, v1);
                    byteBuffer0.position(byteBuffer0.position());
                    this.O = 0;
                }
            }
            else {
                M7.u(byteBuffer1 == byteBuffer0);
            }
            int v2 = byteBuffer0.remaining();
            int v3 = L7.a;
            G8 g80 = this.i;
            if(v3 < 21) {
                long v4 = this.A;
                long v5 = g80.a();
                int v6 = g80.e - ((int)(v4 - v5 * ((long)g80.d)));
                if(v6 > 0) {
                    v7 = this.r.write(this.N, this.O, Math.min(v2, v6));
                    if(v7 > 0) {
                        this.O += v7;
                        byteBuffer0.position(byteBuffer0.position() + v7);
                    }
                }
                else {
                    v7 = 0;
                }
            }
            else if(this.W) {
                M7.J(v != 0x8000000000000001L);
                AudioTrack audioTrack0 = this.r;
                if(v3 >= 26) {
                    v7 = audioTrack0.write(byteBuffer0, v2, 1, v * 1000L);
                }
                else {
                    if(this.w == null) {
                        ByteBuffer byteBuffer2 = ByteBuffer.allocate(16);
                        this.w = byteBuffer2;
                        byteBuffer2.order(ByteOrder.BIG_ENDIAN);
                        this.w.putInt(0x55550001);
                    }
                    if(this.x == 0) {
                        this.w.putInt(4, v2);
                        this.w.putLong(8, v * 1000L);
                        this.w.position(0);
                        this.x = v2;
                    }
                    int v8 = this.w.remaining();
                    if(v8 > 0) {
                        v7 = audioTrack0.write(this.w, v8, 1);
                        if(v7 < 0) {
                            this.x = 0;
                        }
                        else {
                            if(v7 < v8) {
                                v7 = 0;
                                goto label_63;
                            }
                            goto label_55;
                        }
                    }
                    else {
                    label_55:
                        int v9 = audioTrack0.write(byteBuffer0, v2, 1);
                        if(v9 < 0) {
                            this.x = 0;
                        }
                        else {
                            this.x -= v9;
                        }
                        v7 = v9;
                    }
                }
            }
            else {
                v7 = this.r.write(byteBuffer0, v2, 1);
            }
        label_63:
            this.X = SystemClock.elapsedRealtime();
            H1 h10 = this.n;
            if(v7 < 0) {
                if(v3 >= 24 && v7 == -6 || v7 == 0xFFFFFFE0) {
                    z1 = true;
                    if(this.q.b == 1) {
                        this.Y = true;
                    }
                }
                u7 u70 = new u7(v7, ((u)this.q.h), z1);
                Ga ga0 = this.o;
                if(ga0 != null) {
                    ga0.b(u70);
                }
                if(u70.b) {
                    throw u70;
                }
                h10.u(u70);
                return;
            }
            h10.c = null;
            if(ub.h(this.r)) {
                long v10 = this.B;
                if(v10 > 0L) {
                    this.Z = false;
                }
                if(this.S && this.o != null && v7 < v2 && !this.Z) {
                    long v11 = b4.b((v10 - g80.a()) * 1000000L / ((long)g80.g));
                    C9 c90 = ((od)this.o.b).x1;
                    if(c90 != null && v11 >= 2000L) {
                        c90.a.c0 = true;
                    }
                }
            }
            int v12 = this.q.b;
            if(v12 == 0) {
                this.A += (long)v7;
            }
            if(v7 == v2) {
                if(v12 != 0) {
                    if(byteBuffer0 != this.K) {
                        z = false;
                    }
                    M7.J(z);
                    this.B += (long)(this.C * this.L);
                }
                this.M = null;
            }
        }
    }

    public final boolean g(int v, ByteBuffer byteBuffer0, long v1) {
        int v9;
        int v19;
        int v13;
        int v12;
        M7.u(this.K == null || byteBuffer0 == this.K);
        if(this.p == null) {
        label_19:
            H1 h10 = this.m;
            if(!this.u()) {
                try {
                    this.t();
                }
                catch(t7 t70) {
                    if(t70.a) {
                        throw t70;
                    }
                    h10.u(t70);
                    return false;
                }
            }
            h10.c = null;
            G8 g80 = this.i;
            if(this.E) {
                this.F = Math.max(0L, v1);
                this.D = false;
                this.E = false;
                if(this.k && L7.a >= 23) {
                    this.l(this.v);
                }
                this.c(v1);
                if(this.S) {
                    this.S = true;
                    if(this.u()) {
                        Q7 q70 = g80.f;
                        q70.getClass();
                        q70.b();
                        this.r.play();
                    }
                }
            }
            long v2 = this.s();
            AudioTrack audioTrack0 = g80.c;
            audioTrack0.getClass();
            int v3 = audioTrack0.getPlayState();
            if(g80.h) {
                if(v3 == 2) {
                    g80.p = false;
                    return false;
                }
                if(v3 != 1 || g80.a() != 0L) {
                    goto label_53;
                }
            }
            else {
            label_53:
                boolean z = g80.p;
                boolean z1 = g80.b(v2);
                g80.p = z1;
                if(z && !z1 && v3 != 1) {
                    int v4 = g80.e;
                    long v5 = b4.b(g80.i);
                    ub ub0 = (ub)g80.a.b;
                    if(ub0.o != null) {
                        long v6 = SystemClock.elapsedRealtime() - ub0.X;
                        p p0 = ((od)ub0.o.b).o1;
                        Handler handler0 = (Handler)p0.a;
                        if(handler0 != null) {
                            handler0.post(new c(p0, v4, 1, v5, v6));
                        }
                    }
                }
                if(this.K == null) {
                    M7.u(byteBuffer0.order() == ByteOrder.LITTLE_ENDIAN);
                    if(!byteBuffer0.hasRemaining()) {
                        return true;
                    }
                    qb qb2 = this.q;
                    if(qb2.b != 0 && this.C == 0) {
                        int v7 = 3;
                        int v8 = qb2.f;
                        switch(v8) {
                            case 7: 
                            case 8: {
                                int v10 = byteBuffer0.position();
                                int v11 = byteBuffer0.get(v10);
                                switch(v11) {
                                    case -2: {
                                        v12 = (byteBuffer0.get(v10 + 5) & 1) << 6;
                                        v13 = byteBuffer0.get(v10 + 4) & 0xFC;
                                        break;
                                    }
                                    case -1: {
                                        v12 = (byteBuffer0.get(v10 + 4) & 7) << 4;
                                        v13 = byteBuffer0.get(v10 + 7) & 60;
                                        break;
                                    }
                                    default: {
                                        if(v11 == 0x1F) {
                                            v12 = (byteBuffer0.get(v10 + 5) & 7) << 4;
                                            v13 = byteBuffer0.get(v10 + 6) & 60;
                                        }
                                        else {
                                            v12 = (byteBuffer0.get(v10 + 4) & 1) << 6;
                                            v13 = byteBuffer0.get(v10 + 5) & 0xFC;
                                        }
                                    }
                                }
                                v9 = ((v13 >> 2 | v12) + 1) * 0x20;
                                break;
                            }
                            case 9: {
                                int v14 = byteBuffer0.getInt(byteBuffer0.position());
                                if(byteBuffer0.order() != ByteOrder.BIG_ENDIAN) {
                                    v14 = Integer.reverseBytes(v14);
                                }
                                int v15 = Ja.X(v14);
                                if(v15 == -1) {
                                    throw new IllegalArgumentException();
                                }
                                v9 = v15;
                                break;
                            }
                            case 11: 
                            case 12: {
                                v9 = 0x800;
                                break;
                            }
                            case 14: {
                                int v16 = byteBuffer0.position();
                                int v17 = byteBuffer0.limit();
                                for(int v18 = v16; true; ++v18) {
                                    v19 = -1;
                                    if(v18 > v17 - 10) {
                                        break;
                                    }
                                    int v20 = byteBuffer0.getInt(v18 + 4);
                                    if(byteBuffer0.order() != ByteOrder.BIG_ENDIAN) {
                                        v20 = Integer.reverseBytes(v20);
                                    }
                                    if((v20 & -2) == 0xF8726FBA) {
                                        v19 = v18 - v16;
                                        break;
                                    }
                                }
                                v9 = v19 == -1 ? 0 : (40 << (byteBuffer0.get(byteBuffer0.position() + v19 + ((byteBuffer0.get(byteBuffer0.position() + v19 + 7) & 0xFF) == 0xBB ? 8 : 9)) >> 4 & 7)) * 16;
                                break;
                            }
                            case 15: {
                                v9 = 0x200;
                                break;
                            }
                            case 10: 
                            case 16: {
                                v9 = 0x400;
                                break;
                            }
                            case 17: {
                                byte[] arr_b = new byte[16];
                                byteBuffer0.get(arr_b);
                                byteBuffer0.position(byteBuffer0.position());
                                v9 = Ja.j(new N(arr_b, 16, 6, 0)).c;
                                break;
                            }
                            case 5: 
                            case 6: 
                            case 18: {
                                if((byteBuffer0.get(byteBuffer0.position() + 5) & 0xF8) >> 3 > 10) {
                                    if((byteBuffer0.get(byteBuffer0.position() + 4) & 0xC0) >> 6 != 3) {
                                        v7 = (byteBuffer0.get(byteBuffer0.position() + 4) & 0x30) >> 4;
                                    }
                                    v9 = Ja.i[v7] * 0x100;
                                }
                                else {
                                    v9 = 0x600;
                                }
                                break;
                            }
                            default: {
                                throw new IllegalStateException("Unexpected audio encoding: " + v8);
                            }
                        }
                        this.C = v9;
                        if(v9 != 0) {
                            goto label_138;
                        }
                        return true;
                    }
                label_138:
                    if(this.t == null) {
                    label_142:
                        long v21 = this.F;
                        qb qb3 = this.q;
                        long v22 = (this.r() - this.e.o) * 1000000L / ((long)((u)qb3.h).T) + v21;
                        if(!this.D && Math.abs(v22 - v1) > 200000L) {
                            Ga ga0 = this.o;
                            StringBuilder stringBuilder0 = Y.o(v22, "Unexpected audio track timestamp discontinuity: expected ", ", got ");
                            stringBuilder0.append(v1);
                            ga0.b(new v7(stringBuilder0.toString()));  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
                            this.D = true;
                        }
                        if(!this.D) {
                        label_160:
                            if(this.q.b == 0) {
                                this.y += (long)byteBuffer0.remaining();
                            }
                            else {
                                this.z += (long)(this.C * v);
                            }
                            this.K = byteBuffer0;
                            this.L = v;
                            goto label_168;
                        }
                        else if(this.n()) {
                            long v23 = v1 - v22;
                            this.F += v23;
                            this.D = false;
                            this.c(v1);
                            Ga ga1 = this.o;
                            if(ga1 != null && v23 != 0L) {
                                ((od)ga1.b).v1 = true;
                            }
                            goto label_160;
                        }
                    }
                    else if(this.n()) {
                        this.c(v1);
                        this.t = null;
                        goto label_142;
                    }
                }
                else {
                label_168:
                    this.m(v1);
                    if(!this.K.hasRemaining()) {
                        this.K = null;
                        this.L = 0;
                        return true;
                    }
                    long v24 = this.s();
                    if(g80.y != 0x8000000000000001L && v24 > 0L && SystemClock.elapsedRealtime() - g80.y >= 200L) {
                        Log.w("DefaultAudioSink", "Resetting stalled audio track");
                        this.o();
                        return true;
                    }
                }
            }
        }
        else if(this.n()) {
            qb qb0 = this.p;
            qb qb1 = this.q;
            qb0.getClass();
            if(qb1.b != qb0.b || qb1.f != qb0.f || qb1.d != qb0.d || qb1.e != qb0.e || qb1.c != qb0.c) {
                this.v();
                if(!this.p()) {
                    this.o();
                    this.c(v1);
                    goto label_19;
                }
            }
            else {
                this.q = this.p;
                this.p = null;
                if(ub.h(this.r)) {
                    this.r.setOffloadEndOfStream();
                    this.r.setOffloadDelayPadding(((u)this.q.h).W, ((u)this.q.h).X);
                    this.Z = true;
                }
                this.c(v1);
                goto label_19;
            }
        }
        return false;
    }

    public static boolean h(AudioTrack audioTrack0) {
        return L7.a >= 29 && audioTrack0.isOffloadedPlayback();
    }

    public final void i() {
        this.o();
        A6[] arr_a6 = this.f;
        for(int v = 0; v < arr_a6.length; ++v) {
            arr_a6[v].d();
        }
        A6[] arr_a61 = this.g;
        for(int v1 = 0; v1 < arr_a61.length; ++v1) {
            arr_a61[v1].d();
        }
        this.S = false;
        this.Y = false;
    }

    public final int j(u u0) {
        int v = u0.V;
        if("audio/raw".equals(u0.l)) {
            if(!L7.G(v)) {
                x.u(v, "Invalid PCM encoding: ", "DefaultAudioSink");
                return 0;
            }
            return v == 2 || this.c && v == 4 ? 2 : 1;
        }
        return ub.b(u0, this.a) == null ? 0 : 2;
    }

    public static AudioFormat k(int v, int v1, int v2) {
        return new AudioFormat.Builder().setSampleRate(v).setChannelMask(v1).setEncoding(v2).build();
    }

    public final void l(x6 x60) {
        if(this.u()) {
            PlaybackParams playbackParams0 = new PlaybackParams().allowDefaults().setSpeed(x60.a).setPitch(x60.b).setAudioFallbackMode(2);
            try {
                this.r.setPlaybackParams(playbackParams0);
            }
            catch(IllegalArgumentException illegalArgumentException0) {
                M7.M(illegalArgumentException0, "DefaultAudioSink", "Failed to set playback params");
            }
            x60 = new x6(this.r.getPlaybackParams().getSpeed(), this.r.getPlaybackParams().getPitch());
            this.i.j = x60.a;
            Q7 q70 = this.i.f;
            if(q70 != null) {
                q70.b();
            }
        }
        this.v = x60;
    }

    public final void m(long v) {
        ByteBuffer byteBuffer0;
        int v1 = this.I.length;
        int v2 = v1;
        while(v2 >= 0) {
            if(v2 > 0) {
                byteBuffer0 = this.J[v2 - 1];
            }
            else {
                byteBuffer0 = this.K == null ? A6.a : this.K;
            }
            if(v2 == v1) {
                this.f(byteBuffer0, v);
            }
            else {
                A6 a60 = this.I[v2];
                if(v2 > this.P) {
                    a60.e(byteBuffer0);
                }
                ByteBuffer byteBuffer1 = a60.c();
                this.J[v2] = byteBuffer1;
                if(byteBuffer1.hasRemaining()) {
                    ++v2;
                    continue;
                }
            }
            if(byteBuffer0.hasRemaining()) {
                break;
            }
            --v2;
        }
    }

    public final boolean n() {
        if(this.P == -1) {
            this.P = 0;
        }
        for(boolean z = false; true; z = true) {
            int v = this.P;
            A6[] arr_a6 = this.I;
            if(v >= arr_a6.length) {
                break;
            }
            A6 a60 = arr_a6[v];
            if(z) {
                a60.e();
            }
            this.m(0x8000000000000001L);
            if(!a60.b()) {
                return false;
            }
            ++this.P;
        }
        ByteBuffer byteBuffer0 = this.M;
        if(byteBuffer0 != null) {
            this.f(byteBuffer0, 0x8000000000000001L);
            if(this.M != null) {
                return false;
            }
        }
        this.P = -1;
        return true;
    }

    public final void o() {
        if(this.u()) {
            this.y = 0L;
            this.z = 0L;
            this.A = 0L;
            this.B = 0L;
            this.Z = false;
            this.C = 0;
            sb sb0 = this.q();
            sb sb1 = this.q();
            this.u = new sb(sb0.a, sb1.b, 0L, 0L);
            this.F = 0L;
            this.t = null;
            this.j.clear();
            this.K = null;
            this.L = 0;
            this.M = null;
            this.R = false;
            this.Q = false;
            this.P = -1;
            this.w = null;
            this.x = 0;
            this.e.o = 0L;
            for(int v = 0; true; ++v) {
                A6[] arr_a6 = this.I;
                if(v >= arr_a6.length) {
                    break;
                }
                A6 a60 = arr_a6[v];
                a60.flush();
                ByteBuffer[] arr_byteBuffer = this.J;
                arr_byteBuffer[v] = a60.c();
            }
            G8 g80 = this.i;
            AudioTrack audioTrack0 = g80.c;
            audioTrack0.getClass();
            if(audioTrack0.getPlayState() == 3) {
                this.r.pause();
            }
            if(ub.h(this.r)) {
                sa sa0 = this.l;
                sa0.getClass();
                this.r.unregisterStreamEventCallback(((tb)sa0.c));
                ((Handler)sa0.b).removeCallbacksAndMessages(null);
            }
            AudioTrack audioTrack1 = this.r;
            this.r = null;
            if(L7.a < 21 && !this.T) {
                this.U = 0;
            }
            qb qb0 = this.p;
            if(qb0 != null) {
                this.q = qb0;
                this.p = null;
            }
            g80.l = 0L;
            g80.w = 0;
            g80.v = 0;
            g80.m = 0L;
            g80.C = 0L;
            g80.F = 0L;
            g80.k = false;
            g80.c = null;
            g80.f = null;
            this.h.close();
            new pb(this, audioTrack1).start();
        }
        this.n.c = null;
        this.m.c = null;
    }

    public final boolean p() {
        if(this.u()) {
            long v = this.s();
            return this.i.b(v);
        }
        return false;
    }

    public final sb q() {
        sb sb0 = this.t;
        if(sb0 != null) {
            return sb0;
        }
        return this.j.isEmpty() ? this.u : ((sb)this.j.getLast());
    }

    public final long r() {
        return this.q.b == 0 ? this.y / ((long)this.q.a) : this.z;
    }

    public final long s() {
        return this.q.b == 0 ? this.A / ((long)this.q.c) : this.B;
    }

    public final void t() {
        AudioTrack audioTrack0;
        this.h.block();
        try {
            qb qb0 = this.q;
            qb0.getClass();
            audioTrack0 = qb0.a(this.W, this.s, this.U);
        }
        catch(t7 t70) {
            if(this.q.b == 1) {
                this.Y = true;
            }
            Ga ga0 = this.o;
            if(ga0 != null) {
                ga0.b(t70);
            }
            throw t70;
        }
        this.r = audioTrack0;
        if(ub.h(audioTrack0)) {
            AudioTrack audioTrack1 = this.r;
            if(this.l == null) {
                this.l = new sa(this);
            }
            sa sa0 = this.l;
            Handler handler0 = (Handler)sa0.b;
            Objects.requireNonNull(handler0);
            audioTrack1.registerStreamEventCallback(new p0(handler0, 1), ((tb)sa0.c));
            this.r.setOffloadDelayPadding(((u)this.q.h).W, ((u)this.q.h).X);
        }
        this.U = this.r.getAudioSessionId();
        AudioTrack audioTrack2 = this.r;
        boolean z = this.q.b == 2;
        int v = this.q.f;
        int v1 = this.q.c;
        int v2 = this.q.g;
        this.i.c = audioTrack2;
        this.i.d = v1;
        this.i.e = v2;
        this.i.f = new Q7(audioTrack2, 0);
        this.i.g = audioTrack2.getSampleRate();
        this.i.h = z && L7.a < 23 && (v == 5 || v == 6);
        boolean z1 = L7.G(v);
        this.i.q = z1;
        this.i.i = z1 ? ((long)(v2 / v1)) * 1000000L / ((long)this.i.g) : 0x8000000000000001L;
        this.i.s = 0L;
        this.i.t = 0L;
        this.i.u = 0L;
        this.i.p = false;
        this.i.x = 0x8000000000000001L;
        this.i.y = 0x8000000000000001L;
        this.i.r = 0L;
        this.i.o = 0L;
        this.i.j = 1.0f;
        this.w();
        this.V.getClass();
        this.E = true;
    }

    public final boolean u() {
        return this.r != null;
    }

    public final void v() {
        if(!this.R) {
            this.R = true;
            long v = this.s();
            this.i.z = this.i.a();
            this.i.x = SystemClock.elapsedRealtime() * 1000L;
            this.i.A = v;
            this.r.stop();
            this.x = 0;
        }
    }

    public final void w() {
        if(!this.u()) {
            return;
        }
        if(L7.a >= 21) {
            this.r.setStereoVolume(this.G, this.H);
            return;
        }
        this.r.setStereoVolume(this.G, this.H);
    }
}

