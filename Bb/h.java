package bb;

import com.iloen.melon.net.HttpResponse.Notification;
import kotlin.jvm.internal.q;

public final class h extends o {
    public final Notification a;
    public final boolean b;

    public h(Notification httpResponse$Notification0, boolean z) {
        this.a = httpResponse$Notification0;
        this.b = z;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof h && q.b(this.a, ((h)object0).a) && this.b == ((h)object0).b;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? Boolean.hashCode(this.b) : Boolean.hashCode(this.b) + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "NotificationHandle(notification=" + this.a + ", handleNotification=" + this.b + ")";
    }
}

