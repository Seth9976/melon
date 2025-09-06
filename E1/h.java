package e1;

import A7.d;
import kotlin.jvm.internal.q;

public final class H {
    public final int a;
    public final y b;
    public final w c;

    public H(int v, y y0, w w0) {
        this.a = v;
        this.b = y0;
        this.c = w0;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof H && this.a == ((H)object0).a && q.b(this.b, ((H)object0).b) && this.c.equals(((H)object0).c);
    }

    @Override
    public final int hashCode() {
        return this.c.a.hashCode() + d.b(0, d.b(0, (this.a * 0x1F + this.b.a) * 0x1F, 0x1F), 0x1F);
    }

    @Override
    public final String toString() {
        return "ResourceFont(resId=" + this.a + ", weight=" + this.b + ", style=" + "Normal" + ", loadingStrategy=Blocking)";
    }
}

