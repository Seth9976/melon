package z6;

public final class g extends f {
    public final float b;

    public g(float f) {
        super(0);
        this.b = f - 0.001f;
    }

    @Override  // z6.f
    public final void l(float f, float f1, float f2, x x0) {
        float f3 = (float)(1.414214 * ((double)this.b) / 2.0);
        float f4 = (float)Math.sqrt(Math.pow(this.b, 2.0) - Math.pow(f3, 2.0));
        x0.e(f1 - f3, ((float)(-(1.414214 * ((double)this.b) - ((double)this.b)))) + f4, 270.0f, 0.0f);
        x0.d(f1, ((float)(-(1.414214 * ((double)this.b) - ((double)this.b)))));
        x0.d(f1 + f3, ((float)(-(1.414214 * ((double)this.b) - ((double)this.b)))) + f4);
    }
}

