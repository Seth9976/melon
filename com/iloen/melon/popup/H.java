package com.iloen.melon.popup;

import androidx.compose.runtime.b0;
import ie.H;
import we.k;
import we.n;

public final class h implements k {
    public final int a;
    public final n b;
    public final b0 c;

    public h(n n0, b0 b00, int v) {
        this.a = v;
        this.b = n0;
        this.c = b00;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        ((Integer)object0).getClass();
        if(this.a != 0) {
            n n0 = this.b;
            if(n0 != null) {
                n0.invoke(((Number)this.c.getValue()).intValue(), ((Integer)object0));
            }
            return H.a;
        }
        n n1 = this.b;
        if(n1 != null) {
            n1.invoke(((Number)this.c.getValue()).intValue(), ((Integer)object0));
        }
        return H.a;
    }
}

