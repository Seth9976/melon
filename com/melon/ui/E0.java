package com.melon.ui;

import kotlin.jvm.internal.q;
import p8.s;

public final class e0 implements I4 {
    public final s a;

    public e0(s s0) {
        q.g(s0, "tiaraProperty");
        super();
        this.a = s0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof e0 ? q.b(this.a, ((e0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "TiaraPropertyUpdated(tiaraProperty=" + this.a + ")";
    }
}

