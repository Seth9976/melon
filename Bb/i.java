package bb;

import com.iloen.melon.net.v4x.response.AlbumSuggestedContentsRes.RESPONSE;
import kotlin.jvm.internal.q;

public final class i extends o {
    public final RESPONSE a;

    public i(RESPONSE albumSuggestedContentsRes$RESPONSE0) {
        this.a = albumSuggestedContentsRes$RESPONSE0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof i ? q.b(this.a, ((i)object0).a) : false;
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

