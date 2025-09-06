package Na;

import com.iloen.melon.net.HttpResponse;
import kotlin.jvm.internal.q;

public final class d extends f {
    public final Exception a;

    public d(Exception exception0) {
        this.a = exception0;
    }

    @Override  // Na.b
    public final Exception a() {
        return this.a;
    }

    @Override  // Na.b
    public final HttpResponse b() {
        return null;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof d ? q.b(this.a, ((d)object0).a) : false;
    }

    @Override  // Na.b
    public final a getResult() {
        return a.b;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override  // Na.f
    public final String toString() {
        return "Error(exception=" + this.a + ")";
    }
}

