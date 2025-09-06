package com.melon.ui;

import com.iloen.melon.playback.Playable;
import kotlin.jvm.internal.q;

public final class d2 implements k2 {
    public final Playable a;

    public d2(Playable playable0) {
        q.g(playable0, "playable");
        super();
        this.a = playable0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof d2 ? q.b(this.a, ((d2)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ClickShareSongInstagram(playable=" + this.a + ")";
    }
}

