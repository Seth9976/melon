package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.iloen.melon.utils.system.ScreenUtils;
import k8.t1;

public class AspectRatioView extends View {
    public float a;

    public AspectRatioView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, t1.b);
        this.setAspectRatio(typedArray0.getFloat(0, 1.0f));
        typedArray0.recycle();
    }

    @Override  // android.view.View
    public int getSuggestedMinimumHeight() {
        return ScreenUtils.getScreenHeight(this.getContext());
    }

    @Override  // android.view.View
    public int getSuggestedMinimumWidth() {
        return ScreenUtils.getScreenWidth(this.getContext());
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        int v2 = this.getMeasuredWidth();
        int v3 = this.getMeasuredHeight();
        if(v2 <= 0) {
            v2 = v3;
        }
        if(v3 <= 0) {
            v3 = v2;
        }
        int v4 = v2 - this.getPaddingLeft() - this.getPaddingRight();
        int v5 = (int)(((float)(v3 - this.getPaddingTop() - this.getPaddingBottom())) * this.a);
        int v6 = (int)(((float)v4) / this.a);
        if(v4 > 0) {
            if(v4 > v5) {
                v2 = this.getPaddingLeft() + v5 + this.getPaddingRight();
            }
            else {
                v3 = this.getPaddingTop() + v6 + this.getPaddingBottom();
            }
        }
        this.setMeasuredDimension(v2, v3);
    }

    public void setAspectRatio(float f) {
        if(this.a != f) {
            this.a = f;
            this.requestLayout();
        }
    }
}

