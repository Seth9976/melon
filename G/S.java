package G;

import A7.d;

public final class s extends u {
    public float a;
    public float b;
    public float c;

    public s(float f, float f1, float f2) {
        this.a = f;
        this.b = f1;
        this.c = f2;
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
            case 2: {
                return this.c;
            }
            default: {
                return 0.0f;
            }
        }
    }

    @Override  // G.u
    public final int b() {
        return 3;
    }

    @Override  // G.u
    public final u c() {
        return new s(0.0f, 0.0f, 0.0f);
    }

    @Override  // G.u
    public final void d() {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
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
                return;
            }
            case 2: {
                this.c = f;
            }
        }
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof s && ((s)object0).a == this.a && ((s)object0).b == this.b && ((s)object0).c == this.c;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.c) + d.a(this.b, Float.hashCode(this.a) * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        return "AnimationVector3D: v1 = " + this.a + ", v2 = " + this.b + ", v3 = " + this.c;
    }
}

