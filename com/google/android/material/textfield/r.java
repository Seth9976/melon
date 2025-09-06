package com.google.android.material.textfield;

import A6.b;
import android.text.method.PasswordTransformationMethod;
import android.view.View.OnClickListener;
import android.widget.EditText;

public final class r extends l {
    public final int e;
    public EditText f;
    public final b g;

    public r(k k0, int v) {
        super(k0);
        this.e = 0x7F08032E;  // drawable:design_password_eye
        this.g = new b(this, 25);
        if(v != 0) {
            this.e = v;
        }
    }

    @Override  // com.google.android.material.textfield.l
    public final void b() {
        this.q();
    }

    @Override  // com.google.android.material.textfield.l
    public final int c() {
        return 0x7F1307D9;  // string:password_toggle_content_description "Show password"
    }

    @Override  // com.google.android.material.textfield.l
    public final int d() {
        return this.e;
    }

    @Override  // com.google.android.material.textfield.l
    public final View.OnClickListener f() {
        return this.g;
    }

    @Override  // com.google.android.material.textfield.l
    public final boolean k() {
        return true;
    }

    @Override  // com.google.android.material.textfield.l
    public final boolean l() {
        return this.f == null || !(this.f.getTransformationMethod() instanceof PasswordTransformationMethod) ? 1 : 0;
    }

    @Override  // com.google.android.material.textfield.l
    public final void m(EditText editText0) {
        this.f = editText0;
        this.q();
    }

    @Override  // com.google.android.material.textfield.l
    public final void r() {
        EditText editText0 = this.f;
        if(editText0 != null) {
            switch(editText0.getInputType()) {
                case 16: 
                case 0x80: 
                case 0x90: 
                case 0xE0: {
                    this.f.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    break;
                }
            }
        }
    }

    @Override  // com.google.android.material.textfield.l
    public final void s() {
        EditText editText0 = this.f;
        if(editText0 != null) {
            editText0.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}

