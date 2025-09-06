package ie;

import kotlin.jvm.internal.q;

public final class x implements Comparable {
    public final int a;
    public static final w b;

    static {
        x.b = new w();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public x(int v) {
        this.a = v;
    }

    @Override
    public final int compareTo(Object object0) {
        return q.h(this.a ^ 0x80000000, ((x)object0).a ^ 0x80000000);
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof x && this.a == ((x)object0).a;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return String.valueOf(((long)this.a) & 0xFFFFFFFFL);
    }
}

