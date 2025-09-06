package com.melon.ui;

import kotlin.jvm.internal.q;
import vb.t;

public final class c2 implements k2 {
    public final t a;

    public c2(t t0) {
        this.a = t0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof c2 ? q.b(this.a, ((c2)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ClickShareSong(sharableProperties=" + this.a + ")";
    }
}

