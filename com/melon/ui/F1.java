package com.melon.ui;

import android.os.Bundle;
import kotlin.jvm.internal.q;

public final class f1 extends g1 {
    public final Bundle a;

    public f1(Bundle bundle0) {
        this.a = bundle0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof f1 ? q.b(this.a, ((f1)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "LoadPage(extra=" + this.a + ")";
    }
}

