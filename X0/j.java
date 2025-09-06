package X0;

import H0.b;
import kotlin.jvm.internal.r;
import we.a;

public final class j {
    public final r a;
    public final r b;
    public final boolean c;

    public j(a a0, a a1, boolean z) {
        this.a = (r)a0;
        this.b = (r)a1;
        this.c = z;
    }

    public final a a() {
        return this.b;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ScrollAxisRange(value=");
        stringBuilder0.append(((Number)((a)this.a).invoke()).floatValue());
        stringBuilder0.append(", maxValue=");
        stringBuilder0.append(((Number)((a)this.b).invoke()).floatValue());
        stringBuilder0.append(", reverseScrolling=");
        return b.k(stringBuilder0, this.c, ')');
    }
}

