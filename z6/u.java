package z6;

import android.graphics.Matrix;
import android.graphics.Path;

public final class u extends v {
    public float b;
    public float c;

    @Override  // z6.v
    public final void a(Matrix matrix0, Path path0) {
        matrix0.invert(this.a);
        path0.transform(this.a);
        path0.lineTo(this.b, this.c);
        path0.transform(matrix0);
    }
}

