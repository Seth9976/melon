package cd;

import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAG.CONTENTS;
import kotlin.jvm.internal.q;

public final class p2 implements q2 {
    public final CONTENTS a;
    public final int b;

    public p2(CONTENTS mainMusicRes$RESPONSE$TAG$CONTENTS0, int v) {
        this.a = mainMusicRes$RESPONSE$TAG$CONTENTS0;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof p2)) {
            return false;
        }
        return q.b(this.a, ((p2)object0).a) ? this.b == ((p2)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? this.b : this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "OnTagMoreClick(tagData=" + this.a + ", index=" + this.b + ")";
    }
}

