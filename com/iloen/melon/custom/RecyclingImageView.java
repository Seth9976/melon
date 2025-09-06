package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import k8.t1;

public class RecyclingImageView extends AppCompatImageView {
    private boolean mIsDetachDrawableNull;

    public RecyclingImageView(Context context0) {
        this(context0, null);
    }

    public RecyclingImageView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public RecyclingImageView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        if(this.isInEditMode()) {
            return;
        }
        TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, t1.B);
        try {
            this.mIsDetachDrawableNull = typedArray0.getBoolean(0, false);
        }
        finally {
            typedArray0.recycle();
        }
    }

    @Override  // android.widget.ImageView
    public void onDetachedFromWindow() {
        if(this.mIsDetachDrawableNull) {
            this.setImageDrawable(null);
        }
        super.onDetachedFromWindow();
    }
}

