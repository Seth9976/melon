package com.google.android.material.textfield;

import A3.g;
import H0.e;
import Q0.x;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.media3.session.a0;
import com.google.android.material.internal.B;
import com.google.android.material.internal.CheckableImageButton;
import d2.b;
import d5.m;
import d5.w;
import e1.n;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class k extends LinearLayout {
    public boolean B;
    public EditText D;
    public final AccessibilityManager E;
    public a0 G;
    public final i I;
    public final TextInputLayout a;
    public final FrameLayout b;
    public final CheckableImageButton c;
    public ColorStateList d;
    public PorterDuff.Mode e;
    public View.OnLongClickListener f;
    public final CheckableImageButton g;
    public final g h;
    public int i;
    public final LinkedHashSet j;
    public ColorStateList k;
    public PorterDuff.Mode l;
    public int m;
    public ImageView.ScaleType n;
    public View.OnLongClickListener o;
    public CharSequence r;
    public final AppCompatTextView w;

    public k(TextInputLayout textInputLayout0, m m0) {
        super(textInputLayout0.getContext());
        this.i = 0;
        this.j = new LinkedHashSet();
        this.I = new i(this);
        j j0 = new j(this);
        this.E = (AccessibilityManager)this.getContext().getSystemService("accessibility");
        this.a = textInputLayout0;
        this.setVisibility(8);
        this.setOrientation(0);
        this.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 0x800005));
        FrameLayout frameLayout0 = new FrameLayout(this.getContext());
        this.b = frameLayout0;
        frameLayout0.setVisibility(8);
        frameLayout0.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflater0 = LayoutInflater.from(this.getContext());
        CheckableImageButton checkableImageButton0 = this.a(this, layoutInflater0, 0x7F0A0B57);  // id:text_input_error_icon
        this.c = checkableImageButton0;
        CheckableImageButton checkableImageButton1 = this.a(frameLayout0, layoutInflater0, 0x7F0A0B56);  // id:text_input_end_icon
        this.g = checkableImageButton1;
        this.h = new g(this, m0);
        AppCompatTextView appCompatTextView0 = new AppCompatTextView(this.getContext());
        this.w = appCompatTextView0;
        TypedArray typedArray0 = (TypedArray)m0.c;
        if(typedArray0.hasValue(38)) {
            this.d = n.s(this.getContext(), m0, 38);
        }
        CharSequence charSequence0 = null;
        if(typedArray0.hasValue(39)) {
            this.e = B.o(typedArray0.getInt(39, -1), null);
        }
        if(typedArray0.hasValue(37)) {
            this.i(m0.k(37));
        }
        checkableImageButton0.setContentDescription(this.getResources().getText(0x7F1303C3));  // string:error_icon_content_description "Error"
        checkableImageButton0.setImportantForAccessibility(2);
        checkableImageButton0.setClickable(false);
        checkableImageButton0.setPressable(false);
        checkableImageButton0.setFocusable(false);
        if(!typedArray0.hasValue(53)) {
            if(typedArray0.hasValue(0x20)) {
                this.k = n.s(this.getContext(), m0, 0x20);
            }
            if(typedArray0.hasValue(33)) {
                this.l = B.o(typedArray0.getInt(33, -1), null);
            }
        }
        if(typedArray0.hasValue(30)) {
            this.g(typedArray0.getInt(30, 0));
            if(typedArray0.hasValue(27)) {
                CharSequence charSequence1 = typedArray0.getText(27);
                if(checkableImageButton1.getContentDescription() != charSequence1) {
                    checkableImageButton1.setContentDescription(charSequence1);
                }
            }
            checkableImageButton1.setCheckable(typedArray0.getBoolean(26, true));
        }
        else if(typedArray0.hasValue(53)) {
            if(typedArray0.hasValue(54)) {
                this.k = n.s(this.getContext(), m0, 54);
            }
            if(typedArray0.hasValue(55)) {
                this.l = B.o(typedArray0.getInt(55, -1), null);
            }
            this.g(((int)typedArray0.getBoolean(53, false)));
            CharSequence charSequence2 = typedArray0.getText(51);
            if(checkableImageButton1.getContentDescription() != charSequence2) {
                checkableImageButton1.setContentDescription(charSequence2);
            }
        }
        int v = typedArray0.getDimensionPixelSize(29, this.getResources().getDimensionPixelSize(0x7F0703A3));  // dimen:mtrl_min_touch_target_size
        if(v < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if(v != this.m) {
            this.m = v;
            checkableImageButton1.setMinimumWidth(v);
            checkableImageButton1.setMinimumHeight(v);
            checkableImageButton0.setMinimumWidth(v);
            checkableImageButton0.setMinimumHeight(v);
        }
        if(typedArray0.hasValue(0x1F)) {
            ImageView.ScaleType imageView$ScaleType0 = e.A(typedArray0.getInt(0x1F, -1));
            this.n = imageView$ScaleType0;
            checkableImageButton1.setScaleType(imageView$ScaleType0);
            checkableImageButton0.setScaleType(imageView$ScaleType0);
        }
        appCompatTextView0.setVisibility(8);
        appCompatTextView0.setId(0x7F0A0B67);  // id:textinput_suffix_text
        appCompatTextView0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        appCompatTextView0.setAccessibilityLiveRegion(1);
        appCompatTextView0.setTextAppearance(typedArray0.getResourceId(72, 0));
        if(typedArray0.hasValue(73)) {
            appCompatTextView0.setTextColor(m0.j(73));
        }
        CharSequence charSequence3 = typedArray0.getText(71);
        if(!TextUtils.isEmpty(charSequence3)) {
            charSequence0 = charSequence3;
        }
        this.r = charSequence0;
        appCompatTextView0.setText(charSequence3);
        this.n();
        frameLayout0.addView(checkableImageButton1);
        this.addView(appCompatTextView0);
        this.addView(frameLayout0);
        this.addView(checkableImageButton0);
        textInputLayout0.A0.add(j0);
        if(textInputLayout0.d != null) {
            j0.a(textInputLayout0);
        }
        this.addOnAttachStateChangeListener(new x(this, 2));
    }

    public final CheckableImageButton a(ViewGroup viewGroup0, LayoutInflater layoutInflater0, int v) {
        CheckableImageButton checkableImageButton0 = (CheckableImageButton)layoutInflater0.inflate(0x7F0D01F5, viewGroup0, false);  // layout:design_text_input_end_icon
        checkableImageButton0.setId(v);
        if(n.y(this.getContext())) {
            ((ViewGroup.MarginLayoutParams)checkableImageButton0.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton0;
    }

    public final l b() {
        l l1;
        int v = this.i;
        g g0 = this.h;
        SparseArray sparseArray0 = (SparseArray)g0.d;
        l l0 = (l)sparseArray0.get(v);
        if(l0 == null) {
            k k0 = (k)g0.e;
            switch(v) {
                case -1: {
                    l1 = new d(k0, 0);
                    break;
                }
                case 0: {
                    l1 = new d(k0, 1);
                    break;
                }
                case 1: {
                    l1 = new r(k0, g0.c);
                    break;
                }
                case 2: {
                    l1 = new c(k0);
                    break;
                }
                case 3: {
                    l1 = new h(k0);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid end icon mode: " + v);
                }
            }
            sparseArray0.append(v, l1);
            return l1;
        }
        return l0;
    }

    public final int c() {
        int v;
        if(this.d() || this.e()) {
            int v1 = this.g.getMeasuredWidth();
            v = ((ViewGroup.MarginLayoutParams)this.g.getLayoutParams()).getMarginStart() + v1;
        }
        else {
            v = 0;
        }
        int v2 = this.getPaddingEnd();
        return this.w.getPaddingEnd() + v2 + v;
    }

    public final boolean d() {
        return this.b.getVisibility() == 0 && this.g.getVisibility() == 0;
    }

    public final boolean e() {
        return this.c.getVisibility() == 0;
    }

    public final void f(boolean z) {
        int v1;
        l l0 = this.b();
        CheckableImageButton checkableImageButton0 = this.g;
        int v = 1;
        if(l0.k()) {
            boolean z1 = checkableImageButton0.d;
            if(z1 == l0.l()) {
                v1 = 0;
            }
            else {
                checkableImageButton0.setChecked(!z1);
                v1 = 1;
            }
        }
        else {
            v1 = 0;
        }
        if(l0 instanceof h) {
            boolean z2 = checkableImageButton0.isActivated();
            if(z2 == l0.j()) {
                v = v1;
            }
            else {
                checkableImageButton0.setActivated(!z2);
            }
        }
        else {
            v = v1;
        }
        if(!z && v == 0) {
            return;
        }
        e.S(this.a, checkableImageButton0, this.k);
    }

    public final void g(int v) {
        if(this.i == v) {
            return;
        }
        l l0 = this.b();
        a0 a00 = this.G;
        AccessibilityManager accessibilityManager0 = this.E;
        if(a00 != null && accessibilityManager0 != null) {
            accessibilityManager0.removeTouchExplorationStateChangeListener(new b(a00));
        }
        CharSequence charSequence0 = null;
        this.G = null;
        l0.s();
        this.i = v;
        Iterator iterator0 = this.j.iterator();
        if(iterator0.hasNext()) {
            throw H0.b.b(iterator0);
        }
        this.h(v != 0);
        l l1 = this.b();
        int v1 = this.h.b == 0 ? l1.d() : this.h.b;
        Drawable drawable0 = v1 == 0 ? null : w.B(this.getContext(), v1);
        CheckableImageButton checkableImageButton0 = this.g;
        checkableImageButton0.setImageDrawable(drawable0);
        TextInputLayout textInputLayout0 = this.a;
        if(drawable0 != null) {
            e.v(textInputLayout0, checkableImageButton0, this.k, this.l);
            e.S(textInputLayout0, checkableImageButton0, this.k);
        }
        int v2 = l1.c();
        if(v2 != 0) {
            charSequence0 = this.getResources().getText(v2);
        }
        if(checkableImageButton0.getContentDescription() != charSequence0) {
            checkableImageButton0.setContentDescription(charSequence0);
        }
        checkableImageButton0.setCheckable(l1.k());
        if(!l1.i(textInputLayout0.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + textInputLayout0.getBoxBackgroundMode() + " is not supported by the end icon mode " + v);
        }
        l1.r();
        a0 a01 = l1.h();
        this.G = a01;
        if(a01 != null && accessibilityManager0 != null && this.isAttachedToWindow()) {
            accessibilityManager0.addTouchExplorationStateChangeListener(new b(this.G));
        }
        View.OnLongClickListener view$OnLongClickListener0 = this.o;
        checkableImageButton0.setOnClickListener(l1.f());
        e.X(checkableImageButton0, view$OnLongClickListener0);
        EditText editText0 = this.D;
        if(editText0 != null) {
            l1.m(editText0);
            this.j(l1);
        }
        e.v(textInputLayout0, checkableImageButton0, this.k, this.l);
        this.f(true);
    }

    public final void h(boolean z) {
        if(this.d() != z) {
            this.g.setVisibility((z ? 0 : 8));
            this.k();
            this.m();
            this.a.q();
        }
    }

    public final void i(Drawable drawable0) {
        this.c.setImageDrawable(drawable0);
        this.l();
        e.v(this.a, this.c, this.d, this.e);
    }

    public final void j(l l0) {
        if(this.D != null) {
            if(l0.e() != null) {
                this.D.setOnFocusChangeListener(l0.e());
            }
            if(l0.g() != null) {
                this.g.setOnFocusChangeListener(l0.g());
            }
        }
    }

    public final void k() {
        int v = 8;
        int v1 = this.g.getVisibility() != 0 || this.e() ? 8 : 0;
        this.b.setVisibility(v1);
        int v2 = this.r == null || this.B ? 8 : 0;
        if(this.d() || this.e() || v2 == 0) {
            v = 0;
        }
        this.setVisibility(v);
    }

    public final void l() {
        Drawable drawable0 = this.c.getDrawable();
        TextInputLayout textInputLayout0 = this.a;
        int v = drawable0 == null || !textInputLayout0.j.q || !textInputLayout0.m() ? 8 : 0;
        this.c.setVisibility(v);
        this.k();
        this.m();
        if(this.i != 0) {
            return;
        }
        textInputLayout0.q();
    }

    public final void m() {
        TextInputLayout textInputLayout0 = this.a;
        if(textInputLayout0.d == null) {
            return;
        }
        int v = this.d() || this.e() ? 0 : textInputLayout0.d.getPaddingEnd();
        int v1 = this.getContext().getResources().getDimensionPixelSize(0x7F0702ED);  // dimen:material_input_text_to_prefix_suffix_padding
        int v2 = textInputLayout0.d.getPaddingTop();
        int v3 = textInputLayout0.d.getPaddingBottom();
        this.w.setPaddingRelative(v1, v2, v, v3);
    }

    public final void n() {
        AppCompatTextView appCompatTextView0 = this.w;
        int v = appCompatTextView0.getVisibility();
        boolean z = false;
        int v1 = this.r == null || this.B ? 8 : 0;
        if(v != v1) {
            l l0 = this.b();
            if(v1 == 0) {
                z = true;
            }
            l0.p(z);
        }
        this.k();
        appCompatTextView0.setVisibility(v1);
        this.a.q();
    }
}

