package u8;

import A7.d;
import P4.a;
import kotlin.jvm.internal.q;

public final class c {
    public final String a;
    public final long b;

    public c(String s) {
        q.g(s, "cacheKey");
        super();
        this.a = s;
        this.b = a.a * 5L;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof c && q.b(this.a, ((c)object0).a) && this.b == ((c)object0).b;
    }

    @Override
    public final int hashCode() {
        return d.c(this.a.hashCode() * 0x1F, 0x1F, this.b) + 0x4D5;
    }

    @Override
    public final String toString() {
        return "CacheStrategyInfo(cacheKey=" + this.a + ", cacheTime=" + this.b + ", isUsedDbCache=false)";
    }
}

