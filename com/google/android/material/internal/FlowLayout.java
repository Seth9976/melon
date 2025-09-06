package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import d6.a;

public class FlowLayout extends ViewGroup {
    public int a;
    public int b;
    public boolean c;
    public int d;

    public FlowLayout(Context context0) {
        this(context0, null);
    }

    public FlowLayout(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public FlowLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.c = false;
        TypedArray typedArray0 = context0.getTheme().obtainStyledAttributes(attributeSet0, a.u, 0, 0);
        this.a = typedArray0.getDimensionPixelSize(1, 0);
        this.b = typedArray0.getDimensionPixelSize(0, 0);
        typedArray0.recycle();
    }

    public boolean a() {
        return this.c;
    }

    public int getItemSpacing() {
        return this.b;
    }

    public int getLineSpacing() {
        return this.a;
    }

    public int getRowCount() {
        return this.d;
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v12;
        int v11;
        if(this.getChildCount() == 0) {
            this.d = 0;
            return;
        }
        this.d = 1;
        boolean z1 = this.getLayoutDirection() == 1;
        int v4 = z1 ? this.getPaddingRight() : this.getPaddingLeft();
        int v5 = z1 ? this.getPaddingLeft() : this.getPaddingRight();
        int v6 = this.getPaddingTop();
        int v7 = v2 - v - v5;
        int v9 = v4;
        int v10 = v6;
        for(int v8 = 0; v8 < this.getChildCount(); ++v8) {
            View view0 = this.getChildAt(v8);
            if(view0.getVisibility() == 8) {
                view0.setTag(0x7F0A0A17, -1);  // id:row_index_key
            }
            else {
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
                if(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams) {
                    v11 = ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).getMarginStart();
                    v12 = ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).getMarginEnd();
                }
                else {
                    v12 = 0;
                    v11 = 0;
                }
                int v13 = view0.getMeasuredWidth() + (v9 + v11);
                if(!this.c && v13 > v7) {
                    v10 = this.a + v6;
                    ++this.d;
                    v9 = v4;
                }
                view0.setTag(0x7F0A0A17, ((int)(this.d - 1)));  // id:row_index_key
                int v14 = v9 + v11;
                int v15 = view0.getMeasuredWidth() + v14;
                int v16 = view0.getMeasuredHeight() + v10;
                if(z1) {
                    view0.layout(v7 - v15, v10, v7 - v9 - v11, v16);
                }
                else {
                    view0.layout(v14, v10, v15, v16);
                }
                v9 += view0.getMeasuredWidth() + (v11 + v12) + this.b;
                v6 = v16;
            }
        }
    }

    @Override  // android.view.View
    public final void onMeasure(int v, int v1) {
        int v14;
        int v13;
        int v2 = View.MeasureSpec.getSize(v);
        int v3 = View.MeasureSpec.getMode(v);
        int v4 = View.MeasureSpec.getSize(v1);
        int v5 = View.MeasureSpec.getMode(v1);
        int v6 = v3 == 0x80000000 || v3 == 0x40000000 ? v2 : 0x7FFFFFFF;
        int v7 = this.getPaddingLeft();
        int v8 = this.getPaddingTop();
        int v9 = this.getPaddingRight();
        int v10 = v8;
        int v12 = 0;
        for(int v11 = 0; v11 < this.getChildCount(); ++v11) {
            View view0 = this.getChildAt(v11);
            if(view0.getVisibility() != 8) {
                this.measureChild(view0, v, v1);
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
                if(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams) {
                    v13 = ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).leftMargin;
                    v14 = ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).rightMargin;
                }
                else {
                    v14 = 0;
                    v13 = 0;
                }
                if(view0.getMeasuredWidth() + (v7 + v13) > v6 - v9 && !this.a()) {
                    v7 = this.getPaddingLeft();
                    v10 = v8 + this.a;
                }
                int v15 = view0.getMeasuredWidth() + (v7 + v13);
                int v16 = view0.getMeasuredHeight();
                if(v15 > v12) {
                    v12 = v15;
                }
                int v17 = view0.getMeasuredWidth() + (v13 + v14) + this.b + v7;
                if(v11 == this.getChildCount() - 1) {
                    v12 += v14;
                }
                v7 = v17;
                v8 = v16 + v10;
            }
        }
        int v18 = this.getPaddingRight() + v12;
        int v19 = this.getPaddingBottom() + v8;
        if(v3 == 0x80000000) {
            v2 = Math.min(v18, v2);
        }
        else if(v3 != 0x40000000) {
            v2 = v18;
        }
        if(v5 == 0x80000000) {
            v4 = Math.min(v19, v4);
        }
        else if(v5 != 0x40000000) {
            v4 = v19;
        }
        this.setMeasuredDimension(v2, v4);
    }

    public void setItemSpacing(int v) {
        this.b = v;
    }

    public void setLineSpacing(int v) {
        this.a = v;
    }

    public void setSingleLine(boolean z) {
        this.c = z;
    }
}

