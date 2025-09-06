package jd;

import com.melon.net.res.common.SongInfoBase;
import gd.Z3;
import kotlin.jvm.internal.q;

public final class d3 extends Z3 {
    public final SongInfoBase a;

    public d3(SongInfoBase songInfoBase0) {
        q.g(songInfoBase0, "songInfo");
        super();
        this.a = songInfoBase0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof d3 ? q.b(this.a, ((d3)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ClickSongItem(songInfo=" + this.a + ")";
    }
}

