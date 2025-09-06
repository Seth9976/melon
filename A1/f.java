package a1;

import e1.b;
import java.util.Comparator;

public final class f implements Comparator {
    public final int a;

    public f(int v) {
        this.a = v;
        super();
    }

    @Override
    public final int compare(Object object0, Object object1) {
        return b.r(((e)object0).b, ((e)object1).b);
    }
}

