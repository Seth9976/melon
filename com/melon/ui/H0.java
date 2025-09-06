package com.melon.ui;

import com.iloen.melon.net.HttpResponse;
import ie.H;
import we.k;

public final class h0 implements k {
    public final int a;
    public final n0 b;

    public h0(n0 n00, int v) {
        this.a = v;
        this.b = n00;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            this.b.updateTiaraProperty(((HttpResponse)object0));
            return H.a;
        }
        this.b.updateTiaraProperty(((HttpResponse)object0));
        return H.a;
    }
}

