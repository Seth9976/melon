package i.n.i.b.a.s.e;

import java.io.Serializable;

public final class b3 extends o4 implements Serializable {
    public final int a;
    public static final b3 b;
    public static final b3 c;

    static {
        b3.b = new b3(0);
        b3.c = new b3(1);
    }

    public b3(int v) {
        this.a = v;
        super();
    }

    @Override  // i.n.i.b.a.s.e.o4
    public final o4 a() {
        return this.a == 0 ? b3.c : b3.b;
    }

    @Override
    public final int compare(Object object0, Object object1) {
        if(this.a != 0) {
            ((Comparable)object0).getClass();
            return ((Comparable)object0) == ((Comparable)object1) ? 0 : ((Comparable)object1).compareTo(((Comparable)object0));
        }
        ((Comparable)object0).getClass();
        ((Comparable)object1).getClass();
        return ((Comparable)object0).compareTo(((Comparable)object1));
    }

    @Override
    public final String toString() {
        return this.a == 0 ? "Ordering.natural()" : "Ordering.natural().reverse()";
    }
}

