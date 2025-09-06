package com.iloen.melon.player.playlist.drawernew;

import ie.H;
import we.a;

public final class n implements a {
    public final int a;
    public final a b;

    public n(int v, a a0) {
        this.a = v;
        this.b = a0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            this.b.invoke();
            return H.a;
        }
        this.b.invoke();
        return H.a;
    }
}

