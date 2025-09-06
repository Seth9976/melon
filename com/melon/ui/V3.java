package com.melon.ui;

import com.iloen.melon.playback.Playable;
import com.iloen.melon.sns.target.SnsManager.SnsType;
import kotlin.jvm.internal.q;

public final class v3 extends x3 {
    public final Playable a;
    public final SnsManager.SnsType b;

    public v3(Playable playable0, SnsManager.SnsType snsManager$SnsType0) {
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
        if(!(object0 instanceof v3)) {
            return false;
        }
        return q.b(this.a, ((v3)object0).a) ? this.b == ((v3)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ShareSnsAppToApp(playable=" + this.a + ", snsType=" + this.b + ")";
    }
}

