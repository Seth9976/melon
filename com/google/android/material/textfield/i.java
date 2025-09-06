package com.google.android.material.textfield;

import android.text.Editable;
import com.google.android.material.internal.A;

public final class i extends A {
    public final k a;

    public i(k k0) {
        this.a = k0;
    }

    @Override  // android.text.TextWatcher
    public final void afterTextChanged(Editable editable0) {
        this.a.b().a();
    }

    @Override  // com.google.android.material.internal.A
    public final void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        this.a.b().b();
    }
}

