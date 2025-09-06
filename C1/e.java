package C1;

public final class e implements d {
    public float a;
    public float b;

    @Override  // C1.d
    public final float value() {
        float f = this.b + this.a;
        this.b = f;
        return f;
    }
}

