package B7;

import java.util.concurrent.TimeUnit;
import w7.d;
import z7.j;

public final class e {
    public final j a;
    public long b;
    public int c;
    public static final long d;
    public static final long e;

    static {
        e.d = TimeUnit.HOURS.toMillis(24L);
        e.e = TimeUnit.MINUTES.toMillis(30L);
    }

    public e() {
        if(d.b == null) {
            d.b = new d(8);
        }
        d d0 = d.b;
        if(j.d == null) {
            j.d = new j(d0);
        }
        this.a = j.d;
    }

    public final boolean a() {
        boolean z;
        synchronized(this) {
            if(this.c == 0) {
                z = true;
            }
            else {
                this.a.a.getClass();
                z = System.currentTimeMillis() <= this.b ? false : true;
            }
            return z;
        }
    }

    public final void b(int v) {
        double f;
        long v1;
        synchronized(this) {
            if((v < 200 || v >= 300) && (v != 401 && v != 404)) {
                ++this.c;
                __monitor_enter(this);
                goto label_4;
            }
            goto label_20;
        }
        try {
        label_4:
            if(v == 429 || v >= 500 && v < 600) {
                goto label_8;
            }
            else {
                v1 = e.d;
                goto label_6;
            }
            goto label_16;
        }
        catch(Throwable throwable1) {
            goto label_12;
        }
    label_6:
        __monitor_exit(this);
        goto label_16;
        try {
        label_8:
            f = Math.pow(2.0, this.c);
            this.a.getClass();
        }
        catch(Throwable throwable1) {
            try {
            label_12:
                __monitor_exit(this);
                throw throwable1;
            }
            catch(Throwable throwable0) {
                __monitor_exit(this);
                throw throwable0;
            }
        }
        v1 = (long)Math.min(f + ((double)(((long)(Math.random() * 1000.0)))), e.e);
        __monitor_exit(this);
        try {
        label_16:
            this.a.a.getClass();
            this.b = System.currentTimeMillis() + v1;
        }
        catch(Throwable throwable0) {
            __monitor_exit(this);
            throw throwable0;
        }
        __monitor_exit(this);
        return;
        try {
        label_20:
            __monitor_enter(this);
        }
        catch(Throwable throwable0) {
            __monitor_exit(this);
            throw throwable0;
        }
        this.c = 0;
        __monitor_exit(this);
        __monitor_exit(this);
    }
}

