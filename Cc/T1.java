package Cc;

import De.I;
import androidx.compose.runtime.l;
import ie.H;
import j5.d;
import j5.e;
import j5.w;
import kotlin.jvm.internal.q;
import r0.n;
import we.p;

public final class t1 implements p {
    public final int a;
    public final boolean b;
    public final int c;
    public final String d;

    public t1(int v, int v1, boolean z, String s) {
        this.a = v1;
        this.b = z;
        this.c = v;
        this.d = s;
        super();
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        if(this.a != 0) {
            int v = (int)(((Integer)object3));
            q.g(((w)object0), "$this$SubcomposeAsyncImage");
            q.g(((d)object1), "it");
            if((v & 6) == 0) {
                v |= (((androidx.compose.runtime.p)(((l)object2))).g(((w)object0)) ? 4 : 2);
            }
            if(((androidx.compose.runtime.p)(((l)object2))).Q(v & 1, (v & 0x83) != 130)) {
                if(this.b) {
                    ((androidx.compose.runtime.p)(((l)object2))).a0(0xA3626A8D);
                    r0.q q0 = androidx.compose.foundation.layout.d.u(n.a, 3);
                    r0.q q1 = ((w)object0).a.a(q0, r0.d.e);
                    androidx.compose.foundation.q.c(I.Q(this.c, ((androidx.compose.runtime.p)(((l)object2))), 0), this.d, q1, null, null, 0.0f, null, ((androidx.compose.runtime.p)(((l)object2))), 0, 120);
                }
                else {
                    ((androidx.compose.runtime.p)(((l)object2))).a0(0xA2FCFBEF);
                }
                ((androidx.compose.runtime.p)(((l)object2))).p(false);
                return H.a;
            }
            ((androidx.compose.runtime.p)(((l)object2))).T();
            return H.a;
        }
        int v1 = (int)(((Integer)object3));
        q.g(((w)object0), "$this$SubcomposeAsyncImage");
        q.g(((e)object1), "it");
        if((v1 & 6) == 0) {
            v1 |= (((androidx.compose.runtime.p)(((l)object2))).g(((w)object0)) ? 4 : 2);
        }
        if(((androidx.compose.runtime.p)(((l)object2))).Q(v1 & 1, (v1 & 0x83) != 130)) {
            if(this.b) {
                ((androidx.compose.runtime.p)(((l)object2))).a0(744008919);
                r0.q q2 = androidx.compose.foundation.layout.d.u(n.a, 3);
                r0.q q3 = ((w)object0).a.a(q2, r0.d.e);
                androidx.compose.foundation.q.c(I.Q(this.c, ((androidx.compose.runtime.p)(((l)object2))), 0), this.d, q3, null, null, 0.0f, null, ((androidx.compose.runtime.p)(((l)object2))), 0, 120);
            }
            else {
                ((androidx.compose.runtime.p)(((l)object2))).a0(0x2BED6299);
            }
            ((androidx.compose.runtime.p)(((l)object2))).p(false);
            return H.a;
        }
        ((androidx.compose.runtime.p)(((l)object2))).T();
        return H.a;
    }
}

