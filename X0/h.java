package X0;

import Ce.d;
import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class h {
    public final float a;
    public final d b;
    public final int c;
    public static final h d;

    static {
        h.d = new h(0.0f, new d(0.0f, 0.0f), 0);
    }

    public h(float f, d d0, int v) {
        this.a = f;
        this.b = d0;
        this.c = v;
        if(Float.isNaN(f)) {
            throw new IllegalArgumentException("current must not be NaN");
        }
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof h && this.a == ((h)object0).a && q.b(this.b, ((h)object0).b) && this.c == ((h)object0).c;
    }

    @Override
    public final int hashCode() {
        return (this.b.hashCode() + Float.hashCode(this.a) * 0x1F) * 0x1F + this.c;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ProgressBarRangeInfo(current=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", range=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", steps=");
        return o.q(stringBuilder0, this.c, ')');
    }
}

