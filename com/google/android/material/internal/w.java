package com.google.android.material.internal;

import android.graphics.Typeface;
import com.google.android.material.chip.Chip;
import e1.u;
import l6.d;

public final class w extends u {
    public final int e;
    public final Object f;

    public w(Object object0, int v) {
        this.e = v;
        this.f = object0;
        super();
    }

    @Override  // e1.u
    public final void K(int v) {
        if(this.e != 0) {
            return;
        }
        ((y)this.f).e = true;
        x x0 = (x)((y)this.f).f.get();
        if(x0 != null) {
            x0.a();
        }
    }

    @Override  // e1.u
    public final void L(Typeface typeface0, boolean z) {
        if(this.e != 0) {
            d d0 = ((Chip)this.f).e;
            CharSequence charSequence0 = d0.Z0 ? d0.b0 : ((Chip)this.f).getText();
            ((Chip)this.f).setText(charSequence0);
            ((Chip)this.f).requestLayout();
            ((Chip)this.f).invalidate();
            return;
        }
        if(!z) {
            ((y)this.f).e = true;
            x x0 = (x)((y)this.f).f.get();
            if(x0 != null) {
                x0.a();
            }
        }
    }

    private final void Y(int v) {
    }
}

