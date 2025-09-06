package com.melon.ui;

import com.iloen.melon.playback.Playable;
import kotlin.jvm.internal.q;

public final class U1 implements k2 {
    public final Playable a;
    public final String b;

    public U1(Playable playable0, String s) {
        q.g(playable0, "playable");
        q.g(s, "menuId");
        super();
        this.a = playable0;
        this.b = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof U1)) {
            return false;
        }
        return q.b(this.a, ((U1)object0).a) ? q.b(this.b, ((U1)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickPut(playable=" + this.a + ", menuId=" + this.b + ")";
    }
}

