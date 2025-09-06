package Dd;

import K.m;
import Q0.k0;
import X0.i;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import kotlin.jvm.internal.q;
import w0.h;
import we.k;
import we.o;

public final class q2 implements o {
    public final k a;
    public final boolean b;
    public final String c;
    public final String d;
    public final String e;
    public final StatsElementsBase f;
    public final int g;

    public q2(k k0, boolean z, String s, String s1, String s2, StatsElementsBase statsElementsBase0, int v) {
        this.a = k0;
        this.b = z;
        this.c = s;
        this.d = s1;
        this.e = s2;
        this.f = statsElementsBase0;
        this.g = v;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        ((Number)object2).intValue();
        q.g(((r0.q)object0), "$this$composed");
        ((p)(((l)object1))).a0(0x1FF03545);
        Object object3 = ((p)(((l)object1))).k(k0.i);
        m m0 = ((p)(((l)object1))).N();
        if(m0 == androidx.compose.runtime.k.a) {
            m0 = androidx.appcompat.app.o.d(((p)(((l)object1))));
        }
        r0.q q0 = androidx.compose.foundation.q.l(((r0.q)object0), m0, null, true, null, new i(0), new p2(((h)object3), this.a, this.b, this.c, this.d, this.e, this.f, this.g));
        ((p)(((l)object1))).p(false);
        return q0;
    }
}

