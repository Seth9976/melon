package w8;

import B2.h;
import D2.f;
import De.I;
import android.content.Context;
import androidx.compose.runtime.A;
import androidx.compose.runtime.J;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import kc.s2;
import kotlinx.coroutines.flow.Flow;
import m0.c;
import ob.z;
import we.n;
import y0.M;
import y0.s;

public final class m0 implements n {
    public final int a;
    public final w0 b;
    public final Flow c;
    public final z d;
    public final s2 e;
    public final Context f;
    public final f g;

    public m0(w0 w00, Flow flow0, z z0, s2 s20, Context context0, f f0, int v) {
        this.a = v;
        this.b = w00;
        this.c = flow0;
        this.d = z0;
        this.e = s20;
        this.f = context0;
        this.g = f0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            int v = (int)(((Integer)object1));
            p p0 = (p)(((l)object0));
            boolean z = p0.Q(v & 1, (v & 3) != 2);
            H h0 = H.a;
            if(z) {
                q2.f f0 = w0.d;
                p0.b0(0x4F828278);
                p0.b0(0xE02106FD);
                A a0 = h.c;
                Object object2 = p0.k(a0);
                if(object2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
                }
                p0.p(false);
                Object object3 = ((q2.h)object2).b(f0);
                p0.p(false);
                boolean z1 = ((Boolean)object3) == null ? false : ((Boolean)object3).booleanValue();
                q2.f f1 = w0.e;
                p0.b0(0x4F828278);
                p0.b0(0xE02106FD);
                Object object4 = p0.k(a0);
                if(object4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
                }
                p0.p(false);
                Object object5 = ((q2.h)object4).b(f1);
                p0.p(false);
                w0 w00 = this.b;
                int v1 = ((Integer)object5) == null ? w00.u() : ((int)(((Integer)object5)));
                q2.f f2 = w0.f;
                p0.b0(0x4F828278);
                p0.b0(0xE02106FD);
                Object object6 = p0.k(a0);
                if(object6 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
                }
                p0.p(false);
                Object object7 = ((q2.h)object6).b(f2);
                p0.p(false);
                boolean z2 = ((Boolean)object7) == null ? false : ((Boolean)object7).booleanValue();
                q2.f f3 = w0.g;
                p0.b0(0x4F828278);
                p0.b0(0xE02106FD);
                Object object8 = p0.k(a0);
                if(object8 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.datastore.preferences.core.Preferences");
                }
                p0.p(false);
                Object object9 = ((q2.h)object8).b(f3);
                p0.p(false);
                long v2 = s.c(M.c(((Context)p0.k(h.b)).getColor((z2 ? 0x7F0604A1 : 0x7F060030))), (((Float)object9) == null ? 0.7f : ((float)(((Float)object9)))));  // color:white000e
                Flow flow0 = this.c;
                z z3 = this.d;
                s2 s20 = this.e;
                if(z1) {
                    p0.a0(395828061);
                    w00.m(flow0, z3, s20, z2, v2, p0, 0);
                }
                else {
                    p0.a0(0x1797FC20);
                    w00.n(flow0, z3, s20, z2, v2, true, v1, p0, 0x30000);
                }
                p0.p(false);
                Context context0 = this.f;
                boolean z4 = p0.i(context0);
                f f4 = this.g;
                boolean z5 = p0.i(f4);
                boolean z6 = p0.i(w00);
                v0 v00 = p0.N();
                if((z4 | z5 | z6) != 0 || v00 == k.a) {
                    v00 = new v0(context0, f4, w00, null);
                    p0.l0(v00);
                }
                J.d(p0, h0, v00);
                return h0;
            }
            p0.T();
            return h0;
        }
        int v3 = (int)(((Integer)object1));
        if(((p)(((l)object0))).Q(v3 & 1, (v3 & 3) != 2)) {
            I.b(null, c.e(0x7E06D137, ((p)(((l)object0))), new m0(this.b, this.c, this.d, this.e, this.f, this.g, 1)), ((p)(((l)object0))), 0x30);
            return H.a;
        }
        ((p)(((l)object0))).T();
        return H.a;
    }
}

