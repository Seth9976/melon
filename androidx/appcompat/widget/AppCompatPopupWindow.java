package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.PopupWindow;
import d5.m;
import g.a;

class AppCompatPopupWindow extends PopupWindow {
    public AppCompatPopupWindow(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a(context0, attributeSet0, v);
    }

    public final void a(Context context0, AttributeSet attributeSet0, int v) {
        m m0 = m.r(context0, attributeSet0, a.u, v);
        TypedArray typedArray0 = (TypedArray)m0.c;
        if(typedArray0.hasValue(2)) {
            this.setOverlapAnchor(typedArray0.getBoolean(2, false));
        }
        this.setBackgroundDrawable(m0.k(0));
        m0.t();
    }
}

