package k6;

import java.util.ArrayList;

public final class j {
    public final float a;
    public final float b;
    public final ArrayList c;
    public k d;
    public k e;
    public int f;
    public int g;
    public float h;
    public int i;

    public j(float f, float f1) {
        this.c = new ArrayList();
        this.f = -1;
        this.g = -1;
        this.h = 0.0f;
        this.i = -1;
        this.a = f;
        this.b = f1;
    }

    public final void a(float f, float f1, float f2, boolean z, boolean z1) {
        float f3 = 0.0f;
        float f4 = f - f2 / 2.0f;
        float f5 = f2 / 2.0f + f;
        float f6 = this.b;
        if(f5 > f6) {
            f3 = Math.abs(f5 - Math.max(f5 - f2, f6));
        }
        else if(f4 < 0.0f) {
            f3 = Math.abs(f4 - Math.min(f4 + f2, 0.0f));
        }
        this.b(f, f1, f2, z, z1, f3, 0.0f, 0.0f);
    }

    public final void b(float f, float f1, float f2, boolean z, boolean z1, float f3, float f4, float f5) {
        if(f2 <= 0.0f) {
            return;
        }
        ArrayList arrayList0 = this.c;
        if(z1) {
            if(z) {
                throw new IllegalArgumentException("Anchor keylines cannot be focal.");
            }
            if(this.i != -1 && this.i != 0) {
                throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
            }
            this.i = arrayList0.size();
        }
        k k0 = new k(1.401298E-45f, f, f1, f2, z1, f3, f4, f5);
        if(z) {
            if(this.d == null) {
                this.d = k0;
                this.f = arrayList0.size();
            }
            if(this.g != -1 && arrayList0.size() - this.g > 1) {
                throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
            }
            if(f2 != this.d.d) {
                throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
            }
            this.e = k0;
            this.g = arrayList0.size();
        }
        else {
            if(this.d == null && f2 < this.h) {
                throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
            }
            if(this.e != null && f2 > this.h) {
                throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
            }
        }
        this.h = f2;
        arrayList0.add(k0);
    }

    public final void c(float f, float f1, float f2, int v, boolean z) {
        if(v > 0 && f2 > 0.0f) {
            for(int v1 = 0; v1 < v; ++v1) {
                this.a(((float)v1) * f2 + f, f1, f2, z, false);
            }
        }
    }

    public final l d() {
        float f;
        if(this.d == null) {
            throw new IllegalStateException("There must be a keyline marked as focal.");
        }
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; true; ++v) {
            ArrayList arrayList1 = this.c;
            f = this.a;
            if(v >= arrayList1.size()) {
                break;
            }
            k k0 = (k)arrayList1.get(v);
            arrayList0.add(new k(((float)v) * f + (this.d.b - ((float)this.f) * f), k0.b, k0.c, k0.d, k0.e, k0.f, k0.g, k0.h));
        }
        return new l(f, arrayList0, this.f, this.g);
    }
}

