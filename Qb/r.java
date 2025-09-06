package qb;

import com.iloen.melon.playback.Playable;
import java.util.Map;
import kotlin.jvm.internal.q;

public final class r extends u {
    public final Map a;
    public final Playable b;

    public r(Map map0, Playable playable0) {
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
        if(!(object0 instanceof r)) {
            return false;
        }
        return q.b(this.a, ((r)object0).a) ? q.b(this.b, ((r)object0).b) : false;
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

