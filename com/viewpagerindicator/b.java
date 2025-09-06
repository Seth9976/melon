package com.viewpagerindicator;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;

public final class b extends LinearLayout {
    public Drawable a;
    public int b;
    public int c;
    public int d;
    public int e;
    public static final int[] f;

    static {
        b.f = new int[]{0x1010129, 0x1010329, 0x101032A};
    }

    public final void a(int v, Canvas canvas0) {
        Drawable drawable0 = this.a;
        int v1 = this.getPaddingLeft();
        int v2 = this.e;
        drawable0.setBounds(v1 + v2, v, this.getWidth() - this.getPaddingRight() - v2, this.c + v);
        this.a.draw(canvas0);
    }

    public final void b(int v, Canvas canvas0) {
        Drawable drawable0 = this.a;
        int v1 = this.getPaddingTop();
        int v2 = this.e;
        drawable0.setBounds(v, v1 + v2, this.b + v, this.getHeight() - this.getPaddingBottom() - v2);
        this.a.draw(canvas0);
    }

    public final boolean c(int v) {
        if(v != 0 && v != this.getChildCount() && (this.d & 2) != 0) {
            for(int v1 = v - 1; v1 >= 0; --v1) {
                if(this.getChildAt(v1).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override  // android.view.ViewGroup
    public final void measureChildWithMargins(View view0, int v, int v1, int v2, int v3) {
        int v4 = this.indexOfChild(view0);
        int v5 = this.getOrientation();
        LinearLayout.LayoutParams linearLayout$LayoutParams0 = (LinearLayout.LayoutParams)view0.getLayoutParams();
        if(this.c(v4)) {
            if(v5 == 1) {
                linearLayout$LayoutParams0.topMargin = this.c;
            }
            else {
                linearLayout$LayoutParams0.leftMargin = this.b;
            }
        }
        int v6 = this.getChildCount();
        if(v4 == v6 - 1 && this.c(v6)) {
            if(v5 == 1) {
                linearLayout$LayoutParams0.bottomMargin = this.c;
            }
            else {
                linearLayout$LayoutParams0.rightMargin = this.b;
            }
        }
        super.measureChildWithMargins(view0, v, v1, v2, v3);
    }

    @Override  // android.widget.LinearLayout
    public final void onDraw(Canvas canvas0) {
        int v = 0;
        if(this.a != null) {
            if(this.getOrientation() == 1) {
                int v1 = this.getChildCount();
                while(v < v1) {
                    View view0 = this.getChildAt(v);
                    if(view0 != null && view0.getVisibility() != 8 && this.c(v)) {
                        LinearLayout.LayoutParams linearLayout$LayoutParams0 = (LinearLayout.LayoutParams)view0.getLayoutParams();
                        this.a(view0.getTop() - linearLayout$LayoutParams0.topMargin, canvas0);
                    }
                    ++v;
                }
                if(this.c(v1)) {
                    View view1 = this.getChildAt(v1 - 1);
                    this.a((view1 == null ? this.getHeight() - this.getPaddingBottom() - this.c : view1.getBottom()), canvas0);
                }
            }
            else {
                int v2 = this.getChildCount();
                while(v < v2) {
                    View view2 = this.getChildAt(v);
                    if(view2 != null && view2.getVisibility() != 8 && this.c(v)) {
                        LinearLayout.LayoutParams linearLayout$LayoutParams1 = (LinearLayout.LayoutParams)view2.getLayoutParams();
                        this.b(view2.getLeft() - linearLayout$LayoutParams1.leftMargin, canvas0);
                    }
                    ++v;
                }
                if(this.c(v2)) {
                    View view3 = this.getChildAt(v2 - 1);
                    this.b((view3 == null ? this.getWidth() - this.getPaddingRight() - this.b : view3.getRight()), canvas0);
                }
            }
        }
        super.onDraw(canvas0);
    }

    @Override  // android.widget.LinearLayout
    public final void setDividerDrawable(Drawable drawable0) {
        if(drawable0 == this.a) {
            return;
        }
        this.a = drawable0;
        boolean z = false;
        if(drawable0 == null) {
            this.b = 0;
            this.c = 0;
        }
        else {
            this.b = drawable0.getIntrinsicWidth();
            this.c = drawable0.getIntrinsicHeight();
        }
        if(drawable0 == null) {
            z = true;
        }
        this.setWillNotDraw(z);
        this.requestLayout();
    }
}

