package O;

import N0.Z;
import P.t;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.r;
import we.k;

public final class s extends r implements k {
    public final int f;
    public final ArrayList g;
    public final Object h;

    public s(ArrayList arrayList0, List list0, boolean z, int v) {
        this.f = v;
        this.g = arrayList0;
        this.h = list0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.f != 0) {
            ArrayList arrayList0 = this.g;
            int v = arrayList0.size();
            for(int v2 = 0; v2 < v; ++v2) {
                ((t)arrayList0.get(v2)).j(((Z)object0));
            }
            Object object1 = this.h;
            int v3 = ((Collection)object1).size();
            for(int v1 = 0; v1 < v3; ++v1) {
                ((t)((List)object1).get(v1)).j(((Z)object0));
            }
            return H.a;
        }
        ArrayList arrayList1 = this.g;
        int v4 = arrayList1.size();
        for(int v6 = 0; v6 < v4; ++v6) {
            ((v)arrayList1.get(v6)).j(((Z)object0));
        }
        Object object2 = this.h;
        int v7 = ((Collection)object2).size();
        for(int v5 = 0; v5 < v7; ++v5) {
            ((v)((List)object2).get(v5)).j(((Z)object0));
        }
        return H.a;
    }
}

