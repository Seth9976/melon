package i.n.i.b.a.s.e;

import java.util.Locale;

public final class x6 {
    public final float a;
    public final float b;
    public final int c;
    public static final x6 d;

    static {
        x6.d = new x6(1.0f, 1.0f);
    }

    public x6(float f, float f1) {
        boolean z = false;
        M7.u(Float.compare(f, 0.0f) > 0);
        if(f1 > 0.0f) {
            z = true;
        }
        M7.u(z);
        this.a = f;
        this.b = f1;
        this.c = Math.round(f * 1000.0f);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return x6.class == class0 && this.a == ((x6)object0).a && this.b == ((x6)object0).b;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Float.floatToRawIntBits(this.b) + (Float.floatToRawIntBits(this.a) + 0x20F) * 0x1F;
    }

    @Override
    public final String toString() {
        return String.format(Locale.US, "PlaybackParameters(speed=%.2f, pitch=%.2f)", this.a, this.b);
    }
}

