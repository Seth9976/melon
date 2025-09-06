package com.iloen.melon.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;

public class FlowLayout extends ViewGroup {
    public int a;
    public boolean b;
    public int c;

    public FlowLayout(Context context0) {
        super(context0);
        this.b = true;
    }

    public FlowLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.b = true;
    }

    @Override  // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof M;
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new M(1, 1);
    }

    public int getRowCount() {
        return this.c;
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v4 = this.getChildCount();
        int v5 = this.getPaddingLeft();
        int v6 = this.getPaddingTop();
        this.c = v4 > 0 ? 1 : 0;
        for(int v7 = 0; v7 < v4; ++v7) {
            View view0 = this.getChildAt(v7);
            if(view0.getVisibility() != 8) {
                int v8 = view0.getMeasuredWidth();
                int v9 = view0.getMeasuredHeight();
                M m0 = (M)view0.getLayoutParams();
                if(v5 + v8 > v2 - v) {
                    v5 = this.getPaddingLeft();
                    v6 += this.a;
                    ++this.c;
                }
                view0.layout(v5, v6, v5 + v8, v9 + v6);
                v5 = v8 + m0.a + v5;
            }
        }
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        int v2 = View.MeasureSpec.getSize(v) - this.getPaddingLeft() - this.getPaddingRight();
        int v3 = View.MeasureSpec.getSize(v1) - this.getPaddingTop() - this.getPaddingBottom();
        int v4 = View.MeasureSpec.getSize(v1);
        int v5 = this.getPaddingTop();
        int v6 = this.getChildCount();
        int v7 = this.getPaddingLeft();
        int v8 = this.getPaddingTop();
        int v10 = View.MeasureSpec.getMode(v1) == 0x80000000 ? View.MeasureSpec.makeMeasureSpec(v3, 0x80000000) : 0;
        int v11 = 0;
        for(int v9 = 0; v9 < v6; ++v9) {
            View view0 = this.getChildAt(v9);
            if(view0.getVisibility() != 8) {
                M m0 = (M)view0.getLayoutParams();
                if(this.b || v9 < v6 - 1) {
                    view0.measure(View.MeasureSpec.makeMeasureSpec(v2, 0x80000000), v10);
                }
                else {
                    view0.measure(View.MeasureSpec.makeMeasureSpec(v2, 0x80000000), v4 - v5);
                }
                int v12 = view0.getMeasuredWidth();
                v11 = Math.max(v11, (v9 >= v6 - 1 ? view0.getMeasuredHeight() : view0.getMeasuredHeight() + m0.b));
                if(v7 + v12 > v2) {
                    v7 = this.getPaddingLeft();
                    v8 += v11;
                }
                v7 = v12 + m0.a + v7;
            }
        }
        this.a = v11;
        if(View.MeasureSpec.getMode(v1) == 0) {
            v3 = v8 + v11;
        }
        else if(View.MeasureSpec.getMode(v1) == 0x80000000) {
            int v13 = v8 + v11;
            if(v13 < v3) {
                v3 = v13;
            }
        }
        this.setMeasuredDimension(v2, v3);
    }

    public void setBottomEmptyArea(boolean z) {
        this.b = z;
    }
}

