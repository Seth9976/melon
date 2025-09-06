package hc;

import U4.x;
import kotlin.jvm.internal.q;

public final class k {
    public final boolean a;
    public final j b;
    public final String c;

    public k(boolean z, j j0, String s) {
        q.g(j0, "action");
        super();
        this.a = z;
        this.b = j0;
        this.c = s;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof k && this.a == ((k)object0).a && this.b == ((k)object0).b && this.c.equals(((k)object0).c);
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() + Boolean.hashCode(this.a) * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("RemoteAvailable(isAvailable=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", action=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", toastMessage=");
        return x.m(stringBuilder0, this.c, ")");
    }
}

