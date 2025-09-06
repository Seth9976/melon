package Q0;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public final class c0 implements b1 {
    public final ViewConfiguration a;

    public c0(ViewConfiguration viewConfiguration0) {
        this.a = viewConfiguration0;
    }

    @Override  // Q0.b1
    public final long a() {
        return 300L;
    }

    @Override  // Q0.b1
    public final long b() {
        return (long)ViewConfiguration.getLongPressTimeout();
    }

    @Override  // Q0.b1
    public final float c() {
        return Build.VERSION.SDK_INT < 34 ? 2.0f : ((float)this.a.getScaledHandwritingSlop());
    }

    @Override  // Q0.b1
    public final float e() {
        return (float)this.a.getScaledMaximumFlingVelocity();
    }

    @Override  // Q0.b1
    public final float f() {
        return (float)this.a.getScaledTouchSlop();
    }

    @Override  // Q0.b1
    public final float g() {
        return Build.VERSION.SDK_INT < 34 ? 16.0f : ((float)this.a.getScaledHandwritingGestureLineMargin());
    }
}

