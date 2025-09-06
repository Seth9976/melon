package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;

public final class m {
    public boolean a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public int i;
    public float j;
    public float k;
    public float l;
    public boolean m;
    public float n;
    public static final SparseIntArray o;

    static {
        SparseIntArray sparseIntArray0 = new SparseIntArray();
        m.o = sparseIntArray0;
        sparseIntArray0.append(6, 1);
        sparseIntArray0.append(7, 2);
        sparseIntArray0.append(8, 3);
        sparseIntArray0.append(4, 4);
        sparseIntArray0.append(5, 5);
        sparseIntArray0.append(0, 6);
        sparseIntArray0.append(1, 7);
        sparseIntArray0.append(2, 8);
        sparseIntArray0.append(3, 9);
        sparseIntArray0.append(9, 10);
        sparseIntArray0.append(10, 11);
        sparseIntArray0.append(11, 12);
    }

    public final void a(m m0) {
        this.a = m0.a;
        this.b = m0.b;
        this.c = m0.c;
        this.d = m0.d;
        this.e = m0.e;
        this.f = m0.f;
        this.g = m0.g;
        this.h = m0.h;
        this.i = m0.i;
        this.j = m0.j;
        this.k = m0.k;
        this.l = m0.l;
        this.m = m0.m;
        this.n = m0.n;
    }

    public final void b(Context context0, AttributeSet attributeSet0) {
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, q.D);
        this.a = true;
        int v = typedArray0.getIndexCount();
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = typedArray0.getIndex(v1);
            switch(m.o.get(v2)) {
                case 1: {
                    this.b = typedArray0.getFloat(v2, this.b);
                    break;
                }
                case 2: {
                    this.c = typedArray0.getFloat(v2, this.c);
                    break;
                }
                case 3: {
                    this.d = typedArray0.getFloat(v2, this.d);
                    break;
                }
                case 4: {
                    this.e = typedArray0.getFloat(v2, this.e);
                    break;
                }
                case 5: {
                    this.f = typedArray0.getFloat(v2, this.f);
                    break;
                }
                case 6: {
                    this.g = typedArray0.getDimension(v2, this.g);
                    break;
                }
                case 7: {
                    this.h = typedArray0.getDimension(v2, this.h);
                    break;
                }
                case 8: {
                    this.j = typedArray0.getDimension(v2, this.j);
                    break;
                }
                case 9: {
                    this.k = typedArray0.getDimension(v2, this.k);
                    break;
                }
                case 10: {
                    this.l = typedArray0.getDimension(v2, this.l);
                    break;
                }
                case 11: {
                    this.m = true;
                    this.n = typedArray0.getDimension(v2, this.n);
                    break;
                }
                case 12: {
                    this.i = n.p(typedArray0, v2, this.i);
                }
            }
        }
        typedArray0.recycle();
    }
}

