package x1;

import A7.d;

public final class f {
    public final Object a;
    public final int b;
    public final o c;

    public f(Object object0, int v, o o0) {
        this.a = object0;
        this.b = v;
        this.c = o0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof f && this.a.equals(((f)object0).a) && this.b == ((f)object0).b && this.c.equals(((f)object0).c);
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + d.b(this.b, this.a.hashCode() * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        return "HorizontalAnchor(id=" + this.a + ", index=" + this.b + ", reference=" + this.c + ')';
    }
}

