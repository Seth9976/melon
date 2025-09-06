package i.n.i.b.a.s.e;

import e0.b;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class o8 extends Ea {
    public int a;
    public Object b;
    public final Iterator c;
    public final p8 d;

    public o8(p8 p80) {
        this.d = p80;
        this.a = 2;
        this.c = p80.a.iterator();
    }

    @Override
    public final boolean hasNext() {
        Object object0;
        int v = this.a;
        if(v == 4) {
            throw new IllegalStateException();
        }
        switch(E.a[b.b(v)]) {
            case 1: {
                break;
            }
            case 2: {
                return true;
            }
            default: {
                this.a = 4;
                do {
                    Iterator iterator0 = this.c;
                    if(!iterator0.hasNext()) {
                        goto label_10;
                    }
                    object0 = iterator0.next();
                }
                while(!this.d.b.contains(object0));
                Object object1 = object0;
                goto label_12;
            label_10:
                this.a = 3;
                object1 = null;
            label_12:
                this.b = object1;
                if(this.a != 3) {
                    this.a = 1;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public final Object next() {
        if(!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.a = 2;
        Object object0 = this.b;
        this.b = null;
        return object0;
    }
}

