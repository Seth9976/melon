package q2;

import kotlin.jvm.internal.q;

public final class f {
    public final String a;

    public f(String s) {
        q.g(s, "name");
        super();
        this.a = s;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof f ? q.b(this.a, ((f)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return this.a;
    }
}

