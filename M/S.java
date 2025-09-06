package M;

import N0.L;
import N0.M;
import N0.N;
import N0.O;
import N0.a0;
import java.util.List;
import je.x;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.q;
import r0.e;
import r1.a;
import r1.b;
import r1.i;

public final class s implements M {
    public final e a;
    public final boolean b;

    public s(e e0, boolean z) {
        this.a = e0;
        this.b = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof s)) {
            return false;
        }
        return q.b(this.a, ((s)object0).a) ? this.b == ((s)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.b) + this.a.hashCode() * 0x1F;
    }

    @Override  // N0.M
    public final N measure-3p2s80s(O o0, List list0, long v) {
        int v4;
        int v3;
        x x0 = x.a;
        if(list0.isEmpty()) {
            return o0.w(a.j(v), a.i(v), x0, n.h);
        }
        long v1 = this.b ? v : v & 0xFFFFFFFE00000003L;
        l l0 = null;
        int v2 = 1;
        if(list0.size() == 1) {
            L l1 = (L)list0.get(0);
            Object object0 = l1.q();
            if(object0 instanceof l) {
                l0 = (l)object0;
            }
            if(!(l0 == null ? false : l0.b)) {
                a0 a00 = l1.O(v1);
                v3 = Math.max(a.j(v), a00.a);
                v4 = Math.max(a.i(v), a00.b);
                return o0.w(v3, v4, x0, new M.q(a00, l1, o0, v3, v4, this));
            }
            v3 = a.j(v);
            v4 = a.i(v);
            int v5 = a.j(v);
            int v6 = a.i(v);
            if(v6 < 0) {
                v2 = 0;
            }
            if((v2 & (v5 < 0 ? 0 : 1)) == 0) {
                i.a("width and height must be >= 0");
            }
            return o0.w(v3, v4, x0, new M.q(l1.O(b.h(v5, v5, v6, v6)), l1, o0, v3, v4, this));
        }
        a0[] arr_a0 = new a0[list0.size()];
        F f0 = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
        f0.a = a.j(v);
        F f1 = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
        f1.a = a.i(v);
        int v7 = list0.size();
        boolean z = false;
        for(int v8 = 0; v8 < v7; ++v8) {
            L l2 = (L)list0.get(v8);
            Object object1 = l2.q();
            l l3 = object1 instanceof l ? ((l)object1) : null;
            if((l3 == null ? false : l3.b)) {
                z = true;
            }
            else {
                a0 a01 = l2.O(v1);
                arr_a0[v8] = a01;
                f0.a = Math.max(f0.a, a01.a);
                f1.a = Math.max(f1.a, a01.b);
            }
        }
        if(z) {
            long v9 = b.a((f0.a == 0x7FFFFFFF ? 0 : f0.a), f0.a, (f1.a == 0x7FFFFFFF ? 0 : f1.a), f1.a);
            int v10 = list0.size();
            for(int v11 = 0; v11 < v10; ++v11) {
                L l4 = (L)list0.get(v11);
                Object object2 = l4.q();
                l l5 = object2 instanceof l ? ((l)object2) : null;
                if((l5 == null ? false : l5.b)) {
                    arr_a0[v11] = l4.O(v9);
                }
            }
        }
        return o0.w(f0.a, f1.a, x0, new r(arr_a0, list0, o0, f0, f1, this));
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("BoxMeasurePolicy(alignment=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", propagateMinConstraints=");
        return H0.b.k(stringBuilder0, this.b, ')');
    }
}

