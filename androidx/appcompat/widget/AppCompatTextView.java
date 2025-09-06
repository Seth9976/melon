package androidx.appcompat.widget;

import B.a;
import a2.c;
import a2.d;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import d5.w;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView extends TextView {
    public final v a;
    public final T b;
    public final B c;
    public z d;
    public boolean e;
    public k f;
    public Future g;

    public AppCompatTextView(Context context0) {
        this(context0, null);
    }

    public AppCompatTextView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x1010084);
    }

    public AppCompatTextView(Context context0, AttributeSet attributeSet0, int v) {
        TintContextWrapper.a(context0);
        super(context0, attributeSet0, v);
        this.e = false;
        this.f = null;
        a1.a(this.getContext(), this);
        v v1 = new v(this);
        this.a = v1;
        v1.d(attributeSet0, v);
        T t0 = new T(this);
        this.b = t0;
        t0.f(attributeSet0, v);
        t0.b();
        B b0 = new B();
        b0.b = this;
        this.c = b0;
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
            return ((AppCompatTextView)((k)this.getSuperCaller()).a).super.getAutoSizeMaxTextSize();
        }
        return this.b == null ? -1 : Math.round(this.b.i.e);
    }

    @Override  // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if(p1.c) {
            return ((AppCompatTextView)((k)this.getSuperCaller()).a).super.getAutoSizeMinTextSize();
        }
        return this.b == null ? -1 : Math.round(this.b.i.d);
    }

    @Override  // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if(p1.c) {
            return ((AppCompatTextView)((k)this.getSuperCaller()).a).super.getAutoSizeStepGranularity();
        }
        return this.b == null ? -1 : Math.round(this.b.i.c);
    }

    @Override  // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if(p1.c) {
            return ((AppCompatTextView)((k)this.getSuperCaller()).a).super.getAutoSizeTextAvailableSizes();
        }
        return this.b == null ? new int[0] : this.b.i.f;
    }

    @Override  // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if(p1.c) {
            return ((AppCompatTextView)((k)this.getSuperCaller()).a).super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        return this.b == null ? 0 : this.b.i.a;
    }

    @Override  // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return a.a0(super.getCustomSelectionActionModeCallback());
    }

    private z getEmojiTextViewHelper() {
        if(this.d == null) {
            this.d = new z(this);
        }
        return this.d;
    }

    @Override  // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return this.getPaddingTop() - this.getPaint().getFontMetricsInt().top;
    }

    @Override  // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return this.getPaddingBottom() + this.getPaint().getFontMetricsInt().bottom;
    }

    public U getSuperCaller() {
        if(this.f == null) {
            int v = Build.VERSION.SDK_INT;
            if(v >= 34) {
                this.f = new W(this);
                return this.f;
            }
            if(v >= 28) {
                this.f = new V(this);
                return this.f;
            }
            this.f = new k(this);
        }
        return this.f;
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
    public CharSequence getText() {
        Future future0 = this.g;
        if(future0 != null) {
            try {
                this.g = null;
                if(future0.get() != null) {
                    throw new ClassCastException();
                }
                if(Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                a.M(this);
                throw null;
            }
            catch(InterruptedException | ExecutionException unused_ex) {
            }
        }
        return super.getText();
    }

    @Override  // android.widget.TextView
    public TextClassifier getTextClassifier() {
        if(Build.VERSION.SDK_INT < 28) {
            B b0 = this.c;
            if(b0 != null) {
                TextClassifier textClassifier0 = (TextClassifier)b0.c;
                return textClassifier0 == null ? N.a(((TextView)b0.b)) : textClassifier0;
            }
        }
        return ((AppCompatTextView)((k)this.getSuperCaller()).a).super.getTextClassifier();
    }

    public c getTextMetricsParamsCompat() {
        return a.M(this);
    }

    @Override  // android.widget.TextView
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo0) {
        InputConnection inputConnection0 = super.onCreateInputConnection(editorInfo0);
        this.b.getClass();
        if(Build.VERSION.SDK_INT < 30 && inputConnection0 != null) {
            e2.a.P(editorInfo0, this.getText());
        }
        a.a.H(inputConnection0, editorInfo0, this);
        return inputConnection0;
    }

    @Override  // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(Build.VERSION.SDK_INT >= 30 && Build.VERSION.SDK_INT < 33 && this.onCheckIsTextEditor()) {
            ((InputMethodManager)this.getContext().getSystemService("input_method")).isActive(this);
        }
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
    public void onMeasure(int v, int v1) {
        Future future0 = this.g;
        if(future0 != null) {
            try {
                this.g = null;
                if(future0.get() != null) {
                    throw new ClassCastException();
                }
                if(Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                a.M(this);
                throw null;
            }
            catch(InterruptedException | ExecutionException unused_ex) {
            }
        }
        super.onMeasure(v, v1);
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
            ((AppCompatTextView)((k)this.getSuperCaller()).a).super.setAutoSizeTextTypeUniformWithConfiguration(v, v1, v2, v3);
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
            ((AppCompatTextView)((k)this.getSuperCaller()).a).super.setAutoSizeTextTypeUniformWithPresetSizes(arr_v, v);
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
            ((AppCompatTextView)((k)this.getSuperCaller()).a).super.setAutoSizeTextTypeWithDefaults(v);
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
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int v, int v1, int v2, int v3) {
        Context context0 = this.getContext();
        Drawable drawable0 = null;
        Drawable drawable1 = v == 0 ? null : w.B(context0, v);
        Drawable drawable2 = v1 == 0 ? null : w.B(context0, v1);
        Drawable drawable3 = v2 == 0 ? null : w.B(context0, v2);
        if(v3 != 0) {
            drawable0 = w.B(context0, v3);
        }
        this.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable1, drawable2, drawable3, drawable0);
        T t0 = this.b;
        if(t0 != null) {
            t0.b();
        }
    }

    @Override  // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable0, drawable1, drawable2, drawable3);
        T t0 = this.b;
        if(t0 != null) {
            t0.b();
        }
    }

    @Override  // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int v, int v1, int v2, int v3) {
        Context context0 = this.getContext();
        Drawable drawable0 = null;
        Drawable drawable1 = v == 0 ? null : w.B(context0, v);
        Drawable drawable2 = v1 == 0 ? null : w.B(context0, v1);
        Drawable drawable3 = v2 == 0 ? null : w.B(context0, v2);
        if(v3 != 0) {
            drawable0 = w.B(context0, v3);
        }
        this.setCompoundDrawablesWithIntrinsicBounds(drawable1, drawable2, drawable3, drawable0);
        T t0 = this.b;
        if(t0 != null) {
            t0.b();
        }
    }

    @Override  // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable0, Drawable drawable1, Drawable drawable2, Drawable drawable3) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable0, drawable1, drawable2, drawable3);
        T t0 = this.b;
        if(t0 != null) {
            t0.b();
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

    @Override  // android.widget.TextView
    public void setFirstBaselineToTopHeight(int v) {
        if(Build.VERSION.SDK_INT >= 28) {
            this.getSuperCaller().e(v);
            return;
        }
        a.V(this, v);
    }

    @Override  // android.widget.TextView
    public void setLastBaselineToBottomHeight(int v) {
        if(Build.VERSION.SDK_INT >= 28) {
            this.getSuperCaller().a(v);
            return;
        }
        a.W(this, v);
    }

    @Override  // android.widget.TextView
    public void setLineHeight(int v) {
        a.X(this, v);
    }

    @Override  // android.widget.TextView
    public final void setLineHeight(int v, float f) {
        if(Build.VERSION.SDK_INT >= 34) {
            this.getSuperCaller().d(v, f);
            return;
        }
        a.X(this, Math.round(TypedValue.applyDimension(v, f, this.getResources().getDisplayMetrics())));
    }

    public void setPrecomputedText(d d0) {
        if(Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        a.M(this);
        throw null;
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
    public void setTextAppearance(Context context0, int v) {
        super.setTextAppearance(context0, v);
        T t0 = this.b;
        if(t0 != null) {
            t0.g(context0, v);
        }
    }

    @Override  // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier0) {
        if(Build.VERSION.SDK_INT < 28) {
            B b0 = this.c;
            if(b0 != null) {
                b0.c = textClassifier0;
                return;
            }
        }
        ((AppCompatTextView)((k)this.getSuperCaller()).a).super.setTextClassifier(textClassifier0);
    }

    public void setTextFuture(Future future0) {
        this.g = future0;
        if(future0 != null) {
            this.requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(c c0) {
        TextDirectionHeuristic textDirectionHeuristic0 = c0.b;
        TextDirectionHeuristic textDirectionHeuristic1 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int v = 1;
        if(textDirectionHeuristic0 != textDirectionHeuristic1) {
            TextDirectionHeuristic textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            if(textDirectionHeuristic0 != textDirectionHeuristic2) {
                if(textDirectionHeuristic0 == TextDirectionHeuristics.ANYRTL_LTR) {
                    v = 2;
                }
                else if(textDirectionHeuristic0 == TextDirectionHeuristics.LTR) {
                    v = 3;
                }
                else if(textDirectionHeuristic0 == TextDirectionHeuristics.RTL) {
                    v = 4;
                }
                else if(textDirectionHeuristic0 == TextDirectionHeuristics.LOCALE) {
                    v = 5;
                }
                else if(textDirectionHeuristic0 == textDirectionHeuristic2) {
                    v = 6;
                }
                else if(textDirectionHeuristic0 == textDirectionHeuristic1) {
                    v = 7;
                }
            }
        }
        this.setTextDirection(v);
        this.getPaint().set(c0.a);
        this.setBreakStrategy(c0.c);
        this.setHyphenationFrequency(c0.d);
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

    @Override  // android.widget.TextView
    public final void setTypeface(Typeface typeface0, int v) {
        Typeface typeface1;
        if(this.e) {
            return;
        }
        if(typeface0 == null || v <= 0) {
            typeface1 = null;
        }
        else {
            if(this.getContext() == null) {
                throw new IllegalArgumentException("Context cannot be null");
            }
            typeface1 = Typeface.create(typeface0, v);
        }
        this.e = true;
        if(typeface1 != null) {
            typeface0 = typeface1;
        }
        try {
            super.setTypeface(typeface0, v);
            this.e = false;
        }
        catch(Throwable throwable0) {
            this.e = false;
            throw throwable0;
        }
    }
}

