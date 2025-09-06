package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;
import k8.t1;

public class RelativeRadioGroup extends RelativeLayout {
    public static class LayoutParams extends RelativeLayout.LayoutParams {
        public LayoutParams(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
        }

        @Override  // android.view.ViewGroup$LayoutParams
        public final void setBaseAttributes(TypedArray typedArray0, int v, int v1) {
            this.width = typedArray0.hasValue(v) ? typedArray0.getLayoutDimension(v, "layout_width") : -2;
            if(typedArray0.hasValue(v1)) {
                this.height = typedArray0.getLayoutDimension(v1, "layout_height");
                return;
            }
            this.height = -2;
        }
    }

    public int a;
    public final S0 b;
    public boolean c;
    public final O0 d;

    public RelativeRadioGroup(Context context0) {
        super(context0);
        this.a = -1;
        this.c = false;
        this.b = new S0(this, 0);
        O0 o00 = new O0(this, 1);
        this.d = o00;
        super.setOnHierarchyChangeListener(o00);
    }

    public RelativeRadioGroup(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = -1;
        this.c = false;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.A, 0, 0);
        int v = typedArray0.getResourceId(0, -1);
        if(v != -1) {
            this.a = v;
        }
        typedArray0.recycle();
        this.b = new S0(this, 0);
        O0 o00 = new O0(this, 1);
        this.d = o00;
        super.setOnHierarchyChangeListener(o00);
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(view0 instanceof S && ((S)view0).isChecked()) {
            this.c = true;
            int v1 = this.a;
            if(v1 != -1) {
                View view1 = this.findViewById(v1);
                if(view1 != null && view1 instanceof S) {
                    ((S)view1).setChecked(false);
                }
            }
            this.c = false;
            this.setCheckedId(view0.getId());
        }
        super.addView(view0, v, viewGroup$LayoutParams0);
    }

    @Override  // android.widget.RelativeLayout
    public final boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof LayoutParams;
    }

    @Override  // android.widget.RelativeLayout
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);  // 初始化器: Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V
    }

    @Override  // android.widget.RelativeLayout
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return new LayoutParams(this.getContext(), attributeSet0);
    }

    @Override  // android.widget.RelativeLayout
    public final RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return new LayoutParams(this.getContext(), attributeSet0);
    }

    public int getCheckedRadioButtonId() {
        return this.a;
    }

    @Override  // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int v = this.a;
        if(v != -1) {
            this.c = true;
            View view0 = this.findViewById(v);
            if(view0 != null && view0 instanceof S) {
                ((S)view0).setChecked(true);
            }
            this.c = false;
            this.setCheckedId(this.a);
        }
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        super.onInitializeAccessibilityEvent(accessibilityEvent0);
        accessibilityEvent0.setClassName("com.iloen.melon.custom.RelativeRadioGroup");
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        accessibilityNodeInfo0.setClassName("com.iloen.melon.custom.RelativeRadioGroup");
    }

    public void setCheckedId(int v) {
        this.a = v;
    }

    @Override  // android.view.View
    public void setClickable(boolean z) {
        for(int v = 0; v < this.getChildCount(); ++v) {
            this.getChildAt(v).setClickable(z);
        }
        super.setClickable(z);
    }

    public void setOnCheckedChangeListener(T0 t00) {
    }

    @Override  // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener viewGroup$OnHierarchyChangeListener0) {
        this.d.b = viewGroup$OnHierarchyChangeListener0;
    }
}

