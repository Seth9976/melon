package androidx.constraintlayout.widget;

import F1.m;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;

public abstract class VirtualLayout extends ConstraintHelper {
    public boolean j;
    public boolean k;

    public VirtualLayout(Context context0) {
        super(context0);
    }

    public VirtualLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public VirtualLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    @Override  // androidx.constraintlayout.widget.ConstraintHelper
    public final void f(ConstraintLayout constraintLayout0) {
        this.e(constraintLayout0);
    }

    @Override  // androidx.constraintlayout.widget.ConstraintHelper
    public void j(AttributeSet attributeSet0) {
        super.j(attributeSet0);
        if(attributeSet0 != null) {
            TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, q.c);
            int v = typedArray0.getIndexCount();
            for(int v1 = 0; v1 < v; ++v1) {
                int v2 = typedArray0.getIndex(v1);
                if(v2 == 6) {
                    this.j = true;
                }
                else if(v2 == 22) {
                    this.k = true;
                }
            }
            typedArray0.recycle();
        }
    }

    @Override  // androidx.constraintlayout.widget.ConstraintHelper
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(this.j || this.k) {
            ViewParent viewParent0 = this.getParent();
            if(viewParent0 instanceof ConstraintLayout) {
                int v = this.getVisibility();
                float f = this.getElevation();
                for(int v1 = 0; v1 < this.b; ++v1) {
                    View view0 = ((ConstraintLayout)viewParent0).getViewById(this.a[v1]);
                    if(view0 != null) {
                        if(this.j) {
                            view0.setVisibility(v);
                        }
                        if(this.k && f > 0.0f) {
                            view0.setTranslationZ(view0.getTranslationZ() + f);
                        }
                    }
                }
            }
        }
    }

    public void q(m m0, int v, int v1) {
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

