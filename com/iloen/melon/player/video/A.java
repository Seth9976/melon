package com.iloen.melon.player.video;

import ie.H;
import we.k;

public final class a implements k {
    public final int a;
    public final LiveViewModel b;

    public a(LiveViewModel liveViewModel0, int v) {
        this.a = v;
        this.b = liveViewModel0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        LiveViewModel liveViewModel0 = this.b;
        switch(this.a) {
            case 0: {
                liveViewModel0.z0.setValue(((Boolean)object0));
                if(!((Boolean)object0).booleanValue()) {
                    liveViewModel0.t0.setValue("");
                }
                return h0;
            }
            case 1: {
                liveViewModel0.d(((long)(((Long)object0))));
                return h0;
            }
            default: {
                liveViewModel0.q0.setValue(String.valueOf(((long)(((Long)object0)))));
                return h0;
            }
        }
    }
}

