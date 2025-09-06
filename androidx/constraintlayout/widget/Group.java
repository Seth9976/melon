package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;

public class Group extends ConstraintHelper {
    public Group(Context context0) {
        super(context0);
    }

    public Group(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public Group(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    @Override  // androidx.constraintlayout.widget.ConstraintHelper
    public final void f(ConstraintLayout constraintLayout0) {
        this.e(constraintLayout0);
    }

    @Override  // androidx.constraintlayout.widget.ConstraintHelper
    public final void j(AttributeSet attributeSet0) {
        super.j(attributeSet0);
        this.e = false;
    }

    @Override  // androidx.constraintlayout.widget.ConstraintHelper
    public final void m() {
        LayoutParams constraintLayout$LayoutParams0 = (LayoutParams)this.getLayoutParams();
        constraintLayout$LayoutParams0.q0.T(0);
        constraintLayout$LayoutParams0.q0.O(0);
    }

    @Override  // androidx.constraintlayout.widget.ConstraintHelper
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.d();
    }

    @Override  // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        this.d();
    }

    @Override  // android.view.View
    public void setVisibility(int v) {
        super.setVisibility(v);
        this.d();
    }
}

