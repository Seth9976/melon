package W5;

import java.util.Set;

public final class b {
    public final long a;
    public final long b;
    public final Set c;

    public b(long v, long v1, Set set0) {
        this.a = v;
        this.b = v1;
        this.c = set0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this ? true : object0 instanceof b && this.a == ((b)object0).a && this.b == ((b)object0).b && this.c.equals(((b)object0).c);
    }

    @Override
    public final int hashCode() {
        return ((((int)(this.a ^ this.a >>> 0x20)) ^ 1000003) * 1000003 ^ ((int)(this.b >>> 0x20 ^ this.b))) * 1000003 ^ this.c.hashCode();
    }

    @Override
    public final String toString() {
        return "ConfigValue{delta=" + this.a + ", maxAllowedDelay=" + this.b + ", flags=" + this.c + "}";
    }
}

