package w3;

import android.os.SystemClock;

public final class e {
    public final f a;

    public e(f f0) {
        this.a = f0;
    }

    public final void a(int v) {
        f f0 = this.a;
        __monitor_enter(f0);
        int v1 = f0.m;
        if(v1 != 0 && !f0.d) {
            __monitor_exit(f0);
            return;
        }
        if(v1 == v) {
            __monitor_exit(f0);
            return;
        }
        f0.m = v;
        if(v != 0 && v != 1 && v != 8) {
            try {
                f0.k = f0.a(v);
                f0.c.getClass();
                long v2 = SystemClock.elapsedRealtime();
                f0.b((f0.f <= 0 ? 0 : ((int)(v2 - f0.g))), f0.h, f0.k);
                f0.g = v2;
                f0.h = 0L;
                f0.j = 0L;
                f0.i = 0L;
                f0.e.b.clear();
                f0.e.d = -1;
                f0.e.e = 0;
                f0.e.f = 0;
            }
            catch(Throwable throwable0) {
                __monitor_exit(f0);
                throw throwable0;
            }
            __monitor_exit(f0);
            return;
        }
        __monitor_exit(f0);
    }
}

