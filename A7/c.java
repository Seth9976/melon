package a7;

import I7.k;
import android.util.Log;
import com.google.firebase.e;
import e7.m;
import e7.o;

public final class c {
    public final o a;

    public c(o o0) {
        this.a = o0;
    }

    public static c a() {
        c c0 = (c)e.c().b(c.class);
        if(c0 == null) {
            throw new NullPointerException("FirebaseCrashlytics component is not present.");
        }
        return c0;
    }

    public final void b(String s) {
        m m0 = new m(this.a, System.currentTimeMillis() - this.a.d, s, 0);
        this.a.o.a.a(m0);
    }

    public final void c(Throwable throwable0) {
        if(throwable0 == null) {
            Log.w("FirebaseCrashlytics", "A null value was passed to recordException. Ignoring.", null);
            return;
        }
        k k0 = new k(this.a, throwable0);
        this.a.o.a.a(k0);
    }
}

