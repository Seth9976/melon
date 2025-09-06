package com.melon.ui;

import com.iloen.melon.playback.Playable;
import kotlin.jvm.internal.q;

public final class n2 extends L2 {
    public final Playable a;

    public n2(Playable playable0) {
        q.g(playable0, "playable");
        super();
        this.a = playable0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof n2 ? q.b(this.a, ((n2)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ClickAlbumInfo(playable=" + this.a + ")";
    }
}

