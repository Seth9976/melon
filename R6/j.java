package r6;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

public final class j implements TypeEvaluator {
    public final float[] a;
    public final float[] b;
    public final Matrix c;
    public final o d;

    public j(o o0) {
        this.d = o0;
        this.a = new float[9];
        this.b = new float[9];
        this.c = new Matrix();
    }

    @Override  // android.animation.TypeEvaluator
    public final Object evaluate(float f, Object object0, Object object1) {
        this.d.p = f;
        float[] arr_f = this.a;
        ((Matrix)object0).getValues(arr_f);
        float[] arr_f1 = this.b;
        ((Matrix)object1).getValues(arr_f1);
        for(int v = 0; v < 9; ++v) {
            float f1 = arr_f1[v];
            float f2 = arr_f[v];
            arr_f1[v] = (f1 - f2) * f + f2;
        }
        this.c.setValues(arr_f1);
        return this.c;
    }
}

