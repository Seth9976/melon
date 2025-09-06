package com.melon.ui;

import kotlin.jvm.internal.q;
import vb.h;

public final class J3 extends N3 {
    public final h a;

    public J3(h h0) {
        this.a = h0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof J3 ? q.b(this.a, ((J3)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "SharePlaylist(sharableProperties=" + this.a + ")";
    }
}

