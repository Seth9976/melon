package com.iloen.melon.player.playlist.drawernew.composable;

import ie.H;
import we.a;

public final class f implements a {
    public final int a;
    public final F0.a b;
    public final a c;

    public f(F0.a a0, a a1, int v) {
        this.a = v;
        this.b = a0;
        this.c = a1;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            this.b.a(0);
            this.c.invoke();
            return H.a;
        }
        this.b.a(0);
        this.c.invoke();
        return H.a;
    }
}

