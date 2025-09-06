package r0;

import F.e;
import androidx.compose.runtime.p;
import androidx.compose.ui.ZIndexElement;
import we.o;

public abstract class a {
    public static final f a;
    public static final f b;
    public static final StackTraceElement[] c;

    static {
        a.a = new f(-1.0f);
        a.b = new f(1.0f);
        a.c = new StackTraceElement[0];
    }

    public static final q a(q q0, o o0) {
        return q0.then(new l(o0));
    }

    public static final q c(androidx.compose.runtime.l l0, q q0) {
        if(q0.all(m.f)) {
            return q0;
        }
        ((p)l0).b0(1219399079);
        e e0 = new e(((p)l0), 22);
        q q1 = (q)q0.foldIn(n.a, e0);
        ((p)l0).p(false);
        return q1;
    }

    public static final q d(androidx.compose.runtime.l l0, q q0) {
        ((p)l0).a0(0x1A365F2C);
        q q1 = a.c(((p)l0), q0);
        ((p)l0).p(false);
        return q1;
    }

    public static final q e(q q0, float f) {
        return q0.then(new ZIndexElement(f));
    }
}

