package androidx.recyclerview.widget;

import android.view.View;

public final class t0 implements Y0 {
    public final w0 a;

    public t0(w0 w00) {
        this.a = w00;
    }

    @Override  // androidx.recyclerview.widget.Y0
    public final int a(View view0) {
        LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        return this.a.getDecoratedTop(view0) - recyclerView$LayoutParams0.topMargin;
    }

    @Override  // androidx.recyclerview.widget.Y0
    public final int b() {
        return this.a.getPaddingTop();
    }

    @Override  // androidx.recyclerview.widget.Y0
    public final int c() {
        int v = this.a.getPaddingBottom();
        return this.a.getHeight() - v;
    }

    @Override  // androidx.recyclerview.widget.Y0
    public final View d(int v) {
        return this.a.getChildAt(v);
    }

    @Override  // androidx.recyclerview.widget.Y0
    public final int e(View view0) {
        LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        return this.a.getDecoratedBottom(view0) + recyclerView$LayoutParams0.bottomMargin;
    }
}

