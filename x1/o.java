package x1;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.q;

public abstract class o {
    public final Object a;
    public final LinkedHashMap b;

    public o(Object object0) {
        this.a = object0;
        this.b = new LinkedHashMap();
    }

    public Object a() {
        return this.a;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof o && q.b(this.a(), ((o)object0).a());
    }

    @Override
    public final int hashCode() {
        return this.a().hashCode();
    }
}

