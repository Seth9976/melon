package z6;

import android.graphics.Canvas;
import android.graphics.Matrix;
import y6.a;

public abstract class w {
    public final Matrix a;
    public static final Matrix b;

    static {
        w.b = new Matrix();
    }

    public w() {
        this.a = new Matrix();
    }

    public abstract void a(Matrix arg1, a arg2, int arg3, Canvas arg4);
}

