package cd;

import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart;
import kotlin.jvm.internal.q;

public final class u implements y {
    public final Chart a;

    public u(Chart mainMusicRes$RESPONSE$MELONCHART$Chart0) {
        this.a = mainMusicRes$RESPONSE$MELONCHART$Chart0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof u ? q.b(this.a, ((u)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnRoundedClick(chartItem=" + this.a + ")";
    }
}

