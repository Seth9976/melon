package j5;

import Ac.F2;
import N0.L;
import N0.N;
import N0.O;
import N0.a0;
import N0.y;
import i5.k;
import je.x;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import r1.a;
import u5.h;

public final class r implements y, h {
    public final MutableStateFlow a;

    public r() {
        this.a = StateFlowKt.MutableStateFlow(new a(A.a));
    }

    @Override  // u5.h
    public final Object c(k k0) {
        return FlowKt.first(new F2(this.a, 15), k0);
    }

    @Override  // N0.y
    public final N measure-3p2s80s(O o0, L l0, long v) {
        a a0 = new a(v);
        this.a.setValue(a0);
        a0 a00 = l0.O(v);
        int v1 = a00.a;
        int v2 = a00.b;
        p p0 = new p(a00, 0);
        return o0.w(v1, v2, x.a, p0);
    }
}

