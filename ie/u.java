package ie;

import kotlin.jvm.internal.q;

public final class u implements Comparable {
    public final byte a;
    public static final t b;

    static {
        u.b = new t();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public u(byte b) {
        this.a = b;
    }

    @Override
    public final int compareTo(Object object0) {
        return q.h(this.a & 0xFF, ((u)object0).a & 0xFF);
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof u && this.a == ((u)object0).a;
    }

    @Override
    public final int hashCode() {
        return Byte.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return String.valueOf(this.a & 0xFF);
    }
}

