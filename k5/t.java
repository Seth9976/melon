package k5;

import android.os.Build.VERSION;
import n5.m;
import okio.BufferedSource;
import t5.o;

public final class t implements i {
    // 去混淆评级： 低(25)
    @Override  // k5.i
    public final j a(m m0, o o0) {
        BufferedSource bufferedSource0 = m0.a.p();
        return !bufferedSource0.rangeEquals(0L, r.b) && !bufferedSource0.rangeEquals(0L, r.a) && (!bufferedSource0.rangeEquals(0L, r.c) || !bufferedSource0.rangeEquals(8L, r.d) || !bufferedSource0.rangeEquals(12L, r.e) || !bufferedSource0.request(17L) || ((byte)(bufferedSource0.getBuffer().getByte(16L) & 2)) <= 0) && (Build.VERSION.SDK_INT < 30 || !bufferedSource0.rangeEquals(4L, r.f) || !bufferedSource0.rangeEquals(8L, r.g) && !bufferedSource0.rangeEquals(8L, r.h) && !bufferedSource0.rangeEquals(8L, r.i)) ? null : new y(m0.a, o0);
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof t;
    }

    @Override
    public final int hashCode() {
        return t.class.hashCode();
    }
}

