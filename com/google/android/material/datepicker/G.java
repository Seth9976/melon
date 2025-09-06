package com.google.android.material.datepicker;

import E9.h;
import ea.c;
import i.n.i.b.a.s.e.S3;

public final class g implements Runnable {
    public final int a;
    public final long b;
    public final Object c;

    public g(Object object0, long v, int v1) {
        this.a = v1;
        this.c = object0;
        this.b = v;
        super();
    }

    @Override
    public final void run() {
        long v = this.b;
        Object object0 = this.c;
        if(this.a != 0) {
            ((S3)((c)object0).c).b(v);
            return;
        }
        Object[] arr_object = {h.B(v).replace(' ', ' ')};
        ((com.google.android.material.datepicker.h)object0).a.setError(String.format(((com.google.android.material.datepicker.h)object0).e, arr_object));
        ((com.google.android.material.datepicker.h)object0).a();
    }
}

