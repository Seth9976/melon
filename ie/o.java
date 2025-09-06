package ie;

import java.io.Serializable;
import kotlin.jvm.internal.q;

public final class o implements Serializable {
    public final Throwable a;

    public o(Throwable throwable0) {
        q.g(throwable0, "exception");
        super();
        this.a = throwable0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof o && q.b(this.a, ((o)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Failure(" + this.a + ')';
    }
}

