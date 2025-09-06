package ke;

import c2.J;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;
import xe.a;

public final class c extends J implements Iterator, a {
    public final int e;

    public c(e e0, int v) {
        this.e = v;
        q.g(e0, "map");
        super();
        this.d = e0;
        this.b = -1;
        this.c = e0.h;
        this.g();
    }

    @Override
    public final Object next() {
        switch(this.e) {
            case 0: {
                this.b();
                int v1 = this.a;
                e e1 = (e)this.d;
                if(v1 >= e1.f) {
                    throw new NoSuchElementException();
                }
                this.a = v1 + 1;
                this.b = v1;
                d d0 = new d(e1, v1);
                this.g();
                return d0;
            }
            case 1: {
                this.b();
                int v2 = this.a;
                e e2 = (e)this.d;
                if(v2 >= e2.f) {
                    throw new NoSuchElementException();
                }
                this.a = v2 + 1;
                this.b = v2;
                Object object1 = e2.a[v2];
                this.g();
                return object1;
            }
            default: {
                this.b();
                int v = this.a;
                e e0 = (e)this.d;
                if(v >= e0.f) {
                    throw new NoSuchElementException();
                }
                this.a = v + 1;
                this.b = v;
                Object[] arr_object = e0.b;
                q.d(arr_object);
                Object object0 = arr_object[this.b];
                this.g();
                return object0;
            }
        }
    }
}

