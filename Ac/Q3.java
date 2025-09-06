package Ac;

import com.melon.ui.K4;
import java.util.ArrayList;
import je.p;
import kotlin.jvm.internal.q;
import we.k;

public final class q3 implements k {
    public final int a;
    public final L3 b;
    public final ArrayList c;

    public q3(L3 l30, ArrayList arrayList0, int v) {
        this.a = v;
        this.b = l30;
        this.c = arrayList0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        ArrayList arrayList0 = this.c;
        L3 l30 = this.b;
        if(this.a != 0) {
            q.g(((K4)object0), "it");
            n3 n30 = l30.g();
            q.d(n30);
            n3 n31 = l30.g();
            q.d(n31);
            ArrayList arrayList1 = p.A0(n31.b, arrayList0);
            return new n3(n30.a, arrayList1);
        }
        q.g(((K4)object0), "it");
        n3 n32 = l30.g();
        q.d(n32);
        return new n3(n32.a, arrayList0);
    }
}

