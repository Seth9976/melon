package com.melon.playback.melon.drm;

import Yb.m;
import kotlin.jvm.internal.q;

public final class d extends f {
    public final m a;

    public d(m m0) {
        this.a = m0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof d ? q.b(this.a, ((d)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Failure(error=" + this.a + ")";
    }
}

