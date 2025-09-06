package ke;

import java.util.ConcurrentModificationException;
import java.util.Map.Entry;
import kotlin.jvm.internal.q;
import xe.a;

public final class d implements Map.Entry, a {
    public final e a;
    public final int b;
    public final int c;

    public d(e e0, int v) {
        q.g(e0, "map");
        super();
        this.a = e0;
        this.b = v;
        this.c = e0.h;
    }

    public final void a() {
        if(this.a.h != this.c) {
            throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
        }
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof Map.Entry && q.b(((Map.Entry)object0).getKey(), this.getKey()) && q.b(((Map.Entry)object0).getValue(), this.getValue());
    }

    @Override
    public final Object getKey() {
        this.a();
        return this.a.a[this.b];
    }

    @Override
    public final Object getValue() {
        this.a();
        Object[] arr_object = this.a.b;
        q.d(arr_object);
        return arr_object[this.b];
    }

    @Override
    public final int hashCode() {
        Object object0 = this.getKey();
        int v = 0;
        int v1 = object0 == null ? 0 : object0.hashCode();
        Object object1 = this.getValue();
        if(object1 != null) {
            v = object1.hashCode();
        }
        return v1 ^ v;
    }

    @Override
    public final Object setValue(Object object0) {
        this.a();
        e e0 = this.a;
        e0.d();
        Object[] arr_object = e0.b;
        if(arr_object == null) {
            int v = e0.a.length;
            if(v < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            arr_object = new Object[v];
            e0.b = arr_object;
        }
        Object object1 = arr_object[this.b];
        arr_object[this.b] = object0;
        return object1;
    }

    @Override
    public final String toString() {
        return this.getKey() + '=' + this.getValue();
    }
}

