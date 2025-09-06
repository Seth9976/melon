package m4;

import android.graphics.Bitmap;
import android.util.SparseBooleanArray;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import v2.p;
import w2.a;

public final class e {
    public int a;
    public int b;
    public int c;
    public final Object d;
    public Object e;
    public Object f;

    public e(Bitmap bitmap0) {
        ArrayList arrayList0 = new ArrayList();
        this.e = arrayList0;
        this.a = 16;
        this.b = 0x3100;
        this.c = -1;
        ArrayList arrayList1 = new ArrayList();
        this.f = arrayList1;
        if(bitmap0 == null || bitmap0.isRecycled()) {
            throw new IllegalArgumentException("Bitmap is not valid");
        }
        arrayList1.add(h.f);
        this.d = bitmap0;
        arrayList0.add(i.d);
        arrayList0.add(i.e);
        arrayList0.add(i.f);
        arrayList0.add(i.g);
        arrayList0.add(i.h);
        arrayList0.add(i.i);
    }

    public e(p p0) {
        this.a = 1;
        this.d = p0;
        this.e = p0;
    }

    public h a() {
        ArrayList arrayList2;
        SparseBooleanArray sparseBooleanArray0;
        ArrayList arrayList0 = (ArrayList)this.f;
        Bitmap bitmap0 = (Bitmap)this.d;
        if(bitmap0 == null) {
            throw new AssertionError();
        }
        int v = this.c;
        int v1 = this.b;
        double f = -1.0;
        if(v1 > 0) {
            int v2 = bitmap0.getWidth();
            int v3 = bitmap0.getHeight() * v2;
            if(v3 > v1) {
                f = Math.sqrt(((double)v1) / ((double)v3));
            }
        }
        else if(v > 0) {
            int v4 = Math.max(bitmap0.getWidth(), bitmap0.getHeight());
            if(v4 > v) {
                f = ((double)v) / ((double)v4);
            }
        }
        Bitmap bitmap1 = Double.compare(f, 0.0) > 0 ? Bitmap.createScaledBitmap(bitmap0, ((int)Math.ceil(((double)bitmap0.getWidth()) * f)), ((int)Math.ceil(((double)bitmap0.getHeight()) * f)), false) : bitmap0;
        int v5 = bitmap1.getWidth();
        int v6 = bitmap1.getHeight();
        int[] arr_v = new int[v5 * v6];
        bitmap1.getPixels(arr_v, 0, v5, 0, 0, v5, v6);
        b b0 = new b(arr_v, this.a, (arrayList0.isEmpty() ? null : ((c[])arrayList0.toArray(new c[arrayList0.size()]))));
        if(bitmap1 != bitmap0) {
            bitmap1.recycle();
        }
        ArrayList arrayList1 = (ArrayList)this.e;
        h h0 = new h(b0.c, arrayList1);
        int v7 = arrayList1.size();
        for(int v8 = 0; true; ++v8) {
            sparseBooleanArray0 = h0.d;
            if(v8 >= v7) {
                break;
            }
            i i0 = (i)arrayList1.get(v8);
            float[] arr_f = i0.c;
            float[] arr_f1 = i0.a;
            float f1 = 0.0f;
            for(int v9 = 0; v9 < arr_f.length; ++v9) {
                float f2 = arr_f[v9];
                if(f2 > 0.0f) {
                    f1 += f2;
                }
            }
            if(f1 != 0.0f) {
                int v10 = arr_f.length;
                for(int v11 = 0; v11 < v10; ++v11) {
                    float f3 = arr_f[v11];
                    if(f3 > 0.0f) {
                        arr_f[v11] = f3 / f1;
                    }
                }
            }
            List list0 = h0.a;
            int v12 = list0.size();
            int v13 = 0;
            float f4 = 0.0f;
            g g0 = null;
            while(v13 < v12) {
                g g1 = (g)list0.get(v13);
                float[] arr_f2 = g1.b();
                float f5 = arr_f2[1];
                float[] arr_f3 = i0.b;
                if(f5 < arr_f1[0] || f5 > arr_f1[2]) {
                    arrayList2 = arrayList1;
                }
                else {
                    float f6 = arr_f2[2];
                    if(f6 < arr_f3[0] || f6 > arr_f3[2] || sparseBooleanArray0.get(g1.d)) {
                        arrayList2 = arrayList1;
                    }
                    else {
                        float[] arr_f4 = g1.b();
                        arrayList2 = arrayList1;
                        float f7 = i0.c[0];
                        float f8 = Float.compare(f7, 0.0f) <= 0 ? 0.0f : (1.0f - Math.abs(arr_f4[1] - arr_f1[1])) * f7;
                        float f9 = i0.c[1];
                        float f10 = f9 > 0.0f ? (1.0f - Math.abs(arr_f4[2] - arr_f3[1])) * f9 : 0.0f;
                        float f11 = i0.c[2];
                        float f12 = f8 + f10 + (f11 > 0.0f ? ((float)g1.e) / ((float)(h0.e == null ? 1 : h0.e.e)) * f11 : 0.0f);
                        if(g0 == null || f12 > f4) {
                            g0 = g1;
                            f4 = f12;
                        }
                    }
                }
                ++v13;
                arrayList1 = arrayList2;
            }
            if(g0 != null) {
                sparseBooleanArray0.append(g0.d, true);
            }
            h0.c.put(i0, g0);
        }
        sparseBooleanArray0.clear();
        return h0;
    }

    public void b() {
        this.a = 1;
        this.e = (p)this.d;
        this.c = 0;
    }

    public boolean c() {
        a a0 = ((p)this.e).b.b();
        int v = a0.a(6);
        return v == 0 || ((ByteBuffer)a0.d).get(v + a0.a) == 0 ? this.b == 0xFE0F : true;
    }
}

