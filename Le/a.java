package le;

import java.util.Comparator;
import kotlin.jvm.internal.q;

public final class a implements Comparator {
    public final int a;
    public static final a b;
    public static final a c;

    static {
        a.b = new a(0);
        a.c = new a(1);
    }

    public a(int v) {
        this.a = v;
        super();
    }

    @Override
    public final int compare(Object object0, Object object1) {
        if(this.a != 0) {
            q.g(((Comparable)object0), "a");
            q.g(((Comparable)object1), "b");
            return ((Comparable)object1).compareTo(((Comparable)object0));
        }
        q.g(((Comparable)object0), "a");
        q.g(((Comparable)object1), "b");
        return ((Comparable)object0).compareTo(((Comparable)object1));
    }

    @Override
    public final Comparator reversed() {
        return this.a == 0 ? a.c : a.b;
    }
}

