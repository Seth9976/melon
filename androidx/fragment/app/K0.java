package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public final class k0 implements i0 {
    public final l0 a;

    public k0(l0 l00) {
        this.a = l00;
    }

    @Override  // androidx.fragment.app.i0
    public final boolean a(ArrayList arrayList0, ArrayList arrayList1) {
        boolean z = l0.P(2);
        l0 l00 = this.a;
        if(z) {
            Log.v("FragmentManager", "FragmentManager has the following pending actions inside of prepareBackStackState: " + l00.a);
        }
        boolean z1 = false;
        if(l00.d.isEmpty()) {
            Log.i("FragmentManager", "Ignoring call to start back stack pop because the back stack is empty.");
        }
        else {
            a a0 = (a)com.iloen.melon.utils.a.i(1, l00.d);
            l00.h = a0;
            for(Object object0: a0.a) {
                I i0 = ((x0)object0).b;
                if(i0 != null) {
                    i0.mTransitioning = true;
                }
            }
            z1 = l00.Z(arrayList0, arrayList1, -1, 0);
        }
        if(!l00.o.isEmpty() && arrayList0.size() > 0) {
            boolean z2 = ((Boolean)arrayList1.get(arrayList0.size() - 1)).booleanValue();
            LinkedHashSet linkedHashSet0 = new LinkedHashSet();
            for(Object object1: arrayList0) {
                linkedHashSet0.addAll(l0.H(((a)object1)));
            }
            for(Object object2: l00.o) {
                h0 h00 = (h0)object2;
                for(Object object3: linkedHashSet0) {
                    h00.onBackStackChangeStarted(((I)object3), z2);
                }
            }
        }
        return z1;
    }
}

