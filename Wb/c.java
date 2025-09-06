package wb;

import com.iloen.melon.playback.Playable;
import kotlin.jvm.internal.q;

public final class c extends f {
    public final Playable a;

    public c(Playable playable0) {
        q.g(playable0, "playable");
        super();
        this.a = playable0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof c ? q.b(this.a, ((c)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "GetSongInfoBase(playable=" + this.a + ")";
    }
}

