package com.melon.ui;

import kotlin.jvm.internal.q;
import vb.h;

public final class b2 implements k2 {
    public final h a;

    public b2(h h0) {
        this.a = h0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof b2 ? q.b(this.a, ((b2)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ClickSharePlaylist(sharableProperties=" + this.a + ")";
    }
}

