package tb;

import com.iloen.melon.net.HttpResponse.Notification;
import kotlin.jvm.internal.q;

public final class d extends e {
    public final Notification a;

    public d(Notification httpResponse$Notification0) {
        this.a = httpResponse$Notification0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof d ? q.b(this.a, ((d)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "NotificationHandle(notification=" + this.a + ")";
    }
}

