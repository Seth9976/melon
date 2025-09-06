package w8;

import D2.f;
import De.I;
import androidx.compose.runtime.J;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import ie.H;
import kc.s2;
import kotlinx.coroutines.flow.Flow;
import m0.c;
import ob.z;
import we.n;

public final class a0 implements n {
    public final int a;
    public final k0 b;
    public final Flow c;
    public final z d;
    public final s2 e;
    public final f f;

    public a0(k0 k00, Flow flow0, z z0, s2 s20, f f0, int v) {
        this.a = v;
        this.b = k00;
        this.c = flow0;
        this.d = z0;
        this.e = s20;
        this.f = f0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object1));
        if(this.a != 0) {
            if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                this.b.i(this.c, this.d, this.e, ((p)(((l)object0))), 0);
                Boolean boolean0 = (Boolean)w.e(this.d.g(), Boolean.FALSE, null, ((p)(((l)object0))), 0x30, 2).getValue();
                boolean z = boolean0.booleanValue();
                boolean z1 = ((p)(((l)object0))).h(z);
                f f0 = this.f;
                boolean z2 = ((p)(((l)object0))).i(f0);
                j0 j00 = ((p)(((l)object0))).N();
                if(z1 || z2 || j00 == k.a) {
                    j00 = new j0(z, f0, null);
                    ((p)(((l)object0))).l0(j00);
                }
                J.d(((p)(((l)object0))), boolean0, j00);
                return H.a;
            }
            ((p)(((l)object0))).T();
            return H.a;
        }
        if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
            I.b(null, c.e(0x17F3744, ((p)(((l)object0))), new a0(this.b, this.c, this.d, this.e, this.f, 1)), ((p)(((l)object0))), 0x30);
            return H.a;
        }
        ((p)(((l)object0))).T();
        return H.a;
    }
}

