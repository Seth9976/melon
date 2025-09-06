package vb;

import com.iloen.melon.net.HttpResponse.Notification;

public final class q extends s {
    public final Notification a;

    public q(Notification httpResponse$Notification0) {
        this.a = httpResponse$Notification0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof q ? kotlin.jvm.internal.q.b(this.a, ((q)object0).a) : false;
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

