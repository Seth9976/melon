package hd;

import N0.M;
import P0.h;
import P0.i;
import P0.j;
import androidx.compose.foundation.layout.d;
import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.melon.net.res.MusicDnaMainMonthlyLogRes.RESPONSE.CARDINFO;
import kotlin.jvm.internal.q;
import r0.n;
import we.k;
import we.o;

public final class e implements o {
    public final int a;
    public final CARDINFO b;
    public final k c;

    public e(CARDINFO musicDnaMainMonthlyLogRes$RESPONSE$CARDINFO0, k k0, int v) {
        this.a = v;
        this.b = musicDnaMainMonthlyLogRes$RESPONSE$CARDINFO0;
        this.c = k0;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        int v = (int)(((Integer)object2));
        if(this.a != 0) {
            q.g(((a)object0), "$this$item");
            if(((p)(((l)object1))).Q(v & 1, (v & 17) != 16)) {
                r0.q q0 = d.h(d.q(n.a, 300.0f), 375.0f);
                M m0 = M.p.d(r0.d.a, false);
                int v1 = ((p)(((l)object1))).P;
                i0 i00 = ((p)(((l)object1))).m();
                r0.q q1 = r0.a.d(((p)(((l)object1))), q0);
                P0.k.y.getClass();
                i i0 = j.b;
                ((p)(((l)object1))).e0();
                if(((p)(((l)object1))).O) {
                    ((p)(((l)object1))).l(i0);
                }
                else {
                    ((p)(((l)object1))).o0();
                }
                w.x(((p)(((l)object1))), m0, j.f);
                w.x(((p)(((l)object1))), i00, j.e);
                h h0 = j.g;
                if(((p)(((l)object1))).O || !q.b(((p)(((l)object1))).N(), v1)) {
                    A7.d.q(v1, ((p)(((l)object1))), v1, h0);
                }
                w.x(((p)(((l)object1))), q1, j.d);
                H.p(this.b, 1, this.c, ((p)(((l)object1))), 0x30);
                ((p)(((l)object1))).p(true);
                return ie.H.a;
            }
            ((p)(((l)object1))).T();
            return ie.H.a;
        }
        q.g(((a)object0), "$this$item");
        if(((p)(((l)object1))).Q(v & 1, (v & 17) != 16)) {
            r0.q q2 = d.h(d.q(n.a, 300.0f), 375.0f);
            M m1 = M.p.d(r0.d.a, false);
            int v2 = ((p)(((l)object1))).P;
            i0 i01 = ((p)(((l)object1))).m();
            r0.q q3 = r0.a.d(((p)(((l)object1))), q2);
            P0.k.y.getClass();
            i i1 = j.b;
            ((p)(((l)object1))).e0();
            if(((p)(((l)object1))).O) {
                ((p)(((l)object1))).l(i1);
            }
            else {
                ((p)(((l)object1))).o0();
            }
            w.x(((p)(((l)object1))), m1, j.f);
            w.x(((p)(((l)object1))), i01, j.e);
            h h1 = j.g;
            if(((p)(((l)object1))).O || !q.b(((p)(((l)object1))).N(), v2)) {
                A7.d.q(v2, ((p)(((l)object1))), v2, h1);
            }
            w.x(((p)(((l)object1))), q3, j.d);
            H.p(this.b, 0, this.c, ((p)(((l)object1))), 0x30);
            ((p)(((l)object1))).p(true);
            return ie.H.a;
        }
        ((p)(((l)object1))).T();
        return ie.H.a;
    }
}

