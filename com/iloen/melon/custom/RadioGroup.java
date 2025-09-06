package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import androidx.lifecycle.b;
import k8.t1;

public class RadioGroup extends LinearLayout {
    public static class LayoutParams extends LinearLayout.LayoutParams {
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
    public final b b;
    public boolean c;
    public N0 d;
    public final O0 e;

    public RadioGroup(Context context0) {
        super(context0);
        this.a = -1;
        this.c = false;
        this.setOrientation(1);
        this.b = new b(this, 29);
        O0 o00 = new O0(this, 0);
        this.e = o00;
        super.setOnHierarchyChangeListener(o00);
    }

    public RadioGroup(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = -1;
        this.c = false;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.A, 0, 0);
        int v = typedArray0.getResourceId(0, -1);
        if(v != -1) {
            this.a = v;
        }
        typedArray0.recycle();
        this.b = new b(this, 29);
        O0 o00 = new O0(this, 0);
        this.e = o00;
        super.setOnHierarchyChangeListener(o00);
    }

    public final void a(int v) {
        if(v != -1 && v == this.a) {
            return;
        }
        int v1 = this.a;
        if(v1 != -1) {
            this.b(v1, false);
        }
        if(v != -1) {
            this.b(v, true);
        }
        this.setCheckedId(v);
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(view0 instanceof S && ((S)view0).isChecked()) {
            this.c = true;
            int v1 = this.a;
            if(v1 != -1) {
                this.b(v1, false);
            }
            this.c = false;
            this.setCheckedId(view0.getId());
        }
        super.addView(view0, v, viewGroup$LayoutParams0);
    }

    public final void b(int v, boolean z) {
        View view0 = this.findViewById(v);
        if(view0 != null && view0 instanceof S) {
            ((S)view0).setChecked(z);
        }
    }

    public final void c(int v, String s) {
        View view0 = this.findViewById(v);
        if(view0 != null) {
            view0.setContentDescription(s);
        }
    }

    @Override  // android.widget.LinearLayout
    public final boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return viewGroup$LayoutParams0 instanceof LayoutParams;
    }

    @Override  // android.widget.LinearLayout
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.generateDefaultLayoutParams();
    }

    @Override  // android.widget.LinearLayout
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);  // 初始化器: Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V
    }

    @Override  // android.widget.LinearLayout
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return new LayoutParams(this.getContext(), attributeSet0);
    }

    @Override  // android.widget.LinearLayout
    public final LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
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
            this.b(v, true);
            this.c = false;
            this.setCheckedId(this.a);
        }
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        super.onInitializeAccessibilityEvent(accessibilityEvent0);
        accessibilityEvent0.setClassName("com.iloen.melon.custom.RadioGroup");
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        accessibilityNodeInfo0.setClassName("com.iloen.melon.custom.RadioGroup");
    }

    public void setCheckedId(int v) {
        this.a = v;
        N0 n00 = this.d;
        if(n00 != null) {
            n00.onCheckedChanged(this, v);
        }
    }

    @Override  // android.view.View
    public void setClickable(boolean z) {
        for(int v = 0; v < this.getChildCount(); ++v) {
            this.getChildAt(v).setClickable(z);
        }
        super.setClickable(z);
    }

    @Override  // android.view.View
    public void setEnabled(boolean z) {
        for(int v = 0; v < this.getChildCount(); ++v) {
            this.getChildAt(v).setEnabled(z);
        }
        super.setEnabled(z);
    }

    public void setOnCheckedChangeListener(N0 n00) {
        this.d = n00;
    }

    @Override  // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener viewGroup$OnHierarchyChangeListener0) {
        this.e.b = viewGroup$OnHierarchyChangeListener0;
    }
}

