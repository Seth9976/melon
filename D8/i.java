package D8;

import Ac.D;
import Ac.M;
import Bd.G;
import M.h;
import M.j0;
import O.F;
import androidx.compose.runtime.E;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.w;
import ie.H;
import java.util.List;
import kotlinx.coroutines.CoroutineScope;
import r0.d;
import r0.g;
import r0.q;
import we.p;
import ye.a;

public abstract class i {
    public static final void a(List list0, long v, j0 j00, h h0, g g0, q q0, F f0, p p0, l l0, int v1) {
        g g4;
        V v7;
        p0.p p3;
        int v6;
        Integer integer1;
        g g1;
        kotlin.jvm.internal.q.g(list0, "items");
        kotlin.jvm.internal.q.g(p0, "itemContent");
        androidx.compose.runtime.p p1 = (androidx.compose.runtime.p)l0;
        p1.c0(0xE076251);
        int v2 = v1 | (p1.i(list0) ? 4 : 2) | (p1.f(v) ? 0x20 : 16) | 0x6000 | (p1.g(f0) ? 0x100000 : 0x80000);
        int v3 = 1;
        if(p1.Q(v2 & 1, (0x492493 & v2) != 4793490)) {
            p1.V();
            if((v1 & 1) == 0 || p1.B()) {
                g1 = d.m;
            }
            else {
                p1.T();
                g1 = g0;
            }
            p1.q();
            p0.p p2 = p1.N();
            V v4 = k.a;
            if(p2 == v4) {
                p2 = new p0.p();
                p1.l0(p2);
            }
            boolean z = p1.i(list0);
            c c0 = p1.N();
            if(z || c0 == v4) {
                c0 = new c(p2, list0, null);
                p1.l0(c0);
            }
            J.d(p1, list0, c0);
            CoroutineScope coroutineScope0 = p1.N();
            if(coroutineScope0 == v4) {
                coroutineScope0 = J.i(p1);
                p1.l0(coroutineScope0);
            }
            b0 b00 = p1.N();
            if(b00 == v4) {
                b00 = w.s(Boolean.TRUE);
                p1.l0(b00);
            }
            b0 b01 = p1.N();
            if(b01 == v4) {
                b01 = w.s(null);
                p1.l0(b01);
            }
            E e0 = p1.N();
            if(e0 == v4) {
                e0 = w.i(new M(f0, 7));
                p1.l0(e0);
            }
            Integer integer0 = ((Number)e0.getValue()).intValue();
            boolean z1 = p1.i(coroutineScope0);
            int v5 = 0x380000 & v2 ^ 0x180000;
            boolean z2 = v5 > 0x100000 && p1.g(f0) || (v2 & 0x180000) == 0x100000;
            e e1 = p1.N();
            if(!z2 && !z1 && e1 != v4) {
                p3 = p2;
                integer1 = integer0;
                v6 = v5;
            }
            else {
                integer1 = integer0;
                v6 = v5;
                e e2 = new e(p2, coroutineScope0, e0, f0, null);
                p3 = p2;
                p1.l0(e2);
                e1 = e2;
            }
            J.d(p1, integer1, e1);
            boolean z3 = p1.i(coroutineScope0);
            boolean z4 = v6 > 0x100000 && p1.g(f0) || (v2 & 0x180000) == 0x100000;
            if(((v2 & 0x70 ^ 0x30) <= 0x20 || !p1.f(v)) && (v2 & 0x30) != 0x20) {
                v3 = 0;
            }
            G g2 = p1.N();
            if((z4 | z3 | v3) != 0 || g2 == v4) {
                v7 = v4;
                G g3 = new G(coroutineScope0, f0, v, b00, b01, 1);
                p1.l0(g3);
                g2 = g3;
            }
            else {
                v7 = v4;
            }
            J.b(H.a, g2, p1);
            D d0 = p1.N();
            if(d0 == v7) {
                d0 = new D(25, p3, p0);
                p1.l0(d0);
            }
            a.i(q0, f0, j00, false, h0, g1, null, false, null, d0, p1, v2 >> 15 & 0x70 | 12804486, 328);
            g4 = g1;
        }
        else {
            p1.T();
            g4 = g0;
        }
        n0 n00 = p1.t();
        if(n00 != null) {
            n00.d = new D8.a(list0, v, j00, h0, g4, q0, f0, p0, v1);
        }
    }
}

