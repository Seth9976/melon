package androidx.appcompat.widget;

import B.a;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode.Callback;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.widget.n;
import c2.W;
import c2.e;
import c2.g;
import c2.w;
import e2.b;

public class AppCompatEditText extends EditText implements w {
    public final v a;
    public final T b;
    public final B c;
    public final n d;
    public final B e;
    public y f;

    public AppCompatEditText(Context context0) {
        this(context0, null);
    }

    public AppCompatEditText(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F04022F);  // attr:editTextStyle
    }

    public AppCompatEditText(Context context0, AttributeSet attributeSet0, int v) {
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
        B b0 = new B();
        b0.b = this;
        this.c = b0;
        this.d = new n();  // 初始化器: Ljava/lang/Object;-><init>()V
        B b1 = new B(this);
        this.e = b1;
        b1.b(attributeSet0, v);
        KeyListener keyListener0 = this.getKeyListener();
        if(!(keyListener0 instanceof NumberKeyListener)) {
            boolean z = super.isFocusable();
            boolean z1 = super.isClickable();
            boolean z2 = super.isLongClickable();
            int v2 = super.getInputType();
            KeyListener keyListener1 = b1.a(keyListener0);
            if(keyListener1 != keyListener0) {
                super.setKeyListener(keyListener1);
                super.setRawInputType(v2);
                super.setFocusable(z);
                super.setClickable(z1);
                super.setLongClickable(z2);
            }
        }
    }

    @Override  // c2.w
    public final g a(g g0) {
        this.d.getClass();
        return n.a(this, g0);
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

    private y getSuperCaller() {
        if(this.f == null) {
            this.f = new y(this);
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

    @Override  // android.widget.EditText
    public Editable getText() {
        return Build.VERSION.SDK_INT < 28 ? super.getEditableText() : super.getText();
    }

    @Override  // android.widget.EditText
    public CharSequence getText() {
        return this.getText();
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
        return this.getSuperCaller().a.super.getTextClassifier();
    }

    @Override  // android.widget.TextView
    public InputConnection onCreateInputConnection(EditorInfo editorInfo0) {
        InputConnection inputConnection0 = super.onCreateInputConnection(editorInfo0);
        this.b.getClass();
        int v = Build.VERSION.SDK_INT;
        if(v < 30 && inputConnection0 != null) {
            e2.a.P(editorInfo0, this.getText());
        }
        a.a.H(inputConnection0, editorInfo0, this);
        if(inputConnection0 != null && v <= 30) {
            String[] arr_s = W.g(this);
            if(arr_s != null) {
                editorInfo0.contentMimeTypes = arr_s;
                inputConnection0 = new b(inputConnection0, new com.iloen.melon.fragments.radio.a(this, 5));
            }
        }
        return this.e.c(inputConnection0, editorInfo0);
    }

    @Override  // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(Build.VERSION.SDK_INT >= 30 && Build.VERSION.SDK_INT < 33) {
            ((InputMethodManager)this.getContext().getSystemService("input_method")).isActive(this);
        }
    }

    @Override  // android.widget.TextView
    public final boolean onDragEvent(DragEvent dragEvent0) {
        Activity activity0;
        boolean z = false;
        if(Build.VERSION.SDK_INT < 0x1F && dragEvent0.getLocalState() == null && W.g(this) != null) {
            for(Context context0 = this.getContext(); true; context0 = ((ContextWrapper)context0).getBaseContext()) {
                activity0 = null;
                if(!(context0 instanceof ContextWrapper)) {
                    break;
                }
                if(context0 instanceof Activity) {
                    activity0 = (Activity)context0;
                    break;
                }
            }
            if(activity0 == null) {
                Log.i("ReceiveContent", "Can\'t handle drop: no activity: view=" + this);
                return super.onDragEvent(dragEvent0);
            }
            if(dragEvent0.getAction() != 1 && dragEvent0.getAction() == 3) {
                z = C.a(dragEvent0, this, activity0);
            }
        }
        return z ? true : super.onDragEvent(dragEvent0);
    }

    @Override  // android.widget.EditText
    public final boolean onTextContextMenuItem(int v) {
        androidx.lifecycle.b b0;
        int v1 = Build.VERSION.SDK_INT;
        if(v1 < 0x1F && W.g(this) != null && (v == 0x1020022 || v == 0x1020031)) {
            ClipboardManager clipboardManager0 = (ClipboardManager)this.getContext().getSystemService("clipboard");
            ClipData clipData0 = clipboardManager0 == null ? null : clipboardManager0.getPrimaryClip();
            if(clipData0 != null && clipData0.getItemCount() > 0) {
                if(v1 >= 0x1F) {
                    b0 = new androidx.lifecycle.b(clipData0, 1);
                }
                else {
                    b0 = new e();
                    b0.b = clipData0;
                    b0.c = 1;
                }
                b0.setFlags((v == 0x1020022 ? 0 : 1));
                W.k(this, b0.build());
            }
            return true;
        }
        return super.onTextContextMenuItem(v);
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

    public void setEmojiCompatEnabled(boolean z) {
        this.e.d(z);
    }

    @Override  // android.widget.TextView
    public void setKeyListener(KeyListener keyListener0) {
        super.setKeyListener(this.e.a(keyListener0));
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
    public void setTextClassifier(TextClassifier textClassifier0) {
        if(Build.VERSION.SDK_INT < 28) {
            B b0 = this.c;
            if(b0 != null) {
                b0.c = textClassifier0;
                return;
            }
        }
        this.getSuperCaller().a.super.setTextClassifier(textClassifier0);
    }
}

