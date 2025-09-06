package I;

public interface d {
    public static final c a;

    static {
        d.a = c.a;
    }

    default float a(float f, float f1, float f2) {
        d.a.getClass();
        float f3 = f1 + f;
        if(f >= 0.0f && f3 <= f2 || f < 0.0f && f3 > f2) {
            return 0.0f;
        }
        float f4 = f3 - f2;
        return Math.abs(f) < Math.abs(f4) ? f : f4;
    }
}

