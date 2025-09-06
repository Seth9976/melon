package Ce;

import kotlin.jvm.internal.q;

public final class c extends a {
    static {
        new c('\u0001', '\u0000');  // 初始化器: LCe/a;-><init>(CC)V
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof c && (q.h(this.a, this.b) > 0 && q.h(((c)object0).a, ((c)object0).b) > 0 || this.a == ((c)object0).a && this.b == ((c)object0).b);
    }

    @Override
    public final int hashCode() {
        return q.h(this.a, this.b) <= 0 ? this.a * 0x1F + this.b : -1;
    }

    @Override
    public final String toString() {
        return this.a + ".." + this.b;
    }
}

