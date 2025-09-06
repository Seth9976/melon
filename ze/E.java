package Ze;

import Me.u;
import Pe.m;
import kotlin.jvm.internal.q;
import xf.d;

public abstract class e extends E {
    public static final int l;

    public static final u a(u u0) {
        q.g(u0, "functionDescriptor");
        qf.e e0 = ((m)u0).getName();
        q.f(e0, "getName(...)");
        return e.b(e0) ? ((u)d.b(u0, Ze.d.b)) : null;
    }

    public static boolean b(qf.e e0) {
        q.g(e0, "<this>");
        return E.e.contains(e0);
    }
}

