package v8;

import com.iloen.melon.net.HttpRequest;
import kotlin.jvm.internal.q;

public final class g {
    public final HttpRequest a;
    public final String b;

    public g(HttpRequest httpRequest0, String s) {
        q.g(s, "tag");
        super();
        this.a = httpRequest0;
        this.b = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof g)) {
            return false;
        }
        return q.b(this.a, ((g)object0).a) ? q.b(this.b, ((g)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "RequestWrapper(request=" + this.a + ", tag=" + this.b + ")";
    }
}

