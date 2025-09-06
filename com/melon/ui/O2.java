package com.melon.ui;

import com.iloen.melon.playback.Playable;
import kotlin.jvm.internal.q;

public final class o2 extends L2 {
    public final Playable a;
    public final String b;

    public o2(Playable playable0, String s) {
        this.a = playable0;
        this.b = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof o2)) {
            return false;
        }
        return q.b(this.a, ((o2)object0).a) ? q.b(this.b, ((o2)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        String s = this.b;
        if(s != null) {
            v = s.hashCode();
        }
        return v1 * 0x1F + v;
    }

    @Override
    public final String toString() {
        return "ClickArtistInfo(playable=" + this.a + ", artistId=" + this.b + ")";
    }
}

