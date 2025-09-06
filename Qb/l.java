package qb;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.add.AddResult;
import kotlin.jvm.internal.q;

public final class l extends u {
    public final AddResult a;
    public final Playable b;

    public l(AddResult addResult0, Playable playable0) {
        q.g(addResult0, "addResult");
        q.g(playable0, "playable");
        super();
        this.a = addResult0;
        this.b = playable0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof l)) {
            return false;
        }
        return q.b(this.a, ((l)object0).a) ? q.b(this.b, ((l)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "HandleAddResult(addResult=" + this.a + ", playable=" + this.b + ")";
    }
}

