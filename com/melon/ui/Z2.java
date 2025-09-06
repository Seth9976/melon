package com.melon.ui;

import kotlin.jvm.internal.q;

public final class z2 extends L2 {
    public final String a;

    public z2(String s) {
        q.g(s, "contsId");
        super();
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof z2 ? q.b(this.a, ((z2)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ClickMusicWaveDelete(contsId=" + this.a + ")";
    }
}

