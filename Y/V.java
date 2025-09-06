package Y;

import A7.d;
import U.S;
import x0.b;

public final class v {
    public final S a;
    public final long b;
    public final u c;
    public final boolean d;

    public v(S s0, long v, u u0, boolean z) {
        this.a = s0;
        this.b = v;
        this.c = u0;
        this.d = z;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof v && this.a == ((v)object0).a && b.b(this.b, ((v)object0).b) && this.c == ((v)object0).c && this.d == ((v)object0).d;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.d) + (this.c.hashCode() + d.c(this.a.hashCode() * 0x1F, 0x1F, this.b)) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SelectionHandleInfo(handle=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", position=");
        stringBuilder0.append(b.i(this.b));
        stringBuilder0.append(", anchor=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", visible=");
        return H0.b.k(stringBuilder0, this.d, ')');
    }
}

