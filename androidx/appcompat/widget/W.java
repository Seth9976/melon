package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import android.widget.TextView;
import c2.W;
import d5.m;
import g.a;

public final class w {
    public ColorStateList a;
    public PorterDuff.Mode b;
    public boolean c;
    public boolean d;
    public boolean e;
    public final TextView f;

    public w(TextView textView0) {
        this.a = null;
        this.b = null;
        this.c = false;
        this.d = false;
        this.f = textView0;
        super();
    }

    public void a() {
        CompoundButton compoundButton0 = (CompoundButton)this.f;
        Drawable drawable0 = compoundButton0.getButtonDrawable();
        if(drawable0 != null && (this.c || this.d)) {
            Drawable drawable1 = drawable0.mutate();
            if(this.c) {
                drawable1.setTintList(this.a);
            }
            if(this.d) {
                drawable1.setTintMode(this.b);
            }
            if(drawable1.isStateful()) {
                drawable1.setState(compoundButton0.getDrawableState());
            }
            compoundButton0.setButtonDrawable(drawable1);
        }
    }

    public void b() {
        AppCompatCheckedTextView appCompatCheckedTextView0 = (AppCompatCheckedTextView)this.f;
        Drawable drawable0 = appCompatCheckedTextView0.getCheckMarkDrawable();
        if(drawable0 != null && (this.c || this.d)) {
            Drawable drawable1 = drawable0.mutate();
            if(this.c) {
                drawable1.setTintList(this.a);
            }
            if(this.d) {
                drawable1.setTintMode(this.b);
            }
            if(drawable1.isStateful()) {
                drawable1.setState(appCompatCheckedTextView0.getDrawableState());
            }
            appCompatCheckedTextView0.setCheckMarkDrawable(drawable1);
        }
    }

    public void c(AttributeSet attributeSet0, int v) {
        CompoundButton compoundButton0 = (CompoundButton)this.f;
        m m0 = m.r(compoundButton0.getContext(), attributeSet0, a.n, v);
        TypedArray typedArray0 = (TypedArray)m0.c;
        W.n(compoundButton0, compoundButton0.getContext(), a.n, attributeSet0, ((TypedArray)m0.c), v);
        try {
            if(typedArray0.hasValue(1)) {
                int v2 = typedArray0.getResourceId(1, 0);
                if(v2 != 0) {
                    try {
                        compoundButton0.setButtonDrawable(d5.w.B(compoundButton0.getContext(), v2));
                        goto label_14;
                    }
                    catch(Resources.NotFoundException unused_ex) {
                    }
                }
                goto label_10;
            }
            else {
            label_10:
                if(typedArray0.hasValue(0)) {
                    int v3 = typedArray0.getResourceId(0, 0);
                    if(v3 != 0) {
                        compoundButton0.setButtonDrawable(d5.w.B(compoundButton0.getContext(), v3));
                    }
                }
            }
        label_14:
            if(typedArray0.hasValue(2)) {
                compoundButton0.setButtonTintList(m0.j(2));
            }
            if(typedArray0.hasValue(3)) {
                compoundButton0.setButtonTintMode(h0.c(typedArray0.getInt(3, -1), null));
            }
        }
        finally {
            m0.t();
        }
    }
}

