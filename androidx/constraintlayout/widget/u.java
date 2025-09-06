package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;

public final class u {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final int e;

    public u(Context context0, XmlResourceParser xmlResourceParser0) {
        this.a = NaNf;
        this.b = NaNf;
        this.c = NaNf;
        this.d = NaNf;
        this.e = -1;
        TypedArray typedArray0 = context0.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser0), q.F);
        int v = typedArray0.getIndexCount();
        for(int v1 = 0; v1 < v; ++v1) {
            switch(typedArray0.getIndex(v1)) {
                case 0: {
                    int v2 = typedArray0.getResourceId(0, this.e);
                    this.e = v2;
                    String s = context0.getResources().getResourceTypeName(v2);
                    context0.getResources().getResourceName(v2);
                    "layout".equals(s);
                    break;
                }
                case 1: {
                    this.d = typedArray0.getDimension(1, this.d);
                    break;
                }
                case 2: {
                    this.b = typedArray0.getDimension(2, this.b);
                    break;
                }
                case 3: {
                    this.c = typedArray0.getDimension(3, this.c);
                    break;
                }
                case 4: {
                    this.a = typedArray0.getDimension(4, this.a);
                    break;
                }
                default: {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
        }
        typedArray0.recycle();
    }

    public final boolean a(float f, float f1) {
        if(!Float.isNaN(this.a) && f < this.a) {
            return false;
        }
        if(!Float.isNaN(this.b) && f1 < this.b) {
            return false;
        }
        return Float.isNaN(this.c) || f <= this.c ? Float.isNaN(this.d) || f1 <= this.d : false;
    }
}

