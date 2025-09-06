package p3;

import Ac.X3;
import De.I;
import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.media3.common.Metadata.Entry;
import androidx.media3.common.Metadata;
import androidx.media3.common.c;
import androidx.media3.exoplayer.B;
import androidx.media3.exoplayer.e;
import androidx.media3.exoplayer.y;
import b3.G;
import e3.m;
import java.util.ArrayList;
import s3.z;

public final class b extends e implements Handler.Callback {
    public final a B;
    public final y D;
    public final Handler E;
    public final K3.a G;
    public I I;
    public boolean M;
    public boolean N;
    public long S;
    public Metadata T;
    public long V;

    public b(y y0, Looper looper0) {
        super(5);
        this.D = y0;
        this.E = looper0 == null ? null : new Handler(looper0, this);
        this.B = a.a;
        this.G = new K3.a(1);  // 初始化器: Lh3/e;-><init>(I)V
        this.V = 0x8000000000000001L;
    }

    public final void A(Metadata metadata0, ArrayList arrayList0) {
        for(int v = 0; true; ++v) {
            Entry[] arr_metadata$Entry = metadata0.a;
            if(v >= arr_metadata$Entry.length) {
                break;
            }
            androidx.media3.common.b b0 = arr_metadata$Entry[v].getWrappedMetadataFormat();
            if(b0 == null) {
                arrayList0.add(arr_metadata$Entry[v]);
            }
            else {
                a a0 = this.B;
                if(a0.b(b0)) {
                    I i0 = a0.a(b0);
                    byte[] arr_b = arr_metadata$Entry[v].getWrappedMetadataBytes();
                    arr_b.getClass();
                    this.G.o();
                    this.G.q(arr_b.length);
                    this.G.e.put(arr_b);
                    this.G.r();
                    Metadata metadata1 = i0.y(this.G);
                    if(metadata1 != null) {
                        this.A(metadata1, arrayList0);
                    }
                }
                else {
                    arrayList0.add(arr_metadata$Entry[v]);
                }
            }
        }
    }

    public final long B(long v) {
        boolean z = false;
        e3.b.j(Long.compare(v, 0x8000000000000001L) != 0);
        if(this.V != 0x8000000000000001L) {
            z = true;
        }
        e3.b.j(z);
        return v - this.V;
    }

    public final void C(Metadata metadata0) {
        y y0 = this.D;
        B b0 = y0.a;
        m m0 = b0.m;
        c c0 = b0.d0.a();
        for(int v = 0; true; ++v) {
            Entry[] arr_metadata$Entry = metadata0.a;
            if(v >= arr_metadata$Entry.length) {
                break;
            }
            arr_metadata$Entry[v].M(c0);
        }
        b0.d0 = new G(c0);
        G g0 = b0.m0();
        if(!g0.equals(b0.N)) {
            b0.N = g0;
            m0.c(14, new X3(y0, 26));
        }
        m0.c(28, new X3(metadata0, 27));
        m0.b();
    }

    @Override  // androidx.media3.exoplayer.e
    public final String g() {
        return "MetadataRenderer";
    }

    @Override  // android.os.Handler$Callback
    public final boolean handleMessage(Message message0) {
        if(message0.what != 1) {
            throw new IllegalStateException();
        }
        this.C(((Metadata)message0.obj));
        return true;
    }

    @Override  // androidx.media3.exoplayer.e
    public final boolean i() {
        return this.N;
    }

    @Override  // androidx.media3.exoplayer.e
    public final boolean k() {
        return true;
    }

    @Override  // androidx.media3.exoplayer.e
    public final void l() {
        this.T = null;
        this.I = null;
        this.V = 0x8000000000000001L;
    }

    @Override  // androidx.media3.exoplayer.e
    public final void n(long v, boolean z) {
        this.T = null;
        this.M = false;
        this.N = false;
    }

    @Override  // androidx.media3.exoplayer.e
    public final void s(androidx.media3.common.b[] arr_b, long v, long v1, z z0) {
        this.I = this.B.a(arr_b[0]);
        Metadata metadata0 = this.T;
        if(metadata0 != null) {
            long v2 = this.V + metadata0.b - v1;
            if(metadata0.b != v2) {
                metadata0 = new Metadata(v2, metadata0.a);
            }
            this.T = metadata0;
        }
        this.V = v1;
    }

    @Override  // androidx.media3.exoplayer.e
    public final void u(long v, long v1) {
        boolean z = true;
        while(z) {
            if(!this.M && this.T == null) {
                K3.a a0 = this.G;
                a0.o();
                ea.c c0 = this.c;
                c0.e();
                int v2 = this.t(c0, a0, 0);
                if(v2 != -4) {
                    if(v2 == -5) {
                        androidx.media3.common.b b0 = (androidx.media3.common.b)c0.c;
                        b0.getClass();
                        this.S = b0.s;
                    }
                }
                else if(a0.i(4)) {
                    this.M = true;
                }
                else if(a0.g >= this.l) {
                    a0.j = this.S;
                    a0.r();
                    Metadata metadata0 = this.I.y(a0);
                    if(metadata0 != null) {
                        ArrayList arrayList0 = new ArrayList(metadata0.a.length);
                        this.A(metadata0, arrayList0);
                        if(!arrayList0.isEmpty()) {
                            this.T = new Metadata(this.B(a0.g), ((Entry[])arrayList0.toArray(new Entry[0])));
                        }
                    }
                }
            }
            Metadata metadata1 = this.T;
            if(metadata1 == null) {
                z = false;
            }
            else {
                long v3 = this.B(v);
                if(metadata1.b <= v3) {
                    Metadata metadata2 = this.T;
                    Handler handler0 = this.E;
                    if(handler0 == null) {
                        this.C(metadata2);
                    }
                    else {
                        handler0.obtainMessage(1, metadata2).sendToTarget();
                    }
                    this.T = null;
                    z = true;
                }
            }
            if(this.M && this.T == null) {
                this.N = true;
            }
        }
    }

    @Override  // androidx.media3.exoplayer.e
    public final int y(androidx.media3.common.b b0) {
        if(this.B.b(b0)) {
            return b0.L == 0 ? 0x84 : 130;
        }
        return 0x80;
    }
}

