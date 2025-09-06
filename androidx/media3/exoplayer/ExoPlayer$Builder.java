package androidx.media3.exoplayer;

import H6.k;
import H6.m;
import android.content.Context;
import android.os.Looper;
import b3.d;
import e3.r;
import e3.x;

public final class ExoPlayer.Builder {
    public final Context a;
    public final r b;
    public final k c;
    public final k d;
    public final b e;
    public final m f;
    public final b g;
    public final T7.b h;
    public final Looper i;
    public final int j;
    public d k;
    public boolean l;
    public final int m;
    public final boolean n;
    public final i0 o;
    public final long p;
    public final long q;
    public final long r;
    public final h s;
    public final long t;
    public final long u;
    public final boolean v;
    public boolean w;
    public final String x;

    public ExoPlayer.Builder(Context context0) {
        this(context0, new b(context0, 1), new b(context0, 2));
    }

    public ExoPlayer.Builder(Context context0, k k0, k k1) {
        b b0 = new b(context0, 3);
        m m0 = new m(1);
        b b1 = new b(context0, 4);
        T7.b b2 = new T7.b(28);
        super();
        context0.getClass();
        this.a = context0;
        this.c = k0;
        this.d = k1;
        this.e = b0;
        this.f = m0;
        this.g = b1;
        this.h = b2;
        this.i = x.u();
        this.k = d.g;
        this.m = 1;
        this.n = true;
        this.o = i0.c;
        this.p = 5000L;
        this.q = 15000L;
        this.r = 3000L;
        this.s = new h(x.M(20L), x.M(500L));
        this.b = r.a;
        this.t = 500L;
        this.u = 2000L;
        this.v = true;
        this.x = "";
        this.j = -1000;
    }
}

