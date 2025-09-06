package s3;

import B3.L;
import B3.m;
import B3.r;
import B3.v;
import S8.b;
import U3.d;
import android.net.Uri;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import de.c;
import g3.f;
import g3.j;
import g3.w;
import java.io.InterruptedIOException;
import java.util.Map;
import w3.h;
import y8.s;

public final class K implements h {
    public final Uri a;
    public final w b;
    public final s c;
    public final N d;
    public final b e;
    public final v f;
    public volatile boolean g;
    public boolean h;
    public long i;
    public j j;
    public L k;
    public boolean l;
    public final N m;

    public K(N n0, Uri uri0, f f0, s s0, N n1, b b0) {
        this.m = n0;
        this.a = uri0;
        this.b = new w(f0);
        this.c = s0;
        this.d = n1;
        this.e = b0;
        this.f = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.h = true;
        q.c.getAndIncrement();
        this.j = this.a(0L);
    }

    public final j a(long v) {
        e3.b.l(this.a, "The uri must be set.");
        return new j(this.a, 1, null, N.m0, v, -1L, this.m.i, 6);
    }

    @Override  // w3.h
    public final void cancelLoad() {
        this.g = true;
    }

    @Override  // w3.h
    public final void load() {
        w w1;
        int v = 0;
        while(v == 0 && !this.g) {
            try {
                long v1 = this.f.a;
                j j0 = this.a(v1);
                this.j = j0;
                long v2 = this.b.p(j0);
                if(this.g) {
                    goto label_65;
                }
                if(v2 != -1L) {
                    v2 += v1;
                    I i0 = new I(this.m, 0);
                    this.m.B.post(i0);
                }
                this.m.E = IcyHeaders.a(this.b.a.getResponseHeaders());
                w w0 = this.b;
                IcyHeaders icyHeaders0 = this.m.E;
                if(icyHeaders0 == null) {
                    w1 = w0;
                }
                else {
                    int v3 = icyHeaders0.f;
                    if(v3 != -1) {
                        w1 = new p(w0, v3, this);
                        M m0 = new M(0, true);
                        L l0 = this.m.r(m0);
                        this.k = l0;
                        l0.b(N.n0);
                    }
                }
                Map map0 = this.b.a.getResponseHeaders();
                this.c.k(w1, this.a, map0, v1, v2, this.d);
                if(this.m.E != null) {
                    r r0 = (r)this.c.b;
                    if(r0 != null && r0 instanceof d) {
                        ((d)r0).r = true;
                    }
                }
                if(this.h) {
                    long v4 = this.i;
                    r r1 = (r)this.c.b;
                    r1.getClass();
                    r1.seek(v1, v4);
                    this.h = false;
                }
                while(true) {
                    if(v != 0 || this.g) {
                        goto label_58;
                    }
                    try {
                        this.e.a();
                    }
                    catch(InterruptedException unused_ex) {
                        throw new InterruptedIOException();
                    }
                    r r2 = (r)this.c.b;
                    r2.getClass();
                    m m1 = (m)this.c.c;
                    m1.getClass();
                    v = r2.a(m1, this.f);
                    long v5 = this.c.h();
                    if(v5 > this.m.j + v1) {
                        synchronized(this.e) {
                            this.e.a = false;
                        }
                        this.m.B.post(this.m.w);
                        v1 = v5;
                    }
                }
            }
            catch(Throwable throwable0) {
            }
            if(v != 1 && this.c.h() != -1L) {
                this.f.a = this.c.h();
            }
            c.n(this.b);
            throw throwable0;
        label_58:
            if(v == 1) {
                v = 0;
            }
            else if(this.c.h() != -1L) {
                this.f.a = this.c.h();
            }
            c.n(this.b);
            continue;
        label_65:
            if(this.c.h() != -1L) {
                this.f.a = this.c.h();
            }
            c.n(this.b);
            return;
        }
    }
}

