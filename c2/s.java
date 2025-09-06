package c2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.AccessibilityDelegate;
import android.view.View;

public abstract class S {
    public static View.AccessibilityDelegate a(View view0) {
        return view0.getAccessibilityDelegate();
    }

    public static void b(View view0, Context context0, int[] arr_v, AttributeSet attributeSet0, TypedArray typedArray0, int v, int v1) {
        view0.saveAttributeDataForStyleable(context0, arr_v, attributeSet0, typedArray0, v, v1);
    }
}

