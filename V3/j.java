package v3;

import I6.H;
import I6.V;
import I6.m0;
import I6.w0;
import androidx.media3.exoplayer.e;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import b3.q0;

public final class j extends l implements Comparable {
    public final int e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final boolean m;

    public j(int v, q0 q00, int v1, h h0, int v2, String s) {
        super(v, q00, v1);
        int v10;
        int v8;
        int v3 = 0;
        this.f = e.j(v2, false);
        V v4 = h0.t;
        int v5 = this.d.e & ~h0.v;
        this.g = (v5 & 1) != 0;
        this.h = (v5 & 2) != 0;
        V v6 = v4.isEmpty() ? V.t("") : v4;
        int v7;
        for(v7 = 0; true; ++v7) {
            v8 = 0x7FFFFFFF;
            if(v7 >= v6.size()) {
                v10 = 0;
                v7 = 0x7FFFFFFF;
                break;
            }
            String s1 = (String)v6.get(v7);
            int v9 = DefaultTrackSelector.c(this.d, s1, h0.w);
            if(v9 > 0) {
                v10 = v9;
                break;
            }
        }
        this.i = v7;
        this.j = v10;
        int v11 = this.d.f;
        int v12 = h0.u;
        if(v11 == 0 || v11 != v12) {
            v8 = Integer.bitCount(v11 & v12);
        }
        this.k = v8;
        this.m = (this.d.f & 0x440) != 0;
        boolean z = DefaultTrackSelector.f(s) == null;
        int v13 = DefaultTrackSelector.c(this.d, s, z);
        this.l = v13;
        if(e.j(v2, h0.n0) && (v10 > 0 || v4.isEmpty() && v8 > 0 || this.g || this.h && v13 > 0)) {
            v3 = 1;
        }
        this.e = v3;
    }

    @Override  // v3.l
    public final int a() {
        return this.e;
    }

    @Override  // v3.l
    public final boolean b(l l0) {
        j j0 = (j)l0;
        return false;
    }

    public final int c(j j0) {
        w0 w00 = w0.a;
        H h0 = H.a.c(this.f, j0.f).b(this.i, j0.i, w00).a(this.j, j0.j);
        int v = this.k;
        H h1 = h0.a(v, j0.k).c(this.g, j0.g);
        Boolean boolean0 = Boolean.valueOf(this.h);
        Boolean boolean1 = Boolean.valueOf(j0.h);
        if(this.j == 0) {
            w00 = m0.a;
        }
        H h2 = h1.b(boolean0, boolean1, w00).a(this.l, j0.l);
        if(v == 0) {
            h2 = h2.d(this.m, j0.m);
        }
        return h2.e();
    }

    @Override
    public final int compareTo(Object object0) {
        return this.c(((j)object0));
    }
}

