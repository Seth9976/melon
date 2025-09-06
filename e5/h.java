package e5;

import android.net.NetworkRequest;
import kotlin.jvm.internal.q;

public final class h {
    public final Object a;
    public static final String b;

    // 去混淆评级： 低(20)
    static {
        q.f("WM-NetworkRequestCompat", "tagWithPrefix(\"NetworkRequestCompat\")");
        h.b = "WM-NetworkRequestCompat";
    }

    public h(NetworkRequest networkRequest0) {
        this.a = networkRequest0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof h ? q.b(this.a, ((h)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "NetworkRequestCompat(wrapped=" + this.a + ')';
    }
}

