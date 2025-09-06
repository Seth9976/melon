package i.n.i.b.a.s.e;

import android.os.SystemClock;

public final class k4 {
    public final l4 a;

    public k4(l4 l40) {
        this.a = l40;
    }

    public final void a(int v) {
        l4 l40 = this.a;
        __monitor_enter(l40);
        int v1 = l40.i;
        if(v1 != 0 && !l40.e) {
            __monitor_exit(l40);
            return;
        }
        if(v1 == v) {
            __monitor_exit(l40);
            return;
        }
        l40.i = v;
        if(v != 0 && v != 1 && v != 8) {
            try {
                l40.l = l40.d(v);
                l40.d.getClass();
                long v2 = SystemClock.elapsedRealtime();
                int v3 = l40.f <= 0 ? 0 : ((int)(v2 - l40.g));
                long v4 = l40.h;
                long v5 = l40.l;
                if(v3 != 0 || v4 != 0L || v5 != l40.m) {
                    l40.m = v5;
                    l40.b.a(v3, v4, v5);
                }
                l40.g = v2;
                l40.h = 0L;
                l40.k = 0L;
                l40.j = 0L;
                l40.c.b.clear();
                l40.c.d = -1;
                l40.c.e = 0;
                l40.c.f = 0;
            }
            catch(Throwable throwable0) {
                __monitor_exit(l40);
                throw throwable0;
            }
            __monitor_exit(l40);
            return;
        }
        __monitor_exit(l40);
    }
}

