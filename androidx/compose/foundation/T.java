package androidx.compose.foundation;

import kotlin.jvm.internal.q;
import y0.b;
import y0.e;
import y0.g;

public final class t {
    public e a;
    public b b;
    public A0.b c;
    public g d;

    public t() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof t && q.b(this.a, ((t)object0).a) && q.b(this.b, ((t)object0).b) && q.b(this.c, ((t)object0).c) && q.b(this.d, ((t)object0).d);
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        g g0 = this.d;
        if(g0 != null) {
            v = g0.hashCode();
        }
        return ((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v;
    }

    @Override
    public final String toString() {
        return "BorderCache(imageBitmap=" + this.a + ", canvas=" + this.b + ", canvasDrawScope=" + this.c + ", borderPath=" + this.d + ')';
    }
}

