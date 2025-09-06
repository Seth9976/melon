package androidx.compose.foundation.lazy.layout;

import A0.d;
import P0.K;
import androidx.appcompat.app.o;
import java.util.ArrayList;
import r0.p;

public final class q extends p implements P0.p {
    public s a;

    @Override  // P0.p
    public final void draw(d d0) {
        ArrayList arrayList0 = this.a.h;
        if(arrayList0.size() <= 0) {
            ((K)d0).a();
            return;
        }
        o.z(arrayList0.get(0));
        throw null;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof q ? kotlin.jvm.internal.q.b(this.a, ((q)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override  // r0.p
    public final void onAttach() {
        this.a.getClass();
    }

    @Override  // r0.p
    public final void onDetach() {
        s s0 = this.a;
        s0.d();
        s0.b = null;
    }

    @Override
    public final String toString() {
        return "DisplayingDisappearingItemsNode(animator=" + this.a + ')';
    }
}

