package l1;

import g1.a;

public final class f {
    public final float a;
    public static final float b;
    public static final float c;
    public static final float d;

    static {
        f.a(0.0f);
        f.a(0.5f);
        f.b = 0.5f;
        f.a(-1.0f);
        f.c = -1.0f;
        f.a(1.0f);
        f.d = 1.0f;
    }

    public f(float f) {
        this.a = f;
    }

    public static void a(float f) {
        if(0.0f <= f && f <= 1.0f || f == -1.0f) {
            return;
        }
        a.c("topRatio should be in [0..1] range or -1");
    }

    public static String b(float f) {
        if(f == 0.0f) {
            return "LineHeightStyle.Alignment.Top";
        }
        if(f == f.b) {
            return "LineHeightStyle.Alignment.Center";
        }
        if(f == f.c) {
            return "LineHeightStyle.Alignment.Proportional";
        }
        return f == f.d ? "LineHeightStyle.Alignment.Bottom" : "LineHeightStyle.Alignment(topPercentage = " + f + ')';
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof f && Float.compare(this.a, ((f)object0).a) == 0;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return f.b(this.a);
    }
}

