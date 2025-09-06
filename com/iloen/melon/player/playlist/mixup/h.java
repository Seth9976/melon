package com.iloen.melon.player.playlist.mixup;

import androidx.compose.runtime.b1;
import p0.p;
import we.a;

public final class h implements a {
    public final int a;
    public final Object b;

    public h(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        Object object0 = this.b;
        if(this.a != 0) {
            return Boolean.valueOf(((p)object0).isEmpty());
        }
        Boolean boolean0 = (Boolean)((b1)object0).getValue();
        boolean0.getClass();
        return boolean0;
    }
}

