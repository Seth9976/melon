package com.melon.ui;

import kotlin.jvm.internal.q;

public final class P1 implements k2 {
    public final String a;

    public P1(String s) {
        q.g(s, "contsId");
        super();
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof P1 ? q.b(this.a, ((P1)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ClickMusicWaveEdit(contsId=" + this.a + ")";
    }
}

