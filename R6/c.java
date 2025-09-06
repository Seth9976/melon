package r6;

import android.view.ViewGroup.LayoutParams;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public final class c implements g {
    public final int a;
    public final ExtendedFloatingActionButton b;

    public c(ExtendedFloatingActionButton extendedFloatingActionButton0, int v) {
        this.a = v;
        this.b = extendedFloatingActionButton0;
        super();
    }

    @Override  // r6.g
    public final ViewGroup.LayoutParams c() {
        return this.a == 0 ? new ViewGroup.LayoutParams(this.b.getCollapsedSize(), this.b.getCollapsedSize()) : new ViewGroup.LayoutParams(-2, -2);
    }

    @Override  // r6.g
    public final int getHeight() {
        return this.a == 0 ? this.b.getCollapsedSize() : this.b.getMeasuredHeight();
    }

    @Override  // r6.g
    public final int getPaddingEnd() {
        return this.a == 0 ? this.b.getCollapsedPadding() : this.b.V;
    }

    @Override  // r6.g
    public final int getPaddingStart() {
        return this.a == 0 ? this.b.getCollapsedPadding() : this.b.T;
    }

    @Override  // r6.g
    public final int getWidth() {
        return this.a == 0 ? this.b.getCollapsedSize() : this.b.getMeasuredWidth() - this.b.getCollapsedPadding() * 2 + this.b.T + this.b.V;
    }
}

