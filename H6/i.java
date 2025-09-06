package H6;

import va.e;

public final class i extends f {
    public final Object a;
    private static final long serialVersionUID;

    public i(Object object0) {
        this.a = object0;
    }

    @Override  // H6.f
    public final Object a() {
        return this.a;
    }

    @Override  // H6.f
    public final boolean b() {
        return true;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof i ? this.a.equals(((i)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode() + 0x598DF91C;
    }

    @Override
    public final String toString() {
        return e.d(new StringBuilder("Optional.of("), this.a, ")");
    }
}

