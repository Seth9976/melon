package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;

public class AppCompatToggleButton extends ToggleButton {
    public final v a;
    public final T b;
    public z c;

    public AppCompatToggleButton(Context context0) {
        this(context0, null);
    }

    public AppCompatToggleButton(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x101004B);
    }

    public AppCompatToggleButton(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        a1.a(this.getContext(), this);
        v v1 = new v(this);
        this.a = v1;
        v1.d(attributeSet0, v);
        T t0 = new T(this);
        this.b = t0;
        t0.f(attributeSet0, v);
        this.getEmojiTextViewHelper().b(attributeSet0, v);
    }

    @Override  // android.widget.ToggleButton
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        v v0 = this.a;
        if(v0 != null) {
            v0.a();
        }
        T t0 = this.b;
        if(t0 != null) {
            t0.b();
        }
    }

    private z getEmojiTextViewHelper() {
        if(this.c == null) {
            this.c = new z(this);
        }
        return this.c;
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.a == null ? null : this.a.b();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.a == null ? null : this.a.c();
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.b.e();
    }

    @Override  // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        this.getEmojiTextViewHelper().c(z);
    }

    @Override  // android.widget.ToggleButton
    public void setBackgroundDrawable(Drawable drawable0) {
        super.setBackgroundDrawable(drawable0);
        v v0 = this.a;
        if(v0 != null) {
            v0.e();
        }
    }

    @Override  // android.view.View
    public void setBackgroundResource(int v) {
        super.setBackgroundResource(v);
        v v1 = this.a;
        if(v1 != null) {
            v1.f(v);
        }
    }

    @Override  // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        super.setCompoundDrawables(drawable0, drawable1, drawable2, drawable3);
        T t0 = this.b;
        if(t0 != null) {
            t0.b();
        }
    }

    @Override  // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        super.setCompoundDrawablesRelative(drawable0, drawable1, drawable2, drawable3);
        T t0 = this.b;
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
        v v0 = this.a;
        if(v0 != null) {
            v0.h(colorStateList0);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode porterDuff$Mode0) {
        v v0 = this.a;
        if(v0 != null) {
            v0.i(porterDuff$Mode0);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList0) {
        this.b.k(colorStateList0);
        this.b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode porterDuff$Mode0) {
        this.b.l(porterDuff$Mode0);
        this.b.b();
    }
}

