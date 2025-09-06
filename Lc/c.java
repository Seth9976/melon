package lc;

import com.iloen.melon.playback.Playable;
import kotlin.jvm.internal.q;

public final class c {
    public final int a;
    public final Playable b;

    public c(int v, Playable playable0) {
        q.g(playable0, "playable");
        super();
        this.a = v;
        this.b = playable0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof c)) {
            return false;
        }
        return this.a == ((c)object0).a ? q.b(this.b, ((c)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a * 0x1F;
    }

    @Override
    public final String toString() {
        return "PlayableAndListPos(listPos=" + this.a + ", playable=" + this.b + ")";
    }
}

