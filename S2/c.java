package S2;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.q;

public abstract class c {
    public final LinkedHashMap a;

    public c() {
        this.a = new LinkedHashMap();
    }

    public abstract Object a(b arg1);

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof c && q.b(this.a, ((c)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "CreationExtras(extras=" + this.a + ')';
    }
}

