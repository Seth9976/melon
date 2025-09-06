package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout.LayoutParams;
import c2.W;
import d5.m;
import g.a;

public class LinearLayoutCompat extends ViewGroup {
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
        }
    }

    public boolean a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public float g;
    public boolean h;
    public int[] i;
    public int[] j;
    public Drawable k;
    public int l;
    public int m;
    public int n;
    public int o;

    public LinearLayoutCompat(Context context0) {
        this(context0, null);
    }

    public LinearLayoutCompat(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public LinearLayoutCompat(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = true;
        this.b = -1;
        this.c = 0;
        this.e = 0x800033;
        m m0 = m.r(context0, attributeSet0, a.p, v);
        W.n(this, context0, a.p, attributeSet0, ((TypedArray)m0.c), v);
        TypedArray typedArray0 = (TypedArray)m0.c;
        int v1 = typedArray0.getInt(1, -1);
        if(v1 >= 0) {
            this.setOrientation(v1);
        }
        int v2 = typedArray0.getInt(0, -1);
        if(v2 >= 0) {
            this.setGravity(v2);
        }
        if(!typedArray0.getBoolean(2, true)) {
            this.setBaselineAligned(false);
        }
        this.g = typedArray0.getFloat(4, -1.0f);
        this.b = typedArray0.getInt(3, -1);
        this.h = typedArray0.getBoolean(7, false);
        this.setDividerDrawable(m0.k(5));
        this.n = typedArray0.getInt(8, 0);
        this.o = typedArray0.getDimensionPixelSize(6, 0);
        m0.t();
    }

    @Override  // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof LayoutParams;
    }

    public final void d(int v, Canvas canvas0) {
        this.k.setBounds(this.getPaddingLeft() + this.o, v, this.getWidth() - this.getPaddingRight() - this.o, this.m + v);
        this.k.draw(canvas0);
    }

    public final void e(int v, Canvas canvas0) {
        this.k.setBounds(v, this.getPaddingTop() + this.o, this.l + v, this.getHeight() - this.getPaddingBottom() - this.o);
        this.k.draw(canvas0);
    }

    public LayoutParams f() {
        int v = this.d;
        if(v == 0) {
            return new LayoutParams(-2, -2);  // 初始化器: Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V
        }
        return v == 1 ? new LayoutParams(-1, -2) : null;  // 初始化器: Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V
    }

    public LayoutParams g(AttributeSet attributeSet0) {
        return new LayoutParams(this.getContext(), attributeSet0);
    }

    @Override  // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.f();
    }

    @Override  // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return this.g(attributeSet0);
    }

    @Override  // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return this.h(viewGroup$LayoutParams0);
    }

    @Override  // android.view.View
    public int getBaseline() {
        if(this.b < 0) {
            return super.getBaseline();
        }
        int v = this.getChildCount();
        int v1 = this.b;
        if(v <= v1) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View view0 = this.getChildAt(v1);
        int v2 = view0.getBaseline();
        if(v2 == -1) {
            if(this.b != 0) {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn\'t know how to get its baseline.");
            }
            return -1;
        }
        int v3 = this.c;
        if(this.d == 1) {
            switch(this.e & 0x70) {
                case 16: {
                    v3 += (this.getBottom() - this.getTop() - this.getPaddingTop() - this.getPaddingBottom() - this.f) / 2;
                    break;
                }
                case 80: {
                    return this.getBottom() - this.getTop() - this.getPaddingBottom() - this.f + ((LayoutParams)view0.getLayoutParams()).topMargin + v2;
                }
                default: {
                    return v3 + ((LayoutParams)view0.getLayoutParams()).topMargin + v2;
                }
            }
        }
        return v3 + ((LayoutParams)view0.getLayoutParams()).topMargin + v2;
    }

    public int getBaselineAlignedChildIndex() {
        return this.b;
    }

    public Drawable getDividerDrawable() {
        return this.k;
    }

    public int getDividerPadding() {
        return this.o;
    }

    public int getDividerWidth() {
        return this.l;
    }

    public int getGravity() {
        return this.e;
    }

    public int getOrientation() {
        return this.d;
    }

    public int getShowDividers() {
        return this.n;
    }

    public int getVirtualChildCount() {
        return this.getChildCount();
    }

    public float getWeightSum() {
        return this.g;
    }

    public LayoutParams h(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(viewGroup$LayoutParams0 instanceof LayoutParams) {
            return new LayoutParams(((LayoutParams)viewGroup$LayoutParams0));  // 初始化器: Landroid/widget/LinearLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V
        }
        return viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams ? new LayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0)) : new LayoutParams(viewGroup$LayoutParams0);  // 初始化器: Landroid/widget/LinearLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V / 初始化器: Landroid/widget/LinearLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V
    }

    public final boolean i(int v) {
        if(v == 0) {
            return (this.n & 1) != 0;
        }
        if(v == this.getChildCount()) {
            return (this.n & 4) != 0;
        }
        if((this.n & 2) != 0) {
            for(int v1 = v - 1; v1 >= 0; --v1) {
                if(this.getChildAt(v1).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override  // android.view.View
    public final void onDraw(Canvas canvas0) {
        int v4;
        int v2;
        int v = 0;
        if(this.k != null) {
            if(this.d == 1) {
                int v1 = this.getVirtualChildCount();
                while(v < v1) {
                    View view0 = this.getChildAt(v);
                    if(view0 != null && view0.getVisibility() != 8 && this.i(v)) {
                        LayoutParams linearLayoutCompat$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                        this.d(view0.getTop() - linearLayoutCompat$LayoutParams0.topMargin - this.m, canvas0);
                    }
                    ++v;
                }
                if(this.i(v1)) {
                    View view1 = this.getChildAt(v1 - 1);
                    if(view1 == null) {
                        v2 = this.getHeight() - this.getPaddingBottom() - this.m;
                    }
                    else {
                        LayoutParams linearLayoutCompat$LayoutParams1 = (LayoutParams)view1.getLayoutParams();
                        v2 = view1.getBottom() + linearLayoutCompat$LayoutParams1.bottomMargin;
                    }
                    this.d(v2, canvas0);
                }
            }
            else {
                int v3 = this.getVirtualChildCount();
                boolean z = this.getLayoutDirection() == 1;
                while(v < v3) {
                    View view2 = this.getChildAt(v);
                    if(view2 != null && view2.getVisibility() != 8 && this.i(v)) {
                        LayoutParams linearLayoutCompat$LayoutParams2 = (LayoutParams)view2.getLayoutParams();
                        this.e((z ? view2.getRight() + linearLayoutCompat$LayoutParams2.rightMargin : view2.getLeft() - linearLayoutCompat$LayoutParams2.leftMargin - this.l), canvas0);
                    }
                    ++v;
                }
                if(this.i(v3)) {
                    View view3 = this.getChildAt(v3 - 1);
                    if(view3 != null) {
                        LayoutParams linearLayoutCompat$LayoutParams3 = (LayoutParams)view3.getLayoutParams();
                        v4 = z ? view3.getLeft() - linearLayoutCompat$LayoutParams3.leftMargin - this.l : view3.getRight() + linearLayoutCompat$LayoutParams3.rightMargin;
                    }
                    else if(z) {
                        v4 = this.getPaddingLeft();
                    }
                    else {
                        v4 = this.getWidth() - this.getPaddingRight() - this.l;
                    }
                    this.e(v4, canvas0);
                }
            }
        }
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        super.onInitializeAccessibilityEvent(accessibilityEvent0);
        accessibilityEvent0.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        accessibilityNodeInfo0.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override  // android.view.ViewGroup
    public void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v32;
        int v31;
        int v30;
        int v27;
        int v24;
        int v23;
        int v22;
        int v14;
        int v10;
        if(this.d == 1) {
            int v4 = this.getPaddingLeft();
            int v5 = v2 - v;
            int v6 = this.getPaddingRight();
            int v7 = this.getPaddingRight();
            int v8 = this.getVirtualChildCount();
            int v9 = 0x800007 & this.e;
            switch(this.e & 0x70) {
                case 16: {
                    v10 = this.getPaddingTop() + (v3 - v1 - this.f) / 2;
                    break;
                }
                case 80: {
                    v10 = this.getPaddingTop() + v3 - v1 - this.f;
                    break;
                }
                default: {
                    v10 = this.getPaddingTop();
                }
            }
            for(int v11 = 0; v11 < v8; ++v11) {
                View view0 = this.getChildAt(v11);
                if(view0 != null && view0.getVisibility() != 8) {
                    int v12 = view0.getMeasuredWidth();
                    int v13 = view0.getMeasuredHeight();
                    LayoutParams linearLayoutCompat$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                    switch(Gravity.getAbsoluteGravity((linearLayoutCompat$LayoutParams0.gravity >= 0 ? linearLayoutCompat$LayoutParams0.gravity : v9), this.getLayoutDirection()) & 7) {
                        case 1: {
                            v14 = (v5 - v4 - v7 - v12) / 2 + v4 + linearLayoutCompat$LayoutParams0.leftMargin - linearLayoutCompat$LayoutParams0.rightMargin;
                            break;
                        }
                        case 5: {
                            v14 = v5 - v6 - v12 - linearLayoutCompat$LayoutParams0.rightMargin;
                            break;
                        }
                        default: {
                            v14 = linearLayoutCompat$LayoutParams0.leftMargin + v4;
                        }
                    }
                    if(this.i(v11)) {
                        v10 += this.m;
                    }
                    int v15 = v10 + linearLayoutCompat$LayoutParams0.topMargin;
                    view0.layout(v14, v15, v12 + v14, v15 + v13);
                    v10 = v13 + linearLayoutCompat$LayoutParams0.bottomMargin + v15;
                }
            }
            return;
        }
        boolean z1 = this.getLayoutDirection() == 1;
        int v16 = this.getPaddingTop();
        int v17 = v3 - v1;
        int v18 = this.getPaddingBottom();
        int v19 = v17 - v16 - this.getPaddingBottom();
        int v20 = this.getVirtualChildCount();
        int v21 = this.e & 0x70;
        boolean z2 = this.a;
        int[] arr_v = this.i;
        int[] arr_v1 = this.j;
        switch(Gravity.getAbsoluteGravity(0x800007 & this.e, this.getLayoutDirection())) {
            case 1: {
                v22 = this.getPaddingLeft() + (v2 - v - this.f) / 2;
                break;
            }
            case 5: {
                v22 = this.getPaddingLeft() + v2 - v - this.f;
                break;
            }
            default: {
                v22 = this.getPaddingLeft();
            }
        }
        if(z1) {
            v23 = v20 - 1;
            v24 = -1;
        }
        else {
            v24 = 1;
            v23 = 0;
        }
        int v25 = 0;
        while(v25 < v20) {
            int v26 = v24 * v25 + v23;
            View view1 = this.getChildAt(v26);
            if(view1 == null) {
                v27 = v23;
            }
            else {
                v27 = v23;
                if(view1.getVisibility() != 8) {
                    int v28 = view1.getMeasuredWidth();
                    int v29 = view1.getMeasuredHeight();
                    LayoutParams linearLayoutCompat$LayoutParams1 = (LayoutParams)view1.getLayoutParams();
                    if(z2) {
                        v30 = v16;
                        if(linearLayoutCompat$LayoutParams1.height != -1) {
                            v31 = view1.getBaseline();
                            goto label_75;
                        }
                    }
                    else {
                        v30 = v16;
                    }
                    v31 = -1;
                label_75:
                    switch((linearLayoutCompat$LayoutParams1.gravity >= 0 ? linearLayoutCompat$LayoutParams1.gravity : v21) & 0x70) {
                        case 16: {
                            v32 = (v19 - v29) / 2 + v30 + linearLayoutCompat$LayoutParams1.topMargin - linearLayoutCompat$LayoutParams1.bottomMargin;
                            break;
                        }
                        case 0x30: {
                            v32 = v30 + linearLayoutCompat$LayoutParams1.topMargin;
                            if(v31 != -1) {
                                v32 = arr_v[1] - v31 + v32;
                            }
                            break;
                        }
                        case 80: {
                            v32 = v17 - v18 - v29 - linearLayoutCompat$LayoutParams1.bottomMargin;
                            if(v31 != -1) {
                                int v33 = view1.getMeasuredHeight();
                                v32 -= arr_v1[2] - (v33 - v31);
                            }
                            break;
                        }
                        default: {
                            v32 = v30;
                        }
                    }
                    int v34 = (this.i(v26) ? v22 + this.l : v22) + linearLayoutCompat$LayoutParams1.leftMargin;
                    view1.layout(v34, v32, v34 + v28, v32 + v29);
                    v22 = v28 + linearLayoutCompat$LayoutParams1.rightMargin + v34;
                    goto label_93;
                }
            }
            v30 = v16;
        label_93:
            ++v25;
            v23 = v27;
            v16 = v30;
        }
    }

    @Override  // android.view.View
    public void onMeasure(int v, int v1) {
        int v87;
        int v85;
        int v89;
        int v75;
        int v71;
        int v67;
        int v64;
        int v63;
        LayoutParams linearLayoutCompat$LayoutParams5;
        int v62;
        View view7;
        int v65;
        boolean z10;
        boolean z9;
        int[] arr_v3;
        int[] arr_v2;
        int v61;
        int v60;
        int v35;
        int v24;
        boolean z4;
        int v16;
        int v15;
        boolean z3;
        int v14;
        int v13;
        View view1;
        int v19;
        int v18;
        int v17;
        int v2 = 0;
        if(this.d == 1) {
            this.f = 0;
            int v3 = this.getVirtualChildCount();
            int v4 = View.MeasureSpec.getMode(v);
            int v5 = View.MeasureSpec.getMode(v1);
            int v6 = this.b;
            boolean z = this.h;
            int v7 = 0;
            int v8 = 0;
            int v9 = 0;
            boolean z1 = false;
            int v10 = 0;
            boolean z2 = false;
            int v11 = 1;
            float f = 0.0f;
            int v12 = 0;
            while(v7 < v3) {
                View view0 = this.getChildAt(v7);
                if(view0 == null) {
                    this.f = this.f;
                }
                else if(view0.getVisibility() != 8) {
                    if(this.i(v7)) {
                        this.f += this.m;
                    }
                    LayoutParams linearLayoutCompat$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                    float f1 = linearLayoutCompat$LayoutParams0.weight;
                    f += f1;
                    if(v5 != 0x40000000 || linearLayoutCompat$LayoutParams0.height != 0 || f1 <= 0.0f) {
                        if(linearLayoutCompat$LayoutParams0.height != 0 || f1 <= 0.0f) {
                            v17 = 0x80000000;
                        }
                        else {
                            linearLayoutCompat$LayoutParams0.height = -2;
                            v17 = 0;
                        }
                        if(f == 0.0f) {
                            v18 = v7;
                            v19 = this.f;
                        }
                        else {
                            v18 = v7;
                            v19 = 0;
                        }
                        v13 = v5;
                        z3 = z;
                        v14 = v6;
                        v15 = v18;
                        v16 = v4;
                        this.measureChildWithMargins(view0, v, 0, v1, v19);
                        if(v17 != 0x80000000) {
                            linearLayoutCompat$LayoutParams0.height = v17;
                        }
                        int v20 = view0.getMeasuredHeight();
                        view1 = view0;
                        this.f = Math.max(this.f, this.f + v20 + linearLayoutCompat$LayoutParams0.topMargin + linearLayoutCompat$LayoutParams0.bottomMargin);
                        if(z3) {
                            v12 = Math.max(v20, v12);
                        }
                    }
                    else {
                        this.f = Math.max(this.f, linearLayoutCompat$LayoutParams0.topMargin + this.f + linearLayoutCompat$LayoutParams0.bottomMargin);
                        view1 = view0;
                        v13 = 0x40000000;
                        v14 = v6;
                        z3 = z;
                        v15 = v7;
                        z1 = true;
                        v16 = v4;
                    }
                    if(v14 >= 0 && v14 == v15 + 1) {
                        this.c = this.f;
                    }
                    if(v15 < v14 && linearLayoutCompat$LayoutParams0.weight > 0.0f) {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won\'t work.  Either remove the weight, or don\'t set mBaselineAlignedChildIndex.");
                    }
                    if(v16 == 0x40000000 || linearLayoutCompat$LayoutParams0.width != -1) {
                        z4 = false;
                    }
                    else {
                        z4 = true;
                        z2 = true;
                    }
                    int v21 = linearLayoutCompat$LayoutParams0.leftMargin + linearLayoutCompat$LayoutParams0.rightMargin;
                    int v22 = view1.getMeasuredWidth() + v21;
                    v2 = Math.max(v2, v22);
                    int v23 = View.combineMeasuredStates(v10, view1.getMeasuredState());
                    if(v11 == 0) {
                        v10 = v23;
                    }
                    else {
                        v10 = v23;
                        if(linearLayoutCompat$LayoutParams0.width == -1) {
                            v24 = 1;
                            goto label_82;
                        }
                    }
                    v24 = 0;
                label_82:
                    if(linearLayoutCompat$LayoutParams0.weight > 0.0f) {
                        if(!z4) {
                            v21 = v22;
                        }
                        v9 = Math.max(v9, v21);
                    }
                    else {
                        if(!z4) {
                            v21 = v22;
                        }
                        v8 = Math.max(v8, v21);
                    }
                    v11 = v24;
                    goto label_97;
                }
                v13 = v5;
                v14 = v6;
                z3 = z;
                v15 = v7;
                v16 = v4;
            label_97:
                v7 = v15 + 1;
                v6 = v14;
                v4 = v16;
                z = z3;
                v5 = v13;
            }
            int v25 = v10;
            if(this.f > 0 && this.i(v3)) {
                this.f += this.m;
            }
            if(z && (v5 == 0x80000000 || v5 == 0)) {
                this.f = 0;
                for(int v26 = 0; v26 < v3; ++v26) {
                    View view2 = this.getChildAt(v26);
                    if(view2 == null) {
                        this.f = this.f;
                    }
                    else if(view2.getVisibility() != 8) {
                        LayoutParams linearLayoutCompat$LayoutParams1 = (LayoutParams)view2.getLayoutParams();
                        this.f = Math.max(this.f, this.f + v12 + linearLayoutCompat$LayoutParams1.topMargin + linearLayoutCompat$LayoutParams1.bottomMargin);
                    }
                }
            }
            int v27 = this.f;
            int v28 = this.getPaddingTop();
            int v29 = this.getPaddingBottom() + v28 + v27;
            this.f = v29;
            int v30 = View.resolveSizeAndState(Math.max(v29, this.getSuggestedMinimumHeight()), v1, 0);
            int v31 = (v30 & 0xFFFFFF) - this.f;
            if(z1 || v31 != 0 && f > 0.0f) {
                float f2 = this.g;
                if(f2 > 0.0f) {
                    f = f2;
                }
                this.f = 0;
                int v33 = v25;
                for(int v34 = 0; v34 < v3; v34 = v35 + 1) {
                    View view4 = this.getChildAt(v34);
                    if(view4.getVisibility() == 8) {
                        v35 = v34;
                    }
                    else {
                        LayoutParams linearLayoutCompat$LayoutParams2 = (LayoutParams)view4.getLayoutParams();
                        float f3 = linearLayoutCompat$LayoutParams2.weight;
                        if(f3 > 0.0f) {
                            int v36 = (int)(((float)v31) * f3 / f);
                            f -= f3;
                            v31 -= v36;
                            int v37 = this.getPaddingLeft();
                            v35 = v34;
                            int v38 = ViewGroup.getChildMeasureSpec(v, this.getPaddingRight() + v37 + linearLayoutCompat$LayoutParams2.leftMargin + linearLayoutCompat$LayoutParams2.rightMargin, linearLayoutCompat$LayoutParams2.width);
                            if(linearLayoutCompat$LayoutParams2.height != 0 || v5 != 0x40000000) {
                                int v39 = view4.getMeasuredHeight() + v36;
                                if(v39 < 0) {
                                    v39 = 0;
                                }
                                view4.measure(v38, View.MeasureSpec.makeMeasureSpec(v39, 0x40000000));
                            }
                            else {
                                if(v36 <= 0) {
                                    v36 = 0;
                                }
                                view4.measure(v38, View.MeasureSpec.makeMeasureSpec(v36, 0x40000000));
                            }
                            v33 = View.combineMeasuredStates(v33, view4.getMeasuredState() & 0xFFFFFF00);
                        }
                        else {
                            v35 = v34;
                        }
                        int v40 = linearLayoutCompat$LayoutParams2.leftMargin + linearLayoutCompat$LayoutParams2.rightMargin;
                        int v41 = view4.getMeasuredWidth() + v40;
                        v2 = Math.max(v2, v41);
                        if(v4 != 0x40000000 && linearLayoutCompat$LayoutParams2.width == -1) {
                            v41 = v40;
                        }
                        v8 = Math.max(v8, v41);
                        int v42 = v11 == 0 || linearLayoutCompat$LayoutParams2.width != -1 ? 0 : 1;
                        int v43 = this.f;
                        this.f = Math.max(v43, view4.getMeasuredHeight() + v43 + linearLayoutCompat$LayoutParams2.topMargin + linearLayoutCompat$LayoutParams2.bottomMargin);
                        v11 = v42;
                    }
                }
                int v44 = this.f;
                int v45 = this.getPaddingTop();
                this.f = this.getPaddingBottom() + v45 + v44;
                v25 = v33;
            }
            else {
                v8 = Math.max(v8, v9);
                if(z && v5 != 0x40000000) {
                    for(int v32 = 0; v32 < v3; ++v32) {
                        View view3 = this.getChildAt(v32);
                        if(view3 != null && view3.getVisibility() != 8 && ((LayoutParams)view3.getLayoutParams()).weight > 0.0f) {
                            view3.measure(View.MeasureSpec.makeMeasureSpec(view3.getMeasuredWidth(), 0x40000000), View.MeasureSpec.makeMeasureSpec(v12, 0x40000000));
                        }
                    }
                }
            }
            if(v11 != 0 || v4 == 0x40000000) {
                v8 = v2;
            }
            int v46 = this.getPaddingLeft();
            this.setMeasuredDimension(View.resolveSizeAndState(Math.max(this.getPaddingRight() + v46 + v8, this.getSuggestedMinimumWidth()), v, v25), v30);
            if(z2) {
                int v47 = View.MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 0x40000000);
                for(int v48 = 0; v48 < v3; ++v48) {
                    View view5 = this.getChildAt(v48);
                    if(view5.getVisibility() != 8) {
                        LayoutParams linearLayoutCompat$LayoutParams3 = (LayoutParams)view5.getLayoutParams();
                        if(linearLayoutCompat$LayoutParams3.width == -1) {
                            int v49 = linearLayoutCompat$LayoutParams3.height;
                            linearLayoutCompat$LayoutParams3.height = view5.getMeasuredHeight();
                            this.measureChildWithMargins(view5, v47, 0, v1, 0);
                            linearLayoutCompat$LayoutParams3.height = v49;
                        }
                    }
                }
            }
        }
        else {
            this.f = 0;
            int v50 = this.getVirtualChildCount();
            int v51 = View.MeasureSpec.getMode(v);
            int v52 = View.MeasureSpec.getMode(v1);
            if(this.i == null || this.j == null) {
                this.i = new int[4];
                this.j = new int[4];
            }
            int[] arr_v = this.i;
            int[] arr_v1 = this.j;
            arr_v[3] = -1;
            arr_v[2] = -1;
            arr_v[1] = -1;
            arr_v[0] = -1;
            arr_v1[3] = -1;
            arr_v1[2] = -1;
            arr_v1[1] = -1;
            arr_v1[0] = -1;
            boolean z5 = this.a;
            boolean z6 = this.h;
            float f4 = 0.0f;
            int v53 = 1;
            int v54 = 0;
            int v55 = 0;
            int v56 = 0;
            int v57 = 0;
            int v58 = 0;
            int v59 = 0;
            boolean z7 = false;
            boolean z8 = false;
            while(v54 < v50) {
                View view6 = this.getChildAt(v54);
                if(view6 == null) {
                    this.f = this.f;
                    v60 = v54;
                    v61 = v56;
                    arr_v2 = arr_v;
                    arr_v3 = arr_v1;
                    z9 = z5;
                    z10 = z6;
                }
                else if(view6.getVisibility() == 8) {
                    v60 = v54;
                    v61 = v56;
                    arr_v3 = arr_v1;
                    z9 = z5;
                    z10 = z6;
                    arr_v2 = arr_v;
                }
                else {
                    if(this.i(v54)) {
                        this.f += this.l;
                    }
                    LayoutParams linearLayoutCompat$LayoutParams4 = (LayoutParams)view6.getLayoutParams();
                    float f5 = linearLayoutCompat$LayoutParams4.weight;
                    f4 += f5;
                    if(v51 != 0x40000000 || linearLayoutCompat$LayoutParams4.width != 0 || f5 <= 0.0f) {
                        if(linearLayoutCompat$LayoutParams4.width != 0 || f5 <= 0.0f) {
                            v65 = 0x80000000;
                        }
                        else {
                            linearLayoutCompat$LayoutParams4.width = -2;
                            v65 = 0;
                        }
                        arr_v3 = arr_v1;
                        v64 = v57;
                        v60 = v54;
                        z9 = z5;
                        z10 = z6;
                        linearLayoutCompat$LayoutParams5 = linearLayoutCompat$LayoutParams4;
                        v62 = v55;
                        arr_v2 = arr_v;
                        v63 = v56;
                        this.measureChildWithMargins(view6, v, (f4 == 0.0f ? this.f : 0), v1, 0);
                        if(v65 != 0x80000000) {
                            linearLayoutCompat$LayoutParams5.width = v65;
                        }
                        int v66 = view6.getMeasuredWidth();
                        if(v51 == 0x40000000) {
                            view7 = view6;
                            this.f = linearLayoutCompat$LayoutParams5.leftMargin + v66 + linearLayoutCompat$LayoutParams5.rightMargin + this.f;
                        }
                        else {
                            view7 = view6;
                            this.f = Math.max(this.f, this.f + v66 + linearLayoutCompat$LayoutParams5.leftMargin + linearLayoutCompat$LayoutParams5.rightMargin);
                        }
                        if(z10) {
                            v58 = Math.max(v66, v58);
                        }
                    }
                    else {
                        this.f = v51 == 0x40000000 ? linearLayoutCompat$LayoutParams4.leftMargin + linearLayoutCompat$LayoutParams4.rightMargin + this.f : Math.max(this.f, linearLayoutCompat$LayoutParams4.leftMargin + this.f + linearLayoutCompat$LayoutParams4.rightMargin);
                        if(z5) {
                            view6.measure(0, 0);
                            view7 = view6;
                            z9 = true;
                            z10 = z6;
                        }
                        else {
                            view7 = view6;
                            z9 = false;
                            z10 = z6;
                            z8 = true;
                        }
                        v62 = v55;
                        v60 = v54;
                        linearLayoutCompat$LayoutParams5 = linearLayoutCompat$LayoutParams4;
                        arr_v2 = arr_v;
                        arr_v3 = arr_v1;
                        v63 = v56;
                        v64 = v57;
                    }
                    if(v52 == 0x40000000 || linearLayoutCompat$LayoutParams5.height != -1) {
                        v67 = 0;
                    }
                    else {
                        v67 = 1;
                        z7 = true;
                    }
                    int v68 = linearLayoutCompat$LayoutParams5.topMargin + linearLayoutCompat$LayoutParams5.bottomMargin;
                    int v69 = view7.getMeasuredHeight() + v68;
                    v59 = View.combineMeasuredStates(v59, view7.getMeasuredState());
                    if(z9) {
                        int v70 = view7.getBaseline();
                        v71 = v67;
                        if(v70 != -1) {
                            int v72 = (((linearLayoutCompat$LayoutParams5.gravity >= 0 ? linearLayoutCompat$LayoutParams5.gravity : this.e) & 0x70) >> 4 & -2) >> 1;
                            arr_v2[v72] = Math.max(arr_v2[v72], v70);
                            arr_v3[v72] = Math.max(arr_v3[v72], v69 - v70);
                        }
                    }
                    else {
                        v71 = v67;
                    }
                    int v73 = Math.max(v62, v69);
                    int v74 = v53 == 0 || linearLayoutCompat$LayoutParams5.height != -1 ? 0 : 1;
                    if(linearLayoutCompat$LayoutParams5.weight > 0.0f) {
                        if(v71 == 0) {
                            v68 = v69;
                        }
                        v57 = Math.max(v64, v68);
                        v75 = v63;
                    }
                    else {
                        if(v71 == 0) {
                            v68 = v69;
                        }
                        v75 = Math.max(v63, v68);
                        v57 = v64;
                    }
                    v55 = v73;
                    v61 = v75;
                    v53 = v74;
                }
                v56 = v61;
                v54 = v60 + 1;
                arr_v = arr_v2;
                arr_v1 = arr_v3;
                z5 = z9;
                z6 = z10;
            }
            int v76 = v56;
            if(this.f > 0 && this.i(v50)) {
                this.f += this.l;
            }
            int v77 = arr_v[1];
            int v78 = v77 != -1 || arr_v[0] != -1 || arr_v[2] != -1 || arr_v[3] != -1 ? Math.max(v55, Math.max(arr_v1[3], Math.max(arr_v1[0], Math.max(arr_v1[1], arr_v1[2]))) + Math.max(arr_v[3], Math.max(arr_v[0], Math.max(v77, arr_v[2])))) : v55;
            if(z6 && (v51 == 0x80000000 || v51 == 0)) {
                this.f = 0;
                for(int v79 = 0; v79 < v50; ++v79) {
                    View view8 = this.getChildAt(v79);
                    if(view8 == null) {
                        this.f = this.f;
                    }
                    else if(view8.getVisibility() != 8) {
                        LayoutParams linearLayoutCompat$LayoutParams6 = (LayoutParams)view8.getLayoutParams();
                        this.f = v51 == 0x40000000 ? linearLayoutCompat$LayoutParams6.leftMargin + v58 + linearLayoutCompat$LayoutParams6.rightMargin + this.f : Math.max(this.f, this.f + v58 + linearLayoutCompat$LayoutParams6.leftMargin + linearLayoutCompat$LayoutParams6.rightMargin);
                    }
                }
            }
            int v80 = this.f;
            int v81 = this.getPaddingLeft();
            int v82 = this.getPaddingRight() + v81 + v80;
            this.f = v82;
            int v83 = View.resolveSizeAndState(Math.max(v82, this.getSuggestedMinimumWidth()), v, 0);
            int v84 = (v83 & 0xFFFFFF) - this.f;
            if(z8 || v84 != 0 && f4 > 0.0f) {
                float f6 = this.g;
                if(f6 > 0.0f) {
                    f4 = f6;
                }
                arr_v[3] = -1;
                arr_v[2] = -1;
                arr_v[1] = -1;
                arr_v[0] = -1;
                arr_v1[3] = -1;
                arr_v1[2] = -1;
                arr_v1[1] = -1;
                arr_v1[0] = -1;
                this.f = 0;
                v78 = -1;
                int v88 = 0;
                while(v88 < v50) {
                    View view10 = this.getChildAt(v88);
                    if(view10 != null && view10.getVisibility() != 8) {
                        LayoutParams linearLayoutCompat$LayoutParams7 = (LayoutParams)view10.getLayoutParams();
                        float f7 = linearLayoutCompat$LayoutParams7.weight;
                        if(f7 > 0.0f) {
                            int v90 = (int)(((float)v84) * f7 / f4);
                            f4 -= f7;
                            v84 -= v90;
                            int v91 = this.getPaddingTop();
                            v89 = v83;
                            int v92 = ViewGroup.getChildMeasureSpec(v1, this.getPaddingBottom() + v91 + linearLayoutCompat$LayoutParams7.topMargin + linearLayoutCompat$LayoutParams7.bottomMargin, linearLayoutCompat$LayoutParams7.height);
                            if(linearLayoutCompat$LayoutParams7.width != 0 || v51 != 0x40000000) {
                                int v93 = view10.getMeasuredWidth() + v90;
                                if(v93 < 0) {
                                    v93 = 0;
                                }
                                view10.measure(View.MeasureSpec.makeMeasureSpec(v93, 0x40000000), v92);
                            }
                            else {
                                if(v90 <= 0) {
                                    v90 = 0;
                                }
                                view10.measure(View.MeasureSpec.makeMeasureSpec(v90, 0x40000000), v92);
                            }
                            v59 = View.combineMeasuredStates(v59, view10.getMeasuredState() & 0xFF000000);
                        }
                        else {
                            v89 = v83;
                        }
                        if(v51 == 0x40000000) {
                            int v94 = this.f;
                            this.f = view10.getMeasuredWidth() + linearLayoutCompat$LayoutParams7.leftMargin + linearLayoutCompat$LayoutParams7.rightMargin + v94;
                        }
                        else {
                            int v95 = this.f;
                            this.f = Math.max(v95, view10.getMeasuredWidth() + v95 + linearLayoutCompat$LayoutParams7.leftMargin + linearLayoutCompat$LayoutParams7.rightMargin);
                        }
                        boolean z11 = v52 != 0x40000000 && linearLayoutCompat$LayoutParams7.height == -1;
                        int v96 = linearLayoutCompat$LayoutParams7.topMargin + linearLayoutCompat$LayoutParams7.bottomMargin;
                        int v97 = view10.getMeasuredHeight() + v96;
                        v78 = Math.max(v78, v97);
                        if(!z11) {
                            v96 = v97;
                        }
                        int v98 = Math.max(v76, v96);
                        int v99 = v53 == 0 || linearLayoutCompat$LayoutParams7.height != -1 ? 0 : 1;
                        if(z5) {
                            int v100 = view10.getBaseline();
                            if(v100 != -1) {
                                int v101 = (((linearLayoutCompat$LayoutParams7.gravity >= 0 ? linearLayoutCompat$LayoutParams7.gravity : this.e) & 0x70) >> 4 & -2) >> 1;
                                arr_v[v101] = Math.max(arr_v[v101], v100);
                                arr_v1[v101] = Math.max(arr_v1[v101], v97 - v100);
                            }
                        }
                        v53 = v99;
                        v76 = v98;
                    }
                    else {
                        v89 = v83;
                    }
                    ++v88;
                    v83 = v89;
                }
                v87 = v83;
                int v102 = this.f;
                int v103 = this.getPaddingLeft();
                this.f = this.getPaddingRight() + v103 + v102;
                int v104 = arr_v[1];
                if(v104 != -1 || arr_v[0] != -1 || arr_v[2] != -1 || arr_v[3] != -1) {
                    v78 = Math.max(v78, Math.max(arr_v1[3], Math.max(arr_v1[0], Math.max(arr_v1[1], arr_v1[2]))) + Math.max(arr_v[3], Math.max(arr_v[0], Math.max(v104, arr_v[2]))));
                }
                v85 = v76;
            }
            else {
                v85 = Math.max(v76, v57);
                if(z6 && v51 != 0x40000000) {
                    for(int v86 = 0; v86 < v50; ++v86) {
                        View view9 = this.getChildAt(v86);
                        if(view9 != null && view9.getVisibility() != 8 && ((LayoutParams)view9.getLayoutParams()).weight > 0.0f) {
                            view9.measure(View.MeasureSpec.makeMeasureSpec(v58, 0x40000000), View.MeasureSpec.makeMeasureSpec(view9.getMeasuredHeight(), 0x40000000));
                        }
                    }
                }
                v87 = v83;
            }
            if(v53 == 0 && v52 != 0x40000000) {
                v78 = v85;
            }
            int v105 = this.getPaddingTop();
            this.setMeasuredDimension(v87 | v59 & 0xFF000000, View.resolveSizeAndState(Math.max(this.getPaddingBottom() + v105 + v78, this.getSuggestedMinimumHeight()), v1, v59 << 16));
            if(z7) {
                int v106 = View.MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 0x40000000);
                for(int v107 = 0; v107 < v50; ++v107) {
                    View view11 = this.getChildAt(v107);
                    if(view11.getVisibility() != 8) {
                        LayoutParams linearLayoutCompat$LayoutParams8 = (LayoutParams)view11.getLayoutParams();
                        if(linearLayoutCompat$LayoutParams8.height == -1) {
                            int v108 = linearLayoutCompat$LayoutParams8.width;
                            linearLayoutCompat$LayoutParams8.width = view11.getMeasuredWidth();
                            this.measureChildWithMargins(view11, v, 0, v106, 0);
                            linearLayoutCompat$LayoutParams8.width = v108;
                        }
                    }
                }
            }
        }
    }

    public void setBaselineAligned(boolean z) {
        this.a = z;
    }

    public void setBaselineAlignedChildIndex(int v) {
        if(v < 0 || v >= this.getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + this.getChildCount() + ")");
        }
        this.b = v;
    }

    public void setDividerDrawable(Drawable drawable0) {
        if(drawable0 == this.k) {
            return;
        }
        this.k = drawable0;
        boolean z = false;
        if(drawable0 == null) {
            this.l = 0;
            this.m = 0;
        }
        else {
            this.l = drawable0.getIntrinsicWidth();
            this.m = drawable0.getIntrinsicHeight();
        }
        if(drawable0 == null) {
            z = true;
        }
        this.setWillNotDraw(z);
        this.requestLayout();
    }

    public void setDividerPadding(int v) {
        this.o = v;
    }

    public void setGravity(int v) {
        if(this.e != v) {
            if((0x800007 & v) == 0) {
                v |= 0x800003;
            }
            if((v & 0x70) == 0) {
                v |= 0x30;
            }
            this.e = v;
            this.requestLayout();
        }
    }

    public void setHorizontalGravity(int v) {
        int v1 = this.e;
        if((0x800007 & v1) != (v & 0x800007)) {
            this.e = v & 0x800007 | 0xFF7FFFF8 & v1;
            this.requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.h = z;
    }

    public void setOrientation(int v) {
        if(this.d != v) {
            this.d = v;
            this.requestLayout();
        }
    }

    public void setShowDividers(int v) {
        if(v != this.n) {
            this.requestLayout();
        }
        this.n = v;
    }

    public void setVerticalGravity(int v) {
        int v1 = this.e;
        if((v1 & 0x70) != (v & 0x70)) {
            this.e = v & 0x70 | v1 & 0xFFFFFF8F;
            this.requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.g = Math.max(0.0f, f);
    }

    @Override  // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}

