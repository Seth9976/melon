package androidx.constraintlayout.helper.widget;

import F1.e;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.q;

public class Layer extends ConstraintHelper {
    public float B;
    public float D;
    public float E;
    public float G;
    public final boolean I;
    public View[] M;
    public float N;
    public float S;
    public boolean T;
    public boolean V;
    public float j;
    public float k;
    public float l;
    public ConstraintLayout m;
    public float n;
    public float o;
    public float r;
    public float w;

    public Layer(Context context0) {
        super(context0);
        this.j = NaNf;
        this.k = NaNf;
        this.l = NaNf;
        this.n = 1.0f;
        this.o = 1.0f;
        this.r = NaNf;
        this.w = NaNf;
        this.B = NaNf;
        this.D = NaNf;
        this.E = NaNf;
        this.G = NaNf;
        this.I = true;
        this.M = null;
        this.N = 0.0f;
        this.S = 0.0f;
    }

    public Layer(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.j = NaNf;
        this.k = NaNf;
        this.l = NaNf;
        this.n = 1.0f;
        this.o = 1.0f;
        this.r = NaNf;
        this.w = NaNf;
        this.B = NaNf;
        this.D = NaNf;
        this.E = NaNf;
        this.G = NaNf;
        this.I = true;
        this.M = null;
        this.N = 0.0f;
        this.S = 0.0f;
    }

    public Layer(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.j = NaNf;
        this.k = NaNf;
        this.l = NaNf;
        this.n = 1.0f;
        this.o = 1.0f;
        this.r = NaNf;
        this.w = NaNf;
        this.B = NaNf;
        this.D = NaNf;
        this.E = NaNf;
        this.G = NaNf;
        this.I = true;
        this.M = null;
        this.N = 0.0f;
        this.S = 0.0f;
    }

    @Override  // androidx.constraintlayout.widget.ConstraintHelper
    public final void f(ConstraintLayout constraintLayout0) {
        this.e(constraintLayout0);
    }

    @Override  // androidx.constraintlayout.widget.ConstraintHelper
    public final void j(AttributeSet attributeSet0) {
        super.j(attributeSet0);
        this.e = false;
        if(attributeSet0 != null) {
            TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, q.c);
            int v1 = typedArray0.getIndexCount();
            for(int v = 0; v < v1; ++v) {
                int v2 = typedArray0.getIndex(v);
                if(v2 == 6) {
                    this.T = true;
                }
                else if(v2 == 22) {
                    this.V = true;
                }
            }
            typedArray0.recycle();
        }
    }

    @Override  // androidx.constraintlayout.widget.ConstraintHelper
    public final void m() {
        this.r();
        this.r = NaNf;
        this.w = NaNf;
        e e0 = ((LayoutParams)this.getLayoutParams()).q0;
        e0.T(0);
        e0.O(0);
        this.q();
        int v = (int)this.E;
        int v1 = this.getPaddingLeft();
        int v2 = (int)this.G;
        int v3 = this.getPaddingTop();
        int v4 = (int)this.B;
        int v5 = this.getPaddingRight();
        int v6 = (int)this.D;
        this.layout(v - v1, v2 - v3, v5 + v4, this.getPaddingBottom() + v6);
        this.s();
    }

    @Override  // androidx.constraintlayout.widget.ConstraintHelper
    public final void n(ConstraintLayout constraintLayout0) {
        this.m = constraintLayout0;
        float f = this.getRotation();
        if(f == 0.0f) {
            if(!Float.isNaN(this.l)) {
                this.l = 0.0f;
            }
            return;
        }
        this.l = f;
    }

    @Override  // androidx.constraintlayout.widget.ConstraintHelper
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.m = (ConstraintLayout)this.getParent();
        if(this.T || this.V) {
            int v = this.getVisibility();
            float f = this.getElevation();
            for(int v1 = 0; v1 < this.b; ++v1) {
                View view0 = this.m.getViewById(this.a[v1]);
                if(view0 != null) {
                    if(this.T) {
                        view0.setVisibility(v);
                    }
                    if(this.V && f > 0.0f) {
                        view0.setTranslationZ(view0.getTranslationZ() + f);
                    }
                }
            }
        }
    }

    public final void q() {
        if(this.m == null || !this.I && !Float.isNaN(this.r) && !Float.isNaN(this.w)) {
            return;
        }
        if(!Float.isNaN(this.j) && !Float.isNaN(this.k)) {
            this.w = this.k;
            this.r = this.j;
            return;
        }
        View[] arr_view = this.i(this.m);
        int v1 = arr_view[0].getLeft();
        int v2 = arr_view[0].getTop();
        int v3 = arr_view[0].getRight();
        int v4 = arr_view[0].getBottom();
        for(int v = 0; v < this.b; ++v) {
            View view0 = arr_view[v];
            v1 = Math.min(v1, view0.getLeft());
            v2 = Math.min(v2, view0.getTop());
            v3 = Math.max(v3, view0.getRight());
            v4 = Math.max(v4, view0.getBottom());
        }
        this.B = (float)v3;
        this.D = (float)v4;
        this.E = (float)v1;
        this.G = (float)v2;
        this.r = Float.isNaN(this.j) ? ((float)((v1 + v3) / 2)) : this.j;
        if(Float.isNaN(this.k)) {
            this.w = (float)((v2 + v4) / 2);
            return;
        }
        this.w = this.k;
    }

    public final void r() {
        if(this.m != null) {
            int v = this.b;
            if(v != 0) {
                if(this.M == null || this.M.length != v) {
                    this.M = new View[v];
                }
                for(int v1 = 0; v1 < this.b; ++v1) {
                    View[] arr_view = this.M;
                    arr_view[v1] = this.m.getViewById(this.a[v1]);
                }
            }
        }
    }

    public final void s() {
        if(this.m != null) {
            if(this.M == null) {
                this.r();
            }
            this.q();
            double f = Float.isNaN(this.l) ? 0.0 : Math.toRadians(this.l);
            float f1 = (float)Math.sin(f);
            float f2 = (float)Math.cos(f);
            float f3 = this.n * f2;
            float f4 = -this.o * f1;
            float f5 = this.n * f1;
            float f6 = this.o * f2;
            for(int v = 0; v < this.b; ++v) {
                View view0 = this.M[v];
                int v1 = view0.getLeft();
                int v2 = view0.getRight();
                int v3 = view0.getTop();
                int v4 = view0.getBottom();
                float f7 = ((float)((v2 + v1) / 2)) - this.r;
                float f8 = ((float)((v4 + v3) / 2)) - this.w;
                float f9 = f6 * f8 + f7 * f5 - f8 + this.S;
                view0.setTranslationX(f4 * f8 + f3 * f7 - f7 + this.N);
                view0.setTranslationY(f9);
                view0.setScaleY(this.o);
                view0.setScaleX(this.n);
                if(!Float.isNaN(this.l)) {
                    view0.setRotation(this.l);
                }
            }
        }
    }

    @Override  // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        this.d();
    }

    @Override  // android.view.View
    public void setPivotX(float f) {
        this.j = f;
        this.s();
    }

    @Override  // android.view.View
    public void setPivotY(float f) {
        this.k = f;
        this.s();
    }

    @Override  // android.view.View
    public void setRotation(float f) {
        this.l = f;
        this.s();
    }

    @Override  // android.view.View
    public void setScaleX(float f) {
        this.n = f;
        this.s();
    }

    @Override  // android.view.View
    public void setScaleY(float f) {
        this.o = f;
        this.s();
    }

    @Override  // android.view.View
    public void setTranslationX(float f) {
        this.N = f;
        this.s();
    }

    @Override  // android.view.View
    public void setTranslationY(float f) {
        this.S = f;
        this.s();
    }

    @Override  // android.view.View
    public void setVisibility(int v) {
        super.setVisibility(v);
        this.d();
    }
}

