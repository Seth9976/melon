package com.iloen.melon.custom.tablayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup;

public class TagLayout extends ViewGroup {
    public int a;
    public int b;

    public TagLayout(Context context0) {
        super(context0);
        this.a = 0;
        this.b = 0;
    }

    public TagLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = 0;
        this.b = 0;
    }

    public int getHorizontalSpace() {
        return this.a;
    }

    public int getVerticalSpace() {
        return this.b;
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v4 = this.getChildCount();
        int v5 = this.getPaddingLeft();
        int v6 = this.getPaddingTop();
        for(int v7 = 0; v7 < v4; ++v7) {
            View view0 = this.getChildAt(v7);
            if(view0.getVisibility() != 8) {
                int v8 = view0.getMeasuredWidth();
                int v9 = view0.getMeasuredHeight();
                if(v5 + v8 > v2 - v) {
                    v5 = this.getPaddingLeft();
                    v6 = v6 + v9 + this.getVerticalSpace();
                }
                view0.layout(v5, v6, v5 + v8, v9 + v6);
                v5 = this.getHorizontalSpace() + v8 + v5;
            }
        }
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        int v2 = View.MeasureSpec.getMode(v);
        int v3 = View.MeasureSpec.getMode(v1);
        int v4 = View.MeasureSpec.getSize(v);
        int v5 = View.MeasureSpec.getSize(v1);
        if(v2 != 0x40000000) {
            throw new IllegalStateException("width must be an exact value or MATCH_PARENT");
        }
        int v6 = v4 - this.getPaddingLeft() - this.getPaddingRight();
        int v7 = this.getPaddingTop();
        int v8 = this.getPaddingBottom();
        int v9 = this.getChildCount();
        int v10 = this.getPaddingLeft();
        int v12 = 0;
        int v13 = 0;
        for(int v11 = 0; v11 < v9; ++v11) {
            View view0 = this.getChildAt(v11);
            if(view0.getVisibility() != 8) {
                this.measureChild(view0, View.MeasureSpec.makeMeasureSpec(v6, 0x80000000), v5 - v7 - v8);
                int v14 = view0.getMeasuredWidth();
                int v15 = view0.getMeasuredHeight();
                if(v10 + v14 > v6) {
                    v10 = this.getPaddingLeft();
                    v12 = v12 + v15 + this.getVerticalSpace();
                }
                v13 = v15;
                v10 = this.getHorizontalSpace() + v14 + v10;
            }
        }
        if(v9 == 0) {
            this.setMeasuredDimension(0, 0);
            return;
        }
        if(v3 != 0x80000000 && v3 != 0) {
            this.setMeasuredDimension(v4, v5);
            return;
        }
        int v16 = this.getPaddingTop();
        this.setMeasuredDimension(v4, this.getPaddingBottom() + (v16 + v12) + v13);
    }

    public void setHorizontalSpace(int v) {
        this.a = v;
    }

    public void setVerticalSpace(int v) {
        this.b = v;
    }
}

