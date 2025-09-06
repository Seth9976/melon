package cd;

import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart;
import kotlin.jvm.internal.q;

public final class x implements y {
    public final Chart a;

    public x(Chart mainMusicRes$RESPONSE$MELONCHART$Chart0) {
        this.a = mainMusicRes$RESPONSE$MELONCHART$Chart0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof x ? q.b(this.a, ((x)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnViewAllClick(chartItem=" + this.a + ")";
    }
}

