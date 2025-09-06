package Ne;

import Hf.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.q;
import qf.c;

public final class l implements h {
    public final h a;
    public final u b;

    public l(h h0, u u0) {
        this.a = h0;
        this.b = u0;
    }

    @Override  // Ne.h
    public final boolean c(c c0) {
        q.g(c0, "fqName");
        return ((Boolean)this.b.invoke(c0)).booleanValue() ? this.a.c(c0) : false;
    }

    @Override  // Ne.h
    public final b e0(c c0) {
        q.g(c0, "fqName");
        return ((Boolean)this.b.invoke(c0)).booleanValue() ? this.a.e0(c0) : null;
    }

    @Override  // Ne.h
    public final boolean isEmpty() {
        h h0 = this.a;
        if(!(h0 instanceof Collection) || !((Collection)h0).isEmpty()) {
            for(Object object0: h0) {
                c c0 = ((b)object0).b();
                if(c0 != null && ((Boolean)this.b.invoke(c0)).booleanValue()) {
                    return true;
                }
                if(false) {
                    break;
                }
            }
        }
        return false;
    }

    @Override
    public final Iterator iterator() {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: this.a) {
            c c0 = ((b)object0).b();
            if(c0 != null && ((Boolean)this.b.invoke(c0)).booleanValue()) {
                arrayList0.add(object0);
            }
        }
        return arrayList0.iterator();
    }
}

