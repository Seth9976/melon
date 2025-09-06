package x0;

import df.d;

public final class a {
    public float a;
    public float b;
    public float c;
    public float d;

    public a() {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
    }

    public final void a(float f, float f1, float f2, float f3) {
        this.a = Math.max(f, this.a);
        this.b = Math.max(f1, this.b);
        this.c = Math.min(f2, this.c);
        this.d = Math.min(f3, this.d);
    }

    public final boolean b() {
        int v = 0;
        int v1 = Float.compare(this.a, this.c) < 0 ? 0 : 1;
        if(this.b >= this.d) {
            v = 1;
        }
        return v1 | v;
    }

    @Override
    public final String toString() {
        return "MutableRect(" + d.N(this.a) + ", " + d.N(this.b) + ", " + d.N(this.c) + ", " + d.N(this.d) + ')';
    }
}

