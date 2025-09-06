package androidx.constraintlayout.widget;

import F1.a;
import F1.e;
import F1.f;
import F1.j;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;

public class Barrier extends ConstraintHelper {
    public int j;
    public int k;
    public a l;

    public Barrier(Context context0) {
        super(context0);
        super.setVisibility(8);
    }

    public Barrier(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        super.setVisibility(8);
    }

    public Barrier(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        super.setVisibility(8);
    }

    public boolean getAllowsGoneWidget() {
        return this.l.y0;
    }

    public int getMargin() {
        return this.l.z0;
    }

    public int getType() {
        return this.j;
    }

    @Override  // androidx.constraintlayout.widget.ConstraintHelper
    public final void j(AttributeSet attributeSet0) {
        super.j(attributeSet0);
        this.l = new a();
        if(attributeSet0 != null) {
            TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, q.c);
            int v = typedArray0.getIndexCount();
            for(int v1 = 0; v1 < v; ++v1) {
                int v2 = typedArray0.getIndex(v1);
                if(v2 == 26) {
                    this.setType(typedArray0.getInt(26, 0));
                }
                else {
                    switch(v2) {
                        case 25: {
                            a a0 = this.l;
                            a0.y0 = typedArray0.getBoolean(25, true);
                            break;
                        }
                        case 27: {
                            this.l.z0 = typedArray0.getDimensionPixelSize(27, 0);
                        }
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
        androidx.constraintlayout.widget.j j1 = i0.e;
        if(j0 instanceof a) {
            this.q(((a)j0), j1.g0, ((f)j0.W).A0);
            ((a)j0).y0 = j1.o0;
            ((a)j0).z0 = j1.h0;
        }
    }

    @Override  // androidx.constraintlayout.widget.ConstraintHelper
    public final void l(e e0, boolean z) {
        this.q(e0, this.j, z);
    }

    public final void q(e e0, int v, boolean z) {
        this.k = v;
        if(z) {
            int v1 = this.j;
            if(v1 == 5) {
                this.k = 1;
            }
            else if(v1 == 6) {
                this.k = 0;
            }
        }
        else {
            int v2 = this.j;
            if(v2 == 5) {
                this.k = 0;
            }
            else if(v2 == 6) {
                this.k = 1;
            }
        }
        if(e0 instanceof a) {
            ((a)e0).x0 = this.k;
        }
    }

    public void setAllowsGoneWidget(boolean z) {
        this.l.y0 = z;
    }

    public void setDpMargin(int v) {
        this.l.z0 = (int)(((float)v) * this.getResources().getDisplayMetrics().density + 0.5f);
    }

    public void setMargin(int v) {
        this.l.z0 = v;
    }

    public void setType(int v) {
        this.j = v;
    }
}

