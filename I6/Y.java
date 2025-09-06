package I6;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Objects;
import x1.a;

public final class y extends AbstractSet {
    public final int a;
    public final B b;

    public y(B b0, int v) {
        this.a = v;
        this.b = b0;
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
        B b0 = this.b;
        Map map0 = b0.b();
        if(map0 != null) {
            return map0.entrySet().contains(object0);
        }
        if(object0 instanceof Map.Entry) {
            int v = b0.d(((Map.Entry)object0).getKey());
            return v != -1 && a.w(b0.l()[v], ((Map.Entry)object0).getValue());
        }
        return false;
    }

    @Override
    public final Iterator iterator() {
        if(this.a != 0) {
            B b0 = this.b;
            Map map0 = b0.b();
            return map0 != null ? map0.keySet().iterator() : new x(b0, 0);
        }
        B b1 = this.b;
        Map map1 = b1.b();
        return map1 != null ? map1.entrySet().iterator() : new x(b1, 1);
    }

    @Override
    public final boolean remove(Object object0) {
        if(this.a != 0) {
            Map map0 = this.b.b();
            return map0 == null ? this.b.i(object0) != B.j : map0.keySet().remove(object0);
        }
        B b0 = this.b;
        Map map1 = b0.b();
        if(map1 != null) {
            return map1.entrySet().remove(object0);
        }
        if(object0 instanceof Map.Entry && !b0.h()) {
            int v = b0.c();
            Object object1 = ((Map.Entry)object0).getKey();
            Object object2 = ((Map.Entry)object0).getValue();
            Object object3 = b0.a;
            Objects.requireNonNull(object3);
            int v1 = w.o(object1, object2, v, object3, b0.j(), b0.k(), b0.l());
            if(v1 != -1) {
                b0.g(v1, v);
                --b0.f;
                b0.e += 0x20;
                return true;
            }
        }
        return false;
    }

    @Override
    public final int size() {
        return this.b.size();
    }
}

