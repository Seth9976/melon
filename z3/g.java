package z3;

import I6.p0;
import Vd.w;
import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.common.b;
import b3.z0;
import e3.r;
import e3.t;
import e3.x;
import ea.a;
import java.util.concurrent.CopyOnWriteArraySet;

public final class g {
    public final d a;
    public final l b;
    public final n c;
    public final f d;
    public final p0 e;
    public final a f;
    public final r g;
    public final CopyOnWriteArraySet h;
    public b i;
    public j j;
    public t k;
    public Pair l;
    public int m;
    public int n;
    public static final l.a o;

    static {
        g.o = new l.a(2);
    }

    public g(com.iloen.melon.sns.model.a a0) {
        d d0 = new d(this, ((Context)a0.b));
        this.a = d0;
        r r0 = (r)a0.g;
        this.g = r0;
        l l0 = (l)a0.c;
        this.b = l0;
        l0.l = r0;
        n n0 = new n(new wa.a(this), l0);
        this.c = n0;
        f f0 = (f)a0.e;
        e3.b.k(f0);
        this.d = f0;
        this.e = (p0)a0.f;
        this.f = new a(l0, n0);
        CopyOnWriteArraySet copyOnWriteArraySet0 = new CopyOnWriteArraySet();
        this.h = copyOnWriteArraySet0;
        this.n = 0;
        copyOnWriteArraySet0.add(d0);
    }

    public static void a(g g0, long v, long v1) {
        n n0 = g0.c;
        g g1 = (g)n0.a.a;
        l l0 = n0.b;
        w w0 = n0.f;
        if(w0.c != 0) {
            long v2 = ((long[])w0.e)[w0.b];
            Long long0 = (Long)n0.e.i(v2);
            if(long0 != null && ((long)long0) != n0.i) {
                n0.i = (long)long0;
                l0.d(2);
            }
            int v3 = n0.b.a(v2, v, v1, n0.i, false, n0.c);
            boolean z = true;
            switch(v3) {
                case 0: 
                case 1: {
                    n0.j = v2;
                    long v4 = w0.t0();
                    z0 z00 = (z0)n0.d.i(v4);
                    if(z00 != null && !z00.equals(z0.d) && !z00.equals(n0.h)) {
                        n0.h = z00;
                        b3.n n1 = new b3.n();
                        n1.t = z00.a;
                        n1.u = z00.b;
                        n1.m = "video/raw";
                        g1.i = new b(n1);
                        for(Object object0: g1.h) {
                            ((d)object0).m.execute(new c(((d)object0), ((d)object0).l, z00));
                        }
                    }
                    if(l0.e == 3) {
                        z = false;
                    }
                    l0.e = 3;
                    l0.l.getClass();
                    l0.g = x.M(SystemClock.elapsedRealtime());
                    if(z && g1.l != null) {
                        for(Object object1: g1.h) {
                            ((d)object1).m.execute(new c(((d)object1), ((d)object1).l, 1));
                        }
                    }
                    if(g1.j != null) {
                        b b0 = g1.i == null ? new b(new b3.n()) : g1.i;
                        j j0 = g1.j;
                        g1.g.getClass();
                        j0.a(v4, System.nanoTime(), b0, null);
                    }
                    e3.b.k(null);
                    throw null;
                }
                case 2: 
                case 3: 
                case 4: {
                    n0.j = v2;
                    w0.t0();
                    for(Object object2: g1.h) {
                        ((d)object2).m.execute(new c(((d)object2), ((d)object2).l, 2));
                    }
                    e3.b.k(null);
                    throw null;
                }
                case 5: {
                    break;
                }
                default: {
                    throw new IllegalStateException(String.valueOf(v3));
                }
            }
        }
    }
}

