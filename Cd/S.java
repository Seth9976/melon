package cd;

import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.MoreLanding;
import kotlin.jvm.internal.q;

public final class s implements y {
    public final MoreLanding a;

    public s(MoreLanding mainMusicRes$RESPONSE$MELONCHART$MoreLanding0) {
        this.a = mainMusicRes$RESPONSE$MELONCHART$MoreLanding0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof s ? q.b(this.a, ((s)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnExtraRoundedClick(moreLandingItem=" + this.a + ")";
    }
}

