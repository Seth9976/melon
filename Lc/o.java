package Lc;

import com.melon.ui.K4;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import we.k;

public final class o implements k {
    public final int a;
    public final t b;
    public final ArrayList c;

    public o(t t0, ArrayList arrayList0, int v) {
        this.a = v;
        this.b = t0;
        this.c = arrayList0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        ArrayList arrayList0 = this.c;
        t t0 = this.b;
        if(this.a != 0) {
            q.g(((K4)object0), "it");
            q.d(t0.c());
            return new m(arrayList0);
        }
        q.g(((K4)object0), "it");
        q.d(t0.c());
        return new m(arrayList0);
    }
}

