package v1;

import F.B;
import N0.L;
import N0.M;
import N0.N;
import N0.O;
import N0.a0;
import java.util.ArrayList;
import java.util.List;
import je.x;

public final class h implements M {
    public static final h a;

    static {
        h.a = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // N0.M
    public final N measure-3p2s80s(O o0, List list0, long v) {
        x x0 = x.a;
        switch(list0.size()) {
            case 0: {
                return o0.w(0, 0, x0, d.j);
            }
            case 1: {
                a0 a01 = ((L)list0.get(0)).O(v);
                return o0.w(a01.a, a01.b, x0, new B(a01, 15));
            }
            default: {
                ArrayList arrayList0 = new ArrayList(list0.size());
                int v2 = list0.size();
                int v3 = 0;
                int v4 = 0;
                for(int v1 = 0; v1 < v2; ++v1) {
                    a0 a00 = ((L)list0.get(v1)).O(v);
                    v3 = Math.max(v3, a00.a);
                    v4 = Math.max(v4, a00.b);
                    arrayList0.add(a00);
                }
                return o0.w(v3, v4, x0, new xd.d(1, arrayList0));
            }
        }
    }
}

