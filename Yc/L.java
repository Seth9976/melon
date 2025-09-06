package yc;

import Ac.m4;
import com.melon.ui.e3;
import kotlin.jvm.internal.q;

public final class l extends m4 {
    public final e3 a;

    public l(e3 e30) {
        this.a = e30;
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
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "NotificationScreen(notificationScreenUiState=" + this.a + ")";
    }
}

