package mg;

import Tf.o;
import e3.h;
import ie.m;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import je.C;
import kotlin.jvm.internal.q;

public final class b {
    public final LinkedHashMap a;

    static {
    }

    public b() {
        this.a = new LinkedHashMap();
    }

    public b(b b0) {
        q.g(b0, "original");
        super();
        Iterable iterable0 = b0.a.entrySet();
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
        for(Object object0: iterable0) {
            Object object1 = ((Map.Entry)object0).getKey();
            a a0 = (a)((Map.Entry)object0).getValue();
            q.g(a0, "original");
            arrayList0.add(new m(object1, new a(a0.a, a0.b)));
        }
        this.a = C.a0(C.Y(arrayList0));
    }

    public final boolean a(String s, String s1) {
        String s2 = this.b(s);
        return s2 == null ? false : o.v0(s2, s1, true);
    }

    public final String b(String s) {
        String s1 = h.j(s);
        a a0 = (a)this.a.get(s1);
        return a0 == null ? null : a0.b;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        for(Object object0: this.a.values()) {
            stringBuilder0.append(((a)object0).a);
            stringBuilder0.append(": ");
            stringBuilder0.append(((a)object0).b);
            stringBuilder0.append("\r\n");
        }
        String s = stringBuilder0.toString();
        q.f(s, "StringBuilder().apply(builderAction).toString()");
        return s;
    }
}

