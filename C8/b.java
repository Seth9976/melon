package C8;

public final class b {
    public final float a;
    public final float b;
    public final float c;
    public m0.b d;
    public m0.b e;
    public m0.b f;

    public b(float f, float f1, float f2) {
        this.a = f;
        this.b = f1;
        this.c = f2;
    }

    public b(float f, float f1, int v) {
        if((v & 1) != 0) {
            f = 15.0f;
        }
        if((v & 2) != 0) {
            f1 = 15.0f;
        }
        this(f, f1, 30.0f);
    }

    public final m0.b a() {
        return new m0.b(0x59CC0D7, new a(this, 0), true);
    }
}

