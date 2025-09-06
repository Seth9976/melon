package androidx.recyclerview.widget;

import android.view.View;

public final class c0 extends d0 {
    @Override  // androidx.recyclerview.widget.d0
    public final int b(View view0) {
        LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        return this.a.getDecoratedBottom(view0) + recyclerView$LayoutParams0.bottomMargin;
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int c(View view0) {
        LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        return this.a.getDecoratedMeasuredHeight(view0) + recyclerView$LayoutParams0.topMargin + recyclerView$LayoutParams0.bottomMargin;
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int d(View view0) {
        LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        return this.a.getDecoratedMeasuredWidth(view0) + recyclerView$LayoutParams0.leftMargin + recyclerView$LayoutParams0.rightMargin;
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int e(View view0) {
        LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        return this.a.getDecoratedTop(view0) - recyclerView$LayoutParams0.topMargin;
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int f() {
        return this.a.getHeight();
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int g() {
        int v = this.a.getPaddingBottom();
        return this.a.getHeight() - v;
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int h() {
        return this.a.getPaddingBottom();
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int i() {
        return this.a.getHeightMode();
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int j() {
        return this.a.getWidthMode();
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int k() {
        return this.a.getPaddingTop();
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int l() {
        int v = this.a.getPaddingTop();
        int v1 = this.a.getPaddingBottom();
        return this.a.getHeight() - v - v1;
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int n(View view0) {
        this.a.getTransformedBoundingBox(view0, true, this.c);
        return this.c.bottom;
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int o(View view0) {
        this.a.getTransformedBoundingBox(view0, true, this.c);
        return this.c.top;
    }

    @Override  // androidx.recyclerview.widget.d0
    public final void p(int v) {
        this.a.offsetChildrenVertical(v);
    }
}

