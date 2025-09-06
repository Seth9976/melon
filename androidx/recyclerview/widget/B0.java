package androidx.recyclerview.widget;

import android.view.View;

public final class b0 extends d0 {
    @Override  // androidx.recyclerview.widget.d0
    public final int b(View view0) {
        LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        return this.a.getDecoratedRight(view0) + recyclerView$LayoutParams0.rightMargin;
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int c(View view0) {
        LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        return this.a.getDecoratedMeasuredWidth(view0) + recyclerView$LayoutParams0.leftMargin + recyclerView$LayoutParams0.rightMargin;
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int d(View view0) {
        LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        return this.a.getDecoratedMeasuredHeight(view0) + recyclerView$LayoutParams0.topMargin + recyclerView$LayoutParams0.bottomMargin;
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int e(View view0) {
        LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        return this.a.getDecoratedLeft(view0) - recyclerView$LayoutParams0.leftMargin;
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int f() {
        return this.a.getWidth();
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int g() {
        int v = this.a.getPaddingRight();
        return this.a.getWidth() - v;
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int h() {
        return this.a.getPaddingRight();
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int i() {
        return this.a.getWidthMode();
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int j() {
        return this.a.getHeightMode();
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int k() {
        return this.a.getPaddingLeft();
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int l() {
        int v = this.a.getPaddingLeft();
        int v1 = this.a.getPaddingRight();
        return this.a.getWidth() - v - v1;
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int n(View view0) {
        this.a.getTransformedBoundingBox(view0, true, this.c);
        return this.c.right;
    }

    @Override  // androidx.recyclerview.widget.d0
    public final int o(View view0) {
        this.a.getTransformedBoundingBox(view0, true, this.c);
        return this.c.left;
    }

    @Override  // androidx.recyclerview.widget.d0
    public final void p(int v) {
        this.a.offsetChildrenHorizontal(v);
    }
}

