package O9;

import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class h {
    public final boolean a;
    public final String b;

    public h() {
        this(false, null);
    }

    public h(boolean z, String s) {
        this.a = z;
        this.b = s;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof h && this.a == ((h)object0).a && q.b(this.b, ((h)object0).b);
    }

    @Override
    public final int hashCode() {
        int v = Boolean.hashCode(this.a);
        return this.b == null ? v * 0x1F : v * 0x1F + this.b.hashCode();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("RefreshResult(needToClear=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", reason=");
        return o.r(stringBuilder0, this.b, ')');
    }
}

