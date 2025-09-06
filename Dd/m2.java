package Dd;

import K.m;
import Q0.k0;
import X0.i;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.melon.net.res.common.ArtistPlayListWrapperInfoBase;
import kotlin.jvm.internal.q;
import w0.h;
import we.k;
import we.o;

public final class m2 implements o {
    public final int a;
    public final k b;
    public final ArtistPlayListWrapperInfoBase c;
    public final int d;

    public m2(k k0, ArtistPlayListWrapperInfoBase artistPlayListWrapperInfoBase0, int v, int v1) {
        this.a = v1;
        this.b = k0;
        this.c = artistPlayListWrapperInfoBase0;
        this.d = v;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        if(this.a != 0) {
            ((Number)object2).intValue();
            q.g(((r0.q)object0), "$this$composed");
            ((p)(((l)object1))).a0(0x1FF03545);
            Object object3 = ((p)(((l)object1))).k(k0.i);
            m m0 = ((p)(((l)object1))).N();
            if(m0 == androidx.compose.runtime.k.a) {
                m0 = androidx.appcompat.app.o.d(((p)(((l)object1))));
            }
            r0.q q0 = androidx.compose.foundation.q.l(((r0.q)object0), m0, null, true, null, new i(0), new l2(((h)object3), this.b, this.c, this.d, 1));
            ((p)(((l)object1))).p(false);
            return q0;
        }
        ((Number)object2).intValue();
        q.g(((r0.q)object0), "$this$composed");
        ((p)(((l)object1))).a0(0x1FF03545);
        Object object4 = ((p)(((l)object1))).k(k0.i);
        m m1 = ((p)(((l)object1))).N();
        if(m1 == androidx.compose.runtime.k.a) {
            m1 = androidx.appcompat.app.o.d(((p)(((l)object1))));
        }
        r0.q q1 = androidx.compose.foundation.q.l(((r0.q)object0), m1, null, true, null, new i(0), new l2(((h)object4), this.b, this.c, this.d, 0));
        ((p)(((l)object1))).p(false);
        return q1;
    }
}

