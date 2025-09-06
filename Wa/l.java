package Wa;

import com.iloen.melon.net.HttpResponse.Notification;
import kotlin.jvm.internal.q;

public final class l extends p {
    public final Notification a;

    public l(Notification httpResponse$Notification0) {
        this.a = httpResponse$Notification0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof l ? q.b(this.a, ((l)object0).a) : false;
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

