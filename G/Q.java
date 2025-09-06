package G;

public final class q extends u {
    public float a;

    public q(float f) {
        this.a = f;
    }

    @Override  // G.u
    public final float a(int v) {
        return v == 0 ? this.a : 0.0f;
    }

    @Override  // G.u
    public final int b() {
        return 1;
    }

    @Override  // G.u
    public final u c() {
        return new q(0.0f);
    }

    @Override  // G.u
    public final void d() {
        this.a = 0.0f;
    }

    @Override  // G.u
    public final void e(float f, int v) {
        if(v == 0) {
            this.a = f;
        }
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof q && ((q)object0).a == this.a;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return "AnimationVector1D: value = " + this.a;
    }
}

