package com.melon.ui;

import com.iloen.melon.playback.Playable;
import kotlin.jvm.internal.q;

public final class x1 implements k2 {
    public final Playable a;
    public final String b;

    public x1(Playable playable0, String s, int v) {
        if((v & 1) != 0) {
            playable0 = null;
        }
        if((v & 2) != 0) {
            s = null;
        }
        super();
        this.a = playable0;
        this.b = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof x1)) {
            return false;
        }
        return q.b(this.a, ((x1)object0).a) ? q.b(this.b, ((x1)object0).b) : false;
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

