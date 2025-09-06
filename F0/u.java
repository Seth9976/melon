package f0;

import Q5.h;
import Vd.w;
import androidx.compose.runtime.D0;
import androidx.compose.runtime.E0;
import androidx.compose.runtime.a;
import androidx.compose.runtime.c;
import androidx.compose.runtime.q;
import java.util.ArrayList;
import je.n;

public final class u extends I {
    public static final u d;

    static {
        u.d = new u(1, 0, 2);  // 初始化器: Lf0/I;-><init>(III)V
    }

    @Override  // f0.I
    public final void c(w w0, c c0, E0 e00, h h0) {
        int v = w0.i(0);
        if(e00.n != 0) {
            q.c("Cannot move a group while inserting");
        }
        if(v < 0) {
            q.c("Parameter offset is out of bounds");
        }
        if(v != 0) {
            int v1 = e00.t;
            int v2 = e00.v;
            int v3 = e00.u;
            int v4 = v1;
            while(v > 0) {
                v4 += e00.b[e00.q(v4) * 5 + 3];
                if(v4 > v3) {
                    q.c("Parameter offset is out of bounds");
                }
                --v;
            }
            int v5 = e00.b[e00.q(v4) * 5 + 3];
            int v6 = e00.f(e00.q(e00.t), e00.b);
            int v7 = e00.f(e00.q(v4), e00.b);
            int v8 = v4 + v5;
            int v9 = e00.f(e00.q(v8), e00.b);
            int v10 = v9 - v7;
            e00.v(v10, Math.max(e00.t - 1, 0));
            e00.u(v5);
            int[] arr_v = e00.b;
            int v11 = e00.q(v8);
            n.S(e00.q(v1) * 5, v11 * 5, v5 * 5 + v11 * 5, arr_v, arr_v);
            if(v10 > 0) {
                Object[] arr_object = e00.c;
                int v12 = e00.g(v7 + v10);
                System.arraycopy(arr_object, v12, arr_object, v6, e00.g(v9 + v10) - v12);
            }
            int v13 = v7 + v10;
            int v14 = e00.k;
            int v15 = e00.l;
            int v16 = e00.m;
            for(int v17 = v1; v17 < v1 + v5; ++v17) {
                int v18 = e00.q(v17);
                arr_v[v18 * 5 + 4] = E0.h(E0.h(e00.f(v18, arr_v) - (v13 - v6), (v16 >= v18 ? v14 : 0), v15, e00.c.length), e00.k, e00.l, e00.c.length);
            }
            int v19 = e00.n();
            int v20 = D0.b(e00.d, v8, v19);
            ArrayList arrayList0 = new ArrayList();
            if(v20 >= 0) {
                while(v20 < e00.d.size()) {
                    a a0 = (a)e00.d.get(v20);
                    int v21 = e00.c(a0);
                    if(v21 < v8 || v21 >= v8 + v5) {
                        break;
                    }
                    arrayList0.add(a0);
                    e00.d.remove(v20);
                }
            }
            int v22 = arrayList0.size();
            for(int v23 = 0; v23 < v22; ++v23) {
                a a1 = (a)arrayList0.get(v23);
                int v24 = e00.c(a1) + (v1 - v8);
                a1.a = v24 >= e00.g ? -(v19 - v24) : v24;
                int v25 = D0.b(e00.d, v24, v19);
                e00.d.add(v25, a1);
            }
            if(e00.G(v8, v5)) {
                q.c("Unexpectedly removed anchors");
            }
            e00.l(v2, e00.u, v1);
            if(v10 > 0) {
                e00.H(v13, v10, v8 - 1);
            }
        }
    }
}

