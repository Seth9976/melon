package com.iloen.melon.popup;

import Cc.N1;
import M.q0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import e1.y;
import ie.H;
import kotlin.jvm.internal.q;
import we.o;

public final class z implements o {
    public final String a;
    public final long b;

    public z(String s, long v) {
        this.a = s;
        this.b = v;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        int v = (int)(((Integer)object2));
        q.g(((q0)object0), "$this$Button");
        if(((p)(((l)object1))).Q(v & 1, (v & 17) != 16)) {
            N1.b(this.a, null, this.b, 20.0f, y.i, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, ((p)(((l)object1))), 0x30C00, 0xC30, 120786);
            return H.a;
        }
        ((p)(((l)object1))).T();
        return H.a;
    }
}

