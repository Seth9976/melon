package androidx.compose.foundation.selection;

import K.m;
import androidx.compose.foundation.f0;
import androidx.compose.foundation.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import kotlin.jvm.internal.r;
import r0.q;
import we.a;
import we.o;

public final class b extends r implements o {
    public final f0 f;
    public final boolean g;
    public final a h;

    public b(f0 f00, boolean z, a a0) {
        this.f = f00;
        this.g = z;
        this.h = a0;
        super(3);
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        q q0 = (q)object0;
        ((Number)object2).intValue();
        ((p)(((l)object1))).a0(0xA50F4C47);
        m m0 = ((p)(((l)object1))).N();
        if(m0 == k.a) {
            m0 = androidx.appcompat.app.o.d(((p)(((l)object1))));
        }
        q q1 = i0.a(m0, this.f).then(new SelectableElement(this.g, m0, null, this.h));
        ((p)(((l)object1))).p(false);
        return q1;
    }
}

