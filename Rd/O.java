package rd;

import Cc.e0;
import F.X;
import F.Y;
import M.v;
import androidx.compose.foundation.layout.c;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import d9.h;
import ie.H;
import kotlin.jvm.internal.q;
import pc.b;
import r0.n;
import we.a;
import we.k;

public final class o implements we.o {
    public final float B;
    public final a D;
    public final String E;
    public final String G;
    public final boolean I;
    public final int M;
    public final a N;
    public final a S;
    public final a0 a;
    public final b b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final a g;
    public final a h;
    public final a i;
    public final boolean j;
    public final X k;
    public final Y l;
    public final b0 m;
    public final boolean n;
    public final h o;
    public final Long r;
    public final k w;

    public o(a0 a00, b b0, String s, String s1, String s2, String s3, a a0, a a1, a a2, boolean z, X x0, Y y0, b0 b00, boolean z1, h h0, Long long0, k k0, float f, a a3, String s4, String s5, boolean z2, int v, a a4, a a5) {
        this.a = a00;
        this.b = b0;
        this.c = s;
        this.d = s1;
        this.e = s2;
        this.f = s3;
        this.g = a0;
        this.h = a1;
        this.i = a2;
        this.j = z;
        this.k = x0;
        this.l = y0;
        this.m = b00;
        this.n = z1;
        this.o = h0;
        this.r = long0;
        this.w = k0;
        this.B = f;
        this.D = a3;
        this.E = s4;
        this.G = s5;
        this.I = z2;
        this.M = v;
        this.N = a4;
        this.S = a5;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        int v = ((Number)object2).intValue();
        q.g(((v)object0), "$this$BoxWithConstraints");
        if((v & 6) == 0) {
            v |= (((p)(((l)object1))).g(((v)object0)) ? 4 : 2);
        }
        if(((p)(((l)object1))).Q(v & 1, (v & 19) != 18)) {
            K0 k00 = (K0)this.a;
            if(k00.m() < 0) {
                ((p)(((l)object1))).a0(1313609364);
                e0.s(d.h(d.f(n.a, 1.0f), E9.h.t(((p)(((l)object1))), 0x7F0700ED)), this.b, this.c, this.d, this.e, this.f, this.g, this.h, null, this.i, ((p)(((l)object1))), 0, 0x100);  // dimen:dj_malrang_player_recommend_area_height
                ((p)(((l)object1))).p(false);
                return H.a;
            }
            ((p)(((l)object1))).a0(1302009412);
            ((p)(((l)object1))).p(false);
            float f = ((c)(((v)object0))).b();
            float f1 = e0.Z(((p)(((l)object1))), k00.m());
            float f2 = E9.h.t(((p)(((l)object1))), 0x7F0700ED);  // dimen:dj_malrang_player_recommend_area_height
            float f3 = E9.h.t(((p)(((l)object1))), 0x7F0700EC);  // dimen:dj_malrang_player_recommend_area_bottom_margin
            m0.b b0 = m0.c.e(0x8A3232E6, ((p)(((l)object1))), new rd.n(f1, this.m, f, f2, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, f3, this.n, this.o, this.r, this.w, this.B, this.D, this.E, this.G, this.I, this.M, this.N, this.S));
            androidx.compose.animation.b.d(!this.j, null, this.k, this.l, null, b0, ((p)(((l)object1))), 0x30000, 18);
            return H.a;
        }
        ((p)(((l)object1))).T();
        return H.a;
    }
}

