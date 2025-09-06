package Le;

import Je.i;
import Qf.a;
import kotlin.jvm.internal.q;
import qf.b;
import qf.c;
import qf.d;

public final class e implements a {
    public static final e a;

    static {
        e.a = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static Me.e a(Me.e e0) {
        d d0 = tf.e.g(e0);
        c c0 = (c)Le.d.k.get(d0);
        if(c0 == null) {
            throw new IllegalArgumentException("Given class " + e0 + " is not a read-only collection");
        }
        return xf.d.e(e0).j(c0);
    }

    public static Me.e b(c c0, i i0) {
        q.g(i0, "builtIns");
        b b0 = (b)Le.d.h.get(c0.a);
        return b0 == null ? null : i0.j(b0.a());
    }

    @Override  // Qf.a
    public Iterable j(Object object0) {
        return ((Me.c)object0).a().f();
    }
}

