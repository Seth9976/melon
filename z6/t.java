package z6;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;

public final class t extends v {
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public float f;
    public float g;
    public static final RectF h;

    static {
        t.h = new RectF();
    }

    public t(float f, float f1, float f2, float f3) {
        this.b = f;
        this.c = f1;
        this.d = f2;
        this.e = f3;
    }

    @Override  // z6.v
    public final void a(Matrix matrix0, Path path0) {
        matrix0.invert(this.a);
        path0.transform(this.a);
        t.h.set(this.b, this.c, this.d, this.e);
        path0.arcTo(t.h, this.f, this.g, false);
        path0.transform(matrix0);
    }
}

