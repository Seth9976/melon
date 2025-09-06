package androidx.appcompat.widget;

import B.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import d5.m;
import d5.w;

public class AppCompatAutoCompleteTextView extends AutoCompleteTextView {
    public final v a;
    public final T b;
    public final B c;
    public static final int[] d;

    static {
        AppCompatAutoCompleteTextView.d = new int[]{0x1010176};
    }

    public AppCompatAutoCompleteTextView(Context context0) {
        this(context0, null);
    }

    public AppCompatAutoCompleteTextView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040055);  // attr:autoCompleteTextViewStyle
    }

    public AppCompatAutoCompleteTextView(Context context0, AttributeSet attributeSet0, int v) {
        TintContextWrapper.a(context0);
        super(context0, attributeSet0, v);
        a1.a(this.getContext(), this);
        m m0 = m.r(this.getContext(), attributeSet0, AppCompatAutoCompleteTextView.d, v);
        if(((TypedArray)m0.c).hasValue(0)) {
            this.setDropDownBackgroundDrawable(m0.k(0));
        }
        m0.t();
        v v1 = new v(this);
        this.a = v1;
        v1.d(attributeSet0, v);
        T t0 = new T(this);
        this.b = t0;
        t0.f(attributeSet0, v);
        t0.b();
        B b0 = new B(this);
        this.c = b0;
        b0.b(attributeSet0, v);
        KeyListener keyListener0 = this.getKeyListener();
        if(!(keyListener0 instanceof NumberKeyListener)) {
            boolean z = super.isFocusable();
            boolean z1 = super.isClickable();
            boolean z2 = super.isLongClickable();
            int v2 = super.getInputType();
            KeyListener keyListener1 = b0.a(keyListener0);
            if(keyListener1 != keyListener0) {
                super.setKeyListener(keyListener1);
                super.setRawInputType(v2);
                super.setFocusable(z);
                super.setClickable(z1);
                super.setLongClickable(z2);
            }
        }
    }

    @Override  // android.widget.TextView
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

    @Override  // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return a.a0(super.getCustomSelectionActionModeCallback());
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
    public InputConnection onCreateInputConnection(EditorInfo editorInfo0) {
        InputConnection inputConnection0 = super.onCreateInputConnection(editorInfo0);
        a.a.H(inputConnection0, editorInfo0, this);
        return this.c.c(inputConnection0, editorInfo0);
    }

    @Override  // android.view.View
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

    @Override  // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionMode$Callback0) {
        super.setCustomSelectionActionModeCallback(a.b0(actionMode$Callback0, this));
    }

    @Override  // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int v) {
        this.setDropDownBackgroundDrawable(w.B(this.getContext(), v));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.c.d(z);
    }

    @Override  // android.widget.TextView
    public void setKeyListener(KeyListener keyListener0) {
        super.setKeyListener(this.c.a(keyListener0));
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

    @Override  // android.widget.TextView
    public final void setTextAppearance(Context context0, int v) {
        super.setTextAppearance(context0, v);
        T t0 = this.b;
        if(t0 != null) {
            t0.g(context0, v);
        }
    }
}

