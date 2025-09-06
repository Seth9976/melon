package e3;

import i.n.i.b.a.s.e.X1;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import k3.k;

public final class f implements Iterable {
    public final int a;
    public final Object b;
    public final HashMap c;
    public Set d;
    public List e;

    public f(int v) {
        this.a = v;
        if(v != 1) {
            super();
            this.b = new Object();
            this.c = new HashMap();
            this.d = Collections.EMPTY_SET;
            this.e = Collections.EMPTY_LIST;
            return;
        }
        super();
        this.b = new Object();
        this.c = new HashMap();
        this.d = Collections.EMPTY_SET;
        this.e = Collections.EMPTY_LIST;
    }

    public Set a() {
        synchronized(this.b) {
        }
        return this.d;
    }

    public int b(X1 x10) {
        synchronized(this.b) {
            return this.c.containsKey(x10) ? ((int)(((Integer)this.c.get(x10)))) : 0;
        }
    }

    public int d(k k0) {
        synchronized(this.b) {
            return this.c.containsKey(k0) ? ((int)(((Integer)this.c.get(k0)))) : 0;
        }
    }

    @Override
    public final Iterator iterator() {
        if(this.a != 0) {
            Object object0 = this.b;
            return this.e.iterator();
        }
        Object object1 = this.b;
        return this.e.iterator();
    }
}

