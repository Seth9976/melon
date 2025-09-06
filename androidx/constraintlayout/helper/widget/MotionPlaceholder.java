package androidx.constraintlayout.helper.widget;

import F1.j;
import F1.l;
import F1.m;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View.MeasureSpec;
import androidx.constraintlayout.widget.VirtualLayout;

public class MotionPlaceholder extends VirtualLayout {
    public MotionPlaceholder(Context context0) {
        super(context0);
    }

    public MotionPlaceholder(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public MotionPlaceholder(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    @Override  // androidx.constraintlayout.widget.VirtualLayout
    public final void j(AttributeSet attributeSet0) {
        super.j(attributeSet0);
        this.d = new l();  // 初始化器: LF1/m;-><init>()V
        this.p();
    }

    @Override  // androidx.constraintlayout.widget.ConstraintHelper
    public final void o(j j0, SparseArray sparseArray0) {
    }

    @Override  // androidx.constraintlayout.widget.ConstraintHelper
    public final void onMeasure(int v, int v1) {
        this.q(null, v, v1);
    }

    @Override  // androidx.constraintlayout.widget.VirtualLayout
    public final void q(m m0, int v, int v1) {
        int v2 = View.MeasureSpec.getMode(v);
        int v3 = View.MeasureSpec.getSize(v);
        int v4 = View.MeasureSpec.getMode(v1);
        int v5 = View.MeasureSpec.getSize(v1);
        if(m0 != null) {
            m0.Z(v2, v3, v4, v5);
            this.setMeasuredDimension(m0.E0, m0.F0);
            return;
        }
        this.setMeasuredDimension(0, 0);
    }
}

