package T7;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Objects;

public final class l extends AbstractSet {
    public final int a;
    public final o b;

    public l(o o0, int v) {
        this.a = v;
        this.b = o0;
        super();
    }

    @Override
    public final void clear() {
        if(this.a != 0) {
            this.b.clear();
            return;
        }
        this.b.clear();
    }

    @Override
    public final boolean contains(Object object0) {
        if(this.a != 0) {
            return this.b.containsKey(object0);
        }
        if(object0 instanceof Map.Entry) {
            o o0 = this.b;
            Object object1 = ((Map.Entry)object0).getKey();
            n n0 = null;
            n n1 = null;
            if(object1 != null) {
                try {
                    n1 = o0.a(object1, false);
                }
                catch(ClassCastException unused_ex) {
                }
            }
            if(n1 != null && Objects.equals(n1.h, ((Map.Entry)object0).getValue())) {
                n0 = n1;
            }
            return n0 != null;
        }
        return false;
    }

    @Override
    public final Iterator iterator() {
        return this.a == 0 ? new k(this.b, 0) : new k(this.b, 1);
    }

    @Override
    public final boolean remove(Object object0) {
        boolean z = false;
        if(this.a != 0) {
            o o0 = this.b;
            n n0 = null;
            if(object0 != null) {
                try {
                    n0 = o0.a(object0, false);
                }
                catch(ClassCastException unused_ex) {
                }
            }
            if(n0 != null) {
                o0.c(n0, true);
            }
            return n0 != null;
        }
        if(object0 instanceof Map.Entry) {
            Object object1 = ((Map.Entry)object0).getKey();
            o o1 = this.b;
            n n1 = null;
            n n2 = null;
            if(object1 != null) {
                try {
                    n2 = o1.a(object1, false);
                }
                catch(ClassCastException unused_ex) {
                }
            }
            if(n2 != null && Objects.equals(n2.h, ((Map.Entry)object0).getValue())) {
                n1 = n2;
            }
            if(n1 != null) {
                z = true;
                o1.c(n1, true);
            }
        }
        return z;
    }

    @Override
    public final int size() {
        return this.b.d;
    }
}

