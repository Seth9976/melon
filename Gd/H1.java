package gd;

import Ac.m4;
import com.melon.ui.e3;
import kotlin.jvm.internal.q;

public final class h1 extends m4 {
    public final e3 a;

    public h1(e3 e30) {
        this.a = e30;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof h1 ? q.b(this.a, ((h1)object0).a) : false;
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

