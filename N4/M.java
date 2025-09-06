package N4;

import android.graphics.Matrix;
import android.view.View;

public final class m {
    public final Matrix a;
    public final View b;
    public final float[] c;
    public float d;
    public float e;

    public m(View view0, float[] arr_f) {
        this.a = new Matrix();
        this.b = view0;
        float[] arr_f1 = (float[])arr_f.clone();
        this.c = arr_f1;
        this.d = arr_f1[2];
        this.e = arr_f1[5];
        this.a();
    }

    public final void a() {
        this.c[2] = this.d;
        this.c[5] = this.e;
        this.a.setValues(this.c);
        e0.a.m(this.b, this.a);
    }
}

