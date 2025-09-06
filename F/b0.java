package F;

public final class b0 {
    public float a;
    public float b;

    public a0 a(float f) {
        double f1 = this.b(f);
        return new a0(f, ((float)(Math.exp(((double)c0.a) / (((double)c0.a) - 1.0) * f1) * ((double)(this.a * this.b)))), ((long)(Math.exp(f1 / (((double)c0.a) - 1.0)) * 1000.0)));
    }

    public double b(float f) {
        return Math.log(((double)(Math.abs(f) * 0.35f)) / ((double)(this.a * this.b)));
    }
}

