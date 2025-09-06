package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.core.widget.o;

public class AppCompatCheckBox extends CheckBox implements o {
    public final w a;
    public final v b;
    public final T c;
    public z d;

    public AppCompatCheckBox(Context context0) {
        this(context0, null);
    }

    public AppCompatCheckBox(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040107);  // attr:checkboxStyle
    }

    public AppCompatCheckBox(Context context0, AttributeSet attributeSet0, int v) {
        TintContextWrapper.a(context0);
        super(context0, attributeSet0, v);
        a1.a(this.getContext(), this);
        w w0 = new w(this);
        this.a = w0;
        w0.c(attributeSet0, v);
        v v1 = new v(this);
        this.b = v1;
        v1.d(attributeSet0, v);
        T t0 = new T(this);
        this.c = t0;
        t0.f(attributeSet0, v);
        this.getEmojiTextViewHelper().b(attributeSet0, v);
    }

    @Override  // android.widget.CompoundButton
    public void drawableStateChanged() {
        super.drawableStateChanged();
        v v0 = this.b;
        if(v0 != null) {
            v0.a();
        }
        T t0 = this.c;
        if(t0 != null) {
            t0.b();
        }
    }

    private z getEmojiTextViewHelper() {
        if(this.d == null) {
            this.d = new z(this);
        }
        return this.d;
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.b == null ? null : this.b.b();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.b == null ? null : this.b.c();
    }

    @Override  // androidx.core.widget.o
    public ColorStateList getSupportButtonTintList() {
        return this.a == null ? null : this.a.a;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        return this.a == null ? null : this.a.b;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.c.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.c.e();
    }

    @Override  // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        this.getEmojiTextViewHelper().c(z);
    }

    @Override  // android.view.View
    public void setBackgroundDrawable(Drawable drawable0) {
        super.setBackgroundDrawable(drawable0);
        v v0 = this.b;
        if(v0 != null) {
            v0.e();
        }
    }

    @Override  // android.view.View
    public void setBackgroundResource(int v) {
        super.setBackgroundResource(v);
        v v1 = this.b;
        if(v1 != null) {
            v1.f(v);
        }
    }

    @Override  // android.widget.CompoundButton
    public void setButtonDrawable(int v) {
        this.setButtonDrawable(d5.w.B(this.getContext(), v));
    }

    @Override  // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable0) {
        super.setButtonDrawable(drawable0);
        w w0 = this.a;
        if(w0 != null) {
            if(w0.e) {
                w0.e = false;
                return;
            }
            w0.e = true;
            w0.a();
        }
    }

    @Override  // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        super.setCompoundDrawables(drawable0, drawable1, drawable2, drawable3);
        T t0 = this.c;
        if(t0 != null) {
            t0.b();
        }
    }

    @Override  // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        super.setCompoundDrawablesRelative(drawable0, drawable1, drawable2, drawable3);
        T t0 = this.c;
        if(t0 != null) {
            t0.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.getEmojiTextViewHelper().d(z);
    }

    @Override  // android.widget.TextView
    public void setFilters(InputFilter[] arr_inputFilter) {
        super.setFilters(this.getEmojiTextViewHelper().a(arr_inputFilter));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList0) {
        v v0 = this.b;
        if(v0 != null) {
            v0.h(colorStateList0);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode porterDuff$Mode0) {
        v v0 = this.b;
        if(v0 != null) {
            v0.i(porterDuff$Mode0);
        }
    }

    @Override  // androidx.core.widget.o
    public void setSupportButtonTintList(ColorStateList colorStateList0) {
        w w0 = this.a;
        if(w0 != null) {
            w0.a = colorStateList0;
            w0.c = true;
            w0.a();
        }
    }

    @Override  // androidx.core.widget.o
    public void setSupportButtonTintMode(PorterDuff.Mode porterDuff$Mode0) {
        w w0 = this.a;
        if(w0 != null) {
            w0.b = porterDuff$Mode0;
            w0.d = true;
            w0.a();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList0) {
        this.c.k(colorStateList0);
        this.c.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode porterDuff$Mode0) {
        this.c.l(porterDuff$Mode0);
        this.c.b();
    }
}

