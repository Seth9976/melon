package com.google.android.material.chip;

import B6.f;
import E6.a;
import H4.c;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.internal.B;
import com.google.android.material.internal.FlowLayout;
import com.iloen.melon.custom.O0;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import l6.e;
import l6.g;

public class ChipGroup extends FlowLayout {
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
        }
    }

    public int e;
    public int f;
    public g g;
    public final c h;
    public final int i;
    public final O0 j;

    public ChipGroup(Context context0) {
        this(context0, null);
    }

    public ChipGroup(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040119);  // attr:chipGroupStyle
    }

    public ChipGroup(Context context0, AttributeSet attributeSet0, int v) {
        super(a.a(context0, attributeSet0, v, 0x7F14049B), attributeSet0, v);  // style:Widget.MaterialComponents.ChipGroup
        c c0 = new c();
        this.h = c0;
        O0 o00 = new O0(this, 2);
        this.j = o00;
        TypedArray typedArray0 = B.m(this.getContext(), attributeSet0, d6.a.k, v, 0x7F14049B, new int[0]);  // style:Widget.MaterialComponents.ChipGroup
        int v1 = typedArray0.getDimensionPixelOffset(1, 0);
        this.setChipSpacingHorizontal(typedArray0.getDimensionPixelOffset(2, v1));
        this.setChipSpacingVertical(typedArray0.getDimensionPixelOffset(3, v1));
        this.setSingleLine(typedArray0.getBoolean(5, false));
        this.setSingleSelection(typedArray0.getBoolean(6, false));
        this.setSelectionRequired(typedArray0.getBoolean(4, false));
        this.i = typedArray0.getResourceId(0, -1);
        typedArray0.recycle();
        c0.e = new e(this);
        super.setOnHierarchyChangeListener(o00);
        this.setImportantForAccessibility(1);
    }

    @Override  // com.google.android.material.internal.FlowLayout
    public final boolean a() {
        return this.c;
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return super.checkLayoutParams(viewGroup$LayoutParams0) && viewGroup$LayoutParams0 instanceof LayoutParams;
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);  // 初始化器: Landroid/view/ViewGroup$MarginLayoutParams;-><init>(II)V
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return new LayoutParams(this.getContext(), attributeSet0);
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return new LayoutParams(viewGroup$LayoutParams0);  // 初始化器: Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V
    }

    public int getCheckedChipId() {
        return this.h.g();
    }

    public List getCheckedChipIds() {
        return this.h.d(this);
    }

    public int getChipSpacingHorizontal() {
        return this.e;
    }

    public int getChipSpacingVertical() {
        return this.f;
    }

    private int getVisibleChipCount() {
        int v1 = 0;
        for(int v = 0; v < this.getChildCount(); ++v) {
            if(this.getChildAt(v) instanceof Chip && this.getChildAt(v).getVisibility() == 0) {
                ++v1;
            }
        }
        return v1;
    }

    @Override  // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int v = this.i;
        if(v != -1) {
            c c0 = this.h;
            com.google.android.material.internal.g g0 = (com.google.android.material.internal.g)((HashMap)c0.c).get(v);
            if(g0 != null && c0.a(g0)) {
                c0.h();
            }
        }
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        accessibilityNodeInfo0.setCollectionInfo(((AccessibilityNodeInfo.CollectionInfo)f.d(this.getRowCount(), (this.c ? this.getVisibleChipCount() : -1), (this.h.a ? 1 : 2), false).a));
    }

    public void setChipSpacing(int v) {
        this.setChipSpacingHorizontal(v);
        this.setChipSpacingVertical(v);
    }

    public void setChipSpacingHorizontal(int v) {
        if(this.e != v) {
            this.e = v;
            this.setItemSpacing(v);
            this.requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int v) {
        this.setChipSpacingHorizontal(this.getResources().getDimensionPixelOffset(v));
    }

    public void setChipSpacingResource(int v) {
        this.setChipSpacing(this.getResources().getDimensionPixelOffset(v));
    }

    public void setChipSpacingVertical(int v) {
        if(this.f != v) {
            this.f = v;
            this.setLineSpacing(v);
            this.requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int v) {
        this.setChipSpacingVertical(this.getResources().getDimensionPixelOffset(v));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable0) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable0) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int v) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(l6.f f0) {
        if(f0 == null) {
            this.setOnCheckedStateChangeListener(null);
            return;
        }
        this.setOnCheckedStateChangeListener(new e(this));
    }

    public void setOnCheckedStateChangeListener(g g0) {
        this.g = g0;
    }

    @Override  // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener viewGroup$OnHierarchyChangeListener0) {
        this.j.b = viewGroup$OnHierarchyChangeListener0;
    }

    public void setSelectionRequired(boolean z) {
        this.h.b = z;
    }

    @Deprecated
    public void setShowDividerHorizontal(int v) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int v) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(int v) {
        this.setSingleLine(this.getResources().getBoolean(v));
    }

    @Override  // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
    }

    public void setSingleSelection(int v) {
        this.setSingleSelection(this.getResources().getBoolean(v));
    }

    public void setSingleSelection(boolean z) {
        c c0 = this.h;
        if(c0.a != z) {
            c0.a = z;
            boolean z1 = ((HashSet)c0.d).isEmpty();
            for(Object object0: ((HashMap)c0.c).values()) {
                c0.j(((com.google.android.material.internal.g)object0), false);
            }
            if(!z1) {
                c0.h();
            }
        }
    }
}

