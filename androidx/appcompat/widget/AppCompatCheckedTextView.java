package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import c2.W;
import d5.m;
import g.a;

public class AppCompatCheckedTextView extends CheckedTextView {
    public final w a;
    public final v b;
    public final T c;
    public z d;

    public AppCompatCheckedTextView(Context context0) {
        this(context0, null);
    }

    public AppCompatCheckedTextView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040113);  // attr:checkedTextViewStyle
    }

    public AppCompatCheckedTextView(Context context0, AttributeSet attributeSet0, int v) {
        TintContextWrapper.a(context0);
        super(context0, attributeSet0, v);
        a1.a(this.getContext(), this);
        T t0 = new T(this);
        this.c = t0;
        t0.f(attributeSet0, v);
        t0.b();
        v v1 = new v(this);
        this.b = v1;
        v1.d(attributeSet0, v);
        this.a = new w(this);
        m m0 = m.r(this.getContext(), attributeSet0, a.m, v);
        TypedArray typedArray0 = (TypedArray)m0.c;
        W.n(this, this.getContext(), a.m, attributeSet0, ((TypedArray)m0.c), v);
        try {
            if(typedArray0.hasValue(1)) {
                int v3 = typedArray0.getResourceId(1, 0);
                if(v3 != 0) {
                    try {
                        this.setCheckMarkDrawable(d5.w.B(this.getContext(), v3));
                        goto label_24;
                    }
                    catch(Resources.NotFoundException unused_ex) {
                    }
                }
                goto label_20;
            }
            else {
            label_20:
                if(typedArray0.hasValue(0)) {
                    int v4 = typedArray0.getResourceId(0, 0);
                    if(v4 != 0) {
                        this.setCheckMarkDrawable(d5.w.B(this.getContext(), v4));
                    }
                }
            }
        label_24:
            if(typedArray0.hasValue(2)) {
                this.setCheckMarkTintList(m0.j(2));
            }
            if(typedArray0.hasValue(3)) {
                this.setCheckMarkTintMode(h0.c(typedArray0.getInt(3, -1), null));
            }
        }
        finally {
            m0.t();
        }
        this.getEmojiTextViewHelper().b(attributeSet0, v);
    }

    @Override  // android.widget.CheckedTextView
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        T t0 = this.c;
        if(t0 != null) {
            t0.b();
        }
        v v0 = this.b;
        if(v0 != null) {
            v0.a();
        }
        w w0 = this.a;
        if(w0 != null) {
            w0.b();
        }
    }

    @Override  // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return B.a.a0(super.getCustomSelectionActionModeCallback());
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

    public ColorStateList getSupportCheckMarkTintList() {
        return this.a == null ? null : this.a.a;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        return this.a == null ? null : this.a.b;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.c.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.c.e();
    }

    @Override  // android.widget.TextView
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo0) {
        InputConnection inputConnection0 = super.onCreateInputConnection(editorInfo0);
        a.a.H(inputConnection0, editorInfo0, this);
        return inputConnection0;
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

    @Override  // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int v) {
        this.setCheckMarkDrawable(d5.w.B(this.getContext(), v));
    }

    @Override  // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable0) {
        super.setCheckMarkDrawable(drawable0);
        w w0 = this.a;
        if(w0 != null) {
            if(w0.e) {
                w0.e = false;
                return;
            }
            w0.e = true;
            w0.b();
        }
    }

    @Override  // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        super.setCompoundDrawables(drawable0, drawable1, drawable2, drawable3);
        T t0 = this.c;
        if(t0 != null) {
            t0.b();
        }
    }

    @Override  // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        super.setCompoundDrawablesRelative(drawable0, drawable1, drawable2, drawable3);
        T t0 = this.c;
        if(t0 != null) {
            t0.b();
        }
    }

    @Override  // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionMode$Callback0) {
        super.setCustomSelectionActionModeCallback(B.a.b0(actionMode$Callback0, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.getEmojiTextViewHelper().d(z);
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

    public void setSupportCheckMarkTintList(ColorStateList colorStateList0) {
        w w0 = this.a;
        if(w0 != null) {
            w0.a = colorStateList0;
            w0.c = true;
            w0.b();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode porterDuff$Mode0) {
        w w0 = this.a;
        if(w0 != null) {
            w0.b = porterDuff$Mode0;
            w0.d = true;
            w0.b();
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

    @Override  // android.widget.TextView
    public final void setTextAppearance(Context context0, int v) {
        super.setTextAppearance(context0, v);
        T t0 = this.c;
        if(t0 != null) {
            t0.g(context0, v);
        }
    }
}

