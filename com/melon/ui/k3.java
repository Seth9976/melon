package com.melon.ui;

import kotlin.jvm.internal.q;
import vb.i;

public final class K3 extends N3 {
    public final i a;

    public K3(i i0) {
        this.a = i0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof K3 ? q.b(this.a, ((K3)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ShareProgram(sharableProperties=" + this.a + ")";
    }
}

