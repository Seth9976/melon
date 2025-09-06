package v3;

import I6.H;
import I6.V;
import I6.n0;
import I6.w0;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.media3.common.b;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import b3.q0;
import b3.t0;
import e3.x;
import java.util.Objects;

public final class e extends l implements Comparable {
    public final int B;
    public final int D;
    public final int E;
    public final int G;
    public final boolean I;
    public final boolean M;
    public final boolean N;
    public final int e;
    public final boolean f;
    public final String g;
    public final h h;
    public final boolean i;
    public final int j;
    public final int k;
    public final int l;
    public final boolean m;
    public final boolean n;
    public final int o;
    public final int r;
    public final boolean w;

    public e(int v, q0 q00, int v1, h h0, int v2, boolean z, d d0, int v3) {
        super(v, q00, v1);
        int v17;
        boolean z1;
        int v13;
        int v11;
        int v9;
        this.h = h0;
        V v4 = h0.r;
        V v5 = h0.n;
        int v6 = h0.l0 ? 24 : 16;
        int v7 = 0;
        this.m = false;
        this.g = DefaultTrackSelector.f(this.d.d);
        this.i = androidx.media3.exoplayer.e.j(v2, false);
        int v8;
        for(v8 = 0; true; ++v8) {
            v9 = 0x7FFFFFFF;
            if(v8 >= v5.size()) {
                v11 = 0;
                v8 = 0x7FFFFFFF;
                break;
            }
            String s = (String)v5.get(v8);
            int v10 = DefaultTrackSelector.c(this.d, s, false);
            if(v10 > 0) {
                v11 = v10;
                break;
            }
        }
        this.k = v8;
        this.j = v11;
        int v12 = this.d.f;
        this.l = v12 == 0 || v12 != h0.o ? Integer.bitCount(v12 & h0.o) : 0x7FFFFFFF;
        b b0 = this.d;
        this.n = b0.f == 0 || (b0.f & 1) != 0;
        this.w = (b0.e & 1) != 0;
        String s1 = b0.n;
        if(s1 == null) {
            z1 = false;
        }
        else {
            switch(s1) {
                case "audio/ac4": {
                    v13 = 1;
                    break;
                }
                case "audio/eac3-joc": {
                    v13 = 0;
                    break;
                }
                case "audio/iamf": {
                    v13 = 2;
                    break;
                }
                default: {
                    v13 = -1;
                }
            }
            z1 = v13 != 0 && v13 != 1 && v13 != 2 ? false : true;
        }
        this.N = z1;
        this.B = b0.C;
        this.D = b0.D;
        this.E = b0.j;
        this.f = (b0.j == -1 || b0.j <= h0.q) && (b0.C == -1 || b0.C <= h0.p) && d0.apply(b0);
        String[] arr_s = Resources.getSystem().getConfiguration().getLocales().toLanguageTags().split(",", -1);
        for(int v14 = 0; v14 < arr_s.length; ++v14) {
            arr_s[v14] = x.N(arr_s[v14]);
        }
        int v15;
        for(v15 = 0; true; ++v15) {
            if(v15 >= arr_s.length) {
                v17 = 0;
                v15 = 0x7FFFFFFF;
                break;
            }
            int v16 = DefaultTrackSelector.c(this.d, arr_s[v15], false);
            if(v16 > 0) {
                v17 = v16;
                break;
            }
        }
        this.o = v15;
        this.r = v17;
        for(int v18 = 0; v18 < v4.size(); ++v18) {
            String s2 = this.d.n;
            if(s2 != null && s2.equals(v4.get(v18))) {
                v9 = v18;
                break;
            }
        }
        this.G = v9;
        this.I = (v2 & 0x180) == 0x80;
        this.M = (v2 & 0x40) == 0x40;
        b b1 = this.d;
        boolean z2 = this.f;
        h h1 = this.h;
        t0 t00 = h1.s;
        if(androidx.media3.exoplayer.e.j(v2, h1.n0) && (z2 || h1.k0) && (t00.a != 2 || DefaultTrackSelector.g(h1, v2, b1))) {
            v7 = !androidx.media3.exoplayer.e.j(v2, false) || !z2 || b1.j == -1 || h1.z || h1.y || !h1.o0 && z || t00.a == 2 || (v6 & v2) == 0 ? 1 : 2;
        }
        this.e = v7;
    }

    @Override  // v3.l
    public final int a() {
        return this.e;
    }

    @Override  // v3.l
    public final boolean b(l l0) {
        b b0 = ((e)l0).d;
        this.h.getClass();
        return this.d.C != -1 && this.d.C == b0.C && (this.m || this.d.n != null && TextUtils.equals(this.d.n, b0.n)) && (this.d.D != -1 && this.d.D == b0.D && this.I == ((e)l0).I && this.M == ((e)l0).M);
    }

    public final int c(e e0) {
        n0 n00 = !this.f || !this.i ? DefaultTrackSelector.j.a() : DefaultTrackSelector.j;
        int v = e0.E;
        H h0 = H.a.c(this.i, e0.i).b(this.k, e0.k, w0.a).a(this.j, e0.j).a(this.l, e0.l).c(this.w, e0.w).c(this.n, e0.n).b(this.o, e0.o, w0.a).a(this.r, e0.r).c(this.f, e0.f).b(this.G, e0.G, w0.a);
        int v1 = this.E;
        if(this.h.y) {
            h0 = h0.b(v1, v, DefaultTrackSelector.j.a());
        }
        H h1 = h0.c(this.I, e0.I).c(this.M, e0.M).c(this.N, e0.N).b(this.B, e0.B, n00).b(this.D, e0.D, n00);
        if(Objects.equals(this.g, e0.g)) {
            h1 = h1.b(v1, v, n00);
        }
        return h1.e();
    }

    @Override
    public final int compareTo(Object object0) {
        return this.c(((e)object0));
    }
}

