package com.google.android.material.checkbox;

import A6.h;
import O4.b;
import O4.d;
import O4.e;
import O4.f;
import U4.x;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton.OnCheckedChangeListener;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.google.android.material.internal.B;
import d5.m;
import d5.w;
import e1.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import v6.c;

public class MaterialCheckBox extends AppCompatCheckBox {
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR;
        public int a;

        static {
            SavedState.CREATOR = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        @Override
        public final String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("MaterialCheckBox.SavedState{");
            stringBuilder0.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder0.append(" CheckedState=");
            switch(this.a) {
                case 1: {
                    return x.m(stringBuilder0, "checked", "}");
                }
                case 2: {
                    return x.m(stringBuilder0, "indeterminate", "}");
                }
                default: {
                    return x.m(stringBuilder0, "unchecked", "}");
                }
            }
        }

        @Override  // android.view.View$BaseSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeValue(this.a);
        }
    }

    public int B;
    public int[] D;
    public boolean E;
    public CharSequence G;
    public CompoundButton.OnCheckedChangeListener I;
    public final f M;
    public final c N;
    public static final int[] S;
    public static final int[] T;
    public static final int[][] V;
    public static final int W;
    public final LinkedHashSet e;
    public final LinkedHashSet f;
    public ColorStateList g;
    public boolean h;
    public boolean i;
    public boolean j;
    public CharSequence k;
    public Drawable l;
    public Drawable m;
    public boolean n;
    public ColorStateList o;
    public ColorStateList r;
    public PorterDuff.Mode w;

    static {
        MaterialCheckBox.S = new int[]{0x7F0405A0};  // attr:state_indeterminate
        MaterialCheckBox.T = new int[]{0x7F04059F};  // attr:state_error
        MaterialCheckBox.V = new int[][]{new int[]{0x101009E, 0x7F04059F}, new int[]{0x101009E, 0x10100A0}, new int[]{0x101009E, 0xFEFEFF60}, new int[]{0xFEFEFF62, 0x10100A0}, new int[]{0xFEFEFF62, 0xFEFEFF60}};  // attr:state_error
        MaterialCheckBox.W = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    }

    public MaterialCheckBox(Context context0) {
        this(context0, null);
    }

    public MaterialCheckBox(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040107);  // attr:checkboxStyle
    }

    public MaterialCheckBox(Context context0, AttributeSet attributeSet0, int v) {
        super(E6.a.a(context0, attributeSet0, v, 0x7F1404A1), attributeSet0, v);  // style:Widget.MaterialComponents.CompoundButton.CheckBox
        this.e = new LinkedHashSet();
        this.f = new LinkedHashSet();
        Context context1 = this.getContext();
        f f0 = new f(context1, 0);
        Drawable drawable0 = context1.getResources().getDrawable(0x7F08075E, context1.getTheme());  // drawable:mtrl_checkbox_button_checked_unchecked
        f0.a = drawable0;
        drawable0.setCallback(f0.f);
        new e(f0.a.getConstantState());
        this.M = f0;
        this.N = new c(this, 2);
        Context context2 = this.getContext();
        this.l = this.getButtonDrawable();
        this.o = this.getSuperButtonTintList();
        this.setSupportButtonTintList(null);
        m m0 = B.n(context2, attributeSet0, d6.a.F, v, 0x7F1404A1, new int[0]);  // style:Widget.MaterialComponents.CompoundButton.CheckBox
        TypedArray typedArray0 = (TypedArray)m0.c;
        this.m = m0.k(2);
        if(this.l != null && e1.m.z(context2, 0x7F040328, false)) {  // attr:isMaterial3Theme
            int v1 = typedArray0.getResourceId(0, 0);
            int v2 = typedArray0.getResourceId(1, 0);
            if(v1 == MaterialCheckBox.W && v2 == 0) {
                super.setButtonDrawable(null);
                this.l = w.B(context2, 0x7F08075D);  // drawable:mtrl_checkbox_button
                this.n = true;
                if(this.m == null) {
                    this.m = w.B(context2, 0x7F08075F);  // drawable:mtrl_checkbox_button_icon
                }
            }
        }
        this.r = n.s(context2, m0, 3);
        this.w = B.o(typedArray0.getInt(4, -1), PorterDuff.Mode.SRC_IN);
        this.h = typedArray0.getBoolean(10, false);
        this.i = typedArray0.getBoolean(6, true);
        this.j = typedArray0.getBoolean(9, false);
        this.k = typedArray0.getText(8);
        if(typedArray0.hasValue(7)) {
            this.setCheckedState(typedArray0.getInt(7, 0));
        }
        m0.t();
        this.a();
    }

    public final void a() {
        this.l = e2.a.x(this.l, this.o, this.getButtonTintMode());
        this.m = e2.a.x(this.m, this.r, this.w);
        if(this.n) {
            f f0 = this.M;
            if(f0 != null) {
                d d0 = f0.b;
                Drawable drawable0 = f0.a;
                c c0 = this.N;
                if(drawable0 != null) {
                    if(c0.a == null) {
                        c0.a = new b(c0);
                    }
                    ((AnimatedVectorDrawable)drawable0).unregisterAnimationCallback(c0.a);
                }
                ArrayList arrayList0 = f0.e;
                if(arrayList0 != null && c0 != null) {
                    arrayList0.remove(c0);
                    if(f0.e.size() == 0) {
                        h h0 = f0.d;
                        if(h0 != null) {
                            d0.b.removeListener(h0);
                            f0.d = null;
                        }
                    }
                }
                Drawable drawable1 = f0.a;
                if(drawable1 != null) {
                    if(c0.a == null) {
                        c0.a = new b(c0);
                    }
                    ((AnimatedVectorDrawable)drawable1).registerAnimationCallback(c0.a);
                }
                else if(c0 != null) {
                    if(f0.e == null) {
                        f0.e = new ArrayList();
                    }
                    if(!f0.e.contains(c0)) {
                        f0.e.add(c0);
                        if(f0.d == null) {
                            f0.d = new h(f0, 4);
                        }
                        d0.b.addListener(f0.d);
                    }
                }
            }
            Drawable drawable2 = this.l;
            if(drawable2 instanceof AnimatedStateListDrawable && f0 != null) {
                ((AnimatedStateListDrawable)drawable2).addTransition(0x7F0A025F, 0x7F0A0D68, f0, false);  // id:checked
                ((AnimatedStateListDrawable)this.l).addTransition(0x7F0A0571, 0x7F0A0D68, f0, false);  // id:indeterminate
            }
        }
        Drawable drawable3 = this.l;
        if(drawable3 != null) {
            ColorStateList colorStateList0 = this.o;
            if(colorStateList0 != null) {
                drawable3.setTintList(colorStateList0);
            }
        }
        Drawable drawable4 = this.m;
        if(drawable4 != null) {
            ColorStateList colorStateList1 = this.r;
            if(colorStateList1 != null) {
                drawable4.setTintList(colorStateList1);
            }
        }
        super.setButtonDrawable(e2.a.v(this.l, this.m, -1, -1));
        this.refreshDrawableState();
    }

    @Override  // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.l;
    }

    public Drawable getButtonIconDrawable() {
        return this.m;
    }

    public ColorStateList getButtonIconTintList() {
        return this.r;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.w;
    }

    private String getButtonStateDescription() {
        int v = this.B;
        if(v == 1) {
            return "Checked";
        }
        return v == 0 ? "Not checked" : "Partially checked";
    }

    @Override  // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.o;
    }

    public int getCheckedState() {
        return this.B;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.k;
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if(this.g == null) {
            int v = n.q(this, 0x7F040166);  // attr:colorControlActivated
            int v1 = n.q(this, 0x7F040169);  // attr:colorError
            int v2 = n.q(this, 0x7F040190);  // attr:colorSurface
            int v3 = n.q(this, 0x7F040179);  // attr:colorOnSurface
            int[] arr_v = {n.A(1.0f, v2, v1), n.A(1.0f, v2, v), n.A(0.54f, v2, v3), n.A(0.38f, v2, v3), n.A(0.38f, v2, v3)};
            this.g = new ColorStateList(MaterialCheckBox.V, arr_v);
        }
        return this.g;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList0 = this.o;
        if(colorStateList0 != null) {
            return colorStateList0;
        }
        return super.getButtonTintList() == null ? this.getSupportButtonTintList() : super.getButtonTintList();
    }

    @Override  // android.widget.CompoundButton
    public final boolean isChecked() {
        return this.B == 1;
    }

    @Override  // android.widget.TextView
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(this.h && this.o == null && this.r == null) {
            this.setUseMaterialThemeColors(true);
        }
    }

    @Override  // android.widget.CompoundButton
    public final int[] onCreateDrawableState(int v) {
        int[] arr_v = super.onCreateDrawableState(v + 2);
        if(this.getCheckedState() == 2) {
            View.mergeDrawableStates(arr_v, MaterialCheckBox.S);
        }
        if(this.j) {
            View.mergeDrawableStates(arr_v, MaterialCheckBox.T);
        }
        this.D = e2.a.E(arr_v);
        return arr_v;
    }

    @Override  // android.widget.CompoundButton
    public final void onDraw(Canvas canvas0) {
        if(this.i && TextUtils.isEmpty(this.getText())) {
            Drawable drawable0 = this.getButtonDrawable();
            if(drawable0 != null) {
                int v = B.l(this) ? -1 : 1;
                int v1 = (this.getWidth() - drawable0.getIntrinsicWidth()) / 2 * v;
                int v2 = canvas0.save();
                canvas0.translate(((float)v1), 0.0f);
                super.onDraw(canvas0);
                canvas0.restoreToCount(v2);
                if(this.getBackground() != null) {
                    Rect rect0 = drawable0.getBounds();
                    this.getBackground().setHotspotBounds(rect0.left + v1, rect0.top, rect0.right + v1, rect0.bottom);
                }
                return;
            }
        }
        super.onDraw(canvas0);
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        if(accessibilityNodeInfo0 != null && this.j) {
            accessibilityNodeInfo0.setText(accessibilityNodeInfo0.getText() + ", " + this.k);
        }
    }

    @Override  // android.widget.CompoundButton
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((SavedState)parcelable0).getSuperState());
        this.setCheckedState(((SavedState)parcelable0).a);
    }

    @Override  // android.widget.CompoundButton
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcelable;)V
        parcelable0.a = this.getCheckedState();
        return parcelable0;
    }

    @Override  // androidx.appcompat.widget.AppCompatCheckBox
    public void setButtonDrawable(int v) {
        this.setButtonDrawable(w.B(this.getContext(), v));
    }

    @Override  // androidx.appcompat.widget.AppCompatCheckBox
    public void setButtonDrawable(Drawable drawable0) {
        this.l = drawable0;
        this.n = false;
        this.a();
    }

    public void setButtonIconDrawable(Drawable drawable0) {
        this.m = drawable0;
        this.a();
    }

    public void setButtonIconDrawableResource(int v) {
        this.setButtonIconDrawable(w.B(this.getContext(), v));
    }

    public void setButtonIconTintList(ColorStateList colorStateList0) {
        if(this.r == colorStateList0) {
            return;
        }
        this.r = colorStateList0;
        this.a();
    }

    public void setButtonIconTintMode(PorterDuff.Mode porterDuff$Mode0) {
        if(this.w == porterDuff$Mode0) {
            return;
        }
        this.w = porterDuff$Mode0;
        this.a();
    }

    @Override  // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList0) {
        if(this.o == colorStateList0) {
            return;
        }
        this.o = colorStateList0;
        this.a();
    }

    @Override  // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode porterDuff$Mode0) {
        this.setSupportButtonTintMode(porterDuff$Mode0);
        this.a();
    }

    public void setCenterIfNoTextEnabled(boolean z) {
        this.i = z;
    }

    @Override  // android.widget.CompoundButton
    public void setChecked(boolean z) {
        this.setCheckedState(((int)z));
    }

    public void setCheckedState(int v) {
        if(this.B != v) {
            this.B = v;
            super.setChecked(v == 1);
            this.refreshDrawableState();
            if(Build.VERSION.SDK_INT >= 30 && this.G == null) {
                super.setStateDescription(this.getButtonStateDescription());
            }
            if(!this.E) {
                this.E = true;
                LinkedHashSet linkedHashSet0 = this.f;
                if(linkedHashSet0 != null) {
                    Iterator iterator0 = linkedHashSet0.iterator();
                    if(iterator0.hasNext()) {
                        throw H0.b.b(iterator0);
                    }
                }
                if(this.B != 2) {
                    CompoundButton.OnCheckedChangeListener compoundButton$OnCheckedChangeListener0 = this.I;
                    if(compoundButton$OnCheckedChangeListener0 != null) {
                        compoundButton$OnCheckedChangeListener0.onCheckedChanged(this, this.isChecked());
                    }
                }
                AutofillManager autofillManager0 = (AutofillManager)this.getContext().getSystemService(AutofillManager.class);
                if(autofillManager0 != null) {
                    autofillManager0.notifyValueChanged(this);
                }
                this.E = false;
            }
        }
    }

    @Override  // android.widget.TextView
    public void setEnabled(boolean z) {
        super.setEnabled(z);
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence0) {
        this.k = charSequence0;
    }

    public void setErrorAccessibilityLabelResource(int v) {
        this.setErrorAccessibilityLabel((v == 0 ? null : this.getResources().getText(v)));
    }

    public void setErrorShown(boolean z) {
        if(this.j != z) {
            this.j = z;
            this.refreshDrawableState();
            Iterator iterator0 = this.e.iterator();
            if(iterator0.hasNext()) {
                throw H0.b.b(iterator0);
            }
        }
    }

    @Override  // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener compoundButton$OnCheckedChangeListener0) {
        this.I = compoundButton$OnCheckedChangeListener0;
    }

    @Override  // android.widget.CompoundButton
    public void setStateDescription(CharSequence charSequence0) {
        this.G = charSequence0;
        if(charSequence0 == null) {
            if(Build.VERSION.SDK_INT >= 30) {
                super.setStateDescription(this.getButtonStateDescription());
            }
            return;
        }
        super.setStateDescription(charSequence0);
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.h = z;
        if(z) {
            this.setButtonTintList(this.getMaterialThemeColorsTintList());
            return;
        }
        this.setButtonTintList(null);
    }

    @Override  // android.widget.CompoundButton
    public final void toggle() {
        this.setChecked(!this.isChecked());
    }
}

