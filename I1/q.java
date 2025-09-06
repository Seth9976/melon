package I1;

import A1.e;
import B.a;
import U4.x;
import android.view.View;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;

public abstract class q {
    public a a;
    public int b;
    public int[] c;
    public float[][] d;
    public int e;
    public String f;
    public float[] g;
    public boolean h;
    public long i;
    public float j;

    public q() {
        this.b = 0;
        this.c = new int[10];
        this.d = new float[10][3];
        this.g = new float[3];
        this.h = false;
        this.j = NaNf;
    }

    public final float a(float f) {
        switch(this.b) {
            case 1: {
                return Math.signum(f * 6.283185f);
            }
            case 2: {
                return 1.0f - Math.abs(f);
            }
            case 3: {
                return (f * 2.0f + 1.0f) % 2.0f - 1.0f;
            }
            case 4: {
                return 1.0f - (f * 2.0f + 1.0f) % 2.0f;
            }
            case 5: {
                return (float)Math.cos(f * 6.283185f);
            }
            case 6: {
                float f1 = Math.abs(f * 4.0f % 4.0f - 2.0f);
                return 1.0f - (1.0f - f1) * (1.0f - f1);
            }
            default: {
                return (float)Math.sin(f * 6.283185f);
            }
        }
    }

    public final float b(float f, long v, e e0, View view0) {
        this.a.J(((double)f), this.g);
        float[] arr_f = this.g;
        boolean z = true;
        float f1 = arr_f[1];
        int v1 = Float.compare(f1, 0.0f);
        if(v1 == 0) {
            this.h = false;
            return arr_f[2];
        }
        if(Float.isNaN(this.j)) {
            float f2 = e0.c(view0, this.f);
            this.j = f2;
            if(Float.isNaN(f2)) {
                this.j = 0.0f;
            }
        }
        float f3 = (float)((((double)(v - this.i)) * 1.000000E-09 * ((double)f1) + ((double)this.j)) % 1.0);
        this.j = f3;
        String s = this.f;
        HashMap hashMap0 = (HashMap)e0.b;
        if(hashMap0.containsKey(view0)) {
            HashMap hashMap2 = (HashMap)hashMap0.get(view0);
            if(hashMap2 == null) {
                hashMap2 = new HashMap();
            }
            if(hashMap2.containsKey(s)) {
                float[] arr_f1 = (float[])hashMap2.get(s);
                if(arr_f1 == null) {
                    arr_f1 = new float[0];
                }
                if(arr_f1.length <= 0) {
                    arr_f1 = Arrays.copyOf(arr_f1, 1);
                }
                arr_f1[0] = f3;
                hashMap2.put(s, arr_f1);
            }
            else {
                hashMap2.put(s, new float[]{f3});
                hashMap0.put(view0, hashMap2);
            }
        }
        else {
            HashMap hashMap1 = new HashMap();
            hashMap1.put(s, new float[]{f3});
            hashMap0.put(view0, hashMap1);
        }
        this.i = v;
        float f4 = this.g[0];
        float f5 = this.a(this.j) * f4 + this.g[2];
        if(f4 == 0.0f && v1 == 0) {
            z = false;
        }
        this.h = z;
        return f5;
    }

    public void c(float f, float f1, float f2, int v, int v1) {
        int v2 = this.e;
        this.c[v2] = v;
        float[] arr_f = this.d[v2];
        arr_f[0] = f;
        arr_f[1] = f1;
        arr_f[2] = f2;
        this.b = Math.max(this.b, v1);
        ++this.e;
    }

    public abstract boolean d(float arg1, long arg2, e arg3, View arg4);

    public void e(int v) {
        float[][] arr2_f;
        int v1 = this.e;
        if(v1 == 0) {
            System.err.println("Error no points added to " + this.f);
            return;
        }
        int[] arr_v = this.c;
        int[] arr_v1 = new int[arr_v.length + 10];
        arr_v1[0] = v1 - 1;
        arr_v1[1] = 0;
        int v2 = 2;
        while(true) {
            arr2_f = this.d;
            if(v2 <= 0) {
                break;
            }
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
                        float[] arr_f = arr2_f[v7];
                        arr2_f[v7] = arr2_f[v6];
                        arr2_f[v6] = arr_f;
                        ++v7;
                    }
                    ++v6;
                }
                int v10 = arr_v[v7];
                arr_v[v7] = arr_v[v4];
                arr_v[v4] = v10;
                float[] arr_f1 = arr2_f[v7];
                arr2_f[v7] = arr2_f[v4];
                arr2_f[v4] = arr_f1;
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
        int v13 = 0;
        for(int v12 = 1; v12 < arr_v.length; ++v12) {
            if(arr_v[v12] != arr_v[v12 - 1]) {
                ++v13;
            }
        }
        if(v13 == 0) {
            v13 = 1;
        }
        double[] arr_f2 = new double[v13];
        double[][] arr2_f1 = new double[v13][3];
        int v15 = 0;
        for(int v14 = 0; v14 < this.e; ++v14) {
            if(v14 <= 0 || arr_v[v14] != arr_v[v14 - 1]) {
                arr_f2[v15] = ((double)arr_v[v14]) * 0.01;
                double[] arr_f3 = arr2_f1[v15];
                float[] arr_f4 = arr2_f[v14];
                arr_f3[0] = (double)arr_f4[0];
                arr_f3[1] = (double)arr_f4[1];
                arr_f3[2] = (double)arr_f4[2];
                ++v15;
            }
        }
        this.a = a.x(v, arr_f2, arr2_f1);
    }

    @Override
    public final String toString() {
        String s = this.f;
        DecimalFormat decimalFormat0 = new DecimalFormat("##.##");
        for(int v = 0; v < this.e; ++v) {
            StringBuilder stringBuilder0 = x.p(s, "[");
            stringBuilder0.append(this.c[v]);
            stringBuilder0.append(" , ");
            stringBuilder0.append(decimalFormat0.format(this.d[v]));
            stringBuilder0.append("] ");
            s = stringBuilder0.toString();
        }
        return s;
    }
}

