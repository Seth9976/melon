package Ac;

import com.melon.ui.e3;
import kotlin.jvm.internal.q;

public final class l0 extends n0 {
    public final e3 a;

    public l0(e3 e30) {
        this.a = e30;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof l0 ? q.b(this.a, ((l0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Notification(notificationScreenUiState=" + this.a + ")";
    }
}

