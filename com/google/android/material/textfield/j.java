package com.google.android.material.textfield;

import android.widget.EditText;

public final class j {
    public final k a;

    public j(k k0) {
        this.a = k0;
    }

    public final void a(TextInputLayout textInputLayout0) {
        k k0 = this.a;
        i i0 = k0.I;
        if(k0.D == textInputLayout0.getEditText()) {
            return;
        }
        EditText editText0 = k0.D;
        if(editText0 != null) {
            editText0.removeTextChangedListener(i0);
            if(k0.D.getOnFocusChangeListener() == k0.b().e()) {
                k0.D.setOnFocusChangeListener(null);
            }
        }
        EditText editText1 = textInputLayout0.getEditText();
        k0.D = editText1;
        if(editText1 != null) {
            editText1.addTextChangedListener(i0);
        }
        k0.b().m(k0.D);
        k0.j(k0.b());
    }
}

