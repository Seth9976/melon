package com.iloen.melon.popup;

import ie.H;
import we.n;
import we.o;

public final class q implements n {
    public final int a;
    public final o b;

    public q(o o0, int v) {
        this.a = v;
        this.b = o0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Integer)object0).intValue();
        ((Integer)object1).intValue();
        if(this.a != 0) {
            o o0 = this.b;
            if(o0 != null) {
                o0.invoke(((Integer)object0), ((Integer)object1), -1);
            }
            return H.a;
        }
        o o1 = this.b;
        if(o1 != null) {
            o1.invoke(((Integer)object0), ((Integer)object1), -1);
        }
        return H.a;
    }
}

