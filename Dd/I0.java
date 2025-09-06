package Dd;

import com.melon.ui.K4;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import we.k;

public final class i0 implements k {
    public final int a;
    public final g1 b;
    public final ArrayList c;

    public i0(g1 g10, ArrayList arrayList0, int v) {
        this.a = v;
        this.b = g10;
        this.c = arrayList0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        ArrayList arrayList0 = this.c;
        g1 g10 = this.b;
        if(this.a != 0) {
            q.g(((K4)object0), "it");
            q.d(g10.h());
            return O1.a(arrayList0);
        }
        q.g(((K4)object0), "it");
        q.d(g10.h());
        return O1.a(arrayList0);
    }
}

