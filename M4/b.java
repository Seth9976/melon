package m4;

import A1.f;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public final class b {
    public final int[] a;
    public final int[] b;
    public final ArrayList c;
    public final c[] d;
    public final float[] e;
    public static final f f;

    static {
        b.f = new f(14);
    }

    public b(int[] arr_v, int v, c[] arr_c) {
        int v18;
        this.e = new float[3];
        this.d = arr_c;
        int[] arr_v1 = new int[0x8000];
        this.b = arr_v1;
        for(int v2 = 0; v2 < arr_v.length; ++v2) {
            int v3 = arr_v[v2];
            int v4 = b.b(Color.red(v3), 8, 5);
            int v5 = b.b(Color.green(v3), 8, 5);
            int v6 = b.b(Color.blue(v3), 8, 5) | (v4 << 10 | v5 << 5);
            arr_v[v2] = v6;
            ++arr_v1[v6];
        }
        int v7 = 0;
        for(int v8 = 0; v8 < 0x8000; ++v8) {
            if(arr_v1[v8] > 0) {
                int v9 = Color.rgb(b.b(v8 >> 10 & 0x1F, 5, 8), b.b(v8 >> 5 & 0x1F, 5, 8), b.b(v8 & 0x1F, 5, 8));
                S1.c.b(Color.red(v9), Color.green(v9), Color.blue(v9), this.e);
                if(this.c(this.e)) {
                    arr_v1[v8] = 0;
                }
            }
            if(arr_v1[v8] > 0) {
                ++v7;
            }
        }
        int[] arr_v2 = new int[v7];
        this.a = arr_v2;
        int v10 = 0;
        for(int v11 = 0; v11 < 0x8000; ++v11) {
            if(arr_v1[v11] > 0) {
                arr_v2[v10] = v11;
                ++v10;
            }
        }
        if(v7 <= v) {
            this.c = new ArrayList();
            for(int v1 = 0; v1 < v7; ++v1) {
                int v12 = arr_v2[v1];
                g g0 = new g(Color.rgb(b.b(v12 >> 10 & 0x1F, 5, 8), b.b(v12 >> 5 & 0x1F, 5, 8), b.b(v12 & 0x1F, 5, 8)), arr_v1[v12]);
                this.c.add(g0);
            }
            return;
        }
        PriorityQueue priorityQueue0 = new PriorityQueue(v, b.f);
        priorityQueue0.offer(new a(this, 0, this.a.length - 1));
        while(priorityQueue0.size() < v) {
            a a0 = (a)priorityQueue0.poll();
            if(a0 == null) {
                break;
            }
            int v13 = a0.b;
            int v14 = a0.a;
            if(v13 + 1 - v14 <= 1) {
                break;
            }
            b b0 = a0.j;
            if(v13 + 1 - v14 <= 1) {
                throw new IllegalStateException("Can not split a box with only 1 color");
            }
            int v15 = a0.e - a0.d;
            int v16 = a0.g - a0.f;
            int v17 = a0.i - a0.h;
            if(v15 < v16 || v15 < v17) {
                v18 = v16 < v15 || v16 < v17 ? -1 : -2;
            }
            else {
                v18 = -3;
            }
            int[] arr_v3 = b0.a;
            int[] arr_v4 = b0.b;
            b.a(v18, arr_v3, v14, v13);
            Arrays.sort(arr_v3, v14, a0.b + 1);
            b.a(v18, arr_v3, v14, a0.b);
            int v19 = a0.c / 2;
            int v20 = 0;
            for(int v21 = v14; true; ++v21) {
                int v22 = a0.b;
                if(v21 > v22) {
                    break;
                }
                v20 += arr_v4[arr_v3[v21]];
                if(v20 >= v19) {
                    v14 = Math.min(v22 - 1, v21);
                    break;
                }
            }
            a a1 = new a(b0, v14 + 1, a0.b);
            a0.b = v14;
            a0.a();
            priorityQueue0.offer(a1);
            priorityQueue0.offer(a0);
        }
        ArrayList arrayList0 = new ArrayList(priorityQueue0.size());
        for(Object object0: priorityQueue0) {
            int[] arr_v5 = ((a)object0).j.a;
            int[] arr_v6 = ((a)object0).j.b;
            int v23 = ((a)object0).a;
            int v24 = 0;
            int v25 = 0;
            int v26 = 0;
            int v27 = 0;
            while(v23 <= ((a)object0).b) {
                int v28 = arr_v5[v23];
                int v29 = arr_v6[v28];
                v25 += v29;
                v24 = (v28 >> 10 & 0x1F) * v29 + v24;
                v26 = (v28 >> 5 & 0x1F) * v29 + v26;
                v27 += v29 * (v28 & 0x1F);
                ++v23;
            }
            g g1 = new g(Color.rgb(b.b(Math.round(((float)v24) / ((float)v25)), 5, 8), b.b(Math.round(((float)v26) / ((float)v25)), 5, 8), b.b(Math.round(((float)v27) / ((float)v25)), 5, 8)), v25);
            if(!this.c(g1.b())) {
                arrayList0.add(g1);
            }
        }
        this.c = arrayList0;
    }

    public static void a(int v, int[] arr_v, int v1, int v2) {
        switch(v) {
            case -2: {
                while(v1 <= v2) {
                    int v3 = arr_v[v1];
                    arr_v[v1] = v3 & 0x1F | ((v3 >> 5 & 0x1F) << 10 | (v3 >> 10 & 0x1F) << 5);
                    ++v1;
                }
                return;
            }
            case -1: {
                break;
            }
            default: {
                return;
            }
        }
        while(v1 <= v2) {
            int v4 = arr_v[v1];
            arr_v[v1] = v4 >> 10 & 0x1F | ((v4 & 0x1F) << 10 | (v4 >> 5 & 0x1F) << 5);
            ++v1;
        }
    }

    public static int b(int v, int v1, int v2) {
        return v2 <= v1 ? v >> v1 - v2 & (1 << v2) - 1 : v << v2 - v1 & (1 << v2) - 1;
    }

    public final boolean c(float[] arr_f) {
        c[] arr_c = this.d;
        if(arr_c != null && arr_c.length > 0) {
            int v = 0;
            while(v < arr_c.length) {
                arr_c[v].getClass();
                float f = arr_f[2];
                if(Float.compare(f, 0.95f) < 0 && f > 0.05f) {
                    float f1 = arr_f[0];
                    if(f1 >= 10.0f && f1 <= 37.0f && arr_f[1] <= 0.82f) {
                        return true;
                    }
                    ++v;
                    continue;
                }
                return true;
            }
        }
        return false;
    }
}

