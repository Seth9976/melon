package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.q;
import java.util.HashMap;

public class MotionHelper extends ConstraintHelper implements z {
    public boolean j;
    public boolean k;
    public float l;
    public View[] m;

    public MotionHelper(Context context0) {
        super(context0);
        this.j = false;
        this.k = false;
    }

    public MotionHelper(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.j = false;
        this.k = false;
        this.j(attributeSet0);
    }

    public MotionHelper(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.j = false;
        this.k = false;
        this.j(attributeSet0);
    }

    public float getProgress() {
        return this.l;
    }

    @Override  // androidx.constraintlayout.widget.ConstraintHelper
    public final void j(AttributeSet attributeSet0) {
        super.j(attributeSet0);
        if(attributeSet0 != null) {
            TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, q.t);
            int v = typedArray0.getIndexCount();
            for(int v1 = 0; v1 < v; ++v1) {
                int v2 = typedArray0.getIndex(v1);
                if(v2 == 1) {
                    this.j = typedArray0.getBoolean(1, this.j);
                }
                else if(v2 == 0) {
                    this.k = typedArray0.getBoolean(0, this.k);
                }
            }
            typedArray0.recycle();
        }
    }

    @Override  // androidx.constraintlayout.motion.widget.z
    public void onTransitionChange(MotionLayout motionLayout0, int v, int v1, float f) {
    }

    @Override  // androidx.constraintlayout.motion.widget.z
    public void onTransitionCompleted(MotionLayout motionLayout0, int v) {
    }

    @Override  // androidx.constraintlayout.motion.widget.z
    public final void onTransitionStarted(MotionLayout motionLayout0, int v, int v1) {
    }

    @Override  // androidx.constraintlayout.motion.widget.z
    public final void onTransitionTrigger(MotionLayout motionLayout0, int v, boolean z, float f) {
    }

    public void q(MotionLayout motionLayout0, HashMap hashMap0) {
    }

    public void setProgress(float f) {
        this.l = f;
        int v = 0;
        if(this.b > 0) {
            this.m = this.i(((ConstraintLayout)this.getParent()));
            while(v < this.b) {
                View view0 = this.m[v];
                ++v;
            }
            return;
        }
        ViewGroup viewGroup0 = (ViewGroup)this.getParent();
        int v1 = viewGroup0.getChildCount();
        while(v < v1) {
            viewGroup0.getChildAt(v);
            ++v;
        }
    }
}

