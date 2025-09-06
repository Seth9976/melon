package U;

import Ld.p;
import N0.L;
import N0.M;
import N0.N;
import N0.O;
import N0.a0;
import androidx.compose.runtime.I0;
import androidx.compose.runtime.K0;
import androidx.compose.ui.layout.a;
import b0.F;
import b0.J;
import b0.Q;
import java.util.List;
import java.util.NoSuchElementException;
import je.x;
import r1.b;

public final class h0 implements M {
    public final int a;
    public final Object b;

    public h0(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // N0.M
    public final N measure-3p2s80s(O o0, List list0, long v) {
        if(this.a != 0) {
            Q q0 = (Q)this.b;
            int v1 = list0.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                L l0 = (L)list0.get(v2);
                if(a.a(l0) == F.a) {
                    a0 a00 = l0.O(v);
                    int v3 = list0.size();
                    for(int v4 = 0; v4 < v3; ++v4) {
                        L l1 = (L)list0.get(v4);
                        if(a.a(l1) == F.b) {
                            a0 a01 = l1.O(r1.a.a(b.i(-a00.a, 0, v), 0, 0, 0, 0, 11));
                            int v5 = a00.a + a01.a;
                            int v6 = Math.max(a01.b, a00.b);
                            ((I0)q0.h).n(((float)a01.b));
                            ((K0)q0.f).n(v5);
                            int v7 = a00.a / 2;
                            float f = (float)a01.a;
                            float f1 = P4.a.i(q0.b(), q0.b.a, q0.b.b);
                            float f2 = q0.b.b - q0.b.a;
                            int v8 = ye.a.V(P4.a.i((f2 == 0.0f ? 0.0f : (f1 - q0.b.a) / f2), 0.0f, 1.0f) * f);
                            J j0 = new J(a01, v7, (v6 - a01.b) / 2, a00, v8, (v6 - a00.b) / 2);
                            return o0.w(v5, v6, x.a, j0);
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        p p0 = new p(15, list0, this);
        return o0.w(r1.a.h(v), r1.a.g(v), x.a, p0);
    }
}

