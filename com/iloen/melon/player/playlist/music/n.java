package com.iloen.melon.player.playlist.music;

import java.util.List;
import kotlin.jvm.internal.q;
import we.k;

public final class n implements k {
    public final int a;
    public final Object b;

    public n(List list0, int v) {
        this.a = v;
        this.b = list0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            return Success.copy$default(((Success)object0), null, false, false, null, null, ((List)this.b), 0, null, 0xDF, null);
        }
        q.g(((Success)object0), "prevState");
        return Success.copy$default(((Success)object0), null, false, false, null, null, ((List)this.b), 0, null, 0xDF, null);
    }
}

