package Pa;

import com.iloen.melon.net.HttpResponse.Notification;
import kotlin.jvm.internal.q;

public final class f extends h {
    public final Notification a;

    public f(Notification httpResponse$Notification0) {
        this.a = httpResponse$Notification0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof f ? q.b(this.a, ((f)object0).a) : false;
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

