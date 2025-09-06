package Q0;

import android.view.View;
import android.view.ViewParent;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ie.H;
import java.util.Set;
import kotlin.jvm.internal.r;
import m0.c;
import q0.d;
import we.n;
import xe.a;
import xe.e;

public final class t1 extends r implements n {
    public final int f;
    public final u1 g;
    public final n h;

    public t1(u1 u10, n n0, int v) {
        this.f = v;
        this.g = u10;
        this.h = n0;
        super(2);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.f != 0) {
            int v = ((Number)object1).intValue();
            p p0 = (p)(((l)object0));
            if(p0.Q(v & 1, (v & 3) != 2)) {
                u1 u10 = this.g;
                u u0 = u10.a;
                Object object2 = u0.getTag(0x7F0A058A);  // id:inspection_slot_table_set
                Set set0 = !(object2 instanceof Set) || object2 instanceof a && !(object2 instanceof e) ? null : ((Set)object2);
                if(set0 == null) {
                    ViewParent viewParent0 = u0.getParent();
                    View view0 = viewParent0 instanceof View ? ((View)viewParent0) : null;
                    Object object3 = view0 == null ? null : view0.getTag(0x7F0A058A);  // id:inspection_slot_table_set
                    set0 = !(object3 instanceof Set) || object3 instanceof a && !(object3 instanceof e) ? null : ((Set)object3);
                }
                if(set0 != null) {
                    androidx.compose.runtime.u u1 = p0.Q;
                    if(u1 == null) {
                        u1 = new androidx.compose.runtime.u(p0.g);
                        p0.Q = u1;
                    }
                    set0.add(u1);
                    p0.p = true;
                    p0.B = true;
                    p0.c.g();
                    p0.G.g();
                    p0.H.e = p0.H.a.j;
                    p0.H.f = p0.H.a.k;
                }
                boolean z = p0.i(u10);
                r1 r10 = p0.N();
                V v1 = k.a;
                if(z || r10 == v1) {
                    r10 = new r1(u10, null);
                    p0.l0(r10);
                }
                J.d(p0, u0, r10);
                boolean z1 = p0.i(u10);
                s1 s10 = p0.N();
                if(z1 || s10 == v1) {
                    s10 = new s1(u10, null);
                    p0.l0(s10);
                }
                J.d(p0, u0, s10);
                w.a(d.a.a(set0), c.e(-1193460702, p0, new t1(u10, this.h, 0)), p0, 56);
                return H.a;
            }
            p0.T();
            return H.a;
        }
        int v2 = ((Number)object1).intValue();
        if(((p)(((l)object0))).Q(v2 & 1, (v2 & 3) != 2)) {
            AndroidCompositionLocals_androidKt.a(this.g.a, this.h, ((p)(((l)object0))), 0);
            return H.a;
        }
        ((p)(((l)object0))).T();
        return H.a;
    }
}

