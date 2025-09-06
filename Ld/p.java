package ld;

import A7.d;
import com.melon.ui.e3;

public final class p extends r {
    public final boolean a;
    public final int b;
    public final e3 c;

    public p(boolean z, int v, e3 e30) {
        this.a = z;
        this.b = v;
        this.c = e30;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof p && this.a == ((p)object0).a && this.b == ((p)object0).b && this.c.equals(((p)object0).c);
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + d.b(this.b, Boolean.hashCode(this.a) * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        return "NotificationScreen(filterVisible=" + this.a + ", filterIndex=" + this.b + ", notificationScreenUiState=" + this.c + ")";
    }
}

