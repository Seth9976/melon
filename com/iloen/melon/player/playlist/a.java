package com.iloen.melon.player.playlist;

import X0.u;
import X0.x;
import ie.H;
import kotlin.jvm.internal.q;
import q8.c;
import we.k;

public final class a implements k {
    public final int a;
    public final Object b;

    public a(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((x)object0), "$this$semantics");
                u.h(((x)object0), ((String)this.b));
                return H.a;
            }
            case 1: {
                q.g(((x)object0), "$this$semantics");
                u.h(((x)object0), ((String)this.b));
                return H.a;
            }
            default: {
                oc.H h0 = (oc.H)this.b;
                q.g(((c)object0), "$this$customProps");
                String s = h0 == null ? "" : h0.getMenuId();
                ((c)object0).a.put("menuid", s);
                return H.a;
            }
        }
    }
}

