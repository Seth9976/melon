package vb;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.sns.target.SnsManager.SnsType;
import kotlin.jvm.internal.q;

public final class r extends s {
    public final Playable a;
    public final SnsManager.SnsType b;

    public r(Playable playable0, SnsManager.SnsType snsManager$SnsType0) {
        q.g(playable0, "playable");
        q.g(snsManager$SnsType0, "snsType");
        super();
        this.a = playable0;
        this.b = snsManager$SnsType0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof r)) {
            return false;
        }
        return q.b(this.a, ((r)object0).a) ? this.b == ((r)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ShowShareSnsAppToApp(playable=" + this.a + ", snsType=" + this.b + ")";
    }
}

