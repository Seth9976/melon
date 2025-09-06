package com.melon.ui;

import kotlin.jvm.internal.q;
import vb.f;

public final class H3 extends N3 {
    public final f a;

    public H3(f f0) {
        this.a = f0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof H3 ? q.b(this.a, ((H3)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ShareMusicWave(sharableProperties=" + this.a + ")";
    }
}

