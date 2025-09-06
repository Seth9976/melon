package N0;

import F.B;
import F.s;
import P0.F;
import java.util.ArrayList;
import java.util.List;
import je.x;
import r1.a;
import r1.b;

public final class d0 extends F {
    public static final d0 b;

    static {
        d0.b = new d0("Undefined intrinsics block and it is required");  // 初始化器: LP0/F;-><init>(Ljava/lang/String;)V
    }

    @Override  // N0.M
    public final N measure-3p2s80s(O o0, List list0, long v) {
        x x0 = x.a;
        switch(list0.size()) {
            case 0: {
                return o0.w(a.j(v), a.i(v), x0, b0.h);
            }
            case 1: {
                a0 a01 = ((L)list0.get(0)).O(v);
                return o0.w(b.g(a01.a, v), b.f(a01.b, v), x0, new B(a01, 8));
            }
            default: {
                ArrayList arrayList0 = new ArrayList(list0.size());
                int v2 = list0.size();
                int v3 = 0;
                int v4 = 0;
                for(int v1 = 0; v1 < v2; ++v1) {
                    a0 a00 = ((L)list0.get(v1)).O(v);
                    v3 = Math.max(a00.a, v3);
                    v4 = Math.max(a00.b, v4);
                    arrayList0.add(a00);
                }
                return o0.w(b.g(v3, v), b.f(v4, v), x0, new s(8, arrayList0));
            }
        }
    }
}

