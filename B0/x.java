package b0;

import y0.s;

public final class x {
    public final long a;

    public x() {
        this.a = s.g;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof x && s.d(this.a, ((x)object0).a);
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.a) * 0x1F;
    }

    @Override
    public final String toString() {
        return "RippleConfiguration(color=" + s.j(this.a) + ", rippleAlpha=null)";
    }
}

