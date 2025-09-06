package a0;

import A7.d;

public final class f {
    public final float a;
    public final float b;
    public final float c;
    public final float d;

    public f(float f, float f1, float f2, float f3) {
        this.a = f;
        this.b = f1;
        this.c = f2;
        this.d = f3;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof f ? this.a == ((f)object0).a && this.b == ((f)object0).b && this.c == ((f)object0).c && this.d == ((f)object0).d : false;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.d) + d.a(this.c, d.a(this.b, Float.hashCode(this.a) * 0x1F, 0x1F), 0x1F);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("RippleAlpha(draggedAlpha=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", focusedAlpha=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", hoveredAlpha=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", pressedAlpha=");
        return d.m(stringBuilder0, this.d, ')');
    }
}

