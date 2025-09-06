package I1;

import A1.e;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.widget.a;
import h7.u0;

public final class n extends q {
    public String k;
    public SparseArray l;
    public SparseArray m;
    public float[] n;

    @Override  // I1.q
    public final void c(float f, float f1, float f2, int v, int v1) {
        throw new RuntimeException("Wrong call for custom attribute");
    }

    @Override  // I1.q
    public final boolean d(float f, long v, e e0, View view0) {
        this.a.J(((double)f), this.n);
        float[] arr_f = this.n;
        float f1 = arr_f[arr_f.length - 2];
        float f2 = arr_f[arr_f.length - 1];
        long v1 = v - this.i;
        if(Float.isNaN(this.j)) {
            float f3 = e0.c(view0, this.k);
            this.j = f3;
            if(Float.isNaN(f3)) {
                this.j = 0.0f;
            }
        }
        float f4 = (float)((((double)v1) * 1.000000E-09 * ((double)f1) + ((double)this.j)) % 1.0);
        this.j = f4;
        this.i = v;
        float f5 = this.a(f4);
        this.h = false;
        for(int v2 = 0; true; ++v2) {
            float[] arr_f1 = this.g;
            if(v2 >= arr_f1.length) {
                break;
            }
            boolean z = this.h;
            float f6 = this.n[v2];
            this.h = z | ((double)f6) != 0.0;
            arr_f1[v2] = f6 * f5 + f2;
        }
        u0.R(((a)this.l.valueAt(0)), view0, this.g);
        if(f1 != 0.0f) {
            this.h = true;
        }
        return this.h;
    }

    @Override  // I1.q
    public final void e(int v) {
        SparseArray sparseArray0 = this.l;
        int v1 = sparseArray0.size();
        int v2 = ((a)sparseArray0.valueAt(0)).c();
        double[] arr_f = new double[v1];
        this.n = new float[v2 + 2];
        this.g = new float[v2];
        double[][] arr2_f = new double[v1][v2 + 2];
        for(int v3 = 0; v3 < v1; ++v3) {
            int v4 = sparseArray0.keyAt(v3);
            a a0 = (a)sparseArray0.valueAt(v3);
            float[] arr_f1 = (float[])this.m.valueAt(v3);
            arr_f[v3] = ((double)v4) * 0.01;
            a0.b(this.n);
            for(int v5 = 0; true; ++v5) {
                float[] arr_f2 = this.n;
                if(v5 >= arr_f2.length) {
                    break;
                }
                arr2_f[v3][v5] = (double)arr_f2[v5];
            }
            double[] arr_f3 = arr2_f[v3];
            arr_f3[v2] = (double)arr_f1[0];
            arr_f3[v2 + 1] = (double)arr_f1[1];
        }
        this.a = B.a.x(v, arr_f, arr2_f);
    }
}

