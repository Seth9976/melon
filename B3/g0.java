package b3;

import android.os.SystemClock;

public final class g0 implements h0 {
    public final long a;
    public final long b;
    public final float c;

    public g0(long v, long v1, float f) {
        this.a = v;
        this.b = v1;
        this.c = f;
    }

    @Override  // b3.h0
    public final long get() {
        long v = SystemClock.elapsedRealtime();
        return this.a + ((long)(((float)(v - this.b)) * this.c));
    }
}

