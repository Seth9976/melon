package gd;

import Ac.m4;
import com.melon.ui.e3;
import kotlin.jvm.internal.q;

public final class g7 extends m4 {
    public final e3 a;

    public g7(e3 e30) {
        this.a = e30;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof g7 ? q.b(this.a, ((g7)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "NotificationScreen(notificationUiState=" + this.a + ")";
    }
}

