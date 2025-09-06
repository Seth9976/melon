package m0;

import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import ie.f;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.q;
import we.n;

public abstract class c {
    public static final Object a;
    public static final h b;

    static {
        c.a = new Object();
        c.b = new h(0, new long[0], new Object[0]);
    }

    public static final int a(int v, int v1) [...] // Inlined contents

    public static final b b(int v, l l0, f f0) {
        b b0;
        ((p)l0).X(Integer.rotateLeft(v, 1), c.a);
        Object object0 = ((p)l0).N();
        if(object0 == k.a) {
            b0 = new b(v, f0, true);
            ((p)l0).l0(b0);
        }
        else {
            q.e(object0, "null cannot be cast to non-null type androidx.compose.runtime.internal.ComposableLambdaImpl");
            b0 = (b)object0;
            b0.j(f0);
        }
        ((p)l0).p(false);
        return b0;
    }

    public static final long c() [...] // 潜在的解密器

    public static final void d(p p0, n n0) {
        q.e(n0, "null cannot be cast to non-null type kotlin.Function2<androidx.compose.runtime.Composer, kotlin.Int, kotlin.Unit>");
        N.e(2, n0);
        n0.invoke(p0, 1);
    }

    public static final b e(int v, l l0, f f0) {
        b b0 = ((p)l0).N();
        if(b0 == k.a) {
            b0 = new b(v, f0, true);
            ((p)l0).l0(b0);
        }
        b0.j(f0);
        return b0;
    }

    // 去混淆评级： 低(40)
    public static final boolean f(n0 n00, n0 n01) {
        return n00 == null || n00 instanceof n0 && (!n00.b() || n00.equals(n01) || q.b(n00.c, n01.c));
    }
}

