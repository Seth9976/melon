package com.google.android.material.textfield;

import android.widget.AutoCompleteTextView.OnDismissListener;

public final class g implements AutoCompleteTextView.OnDismissListener {
    public final h a;

    public g(h h0) {
        this.a = h0;
    }

    @Override  // android.widget.AutoCompleteTextView$OnDismissListener
    public final void onDismiss() {
        this.a.m = true;
        this.a.o = System.currentTimeMillis();
        this.a.t(false);
    }
}

