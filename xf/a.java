package xf;

import Me.c;
import Pe.S;
import java.util.ArrayList;
import java.util.Collection;
import je.q;
import je.w;

public final class a implements Qf.a {
    public final int a;
    public static final a b;

    static {
        a.b = new a(0);
    }

    public a(int v) {
        this.a = v;
        super();
    }

    @Override  // Qf.a
    public final Iterable j(Object object0) {
        if(this.a != 0) {
            if(((c)object0) != null) {
                Collection collection0 = ((c)object0).f();
                if(collection0 != null) {
                    return collection0;
                }
            }
            return w.a;
        }
        Collection collection1 = ((S)object0).f();
        Iterable iterable0 = new ArrayList(q.Q(10, collection1));
        for(Object object1: ((ArrayList)collection1)) {
            ((ArrayList)iterable0).add(((S)object1).w1());
        }
        return iterable0;
    }
}

