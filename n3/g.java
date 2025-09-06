package n3;

import android.graphics.Bitmap;
import android.os.Trace;
import androidx.media3.common.b;
import androidx.media3.exoplayer.e;
import i3.d;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import kb.D;
import s3.z;

public final class g extends e {
    public final c B;
    public final h3.e D;
    public final ArrayDeque E;
    public boolean G;
    public boolean I;
    public f M;
    public long N;
    public long S;
    public int T;
    public int V;
    public b W;
    public n3.b X;
    public h3.e Y;
    public n3.e Z;
    public Bitmap b0;
    public boolean c0;
    public O5.b d0;
    public O5.b e0;
    public int f0;

    public g(c c0) {
        super(4);
        this.B = c0;
        this.Z = n3.e.a;
        this.D = new h3.e(0);
        this.M = f.c;
        this.E = new ArrayDeque();
        this.S = 0x8000000000000001L;
        this.N = 0x8000000000000001L;
        this.T = 0;
        this.V = 1;
    }

    public final boolean A(long v) {
        boolean z2;
        Bitmap bitmap1;
        Bitmap bitmap0 = this.b0;
        if((bitmap0 == null || this.d0 != null) && (this.V != 0 || this.h == 2)) {
            ArrayDeque arrayDeque0 = this.E;
            if(bitmap0 == null) {
                e3.b.k(this.X);
                a a0 = (a)this.X.f();
                if(a0 != null) {
                    if(a0.i(4)) {
                        if(this.T == 3) {
                            this.D();
                            e3.b.k(this.W);
                            this.C();
                            return false;
                        }
                        a0.p();
                        if(arrayDeque0.isEmpty()) {
                            this.I = true;
                            return false;
                        }
                    }
                    else {
                        e3.b.l(a0.e, "Non-EOS buffer came back from the decoder without bitmap.");
                        this.b0 = a0.e;
                        a0.p();
                        goto label_20;
                    }
                }
            }
            else {
            label_20:
                if(this.c0 && this.b0 != null && this.d0 != null) {
                    e3.b.k(this.W);
                    int v1 = this.W.J;
                    int v2 = this.W.K;
                    boolean z = (v1 != 1 || v2 != 1) && v1 != -1 && v2 != -1;
                    O5.b b0 = this.d0;
                    if(((Bitmap)b0.c) == null) {
                        if(z) {
                            int v3 = b0.a;
                            e3.b.k(this.b0);
                            int v4 = this.b0.getWidth();
                            b b1 = this.W;
                            e3.b.k(b1);
                            int v5 = v4 / b1.J;
                            int v6 = this.b0.getHeight();
                            b b2 = this.W;
                            e3.b.k(b2);
                            int v7 = v6 / b2.K;
                            int v8 = this.W.J;
                            bitmap1 = Bitmap.createBitmap(this.b0, v3 % v8 * v5, v3 / v8 * v7, v5, v7);
                        }
                        else {
                            bitmap1 = this.b0;
                            e3.b.k(bitmap1);
                        }
                        b0.c = bitmap1;
                    }
                    e3.b.k(((Bitmap)this.d0.c));
                    long v9 = this.d0.b - v;
                    boolean z1 = this.h == 2;
                    switch(this.V) {
                        case 0: {
                            break;
                        }
                        case 1: {
                            z1 = true;
                            break;
                        }
                        case 3: {
                            z1 = false;
                            break;
                        }
                        default: {
                            throw new IllegalStateException();
                        }
                    }
                    if(z1 || v9 < 30000L) {
                        this.Z.getClass();
                        z2 = true;
                    }
                    else {
                        z2 = false;
                    }
                    if(z2) {
                        O5.b b3 = this.d0;
                        e3.b.k(b3);
                        long v10 = b3.b;
                        this.N = v10;
                        while(!arrayDeque0.isEmpty() && v10 >= ((f)arrayDeque0.peek()).a) {
                            this.M = (f)arrayDeque0.removeFirst();
                        }
                        this.V = 3;
                        if(z) {
                            O5.b b4 = this.d0;
                            e3.b.k(b4);
                            int v11 = b4.a;
                            b b5 = this.W;
                            e3.b.k(b5);
                            b b6 = this.W;
                            e3.b.k(b6);
                            if(v11 == b5.K * b6.J - 1) {
                                this.b0 = null;
                            }
                        }
                        else {
                            this.b0 = null;
                        }
                        this.d0 = this.e0;
                        this.e0 = null;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean B(long v) {
        boolean z3;
        boolean z;
        if(!this.c0 || this.d0 == null) {
            ea.c c0 = this.c;
            c0.e();
            n3.b b0 = this.X;
            if(b0 != null && this.T != 3 && !this.G) {
                if(this.Y == null) {
                    h3.e e0 = (h3.e)b0.dequeueInputBuffer();
                    this.Y = e0;
                    if(e0 != null) {
                        goto label_9;
                    }
                }
                else {
                label_9:
                    if(this.T == 2) {
                        e3.b.k(this.Y);
                        this.Y.b = 4;
                        n3.b b1 = this.X;
                        e3.b.k(b1);
                        b1.g(this.Y);
                        this.Y = null;
                        this.T = 3;
                        return false;
                    }
                    switch(this.t(c0, this.Y, 0)) {
                        case -5: {
                            b b2 = (b)c0.c;
                            e3.b.k(b2);
                            this.W = b2;
                            this.T = 2;
                            return true;
                        }
                        case -4: {
                            this.Y.r();
                            ByteBuffer byteBuffer0 = this.Y.e;
                            if(byteBuffer0 != null && byteBuffer0.remaining() > 0) {
                                z = true;
                            }
                            else {
                                h3.e e1 = this.Y;
                                e3.b.k(e1);
                                z = e1.i(4);
                            }
                            if(z) {
                                n3.b b3 = this.X;
                                e3.b.k(b3);
                                h3.e e2 = this.Y;
                                e3.b.k(e2);
                                b3.g(e2);
                                this.f0 = 0;
                            }
                            h3.e e3 = this.Y;
                            e3.b.k(e3);
                            if(e3.i(4)) {
                                this.c0 = true;
                            }
                            else {
                                int v1 = this.f0;
                                long v2 = e3.g;
                                O5.b b4 = new O5.b();  // 初始化器: Ljava/lang/Object;-><init>()V
                                b4.a = v1;
                                b4.b = v2;
                                this.e0 = b4;
                                this.f0 = v1 + 1;
                                if(this.c0) {
                                    this.d0 = this.e0;
                                    this.e0 = null;
                                }
                                else {
                                    boolean z1 = v2 - 30000L <= v && v <= v2 + 30000L;
                                    boolean z2 = this.d0 != null && this.d0.b <= v && v < v2;
                                    b b5 = this.W;
                                    e3.b.k(b5);
                                    if(b5.J == -1) {
                                        z3 = true;
                                    }
                                    else {
                                        int v3 = this.W.K;
                                        z3 = v3 == -1 || v1 == v3 * this.W.J - 1;
                                    }
                                    this.c0 = z1 || z2 || z3;
                                    if(!z2 || z1) {
                                        this.d0 = this.e0;
                                        this.e0 = null;
                                    }
                                }
                            }
                            h3.e e4 = this.Y;
                            e3.b.k(e4);
                            if(e4.i(4)) {
                                this.G = true;
                                this.Y = null;
                                return false;
                            }
                            long v4 = this.S;
                            h3.e e5 = this.Y;
                            e3.b.k(e5);
                            this.S = Math.max(v4, e5.g);
                            if(z) {
                                this.Y = null;
                                return !this.c0;
                            }
                            h3.e e6 = this.Y;
                            e3.b.k(e6);
                            e6.o();
                            return !this.c0;
                        }
                        case -3: {
                            break;
                        }
                        default: {
                            throw new IllegalStateException();
                        }
                    }
                }
            }
        }
        return false;
    }

    public final void C() {
        b b0 = this.W;
        D d0 = (D)this.B;
        switch(d0.r(b0)) {
            case 0x83: 
            case 0x84: {
                n3.b b1 = this.X;
                if(b1 != null) {
                    b1.release();
                }
                this.X = new n3.b(((d)d0.b));
                return;
            }
            default: {
                throw this.d(new n3.d("Provided decoder factory can\'t create decoder for format."), this.W, false, 4005);  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
            }
        }
    }

    public final void D() {
        this.Y = null;
        this.T = 0;
        this.S = 0x8000000000000001L;
        n3.b b0 = this.X;
        if(b0 != null) {
            b0.release();
            this.X = null;
        }
    }

    @Override  // androidx.media3.exoplayer.e
    public final String g() {
        return "ImageRenderer";
    }

    @Override  // androidx.media3.exoplayer.e
    public final void handleMessage(int v, Object object0) {
        if(v != 15) {
            return;
        }
        n3.e e0 = object0 instanceof n3.e ? ((n3.e)object0) : null;
        if(e0 == null) {
            e0 = n3.e.a;
        }
        this.Z = e0;
    }

    @Override  // androidx.media3.exoplayer.e
    public final boolean i() {
        return this.I;
    }

    // 去混淆评级： 低(20)
    @Override  // androidx.media3.exoplayer.e
    public final boolean k() {
        return this.V == 3 || this.V == 0 && this.c0;
    }

    @Override  // androidx.media3.exoplayer.e
    public final void l() {
        this.W = null;
        this.M = f.c;
        this.E.clear();
        this.D();
        this.Z.getClass();
    }

    @Override  // androidx.media3.exoplayer.e
    public final void m(boolean z, boolean z1) {
        this.V = z1;
    }

    @Override  // androidx.media3.exoplayer.e
    public final void n(long v, boolean z) {
        this.V = Math.min(this.V, 1);
        this.I = false;
        this.G = false;
        this.b0 = null;
        this.d0 = null;
        this.e0 = null;
        this.c0 = false;
        this.Y = null;
        n3.b b0 = this.X;
        if(b0 != null) {
            b0.flush();
        }
        this.E.clear();
    }

    @Override  // androidx.media3.exoplayer.e
    public final void o() {
        this.D();
    }

    @Override  // androidx.media3.exoplayer.e
    public final void p() {
        this.D();
        this.V = Math.min(this.V, 1);
    }

    @Override  // androidx.media3.exoplayer.e
    public final void s(b[] arr_b, long v, long v1, z z0) {
        if(this.M.b != 0x8000000000000001L) {
            ArrayDeque arrayDeque0 = this.E;
            if(!arrayDeque0.isEmpty() || this.S != 0x8000000000000001L && (this.N == 0x8000000000000001L || this.N < this.S)) {
                arrayDeque0.add(new f(this.S, v1));
                return;
            }
        }
        this.M = new f(0x8000000000000001L, v1);
    }

    @Override  // androidx.media3.exoplayer.e
    public final void u(long v, long v1) {
        if(!this.I) {
            if(this.W != null) {
                goto label_18;
            }
            ea.c c0 = this.c;
            c0.e();
            h3.e e0 = this.D;
            e0.o();
            int v2 = this.t(c0, e0, 2);
            if(v2 == -5) {
                b b0 = (b)c0.c;
                e3.b.k(b0);
                this.W = b0;
                this.C();
                goto label_18;
            }
            if(v2 == -4) {
                e3.b.j(e0.i(4));
                this.G = true;
                this.I = true;
                return;
                try {
                label_18:
                    Trace.beginSection("drainAndFeedDecoder");
                    while(true) {
                        if(!this.A(v)) {
                            while(true) {
                                if(!this.B(v)) {
                                    Trace.endSection();
                                    return;
                                }
                            }
                        }
                    }
                }
                catch(n3.d d0) {
                    throw this.d(d0, null, false, 4003);
                }
            }
        }
    }

    @Override  // androidx.media3.exoplayer.e
    public final int y(b b0) {
        return ((D)this.B).r(b0);
    }
}

