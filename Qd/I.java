package qd;

import M.v;
import androidx.compose.foundation.layout.c;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import e1.x;
import ie.H;
import kotlin.jvm.internal.q;
import we.a;
import we.k;
import we.o;

public final class i implements o {
    public final boolean a;
    public final long b;
    public final String c;
    public final long d;
    public final String e;
    public final long f;
    public final long g;
    public final k h;
    public final k i;
    public final k j;
    public final k k;
    public final a l;
    public final a m;

    public i(boolean z, long v, String s, long v1, String s1, long v2, long v3, k k0, k k1, k k2, k k3, a a0, a a1) {
        this.a = z;
        this.b = v;
        this.c = s;
        this.d = v1;
        this.e = s1;
        this.f = v2;
        this.g = v3;
        this.h = k0;
        this.i = k1;
        this.j = k2;
        this.k = k3;
        this.l = a0;
        this.m = a1;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        int v = (int)(((Integer)object2));
        q.g(((v)object0), "$this$BoxWithConstraints");
        if((v & 6) == 0) {
            v |= (((p)(((l)object1))).g(((v)object0)) ? 4 : 2);
        }
        if(!((p)(((l)object1))).Q(v & 1, (v & 19) != 18)) {
            ((p)(((l)object1))).T();
        }
        else if(Float.compare(((c)(((v)object0))).b(), 48.0f) >= 0) {
            x.g(d.c, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, ((p)(((l)object1))), 6);
            return H.a;
        }
        return H.a;
    }
}

