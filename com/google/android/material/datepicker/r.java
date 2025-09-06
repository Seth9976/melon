package com.google.android.material.datepicker;

import androidx.fragment.app.I;

public final class r {
    public final int a;
    public final I b;

    public r(I i0, int v) {
        this.a = v;
        this.b = i0;
        super();
    }

    public final void a() {
        if(this.a != 0) {
            for(Object object0: ((t)this.b).a) {
                ((r)object0).a();
            }
            return;
        }
        ((s)this.b).V.setEnabled(false);
    }

    public final void b(Object object0) {
        if(this.a != 0) {
            for(Object object1: ((t)this.b).a) {
                ((r)object1).b(object0);
            }
            return;
        }
        String s = ((s)this.b).m().l(((s)this.b).getContext());
        ((s)this.b).N.setContentDescription(((s)this.b).m().f(((s)this.b).requireContext()));
        ((s)this.b).N.setText(s);
        ((s)this.b).V.setEnabled(((s)this.b).m().X());
    }
}

