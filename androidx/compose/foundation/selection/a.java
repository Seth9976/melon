package androidx.compose.foundation.selection;

import K.l;
import K.m;
import androidx.compose.foundation.f0;
import androidx.compose.foundation.i0;
import androidx.compose.foundation.l0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.p;
import kotlin.jvm.internal.r;
import r0.n;
import r0.q;
import we.o;

public final class a extends r implements o {
    public final boolean f;
    public final we.a g;

    public a(boolean z, we.a a0) {
        this.f = z;
        this.g = a0;
        super(3);
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        q q1;
        l l0;
        q q0 = (q)object0;
        ((Number)object2).intValue();
        ((p)(((androidx.compose.runtime.l)object1))).a0(0x815D0778);
        f0 f00 = (f0)((p)(((androidx.compose.runtime.l)object1))).k(i0.a);
        if(f00 instanceof l0) {
            ((p)(((androidx.compose.runtime.l)object1))).a0(0xABD3ED76);
            ((p)(((androidx.compose.runtime.l)object1))).p(false);
            l0 = null;
        }
        else {
            ((p)(((androidx.compose.runtime.l)object1))).a0(0xABD5F380);
            m m0 = ((p)(((androidx.compose.runtime.l)object1))).N();
            if(m0 == k.a) {
                m0 = androidx.appcompat.app.o.d(((p)(((androidx.compose.runtime.l)object1))));
            }
            l0 = m0;
            ((p)(((androidx.compose.runtime.l)object1))).p(false);
        }
        boolean z = this.f;
        we.a a0 = this.g;
        if(f00 instanceof l0) {
            q1 = new SelectableElement(z, l0, ((l0)f00), a0);
        }
        else if(f00 == null) {
            q1 = new SelectableElement(z, l0, null, a0);
        }
        else if(l0 == null) {
            b b0 = new b(f00, z, a0);
            q1 = r0.a.a(n.a, b0);
        }
        else {
            q1 = i0.a(l0, f00).then(new SelectableElement(z, l0, null, a0));
        }
        ((p)(((androidx.compose.runtime.l)object1))).p(false);
        return q1;
    }
}

