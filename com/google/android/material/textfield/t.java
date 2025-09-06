package com.google.android.material.textfield;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public final class t implements TextWatcher {
    public int a;
    public final EditText b;
    public final TextInputLayout c;

    public t(TextInputLayout textInputLayout0, EditText editText0) {
        this.c = textInputLayout0;
        this.b = editText0;
        this.a = editText0.getLineCount();
    }

    @Override  // android.text.TextWatcher
    public final void afterTextChanged(Editable editable0) {
        TextInputLayout textInputLayout0 = this.c;
        textInputLayout0.u(!textInputLayout0.W0, false);
        if(textInputLayout0.k) {
            textInputLayout0.n(editable0);
        }
        if(textInputLayout0.D) {
            textInputLayout0.v(editable0);
        }
        EditText editText0 = this.b;
        int v = editText0.getLineCount();
        int v1 = this.a;
        if(v != v1) {
            if(v < v1) {
                int v2 = editText0.getMinimumHeight();
                int v3 = textInputLayout0.P0;
                if(v2 != v3) {
                    editText0.setMinimumHeight(v3);
                }
            }
            this.a = v;
        }
    }

    @Override  // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }

    @Override  // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }
}

