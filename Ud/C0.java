package ud;

import com.iloen.melon.net.v4x.common.ContsTypeCode;
import kotlin.jvm.internal.q;

public final class c0 extends g0 {
    public final String a;
    public final ContsTypeCode b;

    public c0(ContsTypeCode contsTypeCode0, String s) {
        this.a = s;
        this.b = contsTypeCode0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof c0)) {
            return false;
        }
        return q.b(this.a, ((c0)object0).a) ? q.b(this.b, ((c0)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "OpenArtistOrUserInfoPage(creatorId=" + this.a + ", contsTypeCode=" + this.b + ")";
    }
}

