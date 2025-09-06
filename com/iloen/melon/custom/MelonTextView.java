package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.iloen.melon.utils.ui.ViewUtils;
import java.lang.ref.WeakReference;
import k8.t1;

public class MelonTextView extends AppCompatTextView {
    public WeakReference h;

    public MelonTextView(Context context0) {
        super(context0);
        this.g(context0, null);
    }

    public MelonTextView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.g(context0, attributeSet0);
    }

    public MelonTextView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.g(context0, attributeSet0);
    }

    public final void g(Context context0, AttributeSet attributeSet0) {
        if(this.isInEditMode()) {
            return;
        }
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.u, 0, 0);
        int v = typedArray0.getInt(0, 0);
        try {
            ViewUtils.setTypeface(this, v, false);
            ViewUtils.setFallbackLineSpacing(this, false);
        }
        finally {
            typedArray0.recycle();
        }
    }

    public p0 getOnLayoutListener() {
        if(this.h != null && this.h.get() != null) {
            throw new ClassCastException();
        }
        return null;
    }

    @Override  // androidx.appcompat.widget.AppCompatTextView
    public void onLayout(boolean z, int v, int v1, int v2, int v3) {
        if(this.h != null && this.h.get() != null) {
            throw new ClassCastException();
        }
        super.onLayout(z, v, v1, v2, v3);
        if(this.h != null && this.h.get() != null) {
            throw new ClassCastException();
        }
    }

    public void setOnLayoutListener(p0 p00) {
        this.h = new WeakReference(p00);
    }
}

