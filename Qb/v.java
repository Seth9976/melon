package qb;

import com.iloen.melon.net.HttpResponse.Notification;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import kotlin.jvm.internal.q;

public final class v implements x {
    public final MelonBottomSheetItem a;
    public final Notification b;

    public v(MelonBottomSheetItem melonBottomSheetItem0, Notification httpResponse$Notification0) {
        this.a = melonBottomSheetItem0;
        this.b = httpResponse$Notification0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof v)) {
            return false;
        }
        return q.b(this.a, ((v)object0).a) ? q.b(this.b, ((v)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? v * 0x1F : v * 0x1F + this.b.hashCode();
    }

    @Override
    public final String toString() {
        return "Available(contextItemInfo=" + this.a + ", notification=" + this.b + ")";
    }
}

