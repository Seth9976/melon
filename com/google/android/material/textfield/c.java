package com.google.android.material.textfield;

import A6.b;
import Fd.k;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import e1.n;
import e6.a;

public final class c extends l {
    public final int e;
    public final int f;
    public final TimeInterpolator g;
    public final TimeInterpolator h;
    public EditText i;
    public final b j;
    public final k k;
    public AnimatorSet l;
    public ValueAnimator m;

    public c(com.google.android.material.textfield.k k0) {
        super(k0);
        this.j = new b(this, 23);
        this.k = new k(this, 2);
        this.e = n.B(k0.getContext(), 0x7F04045D, 100);  // attr:motionDurationShort3
        this.f = n.B(k0.getContext(), 0x7F04045D, 150);  // attr:motionDurationShort3
        this.g = n.C(k0.getContext(), 0x7F040466, a.a);  // attr:motionEasingLinearInterpolator
        this.h = n.C(k0.getContext(), 0x7F040464, a.d);  // attr:motionEasingEmphasizedInterpolator
    }

    @Override  // com.google.android.material.textfield.l
    public final void a() {
        if(this.b.r != null) {
            return;
        }
        this.t(this.u());
    }

    @Override  // com.google.android.material.textfield.l
    public final int c() {
        return 0x7F1301D1;  // string:clear_text_end_icon_content_description "Clear text"
    }

    @Override  // com.google.android.material.textfield.l
    public final int d() {
        return 0x7F08076B;  // drawable:mtrl_ic_cancel
    }

    @Override  // com.google.android.material.textfield.l
    public final View.OnFocusChangeListener e() {
        return this.k;
    }

    @Override  // com.google.android.material.textfield.l
    public final View.OnClickListener f() {
        return this.j;
    }

    @Override  // com.google.android.material.textfield.l
    public final View.OnFocusChangeListener g() {
        return this.k;
    }

    @Override  // com.google.android.material.textfield.l
    public final void m(EditText editText0) {
        this.i = editText0;
        boolean z = this.u();
        this.a.setEndIconVisible(z);
    }

    @Override  // com.google.android.material.textfield.l
    public final void p(boolean z) {
        if(this.b.r == null) {
            return;
        }
        this.t(z);
    }

    @Override  // com.google.android.material.textfield.l
    public final void r() {
        ValueAnimator valueAnimator0 = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
        valueAnimator0.setInterpolator(this.h);
        valueAnimator0.setDuration(((long)this.f));
        valueAnimator0.addUpdateListener(new com.google.android.material.textfield.a(this, 1));
        ValueAnimator valueAnimator1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        valueAnimator1.setInterpolator(this.g);
        valueAnimator1.setDuration(((long)this.e));
        valueAnimator1.addUpdateListener(new com.google.android.material.textfield.a(this, 0));
        AnimatorSet animatorSet0 = new AnimatorSet();
        this.l = animatorSet0;
        animatorSet0.playTogether(new Animator[]{valueAnimator0, valueAnimator1});
        this.l.addListener(new com.google.android.material.textfield.b(this, 0));
        ValueAnimator valueAnimator2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        valueAnimator2.setInterpolator(this.g);
        valueAnimator2.setDuration(((long)this.e));
        valueAnimator2.addUpdateListener(new com.google.android.material.textfield.a(this, 0));
        this.m = valueAnimator2;
        valueAnimator2.addListener(new com.google.android.material.textfield.b(this, 1));
    }

    @Override  // com.google.android.material.textfield.l
    public final void s() {
        EditText editText0 = this.i;
        if(editText0 != null) {
            editText0.post(new com.facebook.appevents.c(this, 15));
        }
    }

    public final void t(boolean z) {
        boolean z1 = this.b.d() == z;
        if(z && !this.l.isRunning()) {
            this.m.cancel();
            this.l.start();
            if(z1) {
                this.l.end();
            }
        }
        else if(!z) {
            this.l.cancel();
            this.m.start();
            if(z1) {
                this.m.end();
            }
        }
    }

    // 去混淆评级： 低(20)
    public final boolean u() {
        return this.i != null && (this.i.hasFocus() || this.d.hasFocus()) && this.i.getText().length() > 0;
    }
}

