package P0;

import java.util.Comparator;
import kotlin.jvm.internal.q;

public final class p0 implements Comparator {
    public final int a;
    public static final p0 b;

    static {
        p0.b = new p0(0);
    }

    public p0(int v) {
        this.a = v;
        super();
    }

    @Override
    public final int compare(Object object0, Object object1) {
        if(this.a != 0) {
            int v = q.h(((I)object0).r, ((I)object1).r);
            return v == 0 ? q.h(((I)object0).hashCode(), ((I)object1).hashCode()) : v;
        }
        int v1 = q.h(((I)object1).r, ((I)object0).r);
        return v1 == 0 ? q.h(((I)object0).hashCode(), ((I)object1).hashCode()) : v1;
    }
}

