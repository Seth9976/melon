package qc;

import i.n.i.b.a.s.e.M3;
import java.util.Collections;
import java.util.Comparator;
import kotlin.jvm.internal.q;
import lc.i;
import oc.p0;
import oc.q0;
import oc.r0;
import oc.s0;
import oc.t0;
import oc.u0;
import oc.v0;
import oc.w0;
import oc.x0;
import oc.y0;

public final class w extends i {
    public final Comparator a(y0 y00) {
        q.g(y00, "sortType");
        if(y00.equals(t0.b)) {
            return i.a;
        }
        if(y00.equals(s0.b)) {
            return i.c;
        }
        boolean z = y00.equals(u0.b);
        Comparator comparator0 = i.b;
        if(z) {
            return comparator0;
        }
        if(y00.equals(v0.b)) {
            Comparator comparator1 = Collections.reverseOrder(comparator0);
            q.f(comparator1, "reverseOrder(...)");
            return comparator1;
        }
        if(y00.equals(q0.b)) {
            return i.e;
        }
        if(y00.equals(r0.b)) {
            return i.f;
        }
        boolean z1 = y00.equals(w0.b);
        Comparator comparator2 = i.g;
        if(z1) {
            return comparator2;
        }
        if(y00.equals(x0.b)) {
            Comparator comparator3 = Collections.reverseOrder(comparator2);
            q.f(comparator3, "reverseOrder(...)");
            return comparator3;
        }
        if(!y00.equals(p0.b)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return i.h;
    }
}

