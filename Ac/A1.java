package Ac;

import K.m;
import Q0.k0;
import X0.i;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.melon.net.res.v3.CommentConfig;
import com.melon.net.res.v3.CommentUiModel;
import kotlin.jvm.internal.q;
import w0.h;
import we.k;
import we.o;

public final class a1 implements o {
    public final k a;
    public final CommentConfig b;
    public final CommentUiModel c;
    public final boolean d;

    public a1(k k0, CommentConfig commentConfig0, CommentUiModel commentUiModel0, boolean z) {
        this.a = k0;
        this.b = commentConfig0;
        this.c = commentUiModel0;
        this.d = z;
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
        r0.q q0 = androidx.compose.foundation.q.l(((r0.q)object0), m0, null, true, null, new i(0), new Z0(((h)object3), this.a, this.b, this.c, this.d));
        ((p)(((l)object1))).p(false);
        return q0;
    }
}

