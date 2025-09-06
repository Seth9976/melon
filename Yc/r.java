package yc;

import com.melon.net.res.common.SongInfoBase;
import gd.Z3;
import kotlin.jvm.internal.q;

public final class r extends Z3 {
    public final int a;
    public final SongInfoBase b;

    public r(SongInfoBase songInfoBase0, int v) {
        q.g(songInfoBase0, "songInfoBase");
        super();
        this.a = v;
        this.b = songInfoBase0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof r)) {
            return false;
        }
        return this.a == ((r)object0).a ? q.b(this.b, ((r)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickLineGraph(index=" + this.a + ", songInfoBase=" + this.b + ")";
    }
}

