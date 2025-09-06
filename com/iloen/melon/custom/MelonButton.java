package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.iloen.melon.utils.ui.ViewUtils;
import java.lang.ref.WeakReference;
import k8.t1;

public class MelonButton extends AppCompatButton {
    public WeakReference d;

    public MelonButton(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        if(this.isInEditMode()) {
            return;
        }
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.u, 0, 0);
        int v = typedArray0.getInt(0, 0);
        typedArray0.recycle();
        ViewUtils.setTypeface(this, v);
    }

    public i0 getOnLayoutListener() {
        if(this.d != null && this.d.get() != null) {
            throw new ClassCastException();
        }
        return null;
    }

    @Override  // androidx.appcompat.widget.AppCompatButton
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        if(this.d != null && this.d.get() != null) {
            throw new ClassCastException();
        }
        super.onLayout(z, v, v1, v2, v3);
    }

    public void setOnLayoutListener(i0 i00) {
        this.d = new WeakReference(i00);
    }
}

