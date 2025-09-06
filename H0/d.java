package H0;

import android.view.KeyEvent;
import kotlin.jvm.internal.q;

public final class d {
    public final KeyEvent a;

    public d(KeyEvent keyEvent0) {
        this.a = keyEvent0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof d && q.b(this.a, ((d)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "KeyEvent(nativeKeyEvent=" + this.a + ')';
    }
}

