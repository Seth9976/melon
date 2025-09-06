package a1;

import H8.i;
import e.k;
import java.util.ArrayList;
import kotlin.jvm.internal.r;
import we.a;

public final class z extends r implements a {
    public final int f;
    public final i g;

    public z(i i0, int v) {
        this.f = v;
        this.g = i0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.f != 0) {
            ArrayList arrayList0 = (ArrayList)this.g.f;
            if(arrayList0.isEmpty()) {
                return 0.0f;
            }
            Object object0 = arrayList0.get(0);
            float f = ((B)object0).a.d();
            int v = k.s(arrayList0);
            if(1 <= v) {
                for(int v1 = 1; true; ++v1) {
                    Object object1 = arrayList0.get(v1);
                    float f1 = ((B)object1).a.d();
                    if(Float.compare(f, f1) < 0) {
                        object0 = object1;
                        f = f1;
                    }
                    if(v1 == v) {
                        break;
                    }
                }
            }
            return ((B)object0) == null ? 0.0f : ((B)object0).a.d();
        }
        ArrayList arrayList1 = (ArrayList)this.g.f;
        if(arrayList1.isEmpty()) {
            return 0.0f;
        }
        Object object2 = arrayList1.get(0);
        float f2 = ((B)object2).a.i.c();
        int v2 = k.s(arrayList1);
        if(1 <= v2) {
            for(int v3 = 1; true; ++v3) {
                Object object3 = arrayList1.get(v3);
                float f3 = ((B)object3).a.i.c();
                if(Float.compare(f2, f3) < 0) {
                    object2 = object3;
                    f2 = f3;
                }
                if(v3 == v2) {
                    break;
                }
            }
        }
        return ((B)object2) == null ? 0.0f : ((B)object2).a.i.c();
    }
}

