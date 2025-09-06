package Mc;

import A7.d;
import De.I;
import E9.h;
import H0.e;
import Nc.A;
import Nc.H0;
import Nc.N;
import Nc.Q0;
import Nc.V0;
import Nc.Z0;
import Nc.Z;
import Nc.d0;
import Nc.h0;
import Nc.k1;
import Nc.p0;
import Nc.x0;
import Q1.c;
import U4.F;
import V4.u;
import androidx.compose.foundation.lazy.a;
import com.google.firebase.b;
import com.melon.ui.K4;
import d5.f;
import h7.u0;
import ie.H;
import java.util.ArrayList;
import kotlin.jvm.internal.r;
import r0.n;
import we.p;

public final class l extends r implements p {
    public final ArrayList f;
    public final boolean g;
    public final boolean h;

    public l(ArrayList arrayList0, boolean z, boolean z1) {
        this.f = arrayList0;
        this.g = z;
        this.h = z1;
        super(4);
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        int v = ((Number)object1).intValue();
        int v1 = ((Number)object3).intValue();
        int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)(((androidx.compose.runtime.l)object2))).g(((a)object0)) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (((androidx.compose.runtime.p)(((androidx.compose.runtime.l)object2))).e(v) ? 0x20 : 16);
        }
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)(((androidx.compose.runtime.l)object2));
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            K4 k40 = (K4)this.f.get(v);
            p0.a0(-2087554006);
            n n0 = n.a;
            if(k40 instanceof k1) {
                p0.a0(-2087595454);
                F.c(n0, ((k1)k40), this.g, this.h, p0, 6);
                a.a.b(null, p0, 0);
                p0.p(false);
            }
            else if(k40 instanceof Z0) {
                p0.a0(-2087222462);
                c.f(n0, ((Z0)k40), p0, 6);
                a.a.b(null, p0, 0);
                p0.p(false);
            }
            else if(k40 instanceof V0) {
                p0.a0(-2086947864);
                e.e(n0, ((V0)k40), p0, 6);
                a.a.b(null, p0, 0);
                p0.p(false);
            }
            else if(k40 instanceof H0) {
                p0.a0(0x839FEF93);
                I.a(n0, ((H0)k40), this.g, this.h, p0, 6);
                a.a.b(null, p0, 0);
                p0.p(false);
            }
            else if(k40 instanceof N) {
                p0.a0(-2086313790);
                b.d(((N)k40), p0, 6);
                a.a.b(null, p0, 0);
                p0.p(false);
            }
            else if(k40 instanceof d0) {
                p0.a0(-2086036123);
                u0.a(n0, ((d0)k40), p0, 6);
                a.a.b(null, p0, 0);
                p0.p(false);
            }
            else if(k40 instanceof Q0) {
                p0.a0(0x83ADF050);
                h.f(n0, ((Q0)k40), this.g, this.h, p0, 6);
                a.a.b(null, p0, 0);
                p0.p(false);
            }
            else if(k40 instanceof h0) {
                p0.a0(0x83B37F49);
                x1.a.b(((h0)k40), p0, 6);
                d.v(n0, 23.0f, p0, false);
            }
            else if(k40 instanceof p0) {
                p0.a0(-2085079618);
                y5.a.a(n0, ((p0)k40), p0, 6);
                a.a.b(null, p0, 0);
                p0.p(false);
            }
            else if(k40 instanceof x0) {
                p0.a0(-2084790295);
                ye.a.h(((x0)k40), p0, 6);
                d.v(n0, 19.0f, p0, false);
            }
            else if(k40 instanceof A) {
                p0.a0(-2084487580);
                u.c(n0, ((A)k40), p0, 6);
                a.a.b(null, p0, 0);
                p0.p(false);
            }
            else if(k40 instanceof Z) {
                p0.a0(-2084212207);
                f.b(n0, ((Z)k40), p0, 6);
                d.v(n0, 26.0f, p0, false);
            }
            else {
                p0.a0(0x83051F68);
                p0.p(false);
            }
            p0.p(false);
            return H.a;
        }
        p0.T();
        return H.a;
    }
}

