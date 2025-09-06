package l7;

import H8.i;
import N5.d;
import W.p;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import m7.a;

public final class c {
    public final double a;
    public final double b;
    public final long c;
    public final long d;
    public final int e;
    public final ArrayBlockingQueue f;
    public final ThreadPoolExecutor g;
    public final i h;
    public final p i;
    public int j;
    public long k;

    public c(i i0, a a0, p p0) {
        this.a = a0.d;
        this.b = a0.e;
        this.c = ((long)a0.f) * 1000L;
        this.h = i0;
        this.i = p0;
        this.d = SystemClock.elapsedRealtime();
        this.e = (int)a0.d;
        ArrayBlockingQueue arrayBlockingQueue0 = new ArrayBlockingQueue(((int)a0.d));
        this.f = arrayBlockingQueue0;
        this.g = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue0);
        this.j = 0;
        this.k = 0L;
    }

    public final int a() {
        if(this.k == 0L) {
            this.k = System.currentTimeMillis();
        }
        int v = (int)((System.currentTimeMillis() - this.k) / this.c);
        int v1 = this.f.size() == this.e ? Math.min(100, this.j + v) : Math.max(0, this.j - v);
        if(this.j != v1) {
            this.j = v1;
            this.k = System.currentTimeMillis();
        }
        return v1;
    }

    public final void b(e7.a a0, TaskCompletionSource taskCompletionSource0) {
        String s = "Sending report through Google DataTransport: " + a0.b;
        if(Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", s, null);
        }
        boolean z = SystemClock.elapsedRealtime() - this.d < 2000L;
        N5.a a1 = new N5.a(null, a0.a, d.c, null);
        b b0 = new b(z, this, taskCompletionSource0, a0);
        this.h.x(a1, b0);
    }
}

