package cd;

import Ac.b0;
import Cc.c1;
import M.g;
import M.j0;
import M.j;
import M.w;
import M.y;
import P0.h;
import P0.i;
import P0.k;
import Zc.c;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import bd.s;
import com.google.firebase.b;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import r0.a;
import r0.n;

public abstract class l0 {
    public static final void a(m0 m00, l l0, int v) {
        q.g(m00, "uiState");
        p p0 = (p)l0;
        p0.c0(0x350029C9);
        int v1 = (p0.i(m00) ? 4 : 2) | v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            ArrayList arrayList0 = m00.b;
            p0.a0(0xBE00E25B);
            r0.q q0 = d.f(n.a, 1.0f);
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = a.d(p0, q0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            s s0 = m00.a;
            if(s0 == null) {
                p0.a0(0x73C31C82);
            }
            else {
                p0.a0(0x73C31C83);
                b.j(s0, p0, 0);
            }
            p0.p(false);
            g g0 = j.h(12.0f);
            j0 j00 = androidx.compose.foundation.layout.a.a(20.0f, 0.0f, 2);
            boolean z = p0.i(arrayList0);
            b0 b00 = p0.N();
            if(z || b00 == androidx.compose.runtime.k.a) {
                b00 = new b0(12, arrayList0);
                p0.l0(b00);
            }
            c1.q(null, null, j00, g0, null, null, false, b00, p0, 0x6180, 0xEB);
            p0.p(true);
            p0.p(false);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new c(m00, v, 13);
        }
    }
}

