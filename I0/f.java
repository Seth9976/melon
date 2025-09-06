package i0;

import java.util.NoSuchElementException;

public final class f extends a {
    public final Object[] c;
    public final i d;

    public f(Object[] arr_object, int v, Object[] arr_object1, int v1, int v2) {
        super(v, v1);
        this.c = arr_object1;
        int v3 = v1 - 1 & 0xFFFFFFE0;
        if(v > v3) {
            v = v3;
        }
        this.d = new i(arr_object, v, v3, v2);
    }

    @Override
    public final Object next() {
        if(!this.hasNext()) {
            throw new NoSuchElementException();
        }
        i i0 = this.d;
        if(i0.hasNext()) {
            ++this.a;
            return i0.next();
        }
        int v = this.a;
        this.a = v + 1;
        return this.c[v - i0.b];
    }

    @Override
    public final Object previous() {
        if(!this.hasPrevious()) {
            throw new NoSuchElementException();
        }
        int v = this.a;
        i i0 = this.d;
        int v1 = i0.b;
        if(v > v1) {
            this.a = v - 1;
            return this.c[v - 1 - v1];
        }
        this.a = v - 1;
        return i0.previous();
    }
}

