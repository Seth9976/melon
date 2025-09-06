package G;

public final class r extends u {
    public float a;
    public float b;

    public r(float f, float f1) {
        this.a = f;
        this.b = f1;
    }

    @Override  // G.u
    public final float a(int v) {
        switch(v) {
            case 0: {
                return this.a;
            }
            case 1: {
                return this.b;
            }
            default: {
                return 0.0f;
            }
        }
    }

    @Override  // G.u
    public final int b() {
        return 2;
    }

    @Override  // G.u
    public final u c() {
        return new r(0.0f, 0.0f);
    }

    @Override  // G.u
    public final void d() {
        this.a = 0.0f;
        this.b = 0.0f;
    }

    @Override  // G.u
    public final void e(float f, int v) {
        switch(v) {
            case 0: {
                this.a = f;
                return;
            }
            case 1: {
                this.b = f;
            }
        }
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof r && ((r)object0).a == this.a && ((r)object0).b == this.b;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.b) + Float.hashCode(this.a) * 0x1F;
    }

    @Override
    public final String toString() {
        return "AnimationVector2D: v1 = " + this.a + ", v2 = " + this.b;
    }
}

