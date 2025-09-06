package com.iloen.melon.player.video;

import Cb.i;
import ie.H;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.q;
import q8.c;
import we.k;

public final class d0 implements k {
    public final int a;
    public final boolean b;
    public final boolean c;

    public d0(boolean z, boolean z1, int v) {
        this.a = v;
        this.b = z;
        this.c = z1;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        String s;
        H h0 = H.a;
        boolean z = this.c;
        boolean z1 = this.b;
        if(this.a != 0) {
            ((StringBuilder)object0).append("setScreenOnByPlayback()");
            i.a(((StringBuilder)object0), "isPlaying: " + z1);
            i.a(((StringBuilder)object0), "keepScreenOnDuringPlayback: " + z);
            return h0;
        }
        q.g(((c)object0), "$this$customProps");
        LinkedHashMap linkedHashMap0 = ((c)object0).a;
        if(z1) {
            s = "1000002977";
        }
        else {
            s = z ? "1000002967" : "1000002968";
        }
        linkedHashMap0.put("menuid", s);
        linkedHashMap0.put("Player Type", "5");
        return h0;
    }
}

