package Ge;

import Hf.x;
import Me.L;
import Me.c;
import Pe.m;
import Pe.u;
import java.util.List;
import je.p;
import kotlin.jvm.internal.q;
import qf.e;
import sf.g;

public abstract class x0 {
    public static final g a;

    static {
        x0.a = g.c;
    }

    public static void a(c c0, StringBuilder stringBuilder0) {
        u u0 = A0.g(c0);
        u u1 = c0.Q();
        if(u0 != null) {
            stringBuilder0.append(x0.d(u0.getType()));
            stringBuilder0.append(".");
        }
        boolean z = u0 != null && u1 != null;
        if(z) {
            stringBuilder0.append("(");
        }
        if(u1 != null) {
            stringBuilder0.append(x0.d(u1.getType()));
            stringBuilder0.append(".");
        }
        if(z) {
            stringBuilder0.append(")");
        }
    }

    public static String b(Me.u u0) {
        q.g(u0, "descriptor");
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("fun ");
        x0.a(u0, stringBuilder0);
        e e0 = ((m)u0).getName();
        q.f(e0, "getName(...)");
        stringBuilder0.append(x0.a.O(e0, true));
        List list0 = u0.F();
        q.f(list0, "getValueParameters(...)");
        p.p0(list0, stringBuilder0, ", ", "(", ")", b.h, 0x30);
        stringBuilder0.append(": ");
        x x0 = u0.getReturnType();
        q.d(x0);
        stringBuilder0.append(x0.d(x0));
        return stringBuilder0.toString();
    }

    public static String c(L l0) {
        q.g(l0, "descriptor");
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append((l0.P() ? "var " : "val "));
        x0.a(l0, stringBuilder0);
        e e0 = l0.getName();
        q.f(e0, "getName(...)");
        stringBuilder0.append(x0.a.O(e0, true));
        stringBuilder0.append(": ");
        x x0 = l0.getType();
        q.f(x0, "getType(...)");
        stringBuilder0.append(x0.d(x0));
        return stringBuilder0.toString();
    }

    public static String d(x x0) {
        q.g(x0, "type");
        return x0.a.X(x0);
    }
}

