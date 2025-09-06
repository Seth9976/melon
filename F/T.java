package F;

import N0.L;
import N0.M;
import N0.N;
import N0.O;
import N0.a0;
import N0.p;
import N0.q;
import androidx.compose.runtime.O0;
import e.k;
import java.util.ArrayList;
import java.util.List;
import je.x;
import r1.l;

public final class t implements M {
    public final F a;
    public boolean b;

    public t(F f0) {
        this.a = f0;
    }

    @Override  // N0.M
    public final int maxIntrinsicHeight(q q0, List list0, int v) {
        if(list0.isEmpty()) {
            return 0;
        }
        int v1 = ((p)list0.get(0)).d(v);
        int v2 = k.s(list0);
        if(1 <= v2) {
            for(int v3 = 1; true; ++v3) {
                int v4 = ((p)list0.get(v3)).d(v);
                if(v4 > v1) {
                    v1 = v4;
                }
                if(v3 == v2) {
                    break;
                }
            }
        }
        return v1;
    }

    @Override  // N0.M
    public final int maxIntrinsicWidth(q q0, List list0, int v) {
        if(list0.isEmpty()) {
            return 0;
        }
        int v1 = ((p)list0.get(0)).N(v);
        int v2 = k.s(list0);
        if(1 <= v2) {
            for(int v3 = 1; true; ++v3) {
                int v4 = ((p)list0.get(v3)).N(v);
                if(v4 > v1) {
                    v1 = v4;
                }
                if(v3 == v2) {
                    break;
                }
            }
        }
        return v1;
    }

    @Override  // N0.M
    public final N measure-3p2s80s(O o0, List list0, long v) {
        ArrayList arrayList0 = new ArrayList(list0.size());
        int v1 = list0.size();
        int v3 = 0;
        int v4 = 0;
        for(int v2 = 0; v2 < v1; ++v2) {
            a0 a00 = ((L)list0.get(v2)).O(v);
            v3 = Math.max(v3, a00.a);
            v4 = Math.max(v4, a00.b);
            arrayList0.add(a00);
        }
        boolean z = o0.u();
        F f0 = this.a;
        if(z) {
            this.b = true;
            l l0 = new l(0xFFFFFFFFL & ((long)v4) | ((long)v3) << 0x20);
            ((O0)f0.a).setValue(l0);
        }
        else if(!this.b) {
            l l1 = new l(0xFFFFFFFFL & ((long)v4) | ((long)v3) << 0x20);
            ((O0)f0.a).setValue(l1);
        }
        s s0 = new s(0, arrayList0);
        return o0.w(v3, v4, x.a, s0);
    }

    @Override  // N0.M
    public final int minIntrinsicHeight(q q0, List list0, int v) {
        if(list0.isEmpty()) {
            return 0;
        }
        int v1 = ((p)list0.get(0)).C(v);
        int v2 = k.s(list0);
        if(1 <= v2) {
            for(int v3 = 1; true; ++v3) {
                int v4 = ((p)list0.get(v3)).C(v);
                if(v4 > v1) {
                    v1 = v4;
                }
                if(v3 == v2) {
                    break;
                }
            }
        }
        return v1;
    }

    @Override  // N0.M
    public final int minIntrinsicWidth(q q0, List list0, int v) {
        if(list0.isEmpty()) {
            return 0;
        }
        int v1 = ((p)list0.get(0)).L(v);
        int v2 = k.s(list0);
        if(1 <= v2) {
            for(int v3 = 1; true; ++v3) {
                int v4 = ((p)list0.get(v3)).L(v);
                if(v4 > v1) {
                    v1 = v4;
                }
                if(v3 == v2) {
                    break;
                }
            }
        }
        return v1;
    }
}

