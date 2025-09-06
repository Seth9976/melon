package I;

public final class f implements d {
    @Override  // I.d
    public final float a(float f, float f1, float f2) {
        float f3 = Math.abs(f1 + f - f);
        return f - (f3 > f2 || f2 - (0.3f * f2 - 0.0f * f3) >= f3 ? 0.3f * f2 - 0.0f * f3 : f2 - f3);
    }
}

