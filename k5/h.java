package k5;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.q;

public final class h {
    public final Drawable a;
    public final boolean b;

    public h(Drawable drawable0, boolean z) {
        this.a = drawable0;
        this.b = z;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof h && q.b(this.a, ((h)object0).a) && this.b == ((h)object0).b;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.b) + this.a.hashCode() * 0x1F;
    }
}

