package i0;

import java.util.NoSuchElementException;

public final class c extends a {
    public final int c;
    public final Object d;

    public c(Object object0, int v) {
        this.c = 1;
        super(v, 1);
        this.d = object0;
    }

    public c(Object[] arr_object, int v, int v1) {
        this.c = 0;
        super(v, v1);
        this.d = arr_object;
    }

    @Override
    public final Object next() {
        if(this.c != 0) {
            if(!this.hasNext()) {
                throw new NoSuchElementException();
            }
            ++this.a;
            return this.d;
        }
        if(!this.hasNext()) {
            throw new NoSuchElementException();
        }
        int v = this.a;
        this.a = v + 1;
        return ((Object[])this.d)[v];
    }

    @Override
    public final Object previous() {
        if(this.c != 0) {
            if(!this.hasPrevious()) {
                throw new NoSuchElementException();
            }
            --this.a;
            return this.d;
        }
        if(!this.hasPrevious()) {
            throw new NoSuchElementException();
        }
        int v = this.a - 1;
        this.a = v;
        return ((Object[])this.d)[v];
    }
}

