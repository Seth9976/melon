package com.melon.ui;

import android.os.Bundle;
import kotlin.jvm.internal.q;

public final class W0 extends Y0 {
    public final Bundle a;

    public W0(Bundle bundle0) {
        this.a = bundle0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof W0 ? q.b(this.a, ((W0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "LoadMore(extra=" + this.a + ")";
    }
}

