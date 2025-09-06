package l3;

import androidx.media3.session.H0;
import e3.b;
import e3.x;
import ea.c;
import h3.e;
import i.n.i.b.a.s.e.E0;
import java.util.ArrayList;
import k3.g;
import s3.V;
import s3.v;
import ye.a;

public final class l implements V {
    public final int a;
    public final p b;
    public int c;

    public l(p p0, int v) {
        this.b = p0;
        this.a = v;
        this.c = -1;
    }

    public final void a() {
        b.c(this.c == -1);
        p p0 = this.b;
        p0.j();
        p0.g0.getClass();
        int v = this.a;
        int v1 = p0.g0[v];
        if(v1 != -1) {
            boolean[] arr_z = p0.j0;
            if(arr_z[v1]) {
                v1 = -2;
            }
            else {
                arr_z[v1] = true;
            }
        }
        else if(p0.f0.contains(p0.e0.a(v))) {
            v1 = -3;
        }
        else {
            v1 = -2;
        }
        this.c = v1;
    }

    @Override  // s3.V
    public final int b(c c0, e e0, int v) {
        androidx.media3.common.b b2;
        if(this.c == -3) {
            e0.c(4);
            return -4;
        }
        if(this.c()) {
            int v1 = this.c;
            p p0 = this.b;
            ArrayList arrayList0 = p0.n;
            if(!p0.r()) {
                if(!arrayList0.isEmpty()) {
                    int v2 = 0;
                alab1:
                    while(v2 < arrayList0.size() - 1) {
                        int v3 = ((i)arrayList0.get(v2)).k;
                        for(int v4 = 0; v4 < p0.I.length; ++v4) {
                            if(p0.j0[v4] && p0.I[v4].s() == ((long)v3)) {
                                break alab1;
                            }
                        }
                        ++v2;
                    }
                    x.Q(arrayList0, 0, v2);
                    i i0 = (i)arrayList0.get(0);
                    androidx.media3.common.b b0 = i0.d;
                    if(!b0.equals(p0.c0)) {
                        long v5 = x.Z(i0.g);
                        v v6 = new v(1, p0.b, b0, i0.e, i0.f, v5, 0x8000000000000001L);
                        H0 h00 = new H0(27, p0.k, v6);
                        p0.k.k(h00);
                    }
                    p0.c0 = b0;
                }
                if(arrayList0.isEmpty() || ((i)arrayList0.get(0)).K) {
                    int v7 = p0.I[v1].t(c0, e0, v, p0.p0);
                    if(v7 == -5) {
                        androidx.media3.common.b b1 = (androidx.media3.common.b)c0.c;
                        b1.getClass();
                        if(v1 == p0.W) {
                            int v8 = a.t(p0.I[v1].s());
                            int v9;
                            for(v9 = 0; v9 < arrayList0.size() && ((i)arrayList0.get(v9)).k != v8; ++v9) {
                            }
                            if(v9 < arrayList0.size()) {
                                b2 = ((i)arrayList0.get(v9)).d;
                            }
                            else {
                                b2 = p0.b0;
                                b2.getClass();
                            }
                            b1 = b1.e(b2);
                        }
                        c0.c = b1;
                    }
                    return v7;
                }
            }
        }
        return -3;
    }

    public final boolean c() {
        return this.c != -3 && this.c != -2 && this.c != -1;
    }

    // 去混淆评级： 低(30)
    @Override  // s3.V
    public final boolean isReady() {
        return this.c == -3 || this.c() && (!this.b.r() && this.b.I[this.c].p(this.b.p0));
    }

    @Override  // s3.V
    public final void maybeThrowError() {
        int v = this.c;
        p p0 = this.b;
        switch(v) {
            case -3: {
                break;
            }
            case -2: {
                p0.j();
                throw new E0(U4.x.k("Unable to bind a sample queue to TrackGroup with MIME type ", p0.e0.a(this.a).d[0].n, "."));  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
            }
            case -1: {
                p0.t();
                return;
            label_8:
                p0.t();
                o o0 = p0.I[v];
                if(o0.h != null && o0.h.getState() == 1) {
                    g g0 = o0.h.getError();
                    g0.getClass();
                    throw g0;
                }
                break;
            }
            default: {
                goto label_8;
            }
        }
    }

    @Override  // s3.V
    public final int skipData(long v) {
        if(this.c()) {
            int v1 = this.c;
            p p0 = this.b;
            if(!p0.r()) {
                o o0 = p0.I[v1];
                int v2 = o0.n(v, p0.p0);
                ArrayList arrayList0 = p0.n;
                if(arrayList0 == null) {
                    throw new NullPointerException();
                }
                Object object0 = arrayList0.isEmpty() ? null : com.iloen.melon.utils.a.i(1, arrayList0);
                if(((i)object0) != null && !((i)object0).K) {
                    v2 = Math.min(v2, ((i)object0).c(v1) - o0.l());
                }
                o0.x(v2);
                return v2;
            }
        }
        return 0;
    }
}

