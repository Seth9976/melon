package androidx.constraintlayout.helper.widget;

import F1.e;
import F1.h;
import F1.j;
import F1.m;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View.MeasureSpec;
import androidx.constraintlayout.widget.Constraints.LayoutParams;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.constraintlayout.widget.i;
import androidx.constraintlayout.widget.q;

public class Flow extends VirtualLayout {
    public h l;

    public Flow(Context context0) {
        super(context0);
    }

    public Flow(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public Flow(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    @Override  // androidx.constraintlayout.widget.VirtualLayout
    public final void j(AttributeSet attributeSet0) {
        super.j(attributeSet0);
        this.l = new h();
        if(attributeSet0 != null) {
            TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, q.c);
            int v = typedArray0.getIndexCount();
            for(int v1 = 0; v1 < v; ++v1) {
                switch(typedArray0.getIndex(v1)) {
                    case 0: {
                        h h0 = this.l;
                        h0.a1 = typedArray0.getInt(0, 0);
                        break;
                    }
                    case 1: {
                        h h1 = this.l;
                        int v2 = typedArray0.getDimensionPixelSize(1, 0);
                        h1.x0 = v2;
                        h1.y0 = v2;
                        h1.z0 = v2;
                        h1.A0 = v2;
                        break;
                    }
                    case 2: {
                        h h4 = this.l;
                        h4.B0 = typedArray0.getDimensionPixelSize(2, 0);
                        break;
                    }
                    case 3: {
                        h h5 = this.l;
                        h5.x0 = typedArray0.getDimensionPixelSize(3, 0);
                        break;
                    }
                    case 4: {
                        h h6 = this.l;
                        h6.C0 = typedArray0.getDimensionPixelSize(4, 0);
                        break;
                    }
                    case 5: {
                        h h7 = this.l;
                        h7.y0 = typedArray0.getDimensionPixelSize(5, 0);
                        break;
                    }
                    case 18: {
                        h h2 = this.l;
                        int v3 = typedArray0.getDimensionPixelSize(18, 0);
                        h2.z0 = v3;
                        h2.B0 = v3;
                        h2.C0 = v3;
                        break;
                    }
                    case 19: {
                        h h3 = this.l;
                        h3.A0 = typedArray0.getDimensionPixelSize(19, 0);
                        break;
                    }
                    case 37: {
                        h h16 = this.l;
                        h16.Q0 = typedArray0.getFloat(37, 0.5f);
                        break;
                    }
                    case 38: {
                        h h11 = this.l;
                        h11.K0 = typedArray0.getInt(38, 0);
                        break;
                    }
                    case 39: {
                        h h18 = this.l;
                        h18.R0 = typedArray0.getFloat(39, 0.5f);
                        break;
                    }
                    case 40: {
                        h h13 = this.l;
                        h13.L0 = typedArray0.getInt(40, 0);
                        break;
                    }
                    case 41: {
                        h h21 = this.l;
                        h21.W0 = typedArray0.getInt(41, 2);
                        break;
                    }
                    case 42: {
                        h h15 = this.l;
                        h15.O0 = typedArray0.getFloat(42, 0.5f);
                        break;
                    }
                    case 43: {
                        h h23 = this.l;
                        h23.U0 = typedArray0.getDimensionPixelSize(43, 0);
                        break;
                    }
                    case 44: {
                        h h9 = this.l;
                        h9.I0 = typedArray0.getInt(44, 0);
                        break;
                    }
                    case 45: {
                        h h17 = this.l;
                        h17.S0 = typedArray0.getFloat(45, 0.5f);
                        break;
                    }
                    case 46: {
                        h h12 = this.l;
                        h12.M0 = typedArray0.getInt(46, 0);
                        break;
                    }
                    case 0x2F: {
                        h h19 = this.l;
                        h19.T0 = typedArray0.getFloat(0x2F, 0.5f);
                        break;
                    }
                    case 0x30: {
                        h h14 = this.l;
                        h14.N0 = typedArray0.getInt(0x30, 0);
                        break;
                    }
                    case 49: {
                        h h25 = this.l;
                        h25.Z0 = typedArray0.getInt(49, -1);
                        break;
                    }
                    case 50: {
                        h h22 = this.l;
                        h22.X0 = typedArray0.getInt(50, 2);
                        break;
                    }
                    case 51: {
                        h h20 = this.l;
                        h20.P0 = typedArray0.getFloat(51, 0.5f);
                        break;
                    }
                    case 52: {
                        h h24 = this.l;
                        h24.V0 = typedArray0.getDimensionPixelSize(52, 0);
                        break;
                    }
                    case 53: {
                        h h10 = this.l;
                        h10.J0 = typedArray0.getInt(53, 0);
                        break;
                    }
                    case 54: {
                        h h8 = this.l;
                        h8.Y0 = typedArray0.getInt(54, 0);
                    }
                }
            }
            typedArray0.recycle();
        }
        this.d = this.l;
        this.p();
    }

    @Override  // androidx.constraintlayout.widget.ConstraintHelper
    public final void k(i i0, j j0, LayoutParams constraints$LayoutParams0, SparseArray sparseArray0) {
        super.k(i0, j0, constraints$LayoutParams0, sparseArray0);
        if(j0 instanceof h) {
            int v = constraints$LayoutParams0.V;
            if(v != -1) {
                ((h)j0).a1 = v;
            }
        }
    }

    @Override  // androidx.constraintlayout.widget.ConstraintHelper
    public final void l(e e0, boolean z) {
        h h0 = this.l;
        int v = h0.z0;
        if(v <= 0 && h0.A0 <= 0) {
            return;
        }
        if(z) {
            h0.B0 = h0.A0;
            h0.C0 = v;
            return;
        }
        h0.B0 = v;
        h0.C0 = h0.A0;
    }

    @Override  // androidx.constraintlayout.widget.ConstraintHelper
    public final void onMeasure(int v, int v1) {
        this.q(this.l, v, v1);
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

    public void setFirstHorizontalBias(float f) {
        this.l.Q0 = f;
        this.requestLayout();
    }

    public void setFirstHorizontalStyle(int v) {
        this.l.K0 = v;
        this.requestLayout();
    }

    public void setFirstVerticalBias(float f) {
        this.l.R0 = f;
        this.requestLayout();
    }

    public void setFirstVerticalStyle(int v) {
        this.l.L0 = v;
        this.requestLayout();
    }

    public void setHorizontalAlign(int v) {
        this.l.W0 = v;
        this.requestLayout();
    }

    public void setHorizontalBias(float f) {
        this.l.O0 = f;
        this.requestLayout();
    }

    public void setHorizontalGap(int v) {
        this.l.U0 = v;
        this.requestLayout();
    }

    public void setHorizontalStyle(int v) {
        this.l.I0 = v;
        this.requestLayout();
    }

    public void setLastHorizontalBias(float f) {
        this.l.S0 = f;
        this.requestLayout();
    }

    public void setLastHorizontalStyle(int v) {
        this.l.M0 = v;
        this.requestLayout();
    }

    public void setLastVerticalBias(float f) {
        this.l.T0 = f;
        this.requestLayout();
    }

    public void setLastVerticalStyle(int v) {
        this.l.N0 = v;
        this.requestLayout();
    }

    public void setMaxElementsWrap(int v) {
        this.l.Z0 = v;
        this.requestLayout();
    }

    public void setOrientation(int v) {
        this.l.a1 = v;
        this.requestLayout();
    }

    public void setPadding(int v) {
        this.l.x0 = v;
        this.l.y0 = v;
        this.l.z0 = v;
        this.l.A0 = v;
        this.requestLayout();
    }

    public void setPaddingBottom(int v) {
        this.l.y0 = v;
        this.requestLayout();
    }

    public void setPaddingLeft(int v) {
        this.l.B0 = v;
        this.requestLayout();
    }

    public void setPaddingRight(int v) {
        this.l.C0 = v;
        this.requestLayout();
    }

    public void setPaddingTop(int v) {
        this.l.x0 = v;
        this.requestLayout();
    }

    public void setVerticalAlign(int v) {
        this.l.X0 = v;
        this.requestLayout();
    }

    public void setVerticalBias(float f) {
        this.l.P0 = f;
        this.requestLayout();
    }

    public void setVerticalGap(int v) {
        this.l.V0 = v;
        this.requestLayout();
    }

    public void setVerticalStyle(int v) {
        this.l.J0 = v;
        this.requestLayout();
    }

    public void setWrapMode(int v) {
        this.l.Y0 = v;
        this.requestLayout();
    }
}

