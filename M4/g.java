package m4;

import S1.c;
import android.graphics.Color;
import java.util.Arrays;

public final class g {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public boolean f;
    public int g;
    public int h;
    public float[] i;

    public g(int v, int v1) {
        this.a = Color.red(v);
        this.b = Color.green(v);
        this.c = Color.blue(v);
        this.d = v;
        this.e = v1;
    }

    public final void a() {
        if(!this.f) {
            int v = this.d;
            int v1 = c.g(4.5f, -1, v);
            int v2 = c.g(3.0f, -1, v);
            if(v1 != -1 && v2 != -1) {
                this.h = c.k(-1, v1);
                this.g = c.k(-1, v2);
                this.f = true;
                return;
            }
            int v3 = c.g(4.5f, 0xFF000000, v);
            int v4 = c.g(3.0f, 0xFF000000, v);
            if(v3 != -1 && v4 != -1) {
                this.h = c.k(0xFF000000, v3);
                this.g = c.k(0xFF000000, v4);
                this.f = true;
                return;
            }
            this.h = v1 == -1 ? c.k(0xFF000000, v3) : c.k(-1, v1);
            this.g = v2 == -1 ? c.k(0xFF000000, v4) : c.k(-1, v2);
            this.f = true;
        }
    }

    public final float[] b() {
        if(this.i == null) {
            this.i = new float[3];
        }
        c.b(this.a, this.b, this.c, this.i);
        return this.i;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return g.class == class0 && this.e == ((g)object0).e && this.d == ((g)object0).d;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.d * 0x1F + this.e;
    }

    @Override
    public final String toString() {
        this.a();
        this.a();
        return "g [RGB: #" + Integer.toHexString(this.d) + "] [HSL: " + Arrays.toString(this.b()) + "] [Population: " + this.e + "] [Title Text: #" + Integer.toHexString(this.g) + "] [Body Text: #" + Integer.toHexString(this.h) + ']';
    }
}

