package com.google.android.material.datepicker;

import android.view.View.OnClickListener;
import android.view.View;
import java.util.Iterator;

public final class q implements View.OnClickListener {
    public final int a;
    public final s b;

    public q(s s0, int v) {
        this.a = v;
        this.b = s0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            s s0 = this.b;
            for(Object object0: s0.b) {
                ((View.OnClickListener)object0).onClick(view0);
            }
            s0.dismiss();
            return;
        }
        s s1 = this.b;
        Iterator iterator1 = s1.a.iterator();
        if(!iterator1.hasNext()) {
            s1.dismiss();
            return;
        }
        Object object1 = iterator1.next();
        if(object1 != null) {
            throw new ClassCastException();
        }
        s1.m().getClass();
        throw null;
    }
}

