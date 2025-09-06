package com.google.android.material.snackbar;

import B6.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public final class Snackbar.SnackbarLayout extends c {
    public Snackbar.SnackbarLayout(Context context0) {
        super(context0, null);
    }

    public Snackbar.SnackbarLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    @Override  // B6.c
    public final void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        int v2 = this.getChildCount();
        int v3 = this.getMeasuredWidth();
        int v4 = this.getPaddingLeft();
        int v5 = this.getPaddingRight();
        for(int v6 = 0; v6 < v2; ++v6) {
            View view0 = this.getChildAt(v6);
            if(view0.getLayoutParams().width == -1) {
                view0.measure(View.MeasureSpec.makeMeasureSpec(v3 - v4 - v5, 0x40000000), View.MeasureSpec.makeMeasureSpec(view0.getMeasuredHeight(), 0x40000000));
            }
        }
    }

    @Override  // B6.c
    public void setBackground(Drawable drawable0) {
        super.setBackground(drawable0);
    }

    @Override  // B6.c
    public void setBackgroundDrawable(Drawable drawable0) {
        super.setBackgroundDrawable(drawable0);
    }

    @Override  // B6.c
    public void setBackgroundTintList(ColorStateList colorStateList0) {
        super.setBackgroundTintList(colorStateList0);
    }

    @Override  // B6.c
    public void setBackgroundTintMode(PorterDuff.Mode porterDuff$Mode0) {
        super.setBackgroundTintMode(porterDuff$Mode0);
    }

    @Override  // B6.c
    public void setLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        super.setLayoutParams(viewGroup$LayoutParams0);
    }

    @Override  // B6.c
    public void setOnClickListener(View.OnClickListener view$OnClickListener0) {
        super.setOnClickListener(view$OnClickListener0);
    }
}

