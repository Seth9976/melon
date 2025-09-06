package androidx.media3.session;

import android.os.Bundle;
import android.os.SystemClock;
import e3.b;

public final class w1 {
    public final int a;
    public final Bundle b;
    public final long c;
    public final u1 d;
    public static final String e;
    public static final String f;
    public static final String g;
    public static final String h;

    static {
        w1.e = "0";
        w1.f = "1";
        w1.g = "2";
        w1.h = "3";
    }

    public w1(int v) {
        this(v, Bundle.EMPTY);
    }

    public w1(int v, Bundle bundle0) {
        this(v, bundle0, SystemClock.elapsedRealtime(), null);
    }

    public w1(int v, Bundle bundle0, long v1, u1 u10) {
        b.c(u10 == null || v < 0);
        this.a = v;
        this.b = new Bundle(bundle0);
        this.c = v1;
        if(u10 == null && v < 0) {
            u10 = new u1(v, "no error message provided");
        }
        this.d = u10;
    }

    public static w1 a(Bundle bundle0) {
        u1 u10;
        int v = bundle0.getInt(w1.e, -1);
        Bundle bundle1 = bundle0.getBundle(w1.f);
        long v1 = SystemClock.elapsedRealtime();
        long v2 = bundle0.getLong(w1.g, v1);
        Bundle bundle2 = bundle0.getBundle(w1.h);
        if(bundle2 == null) {
            u10 = v == 0 ? null : new u1(v, "no error message provided");
        }
        else {
            u10 = u1.a(bundle2);
        }
        if(bundle1 == null) {
            bundle1 = Bundle.EMPTY;
        }
        return new w1(v, bundle1, v2, u10);
    }

    public final Bundle b() {
        Bundle bundle0 = new Bundle();
        bundle0.putInt("0", this.a);
        bundle0.putBundle("1", this.b);
        bundle0.putLong("2", this.c);
        u1 u10 = this.d;
        if(u10 != null) {
            bundle0.putBundle("3", u10.b());
        }
        return bundle0;
    }
}

