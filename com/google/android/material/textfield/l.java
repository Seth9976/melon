package com.google.android.material.textfield;

import android.content.Context;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import androidx.media3.session.a0;
import com.google.android.material.internal.CheckableImageButton;
import d2.d;

public abstract class l {
    public final TextInputLayout a;
    public final k b;
    public final Context c;
    public final CheckableImageButton d;

    public l(k k0) {
        this.a = k0.a;
        this.b = k0;
        this.c = k0.getContext();
        this.d = k0.g;
    }

    public void a() {
    }

    public void b() {
    }

    public int c() {
        return 0;
    }

    public int d() {
        return 0;
    }

    public View.OnFocusChangeListener e() {
        return null;
    }

    public View.OnClickListener f() {
        return null;
    }

    public View.OnFocusChangeListener g() {
        return null;
    }

    public a0 h() {
        return null;
    }

    public boolean i(int v) {
        return true;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return this instanceof h;
    }

    public boolean l() {
        return false;
    }

    public void m(EditText editText0) {
    }

    public void n(d d0) {
    }

    public void o(AccessibilityEvent accessibilityEvent0) {
    }

    public void p(boolean z) {
    }

    public final void q() {
        this.b.f(false);
    }

    public void r() {
    }

    public void s() {
    }
}

