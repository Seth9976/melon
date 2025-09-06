package xd;

import N0.Z;
import N0.a0;
import ie.H;
import java.util.ArrayList;
import kotlin.jvm.internal.r;
import we.k;

public final class d extends r implements k {
    public final int f;
    public final ArrayList g;

    public d(int v, ArrayList arrayList0) {
        this.f = v;
        this.g = arrayList0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.f != 0) {
            ArrayList arrayList0 = this.g;
            int v = e.k.s(arrayList0);
            if(v >= 0) {
                for(int v1 = 0; true; ++v1) {
                    Z.g(((Z)object0), ((a0)arrayList0.get(v1)), 0, 0);
                    if(v1 == v) {
                        break;
                    }
                }
            }
            return H.a;
        }
        this.g.get(((Number)object0).intValue());
        return null;
    }
}

