package j0;

import D0.E;
import androidx.collection.v;
import m0.f;

public final class a extends v {
    public final E d;
    public Object e;

    public a(E e0, Object object0, Object object1) {
        super(1, object0, object1);
        this.d = e0;
        this.e = object1;
    }

    @Override  // androidx.collection.v
    public final Object getValue() {
        return this.e;
    }

    @Override  // androidx.collection.v
    public final Object setValue(Object object0) {
        Object object1 = this.e;
        this.e = object0;
        d d0 = (d)this.d.b;
        f f0 = d0.d;
        Object object2 = this.b;
        if(!f0.containsKey(object2)) {
            return object1;
        }
        if(d0.c) {
            k k0 = d0.a[d0.b];
            Object object3 = k0.a[k0.c];
            f0.put(object2, object0);
            d0.d((object3 == null ? 0 : object3.hashCode()), f0.b, object3, 0);
        }
        else {
            f0.put(object2, object0);
        }
        d0.g = f0.d;
        return object1;
    }
}

