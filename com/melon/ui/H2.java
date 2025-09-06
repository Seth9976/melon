package com.melon.ui;

import kotlin.jvm.internal.q;

public final class h2 implements k2 {
    public final String a;

    public h2(String s) {
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof h2 ? q.b(this.a, ((h2)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ClickStreamingCard(songId=" + this.a + ")";
    }
}

