package qb;

import com.iloen.melon.net.HttpResponse.Notification;
import e1.u;
import kotlin.jvm.internal.q;

public final class c extends u {
    public final Notification e;

    public c(Notification httpResponse$Notification0) {
        this.e = httpResponse$Notification0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof c ? q.b(this.e, ((c)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        return this.e == null ? 0 : this.e.hashCode();
    }

    @Override
    public final String toString() {
        return "NotificationHandle(notification=" + this.e + ")";
    }
}

