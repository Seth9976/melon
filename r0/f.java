package r0;

import r1.m;

public final class f implements e {
    public final float a;

    public f(float f) {
        this.a = f;
    }

    @Override  // r0.e
    public final long a(long v, long v1, m m0) {
        long v2 = ((long)(((int)(v1 >> 0x20)) - ((int)(v >> 0x20)))) << 0x20 | ((long)(((int)(v1 & 0xFFFFFFFFL)) - ((int)(v & 0xFFFFFFFFL)))) & 0xFFFFFFFFL;
        return ((long)Math.round(0.0f * (((float)(((int)(v2 & 0xFFFFFFFFL)))) / 2.0f))) & 0xFFFFFFFFL | ((long)Math.round((this.a + 1.0f) * (((float)(((int)(v2 >> 0x20)))) / 2.0f))) << 0x20;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof f && Float.compare(this.a, ((f)object0).a) == 0;
    }

    @Override
    public final int hashCode() {
        return 0xBF800000 + Float.hashCode(this.a) * 0x1F;
    }

    @Override
    public final String toString() {
        return "BiasAbsoluteAlignment(horizontalBias=" + this.a + ", verticalBias=-1.0)";
    }
}

