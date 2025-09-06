package t5;

import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class p {
    public final Integer a;
    public final String b;

    public p(Integer integer0, String s) {
        this.a = integer0;
        this.b = s;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof p && this.a.equals(((p)object0).a) && q.b(this.b, ((p)object0).b);
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? v * 0x1F : v * 0x1F + this.b.hashCode();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Entry(value=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", memoryCacheKey=");
        return o.r(stringBuilder0, this.b, ')');
    }
}

