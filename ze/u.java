package Ze;

import De.I;
import Tf.v;
import d3.g;
import kotlin.jvm.internal.q;
import qf.b;
import qf.c;

public abstract class u {
    public static final c a;
    public static final b b;

    static {
        c c0 = new c("kotlin.jvm.JvmField");
        u.a = c0;
        g.i0(c0);
        g.i0(new c("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
        u.b = g.J("kotlin/jvm/internal/RepeatableContainer", false);
    }

    public static final String a(String s) {
        q.g(s, "propertyName");
        return u.c(s) ? s : "get" + I.p(s);
    }

    public static final String b(String s) {
        String s1;
        StringBuilder stringBuilder0 = new StringBuilder("set");
        if(u.c(s)) {
            s1 = s.substring(2);
            q.f(s1, "substring(...)");
        }
        else {
            s1 = I.p(s);
        }
        stringBuilder0.append(s1);
        return stringBuilder0.toString();
    }

    public static final boolean c(String s) {
        q.g(s, "name");
        if(v.r0(s, "is", false) && s.length() != 2) {
            int v = s.charAt(2);
            return q.h(97, v) > 0 || q.h(v, 0x7A) > 0;
        }
        return false;
    }
}

