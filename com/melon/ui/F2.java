package com.melon.ui;

import com.iloen.melon.playback.Playable;
import kotlin.jvm.internal.q;

public final class f2 implements k2 {
    public final String a;
    public final Playable b;

    public f2(Playable playable0, String s) {
        q.g(s, "songIdString");
        q.g(playable0, "playable");
        super();
        this.a = s;
        this.b = playable0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof f2)) {
            return false;
        }
        return q.b(this.a, ((f2)object0).a) ? q.b(this.b, ((f2)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickSongInfo(songIdString=" + this.a + ", playable=" + this.b + ")";
    }
}

