package va;

import A8.r;
import com.iloen.melon.net.HttpResponse.Notification;
import kotlin.jvm.internal.q;

public final class k1 implements n1 {
    public final Notification a;
    public final r b;

    public k1(Notification httpResponse$Notification0, r r0) {
        q.g(r0, "loginType");
        super();
        this.a = httpResponse$Notification0;
        this.b = r0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof k1)) {
            return false;
        }
        return q.b(this.a, ((k1)object0).a) ? this.b == ((k1)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? this.b.hashCode() : this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "Failure(notification=" + this.a + ", loginType=" + this.b + ")";
    }
}

