package G;

import A7.d;

public final class t extends u {
    public float a;
    public float b;
    public float c;
    public float d;

    public t(float f, float f1, float f2, float f3) {
        this.a = f;
        this.b = f1;
        this.c = f2;
        this.d = f3;
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
            case 3: {
                return this.d;
            }
            default: {
                return 0.0f;
            }
        }
    }

    @Override  // G.u
    public final int b() {
        return 4;
    }

    @Override  // G.u
    public final u c() {
        return new t(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override  // G.u
    public final void d() {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
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
                return;
            }
            case 3: {
                this.d = f;
            }
        }
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof t && ((t)object0).a == this.a && ((t)object0).b == this.b && ((t)object0).c == this.c && ((t)object0).d == this.d;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.d) + d.a(this.c, d.a(this.b, Float.hashCode(this.a) * 0x1F, 0x1F), 0x1F);
    }

    @Override
    public final String toString() {
        return "AnimationVector4D: v1 = " + this.a + ", v2 = " + this.b + ", v3 = " + this.c + ", v4 = " + this.d;
    }
}

