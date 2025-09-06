package I;

public abstract class g0 {
    public static final float a;
    public static final float b;

    static {
        g0.a = 6.0f;
        g0.b = 1.0f;
    }

    public static final boolean a(float f) {
        return Float.isNaN(f) || Math.abs(f) < 0.5f;
    }
}

