package jd;

import com.melon.net.res.common.SongInfoBase;
import gd.Z3;
import kotlin.jvm.internal.q;

public final class c3 extends Z3 {
    public final int a;
    public final SongInfoBase b;

    public c3(SongInfoBase songInfoBase0, int v) {
        q.g(songInfoBase0, "songInfo");
        super();
        this.a = v;
        this.b = songInfoBase0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof c3)) {
            return false;
        }
        return this.a == ((c3)object0).a ? q.b(this.b, ((c3)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickPlayButton(index=" + this.a + ", songInfo=" + this.b + ")";
    }
}

