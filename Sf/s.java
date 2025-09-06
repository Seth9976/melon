package Sf;

import android.view.View;
import android.view.ViewGroup;
import c2.Y;
import java.util.ArrayList;
import java.util.Iterator;
import je.p;
import je.u;
import xe.a;

public final class s implements Iterator, a {
    public final int a;
    public Iterator b;
    public final Object c;

    public s(t t0) {
        this.a = 0;
        super();
        this.c = t0;
        this.b = t0.a.iterator();
    }

    public s(Y y0) {
        this.a = 1;
        super();
        this.c = new ArrayList();
        this.b = y0;
    }

    @Override
    public final boolean hasNext() {
        return this.b.hasNext();
    }

    @Override
    public final Object next() {
        if(this.a != 0) {
            Object object0 = this.b.next();
            ArrayList arrayList0 = (ArrayList)this.c;
            Y y0 = null;
            ViewGroup viewGroup0 = ((View)object0) instanceof ViewGroup ? ((ViewGroup)(((View)object0))) : null;
            if(viewGroup0 != null) {
                y0 = new Y(viewGroup0, 0);
            }
            if(y0 != null && y0.hasNext()) {
                arrayList0.add(this.b);
                this.b = y0;
                return object0;
            }
            while(!this.b.hasNext() && !arrayList0.isEmpty()) {
                this.b = (Iterator)p.s0(arrayList0);
                u.Z(arrayList0);
            }
            return object0;
        }
        Object object1 = this.b.next();
        return ((t)this.c).b.invoke(object1);
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

