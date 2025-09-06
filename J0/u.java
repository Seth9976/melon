package J0;

import android.view.MotionEvent;
import androidx.compose.ui.input.pointer.PointerHoverIconModifierElement;
import r0.q;
import we.k;
import x0.b;
import x9.c;

public abstract class u {
    public static final a a;
    public static final a b;
    public static final StackTraceElement[] c;

    static {
        u.a = new a(1000);
        new a(1007);
        new a(0x3F0);
        u.b = new a(1002);
        u.c = new StackTraceElement[0];
    }

    // 去混淆评级： 低(20)
    public static final boolean a(v v0) {
        return !v0.h && v0.d;
    }

    // 去混淆评级： 低(30)
    public static final boolean b(v v0) {
        return !v0.b() && v0.h && !v0.d;
    }

    // 去混淆评级： 低(20)
    public static final boolean c(v v0) {
        return v0.h && !v0.d;
    }

    public static final boolean d(long v, long v1) {
        return v == v1;
    }

    public static final boolean e(v v0, long v1, long v2) {
        int v3 = 0;
        int v4 = v0.i == 1 ? 1 : 0;
        float f = Float.intBitsToFloat(((int)(v0.c >> 0x20)));
        float f1 = Float.intBitsToFloat(((int)(v0.c & 0xFFFFFFFFL)));
        float f2 = Float.intBitsToFloat(((int)(v2 >> 0x20))) * ((float)v4);
        float f3 = Float.intBitsToFloat(((int)(v2 & 0xFFFFFFFFL))) * ((float)v4);
        if(f1 > ((float)(((int)(v1 & 0xFFFFFFFFL)))) + f3) {
            v3 = 1;
        }
        return (f > ((float)(((int)(v1 >> 0x20)))) + f2 ? 1 : 0) | (f < -f2 ? 1 : 0) | (f1 < -f3 ? 1 : 0) | v3;
    }

    public static q f(q q0, a a0) {
        return q0.then(new PointerHoverIconModifierElement(a0));
    }

    // 去混淆评级： 低(20)
    public static final long g(v v0, boolean z) {
        return z || !v0.b() ? b.f(v0.c, v0.g) : 0L;
    }

    public static final void h(n n0, long v, k k0, boolean z) {
        MotionEvent motionEvent0 = n0.b == null ? null : ((MotionEvent)((c)n0.b.d).c);
        if(motionEvent0 == null) {
            throw new IllegalArgumentException("The PointerEvent receiver cannot have a null MotionEvent.");
        }
        int v1 = motionEvent0.getAction();
        if(z) {
            motionEvent0.setAction(3);
        }
        motionEvent0.offsetLocation(-Float.intBitsToFloat(((int)(v >> 0x20))), -Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))));
        k0.invoke(motionEvent0);
        motionEvent0.offsetLocation(Float.intBitsToFloat(((int)(v >> 0x20))), Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))));
        motionEvent0.setAction(v1);
    }
}

