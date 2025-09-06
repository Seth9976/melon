package Ic;

import Ac.p0;
import com.iloen.melon.playback.Playable;
import kotlin.jvm.internal.q;

public final class c0 extends p0 {
    public final Playable a;

    public c0(Playable playable0) {
        this.a = playable0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof c0 ? q.b(this.a, ((c0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "LongClickSongItem(playable=" + this.a + ")";
    }
}

