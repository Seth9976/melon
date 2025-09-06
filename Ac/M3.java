package Ac;

import com.melon.ui.e3;
import kotlin.jvm.internal.q;

public final class m3 extends o3 {
    public final e3 a;

    public m3(e3 e30) {
        this.a = e30;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof m3 ? q.b(this.a, ((m3)object0).a) : false;
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

