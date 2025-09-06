package qb;

import com.iloen.melon.net.HttpResponse.Notification;
import kotlin.jvm.internal.q;

public final class w implements x {
    public final Notification a;

    public w(Notification httpResponse$Notification0) {
        this.a = httpResponse$Notification0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof w ? q.b(this.a, ((w)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "NotAvailable(notification=" + this.a + ")";
    }
}

