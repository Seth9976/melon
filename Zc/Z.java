package zc;

import com.iloen.melon.utils.ui.ViewUtilsKt;
import kotlin.jvm.internal.q;
import r1.c;
import r1.j;
import we.k;

public final class z implements k {
    public final float a;
    public final float b;

    public z(float f, float f1) {
        this.a = f;
        this.b = f1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((c)object0), "$this$offset");
        int v = ViewUtilsKt.dpToPx(15);
        int v1 = ViewUtilsKt.dpToPx(15);
        return new j(((long)(((int)this.b) - v1)) & 0xFFFFFFFFL | ((long)(((int)this.a) - v)) << 0x20);
    }
}

