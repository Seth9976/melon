package androidx.datastore.preferences.protobuf;

import androidx.glance.appwidget.protobuf.g;
import com.google.protobuf.m;
import java.util.Iterator;
import java.util.NoSuchElementException;
import rf.s;

public final class e implements Iterator {
    public final int a;
    public int b;
    public final int c;
    public final Iterable d;

    public e(h h0) {
        this.a = 0;
        super();
        this.d = h0;
        this.b = 0;
        this.c = h0.size();
    }

    public e(g g0) {
        this.a = 1;
        super();
        this.d = g0;
        this.b = 0;
        this.c = g0.size();
    }

    public e(m m0) {
        this.a = 2;
        super();
        this.d = m0;
        this.b = 0;
        this.c = m0.size();
    }

    public e(s s0) {
        this.a = 3;
        super();
        this.d = s0;
        this.b = 0;
        this.c = s0.b.length;
    }

    public byte a() {
        try {
            int v = this.b;
            this.b = v + 1;
            return ((s)this.d).b[v];
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
            throw new NoSuchElementException(arrayIndexOutOfBoundsException0.getMessage());
        }
    }

    @Override
    public final boolean hasNext() {
        switch(this.a) {
            case 0: {
                return this.b < this.c;
            }
            case 1: {
                return this.b < this.c;
            }
            case 2: {
                return this.b < this.c;
            }
            default: {
                return this.b < this.c;
            }
        }
    }

    @Override
    public final Object next() {
        switch(this.a) {
            case 0: {
                int v = this.b;
                if(v >= this.c) {
                    throw new NoSuchElementException();
                }
                this.b = v + 1;
                return ((h)this.d).f(v);
            }
            case 1: {
                int v1 = this.b;
                if(v1 >= this.c) {
                    throw new NoSuchElementException();
                }
                this.b = v1 + 1;
                return ((g)this.d).e(v1);
            }
            case 2: {
                int v2 = this.b;
                if(v2 >= this.c) {
                    throw new NoSuchElementException();
                }
                this.b = v2 + 1;
                return ((m)this.d).f(v2);
            }
            default: {
                return this.a();
            }
        }
    }

    @Override
    public final void remove() {
        switch(this.a) {
            case 0: {
                throw new UnsupportedOperationException();
            }
            case 1: {
                throw new UnsupportedOperationException();
            }
            case 2: {
                throw new UnsupportedOperationException();
            }
            default: {
                throw new UnsupportedOperationException();
            }
        }
    }
}

