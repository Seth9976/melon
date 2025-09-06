package D2;

import B2.k;
import De.I;
import F2.i;
import M2.f;
import android.content.Context;
import ie.H;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import ne.a;

public final class r0 {
    public final Context a;
    public final LinkedHashMap b;
    public int c;
    public final int d;
    public final LinkedHashSet e;
    public final Set f;
    public static final C g;

    static {
        r0.g = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public r0(Context context0, LinkedHashMap linkedHashMap0, int v, int v1, Set set0) {
        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
        super();
        this.a = context0;
        this.b = linkedHashMap0;
        this.c = v;
        this.d = v1;
        this.e = linkedHashSet0;
        this.f = set0;
    }

    public final int a(k k0) {
        i i0 = I.u(k0);
        synchronized(this) {
            Integer integer0 = (Integer)this.b.get(i0);
            if(integer0 != null) {
                int v1 = integer0.intValue();
                this.e.add(v1);
                return v1;
            }
            int v2 = this.c;
            while(this.f.contains(v2)) {
                v2 = (v2 + 1) % u0.c;
                if(v2 == this.c) {
                    throw new IllegalArgumentException("Cannot assign a valid layout index to the new layout: no free index left.");
                }
                if(false) {
                    break;
                }
            }
            this.c = (v2 + 1) % u0.c;
            this.e.add(v2);
            this.f.add(v2);
            this.b.put(i0, v2);
            return v2;
        }
    }

    public final Object b(D2.k k0) {
        q0 q00 = new q0(this, null);
        Object object0 = f.a.d(this.a, w0.a, "appWidgetLayout-" + this.d, q00, k0);
        return object0 == a.a ? object0 : H.a;
    }
}

