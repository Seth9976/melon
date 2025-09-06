package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.Layout.Alignment;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.B;
import d5.w;
import e1.n;
import java.util.Iterator;
import java.util.LinkedHashSet;
import z6.m;
import z6.o;
import z6.y;

public class MaterialButton extends AppCompatButton implements Checkable, y {
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator CREATOR;
        public boolean c;

        static {
            SavedState.CREATOR = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public SavedState(Parcel parcel0, ClassLoader classLoader0) {
            super(parcel0, classLoader0);
            if(classLoader0 == null) {
                this.getClass().getClassLoader();
            }
            this.c = parcel0.readInt() == 1;
        }

        @Override  // androidx.customview.view.AbsSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeInt(((int)this.c));
        }
    }

    public static final int[] B;
    public static final int[] D;
    public final c d;
    public final LinkedHashSet e;
    public a f;
    public PorterDuff.Mode g;
    public ColorStateList h;
    public Drawable i;
    public String j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public boolean r;
    public int w;

    static {
        MaterialButton.B = new int[]{0x101009F};
        MaterialButton.D = new int[]{0x10100A0};
    }

    public MaterialButton(Context context0) {
        this(context0, null);
    }

    public MaterialButton(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F0403F3);  // attr:materialButtonStyle
    }

    public MaterialButton(Context context0, AttributeSet attributeSet0, int v) {
        super(E6.a.a(context0, attributeSet0, v, 0x7F140489), attributeSet0, v);  // style:Widget.MaterialComponents.Button
        this.e = new LinkedHashSet();
        boolean z = false;
        this.o = false;
        this.r = false;
        Context context1 = this.getContext();
        TypedArray typedArray0 = B.m(context1, attributeSet0, d6.a.A, v, 0x7F140489, new int[0]);  // style:Widget.MaterialComponents.Button
        this.n = typedArray0.getDimensionPixelSize(12, 0);
        int v1 = typedArray0.getInt(15, -1);
        PorterDuff.Mode porterDuff$Mode0 = PorterDuff.Mode.SRC_IN;
        this.g = B.o(v1, porterDuff$Mode0);
        this.h = n.r(this.getContext(), typedArray0, 14);
        this.i = n.u(this.getContext(), typedArray0, 10);
        this.w = typedArray0.getInteger(11, 1);
        this.k = typedArray0.getDimensionPixelSize(13, 0);
        c c0 = new c(this, o.d(context1, attributeSet0, v, 0x7F140489).a());  // style:Widget.MaterialComponents.Button
        this.d = c0;
        c0.c = typedArray0.getDimensionPixelOffset(1, 0);
        c0.d = typedArray0.getDimensionPixelOffset(2, 0);
        c0.e = typedArray0.getDimensionPixelOffset(3, 0);
        c0.f = typedArray0.getDimensionPixelOffset(4, 0);
        if(typedArray0.hasValue(8)) {
            int v2 = typedArray0.getDimensionPixelSize(8, -1);
            c0.g = v2;
            m m0 = c0.b.g();
            m0.c(((float)v2));
            c0.c(m0.a());
            c0.p = true;
        }
        c0.h = typedArray0.getDimensionPixelSize(20, 0);
        c0.i = B.o(typedArray0.getInt(7, -1), porterDuff$Mode0);
        c0.j = n.r(this.getContext(), typedArray0, 6);
        c0.k = n.r(this.getContext(), typedArray0, 19);
        c0.l = n.r(this.getContext(), typedArray0, 16);
        c0.q = typedArray0.getBoolean(5, false);
        c0.t = typedArray0.getDimensionPixelSize(9, 0);
        c0.r = typedArray0.getBoolean(21, true);
        int v3 = this.getPaddingStart();
        int v4 = this.getPaddingTop();
        int v5 = this.getPaddingEnd();
        int v6 = this.getPaddingBottom();
        if(typedArray0.hasValue(0)) {
            c0.o = true;
            this.setSupportBackgroundTintList(c0.j);
            this.setSupportBackgroundTintMode(c0.i);
        }
        else {
            c0.e();
        }
        this.setPaddingRelative(v3 + c0.c, v4 + c0.e, v5 + c0.d, v6 + c0.f);
        typedArray0.recycle();
        this.setCompoundDrawablePadding(this.n);
        if(this.i != null) {
            z = true;
        }
        this.c(z);
    }

    public final boolean a() {
        return this.d != null && !this.d.o;
    }

    public final void b() {
        switch(this.w) {
            case 1: 
            case 2: {
                this.setCompoundDrawablesRelative(this.i, null, null, null);
                return;
            }
            case 3: 
            case 4: {
                this.setCompoundDrawablesRelative(null, null, this.i, null);
                return;
            }
            case 16: 
            case 0x20: {
                this.setCompoundDrawablesRelative(null, this.i, null, null);
            }
        }
    }

    public final void c(boolean z) {
        Drawable drawable0 = this.i;
        if(drawable0 != null) {
            Drawable drawable1 = drawable0.mutate();
            this.i = drawable1;
            drawable1.setTintList(this.h);
            PorterDuff.Mode porterDuff$Mode0 = this.g;
            if(porterDuff$Mode0 != null) {
                this.i.setTintMode(porterDuff$Mode0);
            }
            int v = this.k == 0 ? this.i.getIntrinsicWidth() : this.k;
            int v1 = this.k == 0 ? this.i.getIntrinsicHeight() : this.k;
            this.i.setBounds(this.l, this.m, v + this.l, v1 + this.m);
            this.i.setVisible(true, z);
        }
        if(z) {
            this.b();
            return;
        }
        Drawable[] arr_drawable = this.getCompoundDrawablesRelative();
        Drawable drawable2 = arr_drawable[0];
        Drawable drawable3 = arr_drawable[1];
        int v2 = this.w;
        if((v2 != 1 && v2 != 2 || drawable2 == this.i) && (v2 != 3 && v2 != 4 || arr_drawable[2] == this.i)) {
            if(v2 != 16 && v2 != 0x20) {
                return;
            }
            if(drawable3 == this.i) {
                return;
            }
        }
        this.b();
    }

    public final void d(int v, int v1) {
        if(this.i != null && this.getLayout() != null) {
            int v2 = this.w;
            int v3 = 1;
            if(v2 == 1 || v2 == 2 || (v2 == 3 || v2 == 4)) {
                this.m = 0;
                Layout.Alignment layout$Alignment0 = this.getActualTextAlignment();
                int v6 = this.w;
                switch(v6) {
                    case 2: {
                        if(layout$Alignment0 == Layout.Alignment.ALIGN_NORMAL) {
                            this.l = 0;
                            this.c(false);
                        }
                        else {
                        label_26:
                            if(v6 == 4 && layout$Alignment0 == Layout.Alignment.ALIGN_OPPOSITE) {
                                this.l = 0;
                                this.c(false);
                                return;
                            }
                            int v7 = this.k == 0 ? this.i.getIntrinsicWidth() : this.k;
                            int v8 = v - this.getTextLayoutWidth() - this.getPaddingEnd() - v7 - this.n - this.getPaddingStart();
                            if(layout$Alignment0 == Layout.Alignment.ALIGN_CENTER) {
                                v8 /= 2;
                            }
                            int v9 = this.getLayoutDirection() == 1 ? 1 : 0;
                            if(this.w != 4) {
                                v3 = 0;
                            }
                            if(v9 != v3) {
                                v8 = -v8;
                            }
                            if(this.l != v8) {
                                this.l = v8;
                                this.c(false);
                                return;
                            }
                        }
                        break;
                    }
                    case 1: 
                    case 3: {
                        this.l = 0;
                        this.c(false);
                        return;
                    }
                    default: {
                        goto label_26;
                    }
                }
            }
            else {
                if(v2 != 16 && v2 != 0x20) {
                    return;
                }
                this.l = 0;
                if(v2 == 16) {
                    this.m = 0;
                    this.c(false);
                    return;
                }
                int v4 = this.k == 0 ? this.i.getIntrinsicHeight() : this.k;
                int v5 = Math.max(0, (v1 - this.getTextHeight() - this.getPaddingTop() - v4 - this.n - this.getPaddingBottom()) / 2);
                if(this.m != v5) {
                    this.m = v5;
                    this.c(false);
                }
            }
        }
    }

    // 去混淆评级： 低(20)
    public String getA11yClassName() {
        if(!TextUtils.isEmpty(this.j)) {
            return this.j;
        }
        return this.d == null || !this.d.q ? "android.widget.Button" : "android.widget.CompoundButton";
    }

    private Layout.Alignment getActualTextAlignment() {
        switch(this.getTextAlignment()) {
            case 1: {
                return this.getGravityTextAlignment();
            }
            case 4: {
                return Layout.Alignment.ALIGN_CENTER;
            }
            case 3: 
            case 6: {
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            default: {
                return Layout.Alignment.ALIGN_NORMAL;
            }
        }
    }

    @Override  // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.getSupportBackgroundTintList();
    }

    @Override  // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.getSupportBackgroundTintMode();
    }

    // 去混淆评级： 低(20)
    public int getCornerRadius() {
        return this.a() ? this.d.g : 0;
    }

    private Layout.Alignment getGravityTextAlignment() {
        switch(this.getGravity() & 0x800007) {
            case 1: {
                return Layout.Alignment.ALIGN_CENTER;
            }
            case 5: 
            case 0x800005: {
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            default: {
                return Layout.Alignment.ALIGN_NORMAL;
            }
        }
    }

    public Drawable getIcon() {
        return this.i;
    }

    public int getIconGravity() {
        return this.w;
    }

    public int getIconPadding() {
        return this.n;
    }

    public int getIconSize() {
        return this.k;
    }

    public ColorStateList getIconTint() {
        return this.h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.g;
    }

    public int getInsetBottom() {
        return this.d.f;
    }

    public int getInsetTop() {
        return this.d.e;
    }

    // 去混淆评级： 低(20)
    public ColorStateList getRippleColor() {
        return this.a() ? this.d.l : null;
    }

    public o getShapeAppearanceModel() {
        if(!this.a()) {
            throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
        }
        return this.d.b;
    }

    // 去混淆评级： 低(20)
    public ColorStateList getStrokeColor() {
        return this.a() ? this.d.k : null;
    }

    // 去混淆评级： 低(20)
    public int getStrokeWidth() {
        return this.a() ? this.d.h : 0;
    }

    // 去混淆评级： 低(20)
    @Override  // androidx.appcompat.widget.AppCompatButton
    public ColorStateList getSupportBackgroundTintList() {
        return this.a() ? this.d.j : super.getSupportBackgroundTintList();
    }

    // 去混淆评级： 低(20)
    @Override  // androidx.appcompat.widget.AppCompatButton
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.a() ? this.d.i : super.getSupportBackgroundTintMode();
    }

    private int getTextHeight() {
        if(this.getLineCount() > 1) {
            return this.getLayout().getHeight();
        }
        TextPaint textPaint0 = this.getPaint();
        String s = this.getText().toString();
        if(this.getTransformationMethod() != null) {
            s = this.getTransformationMethod().getTransformation(s, this).toString();
        }
        Rect rect0 = new Rect();
        textPaint0.getTextBounds(s, 0, s.length(), rect0);
        return Math.min(rect0.height(), this.getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int v = this.getLineCount();
        float f = 0.0f;
        for(int v1 = 0; v1 < v; ++v1) {
            f = Math.max(f, this.getLayout().getLineWidth(v1));
        }
        return (int)Math.ceil(f);
    }

    @Override  // android.widget.Checkable
    public final boolean isChecked() {
        return this.o;
    }

    @Override  // android.widget.TextView
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(this.a()) {
            d5.n.A(this, this.d.b(false));
        }
    }

    @Override  // android.widget.TextView
    public final int[] onCreateDrawableState(int v) {
        int[] arr_v = super.onCreateDrawableState(v + 2);
        if(this.d != null && this.d.q) {
            View.mergeDrawableStates(arr_v, MaterialButton.B);
        }
        if(this.o) {
            View.mergeDrawableStates(arr_v, MaterialButton.D);
        }
        return arr_v;
    }

    @Override  // androidx.appcompat.widget.AppCompatButton
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        super.onInitializeAccessibilityEvent(accessibilityEvent0);
        accessibilityEvent0.setClassName(this.getA11yClassName());
        accessibilityEvent0.setChecked(this.o);
    }

    @Override  // androidx.appcompat.widget.AppCompatButton
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        accessibilityNodeInfo0.setClassName(this.getA11yClassName());
        accessibilityNodeInfo0.setCheckable(this.d != null && this.d.q);
        accessibilityNodeInfo0.setChecked(this.o);
        accessibilityNodeInfo0.setClickable(this.isClickable());
    }

    @Override  // androidx.appcompat.widget.AppCompatButton
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        this.d(this.getMeasuredWidth(), this.getMeasuredHeight());
    }

    @Override  // android.widget.TextView
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((SavedState)parcelable0).a);
        this.setChecked(((SavedState)parcelable0).c);
    }

    @Override  // android.widget.TextView
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroidx/customview/view/AbsSavedState;-><init>(Landroid/os/Parcelable;)V
        parcelable0.c = this.o;
        return parcelable0;
    }

    @Override  // androidx.appcompat.widget.AppCompatButton
    public final void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        super.onTextChanged(charSequence0, v, v1, v2);
        this.d(this.getMeasuredWidth(), this.getMeasuredHeight());
    }

    @Override  // android.view.View
    public final boolean performClick() {
        if(this.d.r) {
            this.toggle();
        }
        return super.performClick();
    }

    @Override  // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if(this.i != null) {
            int[] arr_v = this.getDrawableState();
            if(this.i.setState(arr_v)) {
                this.invalidate();
            }
        }
    }

    public void setA11yClassName(String s) {
        this.j = s;
    }

    @Override  // android.view.View
    public void setBackground(Drawable drawable0) {
        this.setBackgroundDrawable(drawable0);
    }

    @Override  // android.view.View
    public void setBackgroundColor(int v) {
        if(this.a()) {
            c c0 = this.d;
            if(c0.b(false) != null) {
                c0.b(false).setTint(v);
            }
            return;
        }
        super.setBackgroundColor(v);
    }

    @Override  // androidx.appcompat.widget.AppCompatButton
    public void setBackgroundDrawable(Drawable drawable0) {
        if(this.a()) {
            if(drawable0 != this.getBackground()) {
                Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
                this.d.o = true;
                this.d.a.setSupportBackgroundTintList(this.d.j);
                this.d.a.setSupportBackgroundTintMode(this.d.i);
                super.setBackgroundDrawable(drawable0);
                return;
            }
            this.getBackground().setState(drawable0.getState());
            return;
        }
        super.setBackgroundDrawable(drawable0);
    }

    @Override  // androidx.appcompat.widget.AppCompatButton
    public void setBackgroundResource(int v) {
        this.setBackgroundDrawable((v == 0 ? null : w.B(this.getContext(), v)));
    }

    @Override  // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList0) {
        this.setSupportBackgroundTintList(colorStateList0);
    }

    @Override  // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode porterDuff$Mode0) {
        this.setSupportBackgroundTintMode(porterDuff$Mode0);
    }

    public void setCheckable(boolean z) {
        if(this.a()) {
            this.d.q = z;
        }
    }

    @Override  // android.widget.Checkable
    public void setChecked(boolean z) {
        if(this.d != null && this.d.q && this.isEnabled() && this.o != z) {
            this.o = z;
            this.refreshDrawableState();
            if(this.getParent() instanceof MaterialButtonToggleGroup) {
                MaterialButtonToggleGroup materialButtonToggleGroup0 = (MaterialButtonToggleGroup)this.getParent();
                boolean z1 = this.o;
                if(!materialButtonToggleGroup0.f) {
                    materialButtonToggleGroup0.b(this.getId(), z1);
                }
            }
            if(!this.r) {
                this.r = true;
                Iterator iterator0 = this.e.iterator();
                if(iterator0.hasNext()) {
                    throw H0.b.b(iterator0);
                }
                this.r = false;
            }
        }
    }

    public void setCornerRadius(int v) {
        if(this.a()) {
            c c0 = this.d;
            if(!c0.p || c0.g != v) {
                c0.g = v;
                c0.p = true;
                m m0 = c0.b.g();
                m0.c(((float)v));
                c0.c(m0.a());
            }
        }
    }

    public void setCornerRadiusResource(int v) {
        if(this.a()) {
            this.setCornerRadius(this.getResources().getDimensionPixelSize(v));
        }
    }

    @Override  // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        if(this.a()) {
            this.d.b(false).l(f);
        }
    }

    public void setIcon(Drawable drawable0) {
        if(this.i != drawable0) {
            this.i = drawable0;
            this.c(true);
            this.d(this.getMeasuredWidth(), this.getMeasuredHeight());
        }
    }

    public void setIconGravity(int v) {
        if(this.w != v) {
            this.w = v;
            this.d(this.getMeasuredWidth(), this.getMeasuredHeight());
        }
    }

    public void setIconPadding(int v) {
        if(this.n != v) {
            this.n = v;
            this.setCompoundDrawablePadding(v);
        }
    }

    public void setIconResource(int v) {
        this.setIcon((v == 0 ? null : w.B(this.getContext(), v)));
    }

    public void setIconSize(int v) {
        if(v < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if(this.k != v) {
            this.k = v;
            this.c(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList0) {
        if(this.h != colorStateList0) {
            this.h = colorStateList0;
            this.c(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode porterDuff$Mode0) {
        if(this.g != porterDuff$Mode0) {
            this.g = porterDuff$Mode0;
            this.c(false);
        }
    }

    public void setIconTintResource(int v) {
        this.setIconTint(P1.c.getColorStateList(this.getContext(), v));
    }

    public void setInsetBottom(int v) {
        this.d.d(this.d.e, v);
    }

    public void setInsetTop(int v) {
        this.d.d(v, this.d.f);
    }

    public void setInternalBackground(Drawable drawable0) {
        super.setBackgroundDrawable(drawable0);
    }

    public void setOnPressedChangeListenerInternal(a a0) {
        this.f = a0;
    }

    @Override  // android.view.View
    public void setPressed(boolean z) {
        a a0 = this.f;
        if(a0 != null) {
            ((MaterialButtonToggleGroup)((androidx.lifecycle.b)a0).b).invalidate();
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList0) {
        if(this.a()) {
            c c0 = this.d;
            MaterialButton materialButton0 = c0.a;
            if(c0.l != colorStateList0) {
                c0.l = colorStateList0;
                if(materialButton0.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable)materialButton0.getBackground()).setColor(x6.a.c(colorStateList0));
                }
            }
        }
    }

    public void setRippleColorResource(int v) {
        if(this.a()) {
            this.setRippleColor(P1.c.getColorStateList(this.getContext(), v));
        }
    }

    @Override  // z6.y
    public void setShapeAppearanceModel(o o0) {
        if(!this.a()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.d.c(o0);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if(this.a()) {
            this.d.n = z;
            this.d.f();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList0) {
        if(this.a()) {
            c c0 = this.d;
            if(c0.k != colorStateList0) {
                c0.k = colorStateList0;
                c0.f();
            }
        }
    }

    public void setStrokeColorResource(int v) {
        if(this.a()) {
            this.setStrokeColor(P1.c.getColorStateList(this.getContext(), v));
        }
    }

    public void setStrokeWidth(int v) {
        if(this.a()) {
            c c0 = this.d;
            if(c0.h != v) {
                c0.h = v;
                c0.f();
            }
        }
    }

    public void setStrokeWidthResource(int v) {
        if(this.a()) {
            this.setStrokeWidth(this.getResources().getDimensionPixelSize(v));
        }
    }

    @Override  // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintList(ColorStateList colorStateList0) {
        if(this.a()) {
            c c0 = this.d;
            if(c0.j != colorStateList0) {
                c0.j = colorStateList0;
                if(c0.b(false) != null) {
                    c0.b(false).setTintList(c0.j);
                }
            }
            return;
        }
        super.setSupportBackgroundTintList(colorStateList0);
    }

    @Override  // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintMode(PorterDuff.Mode porterDuff$Mode0) {
        if(this.a()) {
            c c0 = this.d;
            if(c0.i != porterDuff$Mode0) {
                c0.i = porterDuff$Mode0;
                if(c0.b(false) != null && c0.i != null) {
                    c0.b(false).setTintMode(c0.i);
                }
            }
            return;
        }
        super.setSupportBackgroundTintMode(porterDuff$Mode0);
    }

    @Override  // android.view.View
    public void setTextAlignment(int v) {
        super.setTextAlignment(v);
        this.d(this.getMeasuredWidth(), this.getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z) {
        this.d.r = z;
    }

    @Override  // android.widget.Checkable
    public final void toggle() {
        this.setChecked(!this.o);
    }
}

