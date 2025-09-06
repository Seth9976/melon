package t5;

import java.util.Map;
import je.x;
import kotlin.jvm.internal.q;

public final class t {
    public final Map a;
    public static final t b;

    static {
        t.b = new t(x.a);
    }

    public t(Map map0) {
        this.a = map0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof t && q.b(this.a, ((t)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Tags(tags=" + this.a + ')';
    }
}

