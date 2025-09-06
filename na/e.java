package Na;

import com.iloen.melon.net.HttpResponse;
import kotlin.jvm.internal.q;

public final class e extends f {
    public final Object a;

    public e(Object object0) {
        this.a = object0;
    }

    @Override  // Na.b
    public final Exception a() {
        return null;
    }

    // 去混淆评级： 低(20)
    @Override  // Na.b
    public final HttpResponse b() {
        return this.a instanceof HttpResponse ? ((HttpResponse)this.a) : null;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof e ? q.b(this.a, ((e)object0).a) : false;
    }

    @Override  // Na.b
    public final a getResult() {
        return a.a;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override  // Na.f
    public final String toString() {
        return "Success(data=" + this.a + ")";
    }
}

