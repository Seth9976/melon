package androidx.recyclerview.widget;

import android.view.View;

public final class s0 implements Y0 {
    public final w0 a;

    public s0(w0 w00) {
        this.a = w00;
    }

    @Override  // androidx.recyclerview.widget.Y0
    public final int a(View view0) {
        LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        return this.a.getDecoratedLeft(view0) - recyclerView$LayoutParams0.leftMargin;
    }

    @Override  // androidx.recyclerview.widget.Y0
    public final int b() {
        return this.a.getPaddingLeft();
    }

    @Override  // androidx.recyclerview.widget.Y0
    public final int c() {
        int v = this.a.getPaddingRight();
        return this.a.getWidth() - v;
    }

    @Override  // androidx.recyclerview.widget.Y0
    public final View d(int v) {
        return this.a.getChildAt(v);
    }

    @Override  // androidx.recyclerview.widget.Y0
    public final int e(View view0) {
        LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        return this.a.getDecoratedRight(view0) + recyclerView$LayoutParams0.rightMargin;
    }
}

