package com.iloen.melon.player.playlist.common.scrollbar;

import I.X0;
import K.l;
import androidx.compose.runtime.p;
import ie.H;
import we.n;

public final class a implements n {
    public final int a;
    public final X0 b;
    public final l c;

    public a(X0 x00, l l0) {
        this.a = 0;
        super();
        this.b = x00;
        this.c = l0;
    }

    public a(X0 x00, l l0, int v) {
        this.a = 1;
        super();
        this.b = x00;
        this.c = l0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            ((Integer)object1).getClass();
            AppScrollbarsKt.a(this.b, this.c, ((androidx.compose.runtime.l)object0), 49);
            return H.a;
        }
        int v = (int)(((Integer)object1));
        if(((p)(((androidx.compose.runtime.l)object0))).Q(v & 1, (v & 3) != 2)) {
            AppScrollbarsKt.a(this.b, this.c, ((p)(((androidx.compose.runtime.l)object0))), 0x30);
            return H.a;
        }
        ((p)(((androidx.compose.runtime.l)object0))).T();
        return H.a;
    }
}

