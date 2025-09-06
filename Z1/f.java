package Z1;

import androidx.collection.V;
import b2.a;
import java.util.ArrayList;

public final class f implements a {
    public final int a;
    public final Object b;

    public f(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // b2.a
    public final void accept(Object object0) {
        ArrayList arrayList0;
        if(this.a != 0) {
            synchronized(h.c) {
                V v1 = h.d;
                arrayList0 = (ArrayList)v1.get(((String)this.b));
                if(arrayList0 == null) {
                    return;
                }
                v1.remove(((String)this.b));
            }
            for(int v2 = 0; v2 < arrayList0.size(); ++v2) {
                ((a)arrayList0.get(v2)).accept(((g)object0));
            }
            return;
        }
        g g0 = (g)object0;
        if(g0 == null) {
            g0 = new g(-3);
        }
        ((E9.g)this.b).y(g0);
    }
}

