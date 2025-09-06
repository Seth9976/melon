package com.melon.ui;

import com.iloen.melon.playback.Playable;
import java.util.Map;
import kotlin.jvm.internal.q;

public final class l2 extends m2 {
    public final Map a;
    public final Playable b;

    public l2(Map map0, Playable playable0) {
        q.g(playable0, "playable");
        super();
        this.a = map0;
        this.b = playable0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof l2)) {
            return false;
        }
        return q.b(this.a, ((l2)object0).a) ? q.b(this.b, ((l2)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ShowArtistMultiPopup(artists=" + this.a + ", playable=" + this.b + ")";
    }
}

