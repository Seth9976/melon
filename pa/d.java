package Pa;

import java.util.List;
import kotlin.jvm.internal.q;

public final class d extends h {
    public final String a;
    public final List b;

    public d(String s, List list0) {
        q.g(s, "playlistId");
        q.g(list0, "selectedList");
        super();
        this.a = s;
        this.b = list0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof d)) {
            return false;
        }
        return q.b(this.a, ((d)object0).a) ? q.b(this.b, ((d)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "AddToPlaylist(playlistId=" + this.a + ", selectedList=" + this.b + ")";
    }
}

