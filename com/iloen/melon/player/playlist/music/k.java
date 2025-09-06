package com.iloen.melon.player.playlist.music;

import kotlin.jvm.internal.q;
import oc.c0;

public final class k implements we.k {
    public final int a;
    public final c0 b;

    public k(c0 c00, int v) {
        this.a = v;
        this.b = c00;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((Success)object0), "prevState");
            return Success.copy$default(((Success)object0), null, false, false, null, null, null, 0, this.b, 0x7F, null);
        }
        q.g(((Success)object0), "prevState");
        return Success.copy$default(((Success)object0), null, false, false, null, null, null, 0, this.b, 0x7F, null);
    }
}

