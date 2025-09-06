package com.google.android.material.textfield;

import H0.e;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.internal.B;
import com.google.android.material.internal.CheckableImageButton;
import d5.m;
import e1.n;

public final class s extends LinearLayout {
    public final TextInputLayout a;
    public final AppCompatTextView b;
    public CharSequence c;
    public final CheckableImageButton d;
    public ColorStateList e;
    public PorterDuff.Mode f;
    public int g;
    public ImageView.ScaleType h;
    public View.OnLongClickListener i;
    public boolean j;

    public s(TextInputLayout textInputLayout0, m m0) {
        super(textInputLayout0.getContext());
        this.a = textInputLayout0;
        this.setVisibility(8);
        this.setOrientation(0);
        this.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 0x800003));
        CheckableImageButton checkableImageButton0 = (CheckableImageButton)LayoutInflater.from(this.getContext()).inflate(0x7F0D01F6, this, false);  // layout:design_text_input_start_icon
        this.d = checkableImageButton0;
        AppCompatTextView appCompatTextView0 = new AppCompatTextView(this.getContext());
        this.b = appCompatTextView0;
        if(n.y(this.getContext())) {
            ((ViewGroup.MarginLayoutParams)checkableImageButton0.getLayoutParams()).setMarginEnd(0);
        }
        View.OnLongClickListener view$OnLongClickListener0 = this.i;
        CharSequence charSequence0 = null;
        checkableImageButton0.setOnClickListener(null);
        e.X(checkableImageButton0, view$OnLongClickListener0);
        this.i = null;
        checkableImageButton0.setOnLongClickListener(null);
        e.X(checkableImageButton0, null);
        TypedArray typedArray0 = (TypedArray)m0.c;
        if(typedArray0.hasValue(69)) {
            this.e = n.s(this.getContext(), m0, 69);
        }
        if(typedArray0.hasValue(70)) {
            this.f = B.o(typedArray0.getInt(70, -1), null);
        }
        if(typedArray0.hasValue(66)) {
            this.b(m0.k(66));
            if(typedArray0.hasValue(65)) {
                CharSequence charSequence1 = typedArray0.getText(65);
                if(checkableImageButton0.getContentDescription() != charSequence1) {
                    checkableImageButton0.setContentDescription(charSequence1);
                }
            }
            checkableImageButton0.setCheckable(typedArray0.getBoolean(0x40, true));
        }
        int v = typedArray0.getDimensionPixelSize(67, this.getResources().getDimensionPixelSize(0x7F0703A3));  // dimen:mtrl_min_touch_target_size
        if(v < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if(v != this.g) {
            this.g = v;
            checkableImageButton0.setMinimumWidth(v);
            checkableImageButton0.setMinimumHeight(v);
        }
        if(typedArray0.hasValue(68)) {
            ImageView.ScaleType imageView$ScaleType0 = e.A(typedArray0.getInt(68, -1));
            this.h = imageView$ScaleType0;
            checkableImageButton0.setScaleType(imageView$ScaleType0);
        }
        appCompatTextView0.setVisibility(8);
        appCompatTextView0.setId(0x7F0A0B66);  // id:textinput_prefix_text
        appCompatTextView0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        appCompatTextView0.setAccessibilityLiveRegion(1);
        appCompatTextView0.setTextAppearance(typedArray0.getResourceId(60, 0));
        if(typedArray0.hasValue(61)) {
            appCompatTextView0.setTextColor(m0.j(61));
        }
        CharSequence charSequence2 = typedArray0.getText(59);
        if(!TextUtils.isEmpty(charSequence2)) {
            charSequence0 = charSequence2;
        }
        this.c = charSequence0;
        appCompatTextView0.setText(charSequence2);
        this.e();
        this.addView(checkableImageButton0);
        this.addView(appCompatTextView0);
    }

    public final int a() {
        int v1;
        CheckableImageButton checkableImageButton0 = this.d;
        if(checkableImageButton0.getVisibility() == 0) {
            int v = checkableImageButton0.getMeasuredWidth();
            v1 = ((ViewGroup.MarginLayoutParams)checkableImageButton0.getLayoutParams()).getMarginEnd() + v;
        }
        else {
            v1 = 0;
        }
        int v2 = this.getPaddingStart();
        return this.b.getPaddingStart() + v2 + v1;
    }

    public final void b(Drawable drawable0) {
        CheckableImageButton checkableImageButton0 = this.d;
        checkableImageButton0.setImageDrawable(drawable0);
        if(drawable0 != null) {
            e.v(this.a, checkableImageButton0, this.e, this.f);
            this.c(true);
            e.S(this.a, checkableImageButton0, this.e);
            return;
        }
        this.c(false);
        View.OnLongClickListener view$OnLongClickListener0 = this.i;
        checkableImageButton0.setOnClickListener(null);
        e.X(checkableImageButton0, view$OnLongClickListener0);
        this.i = null;
        checkableImageButton0.setOnLongClickListener(null);
        e.X(checkableImageButton0, null);
        if(checkableImageButton0.getContentDescription() != null) {
            checkableImageButton0.setContentDescription(null);
        }
    }

    public final void c(boolean z) {
        CheckableImageButton checkableImageButton0 = this.d;
        int v = 0;
        if(checkableImageButton0.getVisibility() == 0 != z) {
            if(!z) {
                v = 8;
            }
            checkableImageButton0.setVisibility(v);
            this.d();
            this.e();
        }
    }

    public final void d() {
        EditText editText0 = this.a.d;
        if(editText0 == null) {
            return;
        }
        int v = this.d.getVisibility() == 0 ? 0 : editText0.getPaddingStart();
        int v1 = editText0.getCompoundPaddingTop();
        int v2 = this.getContext().getResources().getDimensionPixelSize(0x7F0702ED);  // dimen:material_input_text_to_prefix_suffix_padding
        int v3 = editText0.getCompoundPaddingBottom();
        this.b.setPaddingRelative(v, v1, v2, v3);
    }

    public final void e() {
        int v = 8;
        int v1 = this.c == null || this.j ? 8 : 0;
        if(this.d.getVisibility() == 0 || v1 == 0) {
            v = 0;
        }
        this.setVisibility(v);
        this.b.setVisibility(v1);
        this.a.q();
    }

    @Override  // android.widget.LinearLayout
    public final void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        this.d();
    }
}

