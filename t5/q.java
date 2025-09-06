package t5;

import ie.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Map;
import je.x;
import xe.a;

public final class q implements Iterable, a {
    public final Map a;
    public static final q b;

    static {
        q.b = new q(x.a);
    }

    public q(Map map0) {
        this.a = map0;
    }

    public final Object a(String s) {
        p p0 = (p)this.a.get(s);
        return p0 != null ? p0.a : null;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof q && kotlin.jvm.internal.q.b(this.a, ((q)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final Iterator iterator() {
        ArrayList arrayList0 = new ArrayList(this.a.size());
        for(Object object0: this.a.entrySet()) {
            arrayList0.add(new m(((String)((Map.Entry)object0).getKey()), ((p)((Map.Entry)object0).getValue())));
        }
        return arrayList0.iterator();
    }

    @Override
    public final String toString() {
        return "Parameters(entries=" + this.a + ')';
    }
}

