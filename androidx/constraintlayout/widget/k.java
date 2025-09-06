package androidx.constraintlayout.widget;

import A1.e;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;

public final class k {
    public boolean a;
    public int b;
    public int c;
    public String d;
    public int e;
    public int f;
    public float g;
    public float h;
    public float i;
    public int j;
    public String k;
    public int l;
    public int m;
    public static final SparseIntArray n;

    static {
        SparseIntArray sparseIntArray0 = new SparseIntArray();
        k.n = sparseIntArray0;
        sparseIntArray0.append(3, 1);
        sparseIntArray0.append(5, 2);
        sparseIntArray0.append(9, 3);
        sparseIntArray0.append(2, 4);
        sparseIntArray0.append(1, 5);
        sparseIntArray0.append(0, 6);
        sparseIntArray0.append(4, 7);
        sparseIntArray0.append(8, 8);
        sparseIntArray0.append(7, 9);
        sparseIntArray0.append(6, 10);
    }

    public final void a(k k0) {
        this.a = k0.a;
        this.b = k0.b;
        this.d = k0.d;
        this.e = k0.e;
        this.f = k0.f;
        this.h = k0.h;
        this.g = k0.g;
    }

    public final void b(Context context0, AttributeSet attributeSet0) {
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, q.r);
        this.a = true;
        int v = typedArray0.getIndexCount();
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = typedArray0.getIndex(v1);
            switch(k.n.get(v2)) {
                case 1: {
                    this.h = typedArray0.getFloat(v2, this.h);
                    break;
                }
                case 2: {
                    this.e = typedArray0.getInt(v2, this.e);
                    break;
                }
                case 3: {
                    this.d = typedArray0.peekValue(v2).type == 3 ? typedArray0.getString(v2) : e.d[typedArray0.getInteger(v2, 0)];
                    break;
                }
                case 4: {
                    this.f = typedArray0.getInt(v2, 0);
                    break;
                }
                case 5: {
                    this.b = n.p(typedArray0, v2, this.b);
                    break;
                }
                case 6: {
                    this.c = typedArray0.getInteger(v2, this.c);
                    break;
                }
                case 7: {
                    this.g = typedArray0.getFloat(v2, this.g);
                    break;
                }
                case 8: {
                    this.j = typedArray0.getInteger(v2, this.j);
                    break;
                }
                case 9: {
                    this.i = typedArray0.getFloat(v2, this.i);
                    break;
                }
                case 10: {
                    int v3 = typedArray0.peekValue(v2).type;
                    if(v3 == 1) {
                        int v4 = typedArray0.getResourceId(v2, -1);
                        this.m = v4;
                        if(v4 != -1) {
                            this.l = -2;
                        }
                    }
                    else if(v3 == 3) {
                        String s = typedArray0.getString(v2);
                        this.k = s;
                        if(s.indexOf("/") > 0) {
                            this.m = typedArray0.getResourceId(v2, -1);
                            this.l = -2;
                        }
                        else {
                            this.l = -1;
                        }
                    }
                    else {
                        this.l = typedArray0.getInteger(v2, this.m);
                    }
                }
            }
        }
        typedArray0.recycle();
    }
}

