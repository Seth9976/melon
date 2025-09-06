package w3;

import I6.V;
import I6.Y;
import I6.p0;
import android.content.Context;
import android.os.Handler;
import b.l;
import e3.r;
import g3.x;
import i.n.i.b.a.s.e.ab;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class f implements x, c {
    public final Y a;
    public final ab b;
    public final r c;
    public final boolean d;
    public final o e;
    public int f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;
    public int m;
    public static final p0 n;
    public static final p0 o;
    public static final p0 p;
    public static final p0 q;
    public static final p0 r;
    public static final p0 s;
    public static f t;

    static {
        f.n = V.s(4300000L, 3200000L, 2400000L, 1700000L, 860000L);
        f.o = V.s(1500000L, 980000L, 750000L, 520000L, 290000L);
        f.p = V.s(2000000L, 1300000L, 1000000L, 860000L, 610000L);
        f.q = V.s(2500000L, 1700000L, 1200000L, 970000L, 680000L);
        f.r = V.s(4700000L, 2800000L, 2100000L, 1700000L, 980000L);
        f.s = V.s(2700000L, 2000000L, 1600000L, 1300000L, 1000000L);
    }

    public f(Context context0, Map map0, int v, r r0, boolean z) {
        this.a = Y.a(map0);
        this.b = new ab(1);
        this.e = new o(v);
        this.c = r0;
        this.d = z;
        if(context0 != null) {
            e3.o o0 = e3.o.b(context0);
            int v1 = o0.c();
            this.m = v1;
            this.k = this.a(v1);
            e e0 = new e(this);
            CopyOnWriteArrayList copyOnWriteArrayList0 = (CopyOnWriteArrayList)o0.e;
            for(Object object0: copyOnWriteArrayList0) {
                WeakReference weakReference0 = (WeakReference)object0;
                if(weakReference0.get() == null) {
                    copyOnWriteArrayList0.remove(weakReference0);
                }
            }
            copyOnWriteArrayList0.add(new WeakReference(e0));
            ((Handler)o0.d).post(new l(24, o0, e0));
            return;
        }
        this.m = 0;
        this.k = this.a(0);
    }

    public final long a(int v) {
        Y y0 = this.a;
        Long long0 = (Long)y0.get(v);
        if(long0 == null) {
            long0 = (Long)y0.get(0);
        }
        if(long0 == null) {
            long0 = 1000000L;
        }
        return (long)long0;
    }

    public final void b(int v, long v1, long v2) {
        if(v != 0 || v1 != 0L || v2 != this.l) {
            this.l = v2;
            for(Object object0: this.b.a) {
                b b0 = (b)object0;
                if(!b0.c) {
                    com.google.android.exoplayer2.audio.c c0 = new com.google.android.exoplayer2.audio.c(b0, v, 2, v1, v2);
                    b0.a.post(c0);
                }
            }
        }
    }
}

