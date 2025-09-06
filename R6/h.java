package r6;

import com.google.android.material.bottomappbar.b;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public final class h {
    public final b a;
    public final FloatingActionButton b;

    public h(FloatingActionButton floatingActionButton0, b b0) {
        this.b = floatingActionButton0;
        this.a = b0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof h && ((h)object0).a.equals(this.a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }
}

