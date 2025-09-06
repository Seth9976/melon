package Fd;

import K.m;
import Q0.k0;
import X0.i;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.iloen.melon.net.v6x.response.SearchKeywordContent;
import kotlin.jvm.internal.q;
import w0.h;
import we.o;

public final class s implements o {
    public final int a;
    public final SearchKeywordContent b;
    public final D c;
    public final Z d;
    public final int e;

    public s(D d0, Z z0, SearchKeywordContent searchKeywordContent0, int v) {
        this.a = 0;
        super();
        this.c = d0;
        this.d = z0;
        this.b = searchKeywordContent0;
        this.e = v;
    }

    public s(SearchKeywordContent searchKeywordContent0, D d0, Z z0, int v, int v1) {
        this.a = v1;
        this.b = searchKeywordContent0;
        this.c = d0;
        this.d = z0;
        this.e = v;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        switch(this.a) {
            case 0: {
                ((Number)object2).intValue();
                q.g(((r0.q)object0), "$this$composed");
                ((p)(((l)object1))).a0(0x1FF03545);
                Object object4 = ((p)(((l)object1))).k(k0.i);
                m m1 = ((p)(((l)object1))).N();
                if(m1 == k.a) {
                    m1 = androidx.appcompat.app.o.d(((p)(((l)object1))));
                }
                r0.q q1 = androidx.compose.foundation.q.l(((r0.q)object0), m1, null, true, null, new i(0), new r(((h)object4), this.c, this.d, this.b, this.e));
                ((p)(((l)object1))).p(false);
                return q1;
            }
            case 1: {
                ((Number)object2).intValue();
                q.g(((r0.q)object0), "$this$composed");
                ((p)(((l)object1))).a0(0x1FF03545);
                Object object5 = ((p)(((l)object1))).k(k0.i);
                m m2 = ((p)(((l)object1))).N();
                if(m2 == k.a) {
                    m2 = androidx.appcompat.app.o.d(((p)(((l)object1))));
                }
                r0.q q2 = androidx.compose.foundation.q.l(((r0.q)object0), m2, null, true, null, new i(0), new r(((h)object5), this.b, this.c, this.d, this.e, 1));
                ((p)(((l)object1))).p(false);
                return q2;
            }
            default: {
                ((Number)object2).intValue();
                q.g(((r0.q)object0), "$this$composed");
                ((p)(((l)object1))).a0(0x1FF03545);
                Object object3 = ((p)(((l)object1))).k(k0.i);
                m m0 = ((p)(((l)object1))).N();
                if(m0 == k.a) {
                    m0 = androidx.appcompat.app.o.d(((p)(((l)object1))));
                }
                r0.q q0 = androidx.compose.foundation.q.l(((r0.q)object0), m0, null, true, null, new i(0), new r(((h)object3), this.b, this.c, this.d, this.e, 2));
                ((p)(((l)object1))).p(false);
                return q0;
            }
        }
    }
}

