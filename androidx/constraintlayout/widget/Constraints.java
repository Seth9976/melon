package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import java.util.HashMap;

public class Constraints extends ViewGroup {
    public static class LayoutParams extends androidx.constraintlayout.widget.ConstraintLayout.LayoutParams {
        public final float A0;
        public final float B0;
        public final float C0;
        public final float D0;
        public final float r0;
        public final boolean s0;
        public final float t0;
        public final float u0;
        public final float v0;
        public final float w0;
        public final float x0;
        public final float y0;
        public final float z0;

        public LayoutParams() {
            super(-2, -2);
            this.r0 = 1.0f;
            this.s0 = false;
            this.t0 = 0.0f;
            this.u0 = 0.0f;
            this.v0 = 0.0f;
            this.w0 = 0.0f;
            this.x0 = 1.0f;
            this.y0 = 1.0f;
            this.z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 0.0f;
        }

        public LayoutParams(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
            this.r0 = 1.0f;
            this.s0 = false;
            this.t0 = 0.0f;
            this.u0 = 0.0f;
            this.v0 = 0.0f;
            this.w0 = 0.0f;
            this.x0 = 1.0f;
            this.y0 = 1.0f;
            this.z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 0.0f;
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, q.g);
            int v1 = typedArray0.getIndexCount();
            for(int v = 0; v < v1; ++v) {
                switch(typedArray0.getIndex(v)) {
                    case 15: {
                        this.r0 = typedArray0.getFloat(15, this.r0);
                        break;
                    }
                    case 16: {
                        this.z0 = typedArray0.getFloat(16, this.z0);
                        break;
                    }
                    case 17: {
                        this.A0 = typedArray0.getFloat(17, this.A0);
                        break;
                    }
                    case 18: {
                        this.B0 = typedArray0.getFloat(18, this.B0);
                        break;
                    }
                    case 19: {
                        this.C0 = typedArray0.getFloat(19, this.C0);
                        break;
                    }
                    case 20: {
                        this.x0 = typedArray0.getFloat(20, this.x0);
                        break;
                    }
                    case 21: {
                        this.y0 = typedArray0.getFloat(21, this.y0);
                        break;
                    }
                    case 22: {
                        this.u0 = typedArray0.getFloat(22, this.u0);
                        break;
                    }
                    case 23: {
                        this.v0 = typedArray0.getFloat(23, this.v0);
                        break;
                    }
                    case 24: {
                        this.w0 = typedArray0.getFloat(24, this.w0);
                        break;
                    }
                    case 27: {
                        this.D0 = typedArray0.getFloat(27, this.D0);
                        break;
                    }
                    case 28: {
                        this.t0 = typedArray0.getFloat(28, this.t0);
                        this.s0 = true;
                    }
                }
            }
            typedArray0.recycle();
        }
    }

    public n a;

    public Constraints(Context context0) {
        super(context0);
        super.setVisibility(8);
    }

    public Constraints(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        Log.v("Constraints", " ################# init");
        super.setVisibility(8);
    }

    public Constraints(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        Log.v("Constraints", " ################# init");
        super.setVisibility(8);
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return new LayoutParams(this.getContext(), attributeSet0);
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(viewGroup$LayoutParams0);
    }

    public n getConstraintSet() {
        if(this.a == null) {
            this.a = new n();
        }
        n n0 = this.a;
        n0.getClass();
        int v = this.getChildCount();
        HashMap hashMap0 = n0.g;
        hashMap0.clear();
        for(int v1 = 0; v1 < v; ++v1) {
            View view0 = this.getChildAt(v1);
            LayoutParams constraints$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
            int v2 = view0.getId();
            if(n0.f && v2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if(!hashMap0.containsKey(v2)) {
                hashMap0.put(v2, new i());
            }
            i i0 = (i)hashMap0.get(v2);
            if(i0 != null) {
                if(view0 instanceof ConstraintHelper) {
                    j j0 = i0.e;
                    i0.d(v2, constraints$LayoutParams0);
                    if(((ConstraintHelper)view0) instanceof Barrier) {
                        j0.i0 = 1;
                        j0.g0 = ((Barrier)(((ConstraintHelper)view0))).getType();
                        j0.j0 = ((Barrier)(((ConstraintHelper)view0))).getReferencedIds();
                        j0.h0 = ((Barrier)(((ConstraintHelper)view0))).getMargin();
                    }
                }
                i0.d(v2, constraints$LayoutParams0);
            }
        }
        return this.a;
    }

    @Override  // android.view.ViewGroup
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
    }
}

