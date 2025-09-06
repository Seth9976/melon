package i.n.i.b.a.s.e;

import R8.v;
import android.net.Uri;
import java.io.InterruptedIOException;
import java.util.Map;

public final class s5 implements gb {
    public final Uri a;
    public final ye b;
    public final sa c;
    public final v5 d;
    public final v e;
    public final B3.v f;
    public volatile boolean g;
    public boolean h;
    public long i;
    public W2 j;
    public long k;
    public e7 l;
    public boolean m;
    public final v5 n;

    public s5(v5 v50, Uri uri0, D0 d00, sa sa0, v5 v51, v v0) {
        this.n = v50;
        this.a = uri0;
        this.b = new ye(d00);
        this.c = sa0;
        this.d = v51;
        this.e = v0;
        this.f = new B3.v();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.h = true;
        this.k = -1L;
        Sd.g.getAndIncrement();
        this.j = this.a(0L);
    }

    public final W2 a(long v) {
        Map map0 = v5.h0;
        Uri uri0 = this.a;
        if(uri0 == null) {
            throw new IllegalStateException("The uri must be set.");
        }
        return new W2(uri0, 1, null, map0, v, -1L, null, 6, 0x8000000000000001L, 0x8000000000000001L, 0x8000000000000001L);
    }

    @Override  // i.n.i.b.a.s.e.gb
    public final void b() {
        this.g = true;
    }

    @Override  // i.n.i.b.a.s.e.gb
    public final void g() {
        long v1;
        int v = 0;
        while(v == 0 && !this.g) {
            try {
                v1 = -1L;
                long v2 = this.f.a;
                W2 w20 = this.a(v2);
                this.j = w20;
                long v3 = this.b.b(w20);
                this.k = v3;
                if(v3 != -1L) {
                    this.k = v3 + v2;
                }
                this.n.w = m9.a(this.b.a.e());
                ye ye0 = this.b;
                m9 m90 = this.n.w;
                if(m90 != null) {
                    int v4 = m90.f;
                    if(v4 != -1) {
                        wd wd0 = new wd(ye0, v4, this);
                        u5 u50 = new u5(0, true);
                        e7 e70 = this.n.b(u50);
                        this.l = e70;
                        e70.a(v5.i0);
                        ye0 = wd0;
                    }
                }
                Map map0 = this.b.a.e();
                this.c.g(ye0, this.a, map0, v2, this.k, this.d);
                if(this.n.w != null) {
                    q4 q40 = (q4)this.c.b;
                    if(q40 instanceof Od) {
                        ((Od)q40).p = true;
                    }
                }
                if(this.h) {
                    long v5 = this.i;
                    q4 q41 = (q4)this.c.b;
                    q41.getClass();
                    q41.d(v2, v5);
                    this.h = false;
                }
                while(true) {
                    if(v != 0 || this.g) {
                        goto label_60;
                    }
                    try {
                        this.e.a();
                    }
                    catch(InterruptedException unused_ex) {
                        throw new InterruptedIOException();
                    }
                    q4 q42 = (q4)this.c.b;
                    q42.getClass();
                    D2 d20 = (D2)this.c.d;
                    d20.getClass();
                    v = q42.f(d20, this.f);
                    D2 d21 = (D2)this.c.d;
                    long v6 = d21 == null ? -1L : d21.d;
                    if(v6 <= this.n.i + v2) {
                        continue;
                    }
                    this.e.c();
                    this.n.o.post(this.n.n);
                    v2 = v6;
                    continue;
                label_51:
                    if(v != 1) {
                        break;
                    }
                    goto label_58;
                }
            }
            catch(Throwable throwable0) {
                goto label_51;
            }
            D2 d22 = (D2)this.c.d;
            if((d22 == null ? -1L : d22.d) != -1L) {
                B3.v v7 = this.f;
                if(d22 != null) {
                    v1 = d22.d;
                }
                v7.a = v1;
            }
        label_58:
            L7.m(this.b);
            throw throwable0;
        label_60:
            if(v == 1) {
                v = 0;
            }
            else {
                D2 d23 = (D2)this.c.d;
                if((d23 == null ? -1L : d23.d) != -1L) {
                    B3.v v8 = this.f;
                    if(d23 != null) {
                        v1 = d23.d;
                    }
                    v8.a = v1;
                }
            }
            L7.m(this.b);
        }
    }
}

