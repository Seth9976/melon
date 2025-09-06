package com.iloen.melon.player.playlist.music;

import ie.H;
import we.a;

public final class p implements a {
    public final int a;
    public final a b;

    public p(int v, a a0) {
        this.a = v;
        this.b = a0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                a a1 = this.b;
                if(a1 != null) {
                    a1.invoke();
                }
                return H.a;
            }
            case 1: {
                a a2 = this.b;
                if(a2 != null) {
                    a2.invoke();
                }
                return H.a;
            }
            default: {
                a a0 = this.b;
                if(a0 != null) {
                    a0.invoke();
                }
                return H.a;
            }
        }
    }
}

