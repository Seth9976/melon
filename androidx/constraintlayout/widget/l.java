package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public final class l {
    public boolean a;
    public int b;
    public int c;
    public float d;
    public float e;

    public final void a(Context context0, AttributeSet attributeSet0) {
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, q.A);
        this.a = true;
        int v = typedArray0.getIndexCount();
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = typedArray0.getIndex(v1);
            if(v2 == 1) {
                this.d = typedArray0.getFloat(1, this.d);
            }
            else if(v2 == 0) {
                this.b = n.h[typedArray0.getInt(0, this.b)];
            }
            else {
                switch(v2) {
                    case 3: {
                        this.e = typedArray0.getFloat(3, this.e);
                        break;
                    }
                    case 4: {
                        this.c = typedArray0.getInt(4, this.c);
                    }
                }
            }
        }
        typedArray0.recycle();
    }
}

