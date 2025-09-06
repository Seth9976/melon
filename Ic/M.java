package Ic;

import Ad.C;
import com.iloen.melon.net.v4x.response.AlbumSuggestedContentsRes.RESPONSE;
import kotlin.jvm.internal.q;

public final class m extends C {
    public final RESPONSE a;

    public m(RESPONSE albumSuggestedContentsRes$RESPONSE0) {
        this.a = albumSuggestedContentsRes$RESPONSE0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof m ? q.b(this.a, ((m)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ShowAlbumRcmdCntsPopup(response=" + this.a + ")";
    }
}

