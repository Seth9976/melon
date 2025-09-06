package cd;

import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAG.CONTENTS;
import kotlin.jvm.internal.q;

public final class o2 implements q2 {
    public final CONTENTS a;
    public final int b;

    public o2(CONTENTS mainMusicRes$RESPONSE$TAG$CONTENTS0, int v) {
        this.a = mainMusicRes$RESPONSE$TAG$CONTENTS0;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof o2)) {
            return false;
        }
        return q.b(this.a, ((o2)object0).a) ? this.b == ((o2)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? this.b : this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "OnTagClick(tagData=" + this.a + ", position=" + this.b + ")";
    }
}

