package com.iloen.melon.player.playlist.mixup;

import X0.u;
import X0.x;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class c implements k {
    public final int a;
    public final Object b;

    public c(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        Object object1 = this.b;
        if(this.a != 0) {
            q.g(((x)object0), "$this$semantics");
            String s = ((MixUpPlaylistComposeFragment)object1).getString(0x7F130B3C);  // string:talkback_go_to_top "맨 위로 이동"
            q.f(s, "getString(...)");
            u.h(((x)object0), s);
            return h0;
        }
        q.g(((x)object0), "$this$semantics");
        u.h(((x)object0), ((String)object1));
        u.e(((x)object0));
        return h0;
    }
}

