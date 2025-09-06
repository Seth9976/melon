package androidx.appcompat.widget;

import B.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

public class AppCompatButton extends Button {
    public final v a;
    public final T b;
    public z c;

    public AppCompatButton(Context context0) {
        this(context0, null);
    }

    public AppCompatButton(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F0400B8);  // attr:buttonStyle
    }

    public AppCompatButton(Context context0, AttributeSet attributeSet0, int v) {
        TintContextWrapper.a(context0);
        super(context0, attributeSet0, v);
        a1.a(this.getContext(), this);
        v v1 = new v(this);
        this.a = v1;
        v1.d(attributeSet0, v);
        T t0 = new T(this);
        this.b = t0;
        t0.f(attributeSet0, v);
        t0.b();
        this.getEmojiTextViewHelper().b(attributeSet0, v);
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
    public int getAutoSizeMaxTextSize() {
        if(p1.c) {
            return super.getAutoSizeMaxTextSize();
        }
        return this.b == null ? -1 : Math.round(this.b.i.e);
    }

    @Override  // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if(p1.c) {
            return super.getAutoSizeMinTextSize();
        }
        return this.b == null ? -1 : Math.round(this.b.i.d);
    }

    @Override  // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if(p1.c) {
            return super.getAutoSizeStepGranularity();
        }
        return this.b == null ? -1 : Math.round(this.b.i.c);
    }

    @Override  // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if(p1.c) {
            return super.getAutoSizeTextAvailableSizes();
        }
        return this.b == null ? new int[0] : this.b.i.f;
    }

    @Override  // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if(p1.c) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        return this.b == null ? 0 : this.b.i.a;
    }

    @Override  // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return a.a0(super.getCustomSelectionActionModeCallback());
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

    @Override  // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        super.onInitializeAccessibilityEvent(accessibilityEvent0);
        accessibilityEvent0.setClassName("android.widget.Button");
    }

    @Override  // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo0) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo0);
        accessibilityNodeInfo0.setClassName("android.widget.Button");
    }

    @Override  // android.widget.TextView
    public void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        T t0 = this.b;
        if(t0 != null && !p1.c) {
            t0.i.a();
        }
    }

    @Override  // android.widget.TextView
    public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        super.onTextChanged(charSequence0, v, v1, v2);
        T t0 = this.b;
        if(t0 != null) {
            b0 b00 = t0.i;
            if(!p1.c && b00.f()) {
                b00.a();
            }
        }
    }

    @Override  // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        this.getEmojiTextViewHelper().c(z);
    }

    @Override  // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int v, int v1, int v2, int v3) {
        if(p1.c) {
            super.setAutoSizeTextTypeUniformWithConfiguration(v, v1, v2, v3);
            return;
        }
        T t0 = this.b;
        if(t0 != null) {
            t0.h(v, v1, v2, v3);
        }
    }

    @Override  // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] arr_v, int v) {
        if(p1.c) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(arr_v, v);
            return;
        }
        T t0 = this.b;
        if(t0 != null) {
            t0.i(arr_v, v);
        }
    }

    @Override  // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int v) {
        if(p1.c) {
            super.setAutoSizeTextTypeWithDefaults(v);
            return;
        }
        T t0 = this.b;
        if(t0 != null) {
            t0.j(v);
        }
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
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionMode$Callback0) {
        super.setCustomSelectionActionModeCallback(a.b0(actionMode$Callback0, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.getEmojiTextViewHelper().d(z);
    }

    @Override  // android.widget.TextView
    public void setFilters(InputFilter[] arr_inputFilter) {
        super.setFilters(this.getEmojiTextViewHelper().a(arr_inputFilter));
    }

    public void setSupportAllCaps(boolean z) {
        T t0 = this.b;
        if(t0 != null) {
            t0.a.setAllCaps(z);
        }
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

    @Override  // android.widget.TextView
    public final void setTextSize(int v, float f) {
        if(p1.c) {
            super.setTextSize(v, f);
            return;
        }
        T t0 = this.b;
        if(t0 != null) {
            b0 b00 = t0.i;
            if(!b00.f()) {
                b00.g(f, v);
            }
        }
    }
}

