package rd;

import M.v;
import N0.j;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.c;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import ie.m;
import kotlin.jvm.internal.q;
import r0.n;
import wc.u;
import we.o;
import y0.s;

public final class j0 implements o {
    public final String a;
    public final long b;
    public final long c;

    public j0(String s, long v, long v1) {
        this.a = s;
        this.b = v;
        this.c = v1;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        int v = (int)(((Integer)object2));
        q.g(((v)object0), "$this$BoxWithConstraints");
        if((v & 6) == 0) {
            v |= (((p)(((l)object1))).g(((v)object0)) ? 4 : 2);
        }
        if(((p)(((l)object1))).Q(v & 1, (v & 19) != 18)) {
            float f = ((c)(((v)object0))).b();
            float f1 = ((c)(((v)object0))).c();
            a.u(androidx.compose.foundation.layout.a.d(1.0f, d.f(n.a, 1.0f), false), this.a, null, j.b, 0x7F080787, ((p)(((l)object1))), 0x36D86, 0);  // drawable:noimage_logo_large_w
            float f2 = 120.0f + (f - f1);
            r0.q q0 = androidx.compose.foundation.q.e(d.h(d.f(n.a, 1.0f), f2), u.g(new m[]{new m(0.0f, new s(s.c(this.b, 0.0f))), new m(((float)(80.0f / f2)), new s(s.c(this.b, 0.9f))), new m(((float)(120.0f / f2)), new s(s.c(this.b, 1.0f))), new m(1.0f, new s(s.c(this.b, 1.0f)))}), null, 6);
            M.p.a((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q0, r0.d.h), ((p)(((l)object1))), 0);
            r0.q q1 = androidx.compose.foundation.q.e(d.h(d.f(n.a, 1.0f), f2), u.g(new m[]{new m(0.0f, new s(s.c(this.c, 0.0f))), new m(((float)(80.0f / f2)), new s(s.c(this.c, 0.15f))), new m(((float)(120.0f / f2)), new s(s.c(this.c, 0.18f))), new m(1.0f, new s(s.c(this.c, 0.18f)))}), null, 6);
            M.p.a((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q1, r0.d.h), ((p)(((l)object1))), 0);
            return H.a;
        }
        ((p)(((l)object1))).T();
        return H.a;
    }
}

