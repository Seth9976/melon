package b;

import ie.H;
import java.util.ListIterator;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.k;

public final class o extends r implements k {
    public final int f;
    public final t g;

    public o(t t0, int v) {
        this.f = v;
        this.g = t0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.f != 0) {
            q.g(((a)object0), "backEvent");
            t t0 = this.g;
            n n0 = t0.c;
            if(n0 == null) {
                Object object1 = null;
                ListIterator listIterator0 = t0.b.listIterator(t0.b.b());
                while(listIterator0.hasPrevious()) {
                    Object object2 = listIterator0.previous();
                    if(((n)object2).isEnabled()) {
                        object1 = object2;
                        break;
                    }
                }
                n0 = (n)object1;
            }
            if(n0 != null) {
                n0.handleOnBackProgressed(((a)object0));
            }
            return H.a;
        }
        Object object3 = null;
        q.g(((a)object0), "backEvent");
        t t1 = this.g;
        ListIterator listIterator1 = t1.b.listIterator(t1.b.b());
        while(listIterator1.hasPrevious()) {
            Object object4 = listIterator1.previous();
            if(((n)object4).isEnabled()) {
                object3 = object4;
                break;
            }
        }
        if(t1.c != null) {
            t1.b();
        }
        t1.c = (n)object3;
        if(((n)object3) != null) {
            ((n)object3).handleOnBackStarted(((a)object0));
        }
        return H.a;
    }
}

