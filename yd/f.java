package yd;

import K.m;
import Q0.k0;
import X0.i;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import kotlin.jvm.internal.q;
import w0.h;
import we.k;
import we.o;
import zd.Q;

public final class f implements o {
    public final int a;
    public final MelonBottomSheetItem b;
    public final k c;
    public final int d;
    public final Q e;

    public f(MelonBottomSheetItem melonBottomSheetItem0, k k0, int v, Q q0, int v1) {
        this.a = v1;
        this.b = melonBottomSheetItem0;
        this.c = k0;
        this.d = v;
        this.e = q0;
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
            r0.q q0 = androidx.compose.foundation.q.l(((r0.q)object0), m0, null, true, null, new i(0), new e(((h)object3), this.b, this.c, this.d, this.e, 1));
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
        r0.q q1 = androidx.compose.foundation.q.l(((r0.q)object0), m1, null, true, null, new i(0), new e(((h)object4), this.b, this.c, this.d, this.e, 0));
        ((p)(((l)object1))).p(false);
        return q1;
    }
}

