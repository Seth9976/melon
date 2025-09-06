package androidx.constraintlayout.helper.widget;

import E9.t;
import H1.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.D;
import androidx.constraintlayout.motion.widget.F;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.q;
import java.util.ArrayList;

public class Carousel extends MotionHelper {
    public boolean B;
    public int D;
    public int E;
    public int G;
    public int I;
    public float M;
    public int N;
    public int S;
    public float T;
    public final ArrayList n;
    public int o;
    public MotionLayout r;
    public int w;

    public Carousel(Context context0) {
        super(context0);
        this.n = new ArrayList();
        this.o = 0;
        this.w = -1;
        this.B = false;
        this.D = -1;
        this.E = -1;
        this.G = -1;
        this.I = -1;
        this.M = 0.9f;
        this.N = 4;
        this.S = 1;
        this.T = 2.0f;
        new t(this, 1);
    }

    public Carousel(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.n = new ArrayList();
        this.o = 0;
        this.w = -1;
        this.B = false;
        this.D = -1;
        this.E = -1;
        this.G = -1;
        this.I = -1;
        this.M = 0.9f;
        this.N = 4;
        this.S = 1;
        this.T = 2.0f;
        new t(this, 1);
        this.r(context0, attributeSet0);
    }

    public Carousel(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.n = new ArrayList();
        this.o = 0;
        this.w = -1;
        this.B = false;
        this.D = -1;
        this.E = -1;
        this.G = -1;
        this.I = -1;
        this.M = 0.9f;
        this.N = 4;
        this.S = 1;
        this.T = 2.0f;
        new t(this, 1);
        this.r(context0, attributeSet0);
    }

    public int getCount() {
        return 0;
    }

    public int getCurrentIndex() {
        return this.o;
    }

    @Override  // androidx.constraintlayout.widget.ConstraintHelper
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(this.getParent() instanceof MotionLayout) {
            MotionLayout motionLayout0 = (MotionLayout)this.getParent();
            ArrayList arrayList0 = this.n;
            arrayList0.clear();
            for(int v = 0; v < this.b; ++v) {
                arrayList0.add(motionLayout0.getViewById(this.a[v]));
            }
            this.r = motionLayout0;
            if(this.S == 2) {
                D d0 = motionLayout0.getTransition(this.E);
                if(d0 != null) {
                    F f0 = d0.l;
                    if(f0 != null) {
                        f0.c = 5;
                    }
                }
                D d1 = this.r.getTransition(this.D);
                if(d1 != null) {
                    F f1 = d1.l;
                    if(f1 != null) {
                        f1.c = 5;
                    }
                }
            }
        }
    }

    @Override  // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.n.clear();
    }

    @Override  // androidx.constraintlayout.motion.widget.MotionHelper
    public final void onTransitionChange(MotionLayout motionLayout0, int v, int v1, float f) {
    }

    @Override  // androidx.constraintlayout.motion.widget.MotionHelper
    public final void onTransitionCompleted(MotionLayout motionLayout0, int v) {
        int v1 = this.o;
        if(v == this.I) {
            this.o = v1 + 1;
        }
        else if(v == this.G) {
            this.o = v1 - 1;
        }
        throw null;
    }

    public final void r(Context context0, AttributeSet attributeSet0) {
        if(attributeSet0 != null) {
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, q.a);
            int v = typedArray0.getIndexCount();
            for(int v1 = 0; v1 < v; ++v1) {
                switch(typedArray0.getIndex(v1)) {
                    case 1: {
                        this.D = typedArray0.getResourceId(1, this.D);
                        break;
                    }
                    case 2: {
                        this.N = typedArray0.getInt(2, this.N);
                        break;
                    }
                    case 3: {
                        this.w = typedArray0.getResourceId(3, this.w);
                        break;
                    }
                    case 4: {
                        this.E = typedArray0.getResourceId(4, this.E);
                        break;
                    }
                    case 5: {
                        this.B = typedArray0.getBoolean(5, this.B);
                        break;
                    }
                    case 6: {
                        this.I = typedArray0.getResourceId(6, this.I);
                        break;
                    }
                    case 7: {
                        this.G = typedArray0.getResourceId(7, this.G);
                        break;
                    }
                    case 8: {
                        this.S = typedArray0.getInt(8, this.S);
                        break;
                    }
                    case 9: {
                        this.M = typedArray0.getFloat(9, this.M);
                        break;
                    }
                    case 10: {
                        this.T = typedArray0.getFloat(10, this.T);
                    }
                }
            }
            typedArray0.recycle();
        }
    }

    public void setAdapter(a a0) {
    }

    public void setInfinite(boolean z) {
        this.B = z;
    }
}

