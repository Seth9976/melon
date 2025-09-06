package com.melon.ui;

import kotlin.jvm.internal.q;

public final class t4 implements I4 {
    public final String a;

    public t4(String s) {
        q.g(s, "message");
        super();
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof t4 ? q.b(this.a, ((t4)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Show(message=" + this.a + ")";
    }
}

