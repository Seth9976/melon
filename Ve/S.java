package Ve;

import java.util.Map;
import je.C;
import je.p;
import kotlin.jvm.internal.q;

public final class s {
    public final String a;
    public final Map b;

    public s(String s, Map map0) {
        q.g(s, "className");
        super();
        this.a = s;
        this.b = map0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof s && q.b(this.a, ((s)object0).a) && q.b(this.b, ((s)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        String s = p.q0(C.X(this.b), null, null, null, r.a, 0x1F);
        return "@" + this.a + '(' + s + ')';
    }
}

