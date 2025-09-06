package com.google.android.material.textfield;

import A6.b;
import E9.w;
import Fd.k;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import androidx.media3.session.a0;
import com.facebook.appevents.c;
import com.google.android.material.search.f;
import d2.d;
import e1.n;
import e6.a;

public final class h extends l {
    public final int e;
    public final int f;
    public final TimeInterpolator g;
    public AutoCompleteTextView h;
    public final b i;
    public final k j;
    public final a0 k;
    public boolean l;
    public boolean m;
    public boolean n;
    public long o;
    public AccessibilityManager p;
    public ValueAnimator q;
    public ValueAnimator r;

    public h(com.google.android.material.textfield.k k0) {
        super(k0);
        this.i = new b(this, 24);
        this.j = new k(this, 3);
        this.k = new a0(this, 24);
        this.o = 0x7FFFFFFFFFFFFFFFL;
        this.f = n.B(k0.getContext(), 0x7F04045D, 67);  // attr:motionDurationShort3
        this.e = n.B(k0.getContext(), 0x7F04045D, 50);  // attr:motionDurationShort3
        this.g = n.C(k0.getContext(), 0x7F040466, a.a);  // attr:motionEasingLinearInterpolator
    }

    @Override  // com.google.android.material.textfield.l
    public final void a() {
        if(this.p.isTouchExplorationEnabled() && w.D(this.h) && !this.d.hasFocus()) {
            this.h.dismissDropDown();
        }
        this.h.post(new c(this, 16));
    }

    @Override  // com.google.android.material.textfield.l
    public final int c() {
        return 0x7F13042A;  // string:exposed_dropdown_menu_content_description "Show dropdown menu"
    }

    @Override  // com.google.android.material.textfield.l
    public final int d() {
        return 0x7F080768;  // drawable:mtrl_dropdown_arrow
    }

    @Override  // com.google.android.material.textfield.l
    public final View.OnFocusChangeListener e() {
        return this.j;
    }

    @Override  // com.google.android.material.textfield.l
    public final View.OnClickListener f() {
        return this.i;
    }

    @Override  // com.google.android.material.textfield.l
    public final a0 h() {
        return this.k;
    }

    @Override  // com.google.android.material.textfield.l
    public final boolean i(int v) {
        return v != 0;
    }

    @Override  // com.google.android.material.textfield.l
    public final boolean j() {
        return this.l;
    }

    @Override  // com.google.android.material.textfield.l
    public final boolean l() {
        return this.n;
    }

    @Override  // com.google.android.material.textfield.l
    public final void m(EditText editText0) {
        if(!(editText0 instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        this.h = (AutoCompleteTextView)editText0;
        ((AutoCompleteTextView)editText0).setOnTouchListener(new f(this, 1));
        this.h.setOnDismissListener(new g(this));
        this.h.setThreshold(0);
        TextInputLayout textInputLayout0 = this.a;
        textInputLayout0.setErrorIconDrawable(null);
        if(!w.D(editText0) && this.p.isTouchExplorationEnabled()) {
            this.d.setImportantForAccessibility(2);
        }
        textInputLayout0.setEndIconVisible(true);
    }

    @Override  // com.google.android.material.textfield.l
    public final void n(d d0) {
        AccessibilityNodeInfo accessibilityNodeInfo0 = d0.a;
        if(!w.D(this.h)) {
            d0.l("android.widget.Spinner");
        }
        if(accessibilityNodeInfo0.isShowingHintText()) {
            accessibilityNodeInfo0.setHintText(null);
        }
    }

    @Override  // com.google.android.material.textfield.l
    public final void o(AccessibilityEvent accessibilityEvent0) {
        boolean z;
        if(this.p.isEnabled() && !w.D(this.h)) {
            switch(accessibilityEvent0.getEventType()) {
                case 8: 
                case 0x8000: {
                    z = this.n && !this.h.isPopupShowing();
                    break;
                }
                default: {
                    z = false;
                }
            }
            if(accessibilityEvent0.getEventType() == 1 || z) {
                this.u();
                this.m = true;
                this.o = System.currentTimeMillis();
            }
        }
    }

    @Override  // com.google.android.material.textfield.l
    public final void r() {
        ValueAnimator valueAnimator0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        valueAnimator0.setInterpolator(this.g);
        valueAnimator0.setDuration(((long)this.f));
        valueAnimator0.addUpdateListener(new com.google.android.exoplayer2.ui.a(this, 4));
        this.r = valueAnimator0;
        ValueAnimator valueAnimator1 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        valueAnimator1.setInterpolator(this.g);
        valueAnimator1.setDuration(((long)this.e));
        valueAnimator1.addUpdateListener(new com.google.android.exoplayer2.ui.a(this, 4));
        this.q = valueAnimator1;
        valueAnimator1.addListener(new A6.h(this, 7));
        this.p = (AccessibilityManager)this.c.getSystemService("accessibility");
    }

    @Override  // com.google.android.material.textfield.l
    public final void s() {
        AutoCompleteTextView autoCompleteTextView0 = this.h;
        if(autoCompleteTextView0 != null) {
            autoCompleteTextView0.setOnTouchListener(null);
            this.h.setOnDismissListener(null);
        }
    }

    public final void t(boolean z) {
        if(this.n != z) {
            this.n = z;
            this.r.cancel();
            this.q.start();
        }
    }

    public final void u() {
        if(this.h == null) {
            return;
        }
        long v = System.currentTimeMillis() - this.o;
        if(Long.compare(v, 0L) < 0 || v > 300L) {
            this.m = false;
        }
        if(!this.m) {
            this.t(!this.n);
            if(this.n) {
                this.h.requestFocus();
                this.h.showDropDown();
                return;
            }
            this.h.dismissDropDown();
            return;
        }
        this.m = false;
    }
}

