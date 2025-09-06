package N4;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.transition.Transition;

public final class o extends L {
    @Override  // N4.L
    public final long f(ViewGroup viewGroup0, Transition transition0, b0 b00, b0 b01) {
        int v5;
        int v4;
        int v1;
        int v;
        if(b00 == null && b01 == null) {
            return 0L;
        }
        if(b01 == null) {
            v1 = -1;
        }
        else {
            if(b00 == null) {
                v = 8;
            }
            else {
                Integer integer0 = (Integer)b00.a.get("android:visibilityPropagation:visibility");
                v = integer0 == null ? 8 : ((int)integer0);
            }
            if(v == 0) {
                v1 = -1;
            }
            else {
                b00 = b01;
                v1 = 1;
            }
        }
        int v2 = L.h(b00, 0);
        int v3 = L.h(b00, 1);
        Rect rect0 = transition0.M == null ? null : transition0.M.i();
        if(rect0 == null) {
            int[] arr_v = new int[2];
            viewGroup0.getLocationOnScreen(arr_v);
            int v6 = arr_v[0];
            int v7 = viewGroup0.getWidth();
            int v8 = Math.round(viewGroup0.getTranslationX() + ((float)(v7 / 2 + v6)));
            int v9 = arr_v[1];
            int v10 = viewGroup0.getHeight();
            v5 = Math.round(viewGroup0.getTranslationY() + ((float)(v10 / 2 + v9)));
            v4 = v8;
        }
        else {
            v4 = rect0.centerX();
            v5 = rect0.centerY();
        }
        float f = ((float)v4) - ((float)v2);
        float f1 = ((float)v5) - ((float)v3);
        float f2 = (float)viewGroup0.getWidth();
        float f3 = ((float)viewGroup0.getHeight()) - 0.0f;
        return (long)Math.round(((float)((transition0.c >= 0L ? transition0.c : 300L) * ((long)v1))) / 3.0f * (((float)Math.sqrt(f1 * f1 + f * f)) / ((float)Math.sqrt(f3 * f3 + (f2 - 0.0f) * (f2 - 0.0f)))));
    }
}

