package com.melon.ui;

import com.iloen.melon.playback.Playable;
import kotlin.jvm.internal.q;

public final class g2 implements k2 {
    public final Playable a;

    public g2(Playable playable0) {
        this.a = playable0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof g2 ? q.b(this.a, ((g2)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ClickSoundType(playable=" + this.a + ")";
    }
}

