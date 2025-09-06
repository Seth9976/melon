package v6;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.internal.B;
import d6.a;
import e1.n;

public abstract class e {
    public int a;
    public int b;
    public int[] c;
    public int d;
    public int e;
    public int f;
    public int g;

    public e(Context context0, AttributeSet attributeSet0, int v, int v1) {
        this.c = new int[0];
        int v2 = context0.getResources().getDimensionPixelSize(0x7F0703C2);  // dimen:mtrl_progress_track_thickness
        B.c(context0, attributeSet0, v, v1);
        B.d(context0, attributeSet0, a.d, v, v1, new int[0]);
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, a.d, v, v1);
        this.a = n.t(context0, typedArray0, 9, v2);
        this.b = Math.min(n.t(context0, typedArray0, 8, 0), this.a / 2);
        this.e = typedArray0.getInt(5, 0);
        this.f = typedArray0.getInt(1, 0);
        this.g = typedArray0.getDimensionPixelSize(3, 0);
        if(typedArray0.hasValue(2)) {
            if(typedArray0.peekValue(2).type != 1) {
                this.c = new int[]{typedArray0.getColor(2, -1)};
                goto label_20;
            }
            int[] arr_v = context0.getResources().getIntArray(typedArray0.getResourceId(2, -1));
            this.c = arr_v;
            if(arr_v.length == 0) {
                throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
            }
        }
        else {
            this.c = new int[]{n.o(context0, 0x7F040182, -1)};  // attr:colorPrimary
        }
    label_20:
        if(typedArray0.hasValue(7)) {
            this.d = typedArray0.getColor(7, -1);
        }
        else {
            this.d = this.c[0];
            TypedArray typedArray1 = context0.getTheme().obtainStyledAttributes(new int[]{0x1010033});
            float f = typedArray1.getFloat(0, 0.2f);
            typedArray1.recycle();
            this.d = n.l(this.d, ((int)(f * 255.0f)));
        }
        typedArray0.recycle();
    }

    public void a() {
        if(this.g < 0) {
            throw new IllegalArgumentException("indicatorTrackGapSize must be >= 0.");
        }
    }
}

