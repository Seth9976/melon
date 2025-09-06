package I1;

import B.a;
import U4.x;
import android.view.View;
import java.text.DecimalFormat;
import java.util.Arrays;

public abstract class k {
    public a a;
    public int[] b;
    public float[] c;
    public int d;
    public String e;

    public k() {
        this.b = new int[10];
        this.c = new float[10];
    }

    public final float a(float f) {
        return (float)this.a.H(((double)f));
    }

    public void b(float f, int v) {
        int[] arr_v = this.b;
        if(arr_v.length < this.d + 1) {
            this.b = Arrays.copyOf(arr_v, arr_v.length * 2);
            this.c = Arrays.copyOf(this.c, this.c.length * 2);
        }
        int v1 = this.d;
        this.b[v1] = v;
        this.c[v1] = f;
        this.d = v1 + 1;
    }

    public abstract void c(View arg1, float arg2);

    public void d(int v) {
        int v1 = this.d;
        if(v1 == 0) {
            return;
        }
        int[] arr_v = this.b;
        float[] arr_f = this.c;
        int[] arr_v1 = new int[arr_v.length + 10];
        arr_v1[0] = v1 - 1;
        arr_v1[1] = 0;
        int v2 = 2;
        while(v2 > 0) {
            int v3 = arr_v1[v2 - 1];
            int v4 = arr_v1[v2 - 2];
            if(v3 < v4) {
                int v5 = arr_v[v4];
                int v6 = v3;
                int v7 = v6;
                while(v6 < v4) {
                    int v8 = arr_v[v6];
                    if(v8 <= v5) {
                        int v9 = arr_v[v7];
                        arr_v[v7] = v8;
                        arr_v[v6] = v9;
                        float f = arr_f[v7];
                        arr_f[v7] = arr_f[v6];
                        arr_f[v6] = f;
                        ++v7;
                    }
                    ++v6;
                }
                int v10 = arr_v[v7];
                arr_v[v7] = arr_v[v4];
                arr_v[v4] = v10;
                float f1 = arr_f[v7];
                arr_f[v7] = arr_f[v4];
                arr_f[v4] = f1;
                arr_v1[v2 - 2] = v7 - 1;
                arr_v1[v2 - 1] = v3;
                int v11 = v2 + 1;
                arr_v1[v2] = v4;
                v2 += 2;
                arr_v1[v11] = v7 + 1;
            }
            else {
                v2 -= 2;
            }
        }
        int v13 = 1;
        for(int v12 = 1; v12 < this.d; ++v12) {
            if(this.b[v12 - 1] != this.b[v12]) {
                ++v13;
            }
        }
        double[] arr_f1 = new double[v13];
        double[][] arr2_f = new double[v13][1];
        int v15 = 0;
        for(int v14 = 0; v14 < this.d; ++v14) {
            if(v14 <= 0 || this.b[v14] != this.b[v14 - 1]) {
                arr_f1[v15] = ((double)this.b[v14]) * 0.01;
                arr2_f[v15][0] = (double)this.c[v14];
                ++v15;
            }
        }
        this.a = a.x(v, arr_f1, arr2_f);
    }

    @Override
    public final String toString() {
        String s = this.e;
        DecimalFormat decimalFormat0 = new DecimalFormat("##.##");
        for(int v = 0; v < this.d; ++v) {
            StringBuilder stringBuilder0 = x.p(s, "[");
            stringBuilder0.append(this.b[v]);
            stringBuilder0.append(" , ");
            stringBuilder0.append(decimalFormat0.format(((double)this.c[v])));
            stringBuilder0.append("] ");
            s = stringBuilder0.toString();
        }
        return s;
    }
}

